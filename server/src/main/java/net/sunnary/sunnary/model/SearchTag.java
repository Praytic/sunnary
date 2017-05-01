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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchTag searchTag = (SearchTag) o;

        if (exclude != searchTag.exclude) return false;
        return tag != null ? tag.equals(searchTag.tag) : searchTag.tag == null;
    }

    @Override
    public int hashCode() {
        int result = tag != null ? tag.hashCode() : 0;
        result = 31 * result + (exclude ? 1 : 0);
        return result;
    }
}
