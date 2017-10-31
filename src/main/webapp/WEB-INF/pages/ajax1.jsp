<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<table class="calendar-table" width="100%" cellpadding="0" cellspacing="0">
    <fmt:parseDate var="now"
                   value="${monthData}" pattern="dd-MM-yyyy"/>
    <thead>
    <tr>
        <th colspan="7" class="my-header"><a href="#" class="prev-btn" id="pre1" onclick="loadPre1()"><i
                class="material-icons">keyboard_arrow_left</i></a>
            <span class="my-text"><small class="return">Cheapest Arrival DEL-BLR : 10-01-2018</small>&nbsp;&nbsp;<fmt:formatDate pattern="MMMMM yyyy" value="${now}"/></span> <a
                    href="#" class="next-btn" id="next1" onclick="loadNext1()"><i class="material-icons">keyboard_arrow_right</i></a>
        </th>
    </tr>

    <c:set var="i" value="${fareCalendar.dayOfMonth}"/>
    <c:set var="max" value="${fareCalendar.numberOfDays}"/>
    <c:set var="days" value="${['S','M','T','W','T','F','S']}"></c:set>

    <tr>
        <c:forEach items="${days}" var="day">
            <th width="14%">${day}</th>
        </c:forEach>
    </tr>

    </thead>

    <c:set var="d" value="1"/>

    <c:forEach var="x" begin="1" end="35">
    <c:if
            test="${(x==1)||(x==8)||(x==15)||(x==22)||(x==29)}">
    </tr>
    <tr>
        </c:if>

        <c:choose>

            <c:when test="${d<fareCalendar.currentDay && fareCalendar.month==fareCalendar.currentMonth && fareCalendar.year==fareCalendar.currentYear}">
                <c:set var="val" value="disabled"/>
            </c:when>

            <c:when test="${ (d<=max) && ((x>7)||(i<=x)) }">
                <c:set var="val" value="range"/>
            </c:when>

            <c:otherwise>
                <c:set var="val" value="blank"/>
            </c:otherwise>

        </c:choose>

     <c:set var="calendar" value="${fareCalendar.dataMap['cal'.concat(d)]}"/>

        <td  class="${val}" id="${calendar.calId}">
            <c:if
                    test="${ (d<=max) && ((x>7)||(i<=x)) }">
                <c:out value="${d}"/>
                <c:choose>
                <c:when test="${fareCalendar.month==fareCalendar.currentMonth}">
               <c:if test="${d>=fareCalendar.currentDay}">
                        <small class="price">${calendar.calValue}</small>
                </c:if>
                </c:when>
                    <c:otherwise>
                        <small class="price">${calendar.calValue}</small>
                </c:otherwise>
          </c:choose>

                <c:set var="d" value="${d+1}"/>
            </c:if>

        </td>
        </c:forEach>

</table>

