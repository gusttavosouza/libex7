package br.edu.utfpr.adapters.gui.configuration.users.employees;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.utfpr.adapters.gui.controllers.users.employees.EmployeeController;
import br.edu.utfpr.adapters.gui.controllers.users.employees.SaveEmployeeController;
import br.edu.utfpr.adapters.gui.controllers.users.employees.SearchEmployeeController;
import br.edu.utfpr.adapters.gui.views.users.employees.SaveEmployeeView;
import br.edu.utfpr.adapters.gui.views.users.employees.SearchEmployeeView;
import br.edu.utfpr.libex7.adapters.persistence.adapters.users.UserPersistenceAdapter;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.EmployeeEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.users.EmployeePersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.repository.users.EmployeeRepository;
import br.edu.utfpr.libex7.adapters.persistence.repository.users.UserRepository;
import br.edu.utfpr.libex7.adapters.persistence.service.users.UserPersistenceService;
import br.edu.utfpr.libex7.application.ports.in.users.SaveUserUseCase;
import br.edu.utfpr.libex7.application.service.users.SaveUserService;
import br.edu.utfpr.libex7.application.service.users.SearchUserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeConfiguration {
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EmployeeController configure() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("libex7");
		EntityManager entityManager = factory.createEntityManager();
		UserRepository<EmployeeEntity> employeeRepository = new EmployeeRepository(entityManager);
		UserPersistenceService<EmployeeEntity> service = new UserPersistenceService(employeeRepository);
		EmployeePersistenceMapper mapper = new EmployeePersistenceMapper();
		UserPersistenceAdapter<EmployeeEntity> adapter = new UserPersistenceAdapter(service, mapper);
		
		SaveUserUseCase saveEmployeeUseCase = new SaveUserService(adapter);
		SaveEmployeeView saveEmployeeView = new SaveEmployeeView();
		
		SearchUserService searchEmployeeUseCase = new SearchUserService(adapter);
		SearchEmployeeView searchEmployeeView = new SearchEmployeeView();
		
		SaveEmployeeController saveEmployeeController = new SaveEmployeeController(saveEmployeeUseCase, saveEmployeeView);
		SearchEmployeeController searchEmployeeController = new SearchEmployeeController(searchEmployeeUseCase, searchEmployeeView);
		
		
		return new EmployeeController(saveEmployeeController, searchEmployeeController);
	}

}
