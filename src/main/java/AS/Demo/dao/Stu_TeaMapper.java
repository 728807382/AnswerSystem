package AS.Demo.dao;

import AS.Demo.po.Stu_Tea;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: AnswerSystem
 * @Description:
 * @Author: huba
 * @Date: 2019/9/17 21:38
 * @Version: 1.0
 */
@Repository("Stu_TeaMapper")
public interface Stu_TeaMapper {
    void AddContact(@Param("student_id") String student_id,@Param("teacher_id") String teacher_id);

    List<Stu_Tea> SelectByteacherId(@Param("teacher_id") String teacher_id);

    void DeleteContact(@Param("student_id") String student_id,@Param("teacher_id") String teacher_id);

}
