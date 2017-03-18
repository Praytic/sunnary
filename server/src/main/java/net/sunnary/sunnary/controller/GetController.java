package net.sunnary.sunnary.controller;

import net.sunnary.sunnary.manager.ContentManager;
import net.sunnary.sunnary.model.Content;
import net.sunnary.sunnary.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
    Controller meant to be used during the demo
    Unloads almost all database info through a few endpoints
 */
@Controller
@RequestMapping("/api/get/")
public class GetController {
    private ContentManager contentManager;

    @Autowired
    public GetController(ContentManager contentManager) {
        this.contentManager = contentManager;
    }

    @GetMapping(value = "content", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Content>> getArticles() {
        return new ResponseEntity<>(contentManager.getAllContent(), HttpStatus.OK);
    }

    @GetMapping(value = "tags", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Tag>> getTags() {
        return new ResponseEntity<>(contentManager.getAllTags(), HttpStatus.OK);
    }
}
