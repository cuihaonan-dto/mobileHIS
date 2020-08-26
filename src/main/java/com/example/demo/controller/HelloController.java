package com.example.demo.controller;

import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Creat by GG
 * Date on 2020/8/25  11:36 上午
 */
@RestController
public class HelloController {

    @Autowired(required = false)
    private DoctorService doctorService;

    @RequestMapping("/doctor")
    public String test(){
        List<Doctor> doctors = doctorService.selectById((long) 1);
        Doctor doctor = doctors.get(0);
        return doctor.getDoctorId().toString();
    }

}
