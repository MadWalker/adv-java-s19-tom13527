<body>
    <div id="header">
        <h1>
            Tom's Home Page
        </h1>
        <h2>
        </h2>
    </div>
    <div id="content">
        <div id="posts">
            <div class="post">
                <h2 class="title">
                    Welcome to Tom's Project Home Page!
                </h2>
                <h3 class="posted">
                    Created on March 7h, 2019 by Tom Good
                </h3>
                <div class="story">
                </div>
                <div class="meta">
                </div>
            </div>
            <div class="post">
                <h2 class="title">
                    Http Request Servlet for Project 3
                </h2>
                <h3 class="posted">
                    Posted on April 10th, 2019 by Tom Good
                </h3>
                <div class="story">
                    <ol>
                        <li>
                            Remote Computer Name: ${myRequestBean.remoteComputerName}
                        </li>
                        <li>
                            Address of Computer Name: ${myRequestBean.addressOfRemoteComputer}
                        </li>
                        <li>
                            Http Mehtod of Request: ${myRequestBean.httpMethodOfRequest}
                        </li>
                        <li>
                            Request URI: ${myRequestBean.requestURI}
                        </li>
                        <li>
                            Request URL: ${myRequestBean.requestURL}
                        </li>
                        <li>
                            Protocol of Request: ${myRequestBean.protocolOfRequest}
                        </li>
                        <li>
                            Server Name: ${myRequestBean.serverName}
                        </li>
                        <li>
                            Server Port Number: ${myRequestBean.serverPortNumber}
                        </li>
                        <li>
                            Locale of Server: ${myRequestBean.localeOfServer}
                        </li>
                        <li>
                            Query String: ${myRequestBean.queryString}
                        </li>
                        <li>
                            Query Parameter: ${myRequestBean.queryParameter}
                        </li>
                        <li>
                            Request Header: ${myRequestBean.requestHeader}
                        </li>
                    </ol>
                    <blockquote>
                    </blockquote>
                    <a href="/java112">Home</a>
                </div>
            </div>
        </div>
    </div>
