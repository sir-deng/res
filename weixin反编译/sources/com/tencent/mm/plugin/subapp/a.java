package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.am.d;
import com.tencent.mm.api.f;
import com.tencent.mm.f.a.fg;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.subapp.d.c;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.b;
import com.tencent.mm.pluginsdk.q.z;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements ap {
    static bl saY;
    private Map<String, ap> saZ = new HashMap();
    private a sba;
    private com.tencent.mm.plugin.subapp.d.a sbb;
    private c sbc;

    public static class a extends com.tencent.mm.sdk.b.c<fg> implements e {
        private String fAJ;
        private int fvy;
        private int fvz;
        private boolean iTs;
        private com.tencent.mm.plugin.subapp.ui.voicetranstext.a sbe;
        private com.tencent.mm.plugin.subapp.ui.voicetranstext.c sbf;
        private b sbg;
        private com.tencent.mm.modelvoice.b sbh;
        private p sbi;
        private volatile boolean sbj;
        boolean sbk;
        private al sbl;
        private fg sbm;
        private int sbn;
        private Map<String, String> sbo;
        private int sbp;
        private boolean sbq;
        private long sbr;
        private long sbs;
        private boolean sbt;
        private String toUser;

        private enum a {
            CHECK,
            UPLOAD,
            UPLOAD_MORE,
            GET,
            FINISH,
            ERROR,
            CANCEL,
            CANCEL_BY_USER,
            LOCAL_ERROR,
            SERVER_ERROR,
            NETWORK_OVERTIME
        }

        public a() {
            this.sbj = false;
            this.sbk = false;
            this.sbq = true;
            this.sbr = 0;
            this.sbt = false;
            this.sbo = new HashMap();
            this.xmG = fg.class.getName().hashCode();
        }

        private boolean a(fg fgVar) {
            if (!(fgVar instanceof fg)) {
                x.f("MicroMsg.SubCoreSubapp", "mismatched event");
                return false;
            } else if (fgVar.fvl.fvo == 2) {
                a(a.CANCEL);
                this.sbo.clear();
                x.i("MicroMsg.SubCoreSubapp", "Have clear the cache of the translate voice results.");
                return true;
            } else if (fgVar.fvl.fvo == 1) {
                a(a.CANCEL);
                x.i("MicroMsg.SubCoreSubapp", "Have cancel translate voice action.");
                return true;
            } else if (fgVar.fvl.fvo == 3) {
                a(a.CANCEL_BY_USER);
                x.i("MicroMsg.SubCoreSubapp", "alvinluo Have cancel translate voice action by user.");
                return true;
            } else if (fgVar.fvl.fvo != 0) {
                x.i("MicroMsg.SubCoreSubapp", "The opCode(%d) is out of range.", Integer.valueOf(this.sbm.fvl.fvo));
                return false;
            } else if (this.iTs) {
                x.w("MicroMsg.SubCoreSubapp", "The Event handler is busy.");
                return false;
            } else if (m.UK() == null) {
                x.e("MicroMsg.SubCoreSubapp", "SubCoreVoice.getVoiceStg() == null" + bi.chl());
                return false;
            } else {
                this.sbm = fgVar;
                String str = this.sbm.fvl.fvn;
                String str2 = this.sbm.fvl.fileName;
                if (bi.oN(str) || bi.oN(str2)) {
                    x.e("MicroMsg.SubCoreSubapp", "The localId(%s) is null or fileName(%s) is null.", str, str2);
                    a(a.LOCAL_ERROR);
                    return false;
                }
                bEo();
                String str3 = (String) this.sbo.get(str2);
                if (bi.oN(str3)) {
                    bl Yv = m.UL().Yv(str2);
                    a.saY = Yv;
                    if (Yv == null || bi.oN(a.saY.field_content)) {
                        x.i("MicroMsg.SubCoreSubapp", "alvinluo transform test voice scene: %d", Integer.valueOf(fgVar.fvl.scene));
                        this.sbi = m.UK().oj(str2);
                        try {
                            if (this.sbi == null) {
                                x.i("MicroMsg.SubCoreSubapp", "alvinluo the VoiceInfo do not exist. (localId : %s, fileName : %s)", str, str2);
                                this.sbi = new p();
                                this.sbi.fileName = str2;
                                this.sbi.hXs = System.currentTimeMillis() / 1000;
                                this.sbi.clientId = str2;
                                this.sbi.hXt = System.currentTimeMillis() / 1000;
                                this.sbi.status = 1;
                                if (fgVar.fvl.scene == 8) {
                                    this.sbi.hXw = -1;
                                } else {
                                    this.sbi.hXw = Integer.valueOf(str).intValue();
                                }
                                x.i("MicroMsg.SubCoreSubapp", "size : %d", Integer.valueOf(o.nz(str2)));
                                this.sbi.hmZ = r0;
                            }
                            if (this.sbi.hXw < 0) {
                                x.i("MicroMsg.SubCoreSubapp", "alvinluo voiceInfo msgLocalId < 0");
                            } else {
                                cg dI = ((h) g.h(h.class)).aZO().dI((long) this.sbi.hXw);
                                com.tencent.mm.af.a.c ag;
                                if (dI.field_isSend == 1) {
                                    this.fAJ = q.FY();
                                    if (this.sbm.fvl.scene == 4 || this.sbm.fvl.scene == 5) {
                                        ag = ((f) g.h(f.class)).ag(dI.field_bizChatId);
                                        if (ag != null) {
                                            this.toUser = ag.field_bizChatServId;
                                        } else {
                                            this.toUser = "";
                                        }
                                    } else {
                                        this.toUser = dI.field_talker;
                                    }
                                } else if (dI.field_isSend == 0) {
                                    this.toUser = q.FY();
                                    if (this.sbm.fvl.scene == 4 || this.sbm.fvl.scene == 5) {
                                        ag = ((f) g.h(f.class)).ag(dI.field_bizChatId);
                                        if (ag != null) {
                                            this.fAJ = ag.field_bizChatServId;
                                        } else {
                                            this.fAJ = "";
                                        }
                                    } else {
                                        this.fAJ = dI.field_talker;
                                    }
                                }
                            }
                            this.sbp = this.sbm.fvl.scene;
                            x.d("MicroMsg.SubCoreSubapp", "alvinluo VoiceTransformText fromUser: %s, toUser: %s, scene: %d", this.fAJ, this.toUser, Integer.valueOf(this.sbp));
                            this.sbh = com.tencent.mm.modelvoice.q.nX(this.sbi.fileName);
                            this.iTs = true;
                            this.sbn = 20;
                            a(a.CHECK);
                            return true;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.SubCoreSubapp", e, "alvinluo set voiceInfo exception", new Object[0]);
                            a(a.LOCAL_ERROR);
                            return true;
                        }
                    }
                    x.i("MicroMsg.SubCoreSubapp", "finish With DB localId:%s,fileName:%s", str, str2);
                    a(a.saY.field_content, a.FINISH);
                    return true;
                }
                x.i("MicroMsg.SubCoreSubapp", "finish With Cache localId:%s,fileName:%s", str, str2);
                a(str3, a.FINISH);
                return true;
            }
        }

        private void bEo() {
            this.sbq = true;
            this.sbr = 0;
            this.sbs = 0;
            this.fvy = 0;
            this.fvz = 0;
            this.sbt = false;
        }

        final void a(a aVar) {
            switch (aVar) {
                case CHECK:
                    x.i("MicroMsg.SubCoreSubapp", "net check");
                    if (this.sbi.fGj > 0) {
                        x.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", Long.valueOf(this.sbi.fGj));
                        this.sbe = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.sbi.clientId, this.sbi.hmZ, this.sbh.getFormat(), this.sbi.fGj, this.sbi.fileName, this.sbp, this.fAJ, this.toUser);
                    } else {
                        x.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", Long.valueOf(this.sbi.fGj));
                        this.sbe = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.sbi.clientId, this.sbi.hmZ, this.sbi.fileName, this.sbp, this.fAJ, this.toUser);
                    }
                    as.CN().a(this.sbe, 0);
                    as.CN().a(this.sbe.getType(), (e) this);
                    this.sbs = System.currentTimeMillis();
                    return;
                case UPLOAD:
                    x.i("MicroMsg.SubCoreSubapp", "net upload");
                    if (this.sbe == null) {
                        x.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
                        return;
                    }
                    this.sbf = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.sbi.clientId, this.sbe.sfg, this.sbh.getFormat(), this.sbi.fileName, this.sbp, this.fAJ, this.toUser);
                    as.CN().a(this.sbf, 0);
                    as.CN().a(this.sbf.getType(), (e) this);
                    return;
                case UPLOAD_MORE:
                    x.i("MicroMsg.SubCoreSubapp", "net upload more");
                    if (this.sbf == null) {
                        x.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
                        return;
                    }
                    this.sbf = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.sbf);
                    as.CN().a(this.sbf, 0);
                    as.CN().a(this.sbf.getType(), (e) this);
                    return;
                case GET:
                    if (this.sbj) {
                        x.i("MicroMsg.SubCoreSubapp", "pulling so pass");
                        return;
                    }
                    x.i("MicroMsg.SubCoreSubapp", "net get");
                    if (this.sbe == null) {
                        x.w("MicroMsg.SubCoreSubapp", "request get must after check!");
                        return;
                    }
                    this.sbj = true;
                    this.sbg = new b(this.sbi.clientId);
                    as.CN().a(this.sbg, 0);
                    as.CN().a(this.sbg.getType(), (e) this);
                    return;
                case FINISH:
                    this.sbk = true;
                    return;
                case CANCEL:
                    as.CN().c(this.sbe);
                    as.CN().c(this.sbf);
                    as.CN().c(this.sbg);
                    this.sbt = true;
                    a(null, a.CANCEL);
                    return;
                case LOCAL_ERROR:
                case SERVER_ERROR:
                    this.sbt = true;
                    a(null, aVar);
                    return;
                case NETWORK_OVERTIME:
                    this.sbt = true;
                    a(null, aVar);
                    return;
                default:
                    return;
            }
        }

        private void bEp() {
            if (this.sbq) {
                this.sbq = false;
                this.sbr = System.currentTimeMillis();
                this.fvy = (int) (this.sbr - this.sbs);
            }
        }

        private void a(String str, a aVar) {
            x.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", aVar);
            if (this.sbl != null) {
                this.sbl.TN();
            }
            as.CN().b(546, (e) this);
            as.CN().b(547, (e) this);
            as.CN().b(548, (e) this);
            if (this.sbm != null) {
                if (!bi.oN(str)) {
                    this.sbo.put(this.sbm.fvl.fileName, str);
                    if ((a.saY == null || bi.oN(a.saY.field_content)) && this.sbm.fvl.fqZ == 1) {
                        bm UL = m.UL();
                        x.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", this.sbm.fvl.fvn, this.sbm.fvl.fileName);
                        bl blVar = new bl();
                        blVar.field_msgId = Long.valueOf(this.sbm.fvl.fvn).longValue();
                        blVar.Yu(this.sbm.fvl.fileName);
                        blVar.field_content = str;
                        UL.a(blVar);
                    }
                } else if (aVar == a.FINISH) {
                    x.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", this.sbm.fvl.fvn);
                    this.sbm.fvm.state = 2;
                }
                this.sbm.fvm.aow = true;
                this.sbm.fvm.content = str;
                if (aVar == a.CANCEL) {
                    this.sbm.fvm.state = 1;
                } else if (aVar == a.LOCAL_ERROR || aVar == a.SERVER_ERROR) {
                    this.sbm.fvm.state = 2;
                }
                x.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", str);
                if (this.sbm.fvl.fvp != null) {
                    this.sbm.fvl.fvp.run();
                }
            }
            if (this.sbt && this.sbi != null) {
                int length;
                int i;
                if (str != null) {
                    length = str.length();
                } else {
                    length = 0;
                }
                if (aVar != a.FINISH) {
                    this.fvy = 0;
                    this.fvz = 0;
                    if (aVar == a.CANCEL) {
                        i = 5;
                        length = 0;
                    } else if (aVar == a.SERVER_ERROR) {
                        length = 0;
                        i = 3;
                    } else if (aVar == a.LOCAL_ERROR) {
                        i = 4;
                        length = 0;
                    } else if (aVar == a.NETWORK_OVERTIME) {
                        length = 0;
                        i = 2;
                    } else {
                        length = 0;
                        i = 0;
                    }
                } else if (bi.oN(str)) {
                    this.fvy = 0;
                    this.fvz = 0;
                    length = 0;
                    i = 3;
                } else {
                    i = 1;
                }
                x.i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", this.sbi.clientId, Integer.valueOf(length), Integer.valueOf(this.fvy), Integer.valueOf(this.fvz), Integer.valueOf(i));
                if (i != 0) {
                    com.tencent.mm.plugin.subapp.d.b.b(this.sbi.clientId, length, this.fvy, this.fvz, i);
                }
            }
            this.sbe = null;
            this.sbf = null;
            this.sbg = null;
            this.sbm = null;
            this.iTs = false;
            this.sbk = false;
            this.sbj = false;
            this.sbn = 20;
            a.saY = null;
            bEo();
        }

        public final void a(int i, int i2, String str, k kVar) {
            String str2 = null;
            x.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                int i3;
                switch (kVar.getType()) {
                    case 546:
                        if (this.sbe.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.sfe) {
                            x.i("MicroMsg.SubCoreSubapp", "check result: done");
                            a(a.FINISH);
                            bEp();
                            this.fvz = 0;
                            this.sbt = true;
                            if (this.sbe.bEU()) {
                                str2 = this.sbe.sff.xcd;
                            }
                            a(str2, a.FINISH);
                            return;
                        } else if (this.sbe.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.sfd) {
                            if (this.sbe.sff != null) {
                                bi.oN(this.sbe.sff.xcd);
                            }
                            x.i("MicroMsg.SubCoreSubapp", "check result: processing");
                            a(a.GET);
                            return;
                        } else if (this.sbe.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.sfc) {
                            x.i("MicroMsg.SubCoreSubapp", "check result: not exist");
                            a(a.UPLOAD);
                            return;
                        } else if (this.sbe.sfh != null) {
                            i3 = this.sbe.sfh.wOD;
                            return;
                        } else {
                            return;
                        }
                    case 547:
                        if (this.sbf.bEW()) {
                            x.i("MicroMsg.SubCoreSubapp", "succeed upload");
                            a(a.GET);
                            return;
                        }
                        x.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", Integer.valueOf(this.sbf.sfg.vPt), Integer.valueOf(this.sbf.sfg.vPu));
                        a(a.UPLOAD_MORE);
                        return;
                    case 548:
                        final int i4 = this.sbg.sfj;
                        x.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", Integer.valueOf(i4));
                        this.sbj = false;
                        bEp();
                        if (!this.sbg.isComplete() && this.sbg.bEU()) {
                            x.i("MicroMsg.SubCoreSubapp", "refreshResult result");
                            String str3 = this.sbg.sff.xcd;
                            if (this.sbm != null) {
                                this.sbm.fvm.aow = false;
                                this.sbm.fvm.content = str3;
                                x.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", Boolean.valueOf(bi.oN(str3)));
                                if (this.sbm.fvl.fvp != null) {
                                    this.sbm.fvl.fvp.run();
                                }
                            }
                        } else if (!this.sbg.bEU()) {
                            x.d("MicroMsg.SubCoreSubapp", "result not valid");
                        }
                        if (this.sbg.isComplete()) {
                            x.i("MicroMsg.SubCoreSubapp", "succeed get");
                            if (this.sbg.bEU()) {
                                str2 = this.sbg.sff.xcd;
                            }
                            a(a.FINISH);
                            this.fvz = (int) (System.currentTimeMillis() - this.sbr);
                            this.sbt = true;
                            a(str2, a.FINISH);
                            return;
                        }
                        x.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", Integer.valueOf(i4));
                        if (!this.sbk) {
                            i3 = this.sbn - 1;
                            this.sbn = i3;
                            if (i3 < 0) {
                                x.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", Integer.valueOf(20));
                                a(a.SERVER_ERROR);
                                return;
                            }
                            if (this.sbl == null) {
                                this.sbl = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                                    public final boolean uG() {
                                        if (!a.this.sbk) {
                                            x.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", Integer.valueOf(i4));
                                            a.this.a(a.GET);
                                        }
                                        return false;
                                    }
                                }, false);
                            }
                            long j = (long) (i4 * 1000);
                            this.sbl.K(j, j);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else if (i == 2) {
                a(a.NETWORK_OVERTIME);
            } else {
                a(a.SERVER_ERROR);
            }
        }
    }

    public a() {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
        Map hashMap = new HashMap();
        hashMap.put(d.class.getName(), new d());
        hashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
        hashMap.put(com.tencent.mm.plugin.subapp.a.c.class.getName(), new com.tencent.mm.plugin.subapp.a.c());
        ak.f dVar = new com.tencent.mm.plugin.subapp.c.d();
        com.tencent.mm.y.ak.a.hhy = dVar;
        hashMap.put(com.tencent.mm.plugin.subapp.c.d.class.getName(), dVar);
        com.tencent.mm.pluginsdk.q.k cVar = new com.tencent.mm.plugin.subapp.jdbiz.c();
        hashMap.put(com.tencent.mm.plugin.subapp.jdbiz.c.class.getName(), cVar);
        z.vjl = cVar;
        hashMap.put(com.tencent.mm.modelmulti.p.class.getName(), new com.tencent.mm.modelmulti.p());
        this.saZ = hashMap;
    }

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, com.tencent.mm.bx.h.d> Bu() {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
        HashMap<Integer, com.tencent.mm.bx.h.d> hashMap = new HashMap();
        for (Entry entry : this.saZ.entrySet()) {
            if (((ap) entry.getValue()).Bu() != null) {
                hashMap.putAll(((ap) entry.getValue()).Bu());
            }
        }
        return hashMap;
    }

    public final void ge(int i) {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
        for (Entry value : this.saZ.entrySet()) {
            ((ap) value.getValue()).ge(i);
        }
    }

    public final void bs(boolean z) {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
        for (Entry value : this.saZ.entrySet()) {
            ((ap) value.getValue()).bs(z);
        }
        if (this.sba == null) {
            this.sba = new a();
        }
        if (this.sbb == null) {
            this.sbb = new com.tencent.mm.plugin.subapp.d.a();
        }
        if (this.sbc == null) {
            this.sbc = new c();
        }
        com.tencent.mm.sdk.b.a.xmy.b(this.sba);
        com.tencent.mm.sdk.b.a.xmy.b(this.sbc);
        com.tencent.mm.sdk.b.a.xmy.b(this.sbb);
    }

    public final void bt(boolean z) {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
        for (Entry value : this.saZ.entrySet()) {
            ((ap) value.getValue()).bt(z);
        }
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
        for (Entry value : this.saZ.entrySet()) {
            ((ap) value.getValue()).onAccountRelease();
        }
        if (this.sba != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.sba);
        }
        if (this.sbb != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.sbb);
        }
        if (this.sbc != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.sbc);
        }
    }

    public final ap MN(String str) {
        return (ap) this.saZ.get(str);
    }

    public final void b(String str, ap apVar) {
        this.saZ.put(str, apVar);
    }
}
