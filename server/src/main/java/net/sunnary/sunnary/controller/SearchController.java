package net.sunnary.sunnary.controller;

import net.sunnary.sunnary.manager.SearchManager;
import net.sunnary.sunnary.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/search")
public class SearchController {
    private SearchManager searchManager;

    @Autowired
    public SearchController(SearchManager searchManager) {
        this.searchManager = searchManager;
    }

    @ResponseBody
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Content>> search(@RequestBody List<String> rawTags) {
        return new ResponseEntity<>(searchManager.searchByRawTags(rawTags), HttpStatus.OK);
    }
}
