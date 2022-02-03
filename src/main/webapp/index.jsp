<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>Page d'accueil</h1>


    <a href="./produit">Get all</a>
    <a href="./ajout">Ajouter</a>
    <a href="./modifie">Modifier</a>
    <a href="<%= request.getContextPath()%>/magall">Liste magasins</a>
    <a href="<%= request.getContextPath()%>/jsp/magasin/add_magasin.jsp">Ajouter un magasin</a>
    <a href="<%= request.getContextPath()%>/jsp/magasin/one_magasin.jsp">Trouver un magasin</a>
</body>
</html>