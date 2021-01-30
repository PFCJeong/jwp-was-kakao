package controllers;

import http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import java.io.DataOutputStream;

public class HomeController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    public HomeController(HttpRequest[] requests) {
        super(requests);
    }

    @Override
    public void handleRequest(HttpRequest request, DataOutputStream dos) {
        if(request.getHttpMethod() == HttpMethod.GET && request.getUri().endsWith(".html")) {
            responseHtml(request.getUri(), dos);
        }
    }
}
