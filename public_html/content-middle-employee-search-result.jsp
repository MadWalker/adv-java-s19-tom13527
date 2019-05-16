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
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>SSN</th>
                        <th>Department</th>
                        <th>Room Number</th>
                        <th>Phone Number</th>
                    </tr>
                        <c:choose>
                            <c:when test="${(foundBoolean)}">
                                <c:forEach var="listofResults" items="${(employeeSearchResults)}">
                                    <tr>
                                        <td>${listofResults.employeeId}</td>
                                        <td>${listofResults.firstName}</td>
                                        <td>${listofResults.lastName}</td>
                                        <td>${listofResults.socialSecurityNumber}</td>
                                        <td>${listofResults.department}</td>
                                        <td>${listofResults.roomNumber}</td>
                                        <td>${listofResults.phoneNumber}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <p>Sorry, no employees were found.</p>
                            </c:otherwise>
                        </c:choose>
                </table>
                <blockquote>
                </blockquote>
                <a href="/java112">Home</a>
            </div>
        </div>
    </div>
</div>
