package just.fo.fun.auth.model;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Data
public class AuthDto {

    @NotNull
    public String login;
    @NotNull
    public String pwd;
}
