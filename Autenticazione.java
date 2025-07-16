public class Autenticazione {
    private AdminUser[] adminUsers;

    public Autenticazione() {
        adminUsers = new AdminUser[2];
        adminUsers[0] = new AdminUser("admin1", "1234", "token1");
        adminUsers[1] = new AdminUser("admin2", "5678", "token2");
    }

    public String login(String username, String password) {
        for (int i = 0; i < adminUsers.length; i++) {
            if (adminUsers[i].username.equals(username) && adminUsers[i].password.equals(password)) {
                return adminUsers[i].token;
            }
        }
        return null;
    }
}