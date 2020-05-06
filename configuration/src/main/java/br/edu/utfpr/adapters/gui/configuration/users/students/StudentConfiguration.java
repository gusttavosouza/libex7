package br.edu.utfpr.adapters.gui.configuration.users.students;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.utfpr.adapters.gui.controllers.users.students.SaveStudentController;
import br.edu.utfpr.adapters.gui.controllers.users.students.SearchStudentController;
import br.edu.utfpr.adapters.gui.controllers.users.students.StudentController;
import br.edu.utfpr.adapters.gui.views.users.students.SaveStudentView;
import br.edu.utfpr.adapters.gui.views.users.students.SearchStudentView;
import br.edu.utfpr.libex7.adapters.persistence.adapters.users.UserPersistenceAdapter;
import br.edu.utfpr.libex7.adapters.persistence.entity.users.StudentEntity;
import br.edu.utfpr.libex7.adapters.persistence.mapper.users.StudentPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.repository.users.StudentRepository;
import br.edu.utfpr.libex7.adapters.persistence.repository.users.UserRepository;
import br.edu.utfpr.libex7.adapters.persistence.service.users.UserPersistenceService;
import br.edu.utfpr.libex7.application.service.users.SaveUserService;
import br.edu.utfpr.libex7.application.service.users.SearchUserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentConfiguration {
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public StudentController configure() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("libex7");
		EntityManager entityManager = factory.createEntityManager();
	    UserRepository<StudentEntity> studentRepository = new StudentRepository(entityManager);
		UserPersistenceService<StudentEntity> service = new UserPersistenceService<>(studentRepository);
		StudentPersistenceMapper mapper = new StudentPersistenceMapper();
		UserPersistenceAdapter<StudentEntity> adapter = new UserPersistenceAdapter(service, mapper);
		
		SaveUserService saveStudentUseCase = new SaveUserService(adapter);
		SaveStudentView saveStudentView = new SaveStudentView();
		
		SearchUserService searchStudentUseCase = new SearchUserService(adapter);
		SearchStudentView searchStudentView = new SearchStudentView();
		
		SaveStudentController saveStudentController = new SaveStudentController(saveStudentUseCase, saveStudentView);
		SearchStudentController searchStudentController = new SearchStudentController(searchStudentUseCase, searchStudentView);
		
		
		return new StudentController(saveStudentController, searchStudentController);
	}

}
