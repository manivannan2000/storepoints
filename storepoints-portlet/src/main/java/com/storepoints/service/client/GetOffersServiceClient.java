package com.storepoints.service.client;

import java.util.List;

import javax.xml.bind.JAXBElement;

import com.storepoints.service.GetStores;
import com.storepoints.service.GetStoresResponse;
import com.storepoints.service.ObjectFactory;
import com.storepoints.service.Store;

public class GetOffersServiceClient extends AbstractSPServiceClient {
	
	private List<Store> stores;

	@Override
	protected String getStoreType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void inflateResponse(Object responseObj) {
		JAXBElement<GetStoresResponse> responseObjJAXB= (JAXBElement<GetStoresResponse>)responseObj;
		
		GetStoresResponse getStoresResponse= responseObjJAXB.getValue();
		
		setStores(getStoresResponse.getReturn());
	}

	@Override
	protected Object getSPServiceRequest() {
		ObjectFactory objectFactory = new ObjectFactory();
		
		GetStores getStores = new GetStores();
		
		return objectFactory.createGetStores(getStores);
	}
	
	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

}
