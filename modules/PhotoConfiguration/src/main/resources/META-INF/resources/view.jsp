<%@page import="com.rsystems.service.PhotoAppConfigurationLocalServiceUtil"%>
<%@page import="org.rsystems.model.PhotoConfigModel"%>
<%@page import="com.rsystems.model.PhotoAppConfiguration"%>
<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL name="processAction" var="myactionURL" />
<%
PhotoAppConfiguration appConfiguration = null;
PhotoConfigModel photoConfig =null;
try {
	appConfiguration = PhotoAppConfigurationLocalServiceUtil.fetchPhotoAppConfiguration("PHOTO_CONFIGURATION");
	photoConfig = new PhotoConfigModel();
	photoConfig.setRootPath(appConfiguration.getValue1());
	photoConfig.setServerName(appConfiguration.getValue2());
} catch (Exception e) {
	e.printStackTrace();
}
%>
<aui:form action="${myactionURL}" method="post" name="fm" autocomplete='off'>
<aui:model-context bean="<%= photoConfig %>" model="<%= PhotoConfigModel.class %>" />
	<aui:input name="rootPath" label="Location where Files will be uploaded" type="text">
	<aui:validator name="required" />
	</aui:input>
	<aui:input name="serverName" label="Server Name" type="text" >
	<aui:validator name="required" />
	</aui:input>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel"></aui:button>
	</aui:button-row>
</aui:form>
