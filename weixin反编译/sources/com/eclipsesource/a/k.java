package com.eclipsesource.a;

import java.io.Writer;

public final class k extends l {
    private final char[] acb;

    private static class a extends i {
        private final char[] acb;
        private int acc;

        /* synthetic */ a(Writer writer, char[] cArr, byte b) {
            this(writer, cArr);
        }

        private a(Writer writer, char[] cArr) {
            super(writer);
            this.acb = cArr;
        }

        protected final void hE() {
            this.acc++;
            this.aca.write(91);
            hL();
        }

        protected final void hF() {
            this.acc--;
            hL();
            this.aca.write(93);
        }

        protected final void hG() {
            this.aca.write(44);
            if (!hL()) {
                this.aca.write(32);
            }
        }

        protected final void hH() {
            this.acc++;
            this.aca.write(123);
            hL();
        }

        protected final void hI() {
            this.acc--;
            hL();
            this.aca.write(125);
        }

        protected final void hJ() {
            this.aca.write(58);
            this.aca.write(32);
        }

        protected final void hK() {
            this.aca.write(44);
            if (!hL()) {
                this.aca.write(32);
            }
        }

        private boolean hL() {
            int i = 0;
            if (this.acb == null) {
                return false;
            }
            this.aca.write(10);
            while (i < this.acc) {
                this.aca.write(this.acb);
                i++;
            }
            return true;
        }
    }

    k(char[] cArr) {
        this.acb = cArr;
    }

    protected final i a(Writer writer) {
        return new a(writer, this.acb, (byte) 0);
    }
}
