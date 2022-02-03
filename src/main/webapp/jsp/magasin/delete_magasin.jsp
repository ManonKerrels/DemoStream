<%@ page import = "servlet.models.Magasin" %>

<h1>Supprimer un magasin de la liste</h1>

<p>
    <form action= "<%=request.getContextPath()%>/deletemag" method="post">
    <input type="number" name="id" placeholder="id"></br>
    <button type="submit">Envoyer</button>
    </form>
</p>