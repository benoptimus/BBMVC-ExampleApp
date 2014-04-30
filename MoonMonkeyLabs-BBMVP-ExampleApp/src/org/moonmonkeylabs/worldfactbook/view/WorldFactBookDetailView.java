
package org.moonmonkeylabs.worldfactbook.view;

import org.moonmonkeylabs.ui.container.ViewMainScreen;
import org.moonmonkeylabs.worldfactbook.model.CountryInfo;

import net.rim.device.api.ui.component.BasicEditField;

import org.moonmonkeylabs.worldfactbook.*;

public class WorldFactBookDetailView extends ViewMainScreen
{
	private BasicEditField _name;
	private BasicEditField _capital;
	private BasicEditField _currency;
	private BasicEditField _tld;

	public WorldFactBookDetailView()
	{
		setTitle("World Fact Book - Country Detail");
		
		_name =     new BasicEditField("Name:\t\t\t", "0", 50, BasicEditField.NO_EDIT_MODE_INPUT);
		_capital =  new BasicEditField("Capital:\t\t", "0", 50, BasicEditField.NO_EDIT_MODE_INPUT);
		_currency = new BasicEditField("Currency:\t", "0", 50, BasicEditField.NO_EDIT_MODE_INPUT);
		_tld =      new BasicEditField("TLD:\t\t\t", "0", 50, BasicEditField.NO_EDIT_MODE_INPUT);

		_name.setEditable(false);
		_capital.setEditable(false);
		_currency.setEditable(false);
		_tld.setEditable(false);

		add(_name);
		add(_capital);
		add(_currency);
		add(_tld);
	}

	public void updateView(int key)
	{
		switch (key)
		{
			case WorldFact.View_Detail_Init:
				CountryInfo countryInfo = (CountryInfo) this.getModel();
				_name.setText(countryInfo.getName());
				_capital.setText(countryInfo.getCaptial());
				_currency.setText(countryInfo.getCurrency());
				_tld.setText(countryInfo.getTld());
				break;
		}
	}
}
