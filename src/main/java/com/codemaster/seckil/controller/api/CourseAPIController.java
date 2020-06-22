package com.codemaster.seckil.controller.api;

import com.codemaster.seckil.VO.CourseVO;
import com.codemaster.seckil.base.controller.BaseApiController;
import com.codemaster.seckil.base.result.Result;
import com.codemaster.seckil.model.Course;
import com.codemaster.seckil.service.ICourseService;
import com.codemaster.seckil.util.CourseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseAPIController extends BaseApiController {

    @Autowired
    public ICourseService courseService;

    @RequestMapping(value="courseList",method= RequestMethod.GET)
    public Result<List<Course>> courseList(){
        return Result.success(courseService.findAllCourses());
    }

    @RequestMapping(value="courseDetail/{courseNo}",method=RequestMethod.GET)
    public Result<CourseVO> courseDetail(@PathVariable String courseNo){
        return Result.success(CourseUtil.courseToCourseVO(courseService.findCourseByCourseNo(courseNo)));
    }
}
