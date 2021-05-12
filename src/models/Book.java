package models;

public class Book {
    protected int book_id;
    protected String name;
    protected Author author;
    protected Integer pages;
    protected Section section;

    public Book(){
        this.book_id = 0;
        this.name = "";
        this.author = new Author();
        this.pages=0;
        this.section = new Section();
    }
    public Book(int book_id, String name, Author author, Integer pages, Section section) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.section = section;
    }
    public Book (Book book){
        this.book_id = book.getBook_id();
        this.name = book.getName();
        this.author = book.getAuthor();
        this.pages = book.getPages();
        this.section = book.getSection();
    }
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }


    public String bookType(){
        return "Book";
    }
    @Override
    public String toString() {
        return "models.Book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", pages=" + pages +
                ", section=" + section +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_id==book.getBook_id() && pages.equals(book.getPages()) && name.equals(book.getName()) && author.equals(book.getAuthor()) && section.equals(book.getSection());
    }



}
