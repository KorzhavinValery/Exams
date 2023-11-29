package pro.sky.Exams.service.impl;

import pro.sky.Exams.exceptions.QuestionsNotFindException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.ExaminerService;
import pro.sky.Exams.service.QuestionsService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService {
    private final Random rnd = new Random();
    private final QuestionsService questionsService;

    public ExaminerServiceImpl(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionsService.getAll().size() < amount) {
            throw new QuestionsNotFindException();
        }
        Set<Question> userQuestion = new HashSet<>();
        while (userQuestion.size() < amount) {
            userQuestion.add(questionsService.getRandomQuestion());
        }
        return userQuestion;
    }
}
