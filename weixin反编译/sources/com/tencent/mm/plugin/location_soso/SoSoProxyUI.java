package com.tencent.mm.plugin.location_soso;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.v;
import com.tencent.tencentmap.mapsdk.map.MapActivity;

@a(19)
public class SoSoProxyUI extends MapActivity {
    protected static final String TAG = "MicroMsg.SoSoProxyUI";
    private com.tencent.mm.plugin.p.a basemapUI;

    public void onCreate(Bundle bundle) {
        boolean z = true;
        x.i(TAG, "SoSoProxyUI onCreate");
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("intent_map_key", -1);
        if (c.a.oem == null) {
            try {
                String str = TAG;
                String str2 = "summerasyncinit not init activity foreground[%b] savedInstanceState[%b], activity[%s, %d]";
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(b.foreground);
                if (bundle == null) {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                objArr[2] = getClass().getSimpleName();
                objArr[3] = Integer.valueOf(hashCode());
                x.e(str, str2, objArr);
                finish();
            } catch (Throwable th) {
                x.printErrStackTrace(TAG, th, "summerasyncinit finish:", new Object[0]);
            }
            g.pWK.a(598, 20, 1, false);
            return;
        }
        this.basemapUI = c.a.oem.e(this, intExtra);
        if (this.basemapUI == null) {
            finish();
            return;
        }
        this.basemapUI.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.e.btT));
        }
    }

    public void onBackPressed() {
        this.basemapUI.onBackPressed();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.basemapUI.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.basemapUI.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || keyEvent.getAction() != 1) {
            return super.onKeyUp(i, keyEvent);
        }
        this.basemapUI.aWZ();
        return true;
    }

    public void onResume() {
        super.onResume();
        this.basemapUI.onResume();
    }

    public void onPause() {
        super.onPause();
        this.basemapUI.onPause();
    }

    public void onDestroy() {
        if (this.basemapUI != null) {
            this.basemapUI.onDestroy();
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.basemapUI.onActivityResult(i, i2, intent);
    }

    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if (getAssets() == null || !"layout_inflater".equals(str)) {
            return systemService;
        }
        return v.b((LayoutInflater) systemService);
    }

    public Resources getResources() {
        if (getAssets() == null || ad.getResources() == null) {
            return super.getResources();
        }
        return ad.getResources();
    }

    public void finish() {
        super.finish();
    }
}
