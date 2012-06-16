package com.storepoints.web.framework.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class SecurityInterceptor extends PortletInterceptorAdapter {

	private static final Log logger = LogFactory
			.getLog(SecurityInterceptor.class);

	private static final String BANNER = "banner";



	@Override
	public boolean preHandleAction(ActionRequest request,
			ActionResponse response, Object handler) throws Exception {
		return true;
	}

	// @Override
	// public boolean preHandleRender(RenderRequest request,
	// RenderResponse response, Object handler) throws Exception {
	//
	// if (request.getPortletSession().getAttribute(AdxWebConstants.ADXUSER) ==
	// null) {
	// UserDTO userDTO = this.getLoginInfo(request);
	// request.getPortletSession().setAttribute(AdxWebConstants.ADXUSER,
	// userDTO);
	// setBanner(request, userDTO);
	// }
	// return true;
	// }

	@Override
	public boolean preHandleRender(RenderRequest request,
			RenderResponse response, Object handler) throws Exception {
		return true;
	}

	/**
	 * @param namespace
	 */
	private String getPortletName(String namespace) {
		return namespace.substring(1, namespace.indexOf("_", 1));

	}

}
