<%@ include file="/WEB-INF/view/common/include.jsp" %>


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

	Ext.define('Stores', {
	    extend: 'Ext.data.Model',
	    fields: [
	       {name: 'storeId'},
	       {name: 'storeName'},
	       {name: 'storeType'}
	    ],
	    idProperty: 'storeName'
	});
	
	Ext.onReady(function() {
	    Ext.QuickTips.init();
	    
	    // setup the state provider, all state information will be saved to a cookie
	    Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));

	    // sample static data for the store
	    var myData = [
			<c:forEach items="${storepointsstores}" var="store" varStatus="status">		            	
	            ['${store.storeId}','${store.storeName}','${store.storeType}' ]  ${not status.last ? ',' : ''}        		
            </c:forEach>
            ];
	    
	    
	    // create the data store
	    var store = Ext.create('Ext.data.ArrayStore', {
	        model: 'Stores',
	        data: myData
	    });
	    
	    
	    // create the Grid
	    var grid = Ext.create('Ext.grid.Panel', {
	        store: store,
	        stateful: true,
	        collapsible: true,
	        multiSelect: true,
	        stateId: 'stateGrid',
	        columns: [
	                  {
	                      text     : 'Store Id',
	                      flex     : 1,
	                      sortable : false,
	                      dataIndex: 'storeId'
	                  },
	                  {
	                      text     : 'Store Name',
	                      width    : 100,
	                      sortable : true,
	                      dataIndex: 'storeName'
	                  },
	                  {
	                      text     : 'Store Type',
	                      width    : 75,
	                      sortable : true,
	                      dataIndex: 'storeType'
	                  },
	                  {
	                      menuDisabled: true,
	                      sortable: false,
	                      xtype: 'actioncolumn',
	                      width: 50,
	                      items: [{
	                          icon   : 'http://store-points.com/Icons/Delete.png',  // Use a URL in the icon config
	                          tooltip: 'Delete Store',
	                          handler: function(grid, rowIndex, colIndex) {
	                              var rec = store.getAt(rowIndex);
	                              alert("Delete Store " + rec.get('storeId'));
	                          }
	                      }, {
	                          icon   : 'http://store-points.com/Icons/Edit.png',  // Use a URL in the icon config
	                          tooltip: 'Edit Store',
	                          handler: function(grid, rowIndex, colIndex) {
	                              var rec = store.getAt(rowIndex);
	                              alert("Edit Store " + rec.get('storeId'));
	                          }
	                      }
	                      ]
	                  }
	              ],
	              title: 'List of Stores',
	              layout:'fit',
	              renderTo: 'grid-stores',
	              viewConfig: {
	                  stripeRows: true,
	                  enableTextSelection: true
	              }
	          });
	      });
	
	</script>

    <div id="grid-stores"></div>

<%-- 
    	<h3><label>Storepoints store Details</label></h3>

				<table class="tStatus" cellpadding="0" cellspacing="0">   
                            	<tr>
                            		<th>Store ID</th>
                            		<th>Store Name</th>
                            		<th>Store Type</th>
                                <tr>
				</table>
--%>