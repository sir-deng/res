package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.protocal.c.oi;
import com.tencent.mm.protocal.c.oj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;

public final class e extends k implements com.tencent.mm.network.k {
    int fDM = 0;
    private boolean fnH = false;
    private b gLB;
    private com.tencent.mm.ad.e gLE;
    private oi pVU = null;
    private a pVV = new a();

    public e(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("data must not be null");
        }
        this.fDM = i;
        g.Do();
        this.fnH = a.CE();
        if (i == 1) {
            try {
                i iVar = new i();
                iVar.aH(bArr);
                this.pVU = SmcProtoBufUtil.toMMReportKvReq(iVar);
            } catch (Exception e) {
                x.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                g.Dr();
                g.Dt().F(new Runnable() {
                    public final void run() {
                        SmcLogic.OnReportResp(3, -1, null, e.this.fDM);
                    }
                });
            }
        } else if (i == 2) {
            try {
                com.tencent.mm.protocal.a.a.g gVar = new com.tencent.mm.protocal.a.a.g();
                gVar.aH(bArr);
                this.pVU = SmcProtoBufUtil.toMMReportIdkeyReq(gVar);
            } catch (Exception e2) {
                x.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                g.Dr();
                g.Dt().F(new Runnable() {
                    public final void run() {
                        SmcLogic.OnReportResp(3, -1, null, e.this.fDM);
                    }
                });
            }
        }
        if (this.pVU != null) {
            this.pVU.wdU = new akp();
            this.pVU.wdU.wyx = this.pVV.vP(this.fDM);
            return;
        }
        x.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", bi.chl());
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (g.Dp().gRu == null || g.Dp().gRu.hoF == null) {
            x.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.gLE.a(i2, i3, str, this);
        } else if (i2 != 0) {
            x.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnReportResp(i2, i3, null, this.fDM);
            this.gLE.a(i2, i3, str, this);
        } else {
            x.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.fDM);
            oj ojVar = (oj) this.gLB.hnR.hnY;
            this.pVV.a(ojVar.wee, this.fDM);
            try {
                if (this.fDM == 1) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(ojVar).toByteArray(), this.fDM);
                } else if (this.fDM == 2) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(ojVar).toByteArray(), this.fDM);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bi.i(e));
            }
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return !this.fnH ? 1 == this.fDM ? TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR : 987 : 1 == this.fDM ? TbsLog.TBSLOG_CODE_SDK_SELF_MODE : 986;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        if (this.pVU == null) {
            x.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
            return -2;
        }
        if (!this.fnH) {
            this.pVU.wdT = com.tencent.mm.bp.b.be(bi.chc());
        }
        b.a aVar = new b.a();
        aVar.hnX = false;
        aVar.hnT = this.pVU;
        aVar.hnU = new oj();
        String str = 1 == this.fDM ? "/cgi-bin/micromsg-bin/newreportkvcomm" : "/cgi-bin/micromsg-bin/newreportidkey";
        String str2 = 1 == this.fDM ? "/cgi-bin/micromsg-bin/newreportkvcommrsa" : "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        if (!this.fnH) {
            str = str2;
        }
        aVar.uri = str;
        aVar.hnS = getType();
        this.gLB = aVar.Kf();
        if (!this.fnH) {
            this.gLB.a(ac.cez());
            this.gLB.fKU = 1;
        }
        int a = a(eVar, this.gLB, this);
        if (a >= 0) {
            return a;
        }
        x.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", Integer.valueOf(a));
        try {
            SmcLogic.OnReportResp(3, -1, null, this.fDM);
            return a;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bi.i(e));
            return a;
        }
    }
}
