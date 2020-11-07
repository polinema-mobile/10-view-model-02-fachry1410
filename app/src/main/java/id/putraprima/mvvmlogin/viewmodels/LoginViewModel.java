package id.putraprima.mvvmlogin.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.models.Login;

public class LoginViewModel extends ViewModel {
    private String email = "fachry@gmail.com";
    private String password = "fachrynajib";
    private MutableLiveData<Login> loginMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loggedMutableLive = new MutableLiveData<>();
    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();
    private Login login;

    private MutableLiveData<Login> userMutableLiveData;
    public LoginViewModel(Login login) {
        this.login = login;
        this.loginMutableLiveData.setValue(this.login);
    }
    public MutableLiveData<Login> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }
    public void doLogin() {
        Log.d("Email", login.email);
        Log.d("Pass", login.password);
        loggedMutableLive.setValue(false);

        if (login.email.equals(email) && login.password.equals(password)) {
            loginMutableLiveData.setValue(login);
            loggedMutableLive.setValue(true);
            return;
        }else if(login.email.isEmpty() || login.email == null && login.password.equals(password)){
            EmailAddress.setValue("Enter an E-Mail Address");
            loggedMutableLive.setValue(false);
            return;
        } else if (login.email.isEmpty() && login.password.isEmpty()){
            EmailAddress.setValue("Masukkan alamat email Anda"); // set pesan
            Password.setValue("Masukkan password Anda"); // set pesan
            loggedMutableLive.setValue(false);
            return;
        }else if (!login.isEmailValid()) {
            EmailAddress.setValue("Enter a Valid E-mail Address");
            loggedMutableLive.setValue(true);
            return;
        } else if (login.email.equals(email) && login.password.isEmpty() || login.password == null || !login.password.equals(password)) {
            Password.setValue("Enter a Password");
            loggedMutableLive.setValue(false);
            return;
        } else if (!login.isPasswordLengthGreaterThan5()) {
            Password.setValue("Enter at least 6 Digit password");
            loggedMutableLive.setValue(false);
            return;
        } else if (!login.email.equals(email) || !login.password.equals(password)){
            EmailAddress.setValue("Masukkan alamat email Anda dengan benar");
            Password.setValue("Masukkan password Anda dengan benar");
            loggedMutableLive.setValue(false);
            return;
        }

    }
    public LiveData<Login> getLogin(){
        return this.loginMutableLiveData;
    }

    public LiveData<Boolean> loggedLiveData() {
        return this.loggedMutableLive;
    }

}
