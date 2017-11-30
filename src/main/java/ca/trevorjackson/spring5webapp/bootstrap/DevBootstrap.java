package ca.trevorjackson.spring5webapp.bootstrap;

import ca.trevorjackson.spring5webapp.model.Author;
import ca.trevorjackson.spring5webapp.model.Book;
import ca.trevorjackson.spring5webapp.repositories.AuthorRepository;
import ca.trevorjackson.spring5webapp.repositories.BookRepository;
import com.sun.istack.internal.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Component;

/**
 * Created by Trevor Jackson
 * November 29, 2017
 **/
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author ericEvans = new Author("Eric", "Evans");
        Book domainDrivenDesign = new Book("Domain Driven Design", "1234", "Harper Collins");
        ericEvans.getBooks().add(domainDrivenDesign);
        domainDrivenDesign.getAuthors().add(ericEvans);
        this.authorRepository.save(ericEvans);
        this.bookRepository.save(domainDrivenDesign);


        Author rodJohnson = new Author("Rod", "Johnson");
        Book j2eeNoEJB = new Book("J2EE Development without EJB", "332134", "Worx");
        rodJohnson.getBooks().add(j2eeNoEJB);
        j2eeNoEJB.getAuthors().add(rodJohnson);
        this.authorRepository.save(rodJohnson);
        this.bookRepository.save(j2eeNoEJB);
    }

}
