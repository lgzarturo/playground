package models;

import com.google.common.base.Objects;

public class PersonBestPractice {
    private final String name;
    private final int age;

    public PersonBestPractice(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public PersonBestPractice(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonBestPractice that = (PersonBestPractice) o;
        return age == that.age &&
                Objects.equal(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age);
    }

    public static class Builder{

        private String name;
        private int age;

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public PersonBestPractice build(){
            return new PersonBestPractice(this);
        }

    }
}
