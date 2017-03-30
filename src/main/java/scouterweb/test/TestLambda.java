package scouterweb.test;

/**
 * @author Gun Lee (gunlee01@gmail.com) on 2017. 3. 27.
 */
public class TestLambda {
    interface StringSupplier {
        String get(Double d);
    }

    public void doPublicLambda() {
        Runnable r = () -> String.valueOf(1);
    }

    public void doPublicLambdaWithArgs() {
        int a = 2;
        long b = 3L;
        Runnable r = () -> {
            long z = a + b;
        };
    }

    public void doPublicReturnLambdaWithArgs() {
        int a = 2;
        long b = 3L;
        StringSupplier s= (x) -> String.valueOf(a + b);
    }
}
