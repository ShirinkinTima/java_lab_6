import ru.shirinkin.testcache.CacheRun;
import ru.shirinkin.testdefault.DefaultRunner;
import ru.shirinkin.testinvoke.InvokeRunner;
import ru.shirinkin.testtostring.Person;
import ru.shirinkin.testtostring.ToStringRunner;
import ru.shirinkin.testtwo.TwoRunner;
import ru.shirinkin.testvalidate.ValidateRunner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice = 6;

        switch (choice) {
            case 1:
                System.out.println("--- Invoke ---");
                InvokeRunner runner1 = new InvokeRunner();
                runner1.run();

                break;
            case 2:
                System.out.println("--- Default ---");
                DefaultRunner runner2 = new DefaultRunner();
                runner2.run();

                break;
            case 3:
                System.out.println("--- ToString ---");
                Person person = new Person("Иван", 30, "secret123");

                String result = ToStringRunner.generate(person);

                System.out.println("Результат:");
                System.out.println(result);

                break;
            case 4:
                System.out.println("--- Validate ---");
                ValidateRunner.run();

                break;
            case 5:
                System.out.println("--- Validate ---");
                TwoRunner.run();

                break;
            case 6:
                System.out.println("--- Cache ---");
                CacheRun.run();
                break;
        }
    }

}
