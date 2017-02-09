package com.allstate.klass.entity;

import com.allstate.enums.Department;
import com.allstate.grade.entity.Grade;
import com.allstate.student.entity.Student;
import com.allstate.teacher.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "klasses")
@Data
public class Klass {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @Size(min = 1)
    private String name;

    @NotNull
    private Date semester;

    @NotNull
    @Min(value = 0)
    private int credits;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('SCIENCE', 'ENGINEERING', 'LITERATURE', 'PHILOSOPHY')")
    private Department department;

    @NotNull
    @DecimalMin(value = "0")
    private double fee;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "klass")
    @JsonIgnore
    private List<Grade> grades;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "klasses_students",
            joinColumns = @JoinColumn(name="klass_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="student_id", referencedColumnName = "id"))
    @JsonIgnore
    private List<Student> students;


}
