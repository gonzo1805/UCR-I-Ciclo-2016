package cr.ac.ucr.ecci.ci1221.model;

/**
 * Represents a university student
 */
public class Student {

  /**
   * The student's name.
   */
  private String name;

  /**
   * The student's gender.
   */
  private Gender gender;

  /**
   * The student university identifier
   */
  private String id;

  public Student(String name, Gender gender, String id) {
    this.setName(name);
    this.setGender(gender);
    this.setId(id);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
