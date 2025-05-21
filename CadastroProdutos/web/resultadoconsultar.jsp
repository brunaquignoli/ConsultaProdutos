<%-- 
    Document   : resultadoconsultar
    Created on : 21 de mai. de 2025, 16:53:08
    Author     : bruna
--%>
<%@ page import="model.Produto" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="estilos/styles.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resultado Consultar</title>
</head>
<body>
    <a class="voltar" href="index.html"> Voltar </a>
    
        <%
            Produto produto = (Produto) request.getAttribute("produto");
            String msg = (String) request.getAttribute("msg");
        %>
    <div class="container">
        <h2><%= msg %></h2>

        <% if (produto != null && produto.getDescricao() != null) { %>
        <br>
            <p><strong>ID:</strong> <%= produto.getId() %></p>
        <br>
            <p><strong>Descrição:</strong> <%= produto.getDescricao() %></p>
        <br>
            <p><strong>Preço:</strong> R$ <%= produto.getPreco() %></p>
        <% } else { %>
            <p>Produto não encontrado.</p>
        <% } %>
    </div>
</body>
</html>

