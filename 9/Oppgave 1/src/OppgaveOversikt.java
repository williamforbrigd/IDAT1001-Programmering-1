public class OppgaveOversikt {

    private Student[] studenter;
    private int antStud;

    public OppgaveOversikt(int maksAntStud) {
        if(maksAntStud > 0) {
            studenter = new Student[maksAntStud];
            antStud = 0;
        }
    }

    public int getAntStud() {
        return antStud;
    }

    public int antOppgStudent(String navn) {
        for(int i = 0; i < antStud; i++) {
            if(studenter[i].getNavn().equals(navn.trim()))
                return studenter[i].getAntOppg();
        }
        return 0;
    }

    public boolean regFor(Student student) {
        if(student != null) {
            for(int i = 0; i < antStud; i++) {
                if(studenter[i].equals(student))
                    return true;
            }
        }
        return false;
    }

    public boolean regStudent(Student student) {
        if(student != null) {

            if(regFor(student)) return false;

            if(antStud < studenter.length) {
                studenter[antStud] = new Student(student.getNavn(), student.getAntOppg());
                antStud++;
                return true;
            }
        }
        return false;
    }

    public boolean økAntOppg(String navn, int økning) {
        for(int i = 0; i < antStud; i++) {
            if(studenter[i].getNavn().equals(navn)) {
                studenter[i].økAntOppg(økning);
                return true;
            }
        }
        return false;
    }

    public String skrivUtStudenter() {
        String println = "";
        for(int i = 0; i < antStud; i++) {
            println += (i+1) + ": " + studenter[i].toString() + "\n";
        }
        return println;
    }
}
