<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="save">
ID:<input type="text" name="id"><br>
Name:<input type="text" name="name"><br>
Technology:<input type="text" name ="tech"><br>
<input type="submit" value="Save">

</form>
name:${obj} 
<form action="getAll">
Retrieve all <br>
<input type="submit" value="GetAll">

</form>

<form action="findByTech">
Search By technology<br>
Technology:<input type="text" name ="tech"><br>
<input type="submit" value="Search">
</form>

<form action="findById">
Search By ID<br>
ID:<input type="text" name ="id"><br>
<input type="submit" value="Search">
</form>

<form action="findByIdGT">
Search By ID Greater Than<br>
ID:<input type="text" name ="id"><br>
<input type="submit" value="SearchGreaterThan">
</form>

<form action="findBySortedTech">
Sorted By Technology<br>
Sorted Technology:<input type="text" name ="tech"><br>
<input type="submit" value="Search">
</form>

</body>
</html>