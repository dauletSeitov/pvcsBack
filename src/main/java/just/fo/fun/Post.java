package just.fo.fun;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Slf4j
@Entity
@ToString
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne

    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String text;

    private String imageUrl;

}