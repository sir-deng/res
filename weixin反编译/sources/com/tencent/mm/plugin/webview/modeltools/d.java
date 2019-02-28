package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.f.a.ok;
import com.tencent.mm.f.a.ol;
import com.tencent.mm.f.a.oo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    String tAO = null;
    private a tAP;
    private c tAQ = new c<oo>() {
        {
            this.xmG = oo.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            oo ooVar = (oo) bVar;
            if ((ooVar instanceof oo) && ooVar.fHp.fEo == 1) {
                d.a(d.this, d.this.tAO);
                d.a(d.this);
            }
            return false;
        }
    };
    private c tAR = new c<ok>() {
        {
            this.xmG = ok.class.getName().hashCode();
        }

        private boolean a(ok okVar) {
            if ((okVar instanceof ok) && "bank".equals(d.this.tAO)) {
                if (okVar.fHe.action == 0) {
                    d.a(d.this, d.this.tAO);
                } else if (okVar.fHe.action == 1) {
                    if (bi.oN(okVar.fHe.cardNum)) {
                        d.b(d.this, d.this.tAO);
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bankcard_number", okVar.fHe.cardNum);
                            d.a(d.this, d.this.tAO, jSONObject, null);
                        } catch (JSONException e) {
                            x.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", e);
                            d.b(d.this, d.this.tAO);
                        }
                    }
                }
                d.a(d.this);
            }
            return false;
        }
    };
    private c tAS = new c<ol>() {
        {
            this.xmG = ol.class.getName().hashCode();
        }

        private boolean a(ol olVar) {
            if ((olVar instanceof ol) && d.this.tAO.equalsIgnoreCase(olVar.fHf.cardType)) {
                if (olVar.fHf.fHg == 0) {
                    d.b(d.this, d.this.tAO);
                } else if (olVar.fHf.fHg == 2) {
                    d.a(d.this, d.this.tAO);
                } else {
                    try {
                        if (bi.oN(olVar.fHf.fHh)) {
                            d.a(d.this, d.this.tAO, null, olVar.fHf.fHi);
                        } else {
                            d.a(d.this, d.this.tAO, new JSONObject(olVar.fHf.fHh), olVar.fHf.fHi);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", e.getMessage());
                        d.b(d.this, d.this.tAO);
                    }
                }
                d.a(d.this);
            }
            return false;
        }
    };

    public interface a {
        void LE(String str);

        void Pl(String str);

        void a(String str, JSONObject jSONObject, Bitmap bitmap);
    }

    static /* synthetic */ void a(d dVar) {
        dVar.tAP = null;
        com.tencent.mm.sdk.b.a.xmy.c(dVar.tAQ);
        com.tencent.mm.sdk.b.a.xmy.c(dVar.tAR);
        com.tencent.mm.sdk.b.a.xmy.c(dVar.tAS);
    }

    static /* synthetic */ void a(d dVar, String str) {
        if (dVar.tAP != null) {
            dVar.tAP.Pl(str);
        }
    }

    static /* synthetic */ void a(d dVar, String str, JSONObject jSONObject, Bitmap bitmap) {
        if (dVar.tAP != null) {
            dVar.tAP.a(str, jSONObject, bitmap);
        }
    }

    static /* synthetic */ void b(d dVar, String str) {
        if (dVar.tAP != null) {
            dVar.tAP.LE(str);
        }
    }

    public final boolean a(String str, Context context, a aVar) {
        Intent intent;
        if ("bank".equalsIgnoreCase(str)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 7);
            intent.putExtra("scan_bankcard_with_confirm_ui", true);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bl.d.b(context, "scanner", ".ui.BaseScanUI", intent);
            this.tAP = aVar;
            this.tAO = "bank";
            com.tencent.mm.sdk.b.a.xmy.b(this.tAQ);
            com.tencent.mm.sdk.b.a.xmy.b(this.tAR);
            return true;
        } else if (!"identity_pay_auth".equalsIgnoreCase(str)) {
            return false;
        } else {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 11);
            com.tencent.mm.bl.d.b(context, "scanner", ".ui.BaseScanUI", intent);
            this.tAP = aVar;
            this.tAO = "identity";
            com.tencent.mm.sdk.b.a.xmy.b(this.tAQ);
            com.tencent.mm.sdk.b.a.xmy.b(this.tAS);
            return true;
        }
    }
}
