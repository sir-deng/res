package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.mm.f.b.eg;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.axe;
import com.tencent.mm.protocal.c.bym;
import com.tencent.mm.protocal.c.byp;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.Iterator;

public final class ac extends eg {
    public static a gKN;
    public String oiM = "";
    private axe sVV = new axe();
    public bym sVW = null;
    public byp sVX = null;
    public boolean sVY = false;
    public String sVZ = "";
    public String sWa = "";
    public String sWb = "";
    public String sWc = "";

    static {
        a aVar = new a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_region";
        aVar.xrT.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "wallet_region";
        aVar.columns[1] = "wallet_grey_item_buf";
        aVar.xrT.put("wallet_grey_item_buf", "BLOB");
        stringBuilder.append(" wallet_grey_item_buf BLOB");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public ac() {
        if (this.sVW == null) {
            this.sVW = new bym();
        }
        if (this.sVX == null) {
            this.sVX = new byp();
        }
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.sVV = new axe();
        try {
            this.sVV = (axe) this.sVV.aH(this.field_wallet_grey_item_buf);
            this.sVW = this.sVV.wLh;
            this.sVX = this.sVV.wLi;
            this.sVY = this.sVV.wLj;
            this.sWc = "";
            Iterator it = this.sVV.wLk.iterator();
            while (it.hasNext()) {
                this.sWc += ((String) it.next()) + "\n";
            }
            if (this.sVV.wLf != null) {
                this.sVZ = n.a(this.sVV.wLf.xfM);
                this.sWa = n.a(this.sVV.wLf.xfN);
            }
            if (this.sVV.wLg != null) {
                this.sWb = n.a(this.sVV.wLg.xfK);
                this.oiM = n.a(this.sVV.wLg.xfL);
            }
            x.v("WalletRegionGreyItem", "noticeContent %s", this.sWb);
        } catch (Exception e) {
            x.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
        }
        if (this.sVW == null) {
            this.sVW = new bym();
        }
        if (this.sVX == null) {
            this.sVX = new byp();
        }
    }
}
