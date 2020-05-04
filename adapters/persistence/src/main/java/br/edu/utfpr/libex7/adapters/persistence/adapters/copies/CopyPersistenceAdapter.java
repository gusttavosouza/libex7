package br.edu.utfpr.libex7.adapters.persistence.adapters.copies;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.copies.CopyPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.service.copies.CopyPersistenceService;
import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.ports.out.copies.RemoveCopyPort;
import br.edu.utfpr.libex7.application.ports.out.copies.SaveCopyPort;
import br.edu.utfpr.libex7.application.ports.out.copies.SearchCopyPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CopyPersistenceAdapter implements SaveCopyPort, RemoveCopyPort, SearchCopyPort{
	
	private final CopyPersistenceService service;
	private final CopyPersistenceMapper mapper;

	@Override
	public Optional<Copy> findById(Long id) {
		 Optional<CopyEntity> optionalCopy = service.findById(id);
		 if(optionalCopy.isPresent()) {
			 CopyEntity copyEntity = optionalCopy.get();
			 return Optional.ofNullable(mapper.mapToDomain(copyEntity));
		 }
		 return Optional.empty();
	}

	@Override
	public List<Copy> findAll() {
		List<CopyEntity> copyEntities = service.findAll();
		List<Copy> copies = new LinkedList<>();
		copyEntities.forEach(c -> copies.add(mapper.mapToDomain(c)));
		return copies;
	}

	@Override
	public void remove(Long id) {
		service.remove(id);
	}

	@Override
	public Copy save(Copy copy) {
		CopyEntity copyEntity = mapper.mapToEntity(copy);
		service.save(copyEntity);
		return mapper.mapToDomain(copyEntity);
	}

}
