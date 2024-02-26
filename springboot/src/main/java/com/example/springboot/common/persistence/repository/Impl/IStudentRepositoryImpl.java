package com.example.springboot.common.persistence.repository.Impl;

import com.example.springboot.common.entity.Student;
import com.example.springboot.common.persistence.repository.Interface.IStudentRepository;
import com.example.springboot.moudle.employee.model.StudentDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collections;
import java.util.List;

@Log4j2
@Repository
public class IStudentRepositoryImpl implements IStudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Student findStudentByID(long id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ID, NAME, BIRTHDAY, GENDER, KHOAID ");
        sql.append(" FROM SINHVIEN ");
        sql.append(" WHERE ID = :ids ");

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("ids", id);

        List<Student> student = namedParameterJdbcTemplate.query(sql.toString(), parameters, BeanPropertyRowMapper.newInstance(Student.class));

        if (student == null || student.isEmpty()) {
            return new Student();
        }

        return student.get(0);
    }

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
            StringBuilder sql = new StringBuilder()
                    .append("SELECT ID, NAME, BIRTHDAY, GENDER, KHOAID ")
                    .append(" FROM SINHVIEN ")
                    .append(" ORDER BY ID ASC");
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("ASC", "DESC");

            log.info(sql.toString());
            List<StudentDTO> result = namedParameterJdbcTemplate.query(
                    sql.toString(),
                    parameters,
                    BeanPropertyRowMapper.newInstance(StudentDTO.class));
            log.info("-------END------- findAll");

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DB not found", e);
        }
    }
}
