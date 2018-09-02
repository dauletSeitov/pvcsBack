package just.fo.fun.entities;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@ToString
@Data
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(unique = true)
    private String login;
    private String password;
    private String name;

    @Column
    @UpdateTimestamp
    private LocalDateTime updated;

}
