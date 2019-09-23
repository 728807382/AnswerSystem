package AS.Demo.controller;

import AS.Demo.po.Question;
import AS.Demo.po.Stu_Tea;
import AS.Demo.po.Student;
import AS.Demo.po.Teacher;
import AS.Demo.service.QuestionService;
import AS.Demo.service.Stu_TeaService;
import AS.Demo.service.StudentService;
import AS.Demo.service.TeacherService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: AnswerSystem
 * @Description:
 * @Author: huba
 * @Date: 2019/9/17 19:31
 * @Version: 1.0
 */
@Controller
public class droppageController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private Stu_TeaService stu_teaService;

    @RequestMapping(value = "/manage")
    public ModelAndView questionmanage(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        ModelAndView modelAndView=new ModelAndView("teacher_manage");
        String teacher_id=request.getParameter("teacher_id");
        Teacher teacher=teacherService.SelectByTeacherId(teacher_id);
        List<Stu_Tea> stu_teaList=stu_teaService.SelectByteacherId(teacher_id);
        List<Question> questionList=questionService.SelectByPoId("test");
        for (int i=0;i<stu_teaList.size();i++){
            String student_id=stu_teaList.get(i).getStudent_id();
            List<Question> questionList1=questionService.SelectByPoId(student_id);
            if (!questionList1.isEmpty()){
                questionList.addAll(questionList1);
            }
        }
        modelAndView.addObject("teacher_id",teacher_id);
        modelAndView.addObject("questionList",questionList);
        return modelAndView;
    }

    @RequestMapping(value = "/teacher_stumanage")
    public ModelAndView teacher_stumanage(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        ModelAndView modelAndView=new ModelAndView("teacher_stumanage");
        String teacher_id=request.getParameter("teacher_id");
        List<Stu_Tea> stu_teaList= stu_teaService.SelectByteacherId(teacher_id);
        Student student=new Student();
        List<Student> studentList=new ArrayList<Student>();
        for (int i = 0; i < stu_teaList.size(); i++) {
            student=studentService.SelectByStudentId(stu_teaList.get(i).getStudent_id());
            studentList.add(student);
        }
        modelAndView.addObject("teacher_id",teacher_id);
        modelAndView.addObject("stu_teaList",stu_teaList);
        modelAndView.addObject("studentList",studentList);
        return modelAndView;
    }
    @RequestMapping(value = "/studentinfo")
    public ModelAndView student_info(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        ModelAndView modelAndView = new ModelAndView("student_info");
        Student student=studentService.SelectByStudentId(request.getParameter("student_id"));
        modelAndView.addObject("student",student);
        return modelAndView;
    }

    @RequestMapping(value = "/teacherinfo")
    public ModelAndView teacher_info(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        ModelAndView modelAndView = new ModelAndView("teacher_info");
        Teacher teacher=teacherService.SelectByTeacherId(request.getParameter("teacher_id"));
        modelAndView.addObject("teacher",teacher);
        return modelAndView;
    }
}
