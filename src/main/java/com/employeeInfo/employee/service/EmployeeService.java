package com.employeeInfo.employee.service;

import com.employeeInfo.employee.model.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    @Autowired
    RestTemplate restTemplate;
    public EmployeeResponse getEmpInfoService(){
        String url = "https://dummy.restapiexample.com/api/v1/employees";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<EmployeeResponse> response= null;
        try{
            response=  restTemplate.exchange(url, HttpMethod.GET,httpEntity,EmployeeResponse.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return response.getBody();
    }

}
