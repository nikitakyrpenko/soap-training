package com.resource.soap.repository;

import training.soap.schema.user_account_api.User;

public interface UserRepository {

    User findById(Integer id);

    User save(User user);

}
