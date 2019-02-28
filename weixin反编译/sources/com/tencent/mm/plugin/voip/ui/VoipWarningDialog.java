package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.ac;
import com.tencent.mm.ui.base.i;

public class VoipWarningDialog extends MMBaseActivity {
    public static int syE = 1234;
    private static a syF;
    private i ien = null;

    public interface a {
        void a(VoipWarningDialog voipWarningDialog);

        void b(VoipWarningDialog voipWarningDialog);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Wk();
    }

    protected void onResume() {
        super.onResume();
        ac.a(true, null);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.ien != null) {
            this.ien.dismiss();
            this.ien = null;
        }
        Wk();
    }

    protected void onPause() {
        super.onPause();
        ac.a(false, null);
    }

    private void Wk() {
        if (getIntent() == null) {
            x.e("MicroMsg.VoipWarningDialog", "Intent is null");
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            x.e("MicroMsg.VoipWarningDialog", "invalid params");
            return;
        }
        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this);
        aVar.Zm(getString(R.l.eVC));
        aVar.Zn(extras.getString("warning_content"));
        aVar.d(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                VoipWarningDialog.this.finish();
            }
        });
        aVar.EV(d.fN(23) ? R.l.eVB : R.l.eVA).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (d.fN(23)) {
                    try {
                        if (!bi.oN((String) Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class))) {
                            VoipWarningDialog.this.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + ad.getPackageName())), VoipWarningDialog.syE);
                            return;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.VoipWarningDialog", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", e.getMessage(), e.getClass().getCanonicalName());
                    }
                }
                String string = VoipWarningDialog.this.getString(R.l.eVD);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                com.tencent.mm.bl.d.b(VoipWarningDialog.this, "webview", ".ui.tools.WebViewUI", intent);
                VoipWarningDialog.this.finish();
            }
        });
        this.ien = aVar.ale();
        this.ien.setCanceledOnTouchOutside(false);
        this.ien.show();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (syF != null) {
            if (i != syE) {
                syF.b(this);
            } else if (b.aM(ad.getContext())) {
                syF.a(this);
            } else {
                syF.b(this);
            }
        }
    }

    public static void a(Context context, a aVar) {
        syF = aVar;
        Intent intent = new Intent(context, VoipWarningDialog.class);
        intent.putExtra("warning_content", ad.getContext().getString(R.l.eVz));
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
