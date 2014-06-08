package com.storepoints.web.controller;


import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;


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
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.PortletRequestDataBinder;

import com.storepoints.service.Store;
import com.storepoints.service.StoreType;
import com.storepoints.service.client.AddOfferServiceClient;
import com.storepoints.service.client.AddStoreServiceClient;
import com.storepoints.service.client.GetOffersServiceClient;
import com.storepoints.service.client.GetStoresServiceClient;
import com.storepoints.web.dto.GetUserContact;
import com.storepoints.web.dto.OfferForm;
import com.storepoints.web.dto.StoreForm;


@Controller
@RequestMapping("VIEW")
public class StorePointsOfferController {
	
	@InitBinder
	protected void initBinder(PortletRequestDataBinder binder) {
	}
	
	
	@RequestMapping()
	public String getStorePointsOfferPage(Model model, RenderRequest renderRequest,
			RenderResponse renderResponse, @RequestParam(value="statusMessage",required=false) String statusMessage) {
		
		if(statusMessage!=null){
			model.addAttribute("statusMessage",statusMessage);
		}
		
		return "storepoints/offer/storeoffer";

	}

	
	/** For the Action phase */
	@RequestMapping(params = "action=listOffers")
	public void listOffers(
			ActionRequest request,
			ActionResponse response,
			BindingResult result, Model model) {
		
		response.setRenderParameter("action", "listOffers");
	}
	
	
	/** For the Action phase */
	@RequestMapping(params = "action=createOffer")
	public void createOffer(
			ActionRequest request,
			ActionResponse response,
			BindingResult result, Model model) {
		
		response.setRenderParameter("action", "createOffer");
	}
	
	
//	@ResourceMapping(value="doAjax")
//	public void doAjax(ResourceRequest request, ResourceResponse response, @RequestParam
//	String storeName, String storeType){
//	response.setContentType("application/x-json");
//	
//		StoreForm storeForm= new StoreForm();
//		storeForm.setStoreName(storeName);
//		storeForm.setStoreType(storeType);
//		
//		AddStoreServiceClient addStoreServiceClient = new AddStoreServiceClient(storeForm);
//		
//		addStoreServiceClient.makeServiceCall();
//	
//		try{
//		response.getWriter().print("Store "+storeName+ " stored.");
//		}catch(IOException excp){
//			
//		}
//	}	
	
	@RequestMapping(params = "action=createOffer")
	public String createOffer(Model model,
			RenderRequest renderRequest,
			RenderResponse renderResponse) {
		
		OfferForm offerForm= new OfferForm(); 
		
		model.addAttribute("offerForm",offerForm);
		
		return "storepoints/offer/createOffer";
	}
	
	@RequestMapping(params = "action=createOfferPut")
	public void createStorePut(
			ActionRequest request,
			ActionResponse response,
			@ModelAttribute("offerForm") OfferForm offerForm,
			BindingResult result, Model model) {
		
		
		AddOfferServiceClient addOfferServiceClient = new AddOfferServiceClient(offerForm);
		
		try{
		
			addOfferServiceClient.makeServiceCall();
			if(addOfferServiceClient.isOfferStatus()){
				response.setRenderParameter("statusMessage","Offer "+offerForm.getOfferName()+" added successfully.");
			}
		
		} catch(Exception excp){
//			return "storepoints/error";
		}
		
		response.setRenderParameter("action", "");
	}
	
	@RequestMapping(params = "action=createOfferPut2")
	public void createStorePut(
			ActionRequest request,
			ActionResponse response,
			@RequestParam("offerName") String offerName,
			@RequestParam("offerType") String offerType,
			BindingResult result, Model model) {
		
		OfferForm offerForm= new OfferForm();
		offerForm.setOfferName(offerName);
		offerForm.setOfferType(offerType);
		
		AddOfferServiceClient addOfferServiceClient = new AddOfferServiceClient(offerForm);
		try{
			addOfferServiceClient.makeServiceCall();
			if(addOfferServiceClient.isOfferStatus()){
				response.setRenderParameter("statusMessage","Offer "+offerForm.getOfferName()+" added successfully.");
			}
		
		} catch(Exception excp){
//			return "storepoints/error";
		}

		response.setRenderParameter("action", "");
	}

	
	@RequestMapping(params = "action=listOffers")
	public String listOffers(Model model,
			RenderRequest renderRequest,
			RenderResponse renderResponse) {
		
		GetOffersServiceClient getOffersServiceClient = new GetOffersServiceClient();

		try{
		getOffersServiceClient.makeServiceCall();
		
		model.addAttribute("storepointsoffers",getOffersServiceClient.getStores() );

		return "storepoints/offer/listOffers";
		
		} catch(Exception excp){
			return "storepoints/offer/error";
		}


	}
}
