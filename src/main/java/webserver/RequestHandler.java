package webserver;

import java.io.*;
import java.net.Socket;

import controllers.Controller;
import controllers.Controllers;
import http.HttpRequestParser;
import http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.IOUtils;

public class RequestHandler implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    private Socket connection;
    private HttpRequestParser parser = new HttpRequestParser();

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        logger.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(),
                connection.getPort());

        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            String request = IOUtils.buildString(in);
            parser.parse(request);
            HttpRequest httpRequest = new HttpRequest(parser.getHttpMethod(), parser.getUri(), parser.getRequestHeaders(), parser.getBody());

            Controller controller = Controllers.getResponsibleController(httpRequest);
            if (controller == null) {
                // TODO: 2021/01/31 NOT_FOUND 리스폰스
                return;
            }
            controller.handleRequest(httpRequest, new DataOutputStream(out));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
