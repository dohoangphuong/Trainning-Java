package com.example.springboot.moudle.employee.service.Impl;

import com.example.springboot.common.entity.Student;
import com.example.springboot.common.persistence.common.StudentRepository;
import com.example.springboot.common.persistence.repository.Interface.IStudentRepository;
import com.example.springboot.moudle.employee.model.EmployeeDTO;
import com.example.springboot.moudle.employee.model.StudentDTO;
import com.example.springboot.moudle.employee.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class EmployeeServiceImpl extends EmployeeService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private IStudentRepository iStudentRepository;

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
        List<Student> studentList = studentRepository.findByID(id);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentList.get(0).ID);
        studentDTO.setName(studentList.get(0).NAME);
        studentDTO.setBirthday(studentList.get(0).BIRTHDAY);
        studentDTO.setGender(studentList.get(0).GENDER);
        studentDTO.setKhoaId(studentList.get(0).KHOA.ID);
        log.info("-------END------- searchSinhVien");

        return studentDTO;
    }

    public List<StudentDTO> findSinhVien() {

        log.info("-------START------- findSinhVien");
        List<StudentDTO> resultList = iStudentRepository.findAll(Sort.Direction.DESC);
        System.out.println(resultList.size());
        if (isNotEmptyAndNull(resultList)) {
            for (StudentDTO student : resultList) {
                log.info("ID " + student.getId());
            }
        }
        log.info("-------END------- findSinhVien");

        return resultList;
    }

    public boolean isEmptyAndNull(List<?> objectList) {
        if (objectList == null || objectList.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNotEmptyAndNull(List<?> objectList) {
        return !isEmptyAndNull(objectList);
    }
}
