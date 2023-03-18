package com.proj.MusicPlayer.modals;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "users")
public class UserDetailModal {

    @Id
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String id;
    private String name, email, password, age,phone;

    @DBRef
    private Set<RolesModal> roles;

    public UserDetailModal(String id, String name, String email, String password, String age, String phone, Set<RolesModal> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.roles = roles;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<RolesModal> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolesModal> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String dob) {
        this.age = dob;
    }
}
