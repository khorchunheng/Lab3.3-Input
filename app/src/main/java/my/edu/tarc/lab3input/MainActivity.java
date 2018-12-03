package my.edu.tarc.lab3input;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Spinner spinnerAge;
   private RadioGroup radioGroupGender;
   private RadioButton radioButtonMale,radioButtonFemale;
   private CheckBox checkBoxSmoker;
   private TextView tetxViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge=findViewById(R.id.spinnerAge);
        radioGroupGender=findViewById(R.id.radioGroupGender);
        radioButtonMale=findViewById(R.id.radioButtonMale);
        radioButtonFemale=findViewById(R.id.radioButtonFemale);
        checkBoxSmoker=findViewById(R.id.checkBoxSmoker);
        tetxViewPremium=findViewById(R.id.textViewPremium);
        ArrayAdapter<CharSequence> adapter=
                ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);
        spinnerAge.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // an message that pop out from the bottom of the screen
        Toast.makeText(this,"Position="+position,Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        float premium=0;
        int age=spinnerAge.getSelectedItemPosition();
        int gender=radioGroupGender.getCheckedRadioButtonId();
        if(age==0){
            premium=50;
        }
        if(age==1){
            premium=55;
        }
        if(age==2){
            premium=60;
        }
        if(age==3){
            premium=70;
            if(gender==R.id.radioButtonMale)
                premium+=50;
            if(checkBoxSmoker.isChecked())
                premium+=100;
        }
        if(age==4){
            premium=90;
            if(gender==R.id.radioButtonMale)
                premium+=100;
            if(checkBoxSmoker.isChecked())
                premium+=150;
        }
        if(age==5){
            premium=120;
            if(gender==R.id.radioButtonMale)
                premium+=150;
            if(checkBoxSmoker.isChecked())
                premium+=200;
        }
        if(age==6){
            premium=150;
            if(gender==R.id.radioButtonMale)
                premium+=200;
            if(checkBoxSmoker.isChecked())
                premium+=250;
        }
        if(age==7){
            premium=150;
            if(gender==R.id.radioButtonMale)
                premium+=200;
            if(checkBoxSmoker.isChecked())
                premium+=300;
        }
        tetxViewPremium.setText("RM"+premium+"0");

        /*if(gender==R.id.radioButtonMale){
            //TODO calculate extra premium for male
        }

        if(checkBoxSmoker.isChecked()){
            //TODO calculate extra premium for smoker
        }*/
    }

    public void reset(View view){
        spinnerAge.setSelection(0);
        radioButtonMale.setChecked(false);
        radioButtonFemale.setChecked(false);
        checkBoxSmoker.setChecked(false);
        tetxViewPremium.setText("Premium");
    }




}
