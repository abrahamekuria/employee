package com.employeeInfo.employee.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class EmpInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String employee_name;
    int employee_salary;
    int employee_age;
    String profile_image;

}




