<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Security Example - ProgrammingFree</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <style>


        /* fallback */
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
            .calendar-table td, .calendar-table th {height:auto !important;}

        }

        @media (min-width: 1024px) {
            .calendar-wrapper ul {display:flex;}
            .calendar-wrapper ul li {width:49%; margin-right:1rem;}
        }
        .my-header { font-size:16px !important;}
        .my-text { margin-top:8px; display:inline-block;}
        .calendar-container { position:relative;}
        .calendar-wrapper { position:absolute; top:100%; left:0; width:100%;}

        .calendar-wrapper ul { list-style:none; margin:0; padding:0;}
        .calendar-table {border-collapse:collapse; font-family:'Helvetica', Arial, Helvetica, sans-serif;}
        .calendar-table td, .calendar-table th { height:30px; border:1px solid #ddd; padding:10px 0px;text-align:center; cursor:pointer; font-size:14px; color:#444;font-weight:bold;}
        .calendar-table td:hover, .calendar-table td.range { background-color:#e7f2fb;}
        .calendar-table td:hover.active, .calendar-table td.active {background-color:#164880; color:#fff;}
        .calendar-table td.disabled, .calendar-table td.disabled:hover { color:#ccc; cursor:not-allowed; background-color:#fff;}
        .calendar-table td .price { display:block; font-weight:normal; font-size:10px; margin-top:0.8rem;color: green;}
        .prev-btn, .next-btn { border:1px solid #ddd; border-radius:5px; color:#333; padding:5px;}
        .prev-btn:hover, .next-btn:hover {background-color:#164880; color:#fff; border-color:#164880;}
        .prev-btn { float:left; margin-left:10px;}
        .next-btn { float:right; margin-right:10px;}
    </style>
</head>
<body>

<div class="calendar-container">

    <div class="calendar-wrapper">
        <ul>
            <li id="contentDiv">
                <table class="calendar-table" width="100%" cellpadding="0" cellspacing="0">
                    <fmt:parseDate var="now"
                                   value="${monthData}" type="date"
                                   dateStyle="short"/>
                    <thead>
                    <tr>
                        <th colspan="7" class="my-header"><a href="#" class="prev-btn" id="pre" onclick="loadPre()"><i
                                class="material-icons">keyboard_arrow_left</i></a>
                            <span class="my-text">Depart: BLR-DEL    <fmt:formatDate pattern="MMMMM yyyy"
                                                                                     value="${now}"/></span>
                            <a class="next-btn" id="next" onclick="loadNext()"><i class="material-icons">keyboard_arrow_right</i></a>
                        </th>
                    </tr>


                    <fmt:formatDate var="i" pattern="E" value="${now}"/>

                    <c:choose>
                        <c:when test="${i=='Sun'}">
                            <c:set var="i" value="1"/>
                        </c:when>

                        <c:when test="${i=='Mon'}">
                            <c:set var="i" value="2"/>
                        </c:when>

                        <c:when test="${i=='Tue'}">
                            <c:set var="i" value="3"/>
                        </c:when>

                        <c:when test="${i=='Wed'}">
                            <c:set var="i" value="4"/>
                        </c:when>

                        <c:when test="${i=='Thu'}">
                            <c:set var="i" value="5"/>
                        </c:when>

                        <c:when test="${i=='Fri'}">
                            <c:set var="i" value="6"/>
                        </c:when>

                        <c:when test="${i=='Sat'}">
                            <c:set var="i" value="7"/>
                        </c:when>

                        <c:otherwise>
                            <c:set var="i" value="?"/>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${param.month==2}">
                            <c:set var="max" value="28"/>

                            <c:if
                                    test="${ ((param.year % 4 == 0 && paran.year % 100 != 0) || param.year % 400 == 0) }">

                                <c:set var="max" value="29"/>
                            </c:if>
                        </c:when>

                        <c:when test="${param.month==4}">
                            <c:set var="max" value="30"/>
                        </c:when>

                        <c:when test="${param.month==6}">
                            <c:set var="max" value="30"/>
                        </c:when>

                        <c:when test="${param.month==9}">
                            <c:set var="max" value="30"/>
                        </c:when>

                        <c:when test="${param.month==11}">
                            <c:set var="max" value="30"/>
                        </c:when>

                        <c:otherwise>
                            <c:set var="max" value="31"/>
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

                    <c:set var="d" value="1"/>


                    <c:forEach var="x" begin="1" end="35">
                    <c:if
                            test="${(x==1)||(x==8)||(x==15)||(x==22)||(x==29)}">
                    </tr>
                    <tr>
                        </c:if>
                            <c:set var="currentDay" value="24"/>
                        <c:choose>


                        <c:when test="${d<currentDay}">
                            <c:set var="val" value="disabled"/>
                        </c:when>

                        <c:when test="${ (d<=max) && ((x>7)||(i<=x)) }">
                            <c:set var="val" value="range"/>
                        </c:when>

                        <c:otherwise>
                            <c:set var="val" value="hello"/>
                        </c:otherwise>
                        </c:choose>

                        <td onclick="getCalendarDate(${d})" class="${val}" id="${data[d-1].calId}">
                            <c:if test="${ (d<=max) && ((x>7)||(i<=x)) }">
                                <c:out value="${d}"/>
                                <c:if test="${d>=currentDay}">
                                    <small class="price">${data[d-1].calValue}</small>
                                </c:if>
                                <c:set var="d" value="${d+1}"/>
                            </c:if>

                        </td>
                        </c:forEach>
                </table>
            </li>
            <li id="tableDiv">
            </li>

        </ul>
    </div>
</div>

</body>

<script>

    var d = new Date();
    var currentDay=d.getDay();
    var month = d.getMonth()+1;
    var year=d.getFullYear();
    var selectedMonth=month;
    var selectedYear=year;
    var selectedId;
    function getCalendarDate(str){

        console.log("month"+month);
        console.log("year"+year);
        console.log(new Date().getMonth());

        $("#"+selectedId).removeClass("active");
        $("#"+selectedId).addClass("range");

        var ide=""+str+month+year;
        console.log(ide);
        $("#"+ide).removeClass("range");
        $("#"+ide).addClass("active");
        selectedId=str+""+month+""+year;
        var selectedDay=str;
        var actionName = "${pageContext.request.contextPath}/view/ajax?month="+month+"&year="+year+"&path=return";
        $.ajax({
            url:actionName,
            type:"GET",
            //data:"URL",
            success:function(result){
                console.log(result);
                $("#tableDiv").html(result);
            }
        });

    }


    function loadNext(){

        if(month==12){
            year=year+1;
            month=1;

        }else {
            month = month + 1
        }
        var actionName = "${pageContext.request.contextPath}/view/ajax?month="+month+"&year="+year+"&path=depart";
        $.ajax({
            url:actionName,
            type:"GET",
            //data:"URL",
            success:function(result){
                console.log(result);
                $("#contentDiv").html(result);
                $("#"+selectedId).removeClass("active");
                $("#"+selectedId).addClass("range");
            }
        });
    }


    function loadPre(){
        if(month==1){
            year=year-1;
            month=12;

        }else {
            month = month - 1
        }
        var actionName = "${pageContext.request.contextPath}/view/ajax?month="+month+"&year="+year+"&path=depart";
        $.ajax({
            url:actionName,
            type:"GET",
            //data:"URL",
            success:function(result){
                console.log(result);
                $("#contentDiv").html(result);
                $("#"+selectedId).removeClass("range");
                $("#"+selectedId).addClass("active");
            }
        });

    }



    function loadPre1(){
        if(selectedMonth==1){
            year=year-1;
            selectedMonth=12;

        }else {
            selectedMonth = selectedMonth - 1
        }
        var actionName = "${pageContext.request.contextPath}/view/ajax?month="+selectedMonth+"&year="+selectedYear+"&path=return";
        $.ajax({
            url:actionName,
            type:"GET",
            //data:"URL",
            success:function(result){
                console.log(result);
                $("#tableDiv").html(result);
            }
        });
    }



    function loadNext1(){
        if(selectedMonth==12){
            year=year+1;
            selectedMonth=1;

        }else {
            selectedMonth = selectedMonth + 1
        }
        var actionName = "${pageContext.request.contextPath}/view/ajax?month="+selectedMonth+"&year="+selectedYear+"&path=return";
        $.ajax({
            url: actionName,
            type: "GET",
            //data:"URL",
            success: function (result) {
                console.log(result);
                $("#tableDiv").html(result);
            }

        });

        }




</script>
</html>
