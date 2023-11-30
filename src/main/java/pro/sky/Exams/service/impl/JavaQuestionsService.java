package pro.sky.Exams.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.Exams.exceptions.QuestionsNotFindException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.repositories.JavaQuestionRepository;
import pro.sky.Exams.service.QuestionRepository;
import pro.sky.Exams.service.QuestionsService;

import java.util.*;

@Service
public class JavaQuestionsService implements QuestionsService {
    private QuestionRepository questionRepository;

    public JavaQuestionsService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return questionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> questions = questionRepository.getAll();
        if (questions.isEmpty()) {
            throw new QuestionsNotFindException();
        }
        Random randomQuestion = new Random();
        int random = randomQuestion.nextInt(questions.size());
        return (Question) questions.toArray()[random];
    }
}
