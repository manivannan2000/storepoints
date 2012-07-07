<%@ include file="/WEB-INF/view/common/include.jsp" %>

<portlet:defineObjects/>

   <c:if test="${not empty statusMessage }" >
   	<h3>${statusMessage}</h3>
   </c:if>

	<ul class="button">
	    <li class="btnLt"></li>
		<li><a href="<portlet:renderURL><portlet:param name="action" value="createStore"/></portlet:renderURL>">Create Store</a> </li>
		<li class="btnRt"></li>
	</ul>
	<ul class="button">
		 <li class="btnLt"></li>
		 <li><a href="<portlet:renderURL><portlet:param name="action" value="listStores"/></portlet:renderURL>">List Stores</a></li>
		<li class="btnRt"></li>
	</ul>
