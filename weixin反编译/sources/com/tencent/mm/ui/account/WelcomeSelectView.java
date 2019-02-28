package com.tencent.mm.ui.account;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;
import com.tencent.mm.y.bi;

public class WelcomeSelectView extends WelcomeView {
    private Context context;
    private int mHeight = 800;
    private View ogB;
    private Button ybw;
    private Button ybx;
    private TextView yby;

    @TargetApi(11)
    public WelcomeSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ce(context);
    }

    public WelcomeSelectView(Context context) {
        super(context);
        ce(context);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    private void ce(final Context context) {
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(R.i.duu, this);
        this.ogB = inflate.findViewById(R.h.cLb);
        this.ybw = (Button) inflate.findViewById(R.h.cLa);
        this.ybx = (Button) inflate.findViewById(R.h.cLj);
        this.yby = (TextView) inflate.findViewById(R.h.cZy);
        this.ogB.setVisibility(8);
        this.yby.setVisibility(8);
        this.yby.setText(w.g(context, R.c.bqS, R.l.dFG));
        this.mHeight = context.getResources().getDisplayMetrics().heightPixels;
        this.yby.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("not_auth_setting", true);
                intent.putExtra("from_login_history", true);
                a.ihN.r(intent, WelcomeSelectView.this.getContext());
            }
        });
        this.ybw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(context, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                context.startActivity(intent);
            }
        });
        this.ybx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z = true;
                if (d.vHo) {
                    String string = context.getString(R.l.dXX, new Object[]{"0x" + Integer.toHexString(d.vHl), w.cfV()});
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", string);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                    a.ihN.j(intent, context);
                    return;
                }
                String str;
                if (bi.HU().HV() <= 0) {
                    z = false;
                }
                Intent intent2;
                if (z) {
                    intent2 = new Intent(context, RegByMobileRegAIOUI.class);
                    intent2.putExtra("login_type", 0);
                    context.startActivity(intent2);
                    str = "RE200_100";
                } else {
                    intent2 = new Intent(context, MobileInputUI.class);
                    intent2.putExtra("mobile_input_purpose", 2);
                    context.startActivity(intent2);
                    str = "R200_100";
                }
                bi.HU();
                b.jg(20);
                b.oZ(str);
                b.b(false, as.CI() + "," + getClass().getName() + ",R100_100_new," + as.fJ("R100_100_new") + ",2");
                b.oY("R100_100_new");
            }
        });
        String e = w.e(this.context.getSharedPreferences(ad.cgf(), 0));
        this.yby.setText(w.g(this.context, R.c.bqS, R.l.dFG));
        if (e != null && e.equals("language_default")) {
            this.yby.setText(this.context.getString(R.l.etM));
        }
        this.ybw.setText(R.l.epN);
        this.ybx.setText(R.l.epM);
    }

    public final void cph() {
        dh(this.ogB);
        dh(this.yby);
        this.ogB.setVisibility(0);
        this.yby.setVisibility(0);
        ah.y(new Runnable() {
            public final void run() {
                as.CN().a(new be(new be.a() {
                    public final void a(e eVar) {
                    }
                }, "launch normal"), 0);
            }
        });
    }
}
