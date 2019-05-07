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
                <form method="GET" action="/java112/searchEmployees">
                    <input type="text" name="searchTerm" /><br />
                    <br />
                    Search Type:
                    <input type="radio" name="searchType" value="employeeId" checked/>ID<br />
                    <!--<input type="radio" name="searchType" value="firstName" />First Name<br />
                    <input type="radio" name="searchType" value="lastName" />Last Name<br />-->
                    <br />
                    <input type="submit" name="submit" value="Enter" />
                </form>
                <blockquote>
                </blockquote>
                <a href="/java112">Home</a>
            </div>
        </div>
    </div>
</div>
