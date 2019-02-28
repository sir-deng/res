package com.tencent.mm.plugin.wallet_core.model;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.f.b.eb;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r extends eb {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bulletin_scene";
        aVar.xrT.put("bulletin_scene", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bulletin_scene TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "bulletin_scene";
        aVar.columns[1] = "bulletin_content";
        aVar.xrT.put("bulletin_content", "TEXT");
        stringBuilder.append(" bulletin_content TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "bulletin_url";
        aVar.xrT.put("bulletin_url", "TEXT");
        stringBuilder.append(" bulletin_url TEXT");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public static void ab(JSONObject jSONObject) {
        boolean z = true;
        int i = 0;
        d bMg = o.bMg();
        StringBuilder append;
        if (jSONObject == null || bMg == null) {
            String str = "MicroMsg.WalletBulletin";
            append = new StringBuilder("json==null?").append(jSONObject == null).append("  stg==null?");
            if (bMg != null) {
                z = false;
            }
            x.e(str, append.append(z).toString());
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("banner_map");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("banner_content_array");
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        if (optJSONArray == null || optJSONArray2 == null) {
            String str2 = "MicroMsg.WalletBulletin";
            append = new StringBuilder("scenes==null?").append(optJSONArray == null).append("  contents==null?");
            if (optJSONArray2 != null) {
                z = false;
            }
            x.e(str2, append.append(z).toString());
            return;
        }
        int i2;
        JSONObject optJSONObject;
        int length = optJSONArray.length();
        for (i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
            if (optJSONObject2 != null) {
                String optString = optJSONObject2.optString("banner_type");
                String optString2 = optJSONObject2.optString("banner_template_id");
                x.i("MicroMsg.WalletBulletin", "sceneid=" + optString + "; contentid=" + optString2);
                if (!(bi.oN(optString) || bi.oN(optString2))) {
                    hashMap.put(optString, optString2);
                    x.i("MicroMsg.WalletBulletin", "sceneid:" + optString + " map contentid:" + optString2);
                }
            }
        }
        i2 = optJSONArray2.length();
        while (i < i2) {
            optJSONObject = optJSONArray2.optJSONObject(i);
            if (optJSONObject != null) {
                hashMap2.put(optJSONObject.optString("banner_template_id"), Integer.valueOf(i));
            }
            i++;
        }
        if (hashMap.size() > 0) {
            for (String str3 : hashMap.keySet()) {
                String str4 = (String) hashMap.get(str3);
                if (hashMap2.containsKey(str4)) {
                    x.i("MicroMsg.WalletBulletin", "find contentid:" + str4 + "in contentMap");
                    optJSONObject = optJSONArray2.optJSONObject(((Integer) hashMap2.get(str4)).intValue());
                    c rVar = new r();
                    rVar.field_bulletin_scene = str3;
                    rVar.field_bulletin_content = optJSONObject.optString("content");
                    rVar.field_bulletin_url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    bMg.b(rVar);
                } else {
                    x.e("MicroMsg.WalletBulletin", "can not find contentid:" + str4 + "in contentMap");
                }
            }
        }
    }
}
