package http;

import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private HttpMethod httpMethod;
    private String uri;
    private Map<String, String> params = new HashMap<>();
    private HttpRequestHeaders httpRequestHeaders;
    private String body;

    public HttpRequest(HttpMethod httpMethod, String uri) {
        this.httpMethod = httpMethod;
        parseUri(uri);
    }

    public HttpRequest(HttpMethod httpMethod, String uri, HttpRequestHeaders httpRequestHeaders, String body) {
        this(httpMethod, uri);
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

    public String getParam(String key) {
        return params.get(key);
    }

    public boolean hasSameRequestLine(HttpRequest request) {
        return httpMethod == request.httpMethod && uri.equals(request.uri);
    }

    private void parseUri(String uri) {
        String[] parsedUri = uri.split("\\?", 2);
        this.uri = parsedUri[0];
        if(parsedUri.length < 2) {
            return;
        }
        for(String param : parsedUri[1].split("&")) {
            params.put(param.split("=")[0], param.split("=")[1]);
        }
    }
}
