package ru.geekbrains.calculatorfree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends ThemesActivity implements View.OnClickListener {

    private Calculations calculations;
    private TextView windowSign;
    private TextView windowInput;
    private TextView windowOutput;
    private TextView windowSignMemory;
    private Button button_00;
    private Button button_0;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_point;
    private Button button_equal;
    private Button button_sum;
    private Button button_sub;
    private Button button_multiply;
    private Button button_div;
    private Button button_percent;
    private Button button_clear;
    private Button button_m_sub;
    private Button button_m_plus;
    private Button button_mr;
    private Button button_mc;
    private Button settings;
    private final static int REQUEST_CODE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Установка темы
        setTheme(getAppTheme(getThemeChoosen()));
        setContentView(R.layout.activity_main);
        calculations = new Calculations();
        initView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != REQUEST_CODE) {
            super.onActivityResult(requestCode, resultCode, data);
        }
        if (requestCode == REQUEST_CODE) {
            recreate();
        }
    }

    private void initView() {
        findViews();
        initClickListeners();

        Button btnSettings = findViewById(R.id.settings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Чтобы стартовать активити, необходимо подготовить интент
                // В данном случае это будет явный интент, поскольку здесь передаётся класс активити
                Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
                // Метод стартует активити, указанную в интенте
                startActivityForResult(runSettings, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.button_00):
                setNum(R.id.button_00);
                break;
            case (R.id.button_0):
                setNum(R.id.button_0);
                break;
            case (R.id.button_1):
                setNum(R.id.button_1);
                break;
            case (R.id.button_2):
                setNum(R.id.button_2);
                break;
            case (R.id.button_3):
                setNum(R.id.button_3);
                break;
            case (R.id.button_4):
                setNum(R.id.button_4);
                break;
            case (R.id.button_5):
                setNum(R.id.button_5);
                break;
            case (R.id.button_6):
                setNum(R.id.button_6);
                break;
            case (R.id.button_7):
                setNum(R.id.button_7);
                break;
            case (R.id.button_8):
                setNum(R.id.button_8);
                break;
            case (R.id.button_9):
                setNum(R.id.button_9);
                break;
            case (R.id.button_point):
                setNum(R.id.button_point);
                break;
            case (R.id.button_equal):
                setSign(R.id.button_equal);
                break;
            case (R.id.button_sum):
                setSign(R.id.button_sum);
                break;
            case (R.id.button_sub):
                setSign(R.id.button_sub);
                break;
            case (R.id.button_percent):
                setSign(R.id.button_percent);
                break;
            case (R.id.button_clear):
                clear();
                break;
            case (R.id.button_m_plus):
                setSignMemory(R.id.button_m_plus);
                break;
            case (R.id.button_m_sub):
                setSignMemory(R.id.button_m_sub);
                break;
            case (R.id.button_div):
                setSign(R.id.button_div);
                break;
            case (R.id.button_mc):
                setSignMemory(R.id.button_mc);
                break;
            case (R.id.button_mr):
                setSignMemory(R.id.button_mr);
                break;
            case (R.id.button_multiply):
                setSign(R.id.button_multiply);
                break;
        }
    }

    private void initClickListeners() {
        button_00.setOnClickListener(this);
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_div.setOnClickListener(this);
        button_equal.setOnClickListener(this);
        button_m_plus.setOnClickListener(this);
        button_m_sub.setOnClickListener(this);
        button_sum.setOnClickListener(this);
        button_sub.setOnClickListener(this);
        button_mc.setOnClickListener(this);
        button_mr.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_percent.setOnClickListener(this);
        button_point.setOnClickListener(this);
        windowSign.setOnClickListener(this);
        windowSignMemory.setOnClickListener(this);
        windowInput.setOnClickListener(this);
        windowOutput.setOnClickListener(this);
    }

    private void findViews() {
        button_00 = findViewById(R.id.button_00);
        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);
        button_clear = findViewById(R.id.button_clear);
        button_div = findViewById(R.id.button_div);
        button_equal = findViewById(R.id.button_equal);
        button_m_plus = findViewById(R.id.button_m_plus);
        button_m_sub = findViewById(R.id.button_m_sub);
        button_sub = findViewById(R.id.button_sub);
        button_sum = findViewById(R.id.button_sum);
        button_mc = findViewById(R.id.button_mc);
        button_mr = findViewById(R.id.button_mr);
        button_multiply = findViewById(R.id.button_multiply);
        button_percent = findViewById(R.id.button_percent);
        button_point = findViewById(R.id.button_point);
        windowSign = findViewById(R.id.window_sign);
        windowSignMemory = findViewById(R.id.window_sign_memory);
        windowInput = findViewById(R.id.window_input);
        windowOutput = findViewById(R.id.window_output);
        settings = findViewById(R.id.settings);
    }

//    private void setShowResultText() {
//        windowInput.setText(calculations.getStringResult());
//        windowInput.setText(calculations.getStringActualNum());
//    }

    String getViewText(int id) {
        if (id == R.id.button_00) {
            return (String) button_00.getText();
        } else if (id == R.id.button_0) {
            return (String) button_0.getText();
        } else if (id == R.id.button_1) {
            return (String) button_1.getText();
        } else if (id == R.id.button_2) {
            return (String) button_2.getText();
        } else if (id == R.id.button_3) {
            return (String) button_3.getText();
        } else if (id == R.id.button_4) {
            return (String) button_4.getText();
        } else if (id == R.id.button_5) {
            return (String) button_5.getText();
        } else if (id == R.id.button_6) {
            return (String) button_6.getText();
        } else if (id == R.id.button_7) {
            return (String) button_7.getText();
        } else if (id == R.id.button_8) {
            return (String) button_8.getText();
        } else if (id == R.id.button_9) {
            return (String) button_9.getText();
        } else if (id == R.id.button_point) {
            return (String) button_point.getText();
        } else if (id == R.id.button_sum) {
            return (String) button_sum.getText();
        } else if (id == R.id.button_sub) {
            return (String) button_sub.getText();
        } else if (id == R.id.button_div) {
            return (String) button_div.getText();
        } else if (id == R.id.button_percent) {
            return (String) button_percent.getText();
        } else if (id == R.id.button_m_sub) {
            return (String) button_m_sub.getText();
        } else if (id == R.id.button_m_plus) {
            return (String) button_m_plus.getText();
        } else if (id == R.id.button_mr) {
            return (String) button_mr.getText();
        } else if (id == R.id.button_mc) {
            return (String) button_mc.getText();
        } else if (id == R.id.button_multiply) {
            return (String) button_multiply.getText();
        } else if (id == R.id.button_equal) {
            return (String) button_equal.getText();
        } else {
            return null;
        }
    }

    private void setNum(int buttonId) {
        windowInput.setText(getViewText(buttonId));
    }

    private void setSign(int buttonId) {
        windowSign.setText(getViewText(buttonId));
    }

    private void setSignMemory(int buttonId) {
        windowSignMemory.setText(getViewText(buttonId));
    }

    private void clear() {
        calculations.clear();
        windowInput.setText("");
        windowOutput.setText("");
        windowSign.setText("");
        windowSignMemory.setText("");
    }

//    private void setEqual(){
//        calculations.makeCalculation();
//        setShowResultText();
//    }


}