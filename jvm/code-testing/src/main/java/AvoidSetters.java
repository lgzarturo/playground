import com.google.common.collect.ImmutableMap;
import models.Person;
import models.PersonBestPractice;

import java.util.HashMap;
import java.util.Map;

public class AvoidSetters {
    public static void main(String[] args) {
        testPerson();
        testPersonBestPractice();
    }

    public static void testPerson() {
        Person jack = new Person();
        jack.setName("Jack");
        jack.setAge(23);

        Person julia = new Person();
        julia.setName("Julia");
        julia.setAge(35);

        Map<Person, Integer> map = new HashMap<>();
        map.put(jack, 35);
        map.put(julia, 65);

        System.out.println("Map: " + map);
        jack.setAge(55); // key corrupting
        System.out.println("Corrupted map: " + map);
        System.out.println("Jack's rate: " + map.get(jack));
        System.out.println("Julia's rate: " + map.get(julia));
    }

    public static void testPersonBestPractice() {
        PersonBestPractice jack = new PersonBestPractice("Jack", 23);
        PersonBestPractice julia = new PersonBestPractice("Julia", 35);

        Map<PersonBestPractice, Integer> map = new HashMap<>();
        map.put(jack, 35);
        map.put(julia, 65);

        ImmutableMap<PersonBestPractice, Integer> imap =
                ImmutableMap.<PersonBestPractice, Integer>builder()
                        .put(jack, 35)
                        .put(julia, 65)
                        .build();

        System.out.println("Map: " + imap);
        jack = new PersonBestPractice.Builder("arturo", 23).setAge(30).build();
        System.out.println("Corrupted map: " + imap);
        System.out.println("Jack's rate: " + imap.get(jack));
        System.out.println("Julia's rate: " + imap.get(julia));
    }
}
