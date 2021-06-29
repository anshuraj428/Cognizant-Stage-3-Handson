package com.cognizant.truyum.service;

import java.util.List;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.*;

@Service
public class MenuItemService {
	
	@Autowired
	private MenuItemDao r;
	
	public List<MenuItem> getMenuItemListAdmin(){
		return r.getMenuItemListAdmin();
		
	}
	
	public List<MenuItem> getMenuItemListCustomer(){
		return r.getMenuItemListCustomer();
			
	}
	
	public MenuItem getMenuItem(long menuItemId) {
		return r.getMenuItem(menuItemId);
		
	}
	
	public void editMenuItem(MenuItem menuItem) {
		r.modifyMenuItem(menuItem);
	}
}
