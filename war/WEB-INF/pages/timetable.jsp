<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Расписание</title>
</head>
<body>
<h2><p align="center">Расписание</p></h2>
<p align="center">
    <a href="/webapp">Главная страница</a>&emsp;
    <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
    <a href="/webapp/students">Информация о студентах</a>&emsp;
    <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
    <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
    <a href="/webapp/courses">Информация о курсах</a>
</p>
<p align="center">
    <a href="/webapp/students">Расписание для студента</a>
    <a href="/webapp/find_by_group">Расписание групповых занятий</a>
    <a href="/webapp/find_by_course_and_flow">Расписание поточных занятий</a>
    <a href="/webapp/professors">Расписание для преподавателя</a>
    <a href="/webapp/lecture_halls">Расписание для аудитории</a>
</p>
<table align="center">
    <tr>
        <th>Название</th>
        <th>Покрытие</th>
        <th>Преподаватель</th>
        <th>Аудитория</th>
        <th>День</th>
        <th>Начало</th>
        <th>Конец</th>
    </tr>
    <c:forEach var="clazz" items="${ClazzList}">
        <tr>
            <td><c:out value="${clazz.courseByCourseId.name} "/>
                <c:if test="${empty clazz.courseByCourseId.yearOfStudy}">
                    <c:out value=""/>
                </c:if>
                <c:if test="${not empty clazz.courseByCourseId.yearOfStudy}">
                    <c:out value="${clazz.courseByCourseId.yearOfStudy} курс"/>
                </c:if>
            </td>
            <td>${clazz.courseByCourseId.coverage}</td>
            <td>${clazz.professorByProfessorId.fullName}</td>
            <td>${clazz.lectureHallByLectureHallId.number}</td>
            <td>${clazz.dayOfTheWeek}</td>
            <td>${clazz.startTime}</td>
            <td>${clazz.endTime}</td>
            <td><a href="/webapp/edit_clazz/${clazz.classId}">Изменить</a></td>
            <td><a href="/webapp/delete_clazz/${clazz.classId}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<p align="center"><a href="/webapp/add_clazz">Добавить занятие</a></p>

<p><%= new java.util.Date() %></p>
</body>
</html>
