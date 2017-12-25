package madle;

/**
 * Created by Alex on 2017/8/21.
 */

public interface ILoginModel {
    String getUserName();

    String getPassword();

//    boolean checkValidity(String userName, String password);

    int checkValidity(String userName, String password);
}
