package com.project.utils;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

public class TextManager {

    public static String getText(String text) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("text", Locale.getDefault());
        return new String(resourceBundle.getString(text).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }
}
