package com.storepoints.couchdb.rs.client;

import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.storepoints.dto.ContactEmail;
import com.storepoints.dto.ContactEmailList;
import com.storepoints.dto.ContactPhone;
import com.storepoints.dto.ContactPhoneList;
import com.storepoints.dto.StatusType;
import com.storepoints.dto.User;

public class GetUserRESTServiceClient extends AbstractRESTServiceClient {
	
	private User user;
	

	private String contactId;
	
	public GetUserRESTServiceClient(String contactId){
		this.contactId=contactId;
	}

	public String getContactId() {
		return contactId;
	}
	
	public User getUser() {
		return user;
	}

	@Override
	protected String getRESTUrl(){
		return	"http://localhost:5984/storepoints_dev";
	}

	
	@Override
	protected String getSPRESTServiceRequest() {
		return "_design/storeusers/_view/by_phonenumber_get_user?key=%22"+getContactId()+"%22";
	}

	@Override
	protected String getSPRESTPostData() {
		//As this service is primarily to get data.
		return null;
	}

	@Override
	protected void inflateResponse(Object responseObj) {
		
		JSONObject jsonObject = JSONObject.fromObject((String)responseObj);
		
		JSONArray userJSONArray = (JSONArray)jsonObject.get("rows");
		
		Iterator iteratorUser = userJSONArray.iterator();
		
		while(iteratorUser.hasNext()) {
			JSONObject userRowJSONObject =(JSONObject)iteratorUser.next();
			
			JSONObject userJSONObject = (JSONObject)userRowJSONObject.get("value");
			
			user = new User();
			
			user.setUserId(userJSONObject.getString("userUUID"));
			
			user.setFirstName(userJSONObject.getString("userFirstName"));
			
			user.setLastName(userJSONObject.getString("userLastName"));
			
			ContactPhoneList contactPhoneList = new ContactPhoneList();
			
			JSONArray phoneListJSONArray = (JSONArray)userJSONObject.get("contactPhoneList");
			
			Iterator iteratorPhoneList = phoneListJSONArray.iterator();
			
			while(iteratorPhoneList.hasNext()) {
				
				JSONObject phoneJSONObject = (JSONObject)iteratorPhoneList.next();
				
				ContactPhone contactPhone = new ContactPhone();
				
				contactPhone.setContactPhoneID(phoneJSONObject.getString("phoneNumber"));
				
				contactPhone.setContactPhoneNumber(phoneJSONObject.getString("phoneNumber"));
				
				contactPhone.setContactPhoneStatus(StatusType.valueOf(phoneJSONObject.getString("phoneStatus")));
				
				contactPhone.setAddedDate(phoneJSONObject.getString("addedDate"));
				
				contactPhoneList.getContactPhoneList().add(contactPhone);
			}
			
			user.setContactPhoneList(contactPhoneList);
			
			ContactEmailList contactEmailList = new ContactEmailList();
			
			JSONArray emailListJSONArray = (JSONArray)userJSONObject.get("contactEmailList");
			
			Iterator iteratorEmailList = emailListJSONArray.iterator();
			
			while(iteratorEmailList.hasNext()) {
				
				JSONObject emailJSONObject = (JSONObject)iteratorEmailList.next();
				
				ContactEmail contactEmail = new ContactEmail();
				
				contactEmail.setContactEmailID(emailJSONObject.getString("emailID"));
				
				contactEmail.setContactEmailAddress(emailJSONObject.getString("emailID"));
				
				contactEmail.setContactEmailStatus(StatusType.valueOf(emailJSONObject.getString("emailStatus")));
				
				contactEmail.setAddedDate(emailJSONObject.getString("addedDate"));
				
				contactEmailList.getContactEmailList().add(contactEmail);
			}
			
			user.setContactEmailList(contactEmailList);
			
			JSONArray storeListJSONArray = (JSONArray)userJSONObject.get("userStoreList");
			
			for(int i=0;i<storeListJSONArray.size();i++){
				user.getStoreList().add(storeListJSONArray.getString(i));
			}
			
			

			
			
		}

	}
	


}
