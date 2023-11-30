package pro.sky.Exams.model;

import java.util.Objects;

public class Question implements Comparable<Question> {
    private String answer;
    private String question;

    public Question(String question, String answer) {
        this.answer = answer;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(answer, question.answer) && Objects.equals(this.question, question.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, question);
    }

    @Override
    public String toString() {
        return "Questions{" +
                "answer='" + answer + '\'' +
                ", question='" + question + '\'' +
                '}';
    }

    @Override
    public int compareTo(Question o) {
        return (question + " " + answer).compareTo(o.getQuestion() + " " + o.getAnswer());
    }
}
