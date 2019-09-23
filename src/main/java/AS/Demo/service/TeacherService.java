package AS.Demo.service;

import AS.Demo.dao.TeacherMapper;
import AS.Demo.po.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title: AnswerSystem
 * @Description:本controllr使用于登陆注册
 * @Author: huba
 * @Date: 2019/9/9 10:53
 * @Version: 1.0
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public void AddTeacher(Teacher teacher) {
        teacherMapper.AddTeacher(teacher);
    }

    public Teacher SelectTeacher(Teacher teacher) {
        return teacherMapper.SelectTeacher(teacher);
    }

    public Teacher SelectByTeacherId(String teacher_id) {
        return teacherMapper.SelectByTeacherId(teacher_id);
    }
}
