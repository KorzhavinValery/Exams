package pro.sky.Exams;

import org.junit.jupiter.api.Test;
import pro.sky.Exams.exceptions.MathQuestionRepositoryException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.impl.MathQuestionService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathQuestionServiceTest {
    MathQuestionService out = new MathQuestionService();

    @Test
    void addByString() {
        assertThrows(MathQuestionRepositoryException.class, () ->
                out.add("", ""));
    }

    @Test
    void addByQuestion() {
        assertThrows(MathQuestionRepositoryException.class, () ->
                out.add(new Question("q", "a")));
    }

    @Test
    void remove() {
        assertThrows(MathQuestionRepositoryException.class, () ->
                out.remove(new Question("q", "a")));
    }

    @Test
    void getAll() {
        assertThrows(MathQuestionRepositoryException.class, () ->
                out.getAll());
    }

    void checkQuestion(Question question) {
        assertTrue(question.getQuestion().matches(
                "Какой будет итог выражения \\d [+\\-*/] \\d \\?"));
        assertTrue(question.getAnswer().matches(
                "-{0,1}\\d{1,2}"));
    }

    @Test
    void getRandomQuestion() {
        for (int i = 0; i < 50; i++) checkQuestion(out.getRandomQuestion());
    }
}
