<%page import="streams.exo.models.Produit"%>
<%page import="java.util.List"%>

<% include file = "/WEB-INF/jsp/head.jsp" %>

<% List<Produit> liste = (Liste<Produit>) request.getAttribute("list", list); %>

<h1> Liste des produits (nombre : <%= liste.size() %> ) </h1>

<ul>
    <% for(Produit p : liste){ %>
        <li> <%= p.getNom() %> <%= p.getMarque() %> <%= p.getPrix() %> </li>
    <% } %>
</ul>

<%@ include file= "/WEB-INF/jsp/foot.jsp" %>