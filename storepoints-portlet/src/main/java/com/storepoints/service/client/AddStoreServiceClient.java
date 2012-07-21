package com.storepoints.service.client;

import java.util.UUID;

import javax.xml.bind.JAXBElement;

import com.storepoints.service.AddStore;
import com.storepoints.service.AddStoreResponse;
import com.storepoints.service.ObjectFactory;
import com.storepoints.service.Status;
import com.storepoints.service.Store;
import com.storepoints.service.StoreType;
import com.storepoints.web.dto.StoreForm;

public class AddStoreServiceClient extends AbstractSPServiceClient {
	
	private StoreForm storeForm;
	
	private boolean storedStatus;
	
	public AddStoreServiceClient(StoreForm storeForm){
		this.storeForm=storeForm;
		System.out.println("AddStore called with "+storeForm.getStoreName()+" and "+storeForm.getStoreType());
	}

	public boolean isStoredStatus() {
		return storedStatus;
	}


	public void setStoredStatus(boolean storedStatus) {
		this.storedStatus = storedStatus;
	}
	

	@Override
	protected String getStoreType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void inflateResponse(Object responseObj) {
		JAXBElement<AddStoreResponse> responseObjJAXB =(JAXBElement<AddStoreResponse>)responseObj;
		
		AddStoreResponse addStoreResponse = responseObjJAXB.getValue();
		Status status =addStoreResponse.getReturn();
		
		setStoredStatus(status.isStatus().equals("true"));
	}

	@Override
	protected Object getSPServiceRequest() {
		ObjectFactory objectFactory = new ObjectFactory();
		
		AddStore addStore = new AddStore();
		
		addStore.setArg0(getStoreFromForm(storeForm));
		return objectFactory.createAddStore(addStore);
	}
	
	
	
	private Store getStoreFromForm(StoreForm storeForm){
		Store store = new Store();
		store.setStoreId(UUID.randomUUID().toString());
		store.setStoreName(storeForm.getStoreName());
		store.setStoreType(StoreType.fromValue(storeForm.getStoreType()));
		
		return store;
	}
	


}
