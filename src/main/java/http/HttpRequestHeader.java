package http;

public class HttpRequestHeader {
    private String headerName;
    private String headerContent;

    private HttpRequestHeader(String headerName, String headerContent) {
        this.headerName = headerName;
        this.headerContent = headerContent;
    }

    public static HttpRequestHeader of(String headerLine) {
        String[] parsedLine = headerLine.split(" ", 2);
        String name = parsedLine[0].replace(":", "");
        String header = parsedLine[1];

        return new HttpRequestHeader(name, header);
    }

    public String getHeaderName() {
        return headerName;
    }

    public String getHeaderContent() {
        return headerContent;
    }
}
