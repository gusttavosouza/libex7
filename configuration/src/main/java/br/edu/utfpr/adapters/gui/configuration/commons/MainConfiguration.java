package br.edu.utfpr.adapters.gui.configuration.commons;

import br.edu.utfpr.adapters.gui.configuration.authors.AuthorConfiguration;
import br.edu.utfpr.adapters.gui.configuration.books.BookConfiguration;
import br.edu.utfpr.adapters.gui.configuration.categories.CategoryConfiguration;
import br.edu.utfpr.adapters.gui.configuration.checkouts.CheckOutConfiguration;
import br.edu.utfpr.adapters.gui.configuration.copies.CopyConfiguration;
import br.edu.utfpr.adapters.gui.configuration.users.employees.EmployeeConfiguration;
import br.edu.utfpr.adapters.gui.configuration.users.students.StudentConfiguration;
import br.edu.utfpr.adapters.gui.controllers.authors.AuthorController;
import br.edu.utfpr.adapters.gui.controllers.books.BookController;
import br.edu.utfpr.adapters.gui.controllers.categories.CategoryController;
import br.edu.utfpr.adapters.gui.controllers.checkouts.CheckOutController;
import br.edu.utfpr.adapters.gui.controllers.commons.MainController;
import br.edu.utfpr.adapters.gui.controllers.copies.CopyController;
import br.edu.utfpr.adapters.gui.controllers.users.employees.EmployeeController;
import br.edu.utfpr.adapters.gui.controllers.users.students.StudentController;
import br.edu.utfpr.adapters.gui.views.commons.MainView;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MainConfiguration {
	
	private final MainView view;

	public MainController configure() {
		  AuthorConfiguration authorConfiguration = new AuthorConfiguration();
		  AuthorController authorController = authorConfiguration.configure();
		  
		  BookConfiguration bookConfiguration = new BookConfiguration();
		  BookController bookController = bookConfiguration.configure();
		  
		  CopyConfiguration copyConfiguration = new CopyConfiguration();
		  CopyController copyController = copyConfiguration.configure();
		  
		  
		  
		  CategoryConfiguration categoryConfiguration = new CategoryConfiguration();
		  CategoryController categoryController = categoryConfiguration.configure();
		  

		  CheckOutConfiguration checkOutConfiguration = new CheckOutConfiguration();
		  CheckOutController checkOutController = checkOutConfiguration.configure();
		  
		  StudentConfiguration studentConfiguration = new StudentConfiguration();
		  StudentController studentController = studentConfiguration.configure();
		  
		  EmployeeConfiguration employeeConfiguration = new EmployeeConfiguration();
		  EmployeeController employeeController = employeeConfiguration.configure();
		  
		  return new MainController(view, authorController, categoryController, bookController, copyController,checkOutController, studentController, employeeController);
	}

}
