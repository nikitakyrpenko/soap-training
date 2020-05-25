package com.resource.soap.repository;

import training.soap.schema.user_account_api.Account;

public interface AccountRepository {

    Account findById(Integer id);

    Account save(Account account);

}
