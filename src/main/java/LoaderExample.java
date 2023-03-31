import java.io.IOException;
import java.util.List;

public class LoaderExample {

    public static void main(String[] args) {
        FootagesAndReportersLoader loader = new FootagesAndReportersLoader();
        try {

            List<FootageAndReporter> footagesAndReporters = loader.loadFootagesAndReporters();
            //System.out.println("loading from "+args[0]);
            for(FootageAndReporter footageAndReporter : footagesAndReporters) {
                System.out.print("\tFootage: " + footageAndReporter.getFootage());
                System.out.println("\tReporter: " + footageAndReporter.getReporter());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

