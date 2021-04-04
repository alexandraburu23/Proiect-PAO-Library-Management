public class TextBook extends Book{

    private String field;
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
}
