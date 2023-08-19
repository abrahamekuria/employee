package com.employeeInfo.employee.controller;

import com.employeeInfo.employee.model.EmpInfo;
import com.employeeInfo.employee.model.EmployeeResponse;
import com.employeeInfo.employee.repo.EmployeeInfoRepository;
import com.employeeInfo.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmployeeController {

    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeInfoRepository infoRepository;

    @GetMapping("/amEmployee")
    public EmployeeResponse getEmpInfo() {
        log.info("Entered etInfo.");
        return employeeService.getEmpInfoService();
    }

    @GetMapping("/amEmployeeById/{id}")
    public EmpInfo getEmpInfoById(@PathVariable int id) {
        EmpInfo empInfo = new EmpInfo();
        EmployeeResponse empInfoService = employeeService.getEmpInfoService();
        List<EmpInfo> empInfoList = empInfoService.getData();
        for (EmpInfo e : empInfoList) {
            if (id == e.getId()) {
                empInfo = e;
                infoRepository.save(e);
                break;
            }
        }
        return empInfo;
    }

    @PostMapping("/saveEmployeeData")
    public String SaveEmpInfo() {
        EmpInfo empInfo = new EmpInfo();
        EmployeeResponse empInfoService = employeeService.getEmpInfoService();
        List<EmpInfo> empInfoList = empInfoService.getData();
        for (EmpInfo e : empInfoList) {
            infoRepository.save(e);
        }
        return "Saved into MySql Successfully";
    }
    @PostMapping ("/addAnEmployee")
    public String PostEmpInfo(@RequestBody EmpInfo newEmp){
        infoRepository.save(newEmp);
        return  "Saved successfully";
    }

    @PutMapping ("/updateAnEmployee")
    public EmpInfo UpdateEmpInfo(@RequestBody EmpInfo updatedEmpInfo){
        EmpInfo byEmpId = infoRepository.findById(updatedEmpInfo.getId());
        if(byEmpId!=null) {
            byEmpId.setId(updatedEmpInfo.getId());
            byEmpId.setEmployee_name(updatedEmpInfo.getEmployee_name());
            byEmpId.setEmployee_age(updatedEmpInfo.getEmployee_age());
            byEmpId.setEmployee_salary(updatedEmpInfo.getEmployee_salary());
            byEmpId.setProfile_image(updatedEmpInfo.getProfile_image());
            infoRepository.save(updatedEmpInfo);
        }
        else{
            return new EmpInfo();
        }

        return byEmpId;
    }

    @DeleteMapping("/deleteAllEmployeeData")
    public String deleteAllEmpInfo() {
        infoRepository.deleteAll();
        return "Deleted";
    }
    @DeleteMapping("/deleteEmployeeById/{id}")
    public String deleteEmpInfoById(@PathVariable int id) {
        infoRepository.deleteById(id);
        return "Employee with ID # "+ id + " is deleted";
    }


    @GetMapping("/amEmployeeByAge/{employee_age}")
    public List<EmpInfo> getEmpInfoByAge(@PathVariable int employee_age) {
        List<EmpInfo> empInfoListResponse = new ArrayList<>();
        EmployeeResponse empInfoService = employeeService.getEmpInfoService();
        List<EmpInfo> empInfoList = empInfoService.getData();
        for (EmpInfo e : empInfoList) {
            if (employee_age == e.getEmployee_age()) {
                empInfoListResponse.add(e);

            }
        }
        return empInfoListResponse;
    }


}
