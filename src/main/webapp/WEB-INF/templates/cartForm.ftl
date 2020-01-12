<#import "/spring.ftl" as spring />
<html>
<head></head>
<body>
<form action="/app/user/cart" method="post" accept="application/pdf">
    User email:<br>
    <@spring.formInput "user.email"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    User id:<br>
    <@spring.formInput "user.id"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Event id:<br>
    <@spring.formInput "event.id"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>