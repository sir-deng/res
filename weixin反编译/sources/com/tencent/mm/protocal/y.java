package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.ats;
import com.tencent.mm.protocal.c.att;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.sc;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;

public final class y {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public byte[] vHK;
        public ats vIE = new ats();

        public final byte[] Hw() {
            int i = -1;
            this.vHZ = ac.cey();
            this.vIE.vSZ = new bes().bl(bi.chc());
            this.vIE.wQE = k.a(this);
            this.vIE.wIg = f.xmQ;
            sc scVar = new sc();
            scVar.wgK = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(scVar.wgK, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            this.vHK = bArr2 != null ? bArr2 : new byte[0];
            String str = "MicroMsg.MMReg2.Req";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(scVar.wgK);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = bi.bx(bArr);
            objArr[5] = bi.bx(bArr2);
            x.d(str, str2, objArr);
            scVar.vQt = new bes().bl(bArr);
            this.vIE.vQx = scVar;
            return this.vIE.toByteArray();
        }

        public final int Hx() {
            return 126;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public byte[] ibg;
        public byte[] vHM;
        public int vHN = 0;
        public att vIF = new att();

        public final int E(byte[] bArr) {
            this.vHN = 0;
            this.vIF = (att) new att().aH(bArr);
            k.a(this, this.vIF.wRa);
            this.vHN = 0;
            return this.vIF.wRa.vQL;
        }

        public final int getCmdId() {
            return 0;
        }

        public final void bg(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.ibg = bArr;
        }
    }
}
