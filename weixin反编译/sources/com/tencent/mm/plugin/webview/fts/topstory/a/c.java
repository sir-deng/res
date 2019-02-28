package com.tencent.mm.plugin.webview.fts.topstory.a;

import android.webkit.URLUtil;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.network.v;
import com.tencent.mm.plugin.topstory.a.a.d;
import com.tencent.mm.plugin.webview.fts.h;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c implements e {
    a tuh;
    boolean tui;

    /* renamed from: com.tencent.mm.plugin.webview.fts.topstory.a.c$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ d tuk;

        AnonymousClass4(d dVar) {
            this.tuk = dVar;
        }

        public final void run() {
            if (c.this.tuh != null) {
                c.this.tuh.a(this.tuk);
            }
        }
    }

    public interface a {
        void OG(String str);

        void a(d dVar);

        void cn(List<d> list);
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.topstory.a.c$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ArrayList lle;

        AnonymousClass2(ArrayList arrayList) {
            this.lle = arrayList;
        }

        public final void run() {
            if (this.lle != null) {
                x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "callbackToSucc, result lisze size: %s", Integer.valueOf(this.lle.size()));
                if (this.lle.size() <= 0) {
                    c.this.OF(null);
                } else if (c.this.tuh != null) {
                    c.this.tuh.cn(this.lle);
                }
            }
        }
    }

    public final void a(int i, com.tencent.mm.plugin.topstory.a.a.a aVar, com.tencent.mm.plugin.aj.a.d dVar, boolean z, a aVar2) {
        oz ozVar;
        long j = 0;
        x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "fetch, offset: %s, relevantVideoInfo: %s, modelParams: %s, fetchCallback: %s", Integer.valueOf(i), aVar, dVar, aVar2);
        this.tuh = aVar2;
        this.tui = z;
        com.tencent.mm.plugin.aj.a.d dVar2 = new com.tencent.mm.plugin.aj.a.d();
        dVar2.offset = i;
        dVar2.tqs = dVar.tqs;
        dVar2.scene = dVar.scene;
        dVar2.tqu = dVar.tqu;
        dVar2.tqz = dVar.tqz;
        dVar2.foW = dVar.foW;
        dVar2.lKv = dVar.lKv;
        dVar2.tqD = new LinkedList();
        if (!bi.oN(aVar.sko)) {
            ozVar = new oz();
            ozVar.aAM = "relevant_vid";
            ozVar.weC = aVar.sko;
            dVar2.tqD.add(ozVar);
        }
        if (!bi.oN(aVar.skp)) {
            ozVar = new oz();
            ozVar.aAM = "relevant_expand";
            ozVar.weC = aVar.skp;
            dVar2.tqD.add(ozVar);
        }
        if (!bi.oN(aVar.skq)) {
            ozVar = new oz();
            ozVar.aAM = "relevant_pre_searchid";
            ozVar.weC = aVar.skq;
            dVar2.tqD.add(ozVar);
        }
        if (!bi.oN(aVar.skr)) {
            ozVar = new oz();
            ozVar.aAM = "relevant_shared_openid";
            ozVar.weC = aVar.skr;
            dVar2.tqD.add(ozVar);
        }
        if (aVar.sks >= 0) {
            ozVar = new oz();
            ozVar.aAM = "rec_category";
            ozVar.weB = aVar.sks;
            dVar2.tqD.add(ozVar);
        }
        ozVar = new oz();
        ozVar.aAM = "is_prefetch";
        if (b.tud) {
            j = 1;
        }
        ozVar.weB = j;
        dVar2.tqD.add(ozVar);
        String bQd = d.bQd();
        x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "clientExposeReportString: %s", bQd);
        if (!bi.oN(bQd)) {
            oz ozVar2 = new oz();
            ozVar2.aAM = "client_exposed_info";
            ozVar2.weC = bQd;
            dVar2.tqD.add(ozVar2);
        }
        oz ozVar3 = new oz();
        ozVar3.aAM = DownloadInfo.NETTYPE;
        if (ao.isWifi(ad.getContext())) {
            ozVar3.weC = "wifi";
        } else if (ao.is4G(ad.getContext())) {
            ozVar3.weC = "4g";
        } else {
            ozVar3.weC = "3g";
        }
        dVar2.tqD.add(ozVar3);
        as.CN().a(new h(dVar2), 0);
        x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "doFetchPage: %s", r0);
        com.tencent.mm.plugin.aj.a.a.a.qq(0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "onSceneEnd, errType: %s, errCode: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), kVar);
        if (kVar.getType() == 1943) {
            h hVar = (h) kVar;
            if (i == 0 && i2 == 0) {
                try {
                    final JSONObject jSONObject = new JSONObject(hVar.Ji());
                    com.tencent.mm.sdk.f.e.post(new Runnable() {
                        public final void run() {
                            c cVar = c.this;
                            JSONObject jSONObject = jSONObject;
                            JSONObject optJSONObject = jSONObject.optJSONObject("client_conf");
                            if (!(optJSONObject == null || optJSONObject == null)) {
                                b.a(optJSONObject.optInt("enable_prefetch", 0) == 1, (long) optJSONObject.optInt("max_report_exposed_cnt", 0), optJSONObject.optInt("max_report_exposed_cnt", 0));
                            }
                            if (b.ttX != null) {
                                String optString = jSONObject.optString("searchID");
                                x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "fetch response searchid: %s", optString);
                                if (!bi.oN(optString)) {
                                    b.ttX.lKv = optString;
                                }
                            }
                            JSONArray optJSONArray = jSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                            ArrayList arrayList = new ArrayList();
                            if (optJSONArray == null || optJSONArray.length() <= 0) {
                                com.tencent.mm.plugin.aj.a.a.a.qq(1);
                                cVar.OF(jSONObject.optString("nomoreText"));
                                return;
                            }
                            int i = 0;
                            while (true) {
                                try {
                                    int i2 = i;
                                    if (i2 < optJSONArray.length()) {
                                        optJSONObject = (JSONObject) optJSONArray.get(i2);
                                        optJSONObject.optInt("count");
                                        long optLong = optJSONObject.optLong("resultType");
                                        long optLong2 = optJSONObject.optLong(Columns.TYPE);
                                        String optString2 = optJSONObject.optString("expand");
                                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("items");
                                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                            long Wz = bi.Wz();
                                            i = 0;
                                            while (true) {
                                                int i3 = i;
                                                if (i3 >= optJSONArray2.length()) {
                                                    break;
                                                }
                                                optJSONObject = (JSONObject) optJSONArray2.get(i3);
                                                String optString3 = optJSONObject.optString("videoApi");
                                                String optString4 = optJSONObject.optString("videoId");
                                                String optString5 = optJSONObject.optString("videoPlatform");
                                                String optString6 = optJSONObject.optString("docID");
                                                int optInt = optJSONObject.optInt("mediaDuration", 0);
                                                if (!(bi.oN(optString3) || bi.oN(optString4))) {
                                                    x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "videoid: %s, videoApi: %s, videoPlatform: %s, videoDuration: %s", optString4, optString3, optString5, Integer.valueOf(optInt));
                                                    d dVar = new d();
                                                    dVar.skE = optString4;
                                                    dVar.skC = "http://shp.qpic.cn/qqvideo_ori/0/" + optString4 + String.format("_%s_%s/0", new Object[]{Integer.valueOf(496), Integer.valueOf(280)});
                                                    c.a(dVar, optString3, optString5);
                                                    dVar.videoUrl = dVar.skT.size() > 0 ? (String) dVar.skT.get(0) : null;
                                                    if (bi.oN(dVar.videoUrl)) {
                                                        com.tencent.mm.plugin.aj.a.a.a.qq(11);
                                                    }
                                                    dVar.skD = optInt;
                                                    dVar.title = optJSONObject.optString("title");
                                                    dVar.lUJ = optJSONObject.optString("shareTitle");
                                                    dVar.rlx = optJSONObject.optString("shareDesc");
                                                    dVar.skF = optJSONObject.optString("shareImgUrl");
                                                    dVar.skG = optJSONObject.optString("shareString");
                                                    dVar.skH = optJSONObject.optString("shareStringUrl");
                                                    dVar.bhd = optJSONObject.optString("source");
                                                    dVar.pka = optJSONObject.optString("sourceUrl");
                                                    dVar.hcZ = 496;
                                                    dVar.hcY = 280;
                                                    dVar.lUI = optJSONObject.optString("shareUrl");
                                                    dVar.skI = optJSONObject.optLong("relevant_category", -1);
                                                    dVar.skJ = optJSONObject.optString("shareOpenId");
                                                    dVar.skK = optJSONObject.optString("expand");
                                                    dVar.skL = optJSONObject.optString("strPlayCount");
                                                    dVar.skM = optJSONObject.optString("titleUrl");
                                                    dVar.skN = optJSONObject.optInt("itemType");
                                                    dVar.skP = optJSONObject.optString("bizIcon");
                                                    dVar.timestamp = Wz;
                                                    dVar.fpU = false;
                                                    dVar.skQ = optString6;
                                                    dVar.skR = optLong;
                                                    dVar.foX = optLong2;
                                                    dVar.skO = optString2;
                                                    if (i2 == 0 && i3 == 0 && cVar.tui) {
                                                        x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "callbackFirstVideo: %s", dVar);
                                                        ah.y(new AnonymousClass4(dVar));
                                                    } else if (!(bi.oN(dVar.videoUrl) || bi.oN(dVar.skC))) {
                                                        x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "title: %s, thumbnailUrl: %s, videoUrl: %s, ", dVar.title, dVar.videoUrl, dVar.skC);
                                                        arrayList.add(dVar);
                                                    }
                                                }
                                                i = i3 + 1;
                                            }
                                        }
                                        i = i2 + 1;
                                    } else {
                                        ah.y(new AnonymousClass2(arrayList));
                                        return;
                                    }
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListFetcher", e, "parseAndRequestVideoList error: %s", e.getMessage());
                                    com.tencent.mm.plugin.aj.a.a.a.qq(3);
                                    cVar.OF(null);
                                    return;
                                }
                            }
                        }
                    }, "FtsRecommendVideoListFetcher_parseAndRequestVideoList");
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListFetcher", e, "parse recommend json failed: %s", e.getMessage());
                    return;
                }
            }
            x.e("MicroMsg.WebSearch.TopStoryVideoListFetcher", "fetch page failed!, response json: %s", hVar.Ji());
            com.tencent.mm.plugin.aj.a.a.a.qq(2);
            OF(null);
        }
    }

    static void a(d dVar, String str, String str2) {
        InputStream inputStream;
        u uVar;
        Throwable e;
        InputStream inputStream2;
        u uVar2;
        String str3 = null;
        StringBuilder stringBuilder = new StringBuilder("");
        dVar.skT = new ArrayList();
        v ol;
        try {
            if (URLUtil.isHttpsUrl(str)) {
                ol = b.ol(str);
                try {
                    ol.VK();
                    ol.VI();
                    ol.VJ();
                    inputStream = ol.ick.getInputStream();
                    uVar = null;
                } catch (Exception e2) {
                    e = e2;
                    inputStream2 = null;
                    try {
                        x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListFetcher", e, "getVideoUrlByVideoApi error: %s", e.getMessage());
                        if (uVar2 != null) {
                            uVar2.aBw.disconnect();
                        }
                        if (ol != null) {
                            ol.ick.disconnect();
                        }
                        if (inputStream2 == null) {
                            com.tencent.mm.a.e.c(inputStream2);
                        }
                    } catch (Throwable th) {
                        e = th;
                        inputStream = inputStream2;
                        uVar = uVar2;
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (ol != null) {
                            ol.ick.disconnect();
                        }
                        if (inputStream != null) {
                            com.tencent.mm.a.e.c(inputStream);
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    uVar = null;
                    inputStream = null;
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (ol != null) {
                        ol.ick.disconnect();
                    }
                    if (inputStream != null) {
                        com.tencent.mm.a.e.c(inputStream);
                    }
                    throw e;
                }
            }
            u a = b.a(str, null);
            try {
                a.setUseCaches(true);
                a.setConnectTimeout(3000);
                a.setReadTimeout(3000);
                inputStream = a.getInputStream();
                uVar = a;
                ol = null;
            } catch (Exception e3) {
                e = e3;
                inputStream2 = null;
                u uVar3 = a;
                ol = null;
                uVar2 = uVar3;
                x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListFetcher", e, "getVideoUrlByVideoApi error: %s", e.getMessage());
                if (uVar2 != null) {
                    uVar2.aBw.disconnect();
                }
                if (ol != null) {
                    ol.ick.disconnect();
                }
                if (inputStream2 == null) {
                    com.tencent.mm.a.e.c(inputStream2);
                }
            } catch (Throwable th3) {
                e = th3;
                uVar = a;
                inputStream = null;
                ol = null;
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (ol != null) {
                    ol.ick.disconnect();
                }
                if (inputStream != null) {
                    com.tencent.mm.a.e.c(inputStream);
                }
                throw e;
            }
            try {
                String readLine;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuilder.append(readLine);
                }
                x.i("MicroMsg.WebSearch.TopStoryVideoListFetcher", "videoApi json: %s", stringBuilder);
                JSONObject jSONObject = new JSONObject(stringBuilder.toString().substring(13));
                JSONObject optJSONObject = jSONObject.optJSONObject("fl");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("fi");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        dVar.skS = optJSONArray.getJSONObject(0).optLong("fs");
                    }
                }
                optJSONObject = jSONObject.optJSONObject("vl");
                if (optJSONObject != null) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("vi");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        String str4 = null;
                        readLine = null;
                        for (int i = 0; i < optJSONArray2.length(); i++) {
                            JSONObject jSONObject2 = optJSONArray2.getJSONObject(i);
                            if (jSONObject2 != null) {
                                readLine = jSONObject2.optString("fn");
                                str4 = jSONObject2.optString("fvkey");
                                jSONObject2 = jSONObject2.optJSONObject("ul");
                                if (jSONObject2 != null) {
                                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("ui");
                                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                        jSONObject2 = optJSONArray3.getJSONObject(0);
                                        if (jSONObject2 != null) {
                                            str3 = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                        }
                                    }
                                }
                            }
                            if (!(bi.oN(str3) || bi.oN(str4) || bi.oN(readLine))) {
                                Object obj = str3 + readLine + "?vkey=" + str4;
                                if (!bi.oN(str2)) {
                                    obj = obj + "&platform=" + str2;
                                }
                                dVar.skT.add(obj);
                            }
                        }
                    }
                }
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (ol != null) {
                    ol.ick.disconnect();
                }
                if (inputStream != null) {
                    com.tencent.mm.a.e.c(inputStream);
                }
            } catch (Exception e4) {
                e = e4;
                uVar2 = uVar;
                inputStream2 = inputStream;
                x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListFetcher", e, "getVideoUrlByVideoApi error: %s", e.getMessage());
                if (uVar2 != null) {
                    uVar2.aBw.disconnect();
                }
                if (ol != null) {
                    ol.ick.disconnect();
                }
                if (inputStream2 == null) {
                    com.tencent.mm.a.e.c(inputStream2);
                }
            } catch (Throwable th4) {
                e = th4;
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (ol != null) {
                    ol.ick.disconnect();
                }
                if (inputStream != null) {
                    com.tencent.mm.a.e.c(inputStream);
                }
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            ol = null;
            inputStream2 = null;
            x.printErrStackTrace("MicroMsg.WebSearch.TopStoryVideoListFetcher", e, "getVideoUrlByVideoApi error: %s", e.getMessage());
            if (uVar2 != null) {
                uVar2.aBw.disconnect();
            }
            if (ol != null) {
                ol.ick.disconnect();
            }
            if (inputStream2 == null) {
                com.tencent.mm.a.e.c(inputStream2);
            }
        } catch (Throwable th5) {
            e = th5;
            ol = null;
            uVar = null;
            inputStream = null;
            if (uVar != null) {
                uVar.aBw.disconnect();
            }
            if (ol != null) {
                ol.ick.disconnect();
            }
            if (inputStream != null) {
                com.tencent.mm.a.e.c(inputStream);
            }
            throw e;
        }
    }

    final void OF(final String str) {
        x.e("MicroMsg.WebSearch.TopStoryVideoListFetcher", "callbackToFailed, msg: %s", str);
        ah.y(new Runnable() {
            public final void run() {
                if (c.this.tuh != null) {
                    c.this.tuh.OG(str);
                }
            }
        });
    }
}
