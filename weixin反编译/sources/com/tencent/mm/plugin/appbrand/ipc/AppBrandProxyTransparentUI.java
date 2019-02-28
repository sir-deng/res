package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class AppBrandProxyTransparentUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.AppBrandProxyTransparentUI", "onCreate");
        try {
            getIntent().getExtras().setClassLoader(Class.forName(getIntent().getStringExtra("task_class_name")).getClassLoader());
        } catch (ClassNotFoundException e) {
            x.e("MicroMsg.AppBrandProxyTransparentUI", "ClassNotFoundException");
            setResult(1);
            finish();
        }
        final AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask) getIntent().getParcelableExtra("task_object");
        final String stringExtra = getIntent().getStringExtra("task_id");
        if (appBrandProxyTransparentUIProcessTask != null) {
            appBrandProxyTransparentUIProcessTask.a((Context) this, new AppBrandProxyTransparentUIProcessTask.a() {
                public final void afx() {
                    x.i("MicroMsg.AppBrandProxyTransparentUI", "onResult");
                    Intent intent = new Intent();
                    intent.putExtra("task_object", appBrandProxyTransparentUIProcessTask);
                    intent.putExtra("task_id", stringExtra);
                    AppBrandProxyTransparentUI.this.setResult(-1, intent);
                    AppBrandProxyTransparentUI.this.finish();
                }
            });
            return;
        }
        setResult(1);
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.AppBrandProxyTransparentUI", "onDestroy");
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void afw() {
        int intExtra = getIntent().getIntExtra("orientation", -1);
        if (intExtra != -1) {
            setRequestedOrientation(intExtra);
        }
    }
}
