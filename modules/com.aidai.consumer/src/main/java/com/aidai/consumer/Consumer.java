package com.aidai.consumer;

import com.aidai.provider.Provider;

public class Consumer {
	
	private Provider provider;
	
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public void init(){
		provider.sayHi();
	}
}
