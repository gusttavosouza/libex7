package br.edu.utfpr.libex7.application.ports.out.copies;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.application.domain.copies.Copy;

public interface SearchCopyPort {
	
	Optional<Copy> findById(Long id);
	List<Copy> findAll();

}
