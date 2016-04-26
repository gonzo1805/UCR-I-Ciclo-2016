package cr.ac.ucr.ecci.ci1221;

import cr.ac.ucr.ecci.ci1221.model.Gender;
import cr.ac.ucr.ecci.ci1221.model.Student;
import cr.ac.ucr.ecci.ci1221.util.collection.Iterator;
import cr.ac.ucr.ecci.ci1221.util.collection.stack.Stack;
import cr.ac.ucr.ecci.ci1221.util.collection.stack.StackArray;
import cr.ac.ucr.ecci.ci1221.util.collection.stack.StackLinkedList;
import cr.ac.ucr.ecci.ci1221.util.collection.stack.StackSpecialArray;

import java.util.Random;

/**
 * Test class for the Stack Model.
 *
 * @author Rodrigo A. Bartels
 * @version 1.0
 */
public class MainStack {

  public static void main(String[] args) {
    Stack<Integer> stack = new StackSpecialArray<>();
    Random random = new Random(123456789);

    System.out.println("Stack is empty? " + stack.isEmpty());

    long startTime = System.nanoTime();
    for (int i = 0; i < 1000000; i++) {
      stack.add(random.nextInt());
    }
    long estimatedTime = System.nanoTime() - startTime;
    double elapsedTime = (double) estimatedTime / 1000000000.0;
    System.out
            .println("Inserting" + stack.size() + "elements in a Stack took: " + elapsedTime);

    System.out.println("Stack is empty? " + stack.isEmpty());

    Iterator<Integer> iterator = stack.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    for (int i = stack.size(); i > 0; i--) {
      Integer integer = stack.pop();
      System.out.println(integer);

    }

    System.out.println("Stack is empty? " + stack.isEmpty());

    stack.push(-1);
    boolean containsCheck = stack.contains(-1);
    System.out.println("The number -1 is available: " + containsCheck);

    stack.push(-2);
    int firstElement = stack.peek();
    System.out.println("The first element is " + firstElement);

    System.out.println("Stack is empty? " + stack.isEmpty());

    stack.clear();
    System.out.println("Stack is empty? " + stack.isEmpty());

    Stack<Student> students = new StackArray<>();
    Student student = new Student("Rodrigo Bartels", Gender.MALE, "A40732");
    students.push(student);

    Iterator<Student> studentsIterator = students.iterator();
    while (studentsIterator.hasNext()) {
      System.out.println(studentsIterator.next());
    }
  }
}
