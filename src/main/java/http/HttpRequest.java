package http;

import annotation.web.RequestMethod;
import utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private RequestMethod requestMethod;
    private String uri;
    private Map<String, String> params;
    private HttpRequestHeaders httpRequestHeaders;
    private String body;

    public HttpRequest(RequestMethod requestMethod, String uri, Map<String, String> params, HttpRequestHeaders httpRequestHeaders, String body) {
        this.requestMethod = requestMethod;
        this.uri = uri;
        this.params = params;
        this.httpRequestHeaders = httpRequestHeaders;
        this.body = body;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
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

    public boolean sameRequestLine(HttpRequest httpRequest) {
        return requestMethod.equals(httpRequest.requestMethod) && uri.equals(httpRequest.uri);
    }

    public boolean isTemplateRequest() {
        return requestMethod == RequestMethod.GET && uri.endsWith(".html");
    }

    public boolean isStaticRequest() {
        return requestMethod
                == RequestMethod.GET && (uri.startsWith("/css") || uri.startsWith("/fonts") || uri.startsWith("/images") || uri.startsWith("/js"));
    }
}