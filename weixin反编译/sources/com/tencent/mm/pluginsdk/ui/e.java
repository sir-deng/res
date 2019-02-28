package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public final class e {
    private int version = 0;
    public int vqb = -7829368;
    public boolean vqc = false;
    public int vqd = -1593835521;
    public boolean vqe = false;
    public int vqf = WebView.NIGHT_MODE_COLOR;
    public boolean vqg = false;
    public int vqh = 0;
    public boolean vqi = false;

    public e(String str) {
        String str2 = "chatbg";
        Map y = bj.y(str, str2);
        String str3 = "." + str2;
        try {
            this.version = bi.e(Integer.valueOf((String) y.get(str3 + ".$version")));
            this.vqb = (int) bi.a(Long.valueOf(Long.parseLong((String) y.get(str3 + ".$time_color"), 16)), -7829368);
            this.vqc = bi.c(Boolean.valueOf((String) y.get(str3 + ".$time_show_shadow_color")));
            this.vqd = (int) bi.a(Long.valueOf(Long.parseLong((String) y.get(str3 + ".$time_shadow_color"), 16)), 0);
            this.vqe = bi.c(Boolean.valueOf((String) y.get(str3 + ".$time_show_background")));
            this.vqf = (int) bi.a(Long.valueOf(Long.parseLong((String) y.get(str3 + ".$voice_second_color"), 16)), -16777216);
            this.vqg = bi.c(Boolean.valueOf((String) y.get(str3 + ".$voice_second_show_shadow_color")));
            this.vqh = (int) bi.a(Long.valueOf(Long.parseLong((String) y.get(str3 + ".$voice_second_shadow_color"), 16)), 0);
            this.vqi = bi.c(Boolean.valueOf((String) y.get(str3 + ".$voice_second_show_background")));
        } catch (Throwable e) {
            x.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
            x.printErrStackTrace("MicroMsg.ChatBgAttr", e, "", new Object[0]);
        }
    }
}
