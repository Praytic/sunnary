package net.sunnary.sunnary.controllers;

import net.sunnary.sunnary.model.Article;
import net.sunnary.sunnary.model.Tag;
import org.springframework.http.MediaType;
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
@RequestMapping("/api/demo/")
public class DemoController {
    @GetMapping(value = "getArticles", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Article> getArticles() {
        return null;
    }

    @GetMapping(value = "getTags", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Tag> getTags() {
        return null;
    }

}
