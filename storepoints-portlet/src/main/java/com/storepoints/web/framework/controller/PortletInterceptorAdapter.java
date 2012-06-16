package com.storepoints.web.framework.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.web.portlet.HandlerInterceptor;
import org.springframework.web.portlet.ModelAndView;

public class PortletInterceptorAdapter implements HandlerInterceptor{

	@Override
	public void afterActionCompletion(ActionRequest request,
			ActionResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterEventCompletion(EventRequest request,
			EventResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterRenderCompletion(RenderRequest request,
			RenderResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterResourceCompletion(ResourceRequest request,
			ResourceResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandleRender(RenderRequest request,
			RenderResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandleResource(ResourceRequest request,
			ResourceResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandleAction(ActionRequest request,
			ActionResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean preHandleEvent(EventRequest request, EventResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean preHandleRender(RenderRequest request,
			RenderResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean preHandleResource(ResourceRequest request,
			ResourceResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
