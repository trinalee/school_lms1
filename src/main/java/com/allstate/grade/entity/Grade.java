package com.allstate.grade.entity;

import com.allstate.klass.entity.Klass;
import com.allstate.student.entity.Student;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @NotNull
    private int value;

    @NotNull
    @Column(name = "is_passing")
    private boolean isPassing;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "klass_id")
    private Klass klass;

}
