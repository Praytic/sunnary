package net.sunnary.sunnary;

import net.sunnary.sunnary.model.Content;
import net.sunnary.sunnary.model.Tag;
import net.sunnary.sunnary.repository.ContentRepository;
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

    private ContentRepository contentRepository;
    private TagRepository tagRepository;

    @Autowired
    public TestDataCreator(ContentRepository contentRepository,
                           TagRepository tagRepository) {
        this.contentRepository = contentRepository;
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
            Content content = new Content();

            int numSteps = random.nextInt(3) + 2;
            for (int j=0; j<numSteps; j++) {
                content.getTags().add(tags.get(random.nextInt(tags.size())));
            }

            int numWords = random.nextInt(3) + 4;
            String name = "";
            for (int j=0; j<numWords; j++) {
                name += wordPool.get(random.nextInt(wordPool.size()));

                if (j != numWords - 1) {
                    name += " ";
                }
            }

            content.setName(name);
            content.setTargetUrl("http://google.com");
            content.setSubmissionDate(new Date());
            content.setType(i % 2 == 0 ? Content.Type.ARTICLE : Content.Type.TOOL);
            contentRepository.save(content);
            log.info("Adding content " + content.getName() + " with tags " + content.getTags().toString());
        }
    }
}
