package com.allstate.teacher.entity;

import com.allstate.enums.Gender;
import com.allstate.klass.entity.Klass;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by localadmin on 2/9/17.
 */

@Entity
@Data
@Table(name="teachers")
@NoArgsConstructor
public class Teacher {

    @GeneratedValue
    @Id
    private int id;

    @Version
    private int version;

    @NotNull
    @Size(min=1)
    private String name;

    @NotNull
    @Min(value=0)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('MALE', 'FEMALE')")
    @NotNull
    private Gender gender;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<Klass> klasses;

    public Teacher(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
