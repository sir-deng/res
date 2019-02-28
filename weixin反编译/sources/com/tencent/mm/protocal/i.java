package com.tencent.mm.protocal;

import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.bea;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.protocal.c.sc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;

public final class i {

    public interface c {

        public static class a {
            public static c vHH;
        }

        int Hs();

        void a(f fVar, g gVar, int i, int i2, String str);

        q aW(int i, int i2);
    }

    public static abstract class f extends com.tencent.mm.protocal.k.d implements com.tencent.mm.protocal.k.b {
        public byte[] vHK;

        public abstract String getUri();

        public final void bf(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.vHK = bArr;
        }
    }

    public static abstract class g extends com.tencent.mm.protocal.k.e implements com.tencent.mm.protocal.k.c {
        public byte[] ibg;
        public String ibj;
        public bqo vHL = new bqo();
        public byte[] vHM;
        public int vHN = 0;

        public final void bg(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.ibg = bArr;
        }
    }

    public static class a extends f implements com.tencent.mm.protocal.k.b {
        public String username;
        public ek vHG = new ek();

        public final byte[] Hw() {
            int i;
            int i2 = -1;
            com.tencent.mm.kernel.a.fH("");
            if (this.vHV == 12) {
                i = 1;
            } else {
                com.tencent.mm.kernel.g.Dr();
                i = com.tencent.mm.kernel.g.Dq().gRO.DE(46);
            }
            x.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r3), Integer.valueOf(i));
            this.vHZ = ac.cey();
            if (10002 == r.ifN && r.ifO > 0) {
                r.ifO = 0;
                ac.H("", "", 0);
            }
            bea bea = this.vHG.vQv;
            bea.wQE = k.a(this);
            x.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf[%d]", Integer.valueOf(this.vHR));
            bea.viU = com.tencent.mm.compatible.e.q.yL();
            bea.vQo = com.tencent.mm.plugin.normsg.a.d.oXY.up(i);
            bea.vQp = 0;
            bea.vQq = com.tencent.mm.kernel.a.CI();
            bea.hxh = bi.fb(ad.getContext());
            bea.kyK = d.vHj;
            bea.vQr = be.ckL();
            bea.lTZ = w.cfV();
            bea.lTY = bi.che();
            bea.vKK = com.tencent.mm.sdk.platformtools.f.fei;
            com.tencent.mm.kernel.g.Dr();
            x.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", (String) com.tencent.mm.kernel.g.Dq().gRO.get(18), Integer.valueOf(bea.vQn.vRL));
            bea.vQn.vRJ.vTx = new bes().bl(bi.Wj(r0));
            el elVar = this.vHG.vQu;
            sc scVar = new sc();
            scVar.wgK = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(scVar.wgK, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            bf(bArr2);
            String str = "MicroMsg.AutoReq";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(scVar.wgK);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = bi.bx(bArr);
            objArr[5] = bi.bx(bArr2);
            x.d(str, str2, objArr);
            scVar.vQt = new bes().bl(bArr);
            elVar.vQx = scVar;
            x.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", bea.viU, bea.vQo, bea.vQq, bea.hxh, bea.kyK, bea.vQr, bea.lTZ, bea.lTY, Integer.valueOf(bea.vKK), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fei), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.xmQ));
            try {
                return this.vHG.toByteArray();
            } catch (Throwable e) {
                x.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", bi.i(e));
                return null;
            }
        }

