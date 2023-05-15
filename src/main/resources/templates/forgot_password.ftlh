<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, baseUser-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Spring Boot Email using FreeMarker</title>
</head>
<body>
<div>Dear,</div>
<div>You have requested to reset your password at OpenJob. Click to the URL below to complete.</div>
<a href="${resetPasswordURL}">Reset link</a>
<div>If you haven't made the request, please ignore this mail.</div>
</body>
</html>