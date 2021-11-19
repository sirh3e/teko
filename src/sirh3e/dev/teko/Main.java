package sirh3e.dev.teko;

import sirh3e.dev.rust.Result;
import sirh3e.dev.teko.core.Exercise;
import sirh3e.dev.teko.exercises.Exercise01;

public class Main {
    public static void main(String[] args) {
        Exercise exercise = new Exercise01();
        Exercise.Executor.execute(exercise);

        var heise = Result.Factory.fromOk("");

        var result = parseToInt("");
/*
        var text = "42";
        var result = parseToInt(text);
        var r1 = result
                .map(Main::add5)
                .map(Main::add5)
                .map(Main::add5)
                .map(Main::add5)
                ;
        var number= r1.unwrap();

        System.out.println(number);
 */
    }

    public static Result<Integer, String> parseToInt(String text) {
        try {
            var number = Integer.parseInt(text);
            return Result.Factory.fromOk(number);
        } catch (NumberFormatException exception) {
            return Result.Factory.fromErr(text);
        }
    }

    public static Integer add5(Integer number) {
        return number + 5;
    }
}
