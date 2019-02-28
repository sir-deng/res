package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static LinkedList<wd> q(JSONArray jSONArray) {
        LinkedList<wd> linkedList = new LinkedList();
        if (jSONArray != null) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    wd wdVar = new wd();
                    wdVar.wmI = jSONObject.optString("favor_compose_id");
                    wdVar.wmJ = jSONObject.optLong("show_favor_amount");
                    wdVar.wmK = jSONObject.optLong("show_pay_amount");
                    wdVar.wmL = jSONObject.optString("total_favor_amount");
                    wdVar.pPL = jSONObject.optString("favor_desc");
                    wdVar.wmM = jSONObject.optLong("compose_sort_flag");
                    wdVar.wbo = jSONObject.optString("extend_str");
                    wdVar.vVE = r(jSONObject.optJSONArray("favor_info_list"));
                    linkedList.add(wdVar);
                    i++;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BusiFavorInfoParser", e, "", new Object[0]);
                }
            }
        }
        return linkedList;
    }

    public static LinkedList<we> r(JSONArray jSONArray) {
        LinkedList<we> linkedList = new LinkedList();
        if (jSONArray != null) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    we weVar = new we();
                    weVar.wmZ = jSONObject.optString("business_receipt_no");
                    weVar.wbo = jSONObject.optString("extend_str");
                    weVar.wmT = jSONObject.optString("fav_desc");
                    weVar.wmR = jSONObject.optLong("fav_id", 0);
                    weVar.wmS = jSONObject.optString("fav_name");
                    weVar.wmW = jSONObject.optString("fav_price");
                    weVar.wmP = jSONObject.optLong("fav_property", 0);
                    weVar.wmY = jSONObject.optInt("fav_scope_type", 0);
                    weVar.wmO = jSONObject.optLong("fav_sub_type", 0);
                    weVar.wmN = jSONObject.optLong("fav_type", 0);
                    weVar.wmV = jSONObject.optString("favor_remarks");
                    weVar.wmQ = jSONObject.optString("favor_type_desc");
                    weVar.wmU = jSONObject.optString("favor_use_manual");
                    weVar.wmX = jSONObject.optString("real_fav_fee");
                    weVar.wna = jSONObject.optInt("unavailable");
                    linkedList.add(weVar);
                    i++;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BusiFavorInfoParser", e, "", new Object[0]);
                }
            }
        }
        return linkedList;
    }
}
