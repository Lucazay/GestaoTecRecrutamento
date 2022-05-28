<%-- 
    Document   : marca
    Created on : 28/05/2022, 05:16:25
    Author     : Acer
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>


<h2>Marca</h2>
<table id="datatable" class="display" >
    <thead>
        <tr>

            <th align="left">ID</th>
            <th align="left">Descricao</th>
            <th align="right"></th>
            <th align="right"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="marca" items="${marcas}">
            <tr>
                <td align="left">${marca.idMarca}</td>
                <td align="left">${marca.descricao}</td>
                <td align="center">
                            <a href="${pageContext.request.contextPath}/MarcaExcluir?idMarca=${marca.idMarca}">
                            <button class="btn btn-group-lg
                                <c:out value="${marca.situacao == 'A' ? 'btn-danger' : 'btn-success'}"/> ">
                                <c:out value="${marca.situacao == 'A' ? 'Inativar' : 'Ativar'}"/>
                            </button>     
                <td align="center">
                    <a href=
                       "${pageContext.request.contextPath}/MarcaCarregar?idMarca=${marca.idMarca}">
                        Alterar</a></td>


            </tr>
        </c:forEach>
    </tbody>

</table>

    

<div align="center">
    <a href="${pageContext.request.contextPath}/MarcaNovo">Novo</a>
    <a href="index.jsp">Voltar à Página Inicial</a>

</div>
<script>
    $(document).ready(function () {
        console.log('entrei ready');
        $('#datatable').DataTable({
            "oLanguage": {
                "sProcessing": "Processando...",
                "sZeroRecords": "Nenhum registro encontrado",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                "sInfoFiltered": "",
                "sInfoPostFix": "",
                "sSearch": "Buscar",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "Primeiro",
                    "sPrevious": "Anterior",
                    "sNext": "Seguinte",
                    "sLast": "Último"
                }
            }
        });
    });
</script>

<%@include file="/footer.jsp" %>