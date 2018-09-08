package just.fo.fun;

import just.fo.fun.entities.Category;
import just.fo.fun.entities.Post;
import just.fo.fun.entities.User;
import just.fo.fun.post.repository.PostRepository;
import just.fo.fun.user.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

//@ComponentScan(basePackages = {"just.fo.fun", "just.fo.fun.auth",  "just.fo.fun.auth.controller"})
@SpringBootApplication

public class FunApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FunApplication.class, args);
        new InitDB(context).fillDb();
    }



}

class InitDB{

    private ConfigurableApplicationContext context;

    public InitDB(ConfigurableApplicationContext context) {
        this.context = context;
    }

    public void fillDb() {
        fillUser(100);
        fillCategory(20);
        fillPost(1000);
        System.out.println("initialization is finished !");
    }

    private void fillUser(int len){
        UserRepository repository = context.getBean(UserRepository.class);

        if(len <= repository.findAll().size()) return;

        for (int i = 1; i < 100 ; i++) {

            User user = new User();
            user.setLogin(randomRow("login"));
            user.setName(randomRow("name"));
            user.setPassword(randomRow("pas"));

            try {
                repository.save(user);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void fillCategory(int len){

        CategoryRepository repository = context.getBean(CategoryRepository.class);

        if(len <= repository.findAll().size()) return;

        for (int i = 1; i < 20 ; i++) {

            Category category = new Category();
            category.setName(randomRow("CN"));

            try {
                repository.save(category);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void fillPost(int len){

        PostRepository repository = context.getBean(PostRepository.class);

        if(len <= repository.findAll().size()) return;

        UserRepository userRepository = context.getBean(UserRepository.class);
        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);

        List<User> userList = userRepository.findAll();
        List<Category> categoryList = categoryRepository.findAll();
        int userCount = userList.size();
        int categoryCount = categoryList.size();

        for (int i = 1; i < 1000 ; i++) {

            Post post = new Post();
            post.setCategory(categoryList.get(ThreadLocalRandom.current().nextInt(1, categoryCount-1)));
            post.setImageUrl(randomRow("image"));
            post.setLikes(ThreadLocalRandom.current().nextLong(-10000, 10000));
            post.setTitle(randomRow("title"));
            post.setUser(userList.get(ThreadLocalRandom.current().nextInt(1, userCount-1)));

            try {
                repository.save(post);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private String randomRow (String str){
        return str + UUID.randomUUID().toString().substring(0, 7);
    }

}


