package pro.sky.Exams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Exams.exceptions.QuestionsNotFindException;
import pro.sky.Exams.exceptions.QuestionsRequestedException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.QuestionRepository;
import pro.sky.Exams.service.impl.JavaQuestionsService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionsServiceTest {
    @Mock
    private QuestionRepository outRepository;
    @InjectMocks
    private JavaQuestionsService out;

    @Test
    void shouldAddQuestion() {
        Question question = new Question("Вопрос", "Ответ");
        when(outRepository.add(eq(question))).thenReturn(question);
        assertEquals(question, out.add("Вопрос", "Ответ"));
        //

    }

    @Test
    void shouldRemoveQuestion() {
        Question question = new Question("Вопрос", "Ответ");
        when(outRepository.remove(eq(question))).thenReturn(question);
        assertEquals(question, out.remove(question));

    }

    @Test
    void shouldGetAll() {
        Collection<Question> expected = List.of(
                new Question("Вопрос1", "Ответ1"),
                new Question("Вопрос2", "Ответ2"));
        when(outRepository.getAll()).thenReturn(expected);
        assertEquals(expected, out.getAll());
        when(outRepository.getAll()).thenReturn(Collections.emptySet());
        assertEquals(Collections.emptySet(), out.getAll());
    }


    @Test
    void shouldThrowExceptionWhenAlreadyAdded() {
        Question question = new Question("Вопрос", "Ответ");
        when(outRepository.add(eq(question))).thenThrow(QuestionsRequestedException.class);
        assertThrows(QuestionsRequestedException.class, () -> out.add(question));
    }

    @Test
    void shouldThrowNotFindException() {
        Question question = new Question("Вопрос", "Ответ");
        when(outRepository.remove(eq(question))).thenThrow(QuestionsNotFindException.class);
        assertThrows(QuestionsNotFindException.class, () -> out.remove(question));
    }
}
