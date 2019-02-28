package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;

public class FreeWifiTestActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.i.diN);
        findViewById(R.h.cjS).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Toast.makeText(ad.getContext(), "test message", 0).show();
            }
        });
        findViewById(R.h.cjT).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h.a(FreeWifiTestActivity.this, "t12345", "t54331", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, null);
            }
        });
    }
}
