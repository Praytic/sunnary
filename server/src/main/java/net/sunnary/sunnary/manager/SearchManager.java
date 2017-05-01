package net.sunnary.sunnary.manager;

import net.sunnary.sunnary.exceptions.NoTagException;
import net.sunnary.sunnary.model.Content;
import net.sunnary.sunnary.model.SearchTag;
import net.sunnary.sunnary.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Transactional(readOnly = true)
public class SearchManager {
    private ContentManager contentManager;

    @Autowired
    public SearchManager(ContentManager contentManager) {
        this.contentManager = contentManager;
    }

    public SearchTag getSearchTag(String rawTag) throws NoTagException {
        boolean shouldExclude = rawTag.startsWith("-");
        String name;
        if (shouldExclude) {
            name = rawTag.substring(1);
        } else {
            name = rawTag;
        }
        return new SearchTag(contentManager.getTag(name), shouldExclude);
    }

    public boolean containsTags(Content content, List<Tag> tags) {
        return content.getTags().stream().anyMatch(tags::contains);
    }

    public List<Content> searchByTags(List<SearchTag> searchTags) {
        Map<Boolean, List<SearchTag>> partitionedTags = searchTags.stream().collect(Collectors.partitioningBy(SearchTag::shouldExclude));
        List<Tag> excludedTags = partitionedTags.get(true).stream().map(SearchTag::getTag).collect(Collectors.toList());
        List<Tag> includedTags = partitionedTags.get(false).stream().map(SearchTag::getTag).collect(Collectors.toList());
        return contentManager.getAllContent().stream()
                .filter(content -> !containsTags(content, excludedTags))
                .filter(content -> containsTags(content, includedTags))
                .collect(Collectors.toList());
    }

    public List<Content> searchByRawTags(List<String> rawTags) {
        List<SearchTag> tags = rawTags.stream().map(this::getSearchTag).collect(Collectors.toList());
        return searchByTags(tags);
    }
}
