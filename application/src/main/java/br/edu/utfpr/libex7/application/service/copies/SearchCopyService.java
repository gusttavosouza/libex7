package br.edu.utfpr.libex7.application.service.copies;

import java.util.List;
import java.util.Optional;

import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.ports.in.copies.SearchCopyUseCase;
import br.edu.utfpr.libex7.application.ports.out.copies.SearchCopyPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchCopyService implements SearchCopyUseCase {

	
	private final SearchCopyPort port;
	
	@Override
	public Optional<Copy> findById(Long id) {
		return port.findById(id);
	}

	@Override
	public List<Copy> findAll() {
		return port.findAll();
	}
	


}
