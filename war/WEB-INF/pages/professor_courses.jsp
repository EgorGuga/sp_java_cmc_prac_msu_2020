<%@ page import="static dao.src.ProfessorDao.findProfessorById" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Преподаватели</title>
</head>
<body>
<h2><p align="center">Информация о преподавателях</p></h2>
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
    <c:forEach var="wj" items="${WJournalList}">
        <tr>
            <td>${wj.courseByCourseId.name}</td>
            <td>
                <c:if test="${empty wj.courseByCourseId.yearOfStudy}">
                    <c:out value=""></c:out>
                </c:if>
                <c:if test="${not empty wj.courseByCourseId.yearOfStudy}">
                    ${wj.courseByCourseId.yearOfStudy}
                </c:if>
            </td>
            <td>${wj.courseByCourseId.coverage}</td>
            <td>${wj.courseByCourseId.intensity}</td>
            <td>${wj.courseByCourseId.year}</td>
            <td>
                <c:if test="${wj.courseByCourseId.active == 1}">
                    <c:out value="Да"></c:out>
                </c:if>
                <c:if test="${wj.courseByCourseId.active == 0}">
                    <c:out value="Нет"></c:out>
                </c:if>
            </td>
            <td><a href="/webapp/delete_professor_course/${wj.professorId}/${wj.courseId}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<p align="center"><a href="/webapp/add_professor_course/${pId}">Добавить курс для преподавателя</a></p>
<p><%= new java.util.Date() %></p>
</body>
</html>
