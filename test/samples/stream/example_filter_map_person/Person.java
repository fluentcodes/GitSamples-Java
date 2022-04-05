package samples.stream.example_filter_map_person;

import java.time.LocalDate;

/**
 * Beispielklasse zur Modellierung einer Person.
 */
public class Person {
    final String name;
    final LocalDate birthday;
    final int age;

    private final Gender gender;

    private String favoriteColor = null;

    public Person(String name, int age, LocalDate birthday) {
        this(name, age, birthday, Gender.MALE);
    }

    public Person(final String name, final int age, final LocalDate birthday, final Gender gender) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(final String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getName()
    {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return "Person [name = " + name + " / birthday = " + birthday + " / favoriteColor = " + favoriteColor + "]";
    }
}
