package micronaut.bug.bson.discriminator;

import io.micronaut.test.annotation.MicronautTest;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MicronautTest
class AnimalRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(AnimalRepositoryTest.class);

    @Inject
    AnimalRepository animalRepository;

    @Test
    void insertThenRead() {

        Animal cat = animalRepository.insert(new Cat());
        Animal dog = animalRepository.insert(new Dog());
        List<Animal> catList = animalRepository.findByType(Cat.TYPE);
        log.info("{} cats in the DB", catList.size());
        Assertions.assertFalse(catList.isEmpty());
    }

    @Test
    void readWithoutInsertingFirst() {
        List<Animal> catList = animalRepository.findByType(Cat.TYPE);
        Assertions.assertFalse(catList.isEmpty());
    }
}