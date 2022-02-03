<%@page import="servlet.models.Magasin"%>

<h1>Ajouter un magasin à la liste</h1>

<p>
    <form action= "<%=request.getContextPath()%>/addmag" method="post">
        <input type="number" name="id" placeholder="id"></br>
        <input type="text" name="nom" placeholder="nom"></br>
        <input type="text" name="rue" placeholder="rue"></br>
        <input type="text" name="ville" placeholder="ville"></br>
        <input type="number" name="cp" placeholder="code postal"></br>
        <input type="number" name="numero" placeholder="numero"></br>
        <input type="number" name="superficie" placeholder="superficie"></br>
        <button type="submit">Envoyer</button>
    </form>
</p>