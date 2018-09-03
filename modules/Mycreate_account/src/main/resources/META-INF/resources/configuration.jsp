<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>"
    var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>"
    var="configurationRenderURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">

    <aui:input name="<%= Constants.CMD %>" type="hidden"
        value="<%= Constants.UPDATE %>" />

    <aui:input name="redirect" type="hidden"
        value="<%= configurationRenderURL %>" />

    <aui:fieldset>

        <aui:input name="userRole" label="Role of new User"
            value="<%= userRole %>">
        </aui:input>
        <aui:input name="userOrganization" label="Organization of new User"
            value="<%= userOrganization %>">
        </aui:input>
		<aui:input name="redirectURL" label="Url to navigate to Native."
            value="<%= redirectURL %>">
        </aui:input>
    </aui:fieldset>
    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>