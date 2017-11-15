<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/calendar.css">
    <title>Title</title>
</head>
<body>
<c:set var="days" value="${['S','M','T','W','T','F','S']}"></c:set>
<div class="calendar-container">

    <div class="calendar-wrapper">
        <ul id="contentDiv">
            <c:forEach items="${dataMap}" var="data" varStatus="status">
            <li>
                <table class="calendar-table" width="100%" cellpadding="0" cellspacing="0">
                    <fmt:parseDate var="now"
                                   value="${data.dateString}"  pattern="dd-MM-yyyy"/>
                    <thead>
                    <tr>
                        <c:choose>
                        <c:when test="${status.index==0}">
                            <th colspan="7" class="my-header"><a href="#" class="prev-btn" onclick="loadCalendar('pre')"><i class="material-icons">keyboard_arrow_left</i></a>
                                <span class="my-text"><fmt:formatDate pattern="MMMMM yyyy" value="${now}"/>
                        </span> <a href="#" class="next-btn hidden-sm" onclick="loadCalendar('next')"><i class="material-icons">keyboard_arrow_right</i></a></th>
                        </c:when>
                        <c:otherwise>
                            <th colspan="7" class="my-header"><a href="#" class="prev-btn hidden-sm" onclick="loadCalendar('pre')">
                                <i class="material-icons">keyboard_arrow_left</i></a> <span class="my-text"><fmt:formatDate pattern="MMMMM yyyy" value="${now}"/>
                         </span> <a href="#" class="next-btn" onclick="loadCalendar('next')"><i class="material-icons">keyboard_arrow_right</i></a></th>
                        </c:otherwise>
                        </c:choose>
                    </tr>
                    <c:set var="i" value="${data.startDayOfMonth}"/>

                    <c:set var="max" value="${data.numberOfDays}"/>

                    <c:set var="end" value="${i>5 && max>30?42:35}"/>

                    <tr>
                        <c:forEach items="${days}" var="day">
                            <th width="14%">${day}</th>
                        </c:forEach>
                    </tr>
                    </thead>
                    <tbody>

                    <c:set var="d" value="1"/>
                    <c:set var="dateParts" value="${fn:split(data.dateString, '-')}" />
                    <c:set var = "year" value="${dateParts[2]}"></c:set>
                    <c:set var = "month" value="${dateParts[1]}"></c:set>

                    <c:forEach var="x" begin="1" end="${end}">
                    <c:if
                            test="${(x==1)||(x==8)||(x==15)||(x==22)||(x==29) || (x==36 && i>5 && max>30)}">
                    </tr>
                    <tr>
                        </c:if>
                        <c:choose>
                            <c:when test="${ (d<=max) && ((x>7)||(i<=x)) }">

                                <c:set var = "day" value="${d<10?'0'.concat(d):d}"></c:set>

                                <c:set var = "calendarId" value = "${year.concat(month).concat(day)}" />
                                <c:set var="calendar" value="${calendarData[calendarId]}"/>

                        <td  id="${calendarId}"  onclick="getCalendarDate(${calendarId})">
                            <div></div>
                                <c:out value="${d}"/>
                                <small class="price">${calendar.calValue}</small>
                                <c:set var="d" value="${d+1}"/>
                        </td>
                            </c:when>
                            <c:otherwise><td>
                        </td></c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tbody>
                </table>
            </li>
            </c:forEach>
        </ul>
        <input type="button" name="deals" value="More Deals" class="button" />
    </div>
</div>

</body>

<script>

    var count=0;
    var minDepartureId=${minDepartureId};
    var departureId=${minDepartureId};
    var selectedDepartureId=${minDepartureId};
    var returnId=0;
    var selectedReturnId=0;
    var preCount=0;
    var contextPath='${pageContext.request.contextPath}';
    $( document ).ready(function() {
        $("#"+selectedDepartureId).addClass("active");

        $("#"+selectedDepartureId).find("div").addClass("flight-lebal").html("DEP");
        init();
    });
</script>

<script src="${pageContext.request.contextPath}/static/js/calendar.js"></script>

</html>
