package ca.trevorjackson.spring5webapp.repositories;

import ca.trevorjackson.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Trevor Jackson
 * November 29, 2017
 **/
public interface BookRepository extends CrudRepository<Book, Long>{
}
