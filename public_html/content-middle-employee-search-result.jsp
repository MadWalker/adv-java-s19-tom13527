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
                Search for an Employee - Results
            </h2>
            <h3 class="posted">
                Posted on May 2nd, 2019 by Tom Good
            </h3>
            <div class="story">
                <table>
                    <tr>
                        <th>Results:</th>
                    </tr>
                    <tr>
                        <c:forEach var="listofResults" items="${employeeIdSearchResults}">
                            <td>${listofResults}</td>
                        </c:forEach>
                    </tr>
                </table>
                <blockquote>
                </blockquote>
                <a href="/java112">Home</a>
            </div>
        </div>
    </div>
</div>
