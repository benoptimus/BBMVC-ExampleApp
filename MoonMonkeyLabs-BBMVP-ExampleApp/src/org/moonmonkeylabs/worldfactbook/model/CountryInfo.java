package org.moonmonkeylabs.worldfactbook.model;

public class CountryInfo
{
	private String _name;
	private String _captial;
	private String _currency;
	private String _tld;
	private boolean _isPrivate;

	public CountryInfo(String name, String captial, String currency, String tld, boolean isPrivate)
	{
		_name = name;
		_captial = captial;
		_currency = currency;
		_tld = tld;
		_isPrivate = isPrivate;
	}

	public String getName()
	{
		return _name;
	}

	public void setName(String name)
	{
		this._name = name;
	}

	public String getCaptial()
	{
		return _captial;
	}

	public void setCaptial(String captial)
	{
		this._captial = captial;
	}

	public String getCurrency()
	{
		return _currency;
	}

	public void setCurrency(String currency)
	{
		this._currency = currency;
	}

	public String getTld()
	{
		return _tld;
	}

	public void setTld(String tld)
	{
		this._tld = tld;
	}

	public boolean getIsPrivate()
	{
		return _isPrivate;
	}

	public void setIsPrivate(boolean isPrivate)
	{
		_isPrivate = isPrivate;
	}
}
