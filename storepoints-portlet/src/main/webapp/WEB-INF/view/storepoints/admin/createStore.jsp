<%@ include file="/WEB-INF/view/common/include.jsp" %>


<portlet:defineObjects/>

<portlet:actionURL var="actionUrl">
	<portlet:param name="action" value="createStorePut" />
</portlet:actionURL>

<form:form name="form1" modelAttribute="storeForm" method="post" action="${actionUrl}">

           <fieldset class="fieldBlockL">
            	<legend>User Summary</legend>
                
                <div class="editLeft"><label>Store Name</label> <span><!-- --></span></div>
                <div class="editRight">
	                <form:input path="storeName" id="_storeName" class="textfield70" />
	                <form:errors class="errors" id="_storeName" path="storeName"/>
                </div> 
                <div class="editLeft"><label>Store Type</label> <span><!-- --></span></div>
                <div class="editRight">
	                <form:input path="storeType" id="_storeType" class="textfield70" />
	                <form:errors class="errors" id="_storeType" path="storeType"/>
                </div>
                <div class="editLeft"><input type="submit" value="Save" id="save"/> <span><!-- --></span></div>
                <div class="editRight">
                </div>
		</fieldset>
</form:form>