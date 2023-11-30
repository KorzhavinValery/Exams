package pro.sky.Exams.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.Exams.exceptions.NoFreeQuestionsException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.ExaminerService;
import pro.sky.Exams.service.QuestionsService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionsService> services;
    private final Random random;

    @Autowired
    public ExaminerServiceImpl(List<QuestionsService> services) {
        this.services = services;
        random = new Random();
    }

    public ExaminerServiceImpl(List<QuestionsService> services, Random random) {
        this.services = services;
        this.random = random;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> result = new HashSet<>();
        Map<QuestionsService, Set<Question>> usedQuestions = services.stream().collect(
                Collectors.toMap(e -> e, e -> new HashSet<>()));
        int i = 0;
        for (; i < amount; i++) {
            int attemptCount = 5;
            while (attemptCount > 0) {
                try {
                    int randomServiceNumber = random.nextInt(services.size());
                    QuestionsService randomService = services.get(randomServiceNumber);
                    Question randomQuestion = randomService.getRandomQuestion();
                    result.add(randomQuestion);
                    usedQuestions.get(randomService).add(randomQuestion);
                    break;
                } catch (NoFreeQuestionsException e) {
                    attemptCount--;
                }
            }
            if (attemptCount == 0) throw (new NoFreeQuestionsException());
        }
        return result;
    }
}
