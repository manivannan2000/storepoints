<%@ page contentType="text/html" isELIgnored="false" %>

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>

<portlet:defineObjects/>

<portlet:actionURL var="actionUrl">
	<portlet:param name="action" value="storepointslist" />
</portlet:actionURL>

<form:form name="form1" modelAttribute="getusercontact" method="post" action="${actionUrl}">

	<label>Enter your contact phone/email address shared with store:</label> 
	
	<input size="50" type="text" value="" name="contactname"/>
	
	<input type="submit" value="Save" id="save"/>
	
</form:form>