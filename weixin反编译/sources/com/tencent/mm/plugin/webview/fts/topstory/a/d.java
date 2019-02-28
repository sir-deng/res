package com.tencent.mm.plugin.webview.fts.topstory.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.topstory.a.a.b;
import com.tencent.mm.plugin.topstory.a.a.c;
import com.tencent.mm.plugin.webview.fts.j;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class d {
    private static HashMap<String, c> tul = new HashMap();
    public static com.tencent.mm.plugin.topstory.a.a.d tum;
    public static b tun;
    public static int tuo = 2;

    private static class a implements Runnable {
        HashSet<c> tup;
        com.tencent.mm.plugin.aj.a.d tuq;

        private a() {
            this.tup = new HashSet();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            List arrayList = new ArrayList();
            arrayList.addAll(this.tup);
            int i = 0;
            while (true) {
                List subList;
                int i2 = i + 20;
                if (i2 >= arrayList.size()) {
                    subList = arrayList.subList(i, arrayList.size());
                } else {
                    subList = arrayList.subList(i, i2);
                }
                String a = a(subList, this.tuq);
                if (!bi.oN(a)) {
                    final bdu bdu = new bdu();
                    bdu.wQx = a;
                    x.v("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "doWebSearchReport, websearch %d report string: %s", Integer.valueOf(subList.size()), bdu.wQx);
                    ah.y(new Runnable() {
                        public final void run() {
                            as.CN().a(new j(bdu), 0);
                        }
                    });
                }
                if (i2 < arrayList.size()) {
                    i = i2;
                } else {
                    return;
                }
            }
        }

        private static String a(List<c> list, com.tencent.mm.plugin.aj.a.d dVar) {
            if (list.size() == 0) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append("isexpose=1&content=");
            StringBuilder stringBuilder2 = new StringBuilder("");
            for (c cVar : list) {
                com.tencent.mm.plugin.topstory.a.a.d dVar2 = cVar.skA;
                stringBuilder2.append(dVar2.foX);
                stringBuilder2.append(":");
                stringBuilder2.append(dVar2.skQ);
                stringBuilder2.append(":");
                stringBuilder2.append(cVar.hMn);
                stringBuilder2.append(":");
                stringBuilder2.append(dVar2.skK);
                stringBuilder2.append(";");
            }
            try {
                stringBuilder.append(p.encode(stringBuilder2.toString(), ProtocolPackage.ServerEncoding));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e, "", new Object[0]);
            }
            try {
                com.tencent.mm.plugin.topstory.a.a.d dVar3;
                stringBuilder.append("&resulttype=");
                for (c cVar2 : list) {
                    dVar3 = cVar2.skA;
                    stringBuilder.append(dVar3.foX);
                    stringBuilder.append(":");
                    stringBuilder.append(dVar3.skR);
                    stringBuilder.append(";");
                }
                stringBuilder.append("&expand=");
                stringBuilder2 = new StringBuilder("");
                for (c cVar22 : list) {
                    dVar3 = cVar22.skA;
                    stringBuilder2.append(dVar3.foX);
                    stringBuilder2.append(":");
                    stringBuilder2.append(dVar3.skO);
                    stringBuilder2.append(";");
                }
                try {
                    stringBuilder.append(p.encode(stringBuilder2.toString(), ProtocolPackage.ServerEncoding));
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e2, "", new Object[0]);
                }
                if (dVar != null) {
                    stringBuilder.append("&");
                    stringBuilder.append("searchid=");
                    stringBuilder.append(dVar.lKv);
                    stringBuilder.append("&");
                    stringBuilder.append("query=");
                    try {
                        stringBuilder.append(p.encode(bi.oN(dVar.foW) ? ad.getContext().getString(R.l.ekW) : dVar.foW, ProtocolPackage.ServerEncoding));
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e22, "", new Object[0]);
                    }
                    stringBuilder.append("&");
                    stringBuilder.append("ishomepage=");
                    stringBuilder.append(dVar.tqs);
                    stringBuilder.append("&");
                    stringBuilder.append("sessionid=");
                    stringBuilder.append(g.zZ(dVar.scene));
                    stringBuilder.append("&");
                    stringBuilder.append("scene=");
                    stringBuilder.append(dVar.scene);
                }
                return stringBuilder.toString();
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e222, "buildWebSearchReportString error: %s", e222.getMessage());
                return null;
            }
        }
    }

    public static String bQd() {
        if (tul.size() > 0) {
            List arrayList = new ArrayList();
            arrayList.addAll(tul.values());
            StringBuilder stringBuilder = new StringBuilder("");
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                c cVar = (c) it.next();
                stringBuilder.append(cVar.skB ? 1 : 0);
                stringBuilder.append("_");
                stringBuilder.append(cVar.skA);
                stringBuilder.append(";");
                return stringBuilder.toString();
            }
        }
        return null;
    }

    public static void ahB() {
        bQe();
        tul.clear();
    }

    public static void bQe() {
        Runnable aVar = new a();
        for (c cVar : tul.values()) {
            if (!cVar.hMK) {
                cVar.hMK = true;
                aVar.tup.add(cVar);
            }
        }
        aVar.tuq = b.ttX;
        if (aVar.tup.size() > 0) {
            e.post(aVar, "TopStoryReportExposeTask");
        }
    }

    public static void b(com.tencent.mm.plugin.topstory.a.a.d dVar) {
        c cVar = new c(dVar);
        if (!tul.containsKey(cVar.skA.skE)) {
            tul.put(cVar.skA.skE, cVar);
            x.i("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "setVideoInfoExpose %s", dVar);
        }
    }

    public static void OH(String str) {
        if (tul.containsKey(str)) {
            ((c) tul.get(str)).skB = true;
            x.v("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "markVideoClick, videoId: %s", str);
            return;
        }
        x.v("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "markVideoClick, Not Found videoId: %s", str);
    }

    private static String a(com.tencent.mm.plugin.topstory.a.a.d dVar, int i, boolean z) {
        try {
            StringBuilder stringBuilder = new StringBuilder("");
            if (!(b.ttX == null || dVar == null)) {
                stringBuilder.append("scene=");
                stringBuilder.append(b.ttX.scene);
                stringBuilder.append("&");
                stringBuilder.append("businesstype=3");
                stringBuilder.append("&");
                stringBuilder.append("mediatype=2");
                stringBuilder.append("&");
                stringBuilder.append("docid=");
                stringBuilder.append(dVar.skQ);
                stringBuilder.append("&");
                stringBuilder.append("typepos=");
                stringBuilder.append("0");
                stringBuilder.append("&");
                stringBuilder.append("docpos=");
                stringBuilder.append(i + 1);
                stringBuilder.append("&");
                stringBuilder.append("searchid=");
                stringBuilder.append(b.ttX.lKv);
                stringBuilder.append("&");
                stringBuilder.append("ishomepage=");
                stringBuilder.append(0);
                stringBuilder.append("&");
                stringBuilder.append("timestamp=");
                stringBuilder.append(System.currentTimeMillis());
                stringBuilder.append("&");
                stringBuilder.append("clicktype=");
                stringBuilder.append(z ? 1 : 2);
                stringBuilder.append("&");
                stringBuilder.append("clicksource=");
                stringBuilder.append("4");
                stringBuilder.append("&");
                stringBuilder.append("sceneactiontype=");
                stringBuilder.append(b.ttX.tqu);
                stringBuilder.append("&");
                stringBuilder.append("query=");
                try {
                    stringBuilder.append(p.encode(bi.oN(b.ttX.foW) ? ad.getContext().getString(R.l.ekW) : b.ttX.foW, ProtocolPackage.ServerEncoding));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e, "", new Object[0]);
                }
                stringBuilder.append("&");
                stringBuilder.append("resulttype=");
                stringBuilder.append(dVar.skR);
                stringBuilder.append("&");
                stringBuilder.append("sessionid=");
                stringBuilder.append(g.zZ(b.ttX.scene));
                stringBuilder.append("&");
                stringBuilder.append("expand=");
                stringBuilder.append(p.encode(dVar.skK, ProtocolPackage.ServerEncoding));
                stringBuilder.append("&");
                stringBuilder.append("title=");
                stringBuilder.append(p.encode(dVar.title, ProtocolPackage.ServerEncoding));
                stringBuilder.append("&");
                stringBuilder.append("nettype=");
                if (ao.isWifi(ad.getContext())) {
                    stringBuilder.append("wifi");
                } else if (ao.is4G(ad.getContext())) {
                    stringBuilder.append("4g");
                } else {
                    stringBuilder.append("3g");
                }
                stringBuilder.append("&");
                stringBuilder.append("itemtype=");
                stringBuilder.append(dVar.skN);
            }
            return stringBuilder.toString();
        } catch (Exception e2) {
            return null;
        }
    }

    public static void b(com.tencent.mm.plugin.topstory.a.a.d dVar, int i, boolean z) {
        String a = a(dVar, i, z);
        if (!bi.oN(a)) {
            bdu bdu = new bdu();
            bdu.wQx = a;
            x.i("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "doClickVideoReport, websearch report string: %s", bdu.wQx);
            as.CN().a(new j(bdu), 0);
        }
    }

    private static String a(com.tencent.mm.plugin.topstory.a.a.d dVar, b bVar) {
        if (b.ttX == null || dVar == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("ismediaplay=1");
        stringBuilder.append("&");
        stringBuilder.append("searchid=");
        stringBuilder.append(b.ttX.lKv);
        stringBuilder.append("&");
        stringBuilder.append("scene=");
        stringBuilder.append(b.ttX.scene);
        stringBuilder.append("&");
        stringBuilder.append("businesstype=3");
        stringBuilder.append("&");
        stringBuilder.append("mediatype=2");
        stringBuilder.append("&");
        stringBuilder.append("docid=");
        stringBuilder.append(dVar.skQ);
        stringBuilder.append("&");
        stringBuilder.append("query=");
        try {
            stringBuilder.append(p.encode(bi.oN(b.ttX.foW) ? ad.getContext().getString(R.l.ekW) : b.ttX.foW, ProtocolPackage.ServerEncoding));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e, "", new Object[0]);
        }
        stringBuilder.append("&");
        stringBuilder.append("title=");
        try {
            stringBuilder.append(p.encode(dVar.title, ProtocolPackage.ServerEncoding));
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListReportUtil", e2, "", new Object[0]);
        }
        stringBuilder.append("&");
        stringBuilder.append("duration=");
        stringBuilder.append(dVar.skD * 1000);
        stringBuilder.append("&");
        stringBuilder.append("mediaid=");
        stringBuilder.append(dVar.skE);
        if (bVar != null) {
            stringBuilder.append("&");
            stringBuilder.append("startplaytime=");
            stringBuilder.append(bVar.skt);
            stringBuilder.append("&");
            stringBuilder.append("endplaytime=");
            stringBuilder.append(bVar.sku);
            stringBuilder.append("&");
            stringBuilder.append("playtime=");
            stringBuilder.append(bVar.skv);
            stringBuilder.append("&");
            stringBuilder.append("autoplay=");
            stringBuilder.append(bVar.skz);
        }
        return stringBuilder.toString();
    }

    public static void bQf() {
        x.i("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "checkDoPlayReport: %s %s", tum, tun);
        if (tum != null && tun != null && tun.skt > 0) {
            tun.sku = System.currentTimeMillis();
            tun.skv = tun.sku - tun.skt;
            String a = a(tum, tun);
            if (!bi.oN(a)) {
                bdu bdu = new bdu();
                bdu.wQx = a;
                x.i("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "doVideoPlayWebSearchReport, websearch report string: %s", bdu.wQx);
                as.CN().a(new j(bdu), 0);
            }
            tum = null;
            tun = null;
        }
    }

    public static final void a(com.tencent.mm.plugin.topstory.a.a.d dVar, int i, String str, int i2) {
        int i3;
        if (((com.tencent.mm.plugin.topstory.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.topstory.a.a.class)).aCJ()) {
            i3 = 2;
        } else if (((com.tencent.mm.plugin.topstory.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFX()) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        String str2 = dVar != null ? dVar.skQ : "";
        x.v("MicroMsg.WebSearch.TopStoryVideoListReportUtil", "reportKvTopStoryVideoPlayError %s", String.format("%s,%s,%s,%s,%s", new Object[]{str2, Integer.valueOf(i), str, Integer.valueOf(i3), Integer.valueOf(i2)}));
        com.tencent.mm.plugin.report.d.pVE.k(15248, str2);
    }

    public static void Au(int i) {
        switch (i) {
            case -21020:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.trn);
                break;
            case -21009:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.trm);
                break;
            case -10012:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.trk);
                break;
            case -10004:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.trl);
                break;
            case -1010:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.trh);
                break;
            case -1007:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.tri);
                break;
            case -1004:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.trj);
                break;
            case ap.CTRL_INDEX /*403*/:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.trp);
                break;
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.tro);
                break;
            case 405:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.trt);
                break;
            case 416:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.trs);
                break;
            case 502:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.trr);
                break;
            case 503:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.trq);
                break;
            default:
                com.tencent.mm.plugin.aj.a.a.b.qq(com.tencent.mm.plugin.aj.a.a.b.tru);
                break;
        }
        com.tencent.mm.plugin.aj.a.a.a.qq(7);
    }
}
