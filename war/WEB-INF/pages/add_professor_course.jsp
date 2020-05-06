<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Преподаватели</title>
</head>
<body>
<h2><p align="center">Добавление курса для преподавателя</p></h2>
<p align="center">
    <a href="/webapp">Главная страница</a>&emsp;
    <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
    <a href="/webapp/students">Информация о студентах</a>&emsp;
    <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
    <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
    <a href="/webapp/courses">Информация о курсах</a>
</p>
<div align="center">
    <c:url value="/webapp/add_professor_course" var="var"/>
    <form:form method="post" action="${var}" modelAttribute="professor_course">
        <table border="0">
            <form:input type="hidden" path="professorId" value="${professor.professorId}"/>
            <tr>
                <td>Курс:</td>
                <td>
                    <form:select path = "courseId">
                        <form:option value = "0" label = "Выберите"/>
                        <c:forEach var="course" items="${CourseList}">
                            <form:option value = "${course.courseId}" label= "${course.name} ${course.yearOfStudy} курс, ${course.year}г."/>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Добавить курс"/></td>
            </tr>
        </table>
    </form:form>
</div>
<p><%= new java.util.Date() %></p>
</body>
</html>