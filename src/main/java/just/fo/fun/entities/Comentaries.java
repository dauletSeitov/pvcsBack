package just.fo.fun.entities;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Entity
@ToString
@Data
public class Comentaries {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    private String text;

}
