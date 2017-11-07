function init(){
    $("td").filter(function() {
        return $(this).attr("id") <minDepartureId;
    }).addClass("disabled");

    if(count==0){
        $(".prev-btn").addClass("prev-btn-disable");
    }
    if(count==5){
        $(".next-btn").addClass("next-btn-disable");
    }
}


function getCalendarDate(blockId){

    if(count>=0 && count<6){

        if(blockId>=minDepartureId && selectedDepartureId!=blockId && departureId==0 ){
            preCount=count;
            var actionName = contextPath+"/ajax?count="+count+"&departureId="+blockId;
            $.ajax({
                url:actionName,
                type:"GET",
                success:function(result){
                    $("#contentDiv").html(result);
                    selectedDepartureId=blockId;
                    departureId=blockId;
                    $("#"+selectedDepartureId).addClass("active");

                    $("#"+selectedDepartureId).find("div").addClass("flight-lebal").html("DEP");

                    $("td").filter(function() {
                        return $(this).attr("id") < blockId;
                    }).addClass("disabled");

                    $("#"+selectedReturnId).removeClass("active");
                    returnId=0;
                    init();

                }
            });
        }
        else if(blockId>=minDepartureId && blockId > departureId && returnId==0){

            selectedReturnId=blockId;

            $("#"+selectedReturnId).addClass("active");

            $("#"+selectedReturnId).find("div").addClass("flight-lebal").html("ARV");

            returnId=blockId;

            departureId=0;
            preCount=0;

            $("td").filter(function() {
                var obj=$(this).attr("id");
                return obj>selectedDepartureId && obj<selectedReturnId;
            }).addClass("range");

            $("td").filter(function() {
                return $(this).attr("id") < selectedDepartureId;
            }).removeClass("disabled");

            init();
        }



    }
}


function loadCalendar(str){
    init();
    if((str=='next' && count>=0 && count<5) || (str=='pre' && count>preCount && count>0 && count<6)){


        if(str=='next'){
            count=count+1;
        }else{
            count=count-1;
        }
        var actionName = contextPath+"/ajax?count="+count+"&departureId="+selectedDepartureId;
        $.ajax({
            url:actionName,
            type:"GET",
            //data:"URL",
            success:function(result){

                $("#contentDiv").html(result);

                $("#"+selectedDepartureId).addClass("active");

                $("#"+selectedDepartureId).find("div").addClass("flight-lebal").html("DEP");

                $("td").filter(function() {
                    return $(this).attr("id") < selectedDepartureId;
                }).addClass("disabled");

                if(departureId==0 && selectedDepartureId>0 && selectedReturnId>0) {
                    $("#"+selectedReturnId).addClass("active");
                    $("td").filter(function () {
                        var obj = $(this).attr("id");
                        return obj > selectedDepartureId && obj < selectedReturnId;
                    }).addClass("range");

                    $("td").filter(function() {
                        return $(this).attr("id") < selectedDepartureId;
                    }).removeClass("disabled");


                    $("#"+selectedReturnId).find("div").addClass("flight-lebal").html("ARV");
                    init();
                }



            }
        });

    }
}