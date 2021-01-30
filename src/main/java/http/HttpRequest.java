package http;

import org.springframework.http.HttpMethod;

public class HttpRequest {
    private HttpMethod httpMethod;
    private String uri;
    private HttpRequestHeaders httpRequestHeaders;
    private String body;

    public HttpRequest(HttpMethod httpMethod, String uri, HttpRequestHeaders httpRequestHeaders, String body) {
        this.httpMethod = httpMethod;
        this.uri = uri;
        this.httpRequestHeaders = httpRequestHeaders;
        this.body = body;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getUri() {
        return uri;
    }

    public HttpRequestHeaders getRequestHeaders() {
        return httpRequestHeaders;
    }

    public String getBody() {
        return body;
    }

}
