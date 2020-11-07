package id.putraprima.mvvmlogin.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.putraprima.mvvmlogin.models.Login;

public class LoginViewModelFactory implements ViewModelProvider.Factory  {
    private Login login;

    public LoginViewModelFactory(Login login) {
        this.login = login;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(LoginViewModel.class)){
            return (T) new LoginViewModel(login);
        }
        throw new IllegalArgumentException("Viewmodel Yang Diminta LoginViewModel");
    }
}
