package com.employeeInfo.employee.repo;

import com.employeeInfo.employee.model.EmpInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInfoRepository extends CrudRepository<EmpInfo, Integer> {
EmpInfo findById(int id);
}
