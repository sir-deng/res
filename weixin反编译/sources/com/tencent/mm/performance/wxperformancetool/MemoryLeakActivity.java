package com.tencent.mm.performance.wxperformancetool;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.bz.b;
import com.tencent.mm.performance.a.a;
import com.tencent.mm.sdk.platformtools.ag;
import java.lang.ref.WeakReference;

@TargetApi(17)
public class MemoryLeakActivity extends Activity {
    private AlertDialog idW;
    private String idX;
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            if (((WeakReference) a.iea.get(MemoryLeakActivity.this.idX)).get() == null) {
                MemoryLeakActivity.this.finish();
            } else {
                MemoryLeakActivity.this.idW.show();
            }
        }
    };

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.daS);
        Builder builder = new Builder(this);
        builder.setTitle("memory leak");
        this.idX = getIntent().getStringExtra("key");
        String stringExtra = getIntent().getStringExtra("tag");
        String stringExtra2 = getIntent().getStringExtra("class");
        if (stringExtra2.contains(" ")) {
            stringExtra2 = stringExtra2.substring(stringExtra2.indexOf(" "));
        }
        final String replace = stringExtra2.replace(".", "_");
        builder.setMessage(stringExtra + stringExtra2 + "\n\npath:" + b.xLy + replace + ".zip");
        builder.setCancelable(true);
        builder.setPositiveButton("dumphprof", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                b.YR(replace);
                if (MemoryLeakActivity.this.idW != null && MemoryLeakActivity.this.idW.isShowing()) {
                    MemoryLeakActivity.this.idW.dismiss();
                }
                MemoryLeakActivity.this.finish();
            }
        });
        builder.setNegativeButton("cancel", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (MemoryLeakActivity.this.idW != null && MemoryLeakActivity.this.idW.isShowing()) {
                    MemoryLeakActivity.this.idW.dismiss();
                }
                MemoryLeakActivity.this.finish();
            }
        });
        builder.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                MemoryLeakActivity.this.finish();
            }
        });
        this.idW = builder.create();
        b.cmc();
        this.mHandler.sendEmptyMessageDelayed(0, 200);
    }

    protected void onDestroy() {
        super.onDestroy();
        a.iea.remove(this.idX);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.idW != null && this.idW.isShowing()) {
            this.idW.dismiss();
            this.idW = null;
        }
    }
}
