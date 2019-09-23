package AS.Demo.controller;

import AS.Demo.po.Student;
import AS.Demo.po.Teacher;
import AS.Demo.service.StudentService;
import AS.Demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @Title: AnswerSystem
 * @Description:
 * @Author: huba
 * @Date: 2019/9/9 10:55
 * @Version: 1.0
 */
@Controller
@RequestMapping()
public class registerController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/register")
    public String register(HttpServletRequest request, Student student, Teacher teacher) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("jobtitle") == "") {
            student.setStudent_id(request.getParameter("id"));
            student.setStudent_password(request.getParameter("password"));
            student.setStudent_name(request.getParameter("name"));
            student.setStudent_sex(request.getParameter("sex"));
            student.setStudent_phone(request.getParameter("phone"));
            studentService.AddStudent(student);
            return "success";
        } else {
            teacher.setTeacher_id(request.getParameter("id"));
            teacher.setTeacher_password(request.getParameter("password"));
            teacher.setTeacher_name(request.getParameter("name"));
            teacher.setTeacher_sex(request.getParameter("sex"));
            teacher.setTeacher_phone(request.getParameter("phone"));
            teacher.setJobtitle(request.getParameter("jobtitle"));
            teacherService.AddTeacher(teacher);
            return "success";
        }
    }
}
