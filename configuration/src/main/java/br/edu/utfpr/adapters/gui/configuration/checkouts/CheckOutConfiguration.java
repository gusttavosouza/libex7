package br.edu.utfpr.adapters.gui.configuration.checkouts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.utfpr.adapters.gui.controllers.checkouts.CheckOutController;
import br.edu.utfpr.adapters.gui.controllers.checkouts.SaveCheckOutController;
import br.edu.utfpr.adapters.gui.controllers.checkouts.SearchCheckOutController;
import br.edu.utfpr.adapters.gui.views.checkouts.SaveCheckOutView;
import br.edu.utfpr.adapters.gui.views.checkouts.SearchCheckOutView;
import br.edu.utfpr.libex7.adapters.persistence.adapters.checkouts.CheckOutPersistenceAdapter;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.checkouts.CheckOutPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.mapper.users.UserPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.repository.checkouts.CheckOutRepository;
import br.edu.utfpr.libex7.adapters.persistence.service.checkouts.CheckOutPersistenceService;
import br.edu.utfpr.libex7.application.domain.users.Student;
import br.edu.utfpr.libex7.application.ports.in.checkout.SaveCheckOutUseCase;
import br.edu.utfpr.libex7.application.ports.in.checkout.SearchCheckOutUseCase;
import br.edu.utfpr.libex7.application.service.checkouts.SaveCheckOutService;
import br.edu.utfpr.libex7.application.service.checkouts.SearchCheckOutService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckOutConfiguration {
	
	
	public CheckOutController configure() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("libex7");
		EntityManager entityManager = factory.createEntityManager();

		CheckOutRepository checkOutRepository = new CheckOutRepository(entityManager);
		CheckOutPersistenceService checkOutPersistenceService = new CheckOutPersistenceService(checkOutRepository);
		
		
		UserPersistenceMapper<Student, StudentEntity> userMapper = new UserPersistenceMapper<>();
		CheckOutPersistenceMapper checkOutPersistenceMapper = new CheckOutPersistenceMapper(userMapper);
		CheckOutPersistenceAdapter checkOutPersistenceAdapter = new CheckOutPersistenceAdapter(checkOutPersistenceService, checkOutPersistenceMapper);
		SaveCheckOutUseCase useCase = new SaveCheckOutService(checkOutPersistenceAdapter);
	    SaveCheckOutView saveCheckOutView = new SaveCheckOutView();
		
		SaveCheckOutController saveCheckOutController = new SaveCheckOutController(useCase, saveCheckOutView);
		
		
		
		SearchCheckOutUseCase searchCheckOutUseCase = new SearchCheckOutService(checkOutPersistenceAdapter);
		SearchCheckOutView searchCheckOutView = new SearchCheckOutView();
		
		SearchCheckOutController searchCheckOutController = new SearchCheckOutController(searchCheckOutUseCase, searchCheckOutView);
		
		return new CheckOutController(saveCheckOutController, searchCheckOutController);
	}

}
