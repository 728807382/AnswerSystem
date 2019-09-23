package AS.Demo.service;

import AS.Demo.dao.QuestionMapper;
import AS.Demo.po.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: AnswerSystem
 * @Description:
 * @Author: huba
 * @Date: 2019/9/16 11:23
 * @Version: 1.0
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    //    增加问题
    public void AddQuestion(Question question){
        questionMapper.AddQuestion(question);
    }

    //      更新问题
    public void UpdateByQuestionId(String question_id,String teacher_id,String answer_des,String question_time){
        questionMapper.UpdateByQuestionId(question_id,teacher_id,answer_des,question_time);
    }


    //    删除问题
    public void DeleteQuestion(String question_id){
        questionMapper.DeleteQuestion(question_id);
    }

    //   按照关键字查找问题(模糊查找)
    public List<Question> SelectByQuestionTitle(String question_title){
         return questionMapper.SelectByQuestionTitle(question_title);
    }
    //    查找所有问题
    public  List<Question> SelectAllQuestion(){
        return questionMapper.SelectAllQuestion();
    }

    //    根据个人id查找本人发布的问题
    public  List<Question> SelectByPoId(String question_poid){
        return questionMapper.SelectByPoId(question_poid);
    }
    //    用问题Id查找问题
    public  Question SelectByQuestionID(String question_id){
        return questionMapper.SelectByQuestionId(question_id);
    }
}
