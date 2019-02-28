package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;

public class RedirectToChattingByPhoneStubUI extends Activity implements e {
    private r mhi = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getString(R.l.dHn);
        this.mhi = h.a((Context) this, "", false, null);
        ah.h(new Runnable() {
            public final void run() {
                RedirectToChattingByPhoneStubUI.this.hideVKB();
            }
        }, 500);
        as.CN().a(106, (e) this);
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(106, (e) this);
        if (this.mhi != null) {
            this.mhi.dismiss();
            this.mhi = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        finish();
    }

    public final boolean hideVKB() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
        x.v("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
        return hideSoftInputFromWindow;
    }
}
