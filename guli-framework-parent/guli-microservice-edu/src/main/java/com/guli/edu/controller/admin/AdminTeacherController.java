package com.guli.edu.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.common.constants.ResultCodeEnum;
import com.guli.edu.entity.Teacher;
import com.guli.edu.query.TeacherQuery;
import com.guli.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.guli.common.vo.R;

import java.util.List;

@Api(description = "讲师管理")
@RestController
//跨域
@CrossOrigin
@RequestMapping("admin/edu/teacher")
public class AdminTeacherController {

    @Autowired
    private TeacherService teacherService;


    @ApiOperation("根据Id删除讲师")
    @DeleteMapping("remove/{id}")
    public R removeById(@PathVariable String id){
        if (teacherService.removeById(id)) {
            return R.ok();
        }else {
            return R.error();
        }

    }
    @ApiOperation("添加讲师")
    @PostMapping("create")
    public R createTeacher(@RequestBody Teacher teacher){
        if (teacherService.save(teacher)) {
            return R.ok();
        }else {
            return R.error();
        }
    }

    @ApiOperation("根据Id修改教师")
    @PutMapping("update/{id}")
    public R updateById(@PathVariable String id,@RequestBody Teacher teacher){
        //查看这个讲师是否存在
        if (teacherService.getById(id) == null) {
            R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
        }
        System.out.println(teacher);
        teacher.setId(id);
        if (teacherService.updateById(teacher)) {
            return R.ok();
        }else {
            return R.error();
        }
    }

    @ApiOperation("分页查询")
    @GetMapping("{page}/{size}")
    public R page(@PathVariable Integer page, @PathVariable Integer size, TeacherQuery teacherQuery){
        Page<Teacher> teacherPage = new Page<>(page, size);
        teacherService.pageQuery(teacherPage,teacherQuery);
        return R.ok().data("item",teacherPage.getRecords()).data("total",teacherPage.getTotal());
    }





}
