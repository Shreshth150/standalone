package com.amdocs.commonality.ddu.learning.standalone.service;

import com.amdocs.commonality.ddu.learning.standalone.model.EmployeeMissingSkillset;
import com.amdocs.commonality.ddu.learning.standalone.model.EmployeeSkillset;
import org.springframework.stereotype.Service;

@Service
public class ValidateSkillsService {


    private final EmployeeMissingSkillset employeeMissingSkillset;

    public ValidateSkillsService(EmployeeMissingSkillset employeeMissingSkillset) {
        this.employeeMissingSkillset = employeeMissingSkillset;
    }

    public EmployeeMissingSkillset validateSkills(EmployeeSkillset employeeSkillset){
        employeeMissingSkillset.setEmpId(employeeSkillset.getEmpId());;
        employeeSkillset.getRequiredSkills().removeIf(skill -> employeeSkillset.getActualSkills().stream()
                .anyMatch(skill1 -> skill1.equalsIgnoreCase(skill)));
        employeeMissingSkillset.setMissingSkills(employeeSkillset.getRequiredSkills());
        return employeeMissingSkillset;
    }
}
