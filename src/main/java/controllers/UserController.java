package controllers;

import db.DataBase;
import http.HttpRequest;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import utils.HttpUtils;

import java.io.DataOutputStream;
import java.util.Map;

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
        if (request.getHttpMethod() == HttpMethod.POST && request.getUri().equals("/user/create")) {
            handleRegistration(request, dos);
        }
    }

    private void handleRegistration(HttpRequest request, DataOutputStream dos) {
        Map<String, String> params = HttpUtils.getParamMap(request.getBody());
        User user = new User(params.get("userId"), params.get("password"), params.get("name"), params.get("email"));
        DataBase.addUser(user);

        responseRedirectedHtml(dos, "/index.html");
    }

}
