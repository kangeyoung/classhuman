package feb26.note;

public class User {
    private String pass;
    private NoteM noteM;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setNoteM(NoteM noteM) {
        this.noteM = noteM;
    }

    public NoteM getNoteM() {
        return noteM;
    }
}

