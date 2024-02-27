package com.example.template.common.persistence.repository.Impl;

import com.example.template.common.entity.SinhVien;
import com.example.template.common.persistence.repository.Interface.IStudentRepository;
import com.example.template.moudle.employee.model.StudentDTO;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import org.thymeleaf.util.StringUtils;

@Log4j2
@Repository
public class IStudentRepositoryImpl implements IStudentRepository {

  @Autowired private JdbcTemplate jdbcTemplate;

  @Autowired private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public List<StudentDTO> findAll() {

    log.info("-------START------- findAll");
    List<StudentDTO> result = this.findAll(Sort.DEFAULT_DIRECTION);
    log.info("-------END------- findAll");

    return result;
  }

  @Override
  public List<StudentDTO> findAll(Sort.Direction direction) {
    try {
      log.info("-------START------- findAll");
      StringBuilder sql =
          new StringBuilder()
              .append("SELECT ID, NAME, BIRTHDAY, GENDER, KHOAID ")
              .append(" FROM SINHVIEN ")
              .append(" ORDER BY ID ASC");
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      parameters.addValue("ASC", "DESC");

      log.info(sql.toString());
      List<StudentDTO> result =
          namedParameterJdbcTemplate.query(
              sql.toString(), parameters, BeanPropertyRowMapper.newInstance(StudentDTO.class));
      log.info("-------END------- findAll");

      return result;
    } catch (Exception e) {
      e.printStackTrace();
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DB not found", e);
    }
  }

  @Override
  public SinhVien findStudentByID(long id) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT ID, NAME, BIRTHDAY, GENDER, KHOAID ");
    sql.append(" FROM SINHVIEN ");
    sql.append(" WHERE ID = :ids ");

    MapSqlParameterSource parameters = new MapSqlParameterSource().addValue("ids", id);

    List<SinhVien> student =
        namedParameterJdbcTemplate.query(
            sql.toString(), parameters, BeanPropertyRowMapper.newInstance(SinhVien.class));

    if (student == null || student.isEmpty()) {
      return new SinhVien();
    }

    return student.get(0);
  }

  @Override
  public List<StudentDTO> findStudentByKhoaID(long khoaid) {
    try {
      log.info("-------START------- findAll");
      StringBuilder sql = new StringBuilder();
      sql.append("SELECT ID, NAME, BIRTHDAY, GENDER, KHOAID ");
      sql.append(" FROM SINHVIEN ");
      sql.append(" WHERE KHOAID = :ids ");

      MapSqlParameterSource parameters = new MapSqlParameterSource().addValue("ids", khoaid);

      log.info(sql.toString());
      List<StudentDTO> result =
          namedParameterJdbcTemplate.query(
              sql.toString(), parameters, BeanPropertyRowMapper.newInstance(StudentDTO.class));
      log.info("-------END------- findAll");

      return result;
    } catch (Exception e) {
      e.printStackTrace();
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DB not found", e);
    }
  }

  @Override
  public List<StudentDTO> searchSinhVienBySinhVien(StudentDTO studentDTO) {
    try {
      log.info("-------START------- findAll");
      MapSqlParameterSource parameters = new MapSqlParameterSource();
      StringBuilder sql = new StringBuilder();
      sql.append("SELECT ID, NAME, BIRTHDAY, GENDER, KHOAID ");
      sql.append(" FROM SINHVIEN ");
      sql.append(" WHERE ID = :ids ");
      parameters.addValue("ids", studentDTO.getId());
      if (!StringUtils.isEmpty(studentDTO.getName())) {
        sql.append(" AND NAME = :names ");
        parameters.addValue("names", studentDTO.getName());
      } else if (studentDTO.getBirthday() != null) {
        sql.append(" AND BIRTHDAY = :birthdays ");
        parameters.addValue("birthdays", studentDTO.getBirthday());
      } else if (studentDTO.getGender() != null) {
        sql.append(" AND GENDER = :genders ");
        parameters.addValue("genders", studentDTO.getGender());
      } else if (studentDTO.getKhoaId() != 0) {
        sql.append(" AND KHOAID = :khoaids ");
        parameters.addValue("khoaids", studentDTO.getKhoaId());
      }

      log.info(sql.toString());
      List<StudentDTO> result =
          namedParameterJdbcTemplate.query(
              sql.toString(), parameters, BeanPropertyRowMapper.newInstance(StudentDTO.class));
      log.info("-------END------- findAll");

      return result;
    } catch (Exception e) {
      e.printStackTrace();
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DB not found", e);
    }
  }
}
