<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Студенты</title>
</head>
<body>
<h2><p align="center">Добавление студента</p></h2>
<p align="center">
    <a href="/webapp">Главная страница</a>&emsp;
    <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
    <a href="/webapp/students">Информация о студентах</a>&emsp;
    <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
    <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
    <a href="/webapp/courses">Информация о курсах</a>
</p>
<div align="center">
    <form:form method="post" modelAttribute="student">
        <table border="0">
            <tr>
                <td>ФИО:</td>
                <td><form:input path="fullName"/></td>
            </tr>
            <tr>
                <td>Курс:</td>
                <td><form:input path="yearOfStudy"/></td>
            </tr>
            <tr>
                <td>Поток:</td>
                <td>
                    <form:select path = "flowId">
                        <form:option value = "0" label = "Выберите"/>
                        <c:forEach var="flow" items="${FlowList}">
                            <form:option value = "${flow.flowId}" label= "${flow.flowNumber}"/>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Группа:</td>
                <td>
                    <form:select path = "groupId">
                        <form:option value = "0" label = "Выберите"/>
                        <c:forEach var="group" items="${SGroupList}">
                            <form:option value = "${group.groupId}" label= "${group.groupNumber}"/>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Добавить студента"/></td>
            </tr>
        </table>
    </form:form>
</div>
<p><%= new java.util.Date() %></p>
</body>
</html>
