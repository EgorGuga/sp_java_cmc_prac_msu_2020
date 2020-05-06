<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Курсы</title>
</head>
<body>
<h2><p align="center">Информация о курсах</p></h2>
<p align="center">
    <a href="/webapp">Главная страница</a>&emsp;
    <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
    <a href="/webapp/students">Информация о студентах</a>&emsp;
    <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
    <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
    <a href="/webapp/courses">Информация о курсах</a>
</p>
<table align="center">
    <tr>
        <th>Название</th>
        <th>Курс</th>
        <th>Покрытие</th>
        <th>Интенсивность</th>
        <th>Год</th>
        <th>Активен</th>
    </tr>
    <c:forEach var="course" items="${CourseList}">
        <tr>
            <td>${course.name}</td>
            <td>
                <c:if test="${empty course.yearOfStudy}">
                    <c:out value=""></c:out>
                </c:if>
                <c:if test="${not empty course.yearOfStudy}">
                    ${course.yearOfStudy}
                </c:if>
            </td>
            <td>${course.coverage}</td>
            <td>${course.intensity}</td>
            <td>${course.year}</td>
            <td>
                <c:if test="${course.active == 1}">
                    <c:out value="Да"></c:out>
                </c:if>
                <c:if test="${course.active == 0}">
                    <c:out value="Нет"></c:out>
                </c:if>
            </td>
            <td><a href="/webapp/edit_course/${course.courseId}">Изменить</a></td>
            <td><a href="/webapp/delete_course/${course.courseId}">Удалить</a></td>

        </tr>
    </c:forEach>
</table>
<p align="center"><a href="/webapp/add_course">Добавить курс</a></p>
<p><%= new java.util.Date() %></p>
</body>
</html>
