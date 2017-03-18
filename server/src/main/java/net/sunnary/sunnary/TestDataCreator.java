package net.sunnary.sunnary;

import net.sunnary.sunnary.model.Article;
import net.sunnary.sunnary.model.Tag;
import net.sunnary.sunnary.repository.ArticleRepository;
import net.sunnary.sunnary.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class TestDataCreator {
    private static final Logger log = LoggerFactory.getLogger(TestDataCreator.class);

    private ArticleRepository articleRepository;
    private TagRepository tagRepository;

    @Autowired
    public TestDataCreator(ArticleRepository articleRepository,
                           TagRepository tagRepository) {
        this.articleRepository = articleRepository;
        this.tagRepository = tagRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {
        List<Tag> tags = new ArrayList<Tag>(Arrays.asList(
                new Tag("java"),
                new Tag("C#"),
                new Tag("JavaScript"),
                new Tag("RandomCrap"),
                new Tag("CPewPew"),
                new Tag("Wut"),
                new Tag("Beginner"),
                new Tag("Advanced"),
                new Tag("Intermediate")
        ));

        tagRepository.save(tags);

        Random random = new Random();

        List<String> wordPool = new ArrayList<>(Arrays.asList(
                "Apple", "Pear", "Crap", "Black", "White",
                "Green", "Purple", "Developing", "Testing", "Debugging",
                "Applying", "Dying", "Code", "Program", "Java", "Maven",
                "Ticket", "Deadlock", "Apache", "Tomcat",
                "Duck", "Goose", "Cow", "Sheep", "Cat", "Dog",
                "Bird", "Parrot", "Bull", "Male", "Female"
        ));

        for (int i=0; i<10; i++) {
            Article article = new Article();

            int numSteps = random.nextInt(3) + 2;
            for (int j=0; j<numSteps; j++) {
                article.getTags().add(tags.get(random.nextInt(tags.size())));
            }

            int numWords = random.nextInt(3) + 4;
            String name = "";
            for (int j=0; j<numWords; j++) {
                name += wordPool.get(random.nextInt(wordPool.size()));

                if (j != numWords - 1) {
                    name += " ";
                }
            }

            article.setName(name);
            article.setTargetUrl("http://google.com");
            article.setSubmissionDate(new Date());
            articleRepository.save(article);
            log.info("Adding article " + article.getName() + " with tags " + article.getTags().toString());
        }
    }
}
