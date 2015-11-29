package com.storepoints.memcached.data;

import java.util.HashMap;
import java.util.Map;

public class SPUsersAccountsMapperTable {
	
	
	private static Map<String, String> usersAccountsMap = new HashMap<String,String>();
	
	static{
		usersAccountsMap.put("UUID1", "A5107701784");
		usersAccountsMap.put("UUID2", "A5102849640");
		
	}

	public static Map<String, String> getUsersAccountsMap() {
		return usersAccountsMap;
	}
}
