package ru.geekbrains.calculatorfree;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

abstract class ThemesActivity extends AppCompatActivity {
    // Числовые переменные (коды) для тем приложения
    protected final static int LIGHT_THEME = 0;
    protected final static int DARK_THEME = 1;
    protected final static int VAN_GOGH_THEME = 2;

    private static final String AppTheme = "APP_THEME";
    private static final String NameSharedPreference = "THEMES";
    // Сохраняет переменную (код) выбранной темы
    protected int themeChoosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Установка темы
        setTheme(getAppTheme(R.style.LightTheme));
        // Установка переменной (кода)
        setThemeChoosen(getAppTheme((R.style.LightTheme)));
    }

    public int getThemeChoosen() {
        return themeChoosen;
    }

    public void setThemeChoosen(int themeChoosen) {
        this.themeChoosen = themeChoosen;
    }

    protected int getAppTheme(int codeTheme) {
        return codeThemeToThemeId(getCodeTheme(codeTheme));
    }

    // Чтение настроек
    protected int getCodeTheme(int codeTheme) {
        // Через класс сохранения и чтения натроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        // Чтение темы, а если настройка не найдена, то взять по умолчанию
        return sharedPref.getInt(AppTheme, codeTheme);
    }

    // Сохранение настроек
    protected void setAppTheme(int codeTheme) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        // Сохраняем настройки посредством класса editor
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeTheme);
//        editor.putInt(AppTheme, codeTheme);
        editor.apply();
    }

    // Переход от кода (переменной) к самой теме
    private int codeThemeToThemeId(int codeTheme) {
        switch (codeTheme) {
            case LIGHT_THEME:
                return R.style.LightTheme;
            case DARK_THEME:
                return R.style.DarkTheme;
            case VAN_GOGH_THEME:
                return R.style.VanGoghTheme;
        }
        return codeTheme;
    }
}
