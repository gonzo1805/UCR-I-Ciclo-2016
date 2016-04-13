package cr.ac.ucr.ecci.ci1221.util;

import java.util.Random;

/**
 * Generates random student ids.
 *
 * @author Rodrigo A. Bartels
 */
public class RandomStudentIdGenerator {

    private static Random random = new Random();

    public static String generateStudentId(){
        Integer nextId = random.nextInt();

        return String.valueOf(nextId);
    }
}
