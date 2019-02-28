package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h {
    public boolean fsk = true;
    public String nWh = "";
    public String rfT = "";
    public String rfU = "";
    public String rgI = "";
    public int[] rgJ;
    public int rgv = 0;
    public List<a> rgw = new ArrayList();

    public final boolean bwZ() {
        return this.fsk && this.rgw != null && this.rgw.size() > 0;
    }

    public final boolean d(String str, String str2, Map<String, String> map) {
        this.rfU = str;
        this.rfT = str2;
        if (map != null) {
            try {
                this.rgw.clear();
                this.nWh = bi.aD((String) map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
                this.rgI = bi.aD((String) map.get("first_step_order"), "");
                String[] split = this.rgI.split("\\|");
                this.rgJ = new int[split.length];
                if (this.rgJ.length == 0) {
                    this.fsk = false;
                }
                int i = 0;
                while (i < split.length) {
                    this.rgJ[i] = bi.Wo(split[i]);
                    if (this.rgJ[i] <= 0 || this.rgJ[i] > 3) {
                        this.fsk = false;
                    }
                    i++;
                }
                int Wo = bi.Wo((String) map.get("wording_count"));
                int Wo2 = bi.Wo((String) map.get("expertype"));
                for (int i2 = 0; i2 < Wo; i2++) {
                    a aVar = new a();
                    aVar.rfm = bi.Wo((String) map.get(String.format("wording_%d_id", new Object[]{Integer.valueOf(i2 + 1)})));
                    aVar.rfn = bi.aD((String) map.get(String.format("wording_%d_zh_CN", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.rfo = bi.aD((String) map.get(String.format("wording_%d_zh_TW", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.rfp = bi.aD((String) map.get(String.format("wording_%d_en", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.rfq = bi.Wo((String) map.get(String.format("wording_%d_action_type", new Object[]{Integer.valueOf(i2 + 1)})));
                    this.rgw.add(aVar);
                }
                x.i("MicroMsg.SnsAdAbTestInfo", "expertType " + Wo2 + " " + str + " " + this.rgI);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", e, "feed xml error ", new Object[0]);
            }
        }
        return false;
    }
}
