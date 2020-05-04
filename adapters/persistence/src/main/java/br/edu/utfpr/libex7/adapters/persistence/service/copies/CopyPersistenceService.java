package br.edu.utfpr.libex7.adapters.persistence.service.copies;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;
import br.edu.utfpr.libex7.adapters.persistence.repository.copies.CopyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CopyPersistenceService implements ICopyPersistenceService {

	private final CopyRepository repository;
	
	@Override
	public Optional<CopyEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<CopyEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public void remove(Long id) {
		repository.remove(id);
	}

	@Override
	public CopyEntity save(CopyEntity copy) {
		return repository.save(copy);
	}

}
