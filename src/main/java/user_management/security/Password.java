package user_management.security;

public class Password {

    private final static int workload = 12;
    private final String hash;

    public Password(String password) {
        this.hash = hashPassword(password);
    }

    public static String hashPassword(String password_plaintext) {
        return BCrypt.hashpw(password_plaintext, BCrypt.gensalt(workload));
    }

    public boolean matches(String password_plaintext) {
        boolean password_verified = false;
        if (null == hash || !hash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        password_verified = BCrypt.checkpw(password_plaintext, hash);
        return(password_verified);
        // Sure whatever
    }

    public String getHash() {
        return hash;
    }

}
