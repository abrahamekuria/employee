package com.employeeInfo.employee.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data

public class PostEmployeeRequestBody {

    String employee_name;
    int employee_salary;
    int employee_age;
    String profile_image;
}
