package br.edu.utfpr.adapters.gui.controllers.commons;


import br.edu.utfpr.adapters.gui.controllers.authors.AuthorController;
import br.edu.utfpr.adapters.gui.controllers.authors.SearchAuthorController;
import br.edu.utfpr.adapters.gui.controllers.books.BookController;
import br.edu.utfpr.adapters.gui.controllers.books.SearchBookController;
import br.edu.utfpr.adapters.gui.controllers.categories.CategoryController;
import br.edu.utfpr.adapters.gui.controllers.categories.SearchCategoryController;
import br.edu.utfpr.adapters.gui.controllers.checkouts.CheckOutController;
import br.edu.utfpr.adapters.gui.controllers.copies.CopyController;
import br.edu.utfpr.adapters.gui.controllers.copies.SearchCopyController;
import br.edu.utfpr.adapters.gui.controllers.users.employees.EmployeeController;
import br.edu.utfpr.adapters.gui.controllers.users.students.SearchStudentController;
import br.edu.utfpr.adapters.gui.controllers.users.students.StudentController;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemNewAuthorHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemNewBookHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemNewCategoryHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemNewCheckOutHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemNewCopyHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemNewEmployeeHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemNewStudentHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemSearchAuthorHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemSearchBookHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemSearchCategoryHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemSearchCheckOutHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemSearchCopyHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemSearchEmployeeHandler;
import br.edu.utfpr.adapters.gui.handlers.commons.MenuItemSearchStudentHandler;
import br.edu.utfpr.adapters.gui.views.commons.MainView;
import br.edu.utfpr.libex7.application.ports.in.authors.SearchAuthorUseCase;
import br.edu.utfpr.libex7.application.ports.in.books.SearchBookUseCase;
import br.edu.utfpr.libex7.application.ports.in.categories.SearchCategoryUseCase;
import br.edu.utfpr.libex7.application.ports.in.copies.SearchCopyUseCase;
import br.edu.utfpr.libex7.application.ports.in.users.SearchUserUseCase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import lombok.Getter;

@Getter
public class MainController {


	private final MainView view;
	private final AuthorController authorController;
	private final BookController bookController;
	private final CategoryController categoryController;
	private final CopyController copyController;
	private final CheckOutController checkOutController;
	private final StudentController studentController;
	private final EmployeeController employeeController;

	public MainController(MainView view, 
			              AuthorController authorController,  
			              CategoryController categoryController , 
			              BookController bookController, 
			              CopyController copyController,
			              CheckOutController checkOutController,
			              StudentController studentController,
			              EmployeeController employeeController) {
		this.view = view;
		this.authorController = authorController;
		this.categoryController = categoryController;
		this.bookController = bookController;
		this.copyController = copyController;
		this.checkOutController = checkOutController;
		this.studentController = studentController;
		this.employeeController = employeeController;

		MenuItem menuItemNewAuthor = this.view.getMenuItemNewAuthor();
		menuItemNewAuthor.setOnAction(new MenuItemNewAuthorHandler(authorController));

		MenuItem menuItemSearchAuthor = this.view.getMenuItemSearchAuthor();
		menuItemSearchAuthor.setOnAction(new MenuItemSearchAuthorHandler(authorController));

		MenuItem menuItemNewBook = this.view.getMenuItemNewBook();
		
		SearchAuthorController searchAuthorController = this.authorController.getSearchAuthorController();
		SearchAuthorUseCase searchAuthorUseCase = searchAuthorController.getUseCase();
		
		SearchCategoryController searchCategoryController = this.categoryController.getSearchCategoryController();
		SearchCategoryUseCase useCase = searchCategoryController.getUseCase();
		menuItemNewBook.setOnAction(new MenuItemNewBookHandler(bookController,searchAuthorUseCase, useCase));


		MenuItem menuItemSearchBook = this.view.getMenuItemSearchBook();
		menuItemSearchBook.setOnAction(new MenuItemSearchBookHandler(bookController));
		
		MenuItem menuItemNewCategory = this.view.getMenuItemNewCategory();
		menuItemNewCategory.setOnAction(new MenuItemNewCategoryHandler(categoryController));
		
		
		MenuItem menuItemSearchCategory = this.view.getMenuItemSearchCategory();
		menuItemSearchCategory.setOnAction(new MenuItemSearchCategoryHandler(categoryController));
		
		MenuItem menuItemNewCopy = view.getMenuItemNewCopy();
		
		SearchBookController searchBookController = bookController.getSearchBookController();
		SearchBookUseCase searchBookUseCase = searchBookController.getUseCase();
		menuItemNewCopy.setOnAction(new MenuItemNewCopyHandler(copyController, searchBookUseCase));
		
		MenuItem menuItemSearchCopy = view.getMenuItemSearchCopy();
		menuItemSearchCopy.setOnAction(new MenuItemSearchCopyHandler(copyController));
		
		MenuItem menuItemNewStudent = this.view.getMenuItemNewStudent();
		menuItemNewStudent.setOnAction(new MenuItemNewStudentHandler(studentController));
		
		
		MenuItem menuItemSearchStudent = this.view.getMenuItemSearchStudent();
		menuItemSearchStudent.setOnAction(new MenuItemSearchStudentHandler(studentController));
		
		MenuItem menuItemNewEmployee = this.view.getMenuItemNewEmployee();
		menuItemNewEmployee.setOnAction(new MenuItemNewEmployeeHandler(employeeController));
		
		MenuItem menuItemSearchEmployee = this.view.getMenuItemSearchEmployee();
		menuItemSearchEmployee.setOnAction(new MenuItemSearchEmployeeHandler(employeeController));
		
		MenuItem menuItemNewCheckout = this.view.getMenuItemNewCheckout();
		
		SearchStudentController searchStudentController = studentController.getSearchStudentController();
		SearchUserUseCase searchUserUseCase = searchStudentController.getUseCase();
		
		SearchCopyController searchCopyController = copyController.getSearchCopyController();
		SearchCopyUseCase searchCopyUseCase = searchCopyController.getUseCase();
		
		menuItemNewCheckout.setOnAction(new MenuItemNewCheckOutHandler(checkOutController, searchUserUseCase, searchCopyUseCase));
		
		MenuItem menuItemSearchCheckout = this.view.getMenuItemSearchCheckout();
		menuItemSearchCheckout.setOnAction(new MenuItemSearchCheckOutHandler(checkOutController, searchUserUseCase, searchCopyUseCase));
		
	
		MenuItem menuItemExit = this.view.getMenuItemExit();
		menuItemExit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			    System.exit(0);
			}
		});

	}

}
