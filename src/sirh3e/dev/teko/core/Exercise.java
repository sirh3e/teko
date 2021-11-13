package sirh3e.dev.teko.core;

public interface Exercise {
    void execute();

    class Executor {
        public static void execute(Exercise exercise) {
            exercise.execute();
        }
    }
}
