package com.storepoints.web.controller;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.PortletRequestDataBinder;

import com.storepoints.service.Store;
import com.storepoints.service.StoreType;
import com.storepoints.service.client.AddStoreServiceClient;
import com.storepoints.service.client.GetStoresServiceClient;
import com.storepoints.web.dto.GetUserContact;
import com.storepoints.web.dto.StoreForm;


@Controller
@RequestMapping("VIEW")
public class StorePointsAdminController {
	
	@InitBinder
	protected void initBinder(PortletRequestDataBinder binder) {
	}
	
	
	@RequestMapping()
	public String getStorePointsAdminPage(Model model, RenderRequest renderRequest,
			RenderResponse renderResponse, @RequestParam(value="statusMessage",required=false) String statusMessage) {
		
		if(statusMessage!=null){
			model.addAttribute("statusMessage",statusMessage);
		}
		
		return "storepoints/admin/storeadmin";

	}

	
	/** For the Action phase */
	@RequestMapping(params = "action=listStores")
	public void listStores(
			ActionRequest request,
			ActionResponse response,
			BindingResult result, Model model) {
		
		response.setRenderParameter("action", "listStores");
	}
	
	
	/** For the Action phase */
	@RequestMapping(params = "action=createStore")
	public void createStore(
			ActionRequest request,
			ActionResponse response,
			BindingResult result, Model model) {
		
		response.setRenderParameter("action", "createStore");
	}
	
	
	@RequestMapping(params = "action=createStore")
	public String createStore(Model model,
			RenderRequest renderRequest,
			RenderResponse renderResponse) {
		
		StoreForm storeForm= new StoreForm(); 
		
		model.addAttribute("storeForm",storeForm);
		
		return "storepoints/admin/createStore";
	}
	
	@RequestMapping(params = "action=createStorePut")
	public void createStorePut(
			ActionRequest request,
			ActionResponse response,
			@ModelAttribute("storeForm") StoreForm storeForm,
			BindingResult result, Model model) {
		
		
		AddStoreServiceClient addStoreServiceClient = new AddStoreServiceClient(storeForm);
		
		addStoreServiceClient.makeServiceCall();
		if(addStoreServiceClient.isStoredStatus()){
			response.setRenderParameter("statusMessage","Store "+storeForm.getStoreName()+" added successfully.");
		}
		
		response.setRenderParameter("action", "");
	}
	
	@RequestMapping(params = "action=listStores")
	public String listStores(Model model,
			RenderRequest renderRequest,
			RenderResponse renderResponse) {
		
		GetStoresServiceClient getStoresServiceClient = new GetStoresServiceClient();
		
		getStoresServiceClient.makeServiceCall();
		
		model.addAttribute("storepointsstores",getStoresServiceClient.getStores() );

		return "storepoints/admin/listStores";

	}
}
