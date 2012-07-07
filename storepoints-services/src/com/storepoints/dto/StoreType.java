package com.storepoints.dto;

public enum StoreType {
	
	RESTAURANTS, //represents Restaurants
	TEXTILES,// represents Textiles
	JEWEL, //represents Jewelleries
	FURNITURES, //represents furnitures
	GROCERY, // represents grocery stores
	PHARMA, //represents Pharmacy stores
	ELECTRONICS, //represents electronics shops
	STATIONARY, //represents stationary shops
	OTHER;// represents others 
	
	
	@Override 
	public String toString() {
		return super.toString();
	}
	
//	@Override 
//	public StoreType valueOf(String typeVal){
//		StoreType[] storeTypes=StoreType.values();
//		StoreType storeTypeForVal=null;
//		
//		for(StoreType storeType: storeTypes){
//			if(storeType.toString().equals(typeVal)){
//				storeTypeForVal= storeType;
//				break;
//			}
//		}
//		return storeTypeForVal;
//	}
	

}
