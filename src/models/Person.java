package models;

import java.util.Objects;

public abstract class Person implements Comparable<Person>{
    protected Integer id;
    protected String name;


    public Person(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public int compareTo(Person person) {
        if(this.name.equals(person.getName())) {
            return this.id.compareTo(person.getId());
        } else {
            return this.name.compareTo(person.getName());
        }
    } //ordered by name and if they have the same name, ordered by id;


}
