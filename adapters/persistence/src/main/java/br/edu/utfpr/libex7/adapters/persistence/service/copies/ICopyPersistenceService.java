package br.edu.utfpr.libex7.adapters.persistence.service.copies;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.adapters.persistence.entity.copies.CopyEntity;

public interface ICopyPersistenceService {
	Optional<CopyEntity> findById(Long id);
	List<CopyEntity> findAll();
	void remove(Long id);
	CopyEntity save(CopyEntity copy);
}
