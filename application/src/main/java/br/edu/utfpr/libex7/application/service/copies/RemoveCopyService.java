package br.edu.utfpr.libex7.application.service.copies;

import br.edu.utfpr.libex7.application.ports.in.books.RemoveBookUseCase;
import br.edu.utfpr.libex7.application.ports.out.copies.RemoveCopyPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoveCopyService implements RemoveBookUseCase{
	
	
	private final RemoveCopyPort port;
	
	@Override
	public void remove(Long id) {
		port.remove(id);
	}
	
	

}
