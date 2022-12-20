package com.example.releaselearning.controller;

import com.example.releaselearning.entity.Homework;
import com.example.releaselearning.entity.Student;
import com.example.releaselearning.entity.Teacher;
import com.example.releaselearning.entity.Class;
import com.example.releaselearning.repository.ClassRepository;
import com.example.releaselearning.repository.HomeworkRepository;
import com.example.releaselearning.repository.StudentRepository;
import com.example.releaselearning.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/tec")
public class TecHomeworkController {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private HomeworkRepository homeworkRepository;

    @GetMapping("/homework/{classId}")
    public String getHomeworkPage(Map<String,Object> map, @PathVariable
            String classId){
        return postHomeworkPage(map,classId);
    }
    @PostMapping("/homework/{classId}")
    public String postHomeworkPage(Map<String,Object> map, @PathVariable
            String classId) {
        //作业界面
        Class cla;
        Optional<Class> tmp = classRepository.findById(classId);
        List<Homework> homeworkList = null;
        if (tmp.isPresent()) {
            cla = tmp.get();
            homeworkList = homeworkRepository.findHomeworkByClassId(cla);
            map.put("cla", cla);
        }
        map.put("homeworkList", homeworkList);
        return "tecHomework";
    }
}
