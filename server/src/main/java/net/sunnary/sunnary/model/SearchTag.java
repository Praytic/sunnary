package net.sunnary.sunnary.model;

public class SearchTag {
    private Tag tag;
    private boolean exclude;

    public SearchTag(Tag tag) {
        this.tag = tag;
        this.exclude = false;
    }

    public SearchTag(Tag tag, boolean exclude) {
        this.tag = tag;
        this.exclude = exclude;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public boolean shouldExclude() {
        return exclude;
    }

    public void shouldExclude(boolean exclude) {
        this.exclude = exclude;
    }
}
