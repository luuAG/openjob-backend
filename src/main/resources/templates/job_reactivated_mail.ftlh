<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, baseUser-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Spring Boot Email using FreeMarker</title>
</head>
<body>
<div style="font-weight: bold">Dear ${candidate.fullName}</div>
<div>The job-openning <b>${job.title}</b> you have applied has been re-opened.</div>
<div>Come and check it out.</div>
</body>
</html>