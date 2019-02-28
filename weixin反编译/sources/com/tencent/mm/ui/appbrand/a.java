package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.v;
import java.io.UnsupportedEncodingException;

public final class a {
    public String appId = "";
    Context context;
    com.tencent.mm.ui.widget.g jIJ;
    public WxaExposedParams jRg = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a().acv();
    public boolean klg;
    public int scene;
    public String username;
    h yeg;
    public String yeh = "";

    public class a extends c {
        public a() {
            super();
        }

        public final void a(n nVar) {
            super.a(nVar);
            nVar.f(2, a.this.context.getString(R.l.dEr));
            nVar.f(8, a.this.context.getString(R.l.dEp));
            nVar.f(7, a.a(a.this));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    public class b extends c {
        public b() {
            super();
        }

        public final void a(n nVar) {
            super.a(nVar);
            nVar.f(3, a.this.context.getString(R.l.dEt));
            nVar.f(8, a.this.context.getString(R.l.dEp));
            nVar.f(7, a.a(a.this));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    public class d extends c {
        public d() {
            super();
        }

        public final void a(n nVar) {
            super.a(nVar);
            nVar.f(2, a.this.context.getString(R.l.dEr));
            nVar.f(8, a.this.context.getString(R.l.dEp));
            nVar.f(7, a.a(a.this));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    public class f extends c {
        public f() {
            super();
        }

        public final View cpq() {
            View inflate = v.fw(a.this.context).inflate(R.i.ddb, null);
            ((TextView) inflate.findViewById(R.h.bKP)).setText(a.this.context.getString(R.l.dEq));
            return inflate;
        }

        public final void a(n nVar) {
            super.a(nVar);
            nVar.f(5, a.this.context.getString(R.l.dEh));
            nVar.f(4, a.this.context.getString(R.l.dEo));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    public interface h {
        void a(n nVar);

        View cpq();

        void onMMMenuItemSelected(MenuItem menuItem, int i);
    }

    public class c implements h {
        public View cpq() {
            return null;
        }

        public void a(n nVar) {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMMMenuItemSelected(android.view.MenuItem r11, int r12) {
            /*
            r10 = this;
            r4 = 100;
            r9 = 4;
            r0 = 0;
            r1 = 1;
            r2 = r11.getItemId();
            switch(r2) {
                case 2: goto L_0x0016;
                case 3: goto L_0x0020;
                case 4: goto L_0x002a;
                case 5: goto L_0x0033;
                case 6: goto L_0x0061;
                case 7: goto L_0x0090;
                case 8: goto L_0x00eb;
                default: goto L_0x000c;
            };
        L_0x000c:
            if (r0 == 0) goto L_0x0015;
        L_0x000e:
            r0 = com.tencent.mm.ui.appbrand.a.this;
            r0 = r0.jIJ;
            r0.bxR();
        L_0x0015:
            return;
        L_0x0016:
            r0 = new com.tencent.mm.ui.appbrand.a$c$1;
            r0.<init>();
            com.tencent.mm.sdk.platformtools.ah.h(r0, r4);
            r0 = r1;
            goto L_0x000c;
        L_0x0020:
            r0 = new com.tencent.mm.ui.appbrand.a$c$2;
            r0.<init>();
            com.tencent.mm.sdk.platformtools.ah.h(r0, r4);
            r0 = r1;
            goto L_0x000c;
        L_0x002a:
            r0 = com.tencent.mm.ui.appbrand.a.this;
            r0 = r0.jIJ;
            r0.bxR();
            r0 = r1;
            goto L_0x000c;
        L_0x0033:
            r0 = com.tencent.mm.ui.appbrand.a.this;
            r0 = r0.username;
            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r0 != 0) goto L_0x0144;
        L_0x003d:
            r0 = com.tencent.mm.ui.appbrand.a.this;
            r0 = r0.context;
            r2 = com.tencent.mm.ui.appbrand.a.this;
            r2 = r2.username;
            com.tencent.mm.ui.appbrand.b.i(r0, r2, r1);
            r0 = com.tencent.mm.ui.appbrand.a.this;
            r0 = r0.klg;
            if (r0 == 0) goto L_0x0056;
        L_0x004e:
            r0 = com.tencent.mm.ui.appbrand.a.this;
            r2 = 6;
            com.tencent.mm.ui.appbrand.a.a(r0, r2);
            r0 = r1;
            goto L_0x000c;
        L_0x0056:
            r0 = com.tencent.mm.ui.appbrand.a.this;
            r2 = com.tencent.mm.ui.appbrand.a.this;
            r2 = r2.scene;
            r0.eQ(r2, r9);
            r0 = r1;
            goto L_0x000c;
        L_0x0061:
            r2 = com.tencent.mm.ui.appbrand.a.this;
            r2 = r2.username;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 != 0) goto L_0x0144;
        L_0x006b:
            r2 = com.tencent.mm.ui.appbrand.a.this;
            r2 = r2.context;
            r3 = com.tencent.mm.ui.appbrand.a.this;
            r3 = r3.username;
            com.tencent.mm.ui.appbrand.b.i(r2, r3, r0);
            r0 = com.tencent.mm.ui.appbrand.a.this;
            r0 = r0.klg;
            if (r0 == 0) goto L_0x0083;
        L_0x007c:
            r0 = com.tencent.mm.ui.appbrand.a.this;
            com.tencent.mm.ui.appbrand.a.a(r0, r1);
            r0 = r1;
            goto L_0x000c;
        L_0x0083:
            r0 = com.tencent.mm.ui.appbrand.a.this;
            r2 = com.tencent.mm.ui.appbrand.a.this;
            r2 = r2.scene;
            r3 = 2;
            r0.eQ(r2, r3);
            r0 = r1;
            goto L_0x000c;
        L_0x0090:
            r2 = com.tencent.mm.ui.appbrand.a.this;
            r3 = com.tencent.mm.ui.appbrand.a.this;
            r3 = r3.context;
            r4 = com.tencent.mm.ui.appbrand.a.this;
            r4 = r4.jRg;
            if (r4 != 0) goto L_0x00a8;
        L_0x009c:
            r0 = "MicroMsg.AppBrandSerivceActionSheet";
            r2 = "exportUrlParams is null";
            com.tencent.mm.sdk.platformtools.x.e(r0, r2);
            r0 = r1;
            goto L_0x000c;
        L_0x00a8:
            r5 = "MicroMsg.AppBrandSerivceActionSheet";
            r6 = "exportUrlParams : %s";
            r7 = new java.lang.Object[r1];
            r8 = r4.toString();
            r7[r0] = r8;
            com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
            r0 = r4.username;
            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r0 != 0) goto L_0x00e8;
        L_0x00c1:
            r0 = new android.content.Intent;
            r0.<init>();
            r5 = "key_username";
            r6 = r4.username;
            r0.putExtra(r5, r6);
            r5 = "key_from_scene";
            r0.putExtra(r5, r9);
            r5 = "key_scene_exposed_params";
            r0.putExtra(r5, r4);
            r4 = "appbrand";
            r5 = ".ui.AppBrandProfileUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r0);
            r0 = r2.scene;
            r2.eQ(r0, r1);
        L_0x00e8:
            r0 = r1;
            goto L_0x000c;
        L_0x00eb:
            r2 = com.tencent.mm.ui.appbrand.a.this;
            r3 = new android.content.Intent;
            r3.<init>();
            r0 = r2.jRg;
            r4 = r0.appId;
            r0 = r2.jRg;
            r5 = r0.fDk;
            r0 = r2.jRg;
            r0 = r0.appId;
            r6 = r2.getAppId();
            r0 = r0.equals(r6);
            if (r0 == 0) goto L_0x013f;
        L_0x0108:
            r0 = "";
        L_0x010b:
            r0 = com.tencent.mm.ui.appbrand.a.ak(r4, r5, r0);
            r4 = "MicroMsg.AppBrandSerivceActionSheet";
            r5 = new java.lang.StringBuilder;
            r6 = "KRawUrl ";
            r5.<init>(r6);
            r5 = r5.append(r0);
            r5 = r5.toString();
            com.tencent.mm.sdk.platformtools.x.v(r4, r5);
            r4 = "rawUrl";
            r3.putExtra(r4, r0);
            r0 = "forceHideShare";
            r3.putExtra(r0, r1);
            r0 = r2.context;
            r2 = "webview";
            r4 = ".ui.tools.WebViewUI";
            com.tencent.mm.bl.d.b(r0, r2, r4, r3);
            r0 = r1;
            goto L_0x000c;
        L_0x013f:
            r0 = r2.getAppId();
            goto L_0x010b;
        L_0x0144:
            r0 = r1;
            goto L_0x000c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.appbrand.a.c.onMMMenuItemSelected(android.view.MenuItem, int):void");
        }
    }

    public class e extends c {
        public e() {
            super();
        }

        public final void a(n nVar) {
            super.a(nVar);
            nVar.f(3, a.this.context.getString(R.l.dEt));
            nVar.f(8, a.this.context.getString(R.l.dEp));
            nVar.f(7, a.a(a.this));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    public class g extends c {
        public g() {
            super();
        }

        public final View cpq() {
            View inflate = v.fw(a.this.context).inflate(R.i.ddb, null);
            ((TextView) inflate.findViewById(R.h.bKP)).setText(a.this.context.getString(R.l.dEs));
            return inflate;
        }

        public final void a(n nVar) {
            super.a(nVar);
            nVar.f(6, a.this.context.getString(R.l.dEi));
            nVar.f(4, a.this.context.getString(R.l.dEo));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    static /* synthetic */ String a(a aVar) {
        if (aVar.jRg == null) {
            return "";
        }
        if (bi.oN(aVar.jRg.fqG)) {
            aVar.jRg.fqG = "";
        }
        return aVar.context.getString(R.l.dEa, new Object[]{aVar.jRg.fqG});
    }

    static /* synthetic */ void a(a aVar, int i) {
        if (!bi.oN(aVar.getAppId())) {
            x.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), eventId : %s, appId %s, sceneId %s", Integer.valueOf(13798), Integer.valueOf(i), aVar.appId, aVar.yeh);
            com.tencent.mm.plugin.report.service.g.pWK.h(13798, Integer.valueOf(i), aVar.getAppId(), Integer.valueOf(0), aVar.yeh, Long.valueOf(bi.Wx()));
        }
    }

    public a(Context context) {
        this.context = context;
    }

    public final void show(int i) {
        this.jIJ = new com.tencent.mm.ui.widget.g(this.context, com.tencent.mm.ui.widget.g.zCt, true);
        switch (i) {
            case 1:
                this.yeg = new a();
                break;
            case 2:
                this.yeg = new b();
                break;
            case 3:
                this.yeg = new f();
                break;
            case 4:
                this.yeg = new g();
                break;
            case 5:
                this.yeg = new d();
                break;
            case 6:
                this.yeg = new e();
                break;
            default:
                return;
        }
        if (this.yeg == null) {
            x.e("MicroMsg.AppBrandSerivceActionSheet", "resetTitleView, state is null");
        } else {
            View cpq = this.yeg.cpq();
            if (cpq != null) {
                this.jIJ.dO(cpq);
            }
        }
        this.jIJ.rQF = new com.tencent.mm.ui.base.p.c() {
            public final void a(n nVar) {
                if (a.this.yeg == null) {
                    x.e("MicroMsg.AppBrandSerivceActionSheet", "resetOnCreateMenuListener, state is null");
                } else {
                    a.this.yeg.a(nVar);
                }
            }
        };
        this.jIJ.rQG = new com.tencent.mm.ui.base.p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                if (a.this.yeg == null) {
                    x.e("MicroMsg.AppBrandSerivceActionSheet", "resetOnCreateMenuListener, state is null");
                } else {
                    a.this.yeg.onMMMenuItemSelected(menuItem, i);
                }
            }
        };
        this.jIJ.bUX();
    }

    final String getAppId() {
        if (bi.oN(this.username)) {
            return null;
        }
        if (bi.oN(this.appId)) {
            WxaAttributes rf = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.c.class)).rf(this.username);
            if (rf != null) {
                this.appId = rf.field_appId;
            }
        }
        return this.appId;
    }

    final void eQ(int i, int i2) {
        if (!bi.oN(getAppId())) {
            x.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", Integer.valueOf(13918), this.appId, Integer.valueOf(i), this.yeh, Integer.valueOf(i2));
            com.tencent.mm.plugin.report.service.g.pWK.h(13918, getAppId(), Integer.valueOf(i), this.yeh, Integer.valueOf(i2), Long.valueOf(bi.Wx()));
        }
    }

    public static String ak(String str, String str2, String str3) {
        String str4 = "";
        try {
            return String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&&business_appid=%s#wechat_redirect", new Object[]{p.encode(bi.oM(str), "UTF-8"), p.encode(bi.oM(str2), "UTF-8"), Integer.valueOf(10), p.encode(bi.oM(str3), "UTF-8")});
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.AppBrandSerivceActionSheet", "buildExposeUrl encode fail, invalid arguments");
            return str4;
        }
    }
}
