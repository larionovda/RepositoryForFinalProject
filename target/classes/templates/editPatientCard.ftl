<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="/updatePatientCard" method="post">
    <div><label> Diagnosis : <input type="text" name="diagnosis" value="${patientCard.diagnosis}"/> </label></div>
    <div><label> Medicine: <input type="text" name="medicine" value="${patientCard.medicine}"/> </label></div>
    <div><label> Procedures: <input type="text" name="procedures" value="${patientCard.procedures}"/> </label></div>
    <div><label> Operation: <input type="text" name="operation" value="${patientCard.operation}"/> </label></div>
    <div><label> <input type="hidden" name="id" value="${patientCard.id}"/> </label></div>
    <div><label> <input type="hidden" name="patientId" value="${patientCard.patientId}"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><input type="submit" value="Edit"/></div>
</form>

</body>
</html>