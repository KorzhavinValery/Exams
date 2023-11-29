package pro.sky.Exams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Exams.exceptions.QuestionsNotFindException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.impl.JavaQuestionsService;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionsServiceTest {

    private JavaQuestionsService out = new JavaQuestionsService();
    private Question qstn = new Question("question", "answer");

    @BeforeEach
    public void setUp() {
        out = new JavaQuestionsService();
    }

    @Test
    void shouldAddQuestion() {
        Question result = out.add(qstn.getQuestion(), qstn.getAnswer());

        assertTrue(out.getAll().contains(qstn));
        assertEquals(qstn, result);
    }

    @Test
    void shouldRemoveQuestion() {

        out.add(new Question(qstn.getQuestion(), qstn.getAnswer()));
        Question result = out.remove(new Question(qstn.getQuestion(), qstn.getAnswer()));
        assertFalse(out.getAll().contains(qstn));
        assertEquals(qstn, result);

    }

    @Test
    void shouldReturnAllQuestions() {
        Question qstn1 = new Question("question1", "answer1");
        out.add(qstn1);
        out.add(qstn);

        Collection<Question> result = out.getAll();

        assertTrue(result.containsAll(Set.of(qstn, qstn1)));
    }

    @Test
    void shouldThrowQuestionsNotFindExceptionWhenCollectionIsEmpty() {
        QuestionsNotFindException questionsNotFindException = assertThrows(QuestionsNotFindException.class,
                () -> out.getRandomQuestion());
    }

    @Test
    void shouldReturnRandomQuestion() {
        out.add(qstn);

        Question result = out.getRandomQuestion();
        assertEquals(qstn, result);

    }
}
