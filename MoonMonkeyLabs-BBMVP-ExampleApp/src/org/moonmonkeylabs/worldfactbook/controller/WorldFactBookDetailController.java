
package org.moonmonkeylabs.worldfactbook.controller;

import org.moonmonkeylabs.bbmvc.Controller;
import org.moonmonkeylabs.bbmvc.Navigator;
import org.moonmonkeylabs.bbmvc.View;
import org.moonmonkeylabs.ui.container.ViewMainScreen;
import org.moonmonkeylabs.worldfactbook.WorldFact;
import org.moonmonkeylabs.worldfactbook.model.CountryInfo;

public class WorldFactBookDetailController extends Controller
{
	private CountryInfo _countryInfo;

	public WorldFactBookDetailController(View view, int controllerId)
	{
		super(view, controllerId);
	}

	protected void onInitialize(Object[] parameters)
	{
		_countryInfo = (CountryInfo) parameters[0];
		_view.setModel(_countryInfo);
		_view.updateView(WorldFact.View_Detail_Init);
	}

	protected void onViewStateChanged(int event)
	{
		switch (event)
		{
			case ViewMainScreen.ScreenClose:
				Navigator.getInstance().goBack();
				break;
		}
	}

	protected void onUpdate(Object[] parameters)
	{
	}
}
