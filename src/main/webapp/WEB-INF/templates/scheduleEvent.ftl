<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<@spring.bind "eventHasAuditorium"/>
<form action="/app/admin/schedule/event" method="post">
    Events:<br>
    <@spring.formSingleSelect "eventHasAuditorium.event", events, ""/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Auditorium:<br>
    <@spring.formSingleSelect "eventHasAuditorium.auditorium", auditoriums, ""/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Time yyyy-[m]m-[d]d hh:mm:ss[.f...]:<br>
    <@spring.formInput "eventHasAuditorium.airDate"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>