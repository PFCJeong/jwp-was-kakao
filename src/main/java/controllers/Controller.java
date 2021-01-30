package controllers;

import http.HttpRequest;

import java.io.DataOutputStream;
import java.util.Arrays;

public abstract class Controller {
    private HttpRequest[] requests;

    public Controller(HttpRequest[] requests) {
        this.requests = requests;
    }

    public abstract void handleRequest(HttpRequest request, DataOutputStream dos);

    public boolean canHandleRequest(HttpRequest request) {
        long matchCount = Arrays.stream(requests)
                .filter(it -> it.hasSameRequestLine(request))
                .count();
        return matchCount != 0;
    }

}
