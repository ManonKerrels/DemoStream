<%@ page import = "servlet.models.Magasin" %>

<h1>Ajout magasin à la liste</h1>

<p>
    <form action= "<%=request.getContextPath()%>/addmag" method="post">
        <input type="text" name="id" placeholder="id"></br>
        <input type="text" name="nom" placeholder="nom"></br>
        <input type="text" name="rue" placeholder="rue"></br>
        <input type="text" name="ville" placeholder="ville"></br>
        <input type="text" name="code postal" placeholder="code postal"></br>
        <input type="text" name="numero" placeholder="numero"></br>
        <input type="text" name="superficie" placeholder="superficie"></br>
        <input type="text" name="produits disponibles" placeholder="produits disponibles"></br>
        <button type="submit">Envoyer</button>
    </form>
</p>