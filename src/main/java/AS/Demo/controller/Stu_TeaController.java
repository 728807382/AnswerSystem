package AS.Demo.controller;

import AS.Demo.dao.Stu_TeaMapper;
import AS.Demo.po.Stu_Tea;
import AS.Demo.po.Student;
import AS.Demo.service.Stu_TeaService;
import AS.Demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.xml.stream.Location;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: AnswerSystem
 * @Description:
 * @Author: huba
 * @Date: 2019/9/17 21:47
 * @Version: 1.0
 */
@Controller
public class Stu_TeaController {
    @Autowired
    private Stu_TeaService stu_teaService;
    @Autowired
    private StudentService studentService;
    @RequestMapping("/AddContact")
    private ModelAndView AddContact(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String student_id=request.getParameter("student_id");
        String student_name=request.getParameter("student_name");
        String teacher_id=request.getParameter("teacher_id");
        Student student=studentService.SelectByStudentId(student_id);
        System.out.println(student);
        if (student!=null&&student.getStudent_name().equals(student_name)){
            stu_teaService.AddContact(student_id,teacher_id);
            ModelAndView modelAndView=new ModelAndView("redirect:teacher_stumanage.action?teacher_id="+teacher_id);
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("error_change");
            String errordetail="账号姓名不匹配，返回！";
            modelAndView.addObject("errordetail",errordetail);
            modelAndView.addObject("teacher_id",teacher_id);
            return modelAndView;
        }
    }
    @RequestMapping("/DeleteContact")
    private ModelAndView DeleteContact(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String student_id=request.getParameter("student_id");
        String teacher_id=request.getParameter("teacher_id");
        ModelAndView modelAndView=new ModelAndView("redirect:teacher_stumanage.action?teacher_id="+teacher_id);
        stu_teaService.DeleteContact(student_id,teacher_id);
        return modelAndView;
    }


}
