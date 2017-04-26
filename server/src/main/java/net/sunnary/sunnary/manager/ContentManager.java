package net.sunnary.sunnary.manager;

import net.sunnary.sunnary.controller.exceptions.ContentCreationException;
import net.sunnary.sunnary.dto.ContentSubmissionForm;
import net.sunnary.sunnary.exceptions.NoContentException;
import net.sunnary.sunnary.exceptions.NoTagException;
import net.sunnary.sunnary.model.Content;
import net.sunnary.sunnary.model.Tag;
import net.sunnary.sunnary.repository.ContentRepository;
import net.sunnary.sunnary.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class ContentManager {
    private ContentRepository contentRepository;

    private TagRepository tagRepository;

    @Autowired
    public ContentManager(ContentRepository contentRepository,
                          TagRepository tagRepository) {
        this.contentRepository = contentRepository;
        this.tagRepository = tagRepository;
    }

    @Transactional
    public void insertContentFromForm(ContentSubmissionForm form) throws ContentCreationException {
        Content content = new Content(form);

        for (String tagString : form.getTags()) {
            Tag tag = tagRepository.findOne(tagString);
            if (tag == null) {
                tag = new Tag();
                tag.setId(tagString);
                tagRepository.save(tag);
            }
            content.getTags().add(tag);
        }

        for (Long contentId : form.getContentIds()) {
            try {
                Content includedContent = getContent(contentId);
                content.getIncludedContents().add(includedContent);
            }
            catch (NoContentException e) {
                throw new ContentCreationException();
            }
        }

        content.setSubmissionDate(new Date());
        content.setType(form.getType());

        contentRepository.save(content);
    }

    public Content getContent(long id) throws NoContentException {
        Content content = contentRepository.getOne(id);

        if (content == null) {
            throw new NoContentException(id);
        }

        return content;
    }

    public Tag getTag(String name) throws NoTagException {
        Tag tag = tagRepository.getOne(name);

        if (tag == null) {
            throw new NoTagException(name);
        }

        return tag;
    }

    @Transactional
    public void upvoteContent(long contentId) throws NoContentException {
        getContent(contentId).upvote();
    }

    @Transactional
    public void downvoteContent(long contentId) throws NoContentException {
        getContent(contentId).downvote();
    }

    @Transactional
    public void viewContent(long contentId) throws NoContentException {
        getContent(contentId).view();
    }

    public List<Content> getAllContent() {
        return contentRepository.findAllFetchEager();
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
