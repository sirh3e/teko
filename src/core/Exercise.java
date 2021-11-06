package core;

public interface Exercise {
    void execute();

    class Executor {
        public static void execute(Exercise exercise) {
            exercise.execute();
        }
    }
}
