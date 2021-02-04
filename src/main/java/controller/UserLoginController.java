package controller;

import annotation.web.RequestMethod;
import db.DataBase;
import model.User;
import utils.HttpUtils;
import webserver.Controller;
import webserver.Model;
import webserver.http.HttpRequest;
import webserver.http.HttpResponse;

import java.util.Map;

public class UserLoginController extends Controller {
    public UserLoginController() {
        super(RequestMethod.POST, "/user/login");
    }

    @Override
    public boolean canHandle(HttpRequest request) {
        return request.getRequestMethod() == requestMethod && request.getUri().equals(uri);
    }

    @Override
    public String handleRequest(HttpRequest request, HttpResponse httpResponse, Model model) {
        Map<String, String> params = HttpUtils.getParamMap(request.getBody());

        User user = DataBase.findUserById(params.get("userId"));
        if (user != null && user.getPassword().equals(params.get("password"))) {
            httpResponse.addCookie("logined=true; Path=/");
            return "redirect:/index.html";
        }
        httpResponse.addCookie("logined=false; Path=/");
        return "redirect:/user/login_failed.html";
    }
}
