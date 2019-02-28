package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static boolean hNJ = false;
    private static AtomicInteger hQC = new AtomicInteger(0);
    public StringBuffer hQA = new StringBuffer();
    public StringBuffer hQB = new StringBuffer();
    public Object hQs = null;
    public int hQt = 1;
    public long hQu;
    public int hQv;
    public int hQw;
    public int hQx;
    public StringBuffer hQy = new StringBuffer();
    public StringBuffer hQz = new StringBuffer();
    public int opType = 0;

    static /* synthetic */ void a(b bVar) {
        d dVar = new d();
        dVar.q("\n\nmodel", bVar.hQt + ",");
        dVar.q("opType", bVar.opType + ",");
        dVar.q("timeStamp", bVar.hQu + ",");
        dVar.q("seq", bVar.hQv + ",");
        dVar.q("netWork", bVar.hQw + ",");
        dVar.q("page", bVar.hQx + ",");
        dVar.q("StatusDesc1", bVar.hQy.toString() + ",");
        dVar.q("DataFlowSourceInfo", bVar.hQz.toString() + ",");
        dVar.q("DataFlowResultInfo", bVar.hQA.toString() + ",");
        dVar.q("StatusDesc2", bVar.hQB.toString() + ", ");
        dVar.hQG.append("bindkey: " + bVar.hQs);
        x.d("MicroMsg.StatisticsOplog", "report logbuffer: " + dVar.SG());
        d.pVE.h(12645, dVar);
    }

    public static b ix(int i) {
        return new b(i, 1);
    }

    public static b iy(int i) {
        return new b(i, 4);
    }

    public final boolean SA() {
        int i = c.hQE;
        if (i == 0) {
            return false;
        }
        if (i == 1) {
            if (this.opType >= HardCoderJNI.SCENE_DB && this.opType <= 700) {
                return true;
            }
            if (this.opType >= 701 && this.opType <= 1000) {
                return true;
            }
        }
        if (i == 2 && this.opType >= 701 && this.opType <= 1000) {
            return true;
        }
        if (i == 3 && this.opType >= HardCoderJNI.SCENE_DB && this.opType <= 700) {
            return true;
        }
        if (i == 4) {
            if (this.opType >= 701 && this.opType <= 1000) {
                return true;
            }
            if (this.opType >= HardCoderJNI.SCENE_DB && this.opType <= 700) {
                return true;
            }
        }
        return false;
    }

    public b(int i, int i2) {
        this.opType = i;
        this.hQx = i2;
        if (SA()) {
            this.hQu = System.currentTimeMillis();
            if (ao.isWifi(ad.getContext())) {
                this.hQw = 4;
            } else if (ao.is4G(ad.getContext())) {
                this.hQw = 3;
            } else if (ao.is3G(ad.getContext())) {
                this.hQw = 2;
            } else if (ao.is2G(ad.getContext())) {
                this.hQw = 1;
            } else {
                this.hQw = 0;
            }
            this.hQv = hQC.incrementAndGet();
        }
    }

    public final boolean iz(int i) {
        this.hQs = Integer.valueOf(i);
        return true;
    }

    public final void update() {
        if (SA()) {
            this.hQu = System.currentTimeMillis();
            this.hQv = hQC.incrementAndGet();
        }
    }

    public final b mF(String str) {
        if (SA()) {
            if (this.hQy.length() != 0) {
                this.hQy.append("||" + str);
            } else if (bi.oN(str)) {
                this.hQy.append(" ");
            } else {
                this.hQy.append(str);
            }
        }
        return this;
    }

    public final b iA(int i) {
        return mF(String.valueOf(i));
    }

    public final b mG(String str) {
        if (SA()) {
            if (this.hQz.length() == 0) {
                this.hQz.append(str);
            } else {
                this.hQz.append("||" + str);
            }
        }
        return this;
    }

    public final b SB() {
        this.hQz = new StringBuffer();
        return this;
    }

    public final b SC() {
        this.hQy = new StringBuffer();
        return this;
    }

    public final b mH(String str) {
        if (SA()) {
            if (this.hQA.length() == 0) {
                this.hQA.append(str);
            } else {
                this.hQA.append("||" + str);
            }
        }
        return this;
    }

    public final b bW(boolean z) {
        return mF(z ? "1" : "0");
    }

    public final b iB(int i) {
        if (SA()) {
            if (this.hQz.length() == 0) {
                this.hQz.append(i);
            } else {
                this.hQz.append("||" + i);
            }
        }
        return this;
    }

    public static void SD() {
        x.i("MicroMsg.StatisticsOplog", "wait op");
    }

    public final boolean SE() {
        if (!SA()) {
            return false;
        }
        e.post(new Runnable() {
            public final void run() {
                b.a(b.this);
            }
        }, "StatisticsOplog");
        return true;
    }

    public final byte[] KH() {
        bna bna = new bna();
        bna.opType = this.opType;
        bna.hQx = this.hQx;
        bna.hQt = this.hQt;
        bna.hQu = this.hQu;
        bna.hQv = this.hQv;
        bna.hQw = this.hQw;
        bna.wWX = this.hQy.toString();
        bna.wWY = this.hQB.toString();
        bna.wWZ = this.hQz.toString();
        bna.wXa = this.hQA.toString();
        try {
            return bna.toByteArray();
        } catch (Exception e) {
            x.e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            return null;
        }
    }

    public final void b(Intent intent, String str) {
        byte[] KH = KH();
        if (KH != null) {
            intent.putExtra(str, KH);
        }
    }

    public static b m(Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("intent_key_StatisticsOplog");
        return byteArray == null ? null : J(byteArray);
    }

    public static b q(Intent intent) {
        return c(intent, "intent_key_StatisticsOplog");
    }

    public static b c(Intent intent, String str) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return J(byteArrayExtra);
    }

    private static b J(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        bna bna = new bna();
        try {
            bna.aH(bArr);
            b bVar = new b(bna.opType, bna.hQx);
            bVar.hQt = bna.hQt;
            bVar.hQu = bna.hQu;
            bVar.hQv = bna.hQv;
            bVar.hQw = bna.hQw;
            bVar.hQy = new StringBuffer(bna.wWX);
            bVar.hQB = new StringBuffer(bna.wWY);
            bVar.hQz = new StringBuffer(bna.wWZ);
            bVar.hQA = new StringBuffer(bna.wXa);
            return bVar;
        } catch (Exception e) {
            x.e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            return null;
        }
    }
}
