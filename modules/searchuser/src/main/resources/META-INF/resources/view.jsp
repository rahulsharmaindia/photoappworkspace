<%@ include file="init.jsp" %>
<%@ include file="validation-error-popup.jsp" %>
<style>
.portlet-title-text{
display:none;
}
</style>
<script>
jQuery(document).ready(function(){
	var errorMsg = "<%=request.getAttribute("error")%>";
	
	if(errorMsg != "null"){
		jQuery("#modalbody").empty();
		jQuery("#modalbody").append(errorMsg);
		jQuery("#responsive").modal();	
		jQuery("#responsive").show();
	}	
});

</script>

<portlet:actionURL name="searchByEmail" var="searchUserUrl">
</portlet:actionURL>

<portlet:actionURL name="cancelBtn" var="redirectToNative" >
 	<portlet:param name="param" value="/redirect-to-native" />
 </portlet:actionURL>
 
<div class="container" style="height:100%;">
	<b>Provide Email Address with which Album needs to be shared:</b> 
	
<div><br/><br/><br/><br/></div>
<aui:form action="<%=searchUserUrl %>" autocomplete='off' method="post" name="searchUserForm">
	<aui:row>
		<aui:col span="12">
			<aui:input name="emailAddress" label="Email Address" type="text" >
			<aui:validator name="required" />
		</aui:input>
		</aui:col>
	</aui:row>
	<aui:button-row>
		<aui:button type="submit" value="Verify"/>	
		<aui:button type="cancel" onClick="<%= redirectToNative %>" />
	</aui:button-row>
	<aui:input name="directoryId" type="hidden" value="<%=request.getAttribute("directoryId")%>" />
	
</aui:form>
</div>



