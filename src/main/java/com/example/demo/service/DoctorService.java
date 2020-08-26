package com.example.demo.service;

import com.example.demo.mapper.DoctorMapper;
import com.example.demo.model.Doctor;
import com.example.demo.model.DoctorExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Creat by GG
 * Date on 2020/8/25  11:42 上午
 */
@Service
public class DoctorService{

    @Autowired(required = false)
    private DoctorMapper doctorMapper;

    public List<Doctor> selectById(Long doctorId){
        DoctorExample doctorExample = new DoctorExample();
        doctorExample.createCriteria().andDoctorIdEqualTo(doctorId);
        return doctorMapper.selectByExample(doctorExample);
    }
}
