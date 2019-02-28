package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d {
    public boolean fsk = true;
    public String nWh = "";
    public String rfT = "";
    public String rfU = "";
    public int rgv = 0;
    public List<b> rgw = new ArrayList();

    static class a {
        public int actionType;
        public int index;
        public String jumpUrl;
        public String rgx;
        public String rgy;
        public int rgz;

        a() {
        }
    }

    static class b {
        public List<a> iSI = new ArrayList();
        public int rgA;
        public int showType;
        public String title;

        b() {
        }
    }

    public final boolean d(String str, String str2, Map<String, String> map) {
        this.rfU = str;
        this.rfT = str2;
        if (map != null) {
            try {
                this.rgw.clear();
                this.nWh = bi.aD((String) map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
                if (!this.nWh.equals("zh_cn")) {
                    this.fsk = false;
                }
                int Wo = bi.Wo((String) map.get("tipcount"));
                int Wo2 = bi.Wo((String) map.get("expertype"));
                for (int i = 0; i < Wo; i++) {
                    b bVar = new b();
                    bVar.title = bi.aD((String) map.get(String.format("tip_%d_basetextformat", new Object[]{Integer.valueOf(i)})), "");
                    bVar.rgA = bi.Wo((String) map.get(String.format("tip_%d_id", new Object[]{Integer.valueOf(i)})));
                    bVar.showType = bi.Wo((String) map.get(String.format("tip_%d_showtype", new Object[]{Integer.valueOf(i)})));
                    int Wo3 = bi.Wo((String) map.get(String.format("tip_%d_button_count", new Object[]{Integer.valueOf(i)})));
                    if (bVar.showType >= 6) {
                        this.fsk = false;
                    }
                    for (int i2 = 0; i2 < Wo3; i2++) {
                        a aVar = new a();
                        aVar.index = bi.Wo((String) map.get(String.format("tip_%d_button_%d_index", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        aVar.actionType = bi.Wo((String) map.get(String.format("tip_%d_button_%d_actiontype", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        aVar.rgx = bi.aD((String) map.get(String.format("tip_%d_button_%d_basetextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.jumpUrl = bi.aD((String) map.get(String.format("tip_%d_button_%d_jumpurl", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.rgy = bi.aD((String) map.get(String.format("tip_%d_button_%d_priortextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.rgz = bi.Wo((String) map.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        if (aVar.actionType >= 9) {
                            this.fsk = false;
                        }
                        bVar.iSI.add(aVar);
                    }
                    this.rgw.add(bVar);
                }
                x.i("Micromsg.SnsABTestInfo", "expertType " + Wo2 + " " + str);
            } catch (Throwable e) {
                x.printErrStackTrace("Micromsg.SnsABTestInfo", e, "feed xml error ", new Object[0]);
            }
        }
        return false;
    }
}
