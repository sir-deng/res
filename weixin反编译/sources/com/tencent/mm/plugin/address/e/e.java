package com.tencent.mm.plugin.address.e;

import android.util.Log;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

public final class e {
    public static String a(b bVar) {
        JSONObject jSONObject = new JSONObject();
        if (bVar == null) {
            return jSONObject.toString();
        }
        try {
            jSONObject.put(Columns.TYPE, bVar.type);
            if (bVar.type == null || !bVar.type.equals("1")) {
                jSONObject.put("title", bVar.title);
                if (bVar.nHr != null) {
                    jSONObject.put("taxNumber", bVar.nHr);
                } else {
                    jSONObject.put("taxNumber", "");
                }
                if (bVar.nHx != null) {
                    jSONObject.put("companyAddress", bVar.nHx);
                } else {
                    jSONObject.put("companyAddress", "");
                }
                if (bVar.nHv != null) {
                    jSONObject.put("telephone", bVar.nHv);
                } else {
                    jSONObject.put("telephone", "");
                }
                if (bVar.nHt != null) {
                    jSONObject.put("bankName", bVar.nHt);
                } else {
                    jSONObject.put("bankName", "");
                }
                if (bVar.nHs != null) {
                    jSONObject.put("bankAccount", bVar.nHs);
                } else {
                    jSONObject.put("bankAccount", "");
                }
                return jSONObject.toString();
            }
            jSONObject.put("title", bVar.nHq);
            jSONObject.put("taxNumber", "");
            jSONObject.put("companyAddress", "");
            jSONObject.put("telephone", "");
            jSONObject.put("bankName", "");
            jSONObject.put("bankAccount", "");
            return jSONObject.toString();
        } catch (Throwable e) {
            x.e("MicroMsg.InvoiceUtil", "put json value error : %s", Log.getStackTraceString(e));
        }
    }
}
