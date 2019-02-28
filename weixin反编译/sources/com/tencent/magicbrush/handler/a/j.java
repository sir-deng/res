package com.tencent.magicbrush.handler.a;

import android.graphics.Typeface;

public final class j {
    public float azb = 14.0f;
    public Typeface boj = null;
    public boolean bok = false;
    public a bol;
    public float strokeWidth = 0.0f;

    public enum a {
        NORMAL(0),
        BOLD(1),
        ITALIC(2),
        BOLD_ITALIC(3);
        
        int boq;

        private a(int i) {
            this.boq = i;
        }

        public static a f(boolean z, boolean z2) {
            if (z && z2) {
                return BOLD_ITALIC;
            }
            if (z) {
                return ITALIC;
            }
            if (z2) {
                return BOLD;
            }
            return NORMAL;
        }
    }

    j(a aVar) {
        this.bol = aVar;
    }

    public final String toString() {
        return "MBFontStyle[" + this.azb + "][" + this.strokeWidth + "]";
    }
}
