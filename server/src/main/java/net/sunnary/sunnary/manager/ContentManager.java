package net.sunnary.sunnary.manager;

import net.sunnary.sunnary.dto.ContentRequestDto;
import net.sunnary.sunnary.exceptions.NoContentException;
import net.sunnary.sunnary.exceptions.NoTagException;
import net.sunnary.sunnary.model.Content;
import net.sunnary.sunnary.model.ContentDescription;
import net.sunnary.sunnary.model.Tag;
import net.sunnary.sunnary.repository.ContentDescriptionRepository;
import net.sunnary.sunnary.repository.ContentRepository;
import net.sunnary.sunnary.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Transactional(readOnly = true)
public class ContentManager {

    private ContentDescriptionRepository contentDescriptionRepository;
    private ContentRepository contentRepository;
    private TagRepository tagRepository;

    @Autowired
    public ContentManager(ContentRepository contentRepository, TagRepository tagRepository,
            ContentDescriptionRepository contentDescriptionRepository) {
        this.contentRepository = contentRepository;
        this.tagRepository = tagRepository;
        this.contentDescriptionRepository = contentDescriptionRepository;
    }

    @Transactional
    public void insertContentFromForm(ContentRequestDto form) {
        Content content = new Content(form);

        content.setTags(getTags(form.getTags(), true));

        if (form.getContentIds() != null) {
            for (Long contentId : form.getContentIds()) {
                Content includedContent = getContent(contentId);
                content.getIncludedContents().add(includedContent);
            }
        }

        content.setSubmissionDate(new Date());
        content.setType(form.getType());

        content = contentRepository.save(content);

        if (!StringUtils.isEmpty(form.getDescription())) {
            ContentDescription description = new ContentDescription(content, form.getDescription());
            contentDescriptionRepository.save(description);
        }
    }

    @Transactional
    public Set<Tag> getTags(List<String> rawTags, boolean createIfNotFound) {
        Set<Tag> tags = new HashSet<>();
        for (String tagString : rawTags) {
            Tag tag = tagRepository.findOne(tagString);
            if (tag == null && createIfNotFound) {
                tag = new Tag();
                tag.setId(tagString);
                tagRepository.save(tag);
                tags.add(tag);
            }
        }
        return tags;
    }

    public Content getContent(long id) {
        Content content = contentRepository.getOne(id);

        if (content == null) {
            throw new NoContentException(id);
        }

        return content;
    }

    public Tag getTag(String name) {
        Tag tag = tagRepository.findOne(name);

        if (tag == null) {
            throw new NoTagException(name);
        }

        return tag;
    }

    @Transactional
    public void upvoteContent(long contentId) {
        getContent(contentId).upvote();
    }

    @Transactional
    public void downvoteContent(long contentId) {
        getContent(contentId).downvote();
    }

    @Transactional
    public void viewContent(long contentId) {
        getContent(contentId).view();
    }

    public List<Content> getAllContent() {
        return contentRepository.findAllFetchEager();
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public List<Tag> getTagsByQuery(String query) {
        return tagRepository.getByQuery(query);
    }
}
