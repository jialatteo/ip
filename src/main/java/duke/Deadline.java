package duke;

public class Deadline extends  Task{
  protected String by;
  public Deadline(String description,String date, boolean isDone) {
    super(description,isDone);
    this.by = date;
  }
  public Deadline(String description,String date) {
    super(description);
    this.by = date;
  }

  public String toString() {
    return "[D][" + this.getStatusIcon() + "] " + this.description + " (by: " + by + ")";
  }
}
