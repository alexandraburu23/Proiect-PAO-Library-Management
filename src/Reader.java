import java.time.LocalDate;
import java.util.Objects;

public class Reader extends Person {

    protected LocalDate registrationDate;
    public Reader ( int id, String name) {
        super(id,name);
        this.registrationDate = LocalDate.now();
    }
    public Reader(int id, String name,LocalDate registrationDate) {
        super(id,name);
        this.registrationDate =registrationDate;
    }
    public Reader(Reader reader){
        super(reader.getId(), reader.getName());
        this.registrationDate = reader.getRegistrationDate();
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }


    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reader reader = (Reader) o;
        return Objects.equals(id, reader.id) && Objects.equals(name, reader.name) && registrationDate.equals(reader.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), registrationDate);
    }

}
