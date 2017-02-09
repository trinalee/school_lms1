package com.allstate.student.entity;

import com.allstate.grade.entity.Grade;
import com.allstate.klass.entity.Klass;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


/**
 * Created by localadmin on 2/9/17.
 */
@Entity
@Table(name="students")
@Data
public class Student {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @Size(min=7)
    @NotNull
    private String email;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Grade> grades;


    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<Klass> klasses;

}
