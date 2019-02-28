package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.b.a.e;
import com.google.android.exoplayer2.source.l;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

final class c {
    byte[] aiR;
    byte[] asT;
    final f asW;
    final f asX;
    final k asY;
    final com.google.android.exoplayer2.source.b.a.a.a[] asZ;
    final e ata;
    final l atb;
    final List<Format> atc;
    boolean atd;
    byte[] ate;
    IOException atf;
    com.google.android.exoplayer2.source.b.a.a.a atg;
    boolean ath;
    Uri ati;
    String atj;
    com.google.android.exoplayer2.g.e atk;

    private static final class a extends com.google.android.exoplayer2.source.a.c {
        public final String atl;
        byte[] atm;

        public a(f fVar, i iVar, Format format, int i, Object obj, byte[] bArr, String str) {
            super(fVar, iVar, format, i, obj, bArr);
            this.atl = str;
        }

        protected final void d(byte[] bArr, int i) {
            this.atm = Arrays.copyOf(bArr, i);
        }
    }

    public static final class b {
        public com.google.android.exoplayer2.source.a.a atn;
        public boolean ato;
        public com.google.android.exoplayer2.source.b.a.a.a atp;

        public b() {
            clear();
        }

        public final void clear() {
            this.atn = null;
            this.ato = false;
            this.atp = null;
        }
    }

    private static final class c extends com.google.android.exoplayer2.g.a {
        private int atq;

        public c(l lVar, int[] iArr) {
            int i = 0;
            super(lVar, iArr);
            Format format = lVar.arZ[0];
            while (i < this.length) {
                if (this.arZ[i] == format) {
                    break;
                }
                i++;
            }
            i = -1;
            this.atq = i;
        }

        public final void kv() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (g(this.atq, elapsedRealtime)) {
                int i = this.length - 1;
                while (i >= 0) {
                    if (g(i, elapsedRealtime)) {
                        i--;
                    } else {
                        this.atq = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        public final int kw() {
            return this.atq;
        }

        public final int kx() {
            return 0;
        }

        public final Object ky() {
            return null;
        }
    }

    public c(e eVar, com.google.android.exoplayer2.source.b.a.a.a[] aVarArr, d dVar, k kVar, List<Format> list) {
        this.ata = eVar;
        this.asZ = aVarArr;
        this.asY = kVar;
        this.atc = list;
        Format[] formatArr = new Format[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            formatArr[i] = aVarArr[i].aeo;
            iArr[i] = i;
        }
        this.asW = dVar.ku();
        this.asX = dVar.ku();
        this.atb = new l(formatArr);
        this.atk = new c(this.atb, iArr);
    }

    final void a(Uri uri, String str, byte[] bArr) {
        String substring;
        if (t.ai(str).startsWith("0x")) {
            substring = str.substring(2);
        } else {
            substring = str;
        }
        Object toByteArray = new BigInteger(substring, 16).toByteArray();
        Object obj = new byte[16];
        int length = toByteArray.length > 16 ? toByteArray.length - 16 : 0;
        System.arraycopy(toByteArray, length, obj, (16 - toByteArray.length) + length, toByteArray.length - length);
        this.ati = uri;
        this.aiR = bArr;
        this.atj = str;
        this.asT = obj;
    }
}
