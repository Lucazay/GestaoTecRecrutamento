<%-- 
    Document   : marcaCadastrar
    Created on : 28/05/2022, 06:24:12
    Author     : Acer
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarmarca" action="MarcaCadastrar" method="POST">
    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro de Marca
                </th>
            </tr>
            <tr>
                <th colspan="2" align="center">${mensagem}</th>
            </tr>
        </thead>
        <tbody>
            <tr><td>ID: </td>
                <td><input type="text" name="idMarca" id="idMarca" value="${marca.idMarca}" readonly="readonly" /></td></tr>
                <tr><td>Descricao: </td>
                <td><input type="text" name="descricao" id="descricao" value="${marca.descricao}"
                           size="50" maxlength="50" /></td></tr>
            <tr><td>
                    <input type="hidden" name="situacao" id="situacao" value="${marca.situacao}"/>
                </td></tr>
            <tr><td colspan="2" align="center">
                    <input type="submit" name="cadastrar" id="cadastrar" value="Cadastrar" />
                    <input type="reset" name="limpar" id="limpar" value="Limpar" />
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><h5><a href="index.jsp"> Voltar à Página Inicial</a></h5></td>
            </tr>   
        </tbody>
    </table>
</form><%@include file="/footer.jsp" %>