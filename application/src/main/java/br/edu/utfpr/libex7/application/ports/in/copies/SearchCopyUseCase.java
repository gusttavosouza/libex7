package br.edu.utfpr.libex7.application.ports.in.copies;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.application.domain.copies.Copy;

public interface SearchCopyUseCase {
	
	Optional<Copy> findById(Long id);
	List<Copy> findAll();

}
