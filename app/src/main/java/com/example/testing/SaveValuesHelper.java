package com.example.testing;

import android.content.SharedPreferences;

public class SaveValuesHelper {

    public static final String KEY_FIRST_OPERAND = "first_operand";
    public static final String KEY_SECOND_OPERAND = "second_operand";

    private final SharedPreferences sharedPreferences;

    public SaveValuesHelper(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void saveValues(Values values) {
        sharedPreferences.edit()
                .putString(KEY_FIRST_OPERAND, values.getFirstOperand())
                .putString(KEY_SECOND_OPERAND, values.getSecondOperand())
                .commit();
    }

    public Values readValues() {
        Values values = new Values();
        values.setFirstOperand(sharedPreferences.getString(KEY_FIRST_OPERAND, ""));
        values.setSecondOperand(sharedPreferences.getString(KEY_SECOND_OPERAND, ""));
        return values;
    }
}