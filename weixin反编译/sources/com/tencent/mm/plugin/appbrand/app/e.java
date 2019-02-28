package com.tencent.mm.plugin.appbrand.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.f.a.br;
import com.tencent.mm.f.a.fx;
import com.tencent.mm.f.a.id;
import com.tencent.mm.f.a.is;
import com.tencent.mm.f.a.ja;
import com.tencent.mm.f.a.jo;
import com.tencent.mm.f.a.mn;
import com.tencent.mm.f.a.o;
import com.tencent.mm.f.a.si;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.network.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.t;
import com.tencent.mm.plugin.appbrand.appusage.l;
import com.tencent.mm.plugin.appbrand.appusage.p;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.game.a.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic;
import com.tencent.mm.plugin.appbrand.media.f;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.widget.h;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.bt;
import com.tencent.xweb.WebView;
import com.tencent.xweb.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

public final class e implements ap {
    private static volatile a iFA;
    private static volatile m iFB;
    private static volatile com.tencent.mm.plugin.appbrand.p.a iFC;
    private static volatile t iFD;
    private static volatile c iFE;
    private static com.tencent.mm.plugin.appbrand.c.c iFF;
    private static b iFG;
    private static f iFH;
    private static volatile com.tencent.mm.plugin.appbrand.appstorage.c iFr;
    private static volatile com.tencent.mm.plugin.appbrand.config.c iFs;
    private static volatile com.tencent.mm.plugin.appbrand.appcache.ap iFt;
    private static volatile p iFu;
    private static volatile l iFv;
    private static volatile com.tencent.mm.plugin.appbrand.config.p iFw;
    private static volatile com.tencent.mm.plugin.appbrand.launching.t iFx;
    private static volatile h iFy;
    private static volatile i iFz;
    private j.a hkl = new j.a() {
        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                e.ZH();
                e.ZI();
                e.ZJ();
            }
        }
    };
    private final n huc = new n.a() {
        public final void eq(int i) {
            d.onNetworkChange();
            com.tencent.mm.plugin.appbrand.appcache.b.b.i.iJI.aaE();
        }
    };
    private as.a iFI = new com.tencent.mm.plugin.appbrand.o.a();
    private com.tencent.mm.vending.b.b iFJ = null;
    private final com.tencent.mm.plugin.auth.a.a iFK = new com.tencent.mm.plugin.auth.a.a() {
        public final void a(com.tencent.mm.protocal.i.f fVar, g gVar, boolean z) {
            if (gVar != null && (gVar instanceof com.tencent.mm.protocal.i.e)) {
                com.tencent.mm.plugin.appbrand.r.c.Dt().F(new Runnable() {
                    public final void run() {
                        c.a(c.this, 1, 7, 0, true, null);
                    }
                });
                ac.cs(true);
            }
            q.jJ(q.a.iNl);
        }

        public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
        }
    };
    private final Set<com.tencent.mm.sdk.b.c> iFL = new HashSet();
    private final com.tencent.mm.sdk.b.c<ja> iFM = new com.tencent.mm.sdk.b.c<ja>() {
        {
            this.xmG = ja.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            switch (((ja) bVar).fAx.aAk) {
                case 1:
                case 3:
                    d.lN(1);
                    break;
                default:
                    d.lN(0);
                    break;
            }
            com.tencent.mm.plugin.appbrand.dynamic.h.b.ady();
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<si> iFN = new com.tencent.mm.sdk.b.c<si>() {
        {
            this.xmG = si.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean z = true;
            si siVar = (si) bVar;
            if (!bi.oN(siVar.fKS.foe)) {
                com.tencent.mm.plugin.appbrand.config.q.acp();
                String str = siVar.fKS.foe;
                int i = siVar.fKS.fKU;
                if (siVar.fKS.action != 1) {
                    z = false;
                }
                siVar.fKT.fKV = com.tencent.mm.plugin.appbrand.config.q.i(str, i, z);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<jo> iFO = new com.tencent.mm.sdk.b.c<jo>() {
        {
            this.xmG = jo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ag agVar = ((jo) bVar).fBb.fBc;
            if (x.fX(agVar.field_username)) {
                agVar.setType(0);
                r.rt(agVar.field_username);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<mn> iFP = new com.tencent.mm.sdk.b.c<mn>() {
        {
            this.xmG = mn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            cg cgVar = ((mn) bVar).fFl.fou;
            if (cgVar != null) {
                String str = cgVar.field_talker;
                if (x.fX(str)) {
                    e.Zw().aY(str + "_unreadCount", String.valueOf(bi.getInt(e.Zw().get(str + "_unreadCount", "0"), 0) + 1));
                    ak XF = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().XF(str);
                    com.tencent.mm.plugin.appbrand.ipc.d.az(com.tencent.mm.plugin.appbrand.config.q.rl(str), XF != null ? XF.field_unReadCount : 0);
                }
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.m> iFQ = new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.m>() {
        {
            this.xmG = com.tencent.mm.f.a.m.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.f.a.m mVar = (com.tencent.mm.f.a.m) bVar;
            if (!bi.oN(mVar.foc.foe)) {
                mVar.fod.fof = bi.getInt(e.Zw().get(mVar.foc.foe + "_unreadCount", "0"), 0);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.p> iFR = new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.p>() {
        {
            this.xmG = com.tencent.mm.f.a.p.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.f.a.p pVar = (com.tencent.mm.f.a.p) bVar;
            if (!bi.oN(pVar.fop.foe)) {
                String str = pVar.fop.foe;
                e.Zw().aY(str + "_unreadCount", pVar.fop.fof);
                com.tencent.mm.plugin.appbrand.ipc.d.az(com.tencent.mm.plugin.appbrand.config.q.rl(str), pVar.fop.fof);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<o> iFS = new com.tencent.mm.sdk.b.c<o>() {
        {
            this.xmG = o.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            boolean fD = e.Zw().iHl.fD("AppBrandCommonKVData", "update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'");
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AppBrandCommonKVDataStorage", "sql:%s, updateRet : %b", "update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'", Boolean.valueOf(fD));
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.l> iFT = new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.l>() {
        {
            this.xmG = com.tencent.mm.f.a.l.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (!((com.tencent.mm.f.a.l) bVar).foa.fob) {
                ac.cs(false);
                com.tencent.mm.plugin.appbrand.r.c.Dt().F(new Runnable() {
                    public final void run() {
                        if (com.tencent.mm.kernel.g.Do().CF() && !b.aaW()) {
                            c.a(c.this, 2, 7, 0, true, null);
                        }
                    }
                });
                com.tencent.mm.cc.g.cv(Boolean.valueOf(true)).h(new com.tencent.mm.plugin.appbrand.appcache.b.a.AnonymousClass2(new com.tencent.mm.plugin.appbrand.appcache.b.a.AnonymousClass1()));
                com.tencent.mm.plugin.appbrand.appcache.b.b.i.iJI.aaE();
                e.u(com.tencent.mm.plugin.appbrand.appcache.b.d.e.class);
                com.tencent.mm.plugin.appbrand.appcache.b.d.e.aaG();
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.n> iFU = new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.n>() {
        {
            this.xmG = com.tencent.mm.f.a.n.class.getName().hashCode();
        }

        private static boolean a(com.tencent.mm.f.a.n nVar) {
            String str = nVar.fog.foe;
            String str2 = nVar.fog.appId;
            int i = nVar.fog.foh;
            int i2 = nVar.fog.scene;
            String str3 = nVar.fog.foi;
            String str4 = nVar.fog.foj;
            int i3 = nVar.fog.action;
            String str5 = nVar.fog.fok;
            long j = nVar.fog.fol;
            int i4 = nVar.fog.fom;
            int i5 = nVar.fog.fon;
            int i6 = 3;
            if (!bi.oN(str)) {
                String str6 = "";
                if (!bi.oN(str4) && str4.contains(".html")) {
                    str6 = str4.substring(0, str4.lastIndexOf(".html") + 5);
                }
                str4 = "";
                try {
                    str4 = com.tencent.mm.compatible.util.p.encode(bi.oM(str6), "UTF-8");
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
                }
                String oM = bi.oM(str3);
                str3 = bi.oM(str5);
                str5 = bi.oM(str2);
                int uD = com.tencent.mm.plugin.appbrand.report.a.uD(str2);
                if (i > 0) {
                    i6 = i - 1;
                    i6 = e.Zy().ao(str, i6) ? 1 : e.Zx().ap(str, i6) ? 2 : 3;
                }
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d, appType %d", Integer.valueOf(13540), Integer.valueOf(i2), oM, str5, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i6), str6, Integer.valueOf(i3), str3, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(uD));
                com.tencent.mm.plugin.report.service.g.pWK.h(13540, (Object[]) new Object[]{Integer.valueOf(i2), oM, str5, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i6), str4, Integer.valueOf(i3), str3, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(uD)});
            }
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<br> iFV = new com.tencent.mm.sdk.b.c<br>() {
        {
            this.xmG = br.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            br brVar = (br) bVar;
            if (!bi.oN(brVar.fqE.username)) {
                WxaAttributes f = e.Zs().f(brVar.fqE.username, "roundedSquareIconURL", "bigHeadURL", "appId", "nickname");
                if (f != null) {
                    String[] strArr = new String[]{f.field_roundedSquareIconURL, f.field_bigHeadURL};
                    brVar.fqF.fqH = strArr;
                    brVar.fqF.appId = f.field_appId;
                    brVar.fqF.fqG = f.field_nickname;
                }
            }
            return true;
        }
    };
    private final com.tencent.mm.sdk.b.c<is> iFW = new com.tencent.mm.sdk.b.c<is>() {
        {
            this.xmG = is.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppBrandStickyBannerLogic.b.y(((is) bVar).fAa.fAb);
            return true;
        }
    };
    private final bt.a iFX = new an();
    private com.tencent.mm.sdk.b.c iFY = new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.e>() {
        {
            this.xmG = com.tencent.mm.f.a.e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            d.alb();
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c iFZ = new com.tencent.mm.sdk.b.c<fx>() {
        {
            this.xmG = fx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fx fxVar = (fx) bVar;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreAppBrand", "FetchAppBrandInfoForMusicEvent callback");
            fxVar.fwF.appId = a.jFe.jFc;
            fxVar.fwF.fwG = a.jFe.fwG;
            fxVar.fwF.fsi = a.jFe.fsi;
            fxVar.fwF.fwH = a.jFe.fwH;
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c iGa = new com.tencent.mm.sdk.b.c<com.tencent.mm.f.a.e>() {
        {
            this.xmG = com.tencent.mm.f.a.e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (!((com.tencent.mm.f.a.e) bVar).fnJ.fnK) {
                ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.e.class)).Jc().exit();
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<id> iGb = new com.tencent.mm.sdk.b.c<id>() {
        {
            this.xmG = id.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            id idVar = (id) bVar;
            HCEEventLogic.b(idVar.fzv.appId, idVar.fzv.type, idVar.fzv.extras);
            return false;
        }
    };
    private final AppBrandGuideUI.a iGc = new AppBrandGuideUI.a();

    static /* synthetic */ void ZH() {
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100249");
        ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("appbrand_video_player", fp.isValid() ? bi.getInt((String) fp.civ().get("appbrand_player"), -1) : -1).commit();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreAppBrand", "check appbrand video ab test[%d]", Integer.valueOf(r0));
    }

    static /* synthetic */ void ZI() {
        try {
            k.iS(ad.getContext());
            com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100367");
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreAppBrand", "get abtest of webview core");
            if (fp.isValid()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreAppBrand", "abtest of webview core is on");
                Map civ = fp.civ();
                if (bi.getInt((String) civ.get("WebCoreTestFlag"), 0) == 1) {
                    int i = bi.getInt((String) civ.get("ModuleToolsType"), 2);
                    int i2 = bi.getInt((String) civ.get("ModuleAppbrandType"), 2);
                    int i3 = bi.getInt((String) civ.get("ModuleSupportType"), 2);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreAppBrand", "moduleToolsType:" + i + ";moduleAppbrandType:" + i2 + ";moduleSupportType" + i3 + ":jsRuntimeType" + bi.getInt((String) civ.get("JsRuntimeType"), 0));
                    Editor edit = ad.getContext().getSharedPreferences("wcwebview", 4).edit();
                    edit.putString("ABTestWebViewtools", WebView.c.values()[i].toString());
                    edit.putString("ABTestWebViewappbrand", WebView.c.values()[i2].toString());
                    edit.putString("ABTestWebViewsupport", WebView.c.values()[i3].toString());
                    edit.commit();
                    if (i == 1 || i2 == 1 || i3 == 1) {
                        XWalkEnvironment.setGrayValueForTest(1);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void ZJ() {
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100371");
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreAppBrand", "get abtest of XWebLocalDebug");
        if (fp.isValid()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.SubCoreAppBrand", "abtest of XWebLocalDebug is on");
            int i = bi.getInt((String) fp.civ().get("bEnableLocalDebug"), 0);
            Editor edit = ad.getContext().getSharedPreferences("wcwebview", 4).edit();
            if (i == 1) {
                edit.putBoolean("m_bEnableLocalDebug", true).commit();
            } else {
                edit.putBoolean("m_bEnableLocalDebug", false).commit();
            }
        }
    }

    private HashMap<Integer, com.tencent.mm.bx.h.d> Zm() {
        HashMap<Integer, com.tencent.mm.bx.h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("AppKVStorageDBCreate".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.appbrand.appstorage.c.gLy;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandWxaPkgStorageDBCreate".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.appbrand.appcache.ap.iIQ;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.appbrand.config.c.iHj;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return p.iHj;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return l.iHj;
            }
        });
        hashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return new String[]{WxaAttributes.iSu};
            }
        });
        hashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return new String[]{com.tencent.mm.plugin.appbrand.launching.t.iSu};
            }
        });
        hashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return h.iHj;
            }
        });
        hashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return new String[]{i.iSu};
            }
        });
        hashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return m.iHj;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.appbrand.p.a.iHj;
            }
        });
        hashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return t.iHj;
            }
        });
        hashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return c.iHj;
            }
        });
        for (Entry entry : a.iFm.entrySet()) {
            final String[] strArr = (String[]) entry.getValue();
            hashMap.put(Integer.valueOf(((a.a) entry.getKey()).hashCode()), new com.tencent.mm.bx.h.d() {
                public final String[] wn() {
                    return strArr;
                }
            });
        }
        return hashMap;
    }

    public static a Zn() {
        return iFA;
    }

    public static e Zo() {
        com.tencent.mm.plugin.appbrand.a.b bVar = (com.tencent.mm.plugin.appbrand.a.b) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.appbrand.a.b.class);
        if (bVar != null) {
            return ((PluginAppBrand) bVar).getCore();
        }
        return null;
    }

    public final a Zp() {
        String str = com.tencent.mm.kernel.g.Dq().cachePath + "AppBrandComm.db";
        if (iFA != null && str.equals(iFA.getPath())) {
            return iFA;
        }
        a a = com.tencent.mm.platformtools.g.a(hashCode(), str, Zm(), true);
        iFA = a;
        return a;
    }

    public final HashMap<Integer, com.tencent.mm.bx.h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SubCoreAppBrand", "onAccountPostReset updated %b", Boolean.valueOf(z));
        this.iFJ = ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.iFK);
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (sharedPreferences != null) {
            Set stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet != null) {
                StringBuilder stringBuilder = new StringBuilder();
                com.tencent.mm.kernel.g.Do();
                if (stringSet.add(stringBuilder.append(com.tencent.mm.kernel.a.Cn()).toString())) {
                    Editor edit = sharedPreferences.edit();
                    edit.remove("uin_set");
                    edit.commit();
                    edit.putStringSet("uin_set", stringSet);
                    edit.commit();
                }
            }
        }
        for (com.tencent.mm.sdk.b.c cfB : this.iFL) {
            cfB.cfB();
        }
        for (String a : an.iID.keySet()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a(a, this.iFX, true);
        }
        com.tencent.mm.plugin.appbrand.appusage.j.b.abp();
        com.tencent.mm.plugin.appbrand.appusage.o.a.abp();
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().b(this.iFI);
        Zp();
        iFr = new com.tencent.mm.plugin.appbrand.appstorage.c(iFA);
        iFs = new com.tencent.mm.plugin.appbrand.config.c(iFA);
        iFt = new com.tencent.mm.plugin.appbrand.appcache.ap(iFA);
        iFu = new p(iFA);
        iFv = new l(iFA);
        iFx = new com.tencent.mm.plugin.appbrand.launching.t(iFA);
        iFy = new h(iFA);
        iFz = new i(iFA);
        iFB = new m(iFA);
        iFC = new com.tencent.mm.plugin.appbrand.p.a(iFA);
        iFD = new t(iFA);
        iFE = new c(iFA);
        Zs();
        a.a(iFA);
        com.tencent.mm.plugin.appbrand.d.setup();
        com.tencent.mm.plugin.appbrand.config.q.acp();
        a.jOP.prepare();
        ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            public final boolean execute() {
                com.tencent.mm.plugin.fts.a.h cVar = new com.tencent.mm.plugin.appbrand.f.c();
                ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).registerIndexStorage(cVar);
                cVar.create();
                com.tencent.mm.plugin.fts.a.j bVar = new com.tencent.mm.plugin.appbrand.f.b();
                ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).registerNativeLogic(7, bVar);
                bVar.create();
                com.tencent.mm.plugin.fts.d.h.a(new com.tencent.mm.plugin.appbrand.f.g());
                com.tencent.mm.plugin.fts.d.h.a(new com.tencent.mm.plugin.appbrand.f.e());
                return true;
            }

            public final String getName() {
                return "InitFTSWeAppPluginTask";
            }
        });
        ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            public final boolean execute() {
                com.tencent.mm.plugin.fts.a.h aVar = new com.tencent.mm.plugin.appbrand.game.a.a();
                ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).registerIndexStorage(aVar);
                aVar.create();
                com.tencent.mm.plugin.fts.a.j bVar = new com.tencent.mm.plugin.appbrand.game.a.b();
                ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).registerNativeLogic(10, bVar);
                bVar.create();
                com.tencent.mm.plugin.fts.d.h.a(new com.tencent.mm.plugin.appbrand.game.a.f());
                com.tencent.mm.plugin.fts.d.h.a(new com.tencent.mm.plugin.appbrand.game.a.d());
                return true;
            }

            public final String getName() {
                return "InitFTSMiniGamePluginTask";
            }
        });
        com.tencent.mm.kernel.g.Dp().a(this.huc);
        com.tencent.mm.plugin.appbrand.dynamic.g.initialize();
        com.tencent.mm.y.c.c.IL().c(this.hkl);
        com.tencent.mm.plugin.appbrand.config.f.init();
        AppBrandGuideUI.a aVar = this.iGc;
        AppBrandGuideUI.a.ali().registerActivityLifecycleCallbacks(aVar);
        AppBrandStickyBannerLogic.b.d(aVar);
        aVar.jQs = false;
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
        if (this.iFJ != null) {
            this.iFJ.dead();
            this.iFJ = null;
        }
        for (com.tencent.mm.sdk.b.c dead : this.iFL) {
            dead.dead();
        }
        com.tencent.mm.plugin.appbrand.d.release();
        for (String b : an.iID.keySet()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b(b, this.iFX, true);
        }
        com.tencent.mm.plugin.appbrand.appusage.j.b.unregister();
        com.tencent.mm.plugin.appbrand.appusage.o.a.unregister();
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk().c(this.iFI);
        aq.shutdown();
        iFr = null;
        iFw = null;
        iFs = null;
        iFt = null;
        iFu = null;
        iFv = null;
        iFx = null;
        iFy = null;
        iFz = null;
        iFB = null;
        iFC = null;
        iFD = null;
        iFE = null;
        a.Zh();
        if (iFG != null) {
            b bVar = iFG;
            bVar.iOF.clear();
            bVar.iOG.clear();
            iFG = null;
        }
        iFF = null;
        if (iFH != null) {
            f fVar = iFH;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AudioRecordMgr", "destroy");
            if (fVar.jFj == f.a.jFv || fVar.jFj == f.a.jFw || fVar.jFj == f.a.jFz) {
                fVar.vj();
            }
            iFH = null;
        }
        com.tencent.mm.plugin.appbrand.media.c.aiR();
        com.tencent.mm.plugin.appbrand.media.c.aiT();
        if (iFA != null) {
            iFA.iY(hashCode());
            iFA = null;
        }
        com.tencent.mm.plugin.appbrand.appusage.c.release();
        com.tencent.mm.plugin.appbrand.config.q.release();
        com.tencent.mm.plugin.appbrand.appcache.b.b.i iVar = com.tencent.mm.plugin.appbrand.appcache.b.b.i.iJI;
        if (iVar.iJK != null) {
            iVar.iJK.cAK();
        }
        iVar.iJJ = false;
        com.tencent.mm.plugin.appbrand.m.c cVar = a.jOP;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.WxaFTSSearchCore", "reset");
        com.tencent.mm.sdk.b.a.xmy.c(cVar.jOL);
        com.tencent.mm.sdk.b.a.xmy.c(cVar.jOM);
        cVar.jON.dead();
        com.tencent.mm.plugin.appbrand.r.c.amq();
        ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).unregisterIndexStorage(WXMediaMessage.TITLE_LENGTH_LIMIT);
        ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).unregisterNativeLogic(7);
        com.tencent.mm.plugin.fts.d.h.qz(com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX);
        com.tencent.mm.plugin.fts.d.h.qz(4208);
        ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).unregisterIndexStorage(8);
        ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).unregisterNativeLogic(10);
        com.tencent.mm.plugin.fts.d.h.qz(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX);
        com.tencent.mm.plugin.fts.d.h.qz(4224);
        com.tencent.mm.kernel.g.Dp().b(this.huc);
        com.tencent.mm.plugin.appbrand.dynamic.g.release();
        com.tencent.mm.y.c.c.IL().j(this.hkl);
        com.tencent.mm.plugin.appbrand.config.f.release();
        AppBrandGuideUI.a aVar = this.iGc;
        AppBrandGuideUI.a.ali().unregisterActivityLifecycleCallbacks(aVar);
        AppBrandStickyBannerLogic.b.c(aVar);
        aVar.jQs = false;
    }

    public e() {
        this.iFL.add(this.iFT);
        this.iFL.add(new com.tencent.mm.plugin.appbrand.launching.a());
        this.iFL.add(this.iFU);
        this.iFL.add(this.iFO);
        this.iFL.add(this.iFP);
        this.iFL.add(this.iFN);
        this.iFL.add(new com.tencent.mm.plugin.appbrand.config.e());
        this.iFL.add(this.iFM);
        this.iFL.add(com.tencent.mm.plugin.appbrand.appusage.b.iLO);
        this.iFL.add(this.iFQ);
        this.iFL.add(this.iFR);
        this.iFL.add(this.iFS);
        this.iFL.add(this.iFY);
        this.iFL.add(this.iFV);
        this.iFL.add(this.iFW);
        this.iFL.add(this.iFZ);
        this.iFL.add(this.iGa);
        this.iFL.add(this.iGb);
    }

    public static AppBrandGuideUI.a Zq() {
        return Zo() == null ? null : Zo().iGc;
    }

    public static com.tencent.mm.plugin.appbrand.appstorage.c Zr() {
        return iFr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.appbrand.config.p Zs() {
        /*
        r1 = com.tencent.mm.plugin.appbrand.app.e.class;
        monitor-enter(r1);
        r0 = iFw;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0018;
    L_0x0007:
        r0 = iFw;	 Catch:{ all -> 0x0033 }
        r2 = r0.hiZ;	 Catch:{ all -> 0x0033 }
        if (r2 == 0) goto L_0x0031;
    L_0x000d:
        r0 = r0.hiZ;	 Catch:{ all -> 0x0033 }
        r0 = r0.chz();	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x0031;
    L_0x0015:
        r0 = 1;
    L_0x0016:
        if (r0 != 0) goto L_0x002d;
    L_0x0018:
        r0 = iFA;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x002d;
    L_0x001c:
        r0 = iFA;	 Catch:{ all -> 0x0033 }
        r0 = r0.chz();	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x002d;
    L_0x0024:
        r0 = new com.tencent.mm.plugin.appbrand.config.p;	 Catch:{ all -> 0x0033 }
        r2 = iFA;	 Catch:{ all -> 0x0033 }
        r0.<init>(r2);	 Catch:{ all -> 0x0033 }
        iFw = r0;	 Catch:{ all -> 0x0033 }
    L_0x002d:
        monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        r0 = iFw;
        return r0;
    L_0x0031:
        r0 = 0;
        goto L_0x0016;
    L_0x0033:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0033 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.app.e.Zs():com.tencent.mm.plugin.appbrand.config.p");
    }

    public static com.tencent.mm.plugin.appbrand.launching.t Zt() {
        return iFx;
    }

    public static i Zu() {
        return iFz;
    }

    public static m Zv() {
        return iFB;
    }

    public static com.tencent.mm.plugin.appbrand.config.c Zw() {
        if (!(iFs != null || iFA == null || iFA.chz())) {
            iFs = new com.tencent.mm.plugin.appbrand.config.c(iFA);
        }
        return iFs;
    }

    public static p Zx() {
        return iFu;
    }

    public static l Zy() {
        return iFv;
    }

    public static com.tencent.mm.plugin.appbrand.appcache.ap Zz() {
        return iFt;
    }

    public static h ZA() {
        return iFy;
    }

    public static com.tencent.mm.plugin.appbrand.c.c ZB() {
        if (iFF == null) {
            iFF = new com.tencent.mm.plugin.appbrand.c.c();
        }
        return iFF;
    }

    public static b ZC() {
        if (iFG == null) {
            iFG = new b();
        }
        return iFG;
    }

    public static f ZD() {
        if (iFH == null) {
            iFH = new f();
        }
        return iFH;
    }

    public static com.tencent.mm.plugin.appbrand.p.a ZE() {
        return iFC;
    }

    public static t ZF() {
        return iFD;
    }

    public static c ZG() {
        return iFE;
    }

    public static <T> T u(Class<T> cls) {
        return a.u(cls);
    }
}
