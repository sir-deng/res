package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.v.a.h;

@a(3)
public class MMSuperAlert extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.gZJ);
        final int intExtra = getIntent().getIntExtra("MMSuperAlert_msg", 0);
        final int intExtra2 = getIntent().getIntExtra("MMSuperAlert_title", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("MMSuperAlert_cancelable", true);
        new ag().postDelayed(new Runnable() {
            public final void run() {
                h.a(MMSuperAlert.this, intExtra == 0 ? "" : MMSuperAlert.this.getString(intExtra), intExtra2 == 0 ? "" : MMSuperAlert.this.getString(intExtra2), booleanExtra, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        MMSuperAlert.this.finish();
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        MMSuperAlert.this.finish();
                    }
                });
            }
        }, 50);
    }

    public static void i(Context context, int i, int i2) {
        Intent intent = new Intent(context, MMSuperAlert.class);
        intent.putExtra("MMSuperAlert_title", i);
        intent.putExtra("MMSuperAlert_msg", i2);
        intent.putExtra("MMSuperAlert_cancelable", false);
        context.startActivity(intent);
    }

    public Resources getResources() {
        if (getAssets() == null || ad.getResources() == null) {
            return super.getResources();
        }
        return ad.getResources();
    }
}
