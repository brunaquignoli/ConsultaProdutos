<%-- 
    Document   : resultadodeletar
    Created on : 21 de mai. de 2025, 16:17:47
    Author     : bruna
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="estilos/styles.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Resultado Deletar </title>
    </head>
    <body>
        <a class="voltar" href="index.html"> Voltar </a>
           
            <div class="container">
                <%
                    String msg = (String) request.getAttribute("msg");
                %>

                <h1> Resultado: <%out.println(msg);%> </h1>
            </div>
    </body>
</html>
