package com.model;

import com.dorm.annotations.MyColumn;
import com.dorm.annotations.MyTable;
import com.dorm.annotations.PK;


import java.util.Objects;

@MyTable
public class Student {

    @PK
    @MyColumn
    private String name;
    @MyColumn
    private String teacher;
    @MyColumn
    private int gradeLevel;

    public Student(){

    }

    public Student(String name, String teacher, int gradeLevel) {
        this.name = name;
        this.teacher = teacher;
        this.gradeLevel = gradeLevel;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return gradeLevel == student.gradeLevel && name.equals(student.name) && teacher.equals(student.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teacher, gradeLevel);
    }


}
