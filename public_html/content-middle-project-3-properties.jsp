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
                    Properties for Project 3
                </h2>
                <h3 class="posted">
                    Posted on April 11th, 2019 by Tom Good
                </h3>
                <div class="story">
                    <table>
                        <tr>
                            <td>Author: </td>
                            <td>${project3Properties.getProperty("author")}</td>
                        </tr>
                        <tr>
                            <td>Author Email: </td>
                            <td>${project3Properties.getProperty("author.email.address")}</td>
                        </tr>
                        <tr>
                            <td>Course Title: </td>
                            <td>${project3Properties.getProperty("course.title")}</td>
                        </tr>
                        <tr>
                            <td>Course Meeting Date and Time: </td>
                            <td>${project3Properties.getProperty("course.meeting.date.and.time")}</td>
                        </tr>
                        <tr>
                            <td>Instructor Name: </td>
                            <td>${project3Properties.getProperty("instructor.name")}</td>
                        </tr>
                        <tr>
                            <td>Project Description: </td>
                            <td>${project3Properties.getProperty("project.description")}</td>
                        </tr>
                        <tr>
                            <td>Driver Class: </td>
                            <td>${project4Properties.getProperty("driver")}</td>
                        </tr>
                        <tr>
                            <td>Url: </td>
                            <td>${project4Properties.getProperty("url")}</td>
                        </tr>
                        <tr>
                            <td>Username: </td>
                            <td>${project4Properties.getProperty("username")}</td>
                        </tr>
                        <tr>
                            <td>Password: </td>
                            <td>${project4Properties.getProperty("password")}</td>
                        </tr>
                    </table>
                    <a href="/java112">Home</a>
                    <blockquote>
                    </blockquote>
                </div>
            </div>
        </div>
    </div>
