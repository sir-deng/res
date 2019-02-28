package com.tencent.mm.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.ac;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.ui.base.j;
import com.tencent.mm.ui.base.j.b;

public class PermissionWarningDialog extends MMBaseActivity {
    private i ien = null;

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
            x.e("MicroMsg.PermissionWarningDialog", "Intent is null");
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            x.e("MicroMsg.PermissionWarningDialog", "invalid params");
            return;
        }
        int i = extras.getInt("warning_type", 0);
        a aVar;
        if (1 == i) {
            aVar = new a(this);
            aVar.Zm(extras.getString("warning_title"));
            aVar.Zn(extras.getString("warning_content"));
            aVar.EV(R.l.dFD).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    PermissionWarningDialog.this.finish();
                }
            });
            this.ien = aVar.ale();
            this.ien.setCanceledOnTouchOutside(false);
            this.ien.show();
        } else if (2 == i) {
            aVar = new a(this);
            final boolean z = extras.getBoolean("warning_filter", false);
            final boolean z2 = extras.getBoolean("warning_due2Exception", false);
            aVar.ES(R.l.dGt);
            aVar.Zn(getString(R.l.dGo));
            aVar.EW(R.l.dEy).b(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.ci(z2);
                    PermissionWarningDialog.this.finish();
                }
            });
            aVar.EV(R.l.dGi).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.j(z, z2);
                    PermissionWarningDialog.this.finish();
                }
            });
            this.ien = aVar.ale();
            this.ien.setCanceledOnTouchOutside(false);
            this.ien.show();
        } else if (3 == i) {
            b Zr = new b(this).Zr(getString(R.l.dFP));
            Zr.yix = getString(R.l.dFE);
            Zr.yiw = getString(R.l.dFQ);
            Zr.a(new j.a() {
                public final void cj(boolean z) {
                    if (z) {
                        x.i("MicroMsg.PermissionWarningDialog", "set MicroPhone unmute.");
                        ((AudioManager) ad.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMicrophoneMute(false);
                    }
                    PermissionWarningDialog.this.finish();
                }
            }).pDT.show();
        }
    }

    public static void i(Context context, String str, String str2) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 1);
        intent.putExtra("warning_title", str);
        intent.putExtra("warning_content", str2);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }

    public static void a(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 2);
        intent.putExtra("warning_filter", z);
        intent.putExtra("warning_due2Exception", z2);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }

    public static void bD(Context context) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 3);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
