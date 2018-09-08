package just.fo.fun.entities;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Slf4j
@Entity
@ToString
@Data
public class Commentary {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    private String text;

    @Length(max = 512)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Commentary parent;

    @Column(columnDefinition="bigint default '0'")
    private Long rating;

}
