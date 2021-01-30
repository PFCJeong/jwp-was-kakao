package controllers;

import http.HttpRequest;
import org.springframework.http.HttpMethod;

public class Requests {
    public static final HttpRequest[] HOME = {
            new HttpRequest(HttpMethod.GET, "/index.html")
    };

    public static final HttpRequest[] USER = {
            new HttpRequest(HttpMethod.GET, "/user/form.html"),
            new HttpRequest(HttpMethod.GET, "/user/list.html"),
            new HttpRequest(HttpMethod.GET, "/user/login.html"),
            new HttpRequest(HttpMethod.GET, "/user/login_failed.html"),
            new HttpRequest(HttpMethod.GET, "/user/profile.html"),
            new HttpRequest(HttpMethod.POST, "/user/create")
    };
}
