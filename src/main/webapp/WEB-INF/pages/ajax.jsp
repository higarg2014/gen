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


                    <fmt:formatDate var="i" pattern="E" value="${now}" />

                    <c:choose>
                        <c:when test="${i=='Sun'}">
                            <c:set var="i" value="1" />
                        </c:when>

                        <c:when test="${i=='Mon'}">
                            <c:set var="i" value="2" />
                        </c:when>

                        <c:when test="${i=='Tue'}">
                            <c:set var="i" value="3" />
                        </c:when>

                        <c:when test="${i=='Wed'}">
                            <c:set var="i" value="4" />
                        </c:when>

                        <c:when test="${i=='Thu'}">
                            <c:set var="i" value="5" />
                        </c:when>

                        <c:when test="${i=='Fri'}">
                            <c:set var="i" value="6" />
                        </c:when>

                        <c:when test="${i=='Sat'}">
                            <c:set var="i" value="7" />
                        </c:when>

                        <c:otherwise>
                            <c:set var="i" value="?" />
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${param.month==2}">
                            <c:set var="max" value="28" />

                            <c:if
                                    test="${ ((param.year % 4 == 0 && paran.year % 100 != 0) || param.year % 400 == 0) }">

                                <c:set var="max" value="29" />
                            </c:if>
                        </c:when>

                        <c:when test="${param.month==4}">
                            <c:set var="max" value="30" />
                        </c:when>

                        <c:when test="${param.month==6}">
                            <c:set var="max" value="30" />
                        </c:when>

                        <c:when test="${param.month==9}">
                            <c:set var="max" value="30" />
                        </c:when>

                        <c:when test="${param.month==11}">
                            <c:set var="max" value="30" />
                        </c:when>

                        <c:otherwise>
                            <c:set var="max" value="31" />
                        </c:otherwise>
                    </c:choose>

                    <tr>
                        <th width="14%">S</th>
                        <th width="14%">M</th>
                        <th width="14%">T</th>
                        <th width="14%">W</th>
                        <th width="14%">T</th>
                        <th width="14%">F</th>
                        <th width="14%">S</th>

                    </tr>

                    </thead>

                    <c:set var="d" value="1" />

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

