package just.fo.fun;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Slf4j
@Entity
@ToString
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private Long userId;

    private String title;

    private String text;

    private String imageUrl;

}
