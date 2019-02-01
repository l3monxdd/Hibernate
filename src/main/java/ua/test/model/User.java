package ua.test.model;

public class User {
    private int id;
    private String name;

    public User() {
    }

    public int getId() {
        return id;
    }

    public User(String name) {
        this.name = name;
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
}
