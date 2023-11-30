package pro.sky.Exams.service.impl;

import pro.sky.Exams.exceptions.QuestionsNotFindException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.repositories.MathQuestionRepository;
import pro.sky.Exams.service.QuestionsService;

import java.util.*;

public class MathQuestionService implements QuestionsService {
    private MathQuestionRepository mathQuestionRepository;


    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question questionExam = new Question(question, answer);
        return mathQuestionRepository.add(questionExam);
    }

//    @Override
//    public Question add(Question question) {
//        questions.add(question);
//        return question;
//    }
//
//    @Override
//    public Question remove(Question question) {
//        questions.remove(question);
//        return question;
//    }
//
//    @Override
//    public Collection<Question> getAll() {
//        return Collections.unmodifiableCollection(questions);
//    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> questions = mathQuestionRepository.getAll();
        if (questions.isEmpty()) {
            throw new QuestionsNotFindException();
        }
        Random randomQuestion = new Random();
        int random = randomQuestion.nextInt(questions.size());
        return (Question) questions.toArray()[random];
    }
}
