package com.allstate.klass.repository;

import com.allstate.klass.entity.Klass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IKlassRepository extends CrudRepository<Klass, Integer> {

    Klass findByName(String name);

    List<Klass> findByTeacherId(int teacherId);
}
