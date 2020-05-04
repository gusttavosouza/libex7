package br.edu.utfpr.libex7.application.service.copies;

import br.edu.utfpr.libex7.application.domain.copies.Copy;
import br.edu.utfpr.libex7.application.ports.in.copies.SaveCopyUseCase;
import br.edu.utfpr.libex7.application.ports.out.copies.SaveCopyPort;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class SaveCopyService implements SaveCopyUseCase{
	
	
	private final SaveCopyPort port;
	
	@Override
	public Copy save(Copy copy) {
		return port.save(copy);
	}
	
	

}
