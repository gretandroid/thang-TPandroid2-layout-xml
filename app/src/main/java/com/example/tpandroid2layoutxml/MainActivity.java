package com.example.tpandroid2layoutxml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tpandroid2layoutxml.model.PersonInfo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final int DEFAULT_COUNTRY_INDEX = 0;
    public static DateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");

    // fake storage
    List<PersonInfo> personInfos = new ArrayList<>();

    private EditText surnameText;
    private EditText nameText;
    private List<CheckBox> formationCheckBoxes = new ArrayList<>();
    private List<RadioButton> marriageStatusRadios = new ArrayList<>();
    private Spinner countrySpinner;
    private EditText dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- init reference for UI attributes --- //
        surnameText = findViewById(R.id.surnameText);
        nameText = findViewById(R.id.nameText);

        // group check box
        formationCheckBoxes.add(findViewById(R.id.frenchCheckBox));
        formationCheckBoxes.add(findViewById(R.id.englishCheckBox));
        formationCheckBoxes.add(findViewById(R.id.italyCheckBox));
        formationCheckBoxes.add(findViewById(R.id.spainCheckBox));

        // group radio
        marriageStatusRadios.add(findViewById(R.id.marriedRadio));
        marriageStatusRadios.add(findViewById(R.id.singleRadio));
        marriageStatusRadios.add(findViewById(R.id.divorcedRadio));
        marriageStatusRadios.add(findViewById(R.id.widownerRadio));

        countrySpinner = findViewById(R.id.countrySpinner);
        dateText = findViewById(R.id.dateText);
    }

    public void save(View view) {
        // name, surname
        String surname = surnameText.getText().toString();
        String name = nameText.getText().toString();

        // formation choices
        List<String> formationChoices = new ArrayList<>();
        formationCheckBoxes.forEach( choice -> {
            if (choice.isChecked()) {
                formationChoices.add(choice.getText().toString());
            }
        });


        // marriage status
        String marriageStatus = EMPTY;
        for (RadioButton choice : marriageStatusRadios) {
            if (choice.isChecked()) {
                marriageStatus = choice.getText().toString();
                break;
            }
        }
        // country selection
        String country = countrySpinner.getSelectedItem().toString();

        // date
        String dateString = dateText.getText().toString();
        Date date = null;
        try {
            date = (Date) DATE_FORMATER.parse(dateString);
        } catch (ParseException e) {
            // Do nothing
        }

        // create an instant of PersonInfo then fill info
        PersonInfo personInfo = new PersonInfo();
        personInfo.setSurname(surname);
        personInfo.setName(name);
        personInfo.addFormations(formationChoices);
        personInfo.setMarriageStatus(marriageStatus);
        personInfo.setCountry(country);
        personInfo.setDate(date);

        // add newly created person info into storage
        personInfos.add(personInfo);

        // show a popup
        Toast.makeText(getBaseContext(), "Saved " + personInfo.toString(), Toast.LENGTH_LONG).show();

        // log debug
        Log.d("Resultat", personInfos.toString());

        // clear fill info on views
        clearUI();
    }

    private void clearUI() {
        surnameText.setText(EMPTY);
        nameText.setText(EMPTY);
        formationCheckBoxes.forEach(checkBox -> checkBox.setChecked(false));
        marriageStatusRadios.forEach(radioButton -> radioButton.setChecked(false));
        countrySpinner.setSelection(DEFAULT_COUNTRY_INDEX);
        dateText.setText(EMPTY);

        // default focus
        surnameText.requestFocus();
    }
}