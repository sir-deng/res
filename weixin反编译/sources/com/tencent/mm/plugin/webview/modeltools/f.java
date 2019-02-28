package com.tencent.mm.plugin.webview.modeltools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.ad;
import com.tencent.mm.f.a.ae;
import com.tencent.mm.f.a.bw;
import com.tencent.mm.f.a.cl;
import com.tencent.mm.f.a.io;
import com.tencent.mm.f.a.kx;
import com.tencent.mm.f.a.tv;
import com.tencent.mm.f.a.tw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.webview.b.e;
import com.tencent.mm.plugin.webview.fts.l;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.af;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.modelcache.k;
import com.tencent.mm.plugin.webview.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.cbg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.bt;
import com.tencent.mm.y.q;
import com.tencent.mm.y.t;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public final class f implements ap {
    private static final HashMap<Integer, d> gyG;
    c bannerOnInitListener = new c<ad>() {
        {
            this.xmG = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            x.i("MicroMsg.SubCoreTools", "now prepare WebviewKeepBanner, hc:%d, sc:%d", Integer.valueOf(hashCode()), Integer.valueOf(f.this.hashCode()));
            b aeVar = new ae();
            aeVar.foO.foQ = new h(com.tencent.mm.sdk.platformtools.ad.getContext());
            a.xmy.m(aeVar);
            return false;
        }
    };
    private bt.a kAd = new bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            final String a = n.a(aVar.hoa.vNO);
            final i bSp = f.bSp();
            new Thread(new Runnable() {
                public final void run() {
                    x.d("MicroMsg.SubCoreTools", "webview hijack sysMsgListener");
                    Map y = bj.y(a, "sysmsg");
                    long j = bi.getLong((String) y.get(".sysmsg.hijackconfig.expiretime"), Long.MAX_VALUE);
                    String str = ".sysmsg.hijackconfig.domainlist.domain";
                    int i = 0;
                    String str2 = str;
                    while (true) {
                        String str3;
                        if (i > 0) {
                            str3 = str + i;
                        } else {
                            str3 = str2;
                        }
                        i++;
                        str2 = (String) y.get(str3);
                        if (!bi.oN(str2)) {
                            com.tencent.mm.sdk.e.c hVar = new h();
                            hVar.field_expireTime = j;
                            hVar.field_host = str2;
                            bSp.b(hVar);
                            str2 = str3;
                        } else {
                            return;
                        }
                    }
                }
            }).start();
        }
    };
    private com.tencent.mm.network.n mKs = new com.tencent.mm.network.n.a() {
        private final byte[] gzU = new byte[0];

        public final void eq(int i) {
            synchronized (this.gzU) {
                if (ao.getNetType(com.tencent.mm.sdk.platformtools.ad.getContext()) == 0) {
                    ah.bRE().setNetWorkState(1);
                } else {
                    ah.bRE().setNetWorkState(2);
                }
            }
        }
    };
    private ac tBd;
    private com.tencent.mm.plugin.webview.model.ad tBe;
    private ab tBf;
    private i tBg;
    private com.tencent.mm.plugin.webview.model.d tBh;
    private af tBi;
    private e tBj;
    private com.tencent.mm.plugin.webview.fts.c tBk;
    private com.tencent.mm.plugin.webview.fts.d tBl;
    private com.tencent.mm.plugin.webview.fts.e tBm;
    private com.tencent.mm.plugin.webview.c.a tBn;
    private final com.tencent.mm.plugin.webview.modelcache.n tBo = new com.tencent.mm.plugin.webview.modelcache.n();
    private com.tencent.mm.plugin.webview.wepkg.utils.c tBp = new com.tencent.mm.plugin.webview.wepkg.utils.c();
    c tBq = new c<tw>() {
        {
            this.xmG = tw.class.getName().hashCode();
        }

        private static boolean a(tw twVar) {
            if (!(twVar instanceof tw)) {
                return false;
            }
            String str;
            String FY = q.FY();
            List arrayList = new ArrayList();
            arrayList.add(twVar.fNj.fNk);
            arrayList.add(twVar.fNj.fNl);
            arrayList.add(twVar.fNj.fNm);
            arrayList.add(twVar.fNj.fNn);
            arrayList.add(twVar.fNj.url);
            arrayList.add(twVar.fNj.fNo);
            arrayList.add(twVar.fNj.fNp);
            arrayList.add(twVar.fNj.fNq);
            arrayList.add(twVar.fNj.fNr);
            arrayList.add(twVar.fNj.fNs);
            arrayList.add(FY);
            arrayList.add(twVar.fNj.fNt);
            arrayList.add(twVar.fNj.fNu);
            PString pString = new PString();
            String a = ((i) g.h(i.class)).a(twVar.fNj.fNv, pString);
            arrayList.add(a);
            arrayList.add("");
            arrayList.add("");
            arrayList.add("");
            int N = t.N(twVar.fNj.fNm, twVar.fNj.fNn);
            int N2 = t.N(FY, twVar.fNj.fNp);
            arrayList.add(String.valueOf(N));
            arrayList.add(String.valueOf(N2));
            Object obj = twVar.fNj.fNw;
            try {
                obj = URLEncoder.encode(obj, "UTF-8");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SubCoreTools", e, "", new Object[0]);
            }
            arrayList.add(obj);
            arrayList.add(pString.value);
            String str2 = "MicroMsg.SubCoreTools";
            String str3 = "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s";
            Object[] objArr = new Object[19];
            objArr[0] = twVar.fNj.fNk;
            objArr[1] = twVar.fNj.fNl;
            objArr[2] = twVar.fNj.fNm;
            objArr[3] = twVar.fNj.fNn;
            if (twVar.fNj.url == null) {
                str = twVar.fNj.url;
            } else {
                str = twVar.fNj.url.replace(",", "!");
            }
            objArr[4] = str;
            objArr[5] = Integer.valueOf(twVar.fNj.fNo);
            objArr[6] = twVar.fNj.fNp;
            objArr[7] = twVar.fNj.fNq;
            objArr[8] = Integer.valueOf(twVar.fNj.fNr);
            objArr[9] = Integer.valueOf(twVar.fNj.fNs);
            objArr[10] = FY;
            objArr[11] = Integer.valueOf(twVar.fNj.fNt);
            if (twVar.fNj.fNu == null) {
                str = twVar.fNj.fNu;
            } else {
                str = twVar.fNj.fNu.replace(",", "!");
            }
            objArr[12] = str;
            objArr[13] = twVar.fNj.fNv;
            objArr[14] = a;
            objArr[15] = Integer.valueOf(N);
            objArr[16] = Integer.valueOf(N2);
            objArr[17] = twVar.fNj.fNw;
            objArr[18] = pString.value;
            x.d(str2, str3, objArr);
            if (twVar.fNj.fNx != 2) {
                com.tencent.mm.plugin.report.service.g.pWK.d(11954, arrayList);
            }
            return true;
        }
    };
    final c<tv> tBr = new c<tv>() {
        {
            this.xmG = tv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            al.tzN = ((tv) bVar).fNh.fNi.substring(11);
            return true;
        }
    };
    c tBs = new c<io>() {
        {
            this.xmG = io.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            io ioVar = (io) bVar;
            if (!(ioVar instanceof io)) {
                return false;
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.bVz().b(ioVar.fzP.fzQ, ioVar.fzP.bjW, ioVar.fzP.fzR);
            return true;
        }
    };
    c tBt = new c<cl>() {
        {
            this.xmG = cl.class.getName().hashCode();
        }

        private static boolean a(cl clVar) {
            if (clVar instanceof cl) {
                Editor edit = com.tencent.mm.sdk.platformtools.ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                String value = com.tencent.mm.j.g.Af().getValue("WebviewDownloadTbs");
                String value2 = com.tencent.mm.j.g.Af().getValue("WebviewEnableTbs");
                String value3 = com.tencent.mm.j.g.Af().getValue("WebviewSupportedTbsVersionSection");
                x.i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, tbsDownload = %s, tbsEnable = %s, tbsSupportedVerSec = %s", value, value2, value3);
                if (value != null) {
                    edit.putString("tbs_download", value);
                }
                edit.apply();
                if ("1".equals(value) && "1".equals(value2)) {
                    j.qq(1);
                }
                if (value != null) {
                    try {
                        if ("0".equals(value)) {
                            x.i("MicroMsg.SubCoreTools", "tbs download disable, reset tbssdk in sandbox");
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(com.tencent.mm.sdk.platformtools.ad.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                            com.tencent.mm.sdk.platformtools.ad.getContext().sendBroadcast(intent);
                        }
                    } catch (Exception e) {
                        x.w("MicroMsg.SubCoreTools", "sendbroadcast ,ex = %s", e.getMessage());
                    }
                }
            }
            return false;
        }
    };
    c tBu = new c<com.tencent.mm.f.a.b>() {
        {
            this.xmG = com.tencent.mm.f.a.b.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            com.tencent.mm.f.a.b bVar2 = (com.tencent.mm.f.a.b) bVar;
            if (bVar2 instanceof com.tencent.mm.f.a.b) {
                Intent intent = new Intent();
                if (bVar2.fnC != null) {
                    intent.putExtra("card_list", bVar2.fnC.fnD);
                    intent.putExtra("result_code", bVar2.fnC.bjW);
                }
                if (bVar2.fnC == null || bVar2.fnC.bjW != -1) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.bVz().b(16, 0, intent);
                } else {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.bVz().b(16, -1, intent);
                }
            }
            return false;
        }
    };
    c tBv = new c<bw>() {
        {
            this.xmG = bw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bw bwVar = (bw) bVar;
            if (bwVar instanceof bw) {
                Intent intent = new Intent();
                if (bwVar.fqT == null || bwVar.fqT.bjW != -1) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.bVz().b(29, 0, intent);
                } else {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.bVz().b(29, -1, intent);
                }
            }
            return false;
        }
    };
    private c tBw = new c<kx>() {
        {
            this.xmG = kx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kx kxVar = (kx) bVar;
            if (kxVar.fCZ.scene == 0) {
                f.bSm().tsq = 0;
                f.bSm().tqH = null;
            } else {
                f.bSm().tsq = 1;
                f.bSm().tqH = new cbg();
                f.bSm().tqH.xhi = 1;
                f.bSm().tqH.xhj = new com.tencent.mm.protocal.c.io();
                f.bSm().tqH.xhj.fGh = kxVar.fCZ.appId;
                f.bSm().tqH.xhj.vVl = kxVar.fCZ.type;
                f.bSm().tqH.xhj.vVm = kxVar.fCZ.version;
                f.bSm().tqH.xhj.vVn = kxVar.fCZ.fDb;
            }
            return false;
        }
    };

    public static f bSi() {
        as.Hg();
        f fVar = (f) bq.ib("plugin.webview");
        if (fVar != null) {
            return fVar;
        }
        Object fVar2 = new f();
        x.e("MicroMsg.SubCoreTools", "new SubCoreTools add to subCore:%d", Integer.valueOf(fVar2.hashCode()));
        as.Hg().a("plugin.webview", fVar2);
        return fVar2;
    }

    public static com.tencent.mm.plugin.webview.c.a bSj() {
        if (bSi().tBn == null) {
            bSi().tBn = new com.tencent.mm.plugin.webview.c.a();
        }
        return bSi().tBn;
    }

    public static com.tencent.mm.plugin.webview.fts.d bSk() {
        if (bSi().tBl == null) {
            bSi().tBl = new com.tencent.mm.plugin.webview.fts.d();
        }
        return bSi().tBl;
    }

    public static com.tencent.mm.plugin.webview.fts.e bSl() {
        if (bSi().tBm == null) {
            bSi().tBm = new com.tencent.mm.plugin.webview.fts.e();
        }
        return bSi().tBm;
    }

    public static com.tencent.mm.plugin.webview.fts.c bSm() {
        if (bSi().tBk == null) {
            bSi().tBk = new com.tencent.mm.plugin.webview.fts.c();
        }
        return bSi().tBk;
    }

    public static ac bSn() {
        if (bSi().tBd == null) {
            bSi().tBd = new ac();
        }
        return bSi().tBd;
    }

    public static com.tencent.mm.plugin.webview.model.ad bSo() {
        if (bSi().tBe == null) {
            bSi().tBe = com.tencent.mm.plugin.webview.model.ad.bRC();
        }
        return bSi().tBe;
    }

    public static i bSp() {
        if (bSi().tBg == null) {
            f bSi = bSi();
            as.Hm();
            bSi.tBg = new i(com.tencent.mm.y.c.Fc());
        }
        return bSi().tBg;
    }

    public static com.tencent.mm.plugin.webview.model.d bSq() {
        if (bSi().tBh == null) {
            f bSi = bSi();
            as.Hm();
            bSi.tBh = new com.tencent.mm.plugin.webview.model.d(com.tencent.mm.y.c.Fc());
        }
        return bSi().tBh;
    }

    public static af bSr() {
        if (bSi().tBi == null) {
            f bSi = bSi();
            as.Hm();
            bSi.tBi = new af(com.tencent.mm.y.c.Fc());
        }
        return bSi().tBi;
    }

    public static e bSs() {
        if (bSi().tBj == null) {
            f bSi = bSi();
            g.Dr();
            bSi.tBj = new e(g.Dq().gRU);
        }
        return bSi().tBj;
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreTools", "onAccountRelease hc:%d", Integer.valueOf(hashCode()));
        a.xmy.c(this.tBs);
        a.xmy.c(this.tBt);
        a.xmy.c(this.tBu);
        a.xmy.c(this.tBv);
        a.xmy.c(this.tBq);
        a.xmy.c(this.bannerOnInitListener);
        a.xmy.c(this.tBw);
        as.b(this.mKs);
        if (this.tBf != null) {
            ab abVar = this.tBf;
            if (abVar.tyP != null) {
                com.tencent.mm.plugin.downloader.model.f.aAK();
                com.tencent.mm.plugin.downloader.model.c.b(abVar.tyP);
            }
            if (abVar.tyQ != null && abVar.tyQ.size() > 0) {
                for (Long l : abVar.tyQ) {
                    x.i("MicroMsg.WebViewAutoDownloader", "remove download task : %d", l);
                    com.tencent.mm.plugin.downloader.model.f.aAK().bY(l.longValue());
                }
            }
        }
        if (this.tBm != null) {
            com.tencent.mm.ad.e eVar = this.tBm;
            a.xmy.c(eVar.jil);
            if (eVar.tsP != null) {
                as.CN().b(1048, eVar);
                as.CN().c(eVar.tsP);
                eVar.tsP = null;
            }
            this.tBm = null;
        }
        if (this.tBk != null) {
            com.tencent.mm.plugin.webview.fts.c cVar = this.tBk;
            a aVar = cVar.tst;
            if (aVar.tsy != null) {
                as.CN().c(aVar.tsy);
            }
            if (aVar.tsA != null) {
                aVar.tsA.kuZ = true;
            }
            b bVar = cVar.tsu;
            if (bVar.tsC != null) {
                as.CN().b(bVar.tsC.getType(), bVar.tsx);
            }
            if (cVar.mRL != null) {
                ((m) g.k(m.class)).cancelSearchTask(cVar.mRL);
                cVar.mRL = null;
            }
            this.tBk = null;
        }
        if (this.tBl != null) {
            com.tencent.mm.sdk.e.j.a aVar2 = this.tBl;
            aVar2.qXn.dead();
            aVar2.tsJ.dead();
            com.tencent.mm.ac.n.JW().j(aVar2);
            this.tBl = null;
        }
        as.getSysCmdMsgExtension().b("hijackconfig", this.kAd, true);
        if (this.tBh != null) {
            this.tBh.bRm();
        }
        com.tencent.mm.plugin.webview.modelcache.n nVar = this.tBo;
        as.getSysCmdMsgExtension().b("webcache", nVar.tAf, true);
        a.xmy.c(nVar.tAg);
        a.xmy.c(nVar.tAh);
        com.tencent.mm.plugin.webview.modelcache.q bSc = a.tAC;
        a.xmy.c(bSc.tAn);
        a.xmy.c(bSc.tAo);
        bSc.release(true);
        com.tencent.mm.plugin.webview.wepkg.utils.c cVar2 = this.tBp;
        x.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
        a.xmy.c(cVar2.tUw);
        a.xmy.c(cVar2.tUx);
        com.tencent.mm.plugin.webview.wepkg.b.a.aQC();
        com.tencent.mm.plugin.webview.wepkg.utils.d.amq();
        this.tBr.dead();
        l bPY = l.bPY();
        a aVar3 = bPY.tts;
        if (aVar3.tsy != null) {
            as.CN().c(aVar3.tsy);
        }
        if (aVar3.ttF != null) {
            aVar3.ttF.kuZ = true;
        }
        bPY.ttA.dead();
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("WebViewHostsFilterTable".hashCode()), new d() {
            public final String[] wn() {
                return i.gLy;
            }
        });
        List<com.tencent.mm.plugin.webview.modelcache.d.a> linkedList = new LinkedList();
        linkedList.add(com.tencent.mm.plugin.webview.modelcache.a.bRV());
        linkedList.addAll(k.bRY());
        linkedList.add(com.tencent.mm.plugin.webview.modelcache.h.bRV());
        for (com.tencent.mm.plugin.webview.modelcache.d.a aVar : linkedList) {
            gyG.put(Integer.valueOf(aVar.id), aVar);
        }
        gyG.put(Integer.valueOf("WEBVIEW_JSLOG_BLOCK_LIST_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.webview.model.d.gLy;
            }
        });
        gyG.put(Integer.valueOf("WEBVIEW_LOCAL_DATA".hashCode()), new d() {
            public final String[] wn() {
                return af.gLy;
            }
        });
        gyG.put(Integer.valueOf("CHECK_WEPKG_VERSION".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.webview.wepkg.a.d.gLy;
            }
        });
        gyG.put(Integer.valueOf("WEPKG_PRELOAD_FILES".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.webview.wepkg.a.b.gLy;
            }
        });
        gyG.put(Integer.valueOf("WEBVIEW_DATA".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.webview.b.c.gLy;
            }
        });
        gyG.put(Integer.valueOf("WEBVIEW_HISTORY_DATA".hashCode()), new d() {
            public final String[] wn() {
                return e.gLy;
            }
        });
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        x.i("MicroMsg.SubCoreTools", "onAccountPostReset hc:%d", Integer.valueOf(hashCode()));
        as.Hg();
        if (((f) bq.ib("plugin.webview")) == null) {
            as.Hg().a("plugin.webview", new f());
            x.e("MicroMsg.SubCoreTools", "getCore, should not be here:%d", Integer.valueOf(r0.hashCode()));
        }
        a.xmy.b(this.tBs);
        a.xmy.b(this.tBt);
        a.xmy.b(this.tBu);
        a.xmy.b(this.tBv);
        a.xmy.b(this.tBq);
        a.xmy.b(this.bannerOnInitListener);
        a.xmy.b(this.tBw);
        as.getSysCmdMsgExtension().a("hijackconfig", this.kAd, true);
        as.a(this.mKs);
        com.tencent.mm.plugin.webview.modelcache.n nVar = this.tBo;
        com.tencent.mm.plugin.webview.modelcache.n.bSa();
        com.tencent.mm.plugin.webview.modelcache.q bSc = a.tAC;
        a.xmy.b(bSc.tAn);
        a.xmy.b(bSc.tAo);
        as.getSysCmdMsgExtension().a("webcache", nVar.tAf, true);
        a.xmy.b(nVar.tAg);
        a.xmy.b(nVar.tAh);
        com.tencent.mm.plugin.webview.wepkg.utils.c cVar = this.tBp;
        x.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
        a.xmy.b(cVar.tUw);
        a.xmy.b(cVar.tUx);
        com.tencent.mm.plugin.webview.wepkg.b.a.aQB();
        Context context = com.tencent.mm.sdk.platformtools.ad.getContext();
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("we_pkg_sp", 4);
                if (sharedPreferences == null) {
                    x.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
                } else {
                    if (sharedPreferences.getBoolean("disable_we_pkg", false)) {
                        x.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
                        sharedPreferences.edit().putBoolean("disable_we_pkg", false).commit();
                    }
                    sharedPreferences.edit().putInt("white_screen_times", 0).commit();
                }
            } catch (Exception e) {
                x.e("MicroMsg.Wepkg.WepkgListener", e.getMessage());
            }
        }
        com.tencent.mm.plugin.ae.c.qyU.a(new al());
        this.tBr.cfB();
        com.tencent.mm.x.g.b.a(new com.tencent.mm.cc.c<com.tencent.mm.x.d>() {
            public final /* synthetic */ Object get() {
                return new com.tencent.mm.plugin.webview.fts.topstory.a.a();
            }
        });
        XWalkEnvironment.init(com.tencent.mm.sdk.platformtools.ad.getContext());
        g.Do();
        XWalkEnvironment.setGrayValueByUserId(com.tencent.mm.kernel.a.Cn());
        l.bPY();
        l.start();
    }

    public final void bt(boolean z) {
        com.tencent.mm.plugin.webview.modelcache.n.bSa();
    }
}
