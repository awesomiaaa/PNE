package com.example.deguzman.plantease;

public class UserList {
    private String name;
    private String email;
    private String password;

    public String getUsername() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }


    public UserList(String username, String email, String password) {
       this.name = username;
       this.email = email;
       this.password = password;


    }
}
