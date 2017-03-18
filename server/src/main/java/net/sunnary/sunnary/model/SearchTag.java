package net.sunnary.sunnary.model;

public class SearchTag {
    private Tag tag;
    private boolean shouldExclude;

    public SearchTag(Tag tag, boolean shouldExclude) {
        this.tag = tag;
        this.shouldExclude = shouldExclude;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public boolean shouldExclude() {
        return shouldExclude;
    }

    public void setShouldExclude(boolean shouldExclude) {
        this.shouldExclude = shouldExclude;
    }
}
