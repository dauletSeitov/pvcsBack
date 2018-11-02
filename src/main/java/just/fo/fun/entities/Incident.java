package just.fo.fun.entities;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Slf4j
@Entity
@ToString
@Data
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private int dangerLevel;

}
