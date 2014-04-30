package org.moonmonkeylabs.worldfactbook.view;

import org.moonmonkeylabs.ui.container.ViewMainScreen;
import org.moonmonkeylabs.worldfactbook.WorldFact;
import org.moonmonkeylabs.worldfactbook.model.CountryInfos;

import net.rim.device.api.ui.DrawStyle;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.ObjectChoiceField;

public class WorldFactBookListView extends ViewMainScreen
{
	private ObjectChoiceField _countryList;
	private ButtonField _showDetail;
	private LabelField _message;
	
	public WorldFactBookListView()
	{
		setTitle("World Fact Book");

		_countryList = new ObjectChoiceField("Select Country:  ", new Object[] {}, 0, ObjectChoiceField.FIELD_LEFT);
		_showDetail = new ButtonField("Show Detail", DrawStyle.ELLIPSIS | Field.FOCUSABLE | ButtonField.CONSUME_CLICK);
		_showDetail.setChangeListener(_showDetailListener);
		_message = new LabelField("");
		
		add(_countryList);
		add(_showDetail);
		add(_message);
	}
	
	private FieldChangeListener _showDetailListener = new FieldChangeListener()
	{
		public void fieldChanged(Field field, int context)
		{
			// set the country index
			getViewData().put(WorldFact.ViewData_List_SelectedCountry, new Integer(_countryList.getSelectedIndex()));
			// notify the controller
			notifyViewListeners(WorldFact.View_List_ShowDetail);
		}
	};
	
	public void updateView(int key)
	{
		switch (key)
		{
			case WorldFact.View_List_SetCountry:
				_countryList.setChoices(((CountryInfos)getModel()).getCounryNames());
				break;
				
			case WorldFact.View_List_SetMessage:
				_message.setText((String)getViewData().get(WorldFact.ViewData_List_Message));
				break;
		}
	}
	
	public boolean isDirty()
	{
		return false;
	}
}
