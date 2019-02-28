package com.tencent.mm.plugin.ipcall.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ad.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.ax;
import com.tencent.mm.f.a.az;
import com.tencent.mm.f.a.ih;
import com.tencent.mm.f.a.ii;
import com.tencent.mm.f.a.qu;
import com.tencent.mm.f.a.rw;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.ipcall.a.c.a;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.g.j;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.ui.IPCallDialUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bt;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class i implements ap {
    private static i nIC = null;
    private static HashMap<Integer, d> nIV;
    private g nID = new g();
    private a nIE = new a();
    private b nIF = new b();
    private com.tencent.mm.plugin.ipcall.a.b.b nIG = new com.tencent.mm.plugin.ipcall.a.b.b();
    private f nIH = new f();
    private c nII = new c();
    private com.tencent.mm.plugin.ipcall.a.g.d nIJ;
    private l nIK;
    private j nIL;
    private h nIM;
    private com.tencent.mm.plugin.voip.video.h nIN;
    private com.tencent.mm.plugin.voip.video.d nIO;
    private Context nIP;
    private long nIQ;
    private com.tencent.mm.sdk.b.c nIR = new com.tencent.mm.sdk.b.c<az>() {
        {
            this.xmG = az.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.d("MicroMsg.SubCoreIPCall", "change language");
            com.tencent.mm.plugin.ipcall.b.a.aVs();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nIS = new com.tencent.mm.sdk.b.c<ax>() {
        {
            this.xmG = ax.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ax axVar = (ax) bVar;
            if (axVar instanceof ax) {
                axVar.fpW.fds = i.aUi().aTY();
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nIT = new com.tencent.mm.sdk.b.c<qu>() {
        {
            this.xmG = qu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qu quVar = (qu) bVar;
            if (quVar instanceof qu) {
                Intent intent = new Intent(ad.getContext(), IPCallDialUI.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("IPCallTalkUI_contactId", quVar.fJs.fJt);
                intent.putExtra("IPCallTalkUI_countryCode", quVar.fJs.fJu);
                intent.putExtra("IPCallTalkUI_nickname", quVar.fJs.bgo);
                intent.putExtra("IPCallTalkUI_phoneNumber", quVar.fJs.fJv);
                ad.getContext().startActivity(intent);
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nIU = new com.tencent.mm.sdk.b.c<ih>() {
        {
            this.xmG = ih.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ih ihVar = (ih) bVar;
            if (ihVar instanceof ih) {
                if (ihVar.fzE.fzH && i.this.nIQ == ihVar.fzE.fzG && i.this.nIP != null) {
                    i.this.nIP = null;
                    i.this.nIQ = 0;
                }
                if (!ihVar.fzE.fzH) {
                    if (ihVar.fzE.fzG == 0) {
                        i.this.nIP = null;
                        i.this.nIQ = 0;
                    } else {
                        i.this.nIP = ihVar.fzE.fzF;
                        i.this.nIQ = ihVar.fzE.fzG;
                    }
                }
            }
            return false;
        }
    };
    private bt.a nIW = new bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOut onRecieveMsg");
            String a = n.a(aVar.hoa.vNO);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, msgContent is null");
                return;
            }
            Map y = bj.y(a, "sysmsg");
            if (y == null) {
                x.e("MicroMsg.SubCoreIPCall", "WeChatOut onReceiveMsg, values is null");
                return;
            }
            int i;
            int i2;
            Object substring;
            if (y.containsKey(".sysmsg.WeChatOut.AccountRedDotType")) {
                i = bi.getInt((String) y.get(".sysmsg.WeChatOut.AccountRedDotType"), -1);
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountRedDotType: %d", Integer.valueOf(i));
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_TYPE_INT, Integer.valueOf(i));
                i2 = i;
            } else {
                i2 = -1;
            }
            if (y.containsKey(".sysmsg.WeChatOut.AcctRD")) {
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut AcctRD: %d", Integer.valueOf(bi.getInt((String) y.get(".sysmsg.WeChatOut.AcctRD"), 0)));
                if (bi.getInt((String) y.get(".sysmsg.WeChatOut.AcctRD"), 0) != 0) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(true));
                    g.pWK.h(13254, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(-1), Integer.valueOf(-1));
                } else {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false));
                }
            }
            if (y.containsKey(".sysmsg.WeChatOut.TabRD")) {
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRD: %d", Integer.valueOf(bi.getInt((String) y.get(".sysmsg.WeChatOut.TabRD"), 0)));
                if (bi.getInt((String) y.get(".sysmsg.WeChatOut.TabRD"), 0) != 0) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(true));
                    g.pWK.h(13254, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                } else {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false));
                }
            }
            if (y.containsKey(".sysmsg.WeChatOut.RechargeRD")) {
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeRD: %d", Integer.valueOf(bi.getInt((String) y.get(".sysmsg.WeChatOut.RechargeRD"), 0)));
                if (bi.getInt((String) y.get(".sysmsg.WeChatOut.RechargeRD"), 0) != 0) {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(true));
                    g.pWK.h(13254, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                } else {
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERINFO_IPCALL_RECHARGE_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(false));
                }
            }
            if (y.containsKey(".sysmsg.WeChatOut.RechargeWording")) {
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWording: %s", (String) y.get(".sysmsg.WeChatOut.RechargeWording"));
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_RECHARGE_STRING, substring);
            }
            if (y.containsKey(".sysmsg.WeChatOut.PackagePurchaseWording")) {
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut PackagePurchaseWording: %s", (String) y.get(".sysmsg.WeChatOut.PackagePurchaseWording"));
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_IPCALL_PACKAGE_PURCHASE_STRING, substring);
            }
            if (y.containsKey(".sysmsg.WeChatOut.AccountWording")) {
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountWording: %s", (String) y.get(".sysmsg.WeChatOut.AccountWording"));
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_STRING, substring);
            }
            if (y.containsKey(".sysmsg.WeChatOut.RechargeWordingVersion")) {
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut RechargeWordingVersion: %d", Integer.valueOf(bi.getInt((String) y.get(".sysmsg.WeChatOut.RechargeWordingVersion"), 0)));
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_REDDOT_RECHARGE_VERSION_INT, Integer.valueOf(i));
            }
            if (y.containsKey(".sysmsg.WeChatOut.TabWording")) {
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut TabWording: %s", (String) y.get(".sysmsg.WeChatOut.TabWording"));
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, substring);
            }
            if (y.containsKey(".sysmsg.WeChatOut.AccountActivityWording")) {
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWording: %s", (String) y.get(".sysmsg.WeChatOut.AccountActivityWording"));
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_STRING, substring);
            }
            if (y.containsKey(".sysmsg.WeChatOut.AccountActivityWordingClearType")) {
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingClearType : %d", Integer.valueOf(bi.getInt((String) y.get(".sysmsg.WeChatOut.AccountActivityWordingClearType"), 0)));
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_CLEAR_TYPE_INT, Integer.valueOf(i));
            }
            if (y.containsKey(".sysmsg.WeChatOut.AccountActivityWordingVersion")) {
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut AccountActivityWordingVersion: %d", Integer.valueOf(bi.getInt((String) y.get(".sysmsg.WeChatOut.AccountActivityWordingVersion"), 0)));
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_IPCALL_ADDRESS_ACCOUNT_ACTIVITY_TYPE_VERSION_INT, Integer.valueOf(i));
            }
            if (y.containsKey(".sysmsg.WeChatOut.TabRedDotType")) {
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut TabRedDotType: %d", Integer.valueOf(bi.getInt((String) y.get(".sysmsg.WeChatOut.TabRedDotType"), 0)));
                g.pWK.h(13254, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(i));
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_TYPE_INT, Integer.valueOf(i));
            }
            i = a.indexOf("<ActivityInfo>");
            i2 = a.indexOf("</ActivityInfo>");
            if (i > 0 && i2 > 0 && i2 > i) {
                substring = a.substring(i, i2 + 15);
                x.i("MicroMsg.SubCoreIPCall", "WeChatOut ActivityInfo: %s", substring);
                com.tencent.mm.plugin.ipcall.a.g.a Dg = com.tencent.mm.plugin.ipcall.a.g.a.Dg(substring);
                if (Dg != null && bi.oN(Dg.fpg) && bi.oN(Dg.nkL)) {
                    x.i("MicroMsg.SubCoreIPCall", "clear activity");
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.valueOf(false));
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_ACTIVITY_STRING, (Object) "");
                } else if (Dg != null) {
                    if (!bi.oN(Dg.nMl)) {
                        o.PB().a(Dg.nMl, null);
                    }
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_HAS_ACTIVITY_BOOLEAN, Boolean.valueOf(true));
                    as.Hm();
                    com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_ACTIVITY_STRING, substring);
                }
            }
            com.tencent.mm.sdk.b.a.xmy.m(new ii());
            com.tencent.mm.sdk.b.a.xmy.m(new rw());
        }
    };
    private bt.a nIX = new bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            x.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
            bx bxVar = aVar.hoa;
            String a = n.a(aVar.hoa.vNO);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
                return;
            }
            Map y = bj.y(a, "sysmsg");
            if (y == null) {
                x.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
                return;
            }
            int i;
            h aUn = i.aUn();
            long j = (long) bxVar.vNL;
            if (y != null) {
                com.tencent.mm.sdk.e.c gVar = new com.tencent.mm.plugin.ipcall.a.g.g();
                gVar.field_svrId = j;
                gVar.field_title = (String) y.get(".sysmsg.WeChatOutMsg.Title");
                if (gVar.field_title == null) {
                    gVar.field_title = "";
                }
                gVar.field_content = (String) y.get(".sysmsg.WeChatOutMsg.Content");
                if (gVar.field_content == null) {
                    gVar.field_content = "";
                }
                int i2 = bi.getInt((String) y.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
                gVar.field_msgType = i2;
                gVar.field_pushTime = bi.getLong((String) y.get(".sysmsg.WeChatOutMsg.PushTime"), 0);
                gVar.field_descUrl = (String) y.get(".sysmsg.WeChatOutMsg.DescUrl");
                if (gVar.field_descUrl == null) {
                    gVar.field_descUrl = "";
                }
                x.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", gVar.field_svrId, gVar.field_title, gVar.field_content, gVar.field_msgType, gVar.field_pushTime, gVar.field_descUrl);
                aUn.b(gVar);
                i = i2;
            } else {
                i = -1;
            }
            if (i != -1) {
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERFINO_IPCALL_MSG_CENTER_SHOW_REDDOT_TYPE_INT, Integer.valueOf(i));
            }
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_IPCALL_MSG_CENTER_SHOW_REDDOT_BOOLEAN, Boolean.valueOf(true));
            g.pWK.h(13254, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1));
        }
    };
    private bt.a nIY = new bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            x.i("MicroMsg.SubCoreIPCall", "WCONotify onRecieveMsg");
            String a = n.a(aVar.hoa.vNO);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, msgContent is null");
                return;
            }
            Map y = bj.y(a, "sysmsg");
            if (y == null) {
                x.e("MicroMsg.SubCoreIPCall", "WCONotify onReceiveMsg, values is null");
            } else if (y.containsKey(".sysmsg.WCONotify.NotifyGetBalance")) {
                x.i("MicroMsg.SubCoreIPCall", "WCONotify NotifyGetBalance: %d", Integer.valueOf(bi.getInt((String) y.get(".sysmsg.WCONotify.NotifyGetBalance"), 0)));
                if (bi.getInt((String) y.get(".sysmsg.WCONotify.NotifyGetBalance"), 0) > 0) {
                    as.CN().a(new com.tencent.mm.plugin.ipcall.a.d.g(2), 0);
                }
            }
        }
    };

    static {
        HashMap hashMap = new HashMap();
        nIV = hashMap;
        hashMap.put(Integer.valueOf("IPCallAddressItem".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.ipcall.a.g.d.gLy;
            }
        });
        nIV.put(Integer.valueOf("IPCallRecord".hashCode()), new d() {
            public final String[] wn() {
                return l.gLy;
            }
        });
        nIV.put(Integer.valueOf("IPCallPopularCountry".hashCode()), new d() {
            public final String[] wn() {
                return j.gLy;
            }
        });
        nIV.put(Integer.valueOf("IPCallMsg".hashCode()), new d() {
            public final String[] wn() {
                return h.gLy;
            }
        });
    }

    public static i aUd() {
        if (nIC == null) {
            nIC = new i();
            as.Hg().a("plugin.ipcall", nIC);
        }
        return nIC;
    }

    public static g aUe() {
        return aUd().nID;
    }

    public static a aUf() {
        return aUd().nIE;
    }

    public static b aUg() {
        return aUd().nIF;
    }

    public static com.tencent.mm.plugin.ipcall.a.b.b aUh() {
        return aUd().nIG;
    }

    public static f aUi() {
        return aUd().nIH;
    }

    public static c aUj() {
        return aUd().nII;
    }

    public static com.tencent.mm.plugin.ipcall.a.g.d aUk() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aUd().nIJ == null) {
            i aUd = aUd();
            as.Hm();
            aUd.nIJ = new com.tencent.mm.plugin.ipcall.a.g.d(com.tencent.mm.y.c.Fc());
        }
        return aUd().nIJ;
    }

    public static l aUl() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aUd().nIK == null) {
            i aUd = aUd();
            as.Hm();
            aUd.nIK = new l(com.tencent.mm.y.c.Fc());
        }
        return aUd().nIK;
    }

    public static j aUm() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aUd().nIL == null) {
            i aUd = aUd();
            as.Hm();
            aUd.nIL = new j(com.tencent.mm.y.c.Fc());
        }
        return aUd().nIL;
    }

    public static h aUn() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aUd().nIM == null) {
            i aUd = aUd();
            as.Hm();
            aUd.nIM = new h(com.tencent.mm.y.c.Fc());
        }
        return aUd().nIM;
    }

    public static com.tencent.mm.plugin.voip.video.h aUo() {
        if (aUd().nIN == null) {
            aUd().nIN = new com.tencent.mm.plugin.voip.video.h(ad.getContext());
        }
        return aUd().nIN;
    }

    public static com.tencent.mm.plugin.voip.video.d aUp() {
        if (aUd().nIO == null) {
            aUd().nIO = new com.tencent.mm.plugin.voip.video.d(ad.getContext());
        }
        return aUd().nIO;
    }

    public final HashMap<Integer, d> Bu() {
        return nIV;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        Object obj = this.nID;
        obj.nIo.init();
        obj.nIp.init();
        obj.nIq.init();
        obj.nIr.init();
        obj.nIs.init();
        obj.nIt.init();
        obj.nIu.init();
        obj.nIv.init();
        obj.nIo.nJa = obj;
        obj.nIq.nJa = obj;
        obj.nIr.nJa = obj;
        obj.nIt.nJa = obj;
        obj.nIv.nJa = obj;
        obj.nIp.nJc = obj;
        obj.nIs.nJc = obj;
        as.a(obj.nIz);
        b.init();
        com.tencent.mm.sdk.b.a.xmy.b(d.aTU().nIb);
        com.tencent.mm.sdk.b.a.xmy.b(e.aTX().inf);
        as.getSysCmdMsgExtension().a("WeChatOut", this.nIW, true);
        as.getSysCmdMsgExtension().a("WeChatOutMsg", this.nIX, true);
        as.getSysCmdMsgExtension().a("WCONotify", this.nIY, true);
        com.tencent.mm.sdk.b.a.xmy.b(this.nIR);
        com.tencent.mm.sdk.b.a.xmy.b(this.nIS);
        com.tencent.mm.sdk.b.a.xmy.b(this.nIT);
        com.tencent.mm.sdk.b.a.xmy.b(this.nIU);
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        if (this.nIH.aTY()) {
            this.nII.cM(0, 0);
        }
        g gVar = this.nID;
        gVar.nIo.destroy();
        gVar.nIp.destroy();
        gVar.nIq.destroy();
        gVar.nIr.destroy();
        gVar.nIs.destroy();
        gVar.nIu.destroy();
        as.b(gVar.nIz);
        b.release();
        e aTU = d.aTU();
        as.CN().b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, aTU);
        as.CN().b((int) JsApiSetBackgroundAudioState.CTRL_INDEX, aTU);
        com.tencent.mm.sdk.b.a.xmy.c(aTU.nIb);
        com.tencent.mm.sdk.b.a.xmy.c(e.aTX().inf);
        as.getSysCmdMsgExtension().b("WeChatOut", this.nIW, true);
        as.getSysCmdMsgExtension().b("WeChatOutMsg", this.nIX, true);
        as.getSysCmdMsgExtension().b("WCONotify", this.nIY, true);
        com.tencent.mm.sdk.b.a.xmy.c(this.nIR);
        com.tencent.mm.sdk.b.a.xmy.c(this.nIS);
        com.tencent.mm.sdk.b.a.xmy.c(this.nIT);
        com.tencent.mm.sdk.b.a.xmy.c(this.nIU);
    }
}
