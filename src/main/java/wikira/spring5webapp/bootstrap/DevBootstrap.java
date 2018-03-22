package wikira.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import wikira.spring5webapp.model.Author;
import wikira.spring5webapp.model.Book;
import wikira.spring5webapp.model.Publisher;
import wikira.spring5webapp.repositories.AuthorRepository;
import wikira.spring5webapp.repositories.BookRepository;
import wikira.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author eric = new Author("Eric", "Evans");
        Publisher publisher = new Publisher("SomePub", "Texas");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(publisher);
        bookRepository.save(ddd);

        Author maciek = new Author("Maciej", "Aniserowicz");
        Publisher selfPublisher = new Publisher("Maciej Aniserowicz", "Poland");
        Book zp = new Book("Zawód Programista", "5678", selfPublisher);
        maciek.getBooks().add(zp);
        zp.getAuthors().add(maciek);

        authorRepository.save(maciek);
        publisherRepository.save(selfPublisher);
        bookRepository.save(zp);
    }
}
