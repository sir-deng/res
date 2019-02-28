package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.f.b.ec;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;

public final class t extends ec {
    public static a gKN;
    public ArrayList<MallFunction> oqr = new ArrayList();
    private ArrayList<MallNews> oqs = new ArrayList();
    private ArrayList<com.tencent.mm.plugin.wallet_core.model.mall.a> oqt = new ArrayList();
    public SparseArray<String> oqu = new SparseArray();

    static {
        a aVar = new a();
        aVar.hUM = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_region";
        aVar.xrT.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "wallet_region";
        aVar.columns[1] = "function_list";
        aVar.xrT.put("function_list", "TEXT");
        stringBuilder.append(" function_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "new_list";
        aVar.xrT.put("new_list", "TEXT");
        stringBuilder.append(" new_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "banner_list";
        aVar.xrT.put("banner_list", "TEXT");
        stringBuilder.append(" banner_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "type_name_list";
        aVar.xrT.put("type_name_list", "TEXT");
        stringBuilder.append(" type_name_list TEXT");
        aVar.columns[5] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        String str = this.field_function_list;
        String str2 = this.field_new_list;
        String str3 = this.field_banner_list;
        String str4 = this.field_type_name_list;
        try {
            if (!bi.oN(str)) {
                this.oqr = b.y(new JSONArray(str));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e, "", new Object[0]);
        }
        try {
            if (!bi.oN(str2)) {
                this.oqs = b.v(new JSONArray(str2));
            }
        } catch (Throwable e2) {
            this.oqs = null;
            x.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e2, "", new Object[0]);
        }
        try {
            if (!bi.oN(str3)) {
                this.oqt = b.w(new JSONArray(str3));
            }
        } catch (Throwable e22) {
            this.oqt = null;
            x.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e22, "", new Object[0]);
        }
        try {
            if (!bi.oN(str4)) {
                this.oqu = b.x(new JSONArray(str4));
            }
        } catch (Throwable e222) {
            this.oqu = null;
            x.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e222, "", new Object[0]);
        }
    }
}
