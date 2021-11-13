package sirh3e.dev.teko;

import sirh3e.dev.teko.core.Exercise;
import sirh3e.dev.teko.exercises.Exercise01;

public class Main {
    public static void main(String[] args) {
        Exercise exercise = new Exercise01();
        Exercise.Executor.execute(exercise);
    }
}
