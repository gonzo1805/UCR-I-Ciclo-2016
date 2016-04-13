package cr.ac.ucr.ecci.ci1221;

import cr.ac.ucr.ecci.ci1221.model.Gender;
import cr.ac.ucr.ecci.ci1221.model.Student;
import cr.ac.ucr.ecci.ci1221.util.collection.Iterator;
import cr.ac.ucr.ecci.ci1221.util.collection.queue.Queue;
import cr.ac.ucr.ecci.ci1221.util.collection.stack.Stack;
import cr.ac.ucr.ecci.ci1221.util.collection.queue.QueueArray;
import cr.ac.ucr.ecci.ci1221.util.collection.stack.StackArray;

import java.util.Random;

/**
 * Test class for Stack Model.
 *
 * @author Rodrigo A. Bartels
 * @version 1.0
 */
public class MainQueue {

  public static void main(String[] args) {
    Queue<Integer> queue = new QueueArray<>();
    Random random = new Random(123456789);

    System.out.println("Queue is empty? " + queue.isEmpty());

    long startTime = System.nanoTime();
    for (int i = 0; i < 1000000; i++) {
      queue.add(random.nextInt());
    }

    long estimatedTime = System.nanoTime() - startTime;
    double elapsedTime = (double) estimatedTime / 1000000000.0;
    System.out
      .println("Inserting" + queue.size() + "elements in a Queue took: " + elapsedTime);

    System.out.println("Queue is empty? " + queue.isEmpty());

    Iterator<Integer> iterator = queue.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    for (int i = queue.size(); i > 0; i--) {
      Integer integer = queue.dequeue();
      System.out.println(integer);

    }

    System.out.println("Queue is empty? " + queue.isEmpty());

    queue.enqueue(-1);
    boolean containsCheck = queue.contains(-1);
    System.out.println("The number -1 is available: " + containsCheck);

    queue.enqueue(-2);
    int firstElement = queue.top();
    System.out.println("The first element is equal to -1" + (firstElement == -1));

    System.out.println("Queue is empty? " + queue.isEmpty());

    queue.clear();
    System.out.println("Queue is empty? " + queue.isEmpty());

    Stack<Student> students = new StackArray<>();
    Student student = new Student("Rodrigo Bartels", Gender.MALE, "A40732");
    students.push(student);

    Iterator<Student> studentsIterator = students.iterator();
    while (studentsIterator.hasNext()) {
      System.out.println(studentsIterator.next());
    }
  }
}
