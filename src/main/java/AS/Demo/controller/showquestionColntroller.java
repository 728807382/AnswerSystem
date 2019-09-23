package AS.Demo.controller;

import AS.Demo.po.Question;
import AS.Demo.po.Stu_Tea;
import AS.Demo.po.Student;
import AS.Demo.po.Teacher;
import AS.Demo.service.QuestionService;
import AS.Demo.service.Stu_TeaService;
import AS.Demo.service.StudentService;
import AS.Demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Title: AnswerSystem
 * @Description:
 * @Author: huba
 * @Date: 2019/9/16 21:16
 * @Version: 1.0
 */
@Controller
public class showquestionColntroller {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private Stu_TeaService stu_teaService;

    @RequestMapping(value = "/showquestion")
    public ModelAndView showquestion(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String question_id=request.getParameter("question_id");
        String teacher_id=request.getParameter("teacher_id");
        Question question=questionService.SelectByQuestionID(question_id);
        Teacher teacher=teacherService.SelectByTeacherId(teacher_id);
        Student student=studentService.SelectByStudentId(question.getQuestion_poid());
        if (teacher_id=="") {
            System.out.println("学生查看");
            ModelAndView modelAndView = new ModelAndView("question");
            modelAndView.addObject("question",question);
            modelAndView.addObject("student",student);
            return modelAndView;
        }else {
            System.out.println("教师查看");
            if (question.getAnswer_time()!=null){
                ModelAndView modelAndView = new ModelAndView("question");
                modelAndView.addObject("question",question);
                modelAndView.addObject("student",student);
                return modelAndView;
            }else {
                ModelAndView modelAndView = new ModelAndView("answer");
                modelAndView.addObject("question",question);
                modelAndView.addObject("student",student);
                modelAndView.addObject("teacher",teacher);
                return modelAndView;
            }
        }
    }
//    学生跳转controller
    @RequestMapping(value = "/studentquestionByPoId")
    public ModelAndView studentquestionByPoId(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        ModelAndView modelAndView = new ModelAndView("teacher_answerquiz");
        String question_poid=request.getParameter("question_poid");
        List<Question> questionList = questionService.SelectByPoId(question_poid);
        modelAndView.addObject("questionList", questionList);
        return modelAndView;
    }
//    教师跳转controller
    @RequestMapping(value = "/teacherquestionByPoId")
    public ModelAndView teacherquestionByPoId(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        ModelAndView modelAndView = new ModelAndView("teacher_answerquiz");
        Teacher teacher=teacherService.SelectByTeacherId(request.getParameter("teacher_id"));
        List<Stu_Tea> stu_teaList=stu_teaService.SelectByteacherId(teacher.getTeacher_id());
        List<Question> questionList=questionService.SelectByPoId("test");
        for (int i=0;i<stu_teaList.size();i++){
            String student_id=stu_teaList.get(i).getStudent_id();
            List<Question> questionList1=questionService.SelectByPoId(student_id);
            if (!questionList1.isEmpty()){
                questionList.addAll(questionList1);
            }
        }
        modelAndView.addObject("teacher",teacher);
        modelAndView.addObject("questionList",questionList);
        return modelAndView;
    }

    @RequestMapping("/quiz")
    public ModelAndView quiz(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        ModelAndView modelAndView=new ModelAndView("student_quiz");
        String question_poid=request.getParameter("question_poid");
        modelAndView.addObject("question_poid",question_poid);
        return modelAndView;
    }
}
