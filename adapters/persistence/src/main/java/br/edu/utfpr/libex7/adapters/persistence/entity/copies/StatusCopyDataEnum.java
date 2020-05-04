package br.edu.utfpr.libex7.adapters.persistence.entity.copies;

import br.edu.utfpr.libex7.application.domain.copies.StatusCopyEnum;

public enum StatusCopyDataEnum {

	AVAILABLE(1, StatusCopyEnum.AVAILABLE),
	UNAVAILABLE(2, StatusCopyEnum.UNAVAILABLE);

	private Integer code;
	private StatusCopyEnum status;

	StatusCopyDataEnum(Integer code, StatusCopyEnum status){
		this.code = code;
		this.status = status;

	}

	public Integer getCode() {
		return code;
	}
	
	public StatusCopyEnum getStatus() {
		return status;
	}
	
	public static StatusCopyDataEnum fromValue(StatusCopyEnum statusCopyEnum) {
		for(StatusCopyDataEnum statusCopyDataEnum : StatusCopyDataEnum.values()) {
			if(statusCopyDataEnum.getStatus().equals(statusCopyEnum)) {
				return statusCopyDataEnum;
			}
		}
		return null;
	}
	
	public static StatusCopyDataEnum fromValue(Integer code) {
		for(StatusCopyDataEnum statusCopyDataEnum : StatusCopyDataEnum.values()) {
			if(statusCopyDataEnum.getCode().equals(code)) {
				return statusCopyDataEnum;
			}
		}
		return null;
	}
}
