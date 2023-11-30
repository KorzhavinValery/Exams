package pro.sky.Exams.repositories;

import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.QuestionRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MathQuestionRepository implements QuestionRepository {
    private Set<Question> questions = new HashSet<>();

    public MathQuestionRepository(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public void init() {

    }
}
