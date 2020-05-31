package com.resource.soap.repository.impl;


import com.resource.soap.repository.UserRepository;
import com.resource.soap.utils.Utilities;
import org.springframework.stereotype.Component;
import training.soap.schema.user_account_api.User;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleInMemoryUserRepository implements UserRepository {

    private final Map<Integer, User> idToUser = new HashMap<>();

    public SimpleInMemoryUserRepository(){
        User user = (User) Utilities.provideObjectByClass(User.class);

        idToUser.put(user.getId(), user);
    }


    @Override
    public User findById(Integer id) {
        return idToUser.get(id);
    }

    @Override
    public User save(User user) {
        int id = idToUser.size() + 1;

        user.setId(id);

        idToUser.put(id, user);
        return user;
    }
}
