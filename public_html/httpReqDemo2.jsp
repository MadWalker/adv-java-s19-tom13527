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
                Http Request Demo
            </h1>
        </div>
        <div id="content">
            <div id="posts">
                <div class="post">
                    <p>name ${name}</p>
                    <p>the class favorite number is ${favoriteNumber}</p>
                </div>
            </div>
<%@ include file="content-side-bar.jsp"%>
<%@ include file="footer.jsp"%>
</html>
