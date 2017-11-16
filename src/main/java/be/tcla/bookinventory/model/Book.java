package be.tcla.bookinventory.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String title;
    private String publisher;
    private String ISBN;
    @NotNull
    private String author;
    private Integer pages;
    @Column(columnDefinition = "boolean default false")
    private boolean ebook;
    private String subject;
    private Language language;
    private Genre genre;

    public Book() {

    }



    public Book(String title, String publisher, String ISBN, String author, int pages, boolean ebook, String subject, Language language, Genre genre) {
        this.title = title;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.author = author;
        this.pages = pages;
        this.ebook = ebook;
        this.subject = subject;
        this.language = language;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public boolean isEbook() {
        return ebook;
    }

    public void setEbook(boolean ebook) {
        this.ebook = ebook;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Enumerated(EnumType.STRING)
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Enumerated(EnumType.STRING)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", ebook=" + ebook +
                ", subject='" + subject + '\'' +
                ", language=" + language +
                ", genre=" + genre +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}
