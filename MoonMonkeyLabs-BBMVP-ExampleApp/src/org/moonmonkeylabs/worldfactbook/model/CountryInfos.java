package org.moonmonkeylabs.worldfactbook.model;

import java.util.Vector;

public class CountryInfos
{
	private Vector _countries;
	
	public CountryInfos()
	{
		_countries = new Vector();
		_countries.addElement(new CountryInfo("United States", "Washington, D.C.", "United States Dollar", "us", false));
		_countries.addElement(new CountryInfo("Germany", "Berlin", "Euro", "de", false));
		_countries.addElement(new CountryInfo("Danmark", "Copenhagen", "Danish krone", "dk", false));
		_countries.addElement(new CountryInfo("Japan", "Tokyo", "Yen", "jp", true));
		_countries.addElement(new CountryInfo("France", "Paris", "Euro", "fr", true));
		_countries.addElement(new CountryInfo("Australia", "Canberra", "Australian dollar", "au", false));
	}
	
	public String[] getCounryNames()
	{
		int size = _countries.size();
		String[] countryNames = new String[_countries.size()];
		for (int i=0; i<size; ++i)
		{
			countryNames[i] = ((CountryInfo)_countries.elementAt(i)).getName();
		}
		return countryNames;
	}
	
	public CountryInfo getCountryAt(int index)
	{
		if (index < _countries.size())
			return (CountryInfo)_countries.elementAt(index);
		else
			return null;
	}
}
