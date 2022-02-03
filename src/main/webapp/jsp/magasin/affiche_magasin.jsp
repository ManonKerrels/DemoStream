<%@page import="servlet.models.Magasin"%>

<% Magasin m = (Magasin) request.getAttribute("m"); %>

<h1> Votre magasin </h1>

<ul>
    <li> <%= m.getNom() %> </li>
    <li> <%= m.getRue() %> </li>
    <li> <%= m.getNumero() %> </li>
    <li> <%= m.getVille() %> </li>
    <li> <%= m.getCodePostal() %> </li>
    <li> <%= m.getSuperficie() %> </li>
</ul>

<ul>
    <li> <a href="./produit">Liste des produits</a> </li>
    <li> <a href="./index.jsp">Accueil</a> </li>
</ul>