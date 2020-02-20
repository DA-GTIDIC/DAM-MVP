package cat.udl.tidic.amd.mvp.presenter;

import cat.udl.tidic.amd.mvp.UserViewActions;
import cat.udl.tidic.amd.mvp.models.UserModel;

public class UserPresenter {


    private UserModel model;
    private UserViewActions view;

    // Presenter has no knowledge of the view
    // Just knows the view interface
    public UserPresenter(UserViewActions view){
        this.view = view;
    }


    public void setUser(String fullName, int year, int month, int day) {
        this.model = new UserModel(fullName,year,month,day);
    }

    public void showBio(){
        view.updateUI(this.model.toString());
    }
}
