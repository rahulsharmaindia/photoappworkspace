<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="myloginportlet_MyLogin.caption"/></b>
</p>

<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">

		<%
		String signedInAs = HtmlUtil.escape(user.getFullName());

		if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
			String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

			signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">" + signedInAs + "</a>";
		}
		
		%>

		<liferay-ui:message arguments="<%= signedInAs %>" key="you-are-signed-in-as-x" translateArguments="<%= false %>" />
	</c:when>
	<c:otherwise>
	
		<%
		String redirect = ParamUtil.getString(request, "redirect");
		%>
	
		<portlet:actionURL name="mylogin" var="loginURL">
			<!-- <portlet:param name="mvcRenderCommandName" value="mylogin" /> -->
		</portlet:actionURL>
		
		<form id="loginForm" action="<%=loginURL%>" autocomplete='off'
			cssClass="sign-in-form" method="post" name="loginForm">

			<input id="saveLastPath" name="saveLastPath" type="hidden" value="<%=false%>" /> 
			<input id="rememberMe" name="rememberMe" type="hidden" value="<%=true%>" /> 
			
			<input	id="redirect" name="redirect" type="hidden" value="<%=redirectURL%>" />

			<table style="width: 50%">
				<tbody>
					<tr>
						<td>User ID</td>
						<td><input id="userId" type="text"  autocomplete="off" name="userId" value=""></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>Email ID</td>
						<td><input id="emailId" type="text"  autocomplete="off" name="emailId" value=""></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input id="password" type="password"  autocomplete="off" name="password" value=""></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>Encrypted Password</td>
						<td><input id="encrypted" type="password"  autocomplete="off" name="encrypted" value=""></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</tbody>
			</table>
			<input type="submit" name="signIn" value="Sign In" />
		</form> 		
	</c:otherwise>
</c:choose>

