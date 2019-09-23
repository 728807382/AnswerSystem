package AS.Demo.service;

import AS.Demo.dao.Stu_TeaMapper;
import AS.Demo.po.Stu_Tea;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: AnswerSystem
 * @Description:
 * @Author: huba
 * @Date: 2019/9/17 21:37
 * @Version: 1.0
 */
@Service
public class Stu_TeaService {
    @Autowired
    private Stu_TeaMapper stu_teaMapper;

    public void AddContact(String student_id,String teacher_id){
        stu_teaMapper.AddContact(student_id,teacher_id);
    }

    public List<Stu_Tea> SelectByteacherId(String teacher_id){
        return  stu_teaMapper.SelectByteacherId(teacher_id);
    }

    public void DeleteContact(String student_id,String teacher_id){
        stu_teaMapper.DeleteContact(student_id,teacher_id);
    }


}
