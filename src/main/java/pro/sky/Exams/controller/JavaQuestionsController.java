package pro.sky.Exams.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.repositories.JavaQuestionRepository;
import pro.sky.Exams.service.QuestionsService;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")
public class JavaQuestionsController {
    private final QuestionsService service;


    public JavaQuestionsController(@Qualifier("javaQuestionService")
                                   QuestionsService service) {
        this.service = service;
    }

    @GetMapping("add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {

        return service.add(question, answer);
    }


    @GetMapping("remove")
    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }

    public Collection<Question> getQuestions() {

        return service.getAll();
    }
}
