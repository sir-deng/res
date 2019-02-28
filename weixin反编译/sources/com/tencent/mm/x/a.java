package com.tencent.mm.x;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

public class a extends d {
    public boolean hck;
    public String hcl;
    public int hcm;

    public final d EQ() {
        d aVar = new a();
        aVar.hck = this.hck;
        aVar.hcl = this.hcl;
        aVar.hcm = this.hcm;
        return aVar;
    }

    public final void a(StringBuilder stringBuilder, com.tencent.mm.x.g.a aVar, String str, keep_SceneResult keep_sceneresult, int i, int i2) {
        stringBuilder.append("<weappinfo>");
        if (!bi.oN(aVar.hfh)) {
            stringBuilder.append("<pagepath>" + com.tencent.mm.x.g.a.fW(aVar.hfh) + "</pagepath>");
        }
        stringBuilder.append("<username>" + bi.Wm(aVar.hfi) + "</username>");
        stringBuilder.append("<appid>" + bi.Wm(aVar.hfj) + "</appid>");
        if (aVar.hfq != 0) {
            stringBuilder.append("<version>" + aVar.hfq + "</version>");
        }
        if (aVar.hfk != 0) {
            stringBuilder.append("<type>" + aVar.hfk + "</type>");
        }
        if (!bi.oN(aVar.hfr)) {
            stringBuilder.append("<weappiconurl>" + com.tencent.mm.x.g.a.fW(aVar.hfr) + "</weappiconurl>");
        }
        if (!bi.oN(aVar.hfn)) {
            stringBuilder.append("<shareId>" + com.tencent.mm.x.g.a.fW(aVar.hfn) + "</shareId>");
        }
        if (aVar.hfp == 1 || aVar.hfp == 2) {
            stringBuilder.append("<pkginfo>");
            stringBuilder.append("<type>");
            stringBuilder.append(aVar.hfp);
            stringBuilder.append("</type>");
            stringBuilder.append("<md5>");
            stringBuilder.append(aVar.hfl);
            stringBuilder.append("</md5>");
            stringBuilder.append("</pkginfo>");
        }
        if (!bi.oN(aVar.hfo)) {
            stringBuilder.append("<sharekey>" + com.tencent.mm.x.g.a.fW(aVar.hfo) + "</sharekey>");
        }
        if (this.hck) {
            stringBuilder.append("<wadynamicpageinfo>");
            stringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
            stringBuilder.append("<cacheKey>");
            stringBuilder.append(com.tencent.mm.x.g.a.fW(this.hcl));
            stringBuilder.append("</cacheKey>");
            stringBuilder.append("</wadynamicpageinfo>");
        }
        stringBuilder.append("<appservicetype>" + this.hcm + "</appservicetype>");
        stringBuilder.append("</weappinfo>");
    }

    public final void a(Map<String, String> map, com.tencent.mm.x.g.a aVar) {
        boolean z;
        if (bi.getInt((String) map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.hck = z;
        this.hcl = (String) map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey");
        this.hcm = bi.getInt((String) map.get(".msg.appmsg.weappinfo.appservicetype"), this.hcm);
    }
}
