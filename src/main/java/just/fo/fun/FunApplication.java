package just.fo.fun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication

public class FunApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FunApplication.class, args);
    }
}



