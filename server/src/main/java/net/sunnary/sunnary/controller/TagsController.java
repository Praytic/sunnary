package net.sunnary.sunnary.controller;

import net.sunnary.sunnary.manager.ContentManager;
import net.sunnary.sunnary.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/tags")
public class TagsController {

    private ContentManager contentManager;

    @Autowired
    public TagsController(ContentManager contentManager) {
        this.contentManager = contentManager;
    }

    @ResponseBody
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, params = { "q" })
    public List<Tag> getTags(@RequestParam(value = "q", required = false) String query) {
        return query != null ? contentManager.getTagsByQuery(query) : contentManager.getAllTags();
    }
}
