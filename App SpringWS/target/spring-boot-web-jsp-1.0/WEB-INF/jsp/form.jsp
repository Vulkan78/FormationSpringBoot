<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Form</title>
</head>
<body>
    <h1>Formulaire</h1>
    <form method="post" class="form">
        <div class="form-row">
            <div class="col">
       			<input type="text" placeholder="id" name="id" class="form-control" value="${empty editFormation ? '' : editFormation.id}">
            </div>
            <div class="col">
        		<input type="text" placeholder="theme" name="theme" class="form-control" value="${empty editFormation ? '' : editFormation.theme}">
            </div>
            <div class="col">
        		<input type="submit" class="btn btn-primary">
            </div>
        </div>
    </form>
</body>
</html>