<%-- 
    Document   : produto
    Created on : 28/05/2022, 09:09:38
    Author     : Acer
--%>

<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>


    <h2>Marcas</h2>
    <div class="col-8 panel-body">
        <table id="datatable" class="table table-striped table-bordered basic-datatable">
            <thead>
                <tr>
                    <th align="left">ID</th>
                    <th align="left">Produto</th>
                    <th align="left">Marca</th>
                    <th align="left">Validade</th>
                    <th align="right"></th>
                    <th align="right"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="produto" items="${produtos}">
                    <tr>
                        <td align="left">${produto.idProduto}</td>
                        <td align="left">${produto.descricao}</td>
                        <td align="left">${produto.marca.descricao}</td>
                        <td align="left">${produto.dataValidade}</td>
                        <td align="center">
                    <a href="${pageContext.request.contextPath}/ProdutoExcluir?idProduto=${produto.idProduto}">
                        Excluir</a></td>
                <td align="center">
                    <a href=
                       "${pageContext.request.contextPath}/ProdutoCarregar?idProduto=${produto.idProduto}">
                        Alterar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
    </div>
    <div align="center">
        <a href="${pageContext.request.contextPath}/ProdutoNovo">Novo</a>
        <a href="index.jsp">Voltar à Página Inicial</a>
        </div>
    <script>
        $(document).ready(function() {
            console.log('entrei ready');
            $('#datatable').DataTable({
                "oLanguage": {
                    "sProcessing": "Processando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "Nenhum registro encontrado.",
                    "sInfo": "Mostrando de _START_até _END_ de _TOTAL_ registros",
                    "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                    "sInfoFiltered": "",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
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
