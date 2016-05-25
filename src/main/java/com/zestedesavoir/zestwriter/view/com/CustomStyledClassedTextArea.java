package com.zestedesavoir.zestwriter.view.com;

import java.text.BreakIterator;

import org.fxmisc.richtext.StyleClassedTextArea;

import javafx.scene.input.KeyCode;

public class CustomStyledClassedTextArea extends StyleClassedTextArea{



    public CustomStyledClassedTextArea() {
        super(true);
        setWrapText(true);
        /*
        setOnKeyReleased(t -> {
            if(t.getCode() == KeyCode.ENTER) {
                System.out.println("Fin du scroll");
            }
        });*/
    }

    @Override
    public void previousWord(org.fxmisc.richtext.NavigationActions.SelectionPolicy selectionPolicy) {
        if(getLength() == 0) {
            return;
        }

        BreakIterator wordBreakIterator = BreakIterator.getWordInstance();
        wordBreakIterator.setText(getText());
        wordBreakIterator.preceding(getCaretPosition());

        moveTo(wordBreakIterator.current(), selectionPolicy);
    }

    @Override
    public void nextWord(org.fxmisc.richtext.NavigationActions.SelectionPolicy selectionPolicy) {
        if(getLength() == 0) {
            return;
        }

        BreakIterator wordBreakIterator = BreakIterator.getWordInstance();
        wordBreakIterator.setText(getText());
        wordBreakIterator.following(getCaretPosition());

        moveTo(wordBreakIterator.current(), selectionPolicy);
    }



}
