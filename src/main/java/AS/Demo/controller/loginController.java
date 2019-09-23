package AS.Demo.controller;

import AS.Demo.dao.StudentMapper;
import AS.Demo.dao.TeacherMapper;
import AS.Demo.po.Student;
import AS.Demo.po.Teacher;
import AS.Demo.service.StudentService;
import AS.Demo.service.TeacherService;
import org.apache.ibatis.annotations.Param;
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
 * @Date: 2019/9/15 14:27
 * @Version: 1.0
 */
@Controller
@RequestMapping()
public class loginController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "login")
    public ModelAndView loginCheck(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("stu_tea").equals("0")) {
            System.out.println("进入学生操作");
            ModelAndView modelAndView = new ModelAndView("student_menu");
            Student student = new Student();
            student.setStudent_id(request.getParameter("id"));
            student.setStudent_password(request.getParameter("password"));
            student = studentService.SelectStudent(student);
            if (student != null) {
                modelAndView.addObject("student", student);
                return modelAndView;
            } else {
                return new ModelAndView("redirect:/jsp/error.html");
            }
        } else {
            System.out.println("进入教师操作");
            ModelAndView modelAndView = new ModelAndView("teacher_menu");
            Teacher teacher = new Teacher();
            teacher.setTeacher_id(request.getParameter("id"));
            teacher.setTeacher_password(request.getParameter("password"));
            teacher = teacherService.SelectTeacher(teacher);
            if (teacher != null) {
                modelAndView.addObject("teacher", teacher);
                return modelAndView;
            } else {
                return new ModelAndView("redirect:/jsp/error.html");
            }
        }
    }
}
