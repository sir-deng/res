package com.tencent.mm.bb;

import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.protocal.c.bga;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static bgb hMr;

    public static bgb Rb() {
        if (hMr == null) {
            String Rc = Rc();
            hMr = new bgb();
            Rc = ad.getContext().getSharedPreferences("fts_history_search_sp", 0).getString(Rc, "");
            if (!bi.oN(Rc)) {
                try {
                    hMr.aH(Base64.decode(Rc.getBytes(), 0));
                } catch (IOException e) {
                }
            }
        }
        return hMr;
    }

    public static String Rc() {
        return "key_pb_history_list" + q.FY();
    }

    public static String Rd() {
        int i = 0;
        bgb Rb = Rb();
        int size = Rb.kyB.size();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            while (true) {
                int i2 = i;
                if (i2 >= Rb.kyB.size() || i2 >= size) {
                    jSONObject2.put("items", jSONArray2);
                    jSONObject2.put("count", jSONArray2.length());
                    jSONObject2.put(Columns.TYPE, 4);
                    jSONArray.put(jSONObject2);
                    jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
                    jSONObject.put("ret", 0);
                } else {
                    bga bga = (bga) Rb.kyB.get(i2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("word", bga.wRS);
                    jSONArray2.put(jSONObject3);
                    i = i2 + 1;
                }
            }
            jSONObject2.put("items", jSONArray2);
            jSONObject2.put("count", jSONArray2.length());
            jSONObject2.put(Columns.TYPE, 4);
            jSONArray.put(jSONObject2);
            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
            jSONObject.put("ret", 0);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
