package part11_project2;

public enum Role {
    ADMIN("stalker56", "ghRT567"),
    MODERATOR("max", "123"),
    USER("roma", "12345Q");

    private String login;
    private String password;

    Role (String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
}
