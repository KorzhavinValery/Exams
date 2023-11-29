package pro.sky.Exams.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.QuestionsService;

import java.util.Collection;

@RestController
@RequestMapping ("/exam/java")
public class JavaQuestionsController {
   private final QuestionsService service;


    public JavaQuestionsController(QuestionsService service) {
        this.service = service;
    }

    public Question addQuestion(String question, String answer) {

        return null;
    }

    public Collection<Question> getQuestions() {

        return null;
    }
    Question removeQuestion(String question, String answer) {
        return null;
    }
}
