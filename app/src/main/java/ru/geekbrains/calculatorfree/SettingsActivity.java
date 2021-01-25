package ru.geekbrains.calculatorfree;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends ThemesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initThemeChooser();

        Button btnReturn = findViewById(R.id.button_return);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Метод, завершающий активити
                finish();
            }
        });
    }

    // Инициализируем радиокнопки
    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.r_b_light_theme), LIGHT_THEME);
        initRadioButton(findViewById(R.id.r_b_dark_theme), DARK_THEME);
        initRadioButton(findViewById(R.id.r_b_van_gogh_theme), VAN_GOGH_THEME);
        RadioGroup rg = findViewById(R.id.r_buttons);
        ((MaterialRadioButton) rg.getChildAt(getCodeTheme(LIGHT_THEME))).setChecked(true);
    }

    // Отельный метод для инициализации
    private void initRadioButton(View button, final int codeTheme) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Сохранение настроек
                setAppTheme(codeTheme);
                // Пересоздание активити для применения темы
                recreate();
            }
        });
    }
}