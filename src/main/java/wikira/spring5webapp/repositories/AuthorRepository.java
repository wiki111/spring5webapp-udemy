package wikira.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import wikira.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
