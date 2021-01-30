package controllers;

import http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;

public class HomeController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    public HomeController(HttpRequest[] requests) {
        super(requests);
    }

    @Override
    public void handleRequest(HttpRequest request, DataOutputStream dos) {
        // TODO: 2021/01/31 요청 처리
    }
}
