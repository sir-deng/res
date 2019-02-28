package com.tencent.mm.plugin.sns.g;

import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bnb;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class j {
    public static String ksD = "]]>";
    public static String ksE = "<TimelineObject>";
    public static String ksF = "</TimelineObject>";

    static class a {
        StringBuffer ksI = new StringBuffer();

        a() {
        }

        public final void vY(String str) {
            this.ksI.append("<" + str + ">");
        }

        public final void vZ(String str) {
            this.ksI.append("</" + str + ">");
        }

        public final void setText(String str) {
            if (!bi.oN(str)) {
                if (str.contains(j.ksD)) {
                    this.ksI.append("<![CDATA[" + bi.Wm(str) + "]]>");
                } else {
                    this.ksI.append("<![CDATA[" + str + "]]>");
                }
            }
        }

        public final void xk(int i) {
            this.ksI.append(i);
        }

        public final void g(String str, Map<String, String> map) {
            this.ksI.append("<" + str);
            for (String str2 : map.keySet()) {
                this.ksI.append(" " + str2 + "=\"" + ((String) map.get(str2)) + "\" ");
            }
            this.ksI.append(">");
            map.clear();
        }
    }

    private static String Lw(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private static String Lx(String str) {
        if (bi.oN(str)) {
            return "";
        }
        return (str.matches("\\d*") ? 1 : null) == null ? "" : str;
    }

    public static String b(bpb bpb) {
        String replace;
        a aVar = new a();
        Map hashMap = new HashMap();
        aVar.vY("TimelineObject");
        aVar.vY(SlookAirButtonFrequentContactAdapter.ID);
        if (bpb.nMq == null || bpb.nMq.equals("")) {
            aVar.setText("0");
        } else {
            aVar.setText(bpb.nMq);
        }
        aVar.vZ(SlookAirButtonFrequentContactAdapter.ID);
        if (bpb.kyG != null) {
            aVar.vY("username");
            aVar.setText(bpb.kyG);
            aVar.vZ("username");
        }
        aVar.vY("createTime");
        aVar.setText(bpb.pgR);
        aVar.vZ("createTime");
        aVar.vY("contentDescShowType");
        aVar.xk(bpb.wYl);
        aVar.vZ("contentDescShowType");
        aVar.vY("contentDescScene");
        aVar.xk(bpb.wYm);
        aVar.vZ("contentDescScene");
        aVar.vY("private");
        aVar.setText(bpb.wER);
        aVar.vZ("private");
        if (!(bpb.wYi == null || bi.oN(bpb.wYi.nMq))) {
            aVar.vY("appInfo");
            aVar.vY(SlookAirButtonFrequentContactAdapter.ID);
            aVar.setText(Lw(bpb.wYi.nMq));
            aVar.vZ(SlookAirButtonFrequentContactAdapter.ID);
            aVar.vY("version");
            aVar.setText(Lw(bpb.wYi.kzm));
            aVar.vZ("version");
            aVar.vY("appName");
            aVar.setText(Lw(bpb.wYi.noG));
            aVar.vZ("appName");
            aVar.vY("installUrl");
            aVar.setText(Lw(bpb.wYi.vOC));
            aVar.vZ("installUrl");
            aVar.vY("fromUrl");
            aVar.setText(Lw(bpb.wYi.vOD));
            aVar.vZ("fromUrl");
            aVar.vZ("appInfo");
        }
        if (!(bpb.wYo == null || bi.oN(bpb.wYo.heZ))) {
            aVar.vY("streamvideo");
            aVar.vY("streamvideourl");
            aVar.setText(Lw(bpb.wYo.heZ));
            aVar.vZ("streamvideourl");
            aVar.vY("streamvideototaltime");
            aVar.xk(bpb.wYo.hfa);
            aVar.vZ("streamvideototaltime");
            aVar.vY("streamvideotitle");
            aVar.setText(Lw(bpb.wYo.hfb));
            aVar.vZ("streamvideotitle");
            aVar.vY("streamvideowording");
            aVar.setText(Lw(bpb.wYo.hfc));
            aVar.vZ("streamvideowording");
            aVar.vY("streamvideoweburl");
            aVar.setText(Lw(bpb.wYo.hfd));
            aVar.vZ("streamvideoweburl");
            aVar.vY("streamvideothumburl");
            aVar.setText(Lw(bpb.wYo.hfe));
            aVar.vZ("streamvideothumburl");
            aVar.vY("streamvideoaduxinfo");
            aVar.setText(Lw(bpb.wYo.hff));
            aVar.vZ("streamvideoaduxinfo");
            aVar.vY("streamvideopublishid");
            aVar.setText(Lw(bpb.wYo.hfg));
            aVar.vZ("streamvideopublishid");
            aVar.vZ("streamvideo");
        }
        if (!(bpb.reA == null || bi.oN(bpb.reA.ttO))) {
            aVar.vY("websearch");
            aVar.vY("relevant_vid");
            aVar.setText(Lw(bpb.reA.ttO));
            aVar.vZ("relevant_vid");
            aVar.vY("relevant_expand");
            aVar.setText(Lw(bpb.reA.ttP));
            aVar.vZ("relevant_expand");
            aVar.vY("relevant_pre_searchid");
            aVar.setText(Lw(bpb.reA.ttQ));
            aVar.vZ("relevant_pre_searchid");
            aVar.vY("relevant_shared_openid");
            aVar.setText(Lw(bpb.reA.ttR));
            aVar.vZ("relevant_shared_openid");
            aVar.vY("rec_category");
            aVar.setText(Lw(bpb.reA.ttS));
            aVar.vZ("rec_category");
            aVar.vY("shareUrl");
            aVar.setText(Lw(bpb.reA.lUI));
            aVar.vZ("shareUrl");
            aVar.vY("shareTitle");
            aVar.setText(Lw(bpb.reA.lUJ));
            aVar.vZ("shareTitle");
            aVar.vY("shareDesc");
            aVar.setText(Lw(bpb.reA.rlx));
            aVar.vZ("shareDesc");
            aVar.vY("shareImgUrl");
            aVar.setText(Lw(bpb.reA.skF));
            aVar.vZ("shareImgUrl");
            aVar.vY("shareString");
            aVar.setText(Lw(bpb.reA.skG));
            aVar.vZ("shareString");
            aVar.vY("shareStringUrl");
            aVar.setText(Lw(bpb.reA.skH));
            aVar.vZ("shareStringUrl");
            aVar.vY("source");
            aVar.setText(Lw(bpb.reA.bhd));
            aVar.vZ("source");
            aVar.vY("strPlayCount");
            aVar.setText(Lw(bpb.reA.skL));
            aVar.vZ("strPlayCount");
            aVar.vY("titleUrl");
            aVar.setText(Lw(bpb.reA.skM));
            aVar.vZ("titleUrl");
            aVar.vZ("websearch");
        }
        aVar.vY("contentDesc");
        aVar.setText(Lw(bpb.wYg));
        aVar.vZ("contentDesc");
        aVar.vY("contentattr");
        aVar.setText(bpb.hcR);
        aVar.vZ("contentattr");
        aVar.vY("sourceUserName");
        aVar.setText(Lw(bpb.vtA));
        aVar.vZ("sourceUserName");
        aVar.vY("sourceNickName");
        aVar.setText(Lw(bpb.vtB));
        aVar.vZ("sourceNickName");
        aVar.vY("statisticsData");
        aVar.setText(Lw(bpb.wYn));
        aVar.vZ("statisticsData");
        aVar.vY("weappInfo");
        aVar.vY("appUserName");
        aVar.setText(Lw(bpb.wYp.username));
        aVar.vZ("appUserName");
        aVar.vY("pagePath");
        aVar.setText(Lw(bpb.wYp.path));
        aVar.vZ("pagePath");
        aVar.vZ("weappInfo");
        aVar.vY("canvasInfoXml");
        aVar.setText(Lw(bpb.rRR));
        aVar.vZ("canvasInfoXml");
        if (bpb.wYh != null) {
            float f = bpb.wYh.vXx;
            float f2 = bpb.wYh.vXy;
            if (!(f == -1000.0f || f2 == -1000.0f)) {
                hashMap.clear();
                hashMap.put("longitude", bpb.wYh.vXx);
                hashMap.put("latitude", bpb.wYh.vXy);
                hashMap.put("city", bi.Wm(Lw(bpb.wYh.hxg)));
                hashMap.put("poiName", bi.Wm(Lw(bpb.wYh.nYL)));
                hashMap.put("poiAddress", bi.Wm(Lw(bpb.wYh.rAh)));
                hashMap.put("poiScale", bpb.wYh.wCU);
                hashMap.put("poiClassifyId", Lw(bpb.wYh.wCS));
                hashMap.put("poiClassifyType", bpb.wYh.rAj);
                hashMap.put("poiClickableStatus", bpb.wYh.wCV);
                aVar.g("location", hashMap);
                aVar.vZ("location");
            }
        }
        aVar.vY("ContentObject");
        aVar.vY("contentStyle");
        aVar.setText(bpb.wYj.wfg);
        aVar.vZ("contentStyle");
        aVar.vY("contentSubStyle");
        aVar.setText(bpb.wYj.wfi);
        aVar.vZ("contentSubStyle");
        aVar.vY("title");
        aVar.setText(Lw(bpb.wYj.fpg));
        aVar.vZ("title");
        aVar.vY("description");
        aVar.setText(Lw(bpb.wYj.nkL));
        aVar.vZ("description");
        aVar.vY("contentUrl");
        aVar.setText(Lw(bpb.wYj.nlE));
        aVar.vZ("contentUrl");
        if (bpb.wYj.wfh.size() > 0) {
            aVar.vY("mediaList");
            Iterator it = bpb.wYj.wfh.iterator();
            while (it.hasNext()) {
                are are = (are) it.next();
                aVar.vY("media");
                aVar.vY(SlookAirButtonFrequentContactAdapter.ID);
                if (Lx(are.nMq).equals("")) {
                    aVar.setText("0");
                } else {
                    aVar.setText(Lx(are.nMq));
                }
                aVar.vZ(SlookAirButtonFrequentContactAdapter.ID);
                aVar.vY(Columns.TYPE);
                aVar.setText(are.kzz);
                aVar.vZ(Columns.TYPE);
                aVar.vY("title");
                aVar.setText(Lw(are.fpg));
                aVar.vZ("title");
                aVar.vY("description");
                aVar.setText(Lw(are.nkL));
                aVar.vZ("description");
                aVar.vY("private");
                aVar.setText(are.wER);
                aVar.vZ("private");
                hashMap.clear();
                hashMap.put(Columns.TYPE, are.wEO);
                if (!bi.oN(are.frM)) {
                    hashMap.put("md5", are.frM);
                }
                if (!bi.oN(are.wFk)) {
                    hashMap.put("videomd5", are.wFk);
                }
                aVar.g(SlookSmartClipMetaTag.TAG_TYPE_URL, hashMap);
                aVar.setText(Lw(are.nlE));
                aVar.vZ(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (!(are.wEP == null || are.wEP.equals(""))) {
                    hashMap.clear();
                    hashMap.put(Columns.TYPE, are.wEQ);
                    aVar.g("thumb", hashMap);
                    aVar.setText(Lw(are.wEP));
                    aVar.vZ("thumb");
                }
                if (are.fqh > 0) {
                    aVar.vY("subType");
                    aVar.setText(are.fqh);
                    aVar.vZ("subType");
                }
                if (!bi.oN(are.ryq)) {
                    aVar.vY("userData");
                    aVar.setText(are.ryq);
                    aVar.vZ("userData");
                }
                if (!(are.wET == null || are.wET.equals(""))) {
                    hashMap.clear();
                    hashMap.put(Columns.TYPE, are.wEU);
                    aVar.g("lowBandUrl", hashMap);
                    aVar.setText(Lw(are.wET));
                    aVar.vZ("lowBandUrl");
                }
                if (are.wES != null) {
                    hashMap.clear();
                    if (are.wES.wFF > 0.0f) {
                        hashMap.put("width", are.wES.wFF);
                    }
                    if (are.wES.wFG > 0.0f) {
                        hashMap.put("height", are.wES.wFG);
                    }
                    if (are.wES.wFH > 0.0f) {
                        hashMap.put("totalSize", are.wES.wFH);
                    }
                    aVar.g("size", hashMap);
                    aVar.vZ("size");
                }
                aVar.vZ("media");
            }
            aVar.vZ("mediaList");
        }
        aVar.ksI.append(Lw(bpb.wYj.wfj));
        aVar.vZ("ContentObject");
        if (bpb.rey != null) {
            aVar.vY("actionInfo");
            if (bpb.rey.vMx != null) {
                aVar.vY("appMsg");
                aVar.vY("mediaTagName");
                aVar.setText(bpb.rey.vMx.vMr);
                aVar.vZ("mediaTagName");
                aVar.vY("messageExt");
                aVar.setText(bpb.rey.vMx.vMs);
                aVar.vZ("messageExt");
                aVar.vY("messageAction");
                aVar.setText(bpb.rey.vMx.vMt);
                aVar.vZ("messageAction");
                aVar.vZ("appMsg");
            }
            aVar.vZ("actionInfo");
        }
        if (!(bpb.wYi == null || bi.oN(bpb.wYi.nMq))) {
            String str = bpb.rzD;
            bnd bnd = new bnd();
            if (str != null) {
                try {
                    bnd.aH(Base64.decode(str, 0));
                } catch (Exception e) {
                }
            }
            bnd.wXe = new bnb();
            bnd.wXe.nhB = bpb.wYi.nMq;
            try {
                str = Base64.encodeToString(bnd.toByteArray(), 0);
                replace = str.replace("\n", "");
            } catch (Throwable e2) {
                Throwable th = e2;
                replace = str;
                x.printErrStackTrace("MicroMsg.TimelineConvert", th, "", new Object[0]);
            }
            bpb.rzD = replace;
        }
        if (bpb.rzD != null) {
            aVar.vY("statExtStr");
            aVar.setText(bpb.rzD);
            aVar.vZ("statExtStr");
        }
        aVar.vZ("TimelineObject");
        replace = aVar.ksI.toString();
        x.d("MicroMsg.TimelineConvert", "xmlContent: " + replace);
        if (bj.y(replace, "TimelineObject") != null) {
            return replace;
        }
        x.e("MicroMsg.TimelineConvert", "xml is error");
        return "";
    }
}
