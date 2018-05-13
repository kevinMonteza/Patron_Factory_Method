
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modeloControl.AccesoDatos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Laboratorio 5</title>
    </head>
    <body>
        <h1>Seleccione Pais</h1>
       <form action="${pageContext.request.contextPath}/ServletProceso" method="post">
           <%
                AccesoDatos paises = new AccesoDatos();
                List<String> lista = new ArrayList<String>();
                lista = paises.pedirPaises();
            %>  
            <select name="ComboBox">
            <%
                for (String temp : lista) {
                    out.print(temp);
            %>
                    <option value="<%=temp%>"><%=temp%></option>
            <%  }
            %>  
            </select>
            <input type="submit" value="Enviar">
        </form>
        <%
            String cad;
            cad = request.getParameter("ComboBox");
        %>
    </body>
</html>
