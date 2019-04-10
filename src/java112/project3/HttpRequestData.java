package java112.project3;

/**
    This javabean will contain variables for multiple http request parametes

    @author Tom Good
*/
public class HttpRequestData {

    private String remoteComputerName;
    private String addressOfRemoteComputer;
    private String httpMethodOfRequest;
    private String requestURI;
    private String requestURL;
    private String protocolOfRequest;
    private String serverName;
    private int serverPortNumber;
    private String localeOfServer;
    private String queryString;
    private String queryParameter;// = "queryParameter";
    private String requestHeader;// = "User-Agent";


    // Zero parameter Constructor
    public HttpRequestData() {

    }

    /**
        Gets the remote computer name of the remoteComputerName object

        @return    The address of the remote computer
    */
    public String getAddressOfRemoteComputer() {
        return remoteComputerName;
    }
    /**
        Gets the remote computer name of the remoteComputerName object

        @return The remote computer name
    */
    public String getRemoteComputerName() {
        return remoteComputerName;
    }
    /**
        Gets the http method of request

        @return The HTTP method of request
    */
    public String getHttpMethodOfRequest() {
        return httpMethodOfRequest;
    }
    /**
        Gets the request URI

        @return The request URI
    */
    public String getRequestURI() {
        return requestURI;
    }
    /**
        Gets the request URL

        @return The request URL
    */
    public String getRequestURL() {
        return requestURL;
    }
    /**
        Gets the protocol of request

        @return The protocol of request
    */
    public String getProtocolOfRequest() {
        return protocolOfRequest;
    }
    /**
        Gets the server name

        @return The server name
    */
    public String getServerName() {
        return serverName;
    }
    /**
        Gets the server port number

        @return The server port number
    */
    public int getServerPortNumber() {
        return serverPortNumber;
    }
    /**
        Gets the locale of the server

        @return The locale of the server
    */
    public String getLocaleOfServer() {
        return localeOfServer;
    }
    /**
        Gets the query string

        @return The query string
    */
    public String getQueryString() {
        return queryString;
    }
    /**
        Gets the query parameter

        @return The query parameter
    */
    public String getQueryParameter() {
        return queryParameter;
    }
    /**
        Gets the request header

        @return The request header
    */
    public String getRequestHeader() {
        return requestHeader;
    }

    /**
        Sets the remote computer name

        @param  remoteComputerName name of the remote computer
     */
    public void setRemoteComputerName(String remoteComputerName) {
        this.remoteComputerName = remoteComputerName;
    }
    /**
        Sets the address of the remote computer

        @param addressOfRemoteComputer address of the remote computer
    */
    public void setAddressOfRemoteComputer(String addressOfRemoteComputer) {
        this.addressOfRemoteComputer = addressOfRemoteComputer;
    }
    /**
        Sets the http method of request

        @param httpMethodOfRequest The HTTP method of request
    */
    public void setHttpMethodOfRequest(String httpMethodOfRequest) {
        this.httpMethodOfRequest = httpMethodOfRequest;
    }
    /**
        Sets the request URI

        @param requestURI The request URI
    */
    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }
    /**
        Sets the request URL

        @param requestURL The request URL
    */
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
    /**
        Sets the protocol of request

        @param protocolOfRequest The protocol of request
    */
    public void setProtocolOfRequest(String protocolOfRequest) {
        this.protocolOfRequest = protocolOfRequest;
    }
    /**
        Sets the server name

        @param serverName The server name
    */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
    /**
        Sets the server port number

        @param serverPortNumber The server port number
    */
    public void setServerPortNumber(int serverPortNumber) {
        this.serverPortNumber = serverPortNumber;
    }
    /**
        Sets the locale of the server

        @param localeOfServer The locale of the server
    */
    public void setLocaleOfServer(String localeOfServer) {
        this.localeOfServer = localeOfServer;
    }
    /**
        Sets the query string

        @param queryString The query string
    */
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }
    /**
        Sets the query parameter

        @param queryParameter The query parameter
    */
    public void setQueryParameter(String queryParameter) {
        this.queryParameter = queryParameter;
    }
    /**
        Sets the request header

        @param requestHeader The request header
    */
    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

}
