package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.gu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public abstract class AutoLoginActivity extends MMActivity {

    public enum a {
        LOGIN_OK,
        LOGIN_FAIL,
        LOGIN_CANCEL
    }

    public abstract void a(a aVar, Intent intent);

    public abstract boolean z(Intent intent);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(8);
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
            finish();
            return;
        }
        d.cdJ();
        x.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + intent.getAction());
        int a = t.a(intent, "wizard_activity_result_code", -2);
        x.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = " + a);
        if (a != -2) {
            Ch(a);
        } else if (!z(intent)) {
            x.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
            finish();
        } else if (bgf()) {
            finish();
            x.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
        } else {
            a(a.LOGIN_OK, intent);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            super.onNewIntent(intent);
            setIntent(intent);
            int a = t.a(intent, "wizard_activity_result_code", 0);
            x.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = " + a);
            Ch(a);
        }
    }

    private void Ch(int i) {
        switch (i) {
            case -1:
                a(a.LOGIN_OK, getIntent());
                return;
            case 0:
                bgf();
                return;
            case 1:
                a(a.LOGIN_CANCEL, getIntent());
                return;
            default:
                x.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = " + i);
                a(a.LOGIN_FAIL, getIntent());
                return;
        }
    }

    public boolean bgf() {
        g.Do();
        if (com.tencent.mm.kernel.a.CE() && !com.tencent.mm.kernel.a.Cz()) {
            return false;
        }
        x.w("MicroMsg.AutoLoginActivity", "not login");
        Intent intent = new Intent(this, getClass());
        intent.putExtras(getIntent());
        intent.addFlags(67108864);
        intent.setDataAndType(getIntent().getData(), getIntent().getType());
        intent.setAction(getIntent().getAction());
        Intent intent2 = new Intent();
        intent2.putExtras(getIntent());
        d.a((Context) this, "accountsync", "com.tencent.mm.ui.account.SimpleLoginUI", intent2, intent);
        return true;
    }

    public static void a(Context context, f fVar, String str, int i) {
        Signature[] aX = p.aX(context, str);
        Object obj = "";
        if (aX != null && aX.length > 0) {
            int length = aX.length;
            int i2 = 0;
            while (i2 < length) {
                i2++;
                String str2 = obj + p.Sp(com.tencent.mm.a.g.s(aX[i2].toByteArray())) + "|";
            }
        }
        if (obj.length() > 1) {
            obj = obj.substring(0, obj.length() - 1);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("raw_package_name", bi.aD(str, ""));
            jSONObject.put("package_name", bi.aD(fVar.field_packageName, ""));
            jSONObject.put("raw_signature", obj);
            jSONObject.put("signature", bi.aD(fVar.field_signature, ""));
            jSONObject.put("scene", i);
        } catch (Exception e) {
            x.i("MicroMsg.AutoLoginActivity", "doIfAppInValid, jsonException = " + e.getMessage());
        }
        b guVar = new gu();
        guVar.fxN.appId = fVar.field_appId;
        guVar.fxN.opType = 3;
        guVar.fxN.fra = jSONObject.toString();
        com.tencent.mm.sdk.b.a.xmy.m(guVar);
    }

    public int getLayoutId() {
        return -1;
    }
}
