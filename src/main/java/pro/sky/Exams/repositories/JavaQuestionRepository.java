package pro.sky.Exams.repositories;

import org.springframework.stereotype.Repository;
import pro.sky.Exams.exceptions.QuestionsNotFindException;
import pro.sky.Exams.exceptions.QuestionsRequestedException;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.QuestionRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private Set<Question> questions = new HashSet<>();

    @Override
    public Question add(Question question) {
        if (!questions.add(question)) {
            throw new QuestionsRequestedException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionsNotFindException();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
