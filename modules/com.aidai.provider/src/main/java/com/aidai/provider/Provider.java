package com.aidai.provider;

public class Provider  implements IProvider{
	
	public void init(){
		System.out.println("Provider init");
	}

	public void sayHi() {
		System.out.println("provider say hi");
	}
}
