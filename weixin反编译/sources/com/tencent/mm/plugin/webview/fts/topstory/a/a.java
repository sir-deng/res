package com.tencent.mm.plugin.webview.fts.topstory.a;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.x.d;
import java.util.Map;

public class a extends d {
    public String bhd;
    public String lUI;
    public String lUJ;
    public String pka;
    public String rlx;
    public String skF;
    public String skG;
    public String skH;
    public String skL;
    public String skM;
    public String ttO;
    public String ttP;
    public String ttQ;
    public String ttR;
    public long ttS;

    public final /* synthetic */ d EQ() {
        d aVar = new a();
        aVar.ttO = this.ttO;
        aVar.ttP = this.ttP;
        aVar.ttQ = this.ttQ;
        aVar.ttR = this.ttR;
        aVar.ttS = this.ttS;
        aVar.lUI = this.lUI;
        aVar.lUJ = this.lUJ;
        aVar.rlx = this.rlx;
        aVar.skF = this.skF;
        aVar.skG = this.skG;
        aVar.skH = this.skH;
        aVar.bhd = this.bhd;
        aVar.pka = this.pka;
        aVar.skL = this.skL;
        aVar.skM = this.skM;
        return aVar;
    }

    public final void a(StringBuilder stringBuilder, com.tencent.mm.x.g.a aVar, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
        stringBuilder.append("<websearch>");
        if (!bi.oN(this.ttO)) {
            stringBuilder.append("<relevant_vid>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.ttO));
            stringBuilder.append("</relevant_vid>");
        }
        if (!bi.oN(this.ttP)) {
            stringBuilder.append("<relevant_expand>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.ttP));
            stringBuilder.append("</relevant_expand>");
        }
        if (!bi.oN(this.ttP)) {
            stringBuilder.append("<relevant_expand>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.ttP));
            stringBuilder.append("</relevant_expand>");
        }
        if (!bi.oN(this.ttQ)) {
            stringBuilder.append("<relevant_pre_searchid>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.ttQ));
            stringBuilder.append("</relevant_pre_searchid>");
        }
        if (!bi.oN(this.ttR)) {
            stringBuilder.append("<relevant_shared_openid>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.ttR));
            stringBuilder.append("</relevant_shared_openid>");
        }
        if (this.ttS >= 0) {
            stringBuilder.append("<rec_category>");
            stringBuilder.append(this.ttS);
            stringBuilder.append("</rec_category>");
        }
        if (!bi.oN(this.lUI)) {
            stringBuilder.append("<shareUrl>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.lUI));
            stringBuilder.append("</shareUrl>");
        }
        if (!bi.oN(this.lUJ)) {
            stringBuilder.append("<shareTitle>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.lUJ));
            stringBuilder.append("</shareTitle>");
        }
        if (!bi.oN(this.rlx)) {
            stringBuilder.append("<shareDesc>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.rlx));
            stringBuilder.append("</shareDesc>");
        }
        if (!bi.oN(this.skF)) {
            stringBuilder.append("<shareImgUrl>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.skF));
            stringBuilder.append("</shareImgUrl>");
        }
        if (!bi.oN(this.skG)) {
            stringBuilder.append("<shareString>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.skG));
            stringBuilder.append("</shareString>");
        }
        if (!bi.oN(this.skH)) {
            stringBuilder.append("<shareStringUrl>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.skH));
            stringBuilder.append("</shareStringUrl>");
        }
        if (!bi.oN(this.bhd)) {
            stringBuilder.append("<source>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.bhd));
            stringBuilder.append("</source>");
        }
        if (!bi.oN(this.pka)) {
            stringBuilder.append("<sourceUrl>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.pka));
            stringBuilder.append("</sourceUrl>");
        }
        if (!bi.oN(this.skL)) {
            stringBuilder.append("<strPlayCount>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.skL));
            stringBuilder.append("</strPlayCount>");
        }
        if (!bi.oN(this.skM)) {
            stringBuilder.append("<titleUrl>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.skM));
            stringBuilder.append("</titleUrl>");
        }
        stringBuilder.append("</websearch>");
    }

    public final void a(Map<String, String> map, com.tencent.mm.x.g.a aVar) {
        this.ttO = (String) map.get(".msg.appmsg.websearch.relevant_vid");
        this.ttP = (String) map.get(".msg.appmsg.websearch.relevant_expand");
        this.ttQ = (String) map.get(".msg.appmsg.websearch.relevant_pre_searchid");
        this.ttR = (String) map.get(".msg.appmsg.websearch.relevant_shared_openid");
        this.ttS = (long) bi.getInt((String) map.get(".msg.appmsg.websearch.rec_category"), -1);
        this.lUI = (String) map.get(".msg.appmsg.websearch.shareUrl");
        this.lUJ = (String) map.get(".msg.appmsg.websearch.shareTitle");
        this.rlx = (String) map.get(".msg.appmsg.websearch.shareDesc");
        this.skF = (String) map.get(".msg.appmsg.websearch.shareImgUrl");
        this.skG = (String) map.get(".msg.appmsg.websearch.shareString");
        this.skH = (String) map.get(".msg.appmsg.websearch.shareStringUrl");
        this.bhd = (String) map.get(".msg.appmsg.websearch.source");
        this.pka = (String) map.get(".msg.appmsg.websearch.sourceUrl");
        this.skL = (String) map.get(".msg.appmsg.websearch.strPlayCount");
        this.skM = (String) map.get(".msg.appmsg.websearch.titleUrl");
    }
}
