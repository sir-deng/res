package com.tencent.mm.protocal;

import com.tencent.mm.ad.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.nr;
import com.tencent.mm.protocal.c.ns;
import com.tencent.mm.protocal.c.sy;
import com.tencent.mm.protocal.c.sz;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class q {

    public static class b extends e implements c {
        public final ns vIt = new ns();

        public final int E(byte[] bArr) {
            this.vIt.aH(bArr);
            return this.vIt.wRa.vQL;
        }
    }

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public final sz vIq = new sz();

        public a() {
            eE(0);
            this.vIq.wij = new sy();
            this.vIq.wij.wih = new nr();
            this.vIq.wii = new ta();
        }

        public final byte[] Hw() {
            this.vHZ = ac.cey();
            this.vIq.wij.wQE = k.a(this);
            this.vIq.wii.vSZ = new bes().bl(bi.chc());
            this.vHY = this.vIq.wii.vSZ.wRm.toByteArray();
            this.vHX = new com.tencent.mm.protocal.k.a() {
                public final boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2) {
                    long j;
                    com.tencent.mm.protocal.k.b bVar = (com.tencent.mm.protocal.k.b) this;
                    long j2 = (long) this.vHR;
                    if (com.tencent.mm.sdk.a.b.cfx() && j2 == 0) {
                        j = d.vHk;
                    } else {
                        j = j2;
                    }
                    ac acVar = this.vHZ;
                    if (i == 722) {
                        x.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
                        sz szVar = ((a) this).vIq;
                        byte[][] a = r.a(j, szVar.wii, szVar.wij);
                        if (a == null) {
                            return false;
                        }
                        byte[] bArr3 = a[0];
                        byte[] bArr4 = a[1];
                        if (MMProtocalJni.packHybrid(pByteArray, bArr, this.vHU, (int) j, bVar.Hx(), acVar.ver, bArr3, bArr4, acVar.vIK.getBytes(), acVar.vIL.getBytes(), this.vHY, i2)) {
                            x.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i2));
                            return true;
                        }
                    }
                    return false;
                }
            };
            return this.vIq.toByteArray();
        }

        public final int Hx() {
            return 722;
        }
    }
}
