
$(document).ready(function(){


    $("#age").keypress(function (e){
        if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)){
            $("#errmsg").html("Digits only").show().fadeOut("slow");
            return false;
        }
    })

    $("#submitButton").click(function(){

        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        var age = $("#age").val();
        if (isEmptyString(firstName) || isEmptyString(lastName) || isEmptyString(age)) {
            alert("Please fill all fields");
            return;
        }
        var data = {firstName: firstName, lastName: lastName, age: age};

        $.post("/submitData", data).done( function(response){
            if (response.status == "Success"){
                $("#successStat").html("Person added!").show().fadeOut(3000);
                $("#firstName").val("");
                $("#lastName").val("");
                $("#age").val("");
            } else {
                $("#failStat").html("Person already exists!").show().fadeOut(3000);
            }
            console.log("Status - " + status);
            console.log("Data - " + data);
        }).fail(function(data, status){
            console.log("Status - " + status);
            console.log("Data - " + data);
            $("#alertDiv").text("Something went wrong!");
        });
    });
});

function isEmptyString(value) {
    return value == '';
}