        public final int Hx() {
            return 702;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/autoauth";
        }
    }

    public static class b extends g implements com.tencent.mm.protocal.k.c {
        public final int E(byte[] bArr) {
            try {
                this.vHL = (bqo) this.vHL.aH(bArr);
                k.a(this, this.vHL.wRa);
                this.vHN = 0;
                if (this.vHL.wRa.vQL == 0 && (this.vHL.wZl == null || this.vHL.wZl.lTO == 0 || bi.by(n.a(this.vHL.wZl.vPQ)))) {
                    x.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.vHL.wRa.vQL = -1;
                }
                x.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", this.vId);
                com.tencent.mm.kernel.a.fH(r0);
                return this.vHL.wRa.vQL;
            } catch (Throwable e) {
                x.e("MicroMsg.MMAuth", "toProtoBuf :%s", bi.i(e));
                this.vHL.wRa.vQL = -1;
                return -1;
            }
        }
    }

    public static class d extends f implements com.tencent.mm.protocal.k.b {
        public aqr vHI = new aqr();
        public boolean vHJ = false;

        public final byte[] Hw() {
            int i;
            int i2 = -1;
            com.tencent.mm.kernel.a.fH("");
            if (this.vHV == 16) {
                i = 1;
            } else if (this.vHJ) {
                i = 3;
            } else {
                com.tencent.mm.kernel.g.Dr();
                i = com.tencent.mm.kernel.g.Dq().gRO.DE(46);
            }
            x.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r4), Integer.valueOf(i));
            if (10002 == r.ifN && r.ifO > 0) {
                r.ifO = 0;
                ac.H("", "", 0);
            }
            this.vHZ = ac.cey();
            bea bea = this.vHI.wEk;
            bea.wQE = k.a(this);
            bea.viU = com.tencent.mm.compatible.e.q.yL();
            bea.vQo = com.tencent.mm.plugin.normsg.a.d.oXY.up(i);
            bea.vQp = 0;
            bea.vQq = com.tencent.mm.kernel.a.CI();
            bea.hxh = bi.fb(ad.getContext());
            bea.kyK = d.vHj;
            bea.vQr = be.ckL();
            bea.lTZ = w.cfV();
            bea.lTY = bi.che();
            bea.vKK = com.tencent.mm.sdk.platformtools.f.fei;
            if (10012 == r.ifN && r.ifO > 0) {
                bea.vKK = r.ifO;
            }
            bea.vUX = d.vHe;
            bea.vUW = d.vHf;
            bea.wEf = d.vHg;
            bea.wgM = com.tencent.mm.compatible.e.q.getSimCountryIso();
            com.tencent.mm.kernel.g.Dr();
            x.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", (String) com.tencent.mm.kernel.g.Dq().gRO.get(18), Integer.valueOf(bea.vQn.vRL));
            bea.vQn.vRJ.vTx = new bes().bl(bi.Wj(r0));
            aqs aqs = this.vHI.wEj;
            aqs.vSZ = new bes().bl(bi.chc());
            sc scVar = new sc();
            scVar.wgK = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(scVar.wgK, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            bf(bArr2);
            String str = "MicroMsg.ManualReq";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(scVar.wgK);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = bi.bx(bArr);
            objArr[5] = bi.bx(bArr2);
            x.d(str, str2, objArr);
            scVar.vQt = new bes().bl(bArr);
            aqs.vQx = scVar;
            x.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", bea.viU, bea.vQo, bea.vQq, bea.hxh, bea.kyK, bea.vQr, bea.lTZ, bea.lTY, Integer.valueOf(bea.vKK), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.fei), Integer.valueOf(com.tencent.mm.sdk.platformtools.f.xmQ), bea.vUX, bea.vUW, bea.wEf, bea.wgM);
            try {
                return this.vHI.toByteArray();
            } catch (Throwable e) {
                x.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", bi.i(e));
                return null;
            }
        }

        public final int Hx() {
            return 701;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/manualauth";
        }
    }

    public static class e extends g implements com.tencent.mm.protocal.k.c {
        public final int E(byte[] bArr) {
            try {
                this.vHL = (bqo) this.vHL.aH(bArr);
                k.a(this, this.vHL.wRa);
                this.vHN = 0;
                if (this.vHL.wRa.vQL == 0 && (this.vHL.wZl == null || this.vHL.wZl.lTO == 0 || bi.by(n.a(this.vHL.wZl.vPQ)))) {
                    x.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.vHL.wRa.vQL = -1;
                }
                x.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", this.vId);
                com.tencent.mm.kernel.a.fH(r0);
                return this.vHL.wRa.vQL;
            } catch (Throwable e) {
                x.e("MicroMsg.MMAuth", "toProtoBuf :%s", bi.i(e));
                this.vHL.wRa.vQL = -1;
                return -1;
            }
        }
    }
}
