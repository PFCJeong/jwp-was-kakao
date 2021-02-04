package controller;

import annotation.web.RequestMethod;
import db.DataBase;
import webserver.Controller;
import webserver.Model;
import webserver.http.HttpRequest;
import webserver.http.HttpResponse;

public class UserListController extends Controller {
    public UserListController() {
        super(RequestMethod.GET, "/user/list");
    }

    @Override
    public boolean canHandle(HttpRequest request) {
        return request.getRequestMethod() == requestMethod && request.getUri().equals(uri);
    }

    @Override
    public String handleRequest(HttpRequest request, HttpResponse response, Model model) {
        String logined = request.getRequestHeaders().getHeader("Cookie");
        if ("logined=true".equals(logined)) {
            model.addAttribute("users", DataBase.findAll());
            return "/user/list";
        } else {
            return "redirect:/user/login.html";
        }
    }
}
