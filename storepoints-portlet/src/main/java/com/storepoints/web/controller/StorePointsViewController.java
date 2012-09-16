package com.storepoints.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

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

import com.storepoints.service.StorePointsService;
import com.storepoints.service.client.GetAccountsServiceClient;
import com.storepoints.service.client.GetStoresServiceClient;
import com.storepoints.web.dto.GetUserContact;

import javax.servlet.http.Cookie;


@Controller
@RequestMapping("VIEW")
public class StorePointsViewController {
	
	//com.storepoints.web.controller.StorePointsViewController

//	private final org.apache.commons.logging.Log logger = org.apache.commons.logging.LogFactory
//			.getLog(StorepointsViewController.class);
	// private UserDTO userDTO = null;


	@InitBinder
	protected void initBinder(PortletRequestDataBinder binder) {
		
	}
	
	@RequestMapping()
	public String getUserContact(Model model, RenderRequest renderRequest,
			RenderResponse renderResponse) {

		PortletPreferences prefs = renderRequest.getPreferences();
		
		String storeType = (String)prefs.getValue("STORETYPE","");
		
//		Cookie[] cookies = renderRequest.getCookies();
//		
//		
//		for(Cookie cookie:cookies){
//			if(cookie.getName().equals("CONTACT_NAME")){
				
//				String contactCookieValue = cookie.getValue();
//				System.out.println("contactCookieValue:"+contactCookieValue);
		
				PortletSession pSession = renderRequest.getPortletSession();
	
		      if(pSession.getAttribute("CONTACT_NAME",PortletSession.APPLICATION_SCOPE)!=null){
		    	  
		    	  String contactSessionValue = (String)pSession.getAttribute("CONTACT_NAME",PortletSession.APPLICATION_SCOPE);
		    	  
					System.out.println("contact value from session:"+contactSessionValue);


					GetAccountsServiceClient  client = new GetAccountsServiceClient(contactSessionValue,storeType);
					client.makeServiceCall();
					
					model.addAttribute("storepointsaccounts",client.getAccountsData() );

					return "storepoints/list";

		      }
		
				
//			}
			
		
		return "storepoints/getusercontact";
	}
	
	/** TO BE REMOVED --START **/	
	/** For the Action phase */
	@RequestMapping(params = "action=listStores")
	public void listStores(
			ActionRequest request,
			ActionResponse response,
			BindingResult result, Model model) {
		
		response.setRenderParameter("action", "listStores");
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

	/** TO BE REMOVED -- END **/	
	
	
	/** For the Action phase */
	@RequestMapping(params = "action=storepointslist")
	public void createNOAccount(
			ActionRequest request,
			ActionResponse response,
			@ModelAttribute("getusercontact") GetUserContact userContact,
			BindingResult result, Model model) {
		
		response.setRenderParameter("contactname", userContact.getContactname());
		response.setRenderParameter("action", "storepointslist");
	}

	@RequestMapping(params = "action=storepointslist")
	public String listStorePoints(Model model, @RequestParam("contactname") String contactname,
			RenderRequest renderRequest,
			RenderResponse renderResponse) {

//			StorePointsService storePointsService = new StorePointsServiceImpl();
		
		PortletSession pSession = renderRequest.getPortletSession();
		
		PortletPreferences prefs = renderRequest.getPreferences();
		
		String storeType = (String)prefs.getValue("STORETYPE","");
		
		if(storeType!=null && !storeType.trim().equals("")){
			
			
			System.out.println("contactname value:"+contactname);
			
			Cookie cookie = new Cookie("CONTACT_NAME",contactname);
			
			renderResponse.addProperty(cookie);
			
			pSession.setAttribute("CONTACT_NAME",contactname , PortletSession.APPLICATION_SCOPE);
			
			
			GetAccountsServiceClient  client = new GetAccountsServiceClient(contactname,storeType);
			client.makeServiceCall();
			
			model.addAttribute("storepointsaccounts",client.getAccountsData() );

		}

		return "storepoints/list";

	}



}
