package com.tencent.mm.plugin.hce.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.hce.a.b;
import com.tencent.mm.plugin.nfc.HCEService;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@a(7)
public class HCETransparentUI extends MMActivity {
    private boolean nFT = false;
    private boolean nFU = false;
    private i nFV = null;
    private ProgressDialog nFW = null;
    private boolean nFX = false;
    private int nFY = 0;
    private Timer nFZ;
    private TimerTask nGa;

    static /* synthetic */ void c(HCETransparentUI hCETransparentUI) {
        hCETransparentUI.dismissDialog();
        if (hCETransparentUI.nFZ != null) {
            hCETransparentUI.nFZ.cancel();
        }
    }

    protected final int getLayoutId() {
        return R.i.dlI;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.HCETransparentUI", "alvinluo onResume");
        if (this.nFX) {
            this.nGa = new TimerTask() {
                public final void run() {
                    x.i("MicroMsg.HCETransparentUI", "alvinluo loop check NFC switch currentCount: %d", Integer.valueOf(HCETransparentUI.this.nFY));
                    HCETransparentUI.this.nFY = HCETransparentUI.this.nFY + 1;
                    if (HCETransparentUI.this.nFY > 10) {
                        x.i("MicroMsg.HCETransparentUI", "alvinluo loop check count exceed max limit: %d", Integer.valueOf(10));
                        HCETransparentUI.c(HCETransparentUI.this);
                        HCETransparentUI.this.aTb();
                    } else if (b.aTa()) {
                        x.i("MicroMsg.HCETransparentUI", "alvinluo loopCheck NFC switch is opened, and cancel task");
                        HCETransparentUI.c(HCETransparentUI.this);
                        HCETransparentUI.this.fP(true);
                    }
                }
            };
            this.nFZ = new Timer();
            this.nFZ.scheduleAtFixedRate(this.nGa, 0, 300);
            this.nFW = h.a((Context) this, getString(R.l.dHn), false, null);
            return;
        }
        aTb();
    }

    private void aTb() {
        if (!b.aSZ()) {
            au(13000, "not support NFC");
        } else if (!b.aSY()) {
            au(13002, "not support HCE");
        } else if (b.aTa()) {
            fP(true);
        } else if (this.nFT) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo has shown open NFC dialog");
            k(13001, "system NFC switch not opened", getString(R.l.epp));
        } else {
            boolean z;
            i.a aVar = new i.a(this);
            aVar.ET(R.l.epr).EV(R.l.esG).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    HCETransparentUI.this.startActivityForResult(new Intent("android.settings.NFC_SETTINGS"), 1);
                }
            });
            List queryIntentActivities = getPackageManager().queryIntentActivities(new Intent("android.settings.NFC_SETTINGS"), 65536);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                x.e("MicroMsg.HCETransparentUI", "alvinluo Cannot jump to NFC setting");
                z = false;
            } else {
                x.i("MicroMsg.HCETransparentUI", "alvinluo NFC activity not null, activities size: " + queryIntentActivities.size());
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    x.i("MicroMsg.HCETransparentUI", "alvinluo NFC activity: %s", ((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name);
                }
                z = true;
            }
            if (z) {
                aVar.EW(R.l.dEy).b(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.HCETransparentUI", "alvinluo user click cancel button of NFC tips dialog.");
                        HCETransparentUI.this.av(13001, "system NFC switch not opened");
                    }
                });
            } else {
                aVar.EV(R.l.dGf);
            }
            aVar.d(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    x.i("MicroMsg.HCETransparentUI", "alvinluo cancel by pressing back");
                    HCETransparentUI.this.av(13001, "system NFC switch not opened");
                }
            });
            this.nFV = aVar.ale();
            this.nFV.setCanceledOnTouchOutside(false);
            this.nFV.show();
            this.nFT = true;
        }
    }

    private void k(final int i, final String str, String str2) {
        dismissDialog();
        this.nFV = h.a((Context) this, str2, "", getString(R.l.dGf), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                HCETransparentUI.this.av(i, str);
            }
        });
    }

    private void dismissDialog() {
        if (this.nFV != null && this.nFV.isShowing()) {
            this.nFV.dismiss();
            this.nFV = null;
        }
        if (this.nFW != null) {
            this.nFW.dismiss();
            this.nFW = null;
        }
    }

    private void au(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("errCode", i);
        intent.putExtra("errMsg", str);
        setResult(1, intent);
    }

    @TargetApi(19)
    private void fP(boolean z) {
        CardEmulation instance = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter(this));
        final ComponentName componentName = new ComponentName(this, HCEService.class.getCanonicalName());
        x.i("MicroMsg.HCETransparentUI", "alvinluo component name: " + componentName);
        if (instance.isDefaultServiceForCategory(componentName, "payment")) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo now is NFC Default Application");
            av(0, "NFC switch has opened and now is NFC default application");
            return;
        }
        x.i("MicroMsg.HCETransparentUI", "alvinluo not NFC Default Application, isAutoSet: %b", Boolean.valueOf(true));
        x.i("MicroMsg.HCETransparentUI", "alvinluo request set default NFC application, hasRequestSetDefault: %b", Boolean.valueOf(this.nFU));
        if (this.nFU) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo has request set default NFC application");
            k(13004, "not set default NFC application", getString(R.l.epq));
            return;
        }
        ah.h(new Runnable() {
            public final void run() {
                HCETransparentUI.this.nFU = true;
                Intent intent = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
                intent.putExtra("category", "payment");
                intent.putExtra("component", componentName);
                HCETransparentUI.this.startActivityForResult(intent, 2);
            }
        }, 200);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.HCETransparentUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
            this.nFX = true;
        } else if (i == 2) {
            x.i("MicroMsg.HCETransparentUI", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
        }
    }

    private void av(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("errCode", i);
        intent.putExtra("errMsg", str);
        setResult(-1, intent);
        finish();
    }

    protected void onPause() {
        super.onPause();
        dismissDialog();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
