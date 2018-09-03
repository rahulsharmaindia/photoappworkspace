<%@ include file="init.jsp" %>
<%@ include file="validation-error-popup.jsp" %>
<liferay-portlet:actionURL name="createUser" var="myactionURL" />
<liferay-portlet:actionURL name="redirectToNative" var="nativeAfterSuccess" >
	<liferay-portlet:param name="redirectURL" value="<%=(String)redirectURL%>" />
</liferay-portlet:actionURL> 
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
	
	var successMsg = "<%=request.getAttribute("success")%>";	
	var userId = "<%=request.getAttribute("userName")%>";
	var emailId = "<%=request.getAttribute("emailId")%>";
	var pwd = "<%=request.getAttribute("pwd")%>";
	if(successMsg != "null" && successMsg == "success"){		
		jQuery("#modalbody").empty();
		jQuery("#title-model").empty();
		var msg = "Login using Email ID: <span style='color:green;'><b>" + emailId + "</b></span> of UserID: <span style='color:green;'><b>"+ userId + " </b></span> <br/> Click <span style='color:red;' ><b>Close</b> </span>to redirect Login Screen!!!"	
		jQuery("#modalbody").append(msg);
		jQuery("#title-model").append("Success!!!");
		jQuery("#responsive").modal();	
		jQuery("#responsive").show();
		
		jQuery("#createActBtn").click(function () {			
			 var redirectLink ="<%=(String)redirectURL%>"
			redirectLink = redirectLink + "?emailId=" + emailId +  "&pwd="+ pwd;			
			window.location.href=redirectLink;			
		})
	}
	
	
});

</script>

<aui:form action="${myactionURL}" autocomplete='off' method="post" name="signupform">

	<aui:row>
		<aui:col span="12">
			<aui:input name="emailAddress" label="EmailAddress" type="text"  autocomplete="off">
			<aui:validator name="required" />
			</aui:input>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<aui:input name="firstName" label="FirstName" type="text"  autocomplete="off">
			<aui:validator name="required" />
			</aui:input>
		</aui:col>
		<aui:col span="6">
			<aui:input name="lastName" label="LastName" type="text"  autocomplete="off">
			<aui:validator name="required" />
			</aui:input>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col span="6">
			<aui:input name="password" label="Password" type="password"  autocomplete="off">
			<aui:validator name="required" />
			</aui:input>
		</aui:col>
		<aui:col span="6">
			<aui:input name="password1" label="Password Again" type="password"  autocomplete="off">
			<aui:validator name="required" />
			</aui:input>
		</aui:col>
	</aui:row>
	<aui:button-row>
		<aui:button type="submit"></aui:button>		
		<aui:button type="cancel" onClick="<%= nativeAfterSuccess %>" />
	</aui:button-row>
	<aui:input name="userRole" type="hidden" value="<%= userRole %>" />
	<aui:input name="userOrganization" type="hidden" value="<%= userOrganization %>" />
	<aui:input name="redirectURL" type="hidden" value="<%= redirectURL %>" />
	<aui:input name="pwd" type="hidden" value="<%= request.getAttribute("pwd") %>" />		
</aui:form>