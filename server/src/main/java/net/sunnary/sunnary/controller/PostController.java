package net.sunnary.sunnary.controller;

import net.sunnary.sunnary.controller.exceptions.ContentCreationException;
import net.sunnary.sunnary.dto.ContentSubmissionForm;
import net.sunnary.sunnary.manager.ContentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/upload/")
public class PostController {
    private ContentManager contentManager;

    @Autowired
    public PostController(ContentManager contentManager) {
        this.contentManager = contentManager;
    }

    @PostMapping(path = "content", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> postArticle(@RequestBody @Valid ContentSubmissionForm form) throws ContentCreationException {
        contentManager.insertContentFromForm(form);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
