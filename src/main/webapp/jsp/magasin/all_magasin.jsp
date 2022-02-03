<%@page import="servlet.models.Magasin"%>
<%@page import="java.util.List"%>

<% List<Magasin> liste = (List<Magasin>) request.getAttribute("list"); %>

<h1> Liste des magasins </h1>
<ul>
    <% for(Magasin m : liste){ %>
        <li> <%= m.toString() %> </li>
    <% } %>
</ul>

<ul>
    <li> <a href="<%= request.getContextPath()%>/jsp/magasin/add_magasin.jsp">Ajouter un magasin</a> </li>
    <li> <a href="<%= request.getContextPath()%>/jsp/magasin/delete_magasin.jsp">Supprimer un magasin</a> </li>
    <li> <a href="<%= request.getContextPath()%>/jsp/magasin/one_magasin.jsp">Chercher un magasin</a> </li>
    <li> <a href="./index.jsp">Accueil</a> </li>
</ul>