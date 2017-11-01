<%--
  Created by IntelliJ IDEA.
  User: higarg
  Date: 11/1/17
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <style>
        @font-face {
            font-family: 'Material Icons';
            font-style: normal;
            font-weight: 400;
            src: url(https://fonts.gstatic.com/s/materialicons/v29/2fcrYFNaTjcS6g4U3t-Y5ZjZjT5FdEJ140U2DJYC3mY.woff2) format('woff2');
        }

        .material-icons {
            font-family: 'Material Icons';
            font-weight: normal;
            font-style: normal;
            font-size: 24px;
            line-height: 1;
            letter-spacing: normal;
            text-transform: none;
            display: inline-block;
            white-space: nowrap;
            word-wrap: normal;
            direction: ltr;
            -webkit-font-feature-settings: 'liga';
            -webkit-font-smoothing: antialiased;
        }


        @media (min-width:240px) and (max-width:768px)  {
            .calendar-wrapper ul li { display:none;}
            .calendar-wrapper ul li:first-child{ display:block;}
            .calendar-table td { height:40px;}
            .calendar-table th { height:25px;}

        }

        @media (min-width: 1024px) {
            .calendar-wrapper ul {display:flex;}
            .calendar-wrapper ul li {width:49%; margin-right:1rem;}
            .hidden-sm { display:none;}
        }
        .my-header { font-size:16px !important;}
        .my-text { margin-top:8px; display:inline-block;}
        .calendar-container { position:relative;}
        .calendar-wrapper { position:absolute; top:100%; left:0; width:100%;}

        .calendar-wrapper ul { list-style:none; margin:0; padding:0;}
        .calendar-table {border-collapse:collapse; font-family:'Helvetica', Arial, Helvetica, sans-serif;}
        .calendar-table td, .calendar-table th { padding:10px 0px;text-align:center; font-weight:bold; cursor:pointer; font-size:16px; color:#444;}
        .calendar-table td { height:51px;}
        .calendar-table th { height:30px;}
        .calendar-table th { font-size:14px;}
        .calendar-table td {border:1px solid #ddd; }
        .calendar-table th {border-top:1px solid #ddd; border-bottom:1px solid #ddd;}
        .calendar-table td:hover, .calendar-table td.range { background-color:#e7f2fb;}
        .calendar-table td:hover.active, .calendar-table td.active {background-color:#164880; color:#fff;}
        .calendar-table td.active .price { color:#fff;}
        .calendar-table td.disabled, .calendar-table td.disabled:hover { color:#ccc; cursor:not-allowed; background-color:#fff;}
        .calendar-table td .price { display:block; font-weight:normal; font-size:9px !important; margin-top:0.8rem; color:#777; font-size:15px;}
        .prev-btn, .next-btn { color:#333}
        .prev-btn i, .next-btn i{ font-size:32px;}
        .prev-btn:hover, .next-btn:hover {color:#164880; }
        .prev-btn { float:left; margin-left:10px;}
        .next-btn { float:right; margin-right:10px;}
        .calendar-table td.disabled { border:none;}
        .calendar-table th.my-header { border:none; height:30px;}
        .border-left-0 { border-left:none !important;}
        .border-right-0 { border-right:none !important;}
        .border-top-0 { border-top:none !important;}
        .border-bottom-0 { border-bottom:none !important;}
        .flight-lebal{font-size:10px !important; padding-bottom: 5px;}
    </style>
</head>
<body>
<div class="calendar-container">

    <div class="calendar-wrapper">
        <ul>
            <c:forEach items="${dataMap}" var="data" varStatus="status">
            <li>
                <table class="calendar-table" width="100%" cellpadding="0" cellspacing="0">
                    <fmt:parseDate var="now"
                                   value="${data.dateString}"  pattern="dd-MM-yyyy"/>
                    <thead>
                    <tr>

                        <c:choose>
                            <c:when test="${status.index==0}">
                        <th colspan="7" class="my-header"><a href="#" class="prev-btn"><i class="material-icons">keyboard_arrow_left</i></a>
                            <span class="my-text"><fmt:formatDate pattern="MMMMM yyyy" value="${now}"/>
                        </span> <a href="#" class="next-btn hidden-sm"><i class="material-icons">keyboard_arrow_right</i></a></th>
                            </c:when>
                            <c:otherwise>
                        <th colspan="7" class="my-header"><a href="#" class="prev-btn hidden-sm">
                            <i class="material-icons">keyboard_arrow_left</i></a> <span class="my-text"><fmt:formatDate pattern="MMMMM yyyy" value="${now}"/>
                         </span> <a href="#" class="next-btn"><i class="material-icons">keyboard_arrow_right</i></a></th>
                            </c:otherwise>

                 </c:choose>

                    </tr>
                    <c:set var="i" value="${data.startDayOfMonth}"/>

                    <c:set var="max" value="${data.numberOfDays}"/>

                    <c:set var="end" value="${i>5?42:35}"/>

                    <c:set var="days" value="${['S','M','T','W','T','F','S']}"></c:set>

                    <tr>
                        <c:forEach items="${days}" var="day">
                            <th width="14%">${day}</th>
                        </c:forEach>
                    </tr>
                    </thead>
                    <tbody>

                    <c:set var="d" value="1"/>


                    <c:forEach var="x" begin="1" end="${end}">
                    <c:if
                            test="${(x==1)||(x==8)||(x==15)||(x==22)||(x==29) || (x==36 && i>5)}">
                    </tr>
                    <tr>
                        </c:if>

                        <c:choose>
                            <c:when test="${ (d<=max) && ((x>7)||(i<=x)) }">
                                <c:set var="calendar" value="${data.dataMap['cal'.concat(d)]}"/>

                        <td class="${calendar.calClass}" id="${calendar.calId}">

                                <c:out value="${d}"/>
                                <small class="price">${calendar.calValue}</small>
                                <c:set var="d" value="${d+1}"/>
                        </td>

                            </c:when>

                            <c:otherwise><td></td></c:otherwise>

                            </c:choose>

                        </c:forEach>


                   <%-- <tr>
                        <td class="disabled">1</td>
                        <td class="disabled">2</td>
                    </tr>
                    <tr>
                        <td class="disabled">3</td>
                        <td class="disabled">4</td>
                        <td class="disabled">5</td>
                        <td class="disabled">6</td>
                        <td class="disabled">7</td>
                        <td class="disabled">8</td>
                        <td class="disabled">9</td>
                    </tr>
                    <tr>
                        <td class="disabled">10</td>
                        <td class="disabled">11</td>
                        <td class="disabled">12</td>
                        <td class="disabled">13</td>
                        <td class="disabled">14</td>
                        <td class="disabled">15</td>
                        <td class="disabled">16</td>
                    </tr>
                    <tr>
                        <td class="disabled">17</td>
                        <td class="disabled">18</td>
                        <td class="disabled">19</td>
                        <td class="active"><div class="flight-lebal">DEP</div>20</td>
                        <td class="range">21<small class="price">$41589</small></td>
                        <td class="range">22<small class="price">$41589</small></td>
                        <td class="range">23<small class="price">$41589</small></td>
                    </tr>
                    <tr>
                        <td class="range">24</td>
                        <td class="range">25</td>
                        <td class="range">26 <small class="price">$41589</small></td>
                        <td class="range">27 <small class="price">$41589</small></td>
                        <td class="range">28 <small class="price">$41589</small></td>
                        <td class="range">29 <small class="price">$41589</small></td>
                        <td class="active"><div class="flight-lebal">ARV</div>30 <small class="price">$41589</small></td>
                    </tr>
                    <tr>
                        <td>31 <small class="price">$ 41589</small></td>

                    </tr>--%>
                    </tbody>
                </table>
            </li>
            </c:forEach>
        </ul>
    </div>
</div>

</body>
</html>
