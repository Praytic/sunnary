package net.sunnary.sunnary.controller;

import net.sunnary.sunnary.dto.ArticleSubmissionForm;
import net.sunnary.sunnary.dto.ErrorMessage;
import net.sunnary.sunnary.manager.ArticleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/upload/")
public class PostController {
    private ArticleManager articleManager;

    @Autowired
    public PostController(ArticleManager articleManager) {
        this.articleManager = articleManager;
    }

    @PostMapping(path = "article", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> postArticle(@RequestBody @Valid ArticleSubmissionForm form) {
        articleManager.insertArticleFromForm(form);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleValidationException(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(
                new ErrorMessage(ErrorMessage.Type.MALFORMED_REQUEST, exception.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
