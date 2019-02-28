package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.j;
import java.util.Arrays;

public interface k {

    public static final class a {
        public final int ahS;
        public final int ahT;
        public final int aiQ;
        public final byte[] aiR;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.aiQ = i;
            this.aiR = bArr;
            this.ahS = i2;
            this.ahT = i3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.aiQ == aVar.aiQ && this.ahS == aVar.ahS && this.ahT == aVar.ahT && Arrays.equals(this.aiR, aVar.aiR)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.aiQ * 31) + Arrays.hashCode(this.aiR)) * 31) + this.ahS) * 31) + this.ahT;
        }
    }

    int a(e eVar, int i, boolean z);

    void a(long j, int i, int i2, int i3, a aVar);

    void a(j jVar, int i);

    void f(Format format);
}
