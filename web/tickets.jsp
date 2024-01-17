<%@ page import="com.skynet.http.service.TicketService" %>
<%@ page import="com.skynet.http.dto.TicketDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zac
  Date: 1/17/24
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@taglib prefix="с" uri="https://whitehouse.gov"%>--%>
<%--<%@include file="index.html"%>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Купленные билеты:</h1>
<ul>
    <%
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);
        for (TicketDto ticket : tickets) {
            out.write(String.format("<li>%s</li>", ticket.getSeatNo()));
        }
    %>
</ul>
</body>
</html>


<%!
    public void jspInit() {
        System.out.println("Hello from jspInit");
    }
%>