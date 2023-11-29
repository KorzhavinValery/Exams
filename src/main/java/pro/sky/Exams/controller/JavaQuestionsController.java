package pro.sky.Exams.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.QuestionsService;

import java.util.Collection;

@RestController
@RequestMapping ("exam/java")
public class JavaQuestionsController {
   private final QuestionsService service;


    public JavaQuestionsController(QuestionsService service) {
        this.service = service;
    }
@GetMapping("add")
    public Question addQuestion(@RequestParam String question, String answer) {

        return service.add(question, answer);
    }


    @GetMapping("remove")
    public Question removeQuestion(@RequestParam String question, String answer) {
        return service.remove(new Question(answer, question));
    }
    public Collection<Question> getQuestions() {

        return service.getAll();
    }
}
