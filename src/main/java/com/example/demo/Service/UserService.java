package com.example.demo.Service;

import com.example.demo.Model.User;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private Map<String,User> users = new HashMap<>();

    public UserService() {
        users.put("Aidyn",new User("aid", "password1"));
        users.put("Beknnur",new User("beka", "password2"));
        users.put("Nurlan",new User("nura", "password3"));
        users.put("Galym",new User("gako", "password4"));

    }
    public boolean tekseriu(String name,String password) {
        User user = users.get(name);
        return user != null && user.getPassword().equals(password);
    }
    public Optional<User> getUser(String name) {
        return Optional.ofNullable(users.get(name));
    }
}
