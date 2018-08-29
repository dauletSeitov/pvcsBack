package just.fo.fun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;
    public List<AuthDto> getAll() {
        return authRepository.getAll();
    }

    public Long create(AuthDto authDto) {
        return  authRepository.create(authDto);
    }
}