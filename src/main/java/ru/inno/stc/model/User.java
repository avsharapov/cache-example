package ru.inno.stc.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private int    id;
    private String name;
    private String phone;

    public User(int id, String name, String phone) {
        this.id    = id;
        this.name  = name;
        this.phone = phone;
    }

    public int getId() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", phone='" + phone + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return id == user.id &&
               Objects.equals(name, user.name) &&
               Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone);
    }
}
