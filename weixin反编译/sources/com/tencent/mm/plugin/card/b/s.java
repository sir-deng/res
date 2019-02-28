package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s {
    public static l xE(String str) {
        int i = 1;
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData jsonContent is null");
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("list");
            if (optJSONObject == null) {
                x.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutData resultJson is null");
                return null;
            }
            int i2;
            l lVar = new l();
            lVar.kSZ = optJSONObject.optString("local_city");
            lVar.kSX = xF(optJSONObject.optString("local_city_list"));
            lVar.kSY = xF(optJSONObject.optString("other_city_list"));
            lVar.kTa = optJSONObject.optBoolean("local_end");
            lVar.kTb = optJSONObject.optBoolean("other_end");
            lVar.fHY = optJSONObject.optBoolean("show_red_dot");
            lVar.fHZ = optJSONObject.optBoolean("show_new");
            lVar.kTd = optJSONObject.optString("tips");
            lVar.kTc = xG(optJSONObject.optString("icons"));
            lVar.kTe = optJSONObject.optInt("newest_sharecard_time_second");
            String str2 = "MicroMsg.ShareCardLayoutDataParser";
            String str3 = "localEnd:%d, otherEnd:%d, showRedDot:%d, showNew:%d, tips:%s";
            Object[] objArr = new Object[5];
            if (lVar.kTa) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(lVar.kTb ? 1 : 0);
            objArr[2] = Integer.valueOf(lVar.fHY ? 1 : 0);
            if (!lVar.fHZ) {
                i = 0;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = lVar.kTd;
            x.i(str2, str3, objArr);
            return lVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", e, "", new Object[0]);
            return null;
        }
    }

    private static LinkedList<m> xF(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("item_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                x.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardLayoutItem itemListJson is null");
                return null;
            }
            LinkedList<m> linkedList = new LinkedList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                m mVar = new m();
                mVar.fHP = optJSONObject.optString("card_id");
                mVar.kPy = optJSONObject.optString("card_tp_id");
                mVar.kTf = optJSONObject.optString("announcement");
                mVar.kTg = (long) optJSONObject.optInt("end_time", 0);
                mVar.kTh = (long) optJSONObject.optInt("update_time", 0);
                mVar.kTi = optJSONObject.optInt("item_type", 0);
                mVar.top = optJSONObject.optInt("top", 0);
                x.i("MicroMsg.ShareCardLayoutDataParser", "ljd: card_tp_id:" + mVar.kPy + " top:" + mVar.top);
                linkedList.add(mVar);
            }
            return linkedList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", e, "", new Object[0]);
            return null;
        }
    }

    private static LinkedList<String> xG(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons jsonContent is null");
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                x.e("MicroMsg.ShareCardLayoutDataParser", "parseShareCardIcons itemListJson is null");
                return null;
            }
            LinkedList<String> linkedList = new LinkedList();
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(jSONArray.optString(i));
            }
            return linkedList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShareCardLayoutDataParser", e, "", new Object[0]);
            return null;
        }
    }
}
