package view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lenovo.mvptest.R;

import presenter.IPresenter;
import presenter.PresenterImpl;

public class MainActivity extends AppCompatActivity implements ILoginView,View.OnClickListener {

    private EditText etUserName;
    private EditText etPassword;
    private Button btn_login;
    private Button btn_clear;
    private ProgressBar pb_progress;
    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //多态
        //通过构造函数完成参数传递，完成V层和P层的关联
        presenter = new PresenterImpl(this);
        initView();
    }

    private void initView() {
        etUserName = (EditText) findViewById(R.id.et_userName);
        etPassword = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        pb_progress = (ProgressBar) findViewById(R.id.pb_progress);

        btn_login.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                presenter.doLogin(etUserName.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.btn_clear:
                presenter.doClear();
                break;
        }
    }

    @Override
    public void onShowResult(int loginCode) {

        switch (loginCode) {
            case 0:
                Toast.makeText(this, "服务器错误", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "用户名错误", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClear() {
        etUserName.setText("");
        etPassword.setText("");
    }
}
