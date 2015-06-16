
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Formular</title>
</head>
<body>
<divstyle="width:100%;" align="center"></div>
<p>
<input name="filename" type="text" size="30" maxlength="30"><br/>
<input type="radio" name="saveCSV" value="CSV"> CSV <br/>
<input type="radio" name="saveSER" value="SER"> SER <br/>
<input type="radio" name="savePDF" value="PDF"> PDF <br/>
</p>
<button type="submit">Speichern!</button>
<button type ="reset">Zurücksetzen!</button>
</body>
</html>