package AS.Demo.controller;

import AS.Demo.po.Question;
import AS.Demo.po.Student;
import AS.Demo.po.Teacher;
import AS.Demo.service.QuestionService;
import AS.Demo.service.StudentService;
import AS.Demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Title: AnswerSystem
 * @Description:
 * @Author: huba
 * @Date: 2019/9/16 11:21
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "/question")
public class QuestionController {
    public static String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    @Autowired
    private QuestionService questionService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/add")
    public void AddQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        Question question = new Question();
        String question_id = getRandomString();
        while (questionService.SelectByQuestionID(question_id)!=null&&questionService.SelectByQuestionID(question_id).getQuestion_id()==question_id) {
            question_id = getRandomString();
        }
        //        获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取String类型的时间
        String question_time = sdf.format(date);
        question.setQuestion_id(question_id);
        System.out.println(request.getParameter("question_title"));
        question.setQuestion_title(request.getParameter("question_title"));
        question.setQuestion_des(request.getParameter("question_content"));
        question.setQuestion_poid(request.getParameter("question_poid"));
        question.setQuestion_time(question_time);
        question.setAnswer_poid(null);
        question.setAnswer_time(null);
        question.setAnswer_des(null);
        questionService.AddQuestion(question);
    }

    @RequestMapping(value = "/qquestion")
    public ModelAndView DeleteQuestion(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String question_id=request.getParameter("question_id");
        String teacher_id=request.getParameter("teacher_id");
        questionService.DeleteQuestion(question_id);
        ModelAndView modelAndView=new ModelAndView("redirect:/manage.action?teacher_id="+teacher_id);
        return modelAndView;
    }

    @RequestMapping(value = "/select")
    public ModelAndView SelectQuestion(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        ModelAndView modelAndView = new ModelAndView("teacher_answerquiz");
        String question_title=request.getParameter("question_title");
        question_title="%".concat(question_title);
        question_title=question_title.concat("%");
        List<Question> questionList = questionService.SelectByQuestionTitle(question_title);
        System.out.println(questionList);
        modelAndView.addObject("questionList", questionList);
        return modelAndView;
    }

    @RequestMapping(value = "/selectAll")
    public ModelAndView SelectAllQuestion() {
        ModelAndView modelAndView = new ModelAndView("");
        List<Question> questionList = questionService.SelectAllQuestion();
        modelAndView.addObject("questionList", questionList);
        return modelAndView;
    }

    @RequestMapping(value = "/updateById")
    public ModelAndView updateByQuestionId(HttpServletResponse response,HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8");
        //获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取String类型的时间
        String question_time = sdf.format(date);
        String teacher_id=request.getParameter("teacher_id");
        String question_id=request.getParameter("question_id");
        String answer_des=request.getParameter("answer_des");
        ModelAndView modelAndView=new ModelAndView("redirect:/showquestion.action?teacher_id="+teacher_id+"&question_id="+question_id);
        questionService.UpdateByQuestionId(question_id,teacher_id,answer_des,question_time);
        return modelAndView;
    }


}
