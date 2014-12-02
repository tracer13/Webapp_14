<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<html>
  <title>
    Version 0.0.2 (fixed configuration)
  </title>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="<c:url value="/resources/core/jquery-2.1.1.js" />"></script>
    <script src="<c:url value="/resources/core/mainscript.js" />"></script>
    <link rel= "stylesheet" type="text/css" href="<c:url value="/resources/core/styles.css" />">
  </head>
<body>
<%--method="POST" action="submitData" >--%>
<div id="submitForm"  >
    <div>
      <p>First Name</p>
      <input type="text" id="firstName"/>
    </div>
    <div>
      <p>Last Name</p>
      <input type="text" id="lastName"/>
    </div>
    <div>
      <p>Age</p>
      <input type="text" id="age"/>
    </div>
    <div>
      <span id="errmsg"></span>
    </div>
    <div>
      <p>
        <button id="submitButton">Submit</button>
      </p>
    </div>
        <span id="successStat"></span>
        <span id="failStat"></span>
</div>


<form id="requestForm" method="GET" action="/getData">
  <table class="data" align="center">
    <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Age</th>
    </tr>
    <c:forEach items="${personList}" var="person">
      <tr>
        <td>${person.firstName}</td>
        <td>${person.lastName}</td>
        <td>${person.age}</td>
      </tr>
    </c:forEach>
  </table>
    <p><input value="Show" type="submit"></p>

</form>
</body>
</html>
