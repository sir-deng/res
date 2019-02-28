package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.f.b.ed;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.reflect.Field;
import org.json.JSONObject;

public final class x extends ed {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_tpa_country";
        aVar.xrT.put("wallet_tpa_country", "TEXT PRIMARY KEY ");
        stringBuilder.append(" wallet_tpa_country TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "wallet_tpa_country";
        aVar.columns[1] = "wallet_type";
        aVar.xrT.put("wallet_type", "INTEGER");
        stringBuilder.append(" wallet_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "wallet_name";
        aVar.xrT.put("wallet_name", "TEXT");
        stringBuilder.append(" wallet_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "wallet_selected";
        aVar.xrT.put("wallet_selected", "INTEGER");
        stringBuilder.append(" wallet_selected INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "wallet_balance";
        aVar.xrT.put("wallet_balance", "INTEGER");
        stringBuilder.append(" wallet_balance INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "wallet_tpa_country_mask";
        aVar.xrT.put("wallet_tpa_country_mask", "INTEGER");
        stringBuilder.append(" wallet_tpa_country_mask INTEGER");
        aVar.columns[6] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public static x ac(JSONObject jSONObject) {
        if (jSONObject == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WalletKindInfo", "json is null");
            return null;
        }
        x xVar = new x();
        xVar.field_wallet_tpa_country = jSONObject.optString("wallet_tpa_country");
        xVar.field_wallet_name = jSONObject.optString("wallet_name");
        xVar.field_wallet_selected = jSONObject.optInt("wallet_selected");
        xVar.field_wallet_type = jSONObject.optInt("wallet_type");
        xVar.field_wallet_balance = jSONObject.optInt("wallet_balance");
        xVar.field_wallet_tpa_country_mask = jSONObject.optInt("wallet_tpa_country_mask");
        if (!bi.oN(xVar.field_wallet_tpa_country)) {
            return xVar;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WalletKindInfo", "wallet_id is illegal");
        return null;
    }
}
