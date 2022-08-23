package duke;

public class Task {
  protected String description;
  protected boolean isDone;

  public Task(String description) {
    this.description = description;
    this.isDone = false;
  }

  public Task(String description, boolean isDone) {
    this.description = description;
    this.isDone = isDone;
  }

  public void mark(){
    this.isDone = true;
  }

  public void unmark(){
    this.isDone = false;
  }
  public String getStatusIcon() {
    return (isDone ? "X" : " ");
  }

  public String toString() {
    return "[" + this.getStatusIcon() + "] " + this.description;
  }

}