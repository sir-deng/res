package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import java.util.Collections;
import java.util.List;

public interface u {

    public static final class a {
        public final String ael;
        public final byte[] apf;
        public final int type;

        public a(String str, int i, byte[] bArr) {
            this.ael = str;
            this.type = i;
            this.apf = bArr;
        }
    }

    public static final class b {
        public final String ael;
        public final List<a> apg;
        public final byte[] aph;
        public final int streamType;

        public b(int i, String str, List<a> list, byte[] bArr) {
            List emptyList;
            this.streamType = i;
            this.ael = str;
            if (list == null) {
                emptyList = Collections.emptyList();
            } else {
                emptyList = Collections.unmodifiableList(list);
            }
            this.apg = emptyList;
            this.aph = bArr;
        }
    }

    public static final class d {
        private String amW;
        private final String api;
        private final int apj;
        private final int apk;
        private int apl;

        public d() {
            this(Integer.MIN_VALUE, 0, 1);
        }

        public d(int i, int i2, int i3) {
            this.api = i != Integer.MIN_VALUE ? i + "/" : "";
            this.apj = i2;
            this.apk = i3;
            this.apl = Integer.MIN_VALUE;
        }

        public final void jG() {
            this.apl = this.apl == Integer.MIN_VALUE ? this.apj : this.apl + this.apk;
            this.amW = this.api + this.apl;
        }

        public final int jH() {
            jJ();
            return this.apl;
        }

        public final String jI() {
            jJ();
            return this.amW;
        }

        private void jJ() {
            if (this.apl == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }
    }

    public interface c {
        u a(int i, b bVar);

        SparseArray<u> jB();
    }

    void a(j jVar, boolean z);

    void a(q qVar, f fVar, d dVar);

    void jy();
}
