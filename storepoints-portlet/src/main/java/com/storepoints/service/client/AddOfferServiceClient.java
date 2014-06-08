package com.storepoints.service.client;

import java.util.UUID;

import javax.xml.bind.JAXBElement;

import com.storepoints.service.AddStore;
import com.storepoints.service.AddStoreResponse;
import com.storepoints.service.ObjectFactory;
import com.storepoints.service.Status;
//import com.storepoints.service.Offer;
import com.storepoints.service.StoreType;
import com.storepoints.web.dto.OfferForm;

public class AddOfferServiceClient extends AbstractSPServiceClient {
	
	private OfferForm offerForm;
	
	private boolean offerStatus;
	
	public AddOfferServiceClient(OfferForm offerForm){
		this.offerForm=offerForm;
		System.out.println("AddOffer called with "+offerForm.getOfferName()+" and "+offerForm.getOfferType());
	}

	public boolean isOfferStatus() {
		return offerStatus;
	}
	
	public void setOfferStatus(boolean offerStatus) {
		this.offerStatus = offerStatus;
	}
	

	@Override
	protected String getStoreType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void inflateResponse(Object responseObj) {
//		JAXBElement<AddStoreResponse> responseObjJAXB =(JAXBElement<AddStoreResponse>)responseObj;
//		
//		AddStoreResponse addStoreResponse = responseObjJAXB.getValue();
//		Status status =addStoreResponse.getReturn();
//		
//		setStoredStatus(status.isStatus().equals("true"));
	}

	@Override
	protected Object getSPServiceRequest() {
//		ObjectFactory objectFactory = new ObjectFactory();
//		
//		AddStore addStore = new AddStore();
//		
//		addStore.setArg0(getStoreFromForm(storeForm));
//		return objectFactory.createAddStore(addStore);
		return null;
	}
	
	
	
//	private Offer getOfferFromForm(OfferForm offerForm){
//		Offer offer = new Offer();
////		store.setStoreId(UUID.randomUUID().toString());
////		store.setStoreName(storeForm.getStoreName());
////		store.setStoreType(StoreType.fromValue(storeForm.getStoreType()));
//		
//		return offer;
//	}
	


}
