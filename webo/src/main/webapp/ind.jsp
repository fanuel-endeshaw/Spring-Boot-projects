<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simple Form</title>
    <link rel="stylesheet" href="sty.css" >
   
</head>
<body>

    <div class="container">
        <h2>Enter Two Numbers</h2>
        <form action="add" >  <label for="num1">Number 1:</label>
            <input type="number" id="num1" name="num1" required><br><br>

            <label for="num2">Number 2:</label>
            <input type="number" id="num2" name="num2" required><br><br>

            <button type="submit">Submit</button>
        </form>
    </div>

</body>
</html>