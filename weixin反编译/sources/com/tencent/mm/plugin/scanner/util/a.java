package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.scanner.a.f;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.plugin.scanner.util.n.c;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public final class a implements e {
    public Activity fBA;
    public Bundle frc;
    public ProgressDialog inI;

    /* renamed from: com.tencent.mm.plugin.scanner.util.a$1 */
    class AnonymousClass1 implements OnCancelListener {
        final /* synthetic */ f qeo;

        public AnonymousClass1(f fVar) {
            this.qeo = fVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            a.this.bqc();
            as.CN().c(this.qeo);
        }
    }

    final void bqc() {
        as.CN().b(1061, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        bqc();
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (i == 4 && i2 == -4) {
            h.a(this.fBA, R.l.eBJ, R.l.dGZ, null);
            return;
        }
        Object obj;
        switch (i) {
            case 1:
                if (as.CN().Kt()) {
                    as.CN().getNetworkServerIp();
                    new StringBuilder().append(i2);
                } else if (ab.bC(this.fBA)) {
                    com.tencent.mm.pluginsdk.ui.k.ep(this.fBA);
                } else {
                    Toast.makeText(this.fBA, this.fBA.getString(R.l.eiQ, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                }
                obj = 1;
                break;
            case 2:
                Toast.makeText(this.fBA, this.fBA.getString(R.l.eiR), 1).show();
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            return;
        }
        if (i == 4 && i2 == -2004) {
            h.h(this.fBA, R.l.eBE, R.l.dGZ);
        } else if (i != 0 || i2 != 0) {
            Toast.makeText(this.fBA, this.fBA.getString(R.l.ejr, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        } else if (kVar.getType() == 1061) {
            id bpl = ((f) kVar).bpl();
            if (bpl == null) {
                x.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
                return;
            }
            x.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", Integer.valueOf(bpl.kzz));
            if (!bi.oN(bpl.vUI)) {
                int i3 = bpl.kzz;
                Context context = this.fBA;
                String str2 = bpl.vUI;
                int i4 = ((f) kVar).fqW;
                int i5 = ((f) kVar).fqX;
                e eVar = new e();
                Bundle bundle = this.frc;
                int Jp = n.Jp(str2);
                x.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", Integer.valueOf(Jp));
                Intent intent;
                if (Jp == 1) {
                    c Jq = n.Jq(str2);
                    if (Jq == null || bi.oN(Jq.username)) {
                        x.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                        obj = 2;
                    } else {
                        as.Hm();
                        ag Xv = com.tencent.mm.y.c.Ff().Xv(Jq.username);
                        if (Xv == null || ((int) Xv.gKO) <= 0) {
                            eVar.a(context, Jq.username, 2, i4, i5, null, bundle);
                            obj = 1;
                        } else {
                            intent = new Intent();
                            intent.putExtra("Contact_User", Xv.field_username);
                            intent.setFlags(65536);
                            b.ihN.d(intent, context);
                            obj = null;
                        }
                    }
                } else if (Jp == 2) {
                    n.b Jr = n.Jr(str2);
                    if (Jr == null || bi.oN(Jr.hPT)) {
                        x.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                        obj = 2;
                    } else {
                        x.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", Jr.hPT);
                        if (i3 == 5) {
                            ((com.tencent.mm.plugin.appbrand.n.e) g.h(com.tencent.mm.plugin.appbrand.n.e.class)).b(context, Jr.hPT, 1031, bundle);
                            obj = null;
                        } else {
                            intent = new Intent();
                            intent.putExtra("rawUrl", Jr.hPT);
                            intent.setFlags(65536);
                            b.ihN.j(intent, context);
                            obj = null;
                        }
                    }
                } else if (Jp == 3 || Jp == 4) {
                    x.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", Integer.valueOf(4), Boolean.valueOf(true));
                    intent = new Intent();
                    intent.setClass(context, ProductUI.class);
                    intent.setFlags(65536);
                    intent.putExtra("key_Product_xml", str2);
                    intent.putExtra("key_Product_funcType", 4);
                    intent.putExtra("key_ProductUI_addToDB", true);
                    intent.putExtra("key_need_add_to_history", true);
                    intent.putExtra("key_is_from_barcode", true);
                    context.startActivity(intent);
                    obj = null;
                } else {
                    x.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
                    x.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", str2);
                    obj = 2;
                }
                switch (obj) {
                    case null:
                        x.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
                        return;
                    case 1:
                        x.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                        return;
                    case 2:
                        x.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
