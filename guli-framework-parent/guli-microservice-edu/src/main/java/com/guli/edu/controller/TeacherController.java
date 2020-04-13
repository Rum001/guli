package com.guli.edu.controller;


import com.guli.edu.entity.Teacher;
import com.guli.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Rum
 * @since 2020-04-11
 */
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @GetMapping("list")
    public List<Teacher> teachers() {
       return teacherService.list(null);
    }

}

