package pro.sky.Exams.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import pro.sky.Exams.exceptions.QuestionsNotFindException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.ExaminerService;
import pro.sky.Exams.service.QuestionRepository;
import pro.sky.Exams.service.QuestionsService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionRepository questionRepository;
    private final QuestionsService questionsService;

    public ExaminerServiceImpl(@Qualifier("mathQuestionRepository")QuestionRepository questionRepository,
                               @Qualifier("mathQuestionService") QuestionsService questionsService) {
        this.questionRepository = questionRepository;
        this.questionsService = questionsService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionRepository.getAll().size() < amount) {
            throw new QuestionsNotFindException();
        }
        Set<Question> userQuestion = new HashSet<>();
        while (userQuestion.size() < amount) {
            userQuestion.add(questionsService.getRandomQuestion());
        }
        return userQuestion;
    }
}
