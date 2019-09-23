package AS.Demo.dao;

import AS.Demo.po.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Title: AnswerSystem
 * @Description:
 * @Author: huba
 * @Date: 2019/9/9 9:27
 * @Version: 1.0
 */
@Repository(value = "StudentMapper")
public interface StudentMapper {
    void AddStudent(Student student);

    Student SelectStudent(Student student);

    Student SelectByStudentId(@Param("student_id") String student_id);
}
