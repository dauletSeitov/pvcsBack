package just.fo.fun.auth;

import just.fo.fun.auth.model.AuthDto;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class AuthRepository {

    private List<AuthDto> db = Arrays.asList(
                new AuthDto(1L, "log","pas"),
                new AuthDto(2L, "log2","pas2"),
                new AuthDto(3L, "log3","pas3"));

    public List<AuthDto> getAll() {
        return db;
    }

    public Long create(AuthDto authDto) {
        return db.add(authDto) ? 1L : 0L;
    }
}
