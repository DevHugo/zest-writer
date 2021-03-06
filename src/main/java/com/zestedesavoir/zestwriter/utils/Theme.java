package com.zestedesavoir.zestwriter.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Theme {
    private String filename;
    private String label;

    public static List<Theme> themeAvailable = Arrays.asList(
            new Theme("dark.css", "Dark"),
            new Theme("light.css", "Standard"));

    public Theme(String filename, String label) {
        this.filename = filename;
        this.label = label;
    }

    public String getFilename() {
        return filename;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return getLabel();
    }

    public static Theme getThemeFromFileName(String filename) {
        Optional<Theme> t = themeAvailable.stream().filter(p -> p.getFilename().toString().equals(filename)).findFirst();
        if(t.isPresent()) return t.get();
        return null;
    }
}
