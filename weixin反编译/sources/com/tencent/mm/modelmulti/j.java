package com.tencent.mm.modelmulti;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ou;
import com.tencent.mm.f.a.ow;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.protocal.c.aro;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bhf;
import com.tencent.mm.protocal.c.bhg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class j extends k implements com.tencent.mm.network.k {
    private static final List<Object> hHm = new ArrayList();
    public long frh;
    private b gLB;
    private e gLE;
    private final List<au> hHn = new LinkedList();
    private int hHo = 3;
    private boolean hHp = false;
    private final List<au> hHq = new ArrayList();
    private au hHr = null;
    public com.tencent.mm.plugin.messenger.foundation.a.k hHs = null;

    static /* synthetic */ void a(j jVar, List list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                r((au) list.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    static /* synthetic */ void b(j jVar, List list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                q((au) list.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public j(String str, String str2, int i, int i2, Object obj) {
        x.d("MicroMsg.NetSceneSendMsg", "dktext :%s", bi.chl());
        if (!bi.oN(str)) {
            au auVar = new au();
            auVar.eR(1);
            auVar.dU(str);
            auVar.aq(bb.hU(str));
            auVar.eS(1);
            auVar.setContent(str2);
            auVar.setType(i);
            String a = a(((o) g.h(o.class)).s(auVar), obj, i2);
            if (!bi.oN(a)) {
                auVar.ea(a);
                x.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", auVar.gkD);
            }
            try {
                this.frh = ((h) g.h(h.class)).aZO().b(auVar, true);
                if (this.frh == -1) {
                    d.pVE.a(111, 255, 1, false);
                }
                Assert.assertTrue(this.frh != -1);
                x.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.frh);
            } catch (SQLiteException e) {
                d.pVE.a(111, 255, 1, false);
                throw e;
            }
        }
    }

    public j(String str, String str2, int i) {
        boolean z = false;
        x.d("MicroMsg.NetSceneSendMsg", "dktext :%s", bi.chl());
        if (!bi.oN(str)) {
            au auVar = new au();
            auVar.eR(1);
            auVar.dU(str);
            auVar.aq(bb.hU(str));
            auVar.eS(1);
            auVar.setContent(str2);
            auVar.setType(i);
            String s = ((o) g.h(o.class)).s(auVar);
            if (!bi.oN(s)) {
                auVar.ea(s);
                x.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", auVar.gkD);
            }
            try {
                this.frh = ((h) g.h(h.class)).aZO().b(auVar, true);
                if (this.frh == -1) {
                    d.pVE.a(111, 255, 1, false);
                }
                if (this.frh != -1) {
                    z = true;
                }
                Assert.assertTrue(z);
                x.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.frh);
            } catch (SQLiteException e) {
                d.pVE.a(111, 255, 1, false);
                throw e;
            }
        }
    }

    public j(long j) {
        x.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = " + j);
        this.frh = j;
        this.hHr = ((h) g.h(h.class)).aZO().dI(j);
        if (this.hHr == null) {
            x.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", Long.valueOf(j));
        }
    }

    public j() {
        x.d("MicroMsg.NetSceneSendMsg", "dktext :%s", bi.chl());
        x.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    }

    public final boolean Kj() {
        return true;
    }

    protected final int Bo() {
        return 10;
    }

    public final boolean Kk() {
        boolean Kk = super.Kk();
        if (Kk) {
            d.pVE.a(111, 254, 1, false);
        }
        return Kk;
    }

    protected final int a(q qVar) {
        return this.hHn.size() > 0 ? b.hoz : b.hoA;
    }

    private static String a(String str, Object obj, int i) {
        String str2 = "MicroMsg.NetSceneSendMsg";
        String str3 = "[mergeMsgSource] rawSource:%s args is null:%s flag:%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(obj == null);
        objArr[2] = Integer.valueOf(i);
        x.i(str2, str3, objArr);
        if (!bi.oN(str) && !str.startsWith("<msgsource>")) {
            x.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", str);
            return str;
        } else if (i != JsApiCreateAudioInstance.CTRL_INDEX || !(obj instanceof HashMap)) {
            return str;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            if (bi.oN(str)) {
                stringBuffer.append("<msgsource>");
            }
            for (Entry entry : ((HashMap) obj).entrySet()) {
                str2 = (String) entry.getValue();
                String str4 = (String) entry.getKey();
                if (bi.oN(str2) || bi.oN(str4)) {
                    x.w("MicroMsg.NetSceneSendMsg", "%s %s", str4, str2);
                } else {
                    stringBuffer.append("<").append(str4).append(">");
                    stringBuffer.append(str2);
                    stringBuffer.append("</").append(str4).append(">");
                }
            }
            if (!bi.oN(str)) {
                return str.replace("<msgsource>", "<msgsource>" + stringBuffer.toString());
            }
            stringBuffer.append("</msgsource>");
            return stringBuffer.toString();
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        List aZW;
        this.gLE = eVar2;
        a aVar = new a();
        aVar.hnT = new bhf();
        aVar.hnU = new bhg();
        aVar.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        aVar.hnS = 522;
        aVar.hnV = bd.CTRL_BYTE;
        aVar.hnW = 1000000237;
        this.gLB = aVar.Kf();
        bhf bhf = (bhf) this.gLB.hnQ.hnY;
        if (this.hHr == null) {
            aZW = ((h) g.h(h.class)).aZO().aZW();
        } else {
            if (this.hHr.field_status != 5) {
                x.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", Long.valueOf(this.hHr.field_msgId), Integer.valueOf(this.hHr.field_status));
            }
            this.hHr.eR(1);
            ((h) g.h(h.class)).aZO().a(this.frh, this.hHr);
            List arrayList = new ArrayList();
            arrayList.add(this.hHr);
            this.hHr = null;
            aZW = arrayList;
        }
        if (aZW.size() == 0) {
            x.w("MicroMsg.NetSceneSendMsg", "no sending message");
            return -2;
        }
        this.hHn.clear();
        for (int i = 0; i < aZW.size(); i++) {
            au auVar = (au) aZW.get(i);
            if (auVar.field_isSend == 1) {
                arn arn = new arn();
                arn.vNN = new bet().Vf(auVar.field_talker);
                arn.pgR = (int) (auVar.field_createTime / 1000);
                arn.kzz = auVar.getType();
                arn.noL = auVar.field_content;
                arn.wGf = com.tencent.mm.y.o.k(com.tencent.mm.y.q.FY(), auVar.field_createTime).hashCode();
                if (this.hHs == null) {
                    this.hHs = ((o) g.h(o.class)).Qg();
                }
                x.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", this.hHs);
                this.hHs.a(arn, auVar);
                x.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", arn.vNR);
                bhf.kyB.add(arn);
                bhf.kyA = bhf.kyB.size();
                this.hHn.add(auVar);
            }
        }
        int a = a(eVar, this.gLB, this);
        if (a >= 0) {
            return a;
        }
        x.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", Integer.valueOf(a));
        Qc();
        return a;
    }

    public final int getType() {
        return 522;
    }

    private void ie(int i) {
        if (this.hHn == null) {
            x.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
        } else if (i >= this.hHn.size() || i < 0) {
            x.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", Integer.valueOf(i), Integer.valueOf(this.hHn.size()));
        } else {
            q((au) this.hHn.get(i));
        }
    }

    private static void q(au auVar) {
        com.tencent.mm.sdk.b.b ouVar = new ou();
        ouVar.fHF.fou = auVar;
        com.tencent.mm.sdk.b.a.xmy.m(ouVar);
        x.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", Long.valueOf(auVar.field_msgId));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4;
        if (i2 == 0 && i3 == 0) {
            List list = ((bhg) this.gLB.hnR.hnY).kyB;
            ArrayList arrayList = new ArrayList();
            if (this.hHn.size() == list.size()) {
                i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= list.size()) {
                        x.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", Integer.valueOf(i5 - this.hHq.size()), Integer.valueOf(this.hHq.size()));
                        break;
                    }
                    aro aro = (aro) list.get(i5);
                    if (aro.vQL != 0 || r.igu) {
                        d.pVE.a(111, 252, 1, false);
                        if (aro.vQL == -49 || r.igu) {
                            x.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", Integer.valueOf(aro.vQL), Integer.valueOf(i5), Boolean.valueOf(r.igu), Integer.valueOf(this.hHo));
                            if (this.hHp) {
                                this.hHq.add((au) this.hHn.get(i5));
                            } else if (this.hHo < 0) {
                                if(i5);
                                this.gLE.a(4, aro.vQL, str, this);
                                ie(i5);
                                return;
                            } else {
                                this.hHp = true;
                                this.hHo--;
                                this.hHq.add((au) this.hHn.get(i5));
                                final String str2 = str;
                                g.Dt().F(new Runnable() {
                                    public final void run() {
                                        new al(5, "", "", "", "", false, 1, false).a(j.this.hok, new e() {
                                            public final void a(int i, int i2, String str, k kVar) {
                                                kVar.hop = true;
                                                x.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(j.this.hHq.size()), str, Boolean.valueOf(j.this.hHp), Integer.valueOf(j.this.hHo));
                                                if (i == 0 && i2 == 0) {
                                                    j.this.hHq.clear();
                                                    j.this.lL(str);
                                                } else {
                                                    j.a(j.this, j.this.hHq);
                                                    j.this.gLE.a(4, -49, str2, j.this);
                                                    j.b(j.this, j.this.hHq);
                                                    j.this.hHq.clear();
                                                }
                                                j.this.hHp = false;
                                                r.igu = false;
                                            }
                                        });
                                    }
                                });
                            }
                        } else {
                            if(i5);
                            this.gLE.a(4, aro.vQL, str, this);
                            ie(i5);
                            return;
                        }
                    }
                    long j = ((au) this.hHn.get(i5)).field_msgId;
                    x.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + aro.vNT + " sent successfully!");
                    au dI = ((h) g.h(h.class)).aZO().dI(j);
                    dI.ap(aro.vNT);
                    x.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(aro.vNT), Integer.valueOf(r.ifO));
                    if (CdnLogic.kMediaTypeFavoriteBigFile == r.ifN && r.ifO != 0) {
                        dI.ap((long) r.ifO);
                        r.ifO = 0;
                    }
                    dI.eR(2);
                    ((h) g.h(h.class)).aZO().a(j, dI);
                    if (this.hHn == null) {
                        x.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
                    } else if (i5 >= this.hHn.size() || i5 < 0) {
                        x.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", Integer.valueOf(i5), Integer.valueOf(this.hHn.size()));
                    } else {
                        x.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", Long.valueOf(((au) this.hHn.get(i5)).field_msgId));
                        au dI2 = ((h) g.h(h.class)).aZO().dI(j);
                        com.tencent.mm.sdk.b.b owVar = new ow();
                        owVar.fHH.fou = dI2;
                        com.tencent.mm.sdk.b.a.xmy.m(owVar);
                    }
                    arrayList.add(Integer.valueOf(i5));
                    if (1 == aro.kzz) {
                        d.pVE.a(11942, true, false, Long.valueOf(aro.vNT));
                        d.pVE.a(11945, false, true, Long.valueOf(aro.vNT));
                        d.pVE.a(11946, false, false, Long.valueOf(aro.vNT));
                        d.pVE.a(90, 0, 1, false);
                        d.pVE.a(90, 1, 1, true);
                    }
                    i4 = i5 + 1;
                }
            }
            x.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", Boolean.valueOf(this.hHp));
            if (this.hHp) {
                this.gLE.a(i2, i3, str, this);
                return;
            } else {
                lL(str);
                return;
            }
        }
        d.pVE.a(111, (long) (i2 + 40), 1, true);
        d.pVE.a(111, 253, 1, false);
        x.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        Qc();
        this.gLE.a(i2, i3, str, this);
        for (i4 = 0; i4 < this.hHn.size(); i4++) {
            ie(i4);
        }
        x.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
        lL(str);
    }

    private void lL(String str) {
        x.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
        int a = a(this.hok, this.gLE);
        if (a == -2) {
            this.gLE.a(0, 0, str, this);
        } else if (a < 0) {
            this.gLE.a(3, -1, str, this);
        }
    }

    private void Qc() {
        for (int i = 0; i < this.hHn.size(); i++) {
            if(i);
        }
    }

    private void if(int i) {
        x.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", Long.valueOf(((au) this.hHn.get(i)).field_msgId));
        r(r0);
    }

    private static void r(au auVar) {
        auVar.eR(5);
        d.pVE.a(111, 30, 1, true);
        ((h) g.h(h.class)).aZO().a(auVar.field_msgId, auVar);
        Iterator it = hHm.iterator();
        while (it.hasNext()) {
            it.next();
            String str = auVar.field_talker;
            str = auVar.field_content;
        }
    }
}
