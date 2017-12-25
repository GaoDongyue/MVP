package presenter;

import android.os.Handler;

import madle.ILoginModel;
import madle.LoginModelBean;
import view.ILoginView;


/**
 * Created by Alex on 2017/8/21.
 */

public class PresenterImpl implements IPresenter {
    ILoginView iloginView;
    private final ILoginModel iLoginModel;
    Handler handler;
    private boolean loginStatus;
    private int loginCode;

    //向下转型
    public PresenterImpl(ILoginView iloginView) {
        this.iloginView = iloginView;
        iLoginModel = new LoginModelBean("mvp", "mvp");
        handler = new Handler();
    }

    @Override
    public void doLogin(String userName, String password) {
        //模拟网络请求
//        loginStatus = iLoginModel.checkValidity(userName, password);
        loginCode = iLoginModel.checkValidity(userName, password);

        //发送延时消息
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                iloginView.onShowResult(loginStatus);
                iloginView.onShowResult(loginCode);
            }
        }, 2000);
    }

    @Override
    public void doClear() {
        iloginView.onClear();
    }
}
