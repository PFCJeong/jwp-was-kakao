package controllers;

import db.DataBase;
import http.HttpRequest;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import java.io.DataOutputStream;

public class UserController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(HttpRequest[] requests) {
        super(requests);
    }

    @Override
    public void handleRequest(HttpRequest request, DataOutputStream dos) {
        if (request.getHttpMethod() == HttpMethod.GET && request.getUri().endsWith(".html")) {
            responseHtml(request.getUri(), dos);
            return;
        }
        if (request.getHttpMethod() == HttpMethod.GET && request.getUri().equals("/user/create")) {
            handleRegistration(request, dos);
        }
    }

    private void handleRegistration(HttpRequest request, DataOutputStream dos) {
        User user = new User(request.getParam("userId"),
                request.getParam("password"),
                request.getParam("name"),
                request.getParam("email"));
        DataBase.addUser(user);
    }

}
