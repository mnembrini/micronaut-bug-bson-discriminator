package micronaut.bug.bson.discriminator;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;

@BsonDiscriminator(value = Dog.TYPE, key = Animal.DISCRIMINATOR_KEY)
public class Dog extends Animal {
    public static final String TYPE = "Dog";

    public Dog() {
        super(TYPE);
    }
}
