package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;

public enum q {
    NONE("", "", "", "", false),
    NOTEUL("<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true),
    NOTEOL("<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true),
    NOTETODO("", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    
    public boolean ucA;
    public String ucu;
    public String ucv;
    public boolean ucw;
    public String ucx;
    public String ucy;
    public boolean ucz;

    public static q a(ParagraphStyle paragraphStyle) {
        if (paragraphStyle instanceof d) {
            return NOTEUL;
        }
        if (paragraphStyle instanceof m) {
            return NOTEOL;
        }
        return paragraphStyle instanceof k ? NOTETODO : null;
    }

    private q(String str, String str2, String str3, String str4, boolean z) {
        this.ucA = false;
        this.ucu = str;
        this.ucv = str2;
        this.ucx = str3;
        this.ucy = str4;
        this.ucw = false;
        this.ucz = z;
    }

    public final boolean bYn() {
        return this == NOTEUL;
    }

    public final boolean bYo() {
        return this == NOTEOL;
    }

    public final boolean bYp() {
        return this == NOTETODO;
    }
}
