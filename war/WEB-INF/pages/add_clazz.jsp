<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Расписание</title>
</head>
<h2><p align="center">Добавление нового занятия</p></h2>
<p align="center">
    <a href="/webapp">Главная страница</a>&emsp;
    <a href="/webapp/timetable">Посмотреть расписание</a>&emsp;
    <a href="/webapp/students">Информация о студентах</a>&emsp;
    <a href="/webapp/professors">Информация о преподавателях</a>&emsp;
    <a href="/webapp/lecture_halls">Информация об аудиториях</a>&emsp;
    <a href="/webapp/courses">Информация о курсах</a>
</p>
<div align="center">
    <form:form method="post" modelAttribute="clazz">
        <table border="0">

            <tr>
                <td>Курс:</td>
                <td>
                    <form:select path = "courseId">
                        <form:option value ="0" label = "Выберите"/>
                        <c:forEach var="course" items="${CourseList}">
                            <form:option value = "${course.courseId}" label= "${course.name} ${course.yearOfStudy} курс, ${course.year}г."/>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Преподаватель:</td>
                <td>
                    <form:select path = "professorId">
                        <form:option value = "0" label = "Выберите"/>
                        <c:forEach var="professor" items="${ProfessorList}">
                            <form:option value = "${professor.professorId}" label= "${professor.fullName}"/>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Аудитория:</td>
                <td>
                    <form:select path = "lectureHallId">
                        <form:option value = "0" label = "Выберите"/>
                        <c:forEach var="lectureHall" items="${LectureHallList}">
                            <form:option value = "${lectureHall.lectureHallId}" label= "${lectureHall.number}"/>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>День недели:</td>
                <td>
                    <form:select path = "clazz.dayOfTheWeek">
                        <form:option value = "NONE" label = "Выберите"/>
                        <form:option value = "Пн" label = "Понедельник"/>
                        <form:option value = "Вт" label = "Вторник"/>
                        <form:option value = "Ср" label = "Среда"/>
                        <form:option value = "Чт" label = "Четверг"/>
                        <form:option value = "Пт" label = "Пятница"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Время начала:</td>
                <td>
                    <form:select path = "startHour">
                            <form:option value = "8" label = "8"/>
                        <form:option value = "9" label = "9"/>
                        <form:option value = "10" label = "10"/>
                        <form:option value = "11" label = "11"/>
                        <form:option value = "12" label = "12"/>
                        <form:option value = "13" label = "13"/>
                        <form:option value = "14" label = "14"/>
                        <form:option value = "15" label = "15"/>
                        <form:option value = "16" label = "16"/>
                        <form:option value = "17" label = "17"/>
                        <form:option value = "18" label = "18"/>
                        <form:option value = "19" label = "19"/>
                        <form:option value = "20" label = "20"/>
                    </form:select>
                    ч
                    <form:select path = "startMinute">
                        <form:option value = "00" label = "00"/>
                        <form:option value = "05" label = "05"/>
                        <form:option value = "10" label = "10"/>
                        <form:option value = "15" label = "15"/>
                        <form:option value = "20" label = "20"/>
                        <form:option value = "25" label = "25"/>
                        <form:option value = "30" label = "30"/>
                        <form:option value = "35" label = "35"/>
                        <form:option value = "40" label = "40"/>
                        <form:option value = "45" label = "45"/>
                        <form:option value = "50" label = "50"/>
                        <form:option value = "55" label = "55"/>
                    </form:select>
                минут
                </td>
            </tr>
            <tr>
                <td>Время конца:</td>
                <td>
                    <form:select path = "endHour">
                        <form:option value = "8" label = "8"/>
                        <form:option value = "9" label = "9"/>
                        <form:option value = "10" label = "10"/>
                        <form:option value = "11" label = "11"/>
                        <form:option value = "12" label = "12"/>
                        <form:option value = "13" label = "13"/>
                        <form:option value = "14" label = "14"/>
                        <form:option value = "15" label = "15"/>
                        <form:option value = "16" label = "16"/>
                        <form:option value = "17" label = "17"/>
                        <form:option value = "18" label = "18"/>
                        <form:option value = "19" label = "19"/>
                        <form:option value = "20" label = "20"/>
                    </form:select>
                    ч
                    <form:select path = "endMinute">
                        <form:option value = "00" label = "00"/>
                        <form:option value = "05" label = "05"/>
                        <form:option value = "10" label = "10"/>
                        <form:option value = "15" label = "15"/>
                        <form:option value = "20" label = "20"/>
                        <form:option value = "25" label = "25"/>
                        <form:option value = "30" label = "30"/>
                        <form:option value = "35" label = "35"/>
                        <form:option value = "40" label = "40"/>
                        <form:option value = "45" label = "45"/>
                        <form:option value = "50" label = "50"/>
                        <form:option value = "55" label = "55"/>
                    </form:select>
                    минут
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Добавить занятие"/></td>
            </tr>
        </table>
    </form:form>
</div>
<p><%= new java.util.Date() %></p>
</body>
</html>