package br.edu.utfpr.libex7.adapters.persistence.mapper.copies;

import java.time.LocalDate;

import br.edu.utfpr.libex7.adapters.persistence.entity.books.BookEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import br.edu.utfpr.libex7.adapters.persistence.entity.copies.StatusCopyDataEnum;
import br.edu.utfpr.libex7.adapters.persistence.mapper.GenericMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.books.BookPersistenceMapper;
import br.edu.utfpr.libex7.application.domain.books.Book;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.domain.copies.StatusCopyEnum;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CopyPersistenceMapper implements GenericMapper<Copy, CopyEntity> {
	
	private final BookPersistenceMapper bookPersistenceMapper;

	@Override
	public Copy mapToDomain(CopyEntity copyEntity) {
		Long id = copyEntity.getId();
		BookEntity bookEntity = copyEntity.getBook();
		StatusCopyDataEnum status = copyEntity.getStatus();
		LocalDate acquisitionDate = copyEntity.getAcquisitionDate();
		Copy copy = new Copy(id);
		copy.setAcquisitionDate(acquisitionDate);
		copy.setBook(bookPersistenceMapper.mapToDomain(bookEntity));
		copy.setStatus(status.getStatus());
		return copy;
	}

	@Override
	public CopyEntity mapToEntity(Copy copy) {
		Long id = copy.getId();
		Book book = copy.getBook();
		StatusCopyEnum status = copy.getStatus();
		LocalDate acquisitionDate = copy.getAcquisitionDate();
		CopyEntity copyEntity = new CopyEntity(id);
		copyEntity.setAcquisitionDate(acquisitionDate);
		copyEntity.setBook(bookPersistenceMapper.mapToEntity(book));
		copyEntity.setStatus(StatusCopyDataEnum.fromValue(status));
		return copyEntity;
	}

}
