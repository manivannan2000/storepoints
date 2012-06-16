package com.storepoints.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
import com.storepoints.service.StorePointsServiceImpl;


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
	public String listStorePoints(Model model, RenderRequest renderRequest,
			RenderResponse renderResponse) {

			StorePointsService storePointsService = new StorePointsServiceImpl();
		
			model.addAttribute("storepointsaccounts",storePointsService.getAccounts() );

		return "storepoints/list";

	}



}
