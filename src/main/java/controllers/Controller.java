package controllers;

import http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.FileIoUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public abstract class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

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

    protected void responseHtml(String uri, DataOutputStream dos) {
        try {
            byte[] body = FileIoUtils.loadFileFromClasspath("./templates" + uri);
            response200Header(dos, body.length);
            responseBody(dos, body);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void response200Header(DataOutputStream dos, int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
