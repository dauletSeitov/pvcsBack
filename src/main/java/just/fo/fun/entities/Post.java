package just.fo.fun.entities;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Length(max = 512)
    private String imageUrl;

    @Column
    @UpdateTimestamp
    private LocalDateTime updated;

    @ManyToOne
    private Category category;

    @Column(columnDefinition="bigint default '0'")
    private Long rating;

}
