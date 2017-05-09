package net.sunnary.sunnary.controller;

import net.sunnary.sunnary.dto.ContentRequestDto;
import net.sunnary.sunnary.dto.ContentResponseDto;
import net.sunnary.sunnary.manager.ContentManager;
import net.sunnary.sunnary.manager.SearchManager;
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
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/content")
public class ContentController {

    private ContentManager contentManager;
    private SearchManager searchManager;

    @Autowired
    public ContentController(ContentManager contentManager, SearchManager searchManager) {
        this.contentManager = contentManager;
        this.searchManager = searchManager;
    }

    @ResponseBody
    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContentResponseDto>> search(@RequestBody List<String> rawTags) {
        List<ContentResponseDto> contents = searchManager.searchByRawTags(rawTags).stream().map(ContentResponseDto::new).collect(Collectors.toList());
        return new ResponseEntity<>(contents, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid ContentRequestDto form) {
        contentManager.insertContentFromForm(form);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
