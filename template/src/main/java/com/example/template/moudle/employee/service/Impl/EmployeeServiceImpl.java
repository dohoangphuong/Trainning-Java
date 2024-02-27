package com.example.template.moudle.employee.service.Impl;

import com.example.template.common.Validate.Validate;
import com.example.template.common.entity.SinhVien;
import com.example.template.common.persistence.common.KhoaRepository;
import com.example.template.common.persistence.common.StudentRepository;
import com.example.template.common.persistence.repository.Interface.IStudentRepository;
import com.example.template.moudle.employee.model.EmployeeDTO;
import com.example.template.moudle.employee.model.StudentDTO;
import com.example.template.moudle.employee.model.StudentRequest;
import com.example.template.moudle.employee.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class EmployeeServiceImpl extends EmployeeService {

  @Autowired private StudentRepository studentRepository;
  @Autowired private KhoaRepository khoaRepository;

  @Autowired private IStudentRepository iStudentRepository;

  public List<EmployeeDTO> getAll() {
    List<EmployeeDTO> listEmployee = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      EmployeeDTO employeeDTO = new EmployeeDTO();
      employeeDTO.setId(i);
      employeeDTO.setName("Nguyen Van " + i);
      listEmployee.add(employeeDTO);
    }

    return listEmployee;
  }

  public StudentDTO searchSinhVien(long id) {

    log.info("-------START------- searchSinhVien");
    List<SinhVien> studentList = studentRepository.findByID(id);
    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setId(studentList.get(0).ID);
    studentDTO.setName(studentList.get(0).NAME);
    studentDTO.setBirthday(studentList.get(0).BIRTHDAY);
    studentDTO.setGender(studentList.get(0).GENDER);
    studentDTO.setKhoaId(studentList.get(0).KHOA.ID);
    log.info("-------END------- searchSinhVien");

    return studentDTO;
  }

  public List<StudentDTO> searchSinhVienByKhoaId(long id) {

    log.info("-------START------- searchSinhVien");

    List<StudentDTO> studentList = iStudentRepository.findStudentByKhoaID(id);
    return studentList;
  }

  public List<StudentDTO> findSinhVien() {

    log.info("-------START------- findSinhVien");
    List<StudentDTO> resultList = iStudentRepository.findAll(Sort.Direction.DESC);
    System.out.println(resultList.size());
    if (Validate.isNotEmptyAndNull(resultList)) {
      for (StudentDTO student : resultList) {
        log.info("ID " + student.getId());
      }
    }
    log.info("-------END------- findSinhVien");

    return resultList;
  }

  public List<StudentDTO> searchSinhVienBySinhVien(StudentRequest student) {

    log.info("-------START------- findSinhVien");
    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setId(student.getId());
    studentDTO.setName(student.getName());

    log.info("-----------------------ResultList is: -------------" + student.getBirthday());
    studentDTO.setBirthday(student.getBirthday());
    studentDTO.setGender(student.getGender());
    studentDTO.setKhoaId(student.getKhoaId());
    log.info("-------DEBUG------- studentDTO id: ", student.getId());

    List<StudentDTO> resultList = iStudentRepository.searchSinhVienBySinhVien(studentDTO);
    System.out.println(resultList.size());
    if (Validate.isNotEmptyAndNull(resultList)) {
      for (StudentDTO result : resultList) {
        log.info("ID " + result.getId());
      }
    } else {
      log.info("-----------------------ResultList is null-------------");
    }
    log.info("-------END------- findSinhVien");
    return resultList;
  }
}
