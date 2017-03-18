package net.sunnary.sunnary.manager;

import net.sunnary.sunnary.dto.ArticleSubmissionForm;
import net.sunnary.sunnary.model.Article;
import net.sunnary.sunnary.model.Tag;
import net.sunnary.sunnary.repository.ArticleRepository;
import net.sunnary.sunnary.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class ArticleManager {
    private ArticleRepository articleRepository;

    private TagRepository tagRepository;

    @Autowired
    public ArticleManager(ArticleRepository articleRepository,
                          TagRepository tagRepository) {
        this.articleRepository = articleRepository;
        this.tagRepository = tagRepository;
    }

    @Transactional
    public void insertArticleFromForm(ArticleSubmissionForm form) {
        Article article = new Article(form);

        for (String tagString : form.getTags()) {
            Tag tag = tagRepository.findOne(tagString);

            if (tag == null) {
                tag = new Tag();
                tag.setId(tagString);
                tagRepository.save(tag);
            }

            article.getTags().add(tag);
            article.setSubmissionDate(new Date());
        }

        articleRepository.save(article);
    }

    @Transactional(readOnly = true)
    public List<Article> getAllArticles() {
        return articleRepository.findAllFetchEager();
    }

    @Transactional
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
