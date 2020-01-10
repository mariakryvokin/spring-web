<html>
<head>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <td>Event name</td>
        <td>Seat</td>
        <td>Air date</td>
        <td>Auditorium name</td>
    </tr>
    </thead>
     <#list ticketsToBeBought as ticket>
      <tbody>
      <tr>
          <td>${ticket.getEventHasAuditorium().getEvent().getName()}</td>
          <td>${ticket.getSeat()}</td>
          <td>${ticket.getEventHasAuditorium().getAirDate()}</td>
          <td>${ticket.getEventHasAuditorium().getAuditorium().getName()}</td>
      </tr>
      </tbody>
     </#list>
</table>
</body>
</html>