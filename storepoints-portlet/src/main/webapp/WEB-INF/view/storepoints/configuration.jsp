<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %> 
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %> 
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.portlet.*" %>
 
<%@ page import="javax.portlet.*" %> 

<portlet:defineObjects />

<% 

PortletPreferences prefs = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
    prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String storeType = (String)prefs.getValue("STORETYPE","");

%>
<form action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm">    
    Store Type: <input size="50" type="text" value="<%=storeType%>" name="<portlet:namespace />STORETYPE"><br/><br/>    
    
    <input type="hidden" name="action" value="save">
    <input type="button" value="Save" onClick="submitForm(document.<portlet:namespace />fm);" /><br/><br/>             
</form>
  