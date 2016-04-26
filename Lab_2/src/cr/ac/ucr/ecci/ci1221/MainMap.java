package cr.ac.ucr.ecci.ci1221;

import cr.ac.ucr.ecci.ci1221.util.RandomStudentIdGenerator;
import cr.ac.ucr.ecci.ci1221.util.collection.map.Map;
import cr.ac.ucr.ecci.ci1221.util.collection.map.LinkedMap;

import java.util.Random;

/**
 * Test class for Map Model.
 *
 * @author Rodrigo A. Bartels
 * @version 1.0
 */
public class MainMap {

  public static void main(String[] args) {
    Map<String, Integer> map = new LinkedMap<>();
    Random random = new Random();

    System.out.println("Map is empty? " + map.isEmpty());

    long startTime = System.nanoTime();
    for (int i = 0; i < 1000000; i++) {
      map.put(RandomStudentIdGenerator.generateStudentId(), random.nextInt(10));
    }
    long estimatedTime = System.nanoTime() - startTime;
    double elapsedTime = (double) estimatedTime / 1000000000.0;
    System.out
      .println("Inserting" + map.size() + "elements in a Array Map took: " + elapsedTime);

    System.out.println("Map is empty? " + map.isEmpty());

    map.put("A40732", 10);
    boolean containsCheck = map.containsKey("A40732");
    System.out.println("The student with ID A40732 is in the map" + containsCheck);
    Integer gpa = map.get("A40732");
    System.out.println("The student with ID A40732 has a GPA of: " + gpa);

    map.remove("A40732");

    containsCheck = map.containsKey("A40732");
    System.out.println("The student with ID A40732 is in the map" + containsCheck);

    map.clear();
    System.out.println("Map is empty? " + map.isEmpty());
  }
}
