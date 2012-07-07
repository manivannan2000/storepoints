<%@ include file="/WEB-INF/view/common/include.jsp" %>


    	<h3><label>Storepoints store Details</label></h3>

				<table class="tStatus" cellpadding="0" cellspacing="0">   
                            	<tr>
                            		<th>Store ID</th>
                            		<th>Store Name</th>
                            		<th>Store Type</th>
                                <tr>
                    <c:forEach items="${storepointsstores}" var="store">		            	
                            	<tr>
                            		<td>${store.storeId}</td>
                            		<td>${store.storeName}</td>
                            		<td>${store.storeType}</td>
                            	</tr>
                    </c:forEach>
				</table>
