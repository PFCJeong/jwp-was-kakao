package controllers;

import http.HttpRequest;
import http.HttpRequestParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ControllersTest {
    String homeRequest = "GET /index.html HTTP/1.1\n" +
            "Host: localhost:8080\n" +
            "Connection: keep-alive\n" +
            "Accept: */*";
    String userRequest = "POST /user/create HTTP/1.1\n" +
            "Host: localhost:8080\n" +
            "Connection: keep-alive\n" +
            "Content-Length: 59\n" +
            "Content-Type: application/x-www-form-urlencoded\n" +
            "Accept: */*\n" +
            "\n" +
            "userId=wonsik&password=1234&name=wonsik&email=wonsik@kakaocorp.com";

    HttpRequestParser parser = new HttpRequestParser();

    @BeforeEach
    void setUp() {
        parser = new HttpRequestParser();

    }

    @DisplayName("Request를 처리할 알맞은 컨트롤러를 리턴하는지 테스트")
    @Test
    void testFindController() {
        parser.parse(homeRequest);
        HttpRequest homeGetRequest = new HttpRequest(parser.getHttpMethod(), parser.getUri(), parser.getRequestHeaders(), parser.getBody());

        assertThat(Controllers.getResponsibleController(homeGetRequest) instanceof HomeController).isTrue();
        assertThat(Controllers.getResponsibleController(homeGetRequest) instanceof UserController).isFalse();

        parser.parse(userRequest);
        HttpRequest userPostRequest = new HttpRequest(parser.getHttpMethod(), parser.getUri(), parser.getRequestHeaders(), parser.getBody());

        assertThat(Controllers.getResponsibleController(userPostRequest) instanceof UserController).isTrue();
        assertThat(Controllers.getResponsibleController(userPostRequest) instanceof HomeController).isFalse();
    }
}