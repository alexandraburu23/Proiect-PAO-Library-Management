import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Author extends Person{



    public Author(int id, String name) {
        super(id,name);

    }
    public Author(Author author){
        super(author.getId(), author.getName());
    }

    @Override
    public String toString() {
        return "Author{" +

                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
