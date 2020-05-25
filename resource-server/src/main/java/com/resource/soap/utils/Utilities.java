package com.resource.soap.utils;

import training.soap.schema.user_account_api.Account;
import training.soap.schema.user_account_api.Role;
import training.soap.schema.user_account_api.User;

public class Utilities {

    public static Object provideObjectByClass(Class<?> klass){
        User user = new User();

        user.setId(1);
        user.setFirstName("foo");
        user.setLastName("bar");
        user.setEmail("foo@bar.com");
        user.setPassword("p@ssword");
        user.setRole(Role.ROLE_CLIENT);

        if (klass == Account.class){
           Account account = new Account();
           account.setId(1);
           account.setBalance(100);
           account.setCharge(0.13F);
           account.setUser(user);

           return account;
        }
        return user;
    }

}
