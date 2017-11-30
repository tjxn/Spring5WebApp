package ca.trevorjackson.spring5webapp.bootstrap;

import ca.trevorjackson.spring5webapp.model.Author;
import ca.trevorjackson.spring5webapp.model.Book;
import ca.trevorjackson.spring5webapp.model.Publisher;
import ca.trevorjackson.spring5webapp.repositories.AuthorRepository;
import ca.trevorjackson.spring5webapp.repositories.BookRepository;
import ca.trevorjackson.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Trevor Jackson
 * November 29, 2017
 **/
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author ericEvans = new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("Harper Collins", "213 Ave");
        Book domainDrivenDesign = new Book("Domain Driven Design", "1234", harperCollins);
        ericEvans.getBooks().add(domainDrivenDesign);
        domainDrivenDesign.getAuthors().add(ericEvans);
        this.authorRepository.save(ericEvans);
        this.bookRepository.save(domainDrivenDesign);
        this.publisherRepository.save(harperCollins);

        Author rodJohnson = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "4335 Street");
        Book j2eeNoEJB = new Book("J2EE Development without EJB", "332134", worx);
        rodJohnson.getBooks().add(j2eeNoEJB);
        j2eeNoEJB.getAuthors().add(rodJohnson);
        this.authorRepository.save(rodJohnson);
        this.bookRepository.save(j2eeNoEJB);
        this.publisherRepository.save(worx);
    }

}
