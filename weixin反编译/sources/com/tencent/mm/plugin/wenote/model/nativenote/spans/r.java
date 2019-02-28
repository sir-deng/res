package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;

public final class r implements ParagraphStyle {
    public final q ubV;
    public final ParagraphStyle ucC;

    public r(q qVar, ParagraphStyle paragraphStyle) {
        this.ubV = qVar;
        this.ucC = paragraphStyle;
    }

    public final String toString() {
        return this.ubV.name() + " - " + this.ucC.getClass().getSimpleName();
    }
}
