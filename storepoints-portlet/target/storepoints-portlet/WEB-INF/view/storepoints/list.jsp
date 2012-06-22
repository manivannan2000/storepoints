<%@ page contentType="text/html" isELIgnored="false" %>

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>


<portlet:defineObjects/>
<%--<span class="banner">
	<%=renderRequest.getPortletSession().getAttribute("banner")%>
</span>  --%>
<span class="version">
	v1.0.0.14
</span>

    	<h3><label>Storepoints Details</label></h3>

                    <c:forEach items="${storepointsaccounts}" var="storePointsAccount">		            	
                        <div class="events">
                            <table class="tStatus" cellpadding="0" cellspacing="0">                        
                                <tr>
                                    <td>${storePointsAccount.accountid}</td>
                                    <td>${storePointsAccount.accountName }</td>
                                    <td>${storePointsAccount.storePoint }</td>
                                </tr>
                            </table>
                        
                        </div>        	
                    </c:forEach>



