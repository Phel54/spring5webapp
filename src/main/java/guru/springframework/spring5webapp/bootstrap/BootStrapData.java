package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Publisher publisher = new Publisher("Isichei Phelim", "No 13, K house", "Accra", "Greater Accra", "90989");



        Author phelim = new Author("Isichei", "Phelim");
        Book java = new Book("Domain Driven Design", "12345");

        phelim.getBooks().add(java);
        java.getAuthors().add(phelim);
        publisher.getBooks().add(java);

        authorRepository.save(phelim);
        bookRepository.save(java);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development", "323232");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);



        System.out.println("Bootstrap Starting");
        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Number of Publishers:" + publisherRepository.count() + " " + "Publishers books : "  + publisher.getBooks().size());

    }
}
