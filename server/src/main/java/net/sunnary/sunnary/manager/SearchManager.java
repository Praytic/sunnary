package net.sunnary.sunnary.manager;

import net.sunnary.sunnary.exceptions.NoTagException;
import net.sunnary.sunnary.model.Content;
import net.sunnary.sunnary.model.SearchTag;
import net.sunnary.sunnary.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchManager {
    private ContentManager contentManager;

    @Autowired
    public SearchManager(ContentManager contentManager) {
        this.contentManager = contentManager;
    }

    private List<SearchTag> convertRawTags(List<String> rawTags) {
        List<SearchTag> result = new ArrayList<>();

        for (String rawTag : rawTags) {
            boolean shouldExclude = false;
            String name;

            if (rawTag.startsWith("-")) {
                shouldExclude = true;
                name = rawTag.substring(1);
            } else {
                name = rawTag;
            }

            Tag tag;
            try {
                tag = contentManager.getTag(name);
            } catch (NoTagException exception) {
                continue;
            }

            result.add(new SearchTag(tag, shouldExclude));
        }

        return result;
    }

    private boolean doesMatchTags(Content content, List<SearchTag> searchTags) {
        for (SearchTag searchTag : searchTags) {
            if (searchTag.shouldExclude() && content.getTags().contains(searchTag.getTag())) {
                return false;
            } else if (!searchTag.shouldExclude() && !content.getTags().contains(searchTag.getTag())) {
                return false;
            }
        }

        return true;
    }

    @Transactional(readOnly = true)
    public List<Content> searchByTags(List<SearchTag> searchTags) {
        return contentManager.getAllContent().stream()
                .filter(content -> doesMatchTags(content, searchTags))
                .collect(Collectors.toList());
    }

    public List<Content> searchByTagsRaw(List<String> rawTags) {
        return searchByTags(convertRawTags(rawTags));
    }
}
