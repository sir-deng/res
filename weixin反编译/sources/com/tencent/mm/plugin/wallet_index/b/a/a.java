package com.tencent.mm.plugin.wallet_index.b.a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.plugin.wallet_index.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class a {

    public interface a {
        void a(com.tencent.mm.plugin.wallet_index.c.a aVar, b bVar);
    }

    public static b a(Intent intent, d dVar) {
        com.tencent.mm.plugin.wallet_index.c.a aR;
        if (intent == null) {
            CY("Null data in IAB activity result.");
            aR = com.tencent.mm.plugin.wallet_index.c.a.aR(5, "");
            if (dVar == null) {
                return null;
            }
            dVar.a(aR, null);
            return null;
        }
        int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (intExtra == 0) {
            x.d("MicroMsg.IabResolver", "Successful resultcode from purchase activity.");
            x.d("MicroMsg.IabResolver", "Purchase data: " + stringExtra);
            x.d("MicroMsg.IabResolver", "Data signature: " + stringExtra2);
            x.d("MicroMsg.IabResolver", "Extras: " + intent.getExtras());
            if (stringExtra == null || stringExtra2 == null) {
                CY("BUG: either purchaseData or dataSignature is null.");
                aR = com.tencent.mm.plugin.wallet_index.c.a.aR(5, "");
                if (dVar == null) {
                    return null;
                }
                dVar.a(aR, null);
                return null;
            }
            try {
                c cVar = new c("inapp", stringExtra, stringExtra2);
                stringExtra = cVar.lEs;
                x.d("MicroMsg.IabResolver", "Purchase signature successfully verified.");
                if (dVar != null) {
                    dVar.a(com.tencent.mm.plugin.wallet_index.c.a.aR(0, ""), cVar);
                }
                return new b(stringExtra, cVar);
            } catch (Throwable e) {
                CY("Failed to parse purchase data.");
                x.printErrStackTrace("MicroMsg.IabResolver", e, "", new Object[0]);
                aR = com.tencent.mm.plugin.wallet_index.c.a.aR(5, "");
                if (dVar == null) {
                    return null;
                }
                dVar.a(aR, null);
                return null;
            }
        }
        CY("Purchase failed. Response: " + intExtra);
        aR = com.tencent.mm.plugin.wallet_index.c.a.aR(intExtra, "");
        if (dVar == null) {
            return null;
        }
        dVar.a(aR, null);
        return null;
    }

    public final int a(Intent intent, a aVar) {
        b bVar = new b();
        int Z = Z(intent);
        x.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(Z));
        if (Z != 0) {
            aVar.a(com.tencent.mm.plugin.wallet_index.c.a.aR(Z, ""), null);
            return Z;
        } else if (intent.hasExtra("INAPP_PURCHASE_ITEM_LIST") && intent.hasExtra("INAPP_PURCHASE_DATA_LIST") && intent.hasExtra("INAPP_DATA_SIGNATURE_LIST")) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST");
            ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("INAPP_PURCHASE_DATA_LIST");
            ArrayList stringArrayListExtra3 = intent.getStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST");
            int i = 0;
            while (i < stringArrayListExtra2.size()) {
                try {
                    String str = (String) stringArrayListExtra2.get(i);
                    String str2 = (String) stringArrayListExtra3.get(i);
                    String str3 = "MicroMsg.IabResolver";
                    x.d(str3, "Sku is owned: " + ((String) stringArrayListExtra.get(i)));
                    c cVar = new c("inapp", str, str2);
                    if (TextUtils.isEmpty(cVar.hAU)) {
                        x.w("MicroMsg.IabResolver", "In-app billing warning: " + "BUG: empty/null token!");
                        x.d("MicroMsg.IabResolver", "Purchase data: " + str);
                    }
                    bVar.tgE.put(cVar.lEs, cVar);
                    i++;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.IabResolver", e, "", new Object[0]);
                    aVar.a(com.tencent.mm.plugin.wallet_index.c.a.aR(5, ""), bVar);
                }
            }
            aVar.a(com.tencent.mm.plugin.wallet_index.c.a.aR(0, ""), bVar);
            return 0;
        } else {
            CY("Bundle returned from getPurchases() doesn't contain required fields.");
            aVar.a(com.tencent.mm.plugin.wallet_index.c.a.aR(5, ""), null);
            return 5;
        }
    }

    private static void CY(String str) {
        x.e("MicroMsg.IabResolver", "In-app billing error: " + str);
    }

    public static int Z(Intent intent) {
        if (intent == null) {
            CY("Intent with no response code, assuming OK (known issue)");
            return 1;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            CY("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            CY("Unexpected type for intent response code.");
            CY(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
        }
    }
}
