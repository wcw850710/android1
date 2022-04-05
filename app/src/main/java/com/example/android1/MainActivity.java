package com.example.android1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android1.classes.BmiFormData;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    RadioButton maleRadio = null;
    RadioButton femaleRadio = null;
    EditText ageEditText = null;
    EditText feetEditText = null;
    EditText inchesEditText = null;
    EditText weightEditText = null;
    Button calculateButton = null;
    TextView resultText = null;

    public RadioButton getMaleRadio() {
        return maleRadio;
    }

    public void setMaleRadio(RadioButton maleRadio) {
        this.maleRadio = maleRadio;
    }

    public RadioButton getFemaleRadio() {
        return femaleRadio;
    }

    public void setFemaleRadio(RadioButton femaleRadio) {
        this.femaleRadio = femaleRadio;
    }

    public EditText getAgeEditText() {
        return ageEditText;
    }

    public void setAgeEditText(EditText ageEditText) {
        this.ageEditText = ageEditText;
    }

    public EditText getFeetEditText() {
        return feetEditText;
    }

    public void setFeetEditText(EditText feetEditText) {
        this.feetEditText = feetEditText;
    }

    public EditText getInchesEditText() {
        return inchesEditText;
    }

    public void setInchesEditText(EditText inchesEditText) {
        this.inchesEditText = inchesEditText;
    }

    public EditText getWeightEditText() {
        return weightEditText;
    }

    public void setWeightEditText(EditText weightEditText) {
        this.weightEditText = weightEditText;
    }

    public Button getCalculateButton() {
        return calculateButton;
    }

    public void setCalculateButton(Button calculateButton) {
        this.calculateButton = calculateButton;
    }

    public TextView getResultText() {
        return resultText;
    }

    public void setResultText(TextView resultText) {
        this.resultText = resultText;
    }

    private void setupViews() {
        setMaleRadio(findViewById(R.id.radio_male));
        setFemaleRadio(findViewById(R.id.radio_female));
        setAgeEditText(findViewById(R.id.edit_text_age));
        setFeetEditText(findViewById(R.id.edit_text_feet));
        setInchesEditText(findViewById(R.id.edit_text_inches));
        setWeightEditText(findViewById(R.id.edit_text_weight));
        setCalculateButton(findViewById(R.id.button_calculate));
        setResultText(findViewById(R.id.text_view_result));
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBmi();
            }
        });
    }

    private BmiFormData checkFormData() throws Error {
        String ageText = getAgeEditText().getText().toString();
        String feetText = getFeetEditText().getText().toString();
        String inchesText = getInchesEditText().getText().toString();
        String weightText = getWeightEditText().getText().toString();

        if (ageText.equals("") || feetText.equals("") || inchesText.equals("") || weightText.equals("")) {
            Toast.makeText(MainActivity.this, "請填寫完整資訊!!", Toast.LENGTH_SHORT).show();
            throw new Error("請填寫完整資訊!!");
        }

        int age = Integer.parseInt(ageText);
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        return new BmiFormData(age, feet, inches, weight);
    }

    private void calculateBmi() {
        try {
            BmiFormData formData = checkFormData();
            String fullResult = getResult(formData);
            resultText.setText(fullResult);
        } catch (Error ignored) {
        }
    }

    @NonNull
    private String getResult(BmiFormData formData) {
        DecimalFormat decimalFormatter = new DecimalFormat("0.00");
        int totalInches = formData.getFeet() * 12 + formData.getInches();
        double heightInMeters = totalInches * 0.0254;
        double bmi = formData.getWeight() / (heightInMeters * heightInMeters);

        String bmiTextResult = decimalFormatter.format(bmi);
        String fullResult;
        if (bmi < 18.5) {
            fullResult = bmiTextResult + " - 你太瘦了";
        } else if (bmi > 25) {
            fullResult = bmiTextResult + " - 你太胖了";
        } else {
            fullResult = bmiTextResult + " - 你有健康的體重";
        }
        return fullResult;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupButtonClickListener();
    }
}