<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html>
<head>
</head>
<body>
<@spring.bind "user"/>
<form action="/app/user/save" method="post">
    First name:<br>
    <@spring.formInput "user.firstName"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Last name:<br>
    <@spring.formInput "user.lastName"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Email:<br>
    <@spring.formInput "user.email"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Birthday:<br>
    <@spring.formInput "user.birthday"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Password:<br>
    <@spring.formPasswordInput "user.password"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>