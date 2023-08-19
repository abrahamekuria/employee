package com.employeeInfo.employee.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeResponse {
    String status;
   List<EmpInfo>  data = new ArrayList<>();
    String message;

}
