<%@ include file="/WEB-INF/view/common/include.jsp" %>


<portlet:defineObjects/>

<%-- 
<span class="banner">
	<%=renderRequest.getPortletSession().getAttribute("banner")%>
</span> 
<span class="version">
	v1.0.0.0
</span>

 --%>
 
 
 <portlet:resourceURL var="doAjaxURL" id="doAjax" escapeXml="false" />
 
     <!-- page specific -->
    <style type="text/css">
        /* style rows on mouseover */
        .x-grid-row-over .x-grid-cell-inner {
            font-weight: bold;
        }
        /* shared styles for the ActionColumn icons */
        .x-action-col-cell img {
            height: 16px;
            width: 16px;
            cursor: pointer;
        }
        /* custom icon for the "buy" ActionColumn icon */
        .x-action-col-cell img.edit-col {
            background-image: url(http://store-points.com/Icons/Edit.png);
        }
        /* custom icon for the "alert" ActionColumn icon */
        .x-action-col-cell img.alert-col {
            background-image: url(../shared/icons/fam/error.png);
        }

        .x-ie6 .x-action-col-cell img.edit-col {
            background-image: url(http://store-points.com/Icons/Edit.png);
        }
        .x-ie6.x-action-col-cell img.alert-col {
            background-image: url(../shared/icons/fam/error.gif);
        }

        .x-ie6 .x-action-col-cell img {
            position:relative;
            top:-1px;
        }
    </style>
    
    
	<script  type="text/JavaScript">
	
	Ext.require([
	             'Ext.grid.*',
	             'Ext.data.*',
	             'Ext.util.*',
	             'Ext.state.*'
	         ]);
	
	Ext.define('StorePoints', {
	    extend: 'Ext.data.Model',
	    fields: [
	       {name: 'accountid'},
	       {name: 'storeName'},
	       {name: 'storeLandMark'},
	       {name: 'storePoint'}
	    ],
	    idProperty: 'accountid'
	});
	
	Ext.onReady(function() {
	    Ext.QuickTips.init();
	    
	    // setup the state provider, all state information will be saved to a cookie
	    Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));

	    // sample static data for the store
	    var myData = [
			<c:forEach items="${storepointsaccounts}" var="storePointsAccount" varStatus="status">		            	
	            ['${storePointsAccount.accountId}','${storePointsAccount.storeName}','${storePointsAccount.storeLandMark}','${storePointsAccount.storePoint}' ]  ${not status.last ? ',' : ''}        		
            </c:forEach>
            ];
	
	    // create the data store
	    var storeAccounts = Ext.create('Ext.data.ArrayStore', {
	        model: 'StorePoints',
	        data: myData
	    });
	    
	    // create the Grid
	    var grid = Ext.create('Ext.grid.Panel', {
      		url	:'${doAjaxURL}',
	        store: storeAccounts,
	        stateful: true,
	        collapsible: true,
	        multiSelect: true,
	        stateId: 'stateGrid',
	        columns: [
	                  {
	                      text     : 'Store Account Id',
	                      flex     : 1,
	                      sortable : false,
	                      dataIndex: 'accountid'
	                  },
	                  {
	                      text     : 'Store Name',
	                      width    : 200,
	                      sortable : true,
	                      dataIndex: 'storeName'
	                  },
	                  {
	                      text     : 'Store Landmark',
	                      width    : 200,
	                      sortable : true,
	                      dataIndex: 'storeLandMark'
	                  },
	                  {
	                      text     : 'Store Points',
	                      width    : 75,
	                      sortable : true,
	                      dataIndex: 'storePoint'
	                  },
	                  {
	                      menuDisabled: true,
	                      sortable: false,
	                      xtype: 'actioncolumn',
	                      width: 50,
	                      items: [ {
	                          icon   : 'http://store-points.com/Icons/Edit.png',  // Use a URL in the icon config
	                          tooltip: 'View Transaction Details',
	                          handler: function(grid, rowIndex, colIndex) {
	                              var rec = storeAccounts.getAt(rowIndex);
	                              alert("View Transaction Details " + rec.get('accountid'));
	                              window.location.href="<portlet:renderURL><portlet:param name='action' value='listStores'/></portlet:renderURL>";
	                          }
	                      }
	                      ]
	                  }
	              ],
	              title: 'Participating Store Points',
	              layout:'fit',
	              renderTo: 'grid-storeaccounts',
	              viewConfig: {
	                  stripeRows: true,
	                  enableTextSelection: true
	              }
	          });
	      });
	
	</script>

    <div id="grid-storeaccounts"></div>
	    
	    
	    
	
<%--	
 
    	<h3><label>Storepoints Details</label></h3>

                    <c:forEach items="${storepointsaccounts}" var="storePointsAccount">		            	
                        <div class="events">
                            <table class="tStatus" cellpadding="0" cellspacing="0">                        
                                <tr>
                                    <td>${storePointsAccount.accountid}</td>
                                    <td>${storePointsAccount.storeName }</td>
                                    <td>${storePointsAccount.storePoint }</td>
                                </tr>
                            </table>
                        
                        </div>        	
                    </c:forEach>


 --%>
