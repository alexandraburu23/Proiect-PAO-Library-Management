package models;

public class TextBook extends Book{

    private String field;
    public TextBook() {
        super(0, "", new Author(), 0,new Section());
        this.field="";
    }
    public TextBook(int book_id, String name, Author author, int pages, Section section, String field) {
        super(book_id, name, author, pages,section);
        this.field=field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String bookType(){
        return "TextBook";
    }
    @Override
    public String toString() {
        return "models.TextBook{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", pages=" + pages +
                ", section=" + section +
                ", field=" + field +
                '}';
    }
}
