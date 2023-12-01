package pro.sky.Exams.service;

import pro.sky.Exams.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
