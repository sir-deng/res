package com.tencent.mm.ad;

import android.os.Looper;
import com.tencent.mm.f.a.hd;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bbn;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bgt;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends com.tencent.mm.protocal.h.a {
    private static a hpu;
    private e hps;
    private byte[] hpt;
    private int type;

    public interface a {
        void cC(String str);
    }

    public static void a(a aVar) {
        hpu = aVar;
    }

    public t(e eVar, int i) {
        this.hps = eVar;
        this.type = i;
    }

    public final boolean a(int i, byte[] bArr, byte[] bArr2) {
        PByteArray pByteArray = new PByteArray();
        if (this.hps instanceof c) {
            PByteArray pByteArray2 = new PByteArray();
            PInt pInt = new PInt(0);
            c cVar = (c) this.hps;
            PInt pInt2 = new PInt(0);
            PInt pInt3 = new PInt(0);
            PInt pInt4 = new PInt(255);
            try {
                if (cVar.cev()) {
                    int E = cVar.E(bArr);
                    x.d("MicroMsg.RemoteResp", "rawData using protobuf ok");
                    this.hps.vIb = E;
                    if (!bi.oN(r.ifQ)) {
                        this.hps.vId = r.ifQ;
                    }
                    return true;
                }
                x.i("MicroMsg.RemoteResp", "bufToResp unpack ret[%b], jType[%d], noticeid[%d], headExtFlags[%d]", Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4)), Integer.valueOf(i), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value));
                b hdVar;
                boolean m;
                if (MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4)) {
                    this.hps.vIc = pInt4.value;
                    if (i != 701 && i != 702 && 10001 == r.ifN && r.ifO > 0) {
                        if (r.ifO == 2) {
                            ac.H("", "", 0);
                        }
                        r.ifO = 0;
                        pInt.value = -13;
                        x.w("MicroMsg.RemoteResp", "dkcert dktest set session timeout once !");
                    }
                    if (pInt.value == -13 || pInt.value == -102 || pInt.value == -3001 || pInt.value == -3002 || pInt.value == -3003) {
                        this.hps.vIb = pInt.value;
                        if (pInt.value == -3002) {
                            try {
                                this.hps.vId = new String(pByteArray2.value);
                            } catch (Exception e) {
                                x.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                            }
                            x.i("MicroMsg.RemoteResp", "jType [%d], ret value[%d], noticeId[%s], msg[%s]", Integer.valueOf(i), Integer.valueOf(pInt.value), pInt3, this.hps.vId);
                        }
                    } else {
                        x.i("MicroMsg.RemoteResp", "bufToResp using protobuf ok jType:%d, enType:%d errCode:%d, len:%d, headExtFlags:%d", Integer.valueOf(i), Integer.valueOf(pInt2.value), Integer.valueOf(cVar.E(pByteArray2.value)), Integer.valueOf(pByteArray2.value.length), Integer.valueOf(this.hps.vIc));
                        this.hps.vIb = r1;
                    }
                    this.hps.vIa = (long) bArr.length;
                    this.hpt = pByteArray.value;
                    if (!bi.oN(r.ifQ)) {
                        this.hps.vId = r.ifQ;
                    }
                    if (pInt3.value != 0) {
                        hdVar = new hd();
                        hdVar.fyh.fyi = pInt3.value;
                        if (i == 701 && this.hps.vIb == 0) {
                            x.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent MMFunc_ManualAuth ok [%d]", Integer.valueOf(pInt3.value));
                            hdVar.fyh.fyj = true;
                        }
                        m = com.tencent.mm.sdk.b.a.xmy.m(hdVar);
                        x.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                        pInt3.value = 0;
                    }
                    return true;
                }
                x.e("MicroMsg.RemoteResp", "unpack return false jType[%d]", Integer.valueOf(i));
                if (pInt3.value != 0) {
                    hdVar = new hd();
                    hdVar.fyh.fyi = pInt3.value;
                    m = com.tencent.mm.sdk.b.a.xmy.m(hdVar);
                    x.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                    pInt3.value = 0;
                }
                return false;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.RemoteResp", e2, "from Protobuf unbuild exception, check now!", new Object[0]);
                x.e("MicroMsg.RemoteResp", "exception:%s", bi.i(e2));
            }
        } else {
            x.f("MicroMsg.RemoteResp", "all protocal should implemented with protobuf");
            return false;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, PInt pInt, bek bek) {
        PByteArray pByteArray = new PByteArray();
        pInt.value = -1;
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt2 = new PInt(0);
        PInt pInt3 = new PInt(0);
        try {
            x.i("MicroMsg.RemoteResp", "bufToRespNoRSA unpack ret[%b], noticeid[%d], headExtFlags[%d]", Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, new PInt(255))), Integer.valueOf(pInt3.value), Integer.valueOf(r7.value));
            if (pInt3.value != 0) {
                b hdVar = new hd();
                hdVar.fyh.fyi = pInt3.value;
                boolean m = com.tencent.mm.sdk.b.a.xmy.m(hdVar);
                x.i("MicroMsg.RemoteResp", "summerdiz bufToRespNoRSA publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
            }
            if (!r1) {
                x.e("MicroMsg.RemoteResp", "unpack failed.");
                return null;
            } else if (pInt.value == -13 || pInt.value == -102 || pInt.value == -3001) {
                x.e("MicroMsg.RemoteResp", "unpack failed. error:%d", Integer.valueOf(pInt.value));
                return null;
            } else if (pInt.value == -3002) {
                try {
                    final String str = new String(pByteArray2.value);
                    x.i("MicroMsg.RemoteResp", "bufToRespNoRSA -3002 ERR_IDCDISASTER, errStr:%s", str);
                    new ag(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            if (!bi.oN(str) && t.hpu != null) {
                                t.hpu.cC(str);
                            }
                        }
                    });
                    return null;
                } catch (Exception e) {
                    x.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                }
            } else {
                x.i("MicroMsg.RemoteResp", "fuckwifi bufToRespNoRSA using protobuf ok jtype:%d enType:%d ", Integer.valueOf(110), Integer.valueOf(pInt2.value));
                bek.aH(pByteArray2.value);
                return pByteArray2.value;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.RemoteResp", e2, "parseFrom unbuild exception, check now!", new Object[0]);
            x.e("MicroMsg.RemoteResp", "exception:%s", bi.i(e2));
        }
    }

    public final byte[] Ky() {
        return this.hpt;
    }

    public final int KR() {
        return this.hps.vIc;
    }

    public final String KS() {
        return this.hps.vId;
    }

    public final void jy(String str) {
        this.hps.vId = str;
    }

    public final int KT() {
        return this.hps.vIb;
    }

    public final void hp(int i) {
        this.hps.vIb = i;
    }

    public final byte[] CM() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                return ((y.b) this.hps).ibg;
            case 701:
            case 702:
                return ((g) this.hps).ibg;
            default:
                return bArr;
        }
    }

    public final byte[] KU() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                bgt bgt = ((y.b) this.hps).vIF.wIy;
                if (bgt == null || bgt.vPR == null) {
                    x.d("MicroMsg.RemoteResp", "summerauth MMFunc_NewReg SecAuthRegKeySect is null");
                    break;
                }
                return bgt.vPR.wRm.toByteArray();
            case 701:
            case 702:
                if (((g) this.hps).vHL.wZl.vPR != null) {
                    return ((g) this.hps).vHL.wZl.vPR.wRm.toByteArray();
                }
                break;
        }
        return bArr;
    }

    public final byte[] KA() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                return ((y.b) this.hps).vHM;
            case 701:
            case 702:
                return ((g) this.hps).vHM;
            default:
                return bArr;
        }
    }

    public final String KV() {
        if (this.type == 381) {
            bbn bbn = ((com.tencent.mm.protocal.r.b) this.hps).vIv.wqE;
            if (bbn != null) {
                return bi.oM(bbn.wOH);
            }
        }
        return "";
    }

    public final String KW() {
        if (this.type == 381) {
            bbn bbn = ((com.tencent.mm.protocal.r.b) this.hps).vIv.wqE;
            if (bbn != null) {
                return bi.oM(bbn.wOG);
            }
        }
        return "";
    }

    public final int KX() {
        if (this.type == 381) {
            return ((com.tencent.mm.protocal.r.b) this.hps).vIv.wpN;
        }
        return 0;
    }

    public final int Cn() {
        switch (this.type) {
            case 126:
                return ((y.b) this.hps).vIF.lTO;
            case 701:
            case 702:
                return ((g) this.hps).vHL.wZl.lTO;
            default:
                return 0;
        }
    }

    public final String KY() {
        switch (this.type) {
            case 126:
                return ((y.b) this.hps).vIF.kyG;
            case 701:
            case 702:
                return ((g) this.hps).ibj;
            default:
                return "";
        }
    }

    public final int getCmdId() {
        return this.hps.getCmdId();
    }
}
