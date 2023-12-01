package pro.sky.Exams.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.Exams.exceptions.MathQuestionRepositoryException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.QuestionsService;

import java.util.*;

@Service
public class MathQuestionService implements QuestionsService {
    private Random random = new Random();


    @Override
    public Question add(String question, String answer) {
        throw new MathQuestionRepositoryException();
    }

    @Override
    public Question add(Question question) {
        throw new MathQuestionRepositoryException();
    }

    @Override
    public Question remove(Question question) {
        throw new MathQuestionRepositoryException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MathQuestionRepositoryException();
    }

    @Override
    public Question getRandomQuestion() {
        int first = random.nextInt(10);
        int second = random.nextInt(9) + 1;
        String[] actions = {" + ", " - ", " * ", " / "};

        String action = actions[random.nextInt(4)];

        int result = switch (action) {
            case " + " -> first + second;
            case " - " -> first - second;
            case " * " -> first * second;
            case " / " -> first / second;
            default -> 0;
        };
        return new Question(
                "Какой будет итог выражения " + first + action + second + " ?",
                String.valueOf(result));
    }
}
