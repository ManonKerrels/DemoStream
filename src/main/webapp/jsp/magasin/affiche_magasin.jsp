<%@page import="servlet.models.Magasin"%>

<% Magasin m = (Magasin) request.getAttribute("m"); %>

<h1> Votre magasin </h1>

<%= m %>

<a href="<%= request.getContextPath()%>/jsp/magasin/produits_magasin.jsp">Voir la liste des produits disponibles</a>