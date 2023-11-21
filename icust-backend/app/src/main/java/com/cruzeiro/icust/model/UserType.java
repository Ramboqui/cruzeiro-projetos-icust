package com.cruzeiro.icust.model;

public enum UserType {
	ADMIN("ADMIN"), PRESTADOR("PRESTADOR"), CLIENTE("CLIENTE");
	
	private final String type;
	
	UserType(String string) {
		type = string;
	}
	
	@Override
	public String toString() {
		return type;
	}
}
