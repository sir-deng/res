package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.y.as;

public final class e {

    /* renamed from: com.tencent.mm.ui.account.e$1 */
    static class AnonymousClass1 implements c {
        final /* synthetic */ Context val$context;
        final /* synthetic */ int xWL;

        AnonymousClass1(int i, Context context) {
            this.xWL = i;
            this.val$context = context;
        }

        public final void a(n nVar) {
            if ((this.xWL & 1) != 0) {
                nVar.f(1, this.val$context.getString(R.l.eDf));
            }
            if ((this.xWL & 2) != 0) {
                nVar.f(2, this.val$context.getString(R.l.eDg));
            }
            if ((this.xWL & 4) != 0) {
                nVar.f(4, this.val$context.getString(R.l.eDe));
            }
            if ((this.xWL & 8) > 0) {
                nVar.f(8, this.val$context.getString(R.l.eXR));
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.account.e$2 */
    static class AnonymousClass2 implements d {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String xWM = null;
        final /* synthetic */ String xWN = null;
        final /* synthetic */ String xWO = null;

        AnonymousClass2(Context context, String str, String str2, String str3) {
            this.val$context = context;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            String str;
            switch (menuItem.getItemId()) {
                case 1:
                    b.oZ("F100_100_QQ");
                    b.b(true, as.CI() + "," + this.val$context.getClass().getName() + ",F100_100_QQ," + as.fJ("F100_100_QQ") + ",1");
                    e.bo(this.val$context, this.val$context.getString(R.l.eSC));
                    return;
                case 2:
                    b.oZ("F100_100_Email");
                    b.b(true, as.CI() + "," + this.val$context.getClass().getName() + ",F100_100_Email," + as.fJ("F100_100_Email") + ",1");
                    e.bo(this.val$context, this.val$context.getString(R.l.etK));
                    return;
                case 4:
                    Context context = this.val$context;
                    String str2 = this.xWM;
                    str = this.xWN;
                    String str3 = this.xWO;
                    b.oZ("F100_100_phone");
                    b.b(true, as.CI() + "," + context.getClass().getName() + ",F100_100_phone," + as.fJ("F100_100_phone") + ",1");
                    if (com.tencent.mm.protocal.d.vHo) {
                        Toast.makeText(context, context.getString(R.l.dDQ), 0).show();
                        return;
                    }
                    Intent intent = new Intent(context, MobileInputUI.class);
                    if (str != null) {
                        int indexOf = str.indexOf("+");
                        if (indexOf != -1 && str.length() > 0) {
                            str = str.substring(indexOf + 1);
                        }
                        intent.putExtra("couttry_code", str);
                    }
                    if (str2 != null) {
                        intent.putExtra("country_name", str2);
                    }
                    if (str3 != null) {
                        intent.putExtra("bindmcontact_shortmobile", str3);
                    }
                    intent.putExtra("mobile_input_purpose", 1);
                    context.startActivity(intent);
                    return;
                case 8:
                    str = this.val$context.getString(R.l.eXS);
                    if (w.cfV().equals("zh_CN")) {
                        str = str + "zh_CN";
                    } else {
                        str = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=";
                    }
                    e.bo(this.val$context, str);
                    return;
                default:
                    return;
            }
        }
    }

    public static void bo(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
        intent.putExtra("KFromLoginHistory", false);
        com.tencent.mm.bl.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
