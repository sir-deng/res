package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.l;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.o;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public abstract class a {

    /* renamed from: com.tencent.tinker.c.a.c.a$1 */
    class AnonymousClass1 implements com.tencent.tinker.a.a.b.a {
        final /* synthetic */ ByteArrayInputStream AqQ;

        public AnonymousClass1(ByteArrayInputStream byteArrayInputStream) {
            this.AqQ = byteArrayInputStream;
        }

        public final byte readByte() {
            return (byte) (this.AqQ.read() & 255);
        }
    }

    /* renamed from: com.tencent.tinker.c.a.c.a$4 */
    class AnonymousClass4 implements b {
        final /* synthetic */ ByteArrayOutputStream AqS;

        public AnonymousClass4(ByteArrayOutputStream byteArrayOutputStream) {
            this.AqS = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.AqS.write(i);
        }
    }

    private final class a {
        private final b AqT;

        public a(b bVar) {
            this.AqT = bVar;
        }

        private void a(m mVar) {
            int i = 0;
            switch (mVar.cHx()) {
                case 0:
                    l.a(this.AqT, 0, (long) mVar.readByte());
                    return;
                case 2:
                    l.a(this.AqT, 2, (long) mVar.readShort());
                    return;
                case 3:
                    l.b(this.AqT, 3, (long) mVar.readChar());
                    return;
                case 4:
                    l.a(this.AqT, 4, (long) mVar.readInt());
                    return;
                case 6:
                    l.a(this.AqT, 6, mVar.readLong());
                    return;
                case 16:
                    l.c(this.AqT, 16, ((long) Float.floatToIntBits(mVar.readFloat())) << 32);
                    return;
                case 17:
                    l.c(this.AqT, 17, Double.doubleToLongBits(mVar.readDouble()));
                    return;
                case 23:
                    l.b(this.AqT, 23, (long) a.this.IV(mVar.cHB()));
                    return;
                case 24:
                    l.b(this.AqT, 24, (long) a.this.IW(mVar.cHC()));
                    return;
                case 25:
                    l.b(this.AqT, 25, (long) a.this.IY(mVar.cHD()));
                    return;
                case 26:
                    l.b(this.AqT, 26, (long) a.this.IZ(mVar.cHF()));
                    return;
                case 27:
                    l.b(this.AqT, 27, (long) a.this.IY(mVar.cHE()));
                    return;
                case 28:
                    fR(28, 0);
                    c(mVar);
                    return;
                case 29:
                    fR(29, 0);
                    b(mVar);
                    return;
                case 30:
                    mVar.cHG();
                    fR(30, 0);
                    return;
                case 31:
                    if (mVar.readBoolean()) {
                        i = 1;
                    }
                    fR(31, i);
                    return;
                default:
                    throw new j("Unexpected type: " + Integer.toHexString(mVar.cHx()));
            }
        }

        public final void b(m mVar) {
            int cHz = mVar.cHz();
            o.a(this.AqT, a.this.IW(mVar.Aos));
            o.a(this.AqT, cHz);
            for (int i = 0; i < cHz; i++) {
                o.a(this.AqT, a.this.IV(mVar.cHA()));
                a(mVar);
            }
        }

        public final void c(m mVar) {
            int cHy = mVar.cHy();
            o.a(this.AqT, cHy);
            for (int i = 0; i < cHy; i++) {
                a(mVar);
            }
        }

        private void fR(int i, int i2) {
            this.AqT.writeByte((i2 << 5) | i);
        }
    }

    /* renamed from: com.tencent.tinker.c.a.c.a$3 */
    class AnonymousClass3 implements b {
        final /* synthetic */ ByteArrayOutputStream AqS;

        public AnonymousClass3(ByteArrayOutputStream byteArrayOutputStream) {
            this.AqS = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.AqS.write(i);
        }
    }

    /* renamed from: com.tencent.tinker.c.a.c.a$2 */
    class AnonymousClass2 implements b {
        final /* synthetic */ ByteArrayOutputStream Apg;

        public AnonymousClass2(ByteArrayOutputStream byteArrayOutputStream) {
            this.Apg = byteArrayOutputStream;
        }

        public final void writeByte(int i) {
            this.Apg.write(i);
        }
    }

    public abstract int IV(int i);

    public abstract int IW(int i);

    public abstract int IX(int i);

    public abstract int IY(int i);

    public abstract int IZ(int i);

    public abstract int Ja(int i);

    public abstract int Jb(int i);

    public abstract int Jc(int i);

    public abstract int Jd(int i);

    public abstract int Je(int i);

    public abstract int Jf(int i);

    public abstract int Jg(int i);

    public abstract int Jh(int i);

    public abstract int Ji(int i);

    public final com.tencent.tinker.a.a.e.a[] b(com.tencent.tinker.a.a.e.a[] aVarArr) {
        com.tencent.tinker.a.a.e.a[] aVarArr2 = new com.tencent.tinker.a.a.e.a[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            com.tencent.tinker.a.a.e.a aVar = aVarArr[i];
            aVarArr2[i] = new com.tencent.tinker.a.a.e.a(IY(aVar.AnD), aVar.AnE);
        }
        return aVarArr2;
    }

    public final e.b[] b(e.b[] bVarArr) {
        e.b[] bVarArr2 = new e.b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            e.b bVar = bVarArr[i];
            bVarArr2[i] = new e.b(IZ(bVar.AnF), bVar.AnE, Ji(bVar.AnG));
        }
        return bVarArr2;
    }
}
