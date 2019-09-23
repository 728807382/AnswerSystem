package AS.Demo.service;

import AS.Demo.dao.StudentMapper;
import AS.Demo.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title: AnswerSystem
 * @Description:本controllr使用于登陆注册
 * @Author: huba
 * @Date: 2019/9/9 10:43
 * @Version: 1.0
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public void AddStudent(Student student) {
        studentMapper.AddStudent(student);
    }

    public Student SelectStudent(Student student) {
        return studentMapper.SelectStudent(student);
    }

    public Student SelectByStudentId(String student_id) {
        return studentMapper.SelectByStudentId(student_id);
    }


}
