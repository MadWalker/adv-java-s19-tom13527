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
                Search for an Employee
            </h2>
            <h3 class="posted">
                Posted on May 2nd, 2019 by Tom Good
            </h3>
            <div class="story">
                <form method="GET" action="/searchEmployees">
                    Search Term:<br>
                    <input type="text" name="searchTerm"><br>
                    Search Type:<br>
                    <input type="radio" name="searchType" value="id" checked> Employee Id<br>
                    <input type="radio" name="searchType" value="lastName"> Last Name<br>
                    <input type="radio" name="searchType" value="firstName"> First Name<br>
                    <input type="submit" value="Submit">
                </form>
                <blockquote>
                </blockquote>
                <a href="/java112">Home</a>
            </div>
        </div>
    </div>
</div>
