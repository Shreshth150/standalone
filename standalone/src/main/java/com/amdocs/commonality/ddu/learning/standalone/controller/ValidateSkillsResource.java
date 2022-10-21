package com.amdocs.commonality.ddu.learning.standalone.controller;


import com.amdocs.commonality.ddu.learning.standalone.model.EmployeeMissingSkillset;
import com.amdocs.commonality.ddu.learning.standalone.model.EmployeeSkillset;
import com.amdocs.commonality.ddu.learning.standalone.service.ValidateSkillsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateSkillsResource {

    private final ValidateSkillsService skillsService;

    public ValidateSkillsResource(ValidateSkillsService skillsService) {
        this.skillsService = skillsService;
    }

    @PostMapping("/employeemanagement/v1/validateEmployeeSkills")
    public ResponseEntity validateSkills(@RequestBody EmployeeSkillset employeeSkillset){
        EmployeeMissingSkillset employeeMissingSkillset = skillsService
                .validateSkills(employeeSkillset);
        return new ResponseEntity(employeeMissingSkillset , HttpStatus.CREATED);
    }
}
