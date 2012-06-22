package com.storepoints.web.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.PortletModeException;
import javax.portlet.ValidatorException;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.portlet.bind.annotation.ActionMapping;




@Controller
@RequestMapping("edit")
public class SPViewConfigController {
	
//	 @RequestMapping //Default action 
//	  public ModelAndView mainHandler(RenderRequest request, RenderResponse response) throws Exception
//	  {    
//	        Map<String, Object> model = new HashMap<String, Object>();
//	        return new ModelAndView("storepoints/configuration", model);
//	    }

	 
	 
	 	@RenderMapping
	    public String render(    Model model, PortletPreferences prefs)
	    {

	        model.addAttribute("attribute", prefs.getValue("STORETYPE", ""));

	        return "storepoints/configuration";
	    }
	 
	 
	 @ActionMapping(params = "action=save")
	  public void action(    @RequestParam("STORETYPE") String storeType,   PortletPreferences prefs,  ActionResponse response) throws ReadOnlyException, ValidatorException, IOException, PortletModeException
	    {

	                if (storeType != null && !storeType.equals(""))
	                {
	                    prefs.reset("STORETYPE");
	                    prefs.setValue("STORETYPE", storeType);
	                }

	                prefs.store();
	    }
}
