package pro.sky.Exams.service;

import pro.sky.Exams.model.Question;

import java.util.Collection;

public interface QuestionsService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
    Question getRandomQuestion();


}
