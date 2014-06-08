<%@ include file="/WEB-INF/view/common/include.jsp" %>


<portlet:defineObjects/>
<%--
<portlet:actionURL var="actionUrl">
	<portlet:param name="action" value="createStorePut" />
</portlet:actionURL>
 --%>

<portlet:resourceURL var="doAjaxURL" id="doAjax" escapeXml="false" />


<script type="text/javascript">
	
	

		Ext.onReady(function() {
			
			var p1 = new Ext.Panel({
                title: 'Store Information',
                id: 'p1',
                frame:true,
                collapsible: true,  	// panel can be collapsible
                collapsed: false,		// panel is initially collapsed if true
                titleCollapse: true,	// can click title to collapse/expand
                bodyStyle:'padding:5px',
                style: 'clear:both',
				items: [{
				    xtype:'fieldset',
                    title: 'Store Name and Type',
    	            autoHeight: true,
				    layout:'column',
				    items:[{
					    xtype: 'hidden',
					    name: 'action',
					    value: 'createStorePut2'
				    },{
				        columnWidth:.5,
				        layout: 'form',
		                labelAlign: 'top',
				        border:false,
				        items: [{
				            xtype:'textfield',
				            fieldLabel: 'Store Name',
				            id: 'storeName',
				            name: 'storeName',
				            value: '',
				            //allowBlank: false, 	// use javascript validation instead to perform required validations together before submit
				            maxLength: 100,		
				            tabIndex: 1,
				            msgTarget: 'under',
				            anchor:'90%'
				        }]
				    },{
				        columnWidth:.5,
				        layout: 'form',
				        labelAlign: 'top',
				        border:false,
				        items: [{
				            xtype:'textfield',
				            fieldLabel: 'Store Type',
				            id: 'storeType',
				            name: 'storeType',
				            value: '',
				            maxLength: 100,
				            tabIndex: 2,
				            msgTarget: 'under',
				            anchor:'90%'
		        		}]
		        }]
			}]
		});
				        
			
			var systemErrorDisplayField = new Ext.form.DisplayField({
				id:'systemErrorDisplayField',
				hidden:true,
				hideLabel:true,
				msgTarget:'under'
			});
			
			
	        var expandCollapseAllContainer = new Ext.Container({
	        	id: 'expandCollapseAllContainer',
	        	layout:'form',
	        	style:'float:right',
	        	autoWidth: true,
	        	items:[{
	        		xtype: 'displayfield',
	        		id: 'expandCollapseAllLink',
	        		value: '[+] Expand All',
	        		cls: 'collapsed',
	        		style: 'font-size:11px;cursor:pointer',
	        		hideLabel: true,
	        		listeners: {
						render: function(){
							this.getEl().on("click", expandCollapseAll);
					    }
					}
	        	}]
	        });
	        		
			function expandCollapseAll(){
	      		if (this.hasClass('collapsed')){
	      			expandAll(this);
	      		} else {
	      			collapseAll(this);
				}
			}
			
			function expandAll(link){
				p1.expand(false); 	// expand without animation
				p2.expand(false);
				p3.expand(false);
				p4.expand(false);
				p5.expand(false);
				link.replaceClass('collapsed','expanded');
				link.update('[&#8211;] Collapse All');					
			}
			
			function collapseAll(link){
				p1.collapse(false); // collapse without animation
				p2.collapse(false);
				p3.collapse(false);
				p4.collapse(false);
				p5.collapse(false);
				link.replaceClass('expanded','collapsed');
				link.update('[+] Expand All');					
			}
			
			
			function resetButtonHandler(button){
				if (button=='yes'){
					Ext.getCmp('storeName').setValue('');
					Ext.getCmp('storeType').setValue('');
				}
			}
			
			function isEmpty(s){
				if (s==null || s==undefined || s.trim()==""){
					return true;
				} else {
					return false;
				}
			}
			
			function validateStoreForm(){
				//var isValidContactInformation = true;
				var isValidated = true;
				// ------------------------------------------------------------
				// general information panel validation
				// ------------------------------------------------------------
				var storeName = Ext.getCmp('storeName');
				if (isEmpty(storeName.getValue())){
					storeName.markInvalid('Store Name is required');
					isValidated = false;
				}
				var storeType = Ext.getCmp('storeType');
				if (isEmpty(storeType.getValue())){
					storeType.markInvalid('Store Type is required');
					isValidated = false;
				}
				return isValidated;
			}
			
			function showSystemError(){
	        	expandAll(Ext.get('expandCollapseAllLink'));
	        	window.scroll(0,0);
	        	Ext.MessageBox.show({
	                title: 'Validation Errors',
	                msg: 'There are validation errors that need your attention.',
	                buttons: Ext.MessageBox.OK,
	                icon: 'ext-mb-error'
	            });
			}
			
			function showServerError(){
	        	expandAll(Ext.get('expandCollapseAllLink'));
	        	window.scroll(0,0);
	        	Ext.MessageBox.show({
	                title: 'Server Errors',
	                msg: 'Error performing the store creation. .There are server errors that need your attention.',
	                buttons: Ext.MessageBox.OK,
	                icon: 'ext-mb-error'
	            });
			}

			
		    /**
		     * Listen for storeCreation eerrors.
		     */
		   /*
		     function onStoreCreationException (response, operation) {
		        Ext.Msg.alert("Error store creation from server", operation.error);
		    }
*/

		    
		    /**
		    *				listeners:{
					exception: this.onStoreCreationException,
					scope:	this
				},

		    */
				        

          	var storeForm = new Ext.form.FormPanel({
          		url				:'${doAjaxURL}',
				frame			: true,
				title   		: 'Store Creation Form',
				autoHeight		: true,
	            layout			:'fit',
				bodyStyle		: 'padding: 5px',
				defaults		: { anchor:'0' },
				items   		: [ systemErrorDisplayField, expandCollapseAllContainer, p1 ],
				standardSubmit	: true,
				buttons			: [{
					text	:'Submit',
					width	: 90,
			        handler	: function() {
			        	var isValidated = true;
			        	var CLIENT_VALIDATION = true;
						if (CLIENT_VALIDATION) {
				        	isValidated = validateStoreForm();
						}
						if (isValidated){
							storeForm.getForm().submit({
				                url: '${doAjaxURL}',
				                scope: this,
				                success: function (formPanel, action) {
				                    var data = Ext.decode(action.response.responseText);
				                    alert("Success: " + data.msg);
				                },
				                failure: function (formPanel, action) {
				                    var data = Ext.decode(action.response.responseText);
				                    alert("Failure: " + data.msg);
				                }
				            });
 						} else {
							showSystemError();
						}
					},
					listeners : {
						exception : function(){
				        	Ext.MessageBox.show({
				                title: 'Server Errors',
				                msg: 'Error performing the store creation. .There are server errors that need your attention.',
				                buttons: Ext.MessageBox.OK,
				                icon: 'ext-mb-error'
				            });
						}
					}
				},{
			        text   	: 'Reset',
			        id	  	: 'resetButton',
			        handler: function() {
		        		//Ext.MessageBox.confirm('Confirm', 'All data you have entered will be lost. Are you sure?', resetButtonHandler);
			        	Ext.MessageBox.show({
			                title: 'Confirm',
			                msg: 'All data will be lost. Are you sure you want to reset the form?',
			                buttons: Ext.MessageBox.YESNO,
			                fn: resetButtonHandler,
			                icon: 'ext-mb-warning'
			            });

			        }
				}]
			});

          	// render the form
			storeForm.render(Ext.get("ext-form-container"));

		});	// end of onReady()

	</script>
          		
          		
	<div id="ext-form-container"></div>
	
<%--	
<form:form name="form1" modelAttribute="storeForm" id="storeFormId" method="post" action="${actionUrl}">
<form:hidden path="storeName" />
<form:hidden path="storeType" />
</form:form>	
          		

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

	 --%>
