<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Расписание</title>
</head>
<body>
<h2><p align="center">Добавление занятия в расписание</p></h2>
<p align="center">
    <a href="/webapp">Главная страница</a>&emsp;
    <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
    <a href="/webapp/students">Информация о студентах</a>&emsp;
    <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
    <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
    <a href="/webapp/courses">Информация о курсах</a>&emsp;
</p>
<h2><p align="center">Поиск по курсу и потоку</p></h2>
<form:form method="post" modelAttribute="clazz">
    <table align="center" border="0">
        <tr>
            <td>Занятие:</td>
            <td><form:select path = "classId">
                <form:option value ="0" label = "Выберите"/>
                <c:forEach var="Clazz" items="${ClazzList}">
                    <form:option value = "${Clazz.classId}" label= "${Clazz.courseByCourseId.name} ${Clazz.courseByCourseId.yearOfStudy} курс, ${Clazz.courseByCourseId.coverage}"/>
                </c:forEach>
            </form:select></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit" value="Добавить занятие в расписание"/></td>
        </tr>
    </table>
</form:form>
<p><%= new java.util.Date() %></p>
</body>
</html>
