package pro.sky.Exams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Exams.exceptions.QuestionsNotFindException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.QuestionsService;
import pro.sky.Exams.service.impl.ExaminerServiceImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionsService questionsService;
    @InjectMocks
    ExaminerServiceImpl out;

    @Test
    void shouldThrowQuestionsNotFindException() {
        when(questionsService.getAll()).thenReturn(Collections.emptySet());
        assertThrows(QuestionsNotFindException.class,
                () -> out.getQuestions(1));
    }

    @Test
    void shouldReturnUniqueQuestions() {
        int amount = 2;
        Question question = new Question("question", "answer");
        Question question1 = new Question("question1", "answer1");

        Set<Question> questions = Set.of(question1, question);

        when(questionsService.getAll()).thenReturn(questions);
        when(questionsService.getRandomQuestion()).thenReturn(question, question1);

        Collection<Question> result = out.getQuestions(2);
        assertEquals(questions, result);
        assertEquals(amount, result.stream().distinct().count());
    }

}
