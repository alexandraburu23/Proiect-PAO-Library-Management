package models;

public class Author extends Person{


    public Author(){
        super(0,"");
    }
    public Author(int id, String name) {
        super(id,name);

    }
    public Author(Author author){
        super(author.getId(), author.getName());
    }

    @Override
    public String toString() {
        return "models.Author{" +

                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
