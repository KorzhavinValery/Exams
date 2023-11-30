package pro.sky.Exams.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.QuestionsService;
import pro.sky.Exams.service.impl.MathQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("exam/math")
public class MathQuestionController {
    private final QuestionsService service;


    public MathQuestionController(@Qualifier("mathQuestionService")
                                  QuestionsService service) {
        this.service = service;
    }

    @GetMapping(path = "add")
    public Question add(@RequestParam String question,
                        @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping(path = "remove")
    public Question remove(@RequestParam String question,
                           @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getAll() {
        return service.getAll();
    }
}
