package com.tencent.mm.plugin.remittance.a;

import android.text.TextUtils;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.mo;
import com.tencent.mm.f.a.tg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.remittance.model.aa;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.bt;
import com.tencent.mm.y.p;
import com.tencent.mm.y.q;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class b implements ap {
    private static HashMap<Integer, d> gyG;
    private a hkl = new a() {
        public final void a(String str, l lVar) {
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                int i;
                c fp = com.tencent.mm.y.c.c.IL().fp("100324");
                if (fp.isValid() && "1".equals(fp.civ().get("open"))) {
                    i = 1;
                } else {
                    i = 0;
                }
                t Db = g.Dq().Db();
                Db.a(w.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(i));
                x.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", Integer.valueOf(i), Integer.valueOf(((Integer) Db.get(w.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0))).intValue()));
                if (((Integer) Db.get(w.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0))).intValue() == 0) {
                    com.tencent.mm.r.c.Bx().b(w.a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, true);
                    Db.a(w.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(1));
                    g.Dq().Db().a(w.a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.valueOf(false));
                }
            }
        }
    };
    private bt.a lTH = new bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            x.i("MicroMsg.SubCoreRemittance", "hy: received AddMsg");
            bx bxVar = aVar.hoa;
            if (bxVar == null) {
                x.e("MicroMsg.SubCoreRemittance", "recieve a null msg");
                return;
            }
            String a = n.a(bxVar.vNO);
            if (bi.oN(a)) {
                x.e("MicroMsg.SubCoreRemittance", "msg illegal,content is null");
                return;
            }
            Map y = bj.y(a, "sysmsg");
            if (y == null) {
                x.e("MicroMsg.SubCoreRemittance", "Resolve msg error");
                return;
            }
            a = (String) y.get(".sysmsg.paymsg.PayMsgType");
            String str;
            if ("15".equals(a)) {
                String decode = URLDecoder.decode((String) y.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    x.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                    return;
                }
                Map y2 = bj.y(decode, "msg");
                if (y2 == null) {
                    x.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                    return;
                }
                a = (String) y2.get(".msg.appmsg.wcpayinfo.transferid");
                if (bi.oN(a)) {
                    x.e("MicroMsg.SubCoreRemittance", "paymsgid is null");
                } else if (b.this.bnV().IV(a)) {
                    x.e("MicroMsg.SubCoreRemittance", "it is a duplicate msg");
                } else {
                    str = (String) y.get(".sysmsg.paymsg.tousername");
                    if (bi.oN(decode) || bi.oN(str)) {
                        x.e("MicroMsg.SubCoreRemittance", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                    } else {
                        b.this.bnV().Q(a, decode, str);
                    }
                }
            } else if ("22".equals(a)) {
                a = (String) y.get(".sysmsg.paymsg.tousername");
                str = (String) y.get(".sysmsg.paymsg.fromusername");
                try {
                    String decode2 = URLDecoder.decode((String) y.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                    if (bi.oN(decode2)) {
                        x.e("MicroMsg.SubCoreRemittance", "appmsgcontent is null");
                        return;
                    }
                    Map y3 = bj.y(decode2, "msg");
                    if (y3 == null) {
                        x.e("MicroMsg.SubCoreRemittance", "Resolve appmsgcontent error");
                        return;
                    }
                    String str2 = (String) y3.get(".msg.appmsg.wcpayinfo.transferid");
                    int i = bi.getInt((String) y3.get(".msg.appmsg.wcpayinfo.paysubtype"), -1);
                    x.i("MicroMsg.SubCoreRemittance", "receive delay transfer newxml, fromusername: %s, tousername: %s, transferId: %s, paysubtype: %d", str, a, str2, Integer.valueOf(i));
                    com.tencent.mm.sdk.e.c cVar = null;
                    try {
                        b.bnS();
                        cVar = b.bnT().IT(str2);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SubCoreRemittance", e, "", new Object[0]);
                    }
                    if (cVar == null) {
                        x.i("MicroMsg.SubCoreRemittance", "empty record");
                        return;
                    }
                    au dI = ((h) g.h(h.class)).aZO().dI(cVar.field_msgId);
                    if (dI.field_msgId <= 0) {
                        x.i("MicroMsg.SubCoreRemittance", "has delete msg");
                        b.bnS();
                        b.bnT().a(cVar, new String[0]);
                        return;
                    }
                    x.i("MicroMsg.SubCoreRemittance", "update msg: %s", Long.valueOf(dI.field_msgId));
                    dI.setContent(decode2);
                    ((h) g.h(h.class)).aZO().a(dI.field_msgId, dI);
                    com.tencent.mm.plugin.remittance.b.c IU = b.bnU().IU(str2);
                    if (IU != null) {
                        IU.field_receiveStatus = i;
                        b.bnU().a(IU);
                    } else if (!dI.field_talker.equals(q.FY())) {
                        IU = new com.tencent.mm.plugin.remittance.b.c();
                        IU.field_locaMsgId = dI.field_msgId;
                        IU.field_transferId = str2;
                        IU.field_receiveStatus = i;
                        IU.field_isSend = false;
                        b.bnU().a(IU);
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.SubCoreRemittance", e2, "", new Object[0]);
                }
            } else if ("33".equals(a)) {
                int i2 = bi.getInt((String) y.get(".sysmsg.paymsg.opentransferbankcard"), 0);
                t Db = g.Dq().Db();
                Db.a(w.a.USERINFO_WALLET_BANK_REMIT_OPEN_INT_SYNC, Integer.valueOf(i2));
                x.i("MicroMsg.SubCoreRemittance", "receive open bank remit: %s, %s", Integer.valueOf(i2), Integer.valueOf(((Integer) Db.get(w.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0))).intValue()));
                if (((Integer) Db.get(w.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(0))).intValue() == 0) {
                    com.tencent.mm.r.c.Bx().b(w.a.NEW_BANDAGE_DATASOURCE_BANK_REMIT_STRING_SYNC, true);
                    Db.a(w.a.USERINFO_WALLET_BANK_REMIT_HAS_SHOWN_RED_DOT_INT_SYNC, Integer.valueOf(1));
                    g.Dq().Db().a(w.a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.valueOf(false));
                }
            }
        }
    };
    private aa pMF = null;
    public com.tencent.mm.plugin.remittance.b.b pMG = null;
    private com.tencent.mm.plugin.remittance.b.d pMH = null;
    private com.tencent.mm.sdk.b.c<mo> pMI = new com.tencent.mm.sdk.b.c<mo>() {
        {
            this.xmG = mo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            mo moVar = (mo) bVar;
            x.i("MicroMsg.SubCoreRemittance", "do insert delay transfer record: %s, %s", Long.valueOf(moVar.fFm.frh), moVar.fFm.fFn);
            if (moVar.fFm.fFo != null) {
                if (moVar.fFm.fFo.hdO == 5) {
                    com.tencent.mm.sdk.e.c aVar = new com.tencent.mm.plugin.remittance.b.a();
                    aVar.field_msgId = moVar.fFm.frh;
                    aVar.field_transferId = moVar.fFm.fFn;
                    b.bnS();
                    b.bnT().b(aVar);
                }
                com.tencent.mm.plugin.remittance.b.c IU = b.bnU().IU(moVar.fFm.fFn);
                if (IU != null) {
                    IU.field_receiveStatus = moVar.fFm.fFo.hdO;
                    b.bnU().a(IU);
                } else if (!((h) g.h(h.class)).aZO().dI(moVar.fFm.frh).field_talker.equals(q.FY())) {
                    IU = new com.tencent.mm.plugin.remittance.b.c();
                    IU.field_locaMsgId = moVar.fFm.frh;
                    IU.field_transferId = moVar.fFm.fFo.hdR;
                    IU.field_receiveStatus = moVar.fFm.fFo.hdO;
                    IU.field_isSend = false;
                    b.bnU().a(IU);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<tg> pMJ = new com.tencent.mm.sdk.b.c<tg>() {
        {
            this.xmG = tg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.plugin.remittance.b.c IU;
            tg tgVar = (tg) bVar;
            com.tencent.mm.plugin.remittance.b.d bnU = b.bnU();
            String str = tgVar.fMA.fFn;
            if (bi.oN(str) || !com.tencent.mm.plugin.remittance.b.d.ijA.containsKey(str)) {
                IU = bnU.IU(str);
                if (IU != null) {
                    com.tencent.mm.plugin.remittance.b.d.ijA.put(str, IU);
                } else {
                    IU = null;
                }
            } else {
                IU = (com.tencent.mm.plugin.remittance.b.c) com.tencent.mm.plugin.remittance.b.d.ijA.get(str);
            }
            if (IU != null) {
                tgVar.fMB.status = IU.field_receiveStatus;
                tgVar.fMB.fMC = IU.field_isSend;
            } else {
                tgVar.fMB.status = -2;
                tgVar.fMB.fMC = false;
            }
            return false;
        }
    };

    static {
        com.tencent.mm.wallet_core.a.i("RemittanceProcess", a.class);
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.remittance.b.b.gLy;
            }
        });
        gyG.put(Integer.valueOf("RemittanceRecord".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.remittance.b.d.gLy;
            }
        });
    }

    public static b bnS() {
        return (b) p.s(b.class);
    }

    public static com.tencent.mm.plugin.remittance.b.b bnT() {
        if (bnS().pMG == null) {
            b bnS = bnS();
            g.Dr();
            bnS.pMG = new com.tencent.mm.plugin.remittance.b.b(g.Dq().gRU);
        }
        return bnS().pMG;
    }

    public static com.tencent.mm.plugin.remittance.b.d bnU() {
        if (bnS().pMH == null) {
            b bnS = bnS();
            g.Dr();
            bnS.pMH = new com.tencent.mm.plugin.remittance.b.d(g.Dq().gRU);
        }
        return bnS().pMH;
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public final void bs(boolean z) {
        if (this.pMF != null) {
            aa aaVar = this.pMF;
            synchronized (aaVar.lock) {
                aaVar.pRs = new HashSet();
                aaVar.pRt.clear();
            }
        }
        com.tencent.mm.y.c.c.IL().c(this.hkl);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("paymsg", this.lTH, true);
        com.tencent.mm.sdk.b.a.xmy.a(this.pMI);
        com.tencent.mm.sdk.b.a.xmy.a(this.pMJ);
    }

    public final void onAccountRelease() {
        com.tencent.mm.y.c.c.IL().j(this.hkl);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("paymsg", this.lTH, true);
        com.tencent.mm.sdk.b.a.xmy.c(this.pMI);
        com.tencent.mm.sdk.b.a.xmy.c(this.pMJ);
    }

    public final aa bnV() {
        if (this.pMF == null) {
            this.pMF = new aa();
        }
        return this.pMF;
    }
}
