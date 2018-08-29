package just.fo.fun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"just.fo.fun"})
@SpringBootApplication
public class FunApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunApplication.class, args);
    }
}
