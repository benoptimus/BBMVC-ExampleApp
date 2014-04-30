
package org.moonmonkeylabs.worldfactbook.controller;

import org.moonmonkeylabs.bbmvc.Controller;
import org.moonmonkeylabs.bbmvc.Navigator;
import org.moonmonkeylabs.bbmvc.View;
import org.moonmonkeylabs.ui.container.ViewMainScreen;
import org.moonmonkeylabs.worldfactbook.WorldFact;
import org.moonmonkeylabs.worldfactbook.model.CountryInfo;
import org.moonmonkeylabs.worldfactbook.model.CountryInfos;
import org.moonmonkeylabs.worldfactbook.view.WorldFactBookDetailView;

public class WorldFactBookListController extends Controller
{
	private CountryInfos _countryInfos;

	public WorldFactBookListController(View view, int controllerId)
	{
		super(view, controllerId);
		_countryInfos = new CountryInfos();
		setModel(_countryInfos);
		_view.updateView(WorldFact.View_List_SetCountry);
	}

	protected void onInitialize(Object[] parameters)
	{

	}

	protected void onViewStateChanged(int key)
	{
		Navigator navigator;
		switch (key)
		{
			case ViewMainScreen.ScreenClose:
				navigator = Navigator.getInstance();
				navigator.goBack();
				break;

			case WorldFact.View_List_ShowDetail:
				CountryInfo selectedCountry = _countryInfos.getCountryAt(((Integer) _view.getViewData().get(WorldFact.ViewData_List_SelectedCountry)).intValue());
				if (selectedCountry.getIsPrivate())
				{
					_view.getViewData().put(WorldFact.ViewData_List_Message, "CountryInfo is private");
					_view.updateView(WorldFact.View_List_SetMessage);
				}
				else
				{
					_view.getViewData().put(WorldFact.ViewData_List_Message, "");
					_view.updateView(WorldFact.View_List_SetMessage);
					navigator = Navigator.getInstance();
					try
					{
						if (!navigator.hasController(WorldFact.Controller_BookDetail))
						{
							WorldFactBookDetailController detailController = new WorldFactBookDetailController(new WorldFactBookDetailView(), WorldFact.Controller_BookDetail);
							navigator.addController(detailController);
						}
						navigator.navigate(WorldFact.Controller_BookDetail, new Object[] { selectedCountry });
					}
					catch (Exception e)
					{
						System.out.println(e.getMessage());
					}
				}
				break;
		}
	}

	protected void onUpdate(Object[] parameters)
	{
	}
}
