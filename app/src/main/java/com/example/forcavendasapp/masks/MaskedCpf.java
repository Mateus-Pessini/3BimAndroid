package com.example.forcavendasapp.masks;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MaskedCpf {

    private static final String CPF_MASK = "###.###.###-##";

    public static void addCPFMask(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            private boolean isUpdating = false;
            private String oldText = "";

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String newText = s.toString();
                if (isUpdating) {
                    oldText = newText;
                    isUpdating = false;
                    return;
                }

                if (!newText.equals(oldText)) {
                    String digitsOnly = newText.replaceAll("[^0-9]", "");
                    StringBuilder formatted = new StringBuilder();

                    int index = 0;
                    for (char m : CPF_MASK.toCharArray()) {
                        if (m != '#') {
                            formatted.append(m);
                            continue;
                        }
                        if (index < digitsOnly.length()) {
                            formatted.append(digitsOnly.charAt(index));
                            index++;
                        }
                    }

                    isUpdating = true;
                    editText.setText(formatted.toString());
                    editText.setSelection(formatted.length());
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Não é necessário implementar esta parte
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Não é necessário implementar esta parte
            }
        });
    }
}
