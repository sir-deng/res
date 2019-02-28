package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class w {
    public static String TAG = "MicroMsg.WalletIndexPayMenu";
    public List<a> list = new LinkedList();

    public static class a {
        public int sVF;
        public String sVG;
        public String sVH;
        public String sVI;
        public String sVJ;
    }

    public w() {
        g.Dr();
        String str = (String) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_INDEX_MAIDAN_STRING_SYNC, (Object) "");
        this.list.clear();
        if (!bi.oN(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    a aVar = new a();
                    aVar.sVF = jSONObject.optInt("paymenu_jump_type");
                    aVar.sVG = jSONObject.optString("paymenu_jump_url");
                    aVar.sVH = jSONObject.optString("paymenu_path");
                    aVar.sVI = jSONObject.optString("paymenu_title");
                    aVar.sVJ = jSONObject.optString("paymenu_username");
                    this.list.add(aVar);
                }
            } catch (Throwable e) {
                x.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
    }

    public static void NA(String str) {
        g.Dr();
        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_INDEX_MAIDAN_STRING_SYNC, (Object) str);
    }
}
