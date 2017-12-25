package madle;

/**
 * Created by Alex on 2017/8/21.
 */

public class LoginModelBean implements ILoginModel {
    String userName;
    String password;

    public LoginModelBean(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

   /* @Override
    public boolean checkValidity(String userName, String password) {
        if(getUserName().equals(userName)&&getPassword().equals(password)){
            return true;
        }
        return false;
    }*/

    @Override
    public int checkValidity(String userName, String password) {
        if (!getUserName().equals(userName)) {
            return 1;
        }
        if (!getPassword().equals(password)) {
            return 2;
        }
        if (getUserName().equals(userName) && getPassword().equals(password)) {
            return 3;
        }
        return 0;
    }
}
