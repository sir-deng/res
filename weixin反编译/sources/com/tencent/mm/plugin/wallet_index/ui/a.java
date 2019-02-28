package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.b.a.b;
import com.tencent.mm.plugin.wallet_index.b.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.p;
import java.util.ArrayList;
import java.util.List;

public final class a implements b {
    public static long the = 0;
    BroadcastReceiver jle = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE".equals(action)) {
                a.this.thh = com.tencent.mm.plugin.wallet_index.b.a.a.a(intent, a.this.thb);
            } else if ("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE".equals(action)) {
                final boolean booleanExtra = intent.getBooleanExtra("is_direct", true);
                a.this.thg.a(intent, new com.tencent.mm.plugin.wallet_index.b.a.a.a() {
                    public final void a(com.tencent.mm.plugin.wallet_index.c.a aVar, b bVar) {
                        x.d("MicroMsg.GoogleWallet", "Query inventory finished.");
                        if (aVar.isFailure() || bVar == null) {
                            x.w("MicroMsg.GoogleWallet", "Failed to query inventory: " + aVar);
                            return;
                        }
                        x.d("MicroMsg.GoogleWallet", "Query inventory was successful.");
                        a.this.thh = bVar;
                        c c = a.this.thd;
                        c.thp.addAll(new ArrayList(bVar.tgE.keySet()));
                        List<c> arrayList = new ArrayList(bVar.tgE.values());
                        if (arrayList.size() > 0) {
                            for (c cVar : arrayList) {
                                x.i("MicroMsg.GoogleWallet", "do NetSceneVerifyPurchase. productId:" + cVar.lEs + ",billNo:" + cVar.tgJ);
                                g.Dr();
                                g.Dp().gRu.a(a.this.thd.a(cVar, true), 0);
                            }
                            return;
                        }
                        com.tencent.mm.plugin.wallet_index.c.a aR;
                        x.d("MicroMsg.GoogleWallet", "purchases is null. consume null ");
                        if (booleanExtra) {
                            x.d("MicroMsg.GoogleWallet", "result ok");
                            aR = com.tencent.mm.plugin.wallet_index.c.a.aR(0, "");
                        } else {
                            x.d("MicroMsg.GoogleWallet", "unknown_purchase");
                            aR = com.tencent.mm.plugin.wallet_index.c.a.aR(5, "");
                        }
                        if (a.this.thf != null) {
                            a.this.thf.a(aR, null);
                        }
                    }
                });
            }
        }
    };
    String lEs;
    private String tgL;
    String tgM;
    private d thb = null;
    private d thc = null;
    private c thd;
    private d thf;
    private com.tencent.mm.plugin.wallet_index.b.a.a thg;
    private b thh;
    String thi;

    public a(Activity activity, c cVar, d dVar) {
        this.thf = dVar;
        the = 0;
        this.thd = cVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_PAY_RESPONSE");
        activity.registerReceiver(this.jle, intentFilter);
        this.thg = new com.tencent.mm.plugin.wallet_index.b.a.a();
    }

    public final int bOb() {
        return 3;
    }

    public final void a(MMActivity mMActivity, d dVar) {
        this.thb = dVar;
        this.lEs = this.thd.tgQ.pjS;
        this.tgM = this.thd.tgQ.pht;
        this.tgL = this.thd.tgQ.wpq;
        Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_PAY_REQUEST");
        intent.setPackage("com.tencent.mm");
        intent.putExtra("product_id", this.lEs);
        this.thi = this.thd.tgQ.wzu;
        String str = "developer_pay_load";
        String str2 = this.thi;
        String str3 = this.tgM;
        String str4 = this.tgL;
        if (bi.oN(str2)) {
            str2 = "";
        }
        if (bi.oN(str3)) {
            str3 = "";
        }
        if (bi.oN(str4)) {
            str4 = "";
        }
        intent.putExtra(str, str2 + "[#]" + str3 + "[#]" + str4);
        if (mMActivity.getPackageManager().queryIntentActivities(intent, 65536).isEmpty()) {
            x.i("MicroMsg.GoogleWallet", "Try to downloading GWallet Moudle!");
            com.tencent.mm.plugin.wallet_index.c.a aR = com.tencent.mm.plugin.wallet_index.c.a.aR(3, "");
            if (this.thb != null) {
                this.thb.a(aR, null);
                return;
            }
            return;
        }
        the = bi.Wy();
        x.i("MicroMsg.GoogleWallet", "GWallet Found!");
        mMActivity.startActivityForResult(intent, 10001);
    }

    public final void g(MMActivity mMActivity) {
        try {
            mMActivity.unregisterReceiver(this.jle);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.GoogleWallet", e.toString());
        }
        if (!bi.bF(mMActivity)) {
            x.d("MicroMsg.GoogleWallet", "close front UI.");
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
            intent.setPackage("com.tencent.mm");
            mMActivity.sendBroadcast(intent);
        }
        x.d("MicroMsg.GoogleWallet", "Destroying helper.");
    }

    private static void c(MMActivity mMActivity, int i) {
        com.tencent.mm.plugin.wallet_index.c.a aR = com.tencent.mm.plugin.wallet_index.c.a.aR(i, "");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", aR.nFO);
        intent.putExtra("key_err_msg", aR.mMessage);
        intent.putExtra("key_launch_ts", the);
        mMActivity.setResult(-1, intent);
        mMActivity.finish();
    }

    public final boolean a(MMActivity mMActivity, int i, int i2, Intent intent) {
        if (i == 10001) {
            x.i("MicroMsg.GoogleWallet", "purchase flow!result_code: %d", Integer.valueOf(i2));
            if (intent != null) {
                int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
                if (intExtra == 3 || intExtra == 105) {
                    p.c(this.thi, this.lEs, this.tgM, intExtra, "");
                    c(mMActivity, intExtra);
                } else if (intExtra == 100000001) {
                    c(mMActivity, intExtra);
                }
            } else {
                c(mMActivity, 1);
            }
            return true;
        }
        d dVar = this.thc;
        String str = this.thi;
        String str2 = this.lEs;
        String str3 = this.tgM;
        int Z = com.tencent.mm.plugin.wallet_index.b.a.a.Z(intent);
        x.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(Z));
        com.tencent.mm.plugin.wallet_index.c.a aR = com.tencent.mm.plugin.wallet_index.c.a.aR(Z, "");
        p.c(str, str2, str3, Z, aR.mMessage);
        if (dVar != null) {
            dVar.a(aR, null);
        }
        return true;
    }

    public final void c(MMActivity mMActivity, boolean z) {
        x.d("MicroMsg.GoogleWallet", "restorePurchase. Querying inventory.");
        x.d("MicroMsg.GoogleWallet", "is direct? " + z);
        Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST");
        intent.setPackage("com.tencent.mm");
        intent.putExtra("is_direct", z);
        mMActivity.startActivityForResult(intent, 10001);
    }

    public final void a(MMActivity mMActivity, ArrayList<String> arrayList, d dVar, boolean z) {
        this.thc = dVar;
        x.d("MicroMsg.GoogleWallet", "consumePurchase. consume...");
        b bVar = this.thh;
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            c cVar = (c) bVar.tgE.get(str);
            if (cVar != null) {
                arrayList2.add(cVar.hAU);
            }
        }
        if (arrayList2.size() > 0) {
            Intent intent = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
            intent.setPackage("com.tencent.mm");
            intent.putStringArrayListExtra("tokens", arrayList2);
            intent.putExtra("IS_FAILED_CONSUME", z);
            mMActivity.sendBroadcast(intent);
            return;
        }
        com.tencent.mm.plugin.wallet_index.c.a aR = com.tencent.mm.plugin.wallet_index.c.a.aR(0, "");
        if (this.thc != null) {
            this.thc.a(aR, null);
        }
    }
}
