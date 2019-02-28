package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.ArrayList;
import org.json.JSONObject;

public final class c {
    public String hAU;
    public String lEs;
    String mPackageName;
    public String rRn;
    String tgF;
    public String tgG;
    long tgH;
    int tgI;
    public String tgJ;
    public String tgK;
    public String tgL;
    public String tgM;

    public c(String str, String str2, String str3) {
        this.tgF = str;
        this.tgK = str2;
        JSONObject jSONObject = new JSONObject(this.tgK);
        this.tgG = jSONObject.optString("orderId");
        this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        this.lEs = jSONObject.optString("productId");
        this.tgH = jSONObject.optLong("purchaseTime");
        this.tgI = jSONObject.optInt("purchaseState");
        String optString = jSONObject.optString("developerPayload");
        ArrayList Ob = Ob(optString);
        if (Ob.size() == 3) {
            this.tgJ = (String) Ob.get(0);
            this.tgM = (String) Ob.get(1);
            this.tgL = (String) Ob.get(2);
        } else {
            this.tgJ = optString;
        }
        this.hAU = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.rRn = str3;
    }

    public c(String str, String str2, String str3, String str4) {
        this.lEs = str;
        this.tgJ = str2;
        this.tgL = str3;
        this.tgM = str4;
    }

    private static ArrayList<String> Ob(String str) {
        ArrayList<String> arrayList = new ArrayList();
        while (str.indexOf("[#]") >= 0) {
            String substring = str.substring(0, str.indexOf("[#]"));
            str = str.substring(substring.length() + 3);
            arrayList.add(substring);
        }
        arrayList.add(str);
        return arrayList;
    }

    public final String toString() {
        return "PurchaseInfo(type:" + this.tgF + "):" + this.tgK;
    }
}
