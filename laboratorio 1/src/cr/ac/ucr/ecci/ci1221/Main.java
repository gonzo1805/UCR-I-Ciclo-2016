package cr.ac.ucr.ecci.ci1221;

import java.util.Random;

import cr.ac.ucr.ecci.ci1221.model.Gender;
import cr.ac.ucr.ecci.ci1221.model.Student;
import cr.ac.ucr.ecci.ci1221.util.collection.Iterator;
import cr.ac.ucr.ecci.ci1221.util.collection.list.ArrayList;
import cr.ac.ucr.ecci.ci1221.util.collection.list.LinkedList;
import cr.ac.ucr.ecci.ci1221.util.collection.list.List;

/**
 * Test class for Lab 1.
 *
 * @author Rodrigo A. Bartels
 * @version 1.0
 */
public class Main {

  public static void main(String[] args) {
    List<Integer> list1 = new LinkedList<>();
    Random random = new Random(123456789);

    System.out.println("List is empty? " + list1.isEmpty());

    long startTime = System.nanoTime();
    for (int i = 0; i < 10; i++) {
      list1.add(random.nextInt());
    }
    long estimatedTime = System.nanoTime() - startTime;
    double elapsedTime = (double) estimatedTime / 1000000000.0;
    System.out
      .println("Inserting" + list1.size() + "elements in a Array List took: " + elapsedTime);

    System.out.println("List is empty? " + list1.isEmpty());

    list1.add(-1);
    boolean containsCheck = list1.contains(-1);
    System.out.println("The number -1 is available: " + containsCheck);

    list1.add(-2, 5);
    int position = list1.find(-2);
    System.out.println("The number -2 is at position: " + position);

    list1.remove(new Integer(-2));
    position = list1.find(-2);
    System.out.println("The number -2 is at position: " + position);

    Integer firstElement = list1.get(1);
    System.out.println("The first element is: " + firstElement);

    list1.sort();

    firstElement = list1.get(1);
    System.out.println("The first element is: " + firstElement);

    list1.remove(1);
    firstElement = list1.get(1);
    System.out.println("The first element is: " + firstElement);

    list1.set(1, 0);
    firstElement = list1.get(1);
    System.out.println("The first element is: " + firstElement);

    Iterator<Integer> iterator = list1.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    list1.clear();
    System.out.println("List is empty? " + list1.isEmpty());

    List<Student> students = new ArrayList<>();
    Student student = new Student("Rodrigo Bartels", Gender.MALE, "A40732");
    students.add(student);

    Iterator<Student> studentsIterator = students.iterator();
    while (studentsIterator.hasNext()) {
      System.out.println(studentsIterator.next());
    }
  }
}
