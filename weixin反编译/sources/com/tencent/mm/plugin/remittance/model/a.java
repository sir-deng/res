package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static JSONObject a(iu iuVar) {
        if (iuVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            List list = iuVar.vVE;
            we weVar = new we();
            jSONObject.put("favor_info_list", bA(list));
            list = iuVar.vVF;
            wd wdVar = new wd();
            jSONObject.put("favor_compose_result_list", bB(list));
            jSONObject.put("default_fav_compose_id", iuVar.vVG);
            jSONObject.put("favor_resp_sign", iuVar.vVH);
            jSONObject.put("no_compose_wording", iuVar.vVI);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            return jSONObject;
        }
    }

    private static JSONArray bA(List<we> list) {
        if (list == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        try {
            int i = 0;
            for (we a : list) {
                jSONArray.put(i, a(a));
                i++;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        return jSONArray;
    }

    private static JSONObject a(we weVar) {
        if (weVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fav_type", weVar.wmN);
            jSONObject.put("fav_sub_type", weVar.wmO);
            jSONObject.put("fav_property", weVar.wmP);
            jSONObject.put("favor_type_desc", weVar.wmQ);
            jSONObject.put("fav_id", weVar.wmR);
            jSONObject.put("fav_name", weVar.wmS);
            jSONObject.put("fav_desc", weVar.wmT);
            jSONObject.put("favor_use_manual", weVar.wmU);
            jSONObject.put("favor_remarks", weVar.wmV);
            jSONObject.put("fav_price", weVar.wmW);
            jSONObject.put("real_fav_fee", weVar.wmX);
            jSONObject.put("fav_scope_type", weVar.wmY);
            jSONObject.put("business_receipt_no", weVar.wmZ);
            jSONObject.put("unavailable", weVar.wna);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            return jSONObject;
        }
    }

    private static JSONArray bB(List<wd> list) {
        if (list == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        try {
            int i = 0;
            for (wd a : list) {
                jSONArray.put(i, a(a));
                i++;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        return jSONArray;
    }

    public static JSONObject a(wd wdVar) {
        if (wdVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("favor_compose_id", wdVar.wmI);
            List list = wdVar.vVE;
            we weVar = new we();
            jSONObject.put("favor_info_list,", bA(list));
            jSONObject.put("show_favor_amount,", wdVar.wmJ);
            jSONObject.put("show_pay_amount,", wdVar.wmK);
            jSONObject.put("total_favor_amount,", wdVar.wmL);
            jSONObject.put("favor_desc", wdVar.pPL);
            jSONObject.put("compose_sort_flag", wdVar.wmM);
            jSONObject.put("extend_str", wdVar.wbo);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            return jSONObject;
        }
    }

    public static JSONObject a(cg cgVar) {
        if (cgVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", cgVar.fDM);
            jSONObject.put("favor_compose_info", a(cgVar.vOj));
            jSONObject.put("f2f_id", cgVar.vOg);
            jSONObject.put("payok_checksign", cgVar.vOi);
            jSONObject.put("receiver_openid", cgVar.pQZ);
            jSONObject.put("receiver_username", cgVar.vOk);
            jSONObject.put("scan_scene", cgVar.pPM);
            jSONObject.put("scene", cgVar.scene);
            jSONObject.put("total_amount", cgVar.vOl);
            jSONObject.put("trans_id", cgVar.vOh);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            return jSONObject;
        }
    }
}
