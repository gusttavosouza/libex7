package br.edu.utfpr.libex7.adapters.persistence.entity.copies;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusCopyDataEnumConverter implements AttributeConverter<StatusCopyDataEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(StatusCopyDataEnum statusCopyDataEnum) {
		return statusCopyDataEnum.getCode();
	}

	@Override
	public StatusCopyDataEnum convertToEntityAttribute(Integer code) {
		return StatusCopyDataEnum.fromValue(code);
	}

}
