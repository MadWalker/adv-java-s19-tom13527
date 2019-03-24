<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="head.jsp"%>
    <body>
        <div id="header">
            <h1>
                This is a jsp
            </h1>
        </div>
        <div id="content">
            <div id="posts">
                <div class="post">
                    <h2 class="title">
                        Here is a picture:
                    </h2>
                    <img src="images/image6.jpg" alt="Programmer photo">
                    <h3>
                        Here is is the date and time:
                    </h3>
                    <%= new java.util.Date() %>

                    <a href="/java112">Home</a>
                </div>
            </div>
<%@ include file="content-side-bar.jsp"%>
<%@ include file="footer.jsp"%>
</html>
