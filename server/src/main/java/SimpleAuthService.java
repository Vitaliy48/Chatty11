import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {
    private class UserData {
        String login;
        String password;
        String nickname;

        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    private List<UserData> users;

    public SimpleAuthService() {
        users = new ArrayList<>();
        users.add(new UserData("111", "111", "Nick1"));
        users.add(new UserData("222", "222", "Nick2"));
        users.add(new UserData("333", "333", "Nick3"));

        for (int i = 0; i < 9; i++) {
            users.add(new UserData("user" + i, "pass" + i, "nick" + i));
        }

    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        for (UserData u : users) {
            if (u.login.equals(login) && u.password.equals(password)) {
                return u.nickname;
            }
        }

        return null;
    }
}
