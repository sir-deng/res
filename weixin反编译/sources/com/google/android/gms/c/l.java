package com.google.android.gms.c;

import android.graphics.drawable.Drawable;
import java.util.Arrays;

public final class l extends o<a, Drawable> {

    public static final class a {
        public final int aXy;
        public final int aXz;

        public a(int i, int i2) {
            this.aXy = i;
            this.aXz = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            return aVar.aXy == this.aXy && aVar.aXz == this.aXz;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Integer.valueOf(this.aXy), Integer.valueOf(this.aXz)});
        }
    }
}
