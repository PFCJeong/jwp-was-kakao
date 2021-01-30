package controllers;

import http.HttpRequest;

import java.util.Arrays;

public class Controllers {
    private static Controller[] controllers = new Controller[] {
            new HomeController(Requests.HOME),
            new UserController(Requests.USER)
    };

    public static Controller getResponsibleController(HttpRequest request) {
        return Arrays.stream(controllers)
                .filter(it -> it.canHandleRequest(request))
                .findFirst()
                .orElse(null);
    }
}
