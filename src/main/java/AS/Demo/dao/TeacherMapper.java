package AS.Demo.dao;

import AS.Demo.po.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Title: AnswerSystem
 * @Description:
 * @Author: huba
 * @Date: 2019/9/9 10:28
 * @Version: 1.0
 */
@Repository(value = "TeacherMapper")
public interface TeacherMapper {
    void AddTeacher(Teacher teacher);

    Teacher SelectTeacher(Teacher teacher);

    Teacher SelectByTeacherId(@Param("teacher_id") String teacher_id);
}
