package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    int fGt;
    int mBg;
    int nZY;
    int ozA;
    boolean ozB;
    boolean ozC;
    byte[] ozs;
    byte[] ozt;
    int ozu = 0;
    int ozv = 0;
    long ozw = bi.Wz();
    int ozx;
    int ozy;
    int ozz;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.a.b$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a ozD;

        AnonymousClass1(a aVar) {
            this.ozD = aVar;
        }

        public final void run() {
            b bVar = b.this;
            x.i("MicroMsg.FrameBufProcessor", "process srcWidth %d srcHeight %d targetWidth %d targetHeight %d bufIndex: %d", Integer.valueOf(bVar.ozx), Integer.valueOf(bVar.ozy), Integer.valueOf(bVar.nZY), Integer.valueOf(bVar.mBg), Integer.valueOf(bVar.ozv));
            if (bVar.ozz == 21 || bVar.ozz == 2130706688) {
                SightVideoJNI.NV21ToYUV420XXAndScaleRotate(bVar.ozs, bVar.ozt, bVar.ozx, bVar.ozy, bVar.nZY, bVar.mBg, 1, bVar.fGt, bVar.ozA, bVar.ozC, bVar.ozB);
            } else if (bVar.ozz == 19) {
                SightVideoJNI.NV21ToYUV420XXAndScaleRotate(bVar.ozs, bVar.ozt, bVar.ozx, bVar.ozy, bVar.nZY, bVar.mBg, 2, bVar.fGt, bVar.ozA, bVar.ozC, bVar.ozB);
            }
            x.v("MicroMsg.FrameBufProcessor", "process used %sms %d %d bufIndex %d", Long.valueOf(bi.bB(bVar.ozw)), Integer.valueOf(bVar.ozs.length), Integer.valueOf(bVar.ozt.length), Integer.valueOf(bVar.ozv));
            this.ozD.a(b.this);
            j.oAr.D(b.this.ozs);
        }
    }

    public interface a {
        void a(b bVar);
    }

    public b(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6, byte[] bArr) {
        this.ozz = i3;
        this.nZY = i4;
        this.mBg = i5;
        this.ozx = i;
        this.ozy = i2;
        this.ozC = z2;
        this.ozB = z;
        this.fGt = i6;
        this.ozs = bArr;
        this.ozu = bArr.length;
        this.ozt = j.oAr.h(Integer.valueOf(((i4 * i5) * 3) / 2));
    }
}
