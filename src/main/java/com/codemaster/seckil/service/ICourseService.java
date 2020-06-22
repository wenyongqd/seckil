package com.codemaster.seckil.service;

import com.codemaster.seckil.model.Course;

import java.util.List;

public interface ICourseService {

    public List<Course> findAllCourses();

    public Course findCourseByCourseNo(String courseNo);

    public int reduceStockByCourseNo(String courseNo);

}

