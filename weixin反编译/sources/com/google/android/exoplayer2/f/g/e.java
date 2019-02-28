package com.google.android.exoplayer2.f.g;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;

final class e extends com.google.android.exoplayer2.f.a {
    public final long endTime;
    public final long startTime;

    /* renamed from: com.google.android.exoplayer2.f.g.e$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] azD = new int[Alignment.values().length];

        static {
            try {
                azD[Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                azD[Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                azD[Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static final class a {
        Alignment avT;
        float avU;
        int avV;
        int avW;
        float avX;
        int avY;
        SpannableStringBuilder azE;
        long endTime;
        long startTime;
        float width;

        public a() {
            reset();
        }

        public final void reset() {
            this.startTime = 0;
            this.endTime = 0;
            this.azE = null;
            this.avT = null;
            this.avU = Float.MIN_VALUE;
            this.avV = Integer.MIN_VALUE;
            this.avW = Integer.MIN_VALUE;
            this.avX = Float.MIN_VALUE;
            this.avY = Integer.MIN_VALUE;
            this.width = Float.MIN_VALUE;
        }

        public final e lf() {
            if (this.avX != Float.MIN_VALUE && this.avY == Integer.MIN_VALUE) {
                if (this.avT != null) {
                    switch (AnonymousClass1.azD[this.avT.ordinal()]) {
                        case 1:
                            this.avY = 0;
                            break;
                        case 2:
                            this.avY = 1;
                            break;
                        case 3:
                            this.avY = 2;
                            break;
                        default:
                            new StringBuilder("Unrecognized alignment: ").append(this.avT);
                            this.avY = 0;
                            break;
                    }
                }
                this.avY = Integer.MIN_VALUE;
            }
            return new e(this.startTime, this.endTime, this.azE, this.avT, this.avU, this.avV, this.avW, this.avX, this.avY, this.width);
        }
    }

    public e(CharSequence charSequence) {
        this(charSequence, (byte) 0);
    }

    private e(CharSequence charSequence, byte b) {
        this(0, 0, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public e(long j, long j2, CharSequence charSequence, Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.startTime = j;
        this.endTime = j2;
    }
}
