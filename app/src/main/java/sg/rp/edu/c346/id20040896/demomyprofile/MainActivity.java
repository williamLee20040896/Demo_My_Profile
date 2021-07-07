package sg.rp.edu.c346.id20040896.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText etName, etGpa;

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String nname = prefs.getString("name","unknown");
        float gpa = prefs.getFloat("gpa",0.0f);
        etName.setText(nname);
        etGpa.setText(String.valueOf(gpa));

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs  = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", etName.getText().toString());
        prefEdit.putFloat("gpa",Float.parseFloat(etGpa.getText().toString()));
        prefEdit.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etGpa = findViewById(R.id.editTextGPA);
    }
}