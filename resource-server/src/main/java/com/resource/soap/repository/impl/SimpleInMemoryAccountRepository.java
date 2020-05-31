package com.resource.soap.repository.impl;


import com.resource.soap.repository.AccountRepository;
import com.resource.soap.utils.Utilities;
import org.springframework.stereotype.Component;
import training.soap.schema.user_account_api.Account;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleInMemoryAccountRepository implements AccountRepository {

    private Map<Integer, Account> idToAccount = new HashMap<>();

    public SimpleInMemoryAccountRepository(){
        Account account = (Account) Utilities.provideObjectByClass(Account.class);

        idToAccount.put(account.getId(), account);
    }

    public Account findById(Integer id){
        return idToAccount.get(id);
    }

    public Account save(Account account){
        Integer id = idToAccount.size() + 1;

        account.setId(id);

        idToAccount.put(id, account);
        return account;
    }

}
