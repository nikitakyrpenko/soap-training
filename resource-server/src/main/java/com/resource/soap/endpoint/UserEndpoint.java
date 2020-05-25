package com.resource.soap.endpoint;

import com.resource.soap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import training.soap.schema.user_account_api.*;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://soap.training/schema/user-account-api";

    private final UserRepository userRepository;

    @Autowired
    public UserEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByIdRequest")
    @ResponsePayload
    public GetUserByIdResponse getUserById(@RequestPayload GetUserByIdRequest userRequest){
        Integer requestId = userRequest.getId();

        User user = userRepository.findById(requestId);

        GetUserByIdResponse getUserResponse = new GetUserByIdResponse();
        getUserResponse.setUser(user);

        return getUserResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postUserRequest")
    @ResponsePayload
    public PostUserResponse saveUser(@RequestPayload PostUserRequest userRequest){
        User user = userRepository.save(userRequest.getUser());

        PostUserResponse postUserResponse = new PostUserResponse();
        postUserResponse.setUserId(user);

        return postUserResponse;
    }

}
