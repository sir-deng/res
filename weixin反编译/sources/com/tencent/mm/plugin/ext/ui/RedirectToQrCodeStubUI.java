package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.f.a.ca;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public class RedirectToQrCodeStubUI extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.RedirectToQrCodeStubUI", "hy: start to handle qrcode string");
        String stringExtra = getIntent().getStringExtra("K_STR");
        int intExtra = getIntent().getIntExtra("K_TYPE", -1);
        int intExtra2 = getIntent().getIntExtra("K_VERSION", -1);
        b caVar = new ca();
        caVar.fqV.activity = this;
        caVar.fqV.fpo = stringExtra;
        caVar.fqV.fqW = intExtra;
        caVar.fqV.fqX = intExtra2;
        caVar.fqV.scene = 47;
        a.xmy.m(caVar);
        finish();
    }
}
