<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="/addPatientCard" method="post">
    <div><label> Diagnosis : <input type="text" name="diagnosis"/> </label></div>
    <div><label> Medicine: <input type="text" name="medicine"/> </label></div>
    <div><label> Procedures: <input type="text" name="procedures"/> </label></div>
    <div><label> Operation: <input type="text" name="operation"/> </label></div>
    <div><label> ID of patient: <input type="number" name="patientId"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><input type="submit" value="Add"/></div>
</form>

</body>
</html>