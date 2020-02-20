package cat.udl.tidic.amd.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cat.udl.tidic.amd.mvp.presenter.UserPresenter;

public class MainActivity extends AppCompatActivity implements UserViewActions {

    private String TAG = "MVPLog";

    private TextView resultTextView;
    private EditText fullNameEditText;
    private EditText yearEditText;
    private EditText monthEditText;
    private EditText dayEditText;

    private UserPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "Starting onCreate()");

        resultTextView = findViewById(R.id.textView_bio);
        fullNameEditText = findViewById(R.id.editText_fullName);
        yearEditText = findViewById(R.id.editText_year);
        monthEditText = findViewById(R.id.editText_month);
        dayEditText = findViewById(R.id.editText_day);

        presenter = new UserPresenter(this);

    }

    public void update(View view){
        String fullName = fullNameEditText.getText().toString();
        int year = Integer.parseInt(yearEditText.getText().toString());
        int month = Integer.parseInt(monthEditText.getText().toString());
        int day = Integer.parseInt(dayEditText.getText().toString());
        presenter.setUser(fullName,year,month,day);
        presenter.showBio();
    }

    public void clear(View view){
        fullNameEditText.setText("");
        yearEditText.setText("");
        monthEditText.setText("");
        dayEditText.setText("");
        resultTextView.setText("");

    }


    @Override
    public void updateUI(String message) {
        resultTextView.setText(message);
    }
}
