package com.resource.soap.endpoint;

import com.resource.soap.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import training.soap.schema.user_account_api.*;

@Endpoint
public class AccountEndpoint {

    private static final String NAMESPACE_URI = "http://soap.training/schema/user-account-api";

    private final AccountRepository accountRepository;

    @Autowired
    public AccountEndpoint(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountByIdRequest")
    @ResponsePayload
    public GetAccountByIdResponse findById(@RequestPayload GetAccountByIdRequest request){
        Integer id = request.getAccountId();

        Account account = accountRepository.findById(id);

        GetAccountByIdResponse response = new GetAccountByIdResponse();
        response.setAccount(account);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postAccountRequest")
    @ResponsePayload
    public PostAccountResponse findById(@RequestPayload PostAccountRequest request){

        Account saved = accountRepository.save(request.getAccount());

        PostAccountResponse response = new PostAccountResponse();
        response.setAccount(saved);

        return response;
    }
}
