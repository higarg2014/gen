<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<table class="calendar-table" width="100%" cellpadding="0" cellspacing="0">
                    <fmt:parseDate var="now"
                                   value="${monthData}" type="date"
                                   dateStyle="short" />
                    <thead>
                    <tr>
                        <th colspan="7" class="my-header"><a href="#" class="prev-btn" id="pre1" onclick="loadPre()"><i class="material-icons">keyboard_arrow_left</i></a>
                            <span class="my-text">Depart: BLR-DEL    <fmt:formatDate pattern="MMMMM yyyy" value="${now}" /></span> <a href="#" class="next-btn" id="next1" onclick="loadNext()"><i class="material-icons">keyboard_arrow_right</i></a></th>
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

                    <c:set var="d" value="1" />


                    <c:forEach var="x" begin="1" end="35">
                    <c:if
                            test="${(x==1)||(x==8)||(x==15)||(x==22)||(x==29)}">
                    </tr><tr>
                    </c:if>


                        <c:choose>

                        <c:when test="${ (d<=max) && ((x>7)||(i<=x)) }">
                            <c:set var="val" value="range" />
                        </c:when>

                        <c:otherwise>
                            <c:set var="val" value="hello" />
                        </c:otherwise>


                        </c:choose>

                    <td onclick="getCalendarDate(${d})" class="${val}" id="${data[d-1].calId}">
                        <c:if
                                test="${ (d<=max) && ((x>7)||(i<=x)) }">
                            <c:out value="${d}" />
                            <small class="price">${data[d-1].calValue}</small>

                            <c:set var="d" value="${d+1}" />
                        </c:if>

                    </td>
                    </c:forEach>

                </table>

