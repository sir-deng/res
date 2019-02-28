package com.tencent.tinker.c.a.a.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.a.AnonymousClass1;
import com.tencent.tinker.c.a.c.a.AnonymousClass2;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public final class h extends i<com.tencent.tinker.a.a.h> {
    private a Aqc = null;
    private e Aqd = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cHq();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.h hVar = (com.tencent.tinker.a.a.h) comparable;
        int[] iArr = hVar.Aoc;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = aVar.IV(iArr[i]);
        }
        byte[] bArr = hVar.Aod;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        com.tencent.tinker.a.a.b.a anonymousClass1 = new AnonymousClass1(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + WXMediaMessage.TITLE_LENGTH_LIMIT);
        b anonymousClass2 = new AnonymousClass2(byteArrayOutputStream);
        while (true) {
            int read = byteArrayInputStream.read() & 255;
            byteArrayOutputStream.write(read);
            switch (read) {
                case 0:
                    return new com.tencent.tinker.a.a.h(hVar.dzH, hVar.Aob, iArr2, byteArrayOutputStream.toByteArray());
                case 1:
                    o.a(anonymousClass2, o.b(anonymousClass1));
                    break;
                case 2:
                    o.c(anonymousClass2, o.a(anonymousClass1));
                    break;
                case 3:
                case 4:
                    o.a(anonymousClass2, o.b(anonymousClass1));
                    o.b(anonymousClass2, aVar.IV(o.c(anonymousClass1)));
                    o.b(anonymousClass2, aVar.IW(o.c(anonymousClass1)));
                    if (read != 4) {
                        break;
                    }
                    o.b(anonymousClass2, aVar.IV(o.c(anonymousClass1)));
                    break;
                case 5:
                case 6:
                    o.a(anonymousClass2, o.b(anonymousClass1));
                    break;
                case 9:
                    o.b(anonymousClass2, aVar.IV(o.c(anonymousClass1)));
                    break;
                default:
                    break;
            }
        }
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.h hVar = (com.tencent.tinker.a.a.h) comparable;
        a aVar = this.Aqc;
        aVar.size++;
        return this.Aqd.a(hVar);
    }

    public h(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.Aqc = iVar2.Aof.AoO;
            this.Aqd = iVar2.a(this.Aqc);
        }
    }

    protected final a c(i iVar) {
        return iVar.Aof.AoO;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.Ari.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.Arw.IS(i2);
        }
    }
}
