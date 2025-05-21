<%-- 
    Document   : resultadoatualizar
    Created on : 21 de mai. de 2025, 16:21:30
    Author     : bruna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos/styles.css"/>
        <title> Resultado Atualizar</title>
    </head>
    <body>
        <a class="voltar" href="index.html"> Voltar </a>
            <div class="container">
                <%
                    String msg = (String) request.getAttribute("msg");
                %>

                <h1> Resultado: <% out.println(msg); %></h1>
            </div>
    </body>
</html>
