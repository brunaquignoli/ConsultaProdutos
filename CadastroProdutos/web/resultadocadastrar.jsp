<%-- 
    Document   : resultadocadastrar
    Created on : 21 de mai. de 2025, 15:50:04
    Author     : bruna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilos/styles.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Resultado Cadastrar </title>
    </head>
    <body>
        <a class="voltar" href="index.html"> Voltar </a>
        
            <div class="container">
                <%
                    String msg = (String) request.getAttribute("msg");            
                %>
                <h1> Resultado: <%out.println(msg); %> </h1>
            </div>
    </body>
</html>
