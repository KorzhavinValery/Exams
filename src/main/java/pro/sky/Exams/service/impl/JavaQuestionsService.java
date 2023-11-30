package pro.sky.Exams.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.Exams.exceptions.QuestionsNotFindException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.repositories.JavaQuestionRepository;
import pro.sky.Exams.service.QuestionsService;

import java.util.*;

@Service
public class JavaQuestionsService implements QuestionsService {
    private JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionsService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question questionExam = new Question(question, answer);
        return javaQuestionRepository.add(questionExam);
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
        Collection<Question> questions = javaQuestionRepository.getAll();
        if (questions.isEmpty()) {
            throw new QuestionsNotFindException();
        }
        Random randomQuestion = new Random();
        int random = randomQuestion.nextInt(questions.size());
        return (Question) questions.toArray()[random];
    }
}
