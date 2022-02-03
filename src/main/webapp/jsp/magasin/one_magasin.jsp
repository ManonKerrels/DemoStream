<%@ page import="servlet.models.Magasin"%>

<h1> Choisir un magasin </h1>

<p>
    <form action= "<%=request.getContextPath()%>/onemag" method="post">
    <input type="number" name="id" placeholder="id"></br>
    <button type="submit">Envoyer</button>
    </form>
</p>
