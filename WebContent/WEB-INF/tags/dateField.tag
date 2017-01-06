<%@ tag language="java" pageEncoding="UTF-8"%>


<!-- this directive makes our tag receives parameters. Name represents the attribute's name  -->
<%@ attribute name="id" required="true" %>

<input type="text" id="${id}" name="${id}"/>
<script>
$("#${id}").datapicker({dateFormat: 'dd/mm/yy'});
</script>
