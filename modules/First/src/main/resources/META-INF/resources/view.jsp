<%@page import="com.rsystems.service.PhotoAppConfigurationLocalServiceUtil"%>
<%@page import="com.rsystems.model.PhotoAppConfiguration"%>
<%@page import="org.rsystems.model.LdapConfigModel"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL name="processAction" var="myactionURL" />
<%
PhotoAppConfiguration appConfiguration = null;
LdapConfigModel ldapConfig =null;
try {
	appConfiguration = PhotoAppConfigurationLocalServiceUtil.fetchPhotoAppConfiguration("LDAP_CONFIGURATION");
	ldapConfig = new LdapConfigModel();
	ldapConfig.setLdapurl(appConfiguration.getValue1());
	ldapConfig.setLdapuser(appConfiguration.getValue2());
	ldapConfig.setLdappass(appConfiguration.getValue3());
} catch (Exception e) {
	e.printStackTrace();
}
%>
<aui:form action="${myactionURL}" method="post" name="fm" autocomplete='off'>
<aui:model-context bean="<%= ldapConfig %>" model="<%= LdapConfigModel.class %>" />
	<aui:input name="ldapurl" label="LDAP Connection URL" type="text" >
	<aui:validator name="required" />
	</aui:input>
	<aui:input name="ldapuser" label="LDAP User Name" type="text" >
	<aui:validator name="required" />
	</aui:input>
	<aui:input name="ldappass" label="LDAP Password" type="text" >
	<aui:validator name="required" />
	</aui:input>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel"></aui:button>
	</aui:button-row>
</aui:form>