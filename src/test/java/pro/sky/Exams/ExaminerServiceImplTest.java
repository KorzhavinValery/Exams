package pro.sky.Exams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Exams.exceptions.NoFreeQuestionsException;
import pro.sky.Exams.exceptions.QuestionsNotFindException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.QuestionsService;
import pro.sky.Exams.service.impl.ExaminerServiceImpl;

import java.util.*;

import static java.util.List.of;
import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionsService javaQuestionService;
    @Mock
    QuestionsService mathQuestionService;
    @Mock
    Random random;
    ExaminerServiceImpl examinerServiceImpl;

    List<Question> testJavaQuestions = of(
            new Question("JavaQuestion", "JavaAnswer"),
            new Question("JavaQuestion1", "JavaAnswer1"),
            new Question("JavaQuestion2", "JavaAnswer2"));

    List<Question> testMathQuestions = of(
            new Question("MathQuestion", "MathAnswer"),
            new Question("MathQuestion1", "MathAnswer1"),
            new Question("MathQuestion2", "MathAnswer2"));

    @BeforeEach
    void setUp() {
        List<QuestionsService> services = of(javaQuestionService, mathQuestionService);
        examinerServiceImpl = new ExaminerServiceImpl(services);
        examinerServiceImpl = new ExaminerServiceImpl(services, random);
        //Заглушки для getRandomQuestion
        when(javaQuestionService.getRandomQuestion())
                .thenReturn(testJavaQuestions.get(0),
                        testJavaQuestions.get(1),
                        testJavaQuestions.get(2))
                .thenThrow(new NoFreeQuestionsException());
        when(mathQuestionService.getRandomQuestion())
                .thenReturn(testMathQuestions.get(0),
                        testMathQuestions.get(1),
                        testMathQuestions.get(2))
                .thenThrow(new NoFreeQuestionsException());
        when(random.nextInt(anyInt())).thenReturn(0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1);
    }

    @Test
    void shouldGetQuestions() {
        List<Question> expected = of(
                testJavaQuestions.get(0),
                testJavaQuestions.get(1),
                testJavaQuestions.get(2),
                testMathQuestions.get(0),
                testMathQuestions.get(1));

        Collection<Question> result = examinerServiceImpl.getQuestions(5);
        List<Question> actual = new ArrayList<>();
        actual.addAll(result);
        Collections.sort(actual);

        assertEquals(expected, actual);
        assertEquals(5, result.size());
        assertThrows(NoFreeQuestionsException.class, () -> examinerServiceImpl.getQuestions(7));
    }
}
