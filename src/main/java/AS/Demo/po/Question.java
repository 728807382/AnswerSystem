package AS.Demo.po;

/**
 * @Title: AnswerSystem
 * @Description:
 * @Author: huba
 * @Date: 2019/9/9 9:16
 * @Version: 1.0
 */
public class Question {
    private String question_id;
    private String question_poid;
    private String question_title;
    private String question_des;
    private String question_time;
    private String answer_poid;
    private String answer_time;
    private String answer_des;

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_poid() {
        return question_poid;
    }

    public void setQuestion_poid(String question_poid) {
        this.question_poid = question_poid;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public String getQuestion_des() {
        return question_des;
    }

    public void setQuestion_des(String question_des) {
        this.question_des = question_des;
    }

    public String getQuestion_time() {
        return question_time;
    }

    public void setQuestion_time(String question_time) {
        this.question_time = question_time;
    }

    public String getAnswer_poid() {
        return answer_poid;
    }

    public void setAnswer_poid(String answer_poid) {
        this.answer_poid = answer_poid;
    }

    public String getAnswer_time() {
        return answer_time;
    }

    public void setAnswer_time(String answer_time) {
        this.answer_time = answer_time;
    }

    public String getAnswer_des() {
        return answer_des;
    }

    public void setAnswer_des(String answer_des) {
        this.answer_des = answer_des;
    }
}

