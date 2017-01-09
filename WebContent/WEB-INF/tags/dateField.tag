<%@ tag language="java" pageEncoding="UTF-8"%>

<%--Created by Eduardo Geralde Neto

This is just a example of creating our own tags, to simplify all repetitive work, in this case, date picker--%>


<!-- This directive makes our tag receives parameters. Name represents the attribute's name  -->
<%@ attribute name="id" required="true" %>

<input type="text" id="${id}" name="${id}"/>
<script>
$("#${id}").datepicker({dateFormat: 'dd/mm/yy', changeYear:true, changeMonth:true});
</script>
