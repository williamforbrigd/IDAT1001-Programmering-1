public class Student {

    private String navn;
    private int antOppg;

    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void økAntOppg(int økning) {
        antOppg += økning;
    }

    @Override
    public boolean equals(Object object) {
        if(object == null) return false;
        if(this == object) return true;
        if(object instanceof Student) {
            Student student = (Student) object;
            return student.getNavn().equals(this.navn);
        }
        return false;
    }

    public String toString() {
        return navn + " " + antOppg;
    }
}
