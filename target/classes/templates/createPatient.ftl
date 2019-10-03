<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="/addPatient" method="post">
<div><label> Id : <input type="number" name="id"/> </label></div>
<div><label> Name: <input type="text" name="name"/> </label></div>
<div><label> Surname: <input type="text" name="surname"/> </label></div>
<div><label> Patronymic: <input type="text" name="patronymic"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
<div><input type="submit" value="Add"/></div>
</form>

</body>
</html>