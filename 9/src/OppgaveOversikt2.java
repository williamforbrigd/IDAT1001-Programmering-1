import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class OppgaveOversikt2 {

    private HashMap<Integer, Student> studenter;

    public OppgaveOversikt2() {
        studenter = new HashMap<Integer, Student>();
    }

    public OppgaveOversikt2(HashMap<Integer, Student> studenter) {
        this.studenter = studenter;
    }

    public String listAlleStudenter() {
        String println = "";
        int index = 0;
        /*

        while(index < studenter.values().size()) {
            println += studenter.get(index).toString() + "\n";
            index++;
        }

        for(int i = 0; i < studenter.values().size(); i++) {
            println += studenter.get(i).toString() + "\n";
         */

        for(Student student : this.studenter.values()) {
            index++;
            println += index + ": " + student.toString() + "\n";
        }
        return println;
    }

    public String listAlleStudenter2() {
        String println = "";

        Iterator<Student> it = this.studenter.values().iterator();

        while(it.hasNext()) {
            Student student = it.next();
            println += student.toString() + "\n";
        }
        return println;
    }

    public int getAntStud() {
        return studenter.values().size();
    }

    public int antOppgStudent(String navn) {
        for(int i = 0; i < this.studenter.values().size(); i++) {
            if(studenter.get(i).getNavn().equals(navn.trim()))
                return studenter.get(i).getAntOppg();
        }
        return 0;
    }

    public boolean regFor(Student student) {
        if(student != null) {
            for(Student s : studenter.values()) {
                if(s.equals(student))
                    return true;
            }
        }
        return false;
    }

    public boolean regStudent(Student student) {
        int antallStudener = 0;
        if(student != null) {

            if(regFor(student)) return false;

            antallStudener++;
            studenter.put(antallStudener, student);
            return true;
        }
        return false;
    }

    public boolean økAntOppg(String navn, int økning) {
        for(int i = 0; i < studenter.values().size(); i++) {
            if(!studenter.get(i).getNavn().equals(navn.trim())) {
                return false;
            }
            studenter.get(i).økAntOppg(økning);
            return true;
        }
        return false;
    }




}
