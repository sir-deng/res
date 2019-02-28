package com.tencent.mm.plugin.wallet_core.model;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

public final class n {
    public long sOB;
    public long sTB;
    public long sTC;
    public int sTD;
    public int sTE;
    public long sTF;

    public static class a {
        public String name;
        public String pkG;
        public String sTG;
        public String sTH;
        public String title;
        public int type;
        public String url;

        public final void Y(JSONObject jSONObject) {
            this.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            this.name = jSONObject.optString("wording");
            this.pkG = jSONObject.optString("icon");
            this.sTG = jSONObject.optString("btn_text");
            this.type = jSONObject.optInt(Columns.TYPE);
            this.title = jSONObject.optString("title");
            this.sTH = jSONObject.optString("small_title");
        }
    }

    public static class b {
        public String sGf;
        public String sGg;
        public String sTI;
        public String sTJ;
        public String sTK;
        public String sTL;
        public int sTM;
    }
}
