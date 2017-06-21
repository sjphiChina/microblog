<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View your posts</title>
</head>
<body>
  <table border="2" width="70%" cellpadding="2">
    <tr>
      <th>Content</th>
    </tr>
    <c:forEach var="postbean" items="${list}">
      <tr>
        <td>${postbean.content}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>