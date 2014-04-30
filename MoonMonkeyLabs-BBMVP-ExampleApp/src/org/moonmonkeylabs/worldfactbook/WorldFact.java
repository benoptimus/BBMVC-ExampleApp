package org.moonmonkeylabs.worldfactbook;

import org.moonmonkeylabs.bbmvc.Navigator;
import org.moonmonkeylabs.worldfactbook.controller.WorldFactBookListController;
import org.moonmonkeylabs.worldfactbook.view.WorldFactBookListView;

public class WorldFact
{
	public static final int View_List_SetCountry = 10;
	public static final int View_List_SetMessage = 11;
	public static final int View_List_Notify_ShowDetail = 12;
	public static final int View_List_Init = 13;
	public static final int View_List_ShowDetail = 13;
	public static final int View_Detail_Init = 15;
	
	public static final int Controller_BookList = 20;
	public static final int Controller_BookDetail = 21;

	public static final int ViewData_List_SelectedCountry = 30;
	public static final int ViewData_List_Message = 31;
	
	public static void main(String[] args)
	{
		try
		{
			Navigator navigator = Navigator.getInstance();
			WorldFactBookListController listController = new WorldFactBookListController(new WorldFactBookListView(), WorldFact.Controller_BookList);
			navigator.addController(listController);
			navigator.navigate(WorldFact.Controller_BookList);
			navigator.enterEventDispatcher();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
