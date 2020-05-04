package br.edu.utfpr.libex7.application.domain.copies;

public enum StatusCopyEnum {

	AVAILABLE("Disponível"),
	UNAVAILABLE("Indisponível");
	
	private String description;

	StatusCopyEnum(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static StatusCopyEnum fromValue(String description) {
		for(StatusCopyEnum copy : StatusCopyEnum.values()) {
			if(copy.getDescription().equals(description)) {
				return copy;
			}
		}
		return null;
	}
}
