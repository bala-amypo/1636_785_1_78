@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository repo,
                           BCryptPasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public User register(User user) {

        if (repo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
