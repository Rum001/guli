package com.guli.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.edu.entity.Teacher;
import com.guli.edu.mapper.TeacherMapper;
import com.guli.edu.query.TeacherQuery;
import com.guli.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Rum
 * @since 2020-04-11
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public void pageQuery(Page<Teacher> teacherPage, TeacherQuery teacherQuery) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper.orderByDesc("sort");
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if (name != null) {
            teacherQueryWrapper.like("name",name);
        }
        if (level!=null){
            teacherQueryWrapper.eq("level",level);
        }
        if (begin!=null){
            teacherQueryWrapper.ge("gmt_create",begin);
        }
        if (end != null) {
            teacherQueryWrapper.le("gmt_create",end);
        }
        page(teacherPage,teacherQueryWrapper);
    }
}
