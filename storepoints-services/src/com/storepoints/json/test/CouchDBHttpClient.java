package com.storepoints.json.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import com.storepoints.dto.Store;


public class CouchDBHttpClient {
	
	
	public static void main(String arg[]){
		
		try {

			HttpClient client = new HttpClient();

//			PostMethod post = new PostMethod(
//					"http://localhost:5984/storepoints_dev/stores");

			// post.setRequestEntity(new ByteArrayRequestEntity());
			// set any request headers
//			post.setRequestHeader("Content-type", "application/json");

			GetMethod getMethod = new GetMethod("http://localhost:5984/storepoints_dev/stores");
			
			getMethod.setRequestHeader("Content-type", "application/json");
			

			// Make the call
			int status = client.executeMethod(getMethod);
			
			System.out.println("Status value:"+status);

			InputStream in = null;
			switch (status) {
			case 200:
				in = getMethod.getResponseBodyAsStream();

				break;
			case 500:
				in = getMethod.getResponseBodyAsStream();
				break;
			case 404:

				break;
			default:
				// possibly return?
				break;
			}
			if (in == null) {
				return;
			}
			

			StringBuffer buffer = new StringBuffer();
			
			BufferedReader readerOut = null;
			try {
				readerOut = new BufferedReader(new InputStreamReader(in));
				String line = readerOut.readLine();
				while( line != null ){
					
//					System.out.println("PROXY SCRAPPER SERVER RESPONSE LOG:"+line);
					buffer.append(line);
					line = readerOut.readLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				try {
					readerOut.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			
			
//			System.out.println("Final buffer value:"+buffer.toString());
			
			JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
			
			
			JSONArray storeJSONArray = (JSONArray)jsonObject.get("storeList");
			
			Iterator iteratorStore= storeJSONArray.iterator();
			
			while(iteratorStore.hasNext()){
				
				JSONObject storeJSONObject =(JSONObject)iteratorStore.next();
	
//				Store store =(Store)JSONSerializer.toJava((JSONObject)iteratorStore.next());
				
				System.out.println("Store name from couchDB:"+storeJSONObject.get("storeName"));
				
				
//				if(store!=null){
//					System.out.println("Store name from couchDB:"+store.getStoreName());
//				}
			}
			
//			for(Store store: storeJSONArray){
				
//				Store store =(Store)JSONSerializer.toJava(storeJSON);
//				System.out.println("Store name from couchDB:"+store.getStoreName());
//			}
			
			

		}catch(Exception excp){
			excp.printStackTrace();
			
		}
	}

}
