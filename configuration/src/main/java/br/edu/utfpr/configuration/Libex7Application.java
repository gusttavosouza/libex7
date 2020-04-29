package br.edu.utfpr.configuration;

import br.edu.utfpr.adapters.gui.controllers.SaveAuthorController;
import br.edu.utfpr.libex7.adapters.persistence.adapters.AuthorPersistenceAdapter;
import br.edu.utfpr.libex7.adapters.persistence.mapper.AuthorPersistenceMapper;
import br.edu.utfpr.libex7.adapters.persistence.repository.AuthorRepository;
import br.edu.utfpr.libex7.adapters.persistence.repository.ConnectionFactory;
import br.edu.utfpr.libex7.adapters.persistence.service.AuthorPersistenceService;
import br.edu.utfpr.libex7.application.domain.authors.Author;
import br.edu.utfpr.libex7.application.ports.in.SaveAuthorUseCase;
import br.edu.utfpr.libex7.application.ports.out.SaveAuthorPort;
import br.edu.utfpr.libex7.application.service.SaveAuthorService;

import java.sql.Connection;
import java.util.Scanner;

public class Libex7Application {

    public static void main(String[] args) {

        Connection connection = ConnectionFactory.getInstance();

        AuthorRepository authorRepository = new AuthorRepository(connection);

        AuthorPersistenceService authorPersistenceService = new AuthorPersistenceService(authorRepository);
        AuthorPersistenceMapper authorPersistenceMapper = new AuthorPersistenceMapper();

        SaveAuthorPort saveAuthorPort = new AuthorPersistenceAdapter(authorPersistenceService, authorPersistenceMapper);

        SaveAuthorUseCase saveAuthorUseCase = new SaveAuthorService(saveAuthorPort);

        SaveAuthorController saveAuthorController = new SaveAuthorController(saveAuthorUseCase);
        startProcessingDesktopRequests(saveAuthorController);
    }

    private static void startProcessingDesktopRequests(SaveAuthorController saveAuthorController) {

        boolean exit = false;

        while(!exit){


            Scanner sc = new Scanner(System.in);

            System.out.println("Pressione Qualquer Tecla para Iniciar ou Exit para Sair");
            String line = sc.nextLine();
            if(line.equalsIgnoreCase("exit")){
                System.exit(0);
            }

            System.out.println("Digite o nome do Autor");
            String name = sc.nextLine();
            Author author = new Author();
            author.setName(name);
            saveAuthorController.save(author);
            System.out.println("Autor salvo com sucesso !!!");

            System.out.println("Deseja Continuar ?");
            System.out.println("(Y) - SIM | (N) - NÃO ");
            String continueOption = sc.nextLine();
            if(continueOption.equalsIgnoreCase("N")){
                System.exit(0);
            }

        }

    }


}
