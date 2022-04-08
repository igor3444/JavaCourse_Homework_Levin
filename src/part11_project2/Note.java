package part11_project2;

public abstract class Note {
    private String title;
    private String body;
    private int numNote;

    public Note() {
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public int getNumNote() {
        return numNote;
    }
    public void setNumNote(int numNote) {
        this.numNote = numNote;
    }
}
