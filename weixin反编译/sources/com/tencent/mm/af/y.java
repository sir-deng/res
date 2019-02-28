package com.tencent.mm.af;

import com.tencent.mm.ad.d.c;
import com.tencent.mm.af.a.b;
import com.tencent.mm.af.a.g;
import com.tencent.mm.af.a.h;
import com.tencent.mm.af.a.i;
import com.tencent.mm.af.a.k;
import com.tencent.mm.af.m.a;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.bt;
import com.tencent.mm.y.e;
import com.tencent.mm.y.p;
import com.tencent.mm.y.s;
import java.util.HashMap;
import java.util.Map;

public class y implements ap {
    private static HashMap<Integer, d> gyG;
    private static long hrR = 0;
    private e hhI = new e();
    private e hrS;
    private a hrT = null;
    private k hrU = null;
    private i hrV;
    private h hrW = null;
    private com.tencent.mm.af.a.d hrX = null;
    private b hrY = null;
    private k hrZ = null;
    private g hsa = null;
    private i hsb = null;
    private h hsc = null;
    private c hsd = null;
    private a hse;
    private bt.a hsf = new bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            bx bxVar = aVar.hoa;
            if (bxVar == null) {
                x.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
                return;
            }
            String a = n.a(bxVar.vNO);
            if (bi.oN(a)) {
                x.e("MicroMsg.SubCoreBiz", "msg content is null");
                return;
            }
            Map y = bj.y(a, "sysmsg");
            if (y == null || y.size() <= 0) {
                x.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
                return;
            }
            if ("mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String) y.get(".sysmsg.$type"))) {
                x.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", Integer.valueOf(bi.getInt((String) y.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0)));
                com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT, Integer.valueOf(r0));
                com.tencent.mm.kernel.g.Dq().Db().lO(true);
                return;
            }
            x.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
        }
    };
    private as.a hsg = new as.a() {
        public final void a(ae aeVar, as asVar) {
            if (aeVar != null && !bi.oN(aeVar.field_username)) {
                String str = aeVar.field_username;
                com.tencent.mm.storage.x Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(str);
                if (Xv != null && Xv.ciN() && !s.gU(str)) {
                    d jN = y.Ml().jN(str);
                    if (jN.xrR == -1) {
                        x.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
                    } else if (jN.Ll()) {
                        if (jN.bK(false) == null) {
                            aeVar.dJ(null);
                            x.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                        } else if (jN.bK(false).LM() == null) {
                            aeVar.dJ(null);
                            x.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                        } else if (jN.Lm()) {
                            aeVar.dJ(null);
                        } else {
                            aeVar.dJ(bi.oM(jN.Ls()));
                            if (bi.oN(jN.Ls())) {
                                x.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", aeVar.field_username);
                            }
                        }
                    } else if (jN.Lh() || jN.Lk() || s.ho(str)) {
                        aeVar.dJ(null);
                    } else {
                        aeVar.dJ("officialaccounts");
                    }
                }
            }
        }
    };
    private e.a hsh = new e.a() {
        public final void a(e.a.b bVar) {
            if ((bVar.hrn == e.a.a.hrj || bVar.hrn == e.a.a.hrl) && bVar.hro != null) {
                ag Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(bVar.hpQ);
                if (Xv == null) {
                    return;
                }
                if (!Xv.ciN()) {
                    y.h(bVar.hro);
                } else if (!s.gU(Xv.field_username)) {
                    ae XF = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().XF(bVar.hpQ);
                    x.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", bVar.hpQ);
                    if (!(!bVar.hro.Ll() || bVar.hro.bK(false) == null || bVar.hro.bK(false).LM() == null || bi.oN(bVar.hro.Ls()) || !bi.oN(bVar.hro.field_enterpriseFather))) {
                        bVar.hro.field_enterpriseFather = bVar.hro.Ls();
                        y.Ml().e(bVar.hro);
                        x.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", bVar.hpQ, bVar.hro.field_enterpriseFather);
                    }
                    if (XF != null) {
                        int i;
                        boolean i2;
                        if (bVar.hro.Ll()) {
                            if (bVar.hro.bK(false) == null) {
                                x.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                                return;
                            } else if (bVar.hro.bK(false).LM() == null) {
                                x.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                                return;
                            } else {
                                String str = XF.field_parentRef;
                                if (bVar.hro.Lm()) {
                                    XF.dJ(null);
                                } else {
                                    x.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", bVar.hro.Ls(), bVar.hpQ);
                                    XF.dJ(bi.oM(bVar.hro.Ls()));
                                }
                                if (str != null && XF.field_parentRef != null && !str.equals(XF.field_parentRef)) {
                                    i2 = 1;
                                } else if (str == null && XF.field_parentRef != null) {
                                    i2 = 1;
                                } else if (str == null || XF.field_parentRef != null) {
                                    i2 = false;
                                } else {
                                    i2 = 1;
                                }
                                x.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", bVar.hpQ, XF.field_parentRef);
                            }
                        } else if (bVar.hro.Lk()) {
                            x.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", bVar.hpQ);
                            i2 = 1;
                        } else if (!bVar.hro.Lh() && !s.ho(Xv.field_username) && !"officialaccounts".equals(XF.field_parentRef)) {
                            XF.dJ("officialaccounts");
                            i2 = 1;
                        } else if (!bVar.hro.Lh() || XF.field_parentRef == null) {
                            i2 = false;
                        } else {
                            XF.dJ(null);
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().a(XF, XF.field_username);
                            if (!bi.oN(XF.field_parentRef)) {
                                ak XF2;
                                String cjx;
                                au Fd;
                                if ("officialaccounts".equals(XF.field_parentRef)) {
                                    XF2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().XF("officialaccounts");
                                    if (XF2 == null) {
                                        ak aeVar = new ae("officialaccounts");
                                        aeVar.cjn();
                                        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().d(aeVar);
                                        XF2 = aeVar;
                                    }
                                    if (bi.oN(XF2.field_content)) {
                                        x.i("MicroMsg.SubCoreBiz", "conv content is null");
                                        cjx = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().cjx();
                                        if (bi.oN(cjx)) {
                                            x.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                                            return;
                                        }
                                        Fd = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().Fd(cjx);
                                        if (Fd == null || Fd.field_msgId == 0) {
                                            x.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                                            return;
                                        } else {
                                            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(Fd.field_msgId, Fd);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                x.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", bVar.hpQ, XF.field_parentRef);
                                XF2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().XF(XF.field_parentRef);
                                if (XF2 != null && bi.oN(XF2.field_content)) {
                                    x.i("MicroMsg.SubCoreBiz", "conv content is null");
                                    cjx = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().XQ(XF.field_parentRef);
                                    if (bi.oN(cjx)) {
                                        x.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                                        return;
                                    }
                                    Fd = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().Fd(cjx);
                                    if (Fd == null || Fd.field_msgId == 0) {
                                        x.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                                    } else {
                                        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(Fd.field_msgId, Fd);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    };

    static /* synthetic */ void h(d dVar) {
        if (dVar.Ll() && !dVar.Lm() && dVar.bK(false) != null && dVar.bK(false).LM() != null && !bi.oN(dVar.Ls())) {
            if (((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().XF(dVar.Ls()) == null) {
                x.d("MicroMsg.SubCoreBiz", "father conv is null");
            }
            if (((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().XF(dVar.field_username) == null) {
                x.v("MicroMsg.SubCoreBiz", "add empty conv for enterprise child %s", dVar.field_username);
                ae aeVar = new ae(dVar.field_username);
                if (!dVar.Lm()) {
                    x.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", dVar.Ls(), dVar.field_username);
                    aeVar.dJ(bi.oM(dVar.Ls()));
                    aeVar.cjn();
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().d(aeVar);
                }
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return e.gLy;
            }
        });
        gyG.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return i.gLy;
            }
        });
        gyG.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.af.a.d.gLy;
            }
        });
        gyG.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return k.gLy;
            }
        });
        gyG.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return b.gLy;
            }
        });
        gyG.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return g.gLy;
            }
        });
        gyG.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return c.gLy;
            }
        });
    }

    private static synchronized y Mj() {
        y yVar;
        synchronized (y.class) {
            yVar = (y) p.s(y.class);
        }
        return yVar;
    }

    public static i Mk() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Mj().hrV == null) {
            Mj().hrV = new i(com.tencent.mm.kernel.g.Dq().gRU);
        }
        return Mj().hrV;
    }

    public static e Ml() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Mj().hrS == null) {
            Mj().hrS = new e(com.tencent.mm.kernel.g.Dq().gRU);
        }
        return Mj().hrS;
    }

    public static h Mm() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Mj().hrW == null) {
            Mj().hrW = new h();
            com.tencent.mm.ad.e eVar = Mj().hrW;
            com.tencent.mm.kernel.g.Dp().gRu.a(675, eVar);
            com.tencent.mm.kernel.g.Dp().gRu.a(672, eVar);
            com.tencent.mm.kernel.g.Dp().gRu.a(674, eVar);
            synchronized (eVar.hrp) {
                eVar.hrr.clear();
            }
        }
        return Mj().hrW;
    }

    public static com.tencent.mm.af.a.d Mn() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Mj().hrX == null) {
            Mj().hrX = new com.tencent.mm.af.a.d(com.tencent.mm.kernel.g.Dq().gRU);
        }
        return Mj().hrX;
    }

    public static b Mo() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Mj().hrY == null) {
            Mj().hrY = new b(com.tencent.mm.kernel.g.Dq().gRU);
        }
        return Mj().hrY;
    }

    public static k Mp() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Mj().hrZ == null) {
            Mj().hrZ = new k(com.tencent.mm.kernel.g.Dq().gRU);
        }
        return Mj().hrZ;
    }

    public static g Mq() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Mj().hsa == null) {
            Mj().hsa = new g(com.tencent.mm.kernel.g.Dq().gRU);
        }
        return Mj().hsa;
    }

    public static h Mr() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Mj().hsc == null) {
            Mj().hsc = new h();
        }
        return Mj().hsc;
    }

    public static c Ms() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Mj().hsd == null) {
            Mj().hsd = new c(com.tencent.mm.kernel.g.Dq().gRU);
        }
        return Mj().hsd;
    }

    public static a Mt() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Mj().hrT == null) {
            Mj().hrT = new a();
        }
        return Mj().hrT;
    }

    public static k Mu() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Mj().hrU == null) {
            Mj().hrU = new k();
        }
        return Mj().hrU;
    }

    public static a Mv() {
        if (Mj().hse == null) {
            Mj().hse = new a();
        }
        return Mj().hse;
    }

    public static i Mw() {
        com.tencent.mm.kernel.g.Do().CA();
        if (Mj().hsb == null) {
            Mj().hsb = new i();
        }
        return Mj().hsb;
    }

    public static long Mx() {
        if (hrR == 0) {
            Object obj = com.tencent.mm.kernel.g.Dq().Db().get(w.a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, null);
            if (obj != null && (obj instanceof Long)) {
                hrR = ((Long) obj).longValue();
                x.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", Long.valueOf(hrR));
            }
        }
        if (hrR == 0) {
            hrR = System.currentTimeMillis();
            com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, Long.valueOf(hrR));
            x.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", Long.valueOf(hrR));
        }
        return hrR;
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        c.a(Integer.valueOf(55), this.hhI);
        c.a(Integer.valueOf(57), this.hhI);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().b(this.hsg);
        Ml().a(this.hsh, null);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.hsf, true);
    }

    public final void onAccountRelease() {
        c.b(Integer.valueOf(55), this.hhI);
        c.b(Integer.valueOf(57), this.hhI);
        if (Mj().hrW != null) {
            com.tencent.mm.ad.e eVar = Mj().hrW;
            com.tencent.mm.kernel.g.Dp().gRu.b(675, eVar);
            com.tencent.mm.kernel.g.Dp().gRu.b(672, eVar);
            com.tencent.mm.kernel.g.Dp().gRu.b(674, eVar);
            synchronized (eVar.hrp) {
                eVar.hrr.clear();
            }
            eVar.hrq.clear();
        }
        if (com.tencent.mm.kernel.g.Do().CF()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().c(this.hsg);
            Ml().a(this.hsh);
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.hsf, true);
    }

    public final void bt(boolean z) {
    }
}
