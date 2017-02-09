package com.allstate.klass.service;

import com.allstate.klass.entity.Klass;
import com.allstate.klass.repository.IKlassRepository;
import com.allstate.teacher.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlassService {
    private IKlassRepository klassRepository;

    @Autowired
    public void setKlassRepository(IKlassRepository klassRepository) {
        this.klassRepository = klassRepository;
    }

    public Klass findById(int id) {
        return klassRepository.findOne(id);
    }

    public Klass findByName(String name) {
        return klassRepository.findByName(name);
    }

    public List<Klass> findKlassListByTeacherId(int id) { return klassRepository.findByTeacherId(id); }

    public Teacher findTeacherByClass(String klassName) { return klassRepository.findByName(klassName).getTeacher();}
}
