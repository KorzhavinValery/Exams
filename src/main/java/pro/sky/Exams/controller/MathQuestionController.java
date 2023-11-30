package pro.sky.Exams.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Exams.model.Question;
import pro.sky.Exams.service.impl.MathQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("exam/math")
public class MathQuestionController {
    private final MathQuestionService mathQuestionService;


    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }
    @GetMapping(path = "/add")
    public Question add(@RequestParam String question,
                        @RequestParam String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question remove(@RequestParam String question,
                           @RequestParam String answer) {
        Question fullQuestion = new Question(question, answer);
        return fullQuestion;
    }

    @GetMapping
    public Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }
}
