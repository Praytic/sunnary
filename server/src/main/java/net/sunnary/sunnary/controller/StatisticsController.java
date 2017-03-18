package net.sunnary.sunnary.controller;

import net.sunnary.sunnary.controller.exceptions.NoContentControllerException;
import net.sunnary.sunnary.exceptions.NoContentException;
import net.sunnary.sunnary.manager.ContentManager;
import net.sunnary.sunnary.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/stats/")
public class StatisticsController {
    private ContentManager contentManager;

    @Autowired
    public StatisticsController(ContentManager contentManager) {
        this.contentManager = contentManager;
    }

    @PostMapping("{contentId}/upvote")
    public ResponseEntity<Void> upvote(@PathVariable long contentId) throws NoContentControllerException {
        try {
            contentManager.upvoteContent(contentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoContentException e) {
            throw new NoContentControllerException();
        }
    }

    @PostMapping("{contentId}/downvote")
    public ResponseEntity<Void> downvote(@PathVariable long contentId) throws NoContentControllerException {
        try {
            contentManager.downvoteContent(contentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoContentException e) {
            throw new NoContentControllerException();
        }
    }

    @PostMapping("{contentId}/view")
    public ResponseEntity<Void> view(@PathVariable long contentId) throws NoContentControllerException {
        try {
            contentManager.viewContent(contentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoContentException e) {
            throw new NoContentControllerException();
        }
    }
}
