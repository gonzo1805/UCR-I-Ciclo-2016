package cr.ac.ucr.ecci.ci1221.model;

/**
 * Represents a university student.
 */
public class Student implements Comparable{

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

  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Student) {
      return this.id.equalsIgnoreCase(((Student) obj).getId());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();

    result = 29 * result + (name!= null ? name.hashCode() : 0);
    result = 29 * result + (gender!= null ? gender.hashCode() : 0);
    result = 29 * result + (id != null ? id.hashCode() : 0);

    return result;
  }

  @Override
  public int compareTo(Object o) {
    return this.getId().compareTo(((Student) o).getId());
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
