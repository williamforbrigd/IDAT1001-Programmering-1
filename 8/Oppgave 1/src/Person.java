import java.util.Objects;

public class Person {

    private final String fornavn;
    private final String etternavn;
    private final int fodselsaar;

    public Person(String fornavn, String etternavn, int fodselsaar) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsaar = fodselsaar;
    }


    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public int getFodselsaar() {
        return fodselsaar;
    }

    public boolean equals(Object object) {
        if(object == null) return false;
        if(this == object) return true;
        if(object instanceof Person) {
            Person person = (Person) object;
            return Objects.equals(this.fornavn, person.getFornavn()) && Objects.equals(this.etternavn, person.getEtternavn());
        }
        return false;
    }

    public String toString() {
        return fornavn + " " + etternavn + " " + fodselsaar;
    }
}
