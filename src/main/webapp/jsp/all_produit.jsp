<%page import="streams.exo.models.Produit"%>
<%page import="java.util.List"%>

<% List<Produit> liste = (Liste<Produit>) request.getAttribute("list", list); %>

<h1> Liste des produits (nombre : <%= liste.size() %> ) </h1>

<ul>
    <% for(Produit p : liste){ %>
        <li> <%= p.getNom() %> <%= p.getMarque() %> <%= p.getPrix() %> </li>
    <% } %>
</ul>


<ul>
    <li> <a href="./index.jsp">Accueil</a> </li>
</ul>