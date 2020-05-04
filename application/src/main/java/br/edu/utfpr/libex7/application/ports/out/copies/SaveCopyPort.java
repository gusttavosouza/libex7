package br.edu.utfpr.libex7.application.ports.out.copies;

import br.edu.utfpr.libex7.application.domain.copies.Copy;

public interface SaveCopyPort {
	
	Copy save(Copy copy);

}
