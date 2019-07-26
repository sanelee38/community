package life.sanelee.community.Controller;

import life.sanelee.community.dto.CommentDTO;
import life.sanelee.community.dto.QuestionDTO;
import life.sanelee.community.service.CommentService;
import life.sanelee.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model){
        QuestionDTO questionDTo = questionService.getById(id);
        List<CommentDTO> comments = commentService.listByQuestionId(id);

        questionService.incView(id);
        model.addAttribute("question",questionDTo);
        model.addAttribute("comments",comments);
        return "question";
    }
}
