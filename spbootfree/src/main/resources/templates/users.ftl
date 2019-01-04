<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<#list users as user>
    <h1>${user.id}</h1>******<h2>${user.username}</h2>*********<h3>${user.password}</h3><br>
</#list>
</body>
</html>