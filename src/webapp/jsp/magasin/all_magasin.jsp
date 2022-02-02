<%@ page import = "servlet.models.Magasin" %>
<%@ page import = "java.util.List" %>

<% List<Magasin> liste = (List<Magasin>) request.getAttribute("list"); %>

<h1> Liste des magasins </h1>
<ul>
    <% for(Magasin m : liste){ %>
        <li> <%= m.toString() %>
        <%= m.getProduitDispo() %> </li>
    <% } %>
</ul>

<a href="<%= request.getContextPath()%>/jsp/magasin/add_magasin.jsp">Ajouter un magasin</a>