package com.relayr.productcomparisonservice.datasource.reader;

public interface httpReader extends Reader{

	public void pullUrl(String url);
	
	public void callbackUrl(String url);
	
}
