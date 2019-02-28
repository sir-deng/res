package com.tencent.mm.openim.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.aej;
import com.tencent.mm.protocal.c.aek;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.c.avs;
import com.tencent.mm.protocal.c.cbx;
import com.tencent.mm.protocal.c.cx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends k implements com.tencent.mm.network.k {
    String ael;
    public final b gLB;
    private e gLE;
    String idF;
    private LinkedList<String> ppn = new LinkedList();

    public c(String str, String str2, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hnT = new aej();
        aVar.hnU = new aek();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimresource";
        aVar.hnS = 453;
        this.gLB = aVar.Kf();
        this.idF = str;
        this.ael = str2;
        this.ppn.addAll(linkedList);
        int size = 10 - this.ppn.size();
        if (size > 0) {
            this.ppn.addAll(((PluginOpenIM) g.k(PluginOpenIM.class)).getWordingInfoStg().bl(size, str2));
        }
        aej aej = (aej) this.gLB.hnQ.hnY;
        aej.kPE = str;
        aej.ael = str2;
        aej.wtz = this.ppn;
        x.i("MicroMsg.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", str, str2, p(linkedList), p(this.ppn));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 453;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.idF, this.ael);
        if (i2 == 0 && i3 == 0) {
            aek aek = (aek) this.gLB.hnR.hnY;
            ar arVar = aek.wtB;
            x.i("MicroMsg.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", Integer.valueOf(arVar.vMq.size()), Integer.valueOf(arVar.vMp.size()));
            com.tencent.mm.openim.d.b bVar = new com.tencent.mm.openim.d.b();
            bVar.field_acctTypeId = arVar.vMo;
            bVar.field_language = this.ael;
            g.Dr();
            ((PluginOpenIM) g.k(PluginOpenIM.class)).getAccTypeInfoStg().b((com.tencent.mm.sdk.e.c) bVar, "acctTypeId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
            bVar.field_accTypeRec = arVar;
            g.Dr();
            ((PluginOpenIM) g.k(PluginOpenIM.class)).getAccTypeInfoStg().a(bVar);
            cx cxVar = aek.wtA;
            x.i("MicroMsg.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", Integer.valueOf(cxVar.vOB), Integer.valueOf(cxVar.vMq.size()), Integer.valueOf(cxVar.vMp.size()));
            com.tencent.mm.openim.d.c cVar = new com.tencent.mm.openim.d.c();
            cVar.field_appid = this.idF;
            cVar.field_language = this.ael;
            g.Dr();
            ((PluginOpenIM) g.k(PluginOpenIM.class)).getAppIdInfoStg().b((com.tencent.mm.sdk.e.c) cVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
            cVar.field_appRec = cxVar;
            cVar.field_acctTypeId = arVar.vMo;
            g.Dr();
            ((PluginOpenIM) g.k(PluginOpenIM.class)).getAppIdInfoStg().a(cVar);
            Iterator it = cxVar.vMq.iterator();
            while (it.hasNext()) {
                avs avs = (avs) it.next();
                if ("openim_desc_icon".equals(avs.aAM)) {
                    ((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).ox(avs.url);
                }
            }
            x.i("MicroMsg.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", Integer.valueOf(aek.wtC.size()));
            Iterator it2 = aek.wtC.iterator();
            while (it2.hasNext()) {
                cbx cbx = (cbx) it2.next();
                com.tencent.mm.openim.d.e eVar = new com.tencent.mm.openim.d.e();
                eVar.field_appid = this.idF;
                eVar.field_wordingId = cbx.xhO;
                eVar.field_language = this.ael;
                g.Dr();
                ((PluginOpenIM) g.k(PluginOpenIM.class)).getWordingInfoStg().b((com.tencent.mm.sdk.e.c) eVar, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                eVar.field_wording = cbx.fzT;
                eVar.field_pinyin = cbx.pul;
                eVar.field_quanpin = cbx.xhP;
                g.Dr();
                ((PluginOpenIM) g.k(PluginOpenIM.class)).getWordingInfoStg().a(eVar);
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    private static String p(LinkedList<String> linkedList) {
        String str = "size:" + linkedList.size() + "[";
        Iterator it = linkedList.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2 + "]";
            }
            str = str2 + ((String) it.next()) + ",";
        }
    }
}
