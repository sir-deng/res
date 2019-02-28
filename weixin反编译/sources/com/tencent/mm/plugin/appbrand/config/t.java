package com.tencent.mm.plugin.appbrand.config;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

public final class t {
    public String appId;
    public String fqG;
    public String hre;
    public List<Pair<String, String>> iSL;
    public int iSR;
    public String iSZ;
    public List<WxaEntryInfo> iSy;
    private String iTa = null;
    public String signature;
    public String username;

    public final String acw() {
        if (bi.oN(this.iTa) && !bi.cC(this.iSL)) {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            for (Pair pair : this.iSL) {
                str = bi.oN((String) pair.second) ? (String) pair.first : (String) pair.second;
                if (!bi.oN(str)) {
                    stringBuilder.append("、");
                    stringBuilder.append(str);
                }
            }
            str = stringBuilder.toString();
            if (!bi.oN(str)) {
                str = str.replaceFirst("、", "");
            }
            this.iTa = str;
        }
        return bi.oM(this.iTa);
    }
}
