<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<%@ include file="validation-error-popup.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<portlet:actionURL name="successBtn" var="redirectToSuccess" >
 	<portlet:param name="param" value="/redirect-after-success" />
 </portlet:actionURL>
<style>
.portlet-title-text{
display:none;
}
</style>
<script>
jQuery(document).ready(function(){	
	var successMsg = "<%=request.getAttribute("success")%>";	
	var userId = "<%=request.getAttribute("userName")%>";	
	if(successMsg != "null" && successMsg == "success"){		
		jQuery("#modalbody").empty();
		jQuery("#title-model").empty();
		var msg = "Album shared successfully with UserId: <span style='color:green;'><b>"+ userId + " </b></span>.";	
		jQuery("#modalbody").append(msg);
		jQuery("#title-model").append("Success!!!");
		jQuery("#responsive").modal();	
		jQuery("#responsive").show();
		
		jQuery("#createActBtn").click(function () {
			window.location.href="<%= redirectToSuccess %>";
		})
	}
	
	
});

</script>
<portlet:actionURL name="shareWithSelectedEmails" var="shareUser">
</portlet:actionURL>
<portlet:actionURL name="cancelBtn" var="redirectToNative" >
 	<portlet:param name="param" value="/redirect-to-native" />
 </portlet:actionURL>

<div class="container" style="height:100%;">
	<b>Share Album with the selected email:</b>
<div><br/><br/><br/><br/></div>  
<aui:form action="<%=shareUser %>">
	<aui:row>
	<aui:col span="12">
	<aui:input name="validEmail" label="Email Address" type="text" value="<%=request.getAttribute("validEmail")%>" readonly="true">
	<aui:validator name="required" />
	</aui:input>
	</aui:col>
	</aui:row>	
	<aui:button-row>
		<aui:button type="submit" value="Share"/>		
		<aui:button type="cancel" onClick="<%= redirectToNative %>" />
	</aui:button-row>
	<aui:input name="directoryId" type="hidden" value="<%=request.getAttribute("directoryId")%>" />
	<aui:input name="userName" type="hidden" value="<%=request.getAttribute("userName")%>" />
</aui:form>
</div>