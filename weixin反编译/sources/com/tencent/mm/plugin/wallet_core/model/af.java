package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.f.b.eh;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.lang.reflect.Field;

public final class af extends eh {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = OpenSDKTool4Assistant.EXTRA_UIN;
        aVar.xrT.put(OpenSDKTool4Assistant.EXTRA_UIN, "TEXT PRIMARY KEY ");
        stringBuilder.append(" uin TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = OpenSDKTool4Assistant.EXTRA_UIN;
        aVar.columns[1] = "is_reg";
        aVar.xrT.put("is_reg", "INTEGER");
        stringBuilder.append(" is_reg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "true_name";
        aVar.xrT.put("true_name", "TEXT");
        stringBuilder.append(" true_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "card_num";
        aVar.xrT.put("card_num", "INTEGER");
        stringBuilder.append(" card_num INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isDomesticUser";
        aVar.xrT.put("isDomesticUser", "INTEGER");
        stringBuilder.append(" isDomesticUser INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "cre_type";
        aVar.xrT.put("cre_type", "INTEGER");
        stringBuilder.append(" cre_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "main_card_bind_serialno";
        aVar.xrT.put("main_card_bind_serialno", "TEXT");
        stringBuilder.append(" main_card_bind_serialno TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "ftf_pay_url";
        aVar.xrT.put("ftf_pay_url", "TEXT");
        stringBuilder.append(" ftf_pay_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "switchConfig";
        aVar.xrT.put("switchConfig", "INTEGER");
        stringBuilder.append(" switchConfig INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "reset_passwd_flag";
        aVar.xrT.put("reset_passwd_flag", "TEXT");
        stringBuilder.append(" reset_passwd_flag TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "find_passwd_url";
        aVar.xrT.put("find_passwd_url", "TEXT");
        stringBuilder.append(" find_passwd_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "is_open_touch";
        aVar.xrT.put("is_open_touch", "INTEGER");
        stringBuilder.append(" is_open_touch INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "lct_wording";
        aVar.xrT.put("lct_wording", "TEXT");
        stringBuilder.append(" lct_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "lct_url";
        aVar.xrT.put("lct_url", "TEXT");
        stringBuilder.append(" lct_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "cre_name";
        aVar.xrT.put("cre_name", "TEXT");
        stringBuilder.append(" cre_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "lqt_state";
        aVar.xrT.put("lqt_state", "INTEGER");
        stringBuilder.append(" lqt_state INTEGER");
        stringBuilder.append(", ");
        aVar.columns[16] = "paymenu_use_new";
        aVar.xrT.put("paymenu_use_new", "INTEGER");
        stringBuilder.append(" paymenu_use_new INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "is_show_lqb";
        aVar.xrT.put("is_show_lqb", "INTEGER");
        stringBuilder.append(" is_show_lqb INTEGER");
        stringBuilder.append(", ");
        aVar.columns[18] = "is_open_lqb";
        aVar.xrT.put("is_open_lqb", "INTEGER");
        stringBuilder.append(" is_open_lqb INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "lqb_open_url";
        aVar.xrT.put("lqb_open_url", "TEXT");
        stringBuilder.append(" lqb_open_url TEXT");
        aVar.columns[20] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final boolean bMv() {
        return this.field_is_reg == 0;
    }

    public final boolean bMw() {
        return this.field_is_reg == -1;
    }
}
