<%@ include file="init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<style>
.portlet-title-text{
display:none;
}
</style>
<portlet:actionURL name="successBtn" var="createUserSuccess" >
 	<portlet:param name="param" value="/redirect-to-native" />
 </portlet:actionURL>
 
 <div class="container" style="height:100%;">
	<b>Action Complete:</b>
<div><br/><br/></div>
<div class="container">
  <h2>Success!</h2>
  <div class="alert alert-success">
    <strong>UserID:<b>"<%=request.getAttribute("userName")%>"</b> created Successfully.</strong> 
  </div>	
	<aui:button-row>			
		<aui:button type="OK" value="OK" onClick="<%= createUserSuccess %>" />
	</aui:button-row>	

</div>