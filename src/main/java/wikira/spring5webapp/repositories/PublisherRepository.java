package wikira.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import wikira.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{
}
