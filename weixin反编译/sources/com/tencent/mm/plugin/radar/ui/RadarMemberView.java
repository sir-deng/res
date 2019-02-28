package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.protocal.c.bbr;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.x;
import java.util.Arrays;

public final class RadarMemberView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ b.e.d[] pDC = new b.e.d[]{b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "avatarHolder", "getAvatarHolder()Landroid/view/View;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "avatarCopy", "getAvatarCopy()Landroid/widget/ImageView;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "avatarCopyContainer", "getAvatarCopyContainer()Landroid/view/View;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "confirmBtn", "getConfirmBtn()Landroid/widget/Button;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "confirmBtnDisabled", "getConfirmBtnDisabled()Landroid/widget/TextView;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "memberNameTv", "getMemberNameTv()Landroid/widget/TextView;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "modifyNameBtn", "getModifyNameBtn()Landroid/widget/Button;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "sayHiTv", "getSayHiTv()Landroid/widget/TextView;")), b.c.b.j.a(new b.c.b.i(b.c.b.j.R(RadarMemberView.class), "exposeTv", "getExposeTv()Landroid/widget/TextView;"))};
    private static final int pDW = 0;
    private static final int pDX = 1;
    public static final a pDY = new a();
    private x jQP;
    private TextView mVG;
    private View pDD;
    private final b.b pDE = i.C(this, com.tencent.mm.plugin.radar.a.c.pBt);
    private final b.b pDF = i.C(this, com.tencent.mm.plugin.radar.a.c.pBg);
    private final b.b pDG = i.C(this, com.tencent.mm.plugin.radar.a.c.pBf);
    private final b.b pDH = i.C(this, com.tencent.mm.plugin.radar.a.c.pBi);
    private final b.b pDI = i.C(this, com.tencent.mm.plugin.radar.a.c.pBj);
    private final b.b pDJ = i.C(this, com.tencent.mm.plugin.radar.a.c.pBn);
    private final b.b pDK = i.C(this, com.tencent.mm.plugin.radar.a.c.pBm);
    private final b.b pDL = i.C(this, com.tencent.mm.plugin.radar.a.c.pBz);
    private int[] pDM;
    private final b.b pDN = i.C(this, com.tencent.mm.plugin.radar.a.c.pBe);
    private boolean pDO;
    private bf pDP;
    b pDQ;
    private final OnClickListener pDR = new h(this);
    private final d pDS = new d(this);
    private com.tencent.mm.ui.base.i pDT;
    private View pDU;
    private TextView pDV;
    bbr pDg;
    com.tencent.mm.plugin.radar.b.c.e pDh;
    private EditText pwv;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public interface b {
        void a(bbr bbr, com.tencent.mm.plugin.radar.b.c.e eVar);

        void b(bbr bbr, com.tencent.mm.plugin.radar.b.c.e eVar);
    }

    public static final class c implements AnimationListener {
        final /* synthetic */ RadarMemberView pDZ;

        c(RadarMemberView radarMemberView) {
            this.pDZ = radarMemberView;
        }

        public final void onAnimationStart(Animation animation) {
            b.c.b.e.i(animation, "animation");
        }

        public final void onAnimationRepeat(Animation animation) {
            b.c.b.e.i(animation, "animation");
        }

        public final void onAnimationEnd(Animation animation) {
            b.c.b.e.i(animation, "animation");
            a aVar = RadarMemberView.pDY;
            com.tencent.mm.sdk.platformtools.x.d(RadarMemberView.TAG, "dismiss animation end");
            this.pDZ.pDO = false;
            d d = this.pDZ.pDS;
            a aVar2 = RadarMemberView.pDY;
            d.sendEmptyMessage(RadarMemberView.pDX);
        }
    }

    static final class e implements OnClickListener {
        final /* synthetic */ RadarMemberView pDZ;
        final /* synthetic */ bbr pEa;

        e(RadarMemberView radarMemberView, bbr bbr) {
            this.pDZ = radarMemberView;
            this.pEa = bbr;
        }

        public final void onClick(View view) {
            if (this.pDZ.pDh != null && this.pDZ.pDQ != null) {
                b a = this.pDZ.pDQ;
                if (a != null) {
                    a.a(this.pEa, this.pDZ.pDh);
                }
                this.pDZ.dismiss();
            }
        }
    }

    public static final class d extends ag {
        final /* synthetic */ RadarMemberView pDZ;

        d(RadarMemberView radarMemberView) {
            this.pDZ = radarMemberView;
        }

        public final void handleMessage(Message message) {
            b.c.b.e.i(message, "msg");
            int i = message.what;
            a aVar = RadarMemberView.pDY;
            if (i == RadarMemberView.pDW) {
                RadarMemberView radarMemberView = this.pDZ;
                bbr bbr = this.pDZ.pDg;
                radarMemberView.a(this.pDZ.pDh);
                return;
            }
            i = message.what;
            aVar = RadarMemberView.pDY;
            if (i == RadarMemberView.pDX) {
                this.pDZ.setVisibility(4);
                this.pDZ.reset();
                View k = this.pDZ.pDD;
                if (k != null) {
                    k.setVisibility(0);
                }
                b a = this.pDZ.pDQ;
                if (a != null) {
                    a.b(this.pDZ.pDg, this.pDZ.pDh);
                }
            }
        }
    }

    public static final class i implements AnimationListener {
        final /* synthetic */ RadarMemberView pDZ;

        i(RadarMemberView radarMemberView) {
            this.pDZ = radarMemberView;
        }

        public final void onAnimationStart(Animation animation) {
            b.c.b.e.i(animation, "animation");
        }

        public final void onAnimationRepeat(Animation animation) {
            b.c.b.e.i(animation, "animation");
        }

        public final void onAnimationEnd(Animation animation) {
            b.c.b.e.i(animation, "animation");
            a aVar = RadarMemberView.pDY;
            com.tencent.mm.sdk.platformtools.x.d(RadarMemberView.TAG, "popup animation end");
            d d = this.pDZ.pDS;
            a aVar2 = RadarMemberView.pDY;
            d.sendEmptyMessage(RadarMemberView.pDW);
        }
    }

    public static final class j implements TextWatcher {
        final /* synthetic */ RadarMemberView pDZ;

        j(RadarMemberView radarMemberView) {
            this.pDZ = radarMemberView;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            b.c.b.e.i(charSequence, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            b.c.b.e.i(charSequence, "s");
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = false;
            b.c.b.e.i(editable, "s");
            int length = 50 - editable.length();
            if (length < 0) {
                length = 0;
            }
            TextView f = this.pDZ.pDV;
            if (f != null) {
                f.setText(String.valueOf(length));
            }
            com.tencent.mm.ui.base.i g = this.pDZ.pDT;
            if (g != null) {
                Button button = g.getButton(-1);
                if (button != null) {
                    if (editable.length() > 0) {
                        z = true;
                    }
                    button.setEnabled(z);
                }
            }
        }
    }

    static final class l implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarMemberView pDZ;

        l(RadarMemberView radarMemberView) {
            this.pDZ = radarMemberView;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            com.tencent.mm.ui.base.i g = this.pDZ.pDT;
            if (g != null) {
                g.dismiss();
            }
            this.pDZ.pDT = null;
        }
    }

    static final class g implements OnClickListener {
        final /* synthetic */ RadarMemberView pDZ;

        g(RadarMemberView radarMemberView) {
            this.pDZ = radarMemberView;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            String str = "k_username";
            x c = this.pDZ.jQP;
            intent.putExtra(str, c != null ? c.getUsername() : null);
            intent.putExtra("showShare", false);
            b.c.b.l lVar = b.c.b.l.AEg;
            Object format = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[]{Integer.valueOf(38)}, 1));
            b.c.b.e.h(format, "java.lang.String.format(format, *args)");
            intent.putExtra("rawUrl", format);
            com.tencent.mm.bl.d.b(this.pDZ.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    static final class k implements Runnable {
        final /* synthetic */ RadarMemberView pDZ;

        k(RadarMemberView radarMemberView) {
            this.pDZ = radarMemberView;
        }

        public final void run() {
            if (this.pDZ.getContext() instanceof Activity) {
                a aVar = RadarMemberView.pDY;
                Context context = this.pDZ.getContext();
                if (context == null) {
                    throw new b.i("null cannot be cast to non-null type android.app.Activity");
                }
                Activity activity = (Activity) context;
                b.c.b.e.i(activity, "ac");
                Object systemService = activity.getSystemService("input_method");
                if (!(systemService instanceof InputMethodManager)) {
                    systemService = null;
                }
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                if (inputMethodManager != null) {
                    View currentFocus = activity.getCurrentFocus();
                    if (currentFocus != null && currentFocus.getWindowToken() != null) {
                        inputMethodManager.toggleSoftInput(0, 2);
                    }
                }
            }
        }
    }

    static final class m implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarMemberView pDZ;

        m(RadarMemberView radarMemberView) {
            this.pDZ = radarMemberView;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.pDZ.pDT != null) {
                com.tencent.mm.ui.base.i g = this.pDZ.pDT;
                if (g != null) {
                    g.dismiss();
                }
                this.pDZ.pDT = null;
            }
            RadarMemberView.i(this.pDZ);
        }
    }

    static final class f implements OnTouchListener {
        final /* synthetic */ RadarMemberView pDZ;

        f(RadarMemberView radarMemberView) {
            this.pDZ = radarMemberView;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (view != this.pDZ.bmh()) {
                b.c.b.e.h((Object) motionEvent, "event");
                if (motionEvent.getAction() == 1 && this.pDZ.isShowing()) {
                    this.pDZ.dismiss();
                }
            }
            return true;
        }
    }

    static final class h implements OnClickListener {
        final /* synthetic */ RadarMemberView pDZ;

        h(RadarMemberView radarMemberView) {
            this.pDZ = radarMemberView;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r7) {
            /*
            r6 = this;
            r3 = 0;
            r4 = 1;
            r2 = 0;
            r1 = "";
            r0 = r6.pDZ;
            r0 = r0.jQP;
            if (r0 == 0) goto L_0x0029;
        L_0x000e:
            r0 = r6.pDZ;
            r0 = r0.jQP;
            if (r0 == 0) goto L_0x0053;
        L_0x0016:
            r0 = r0.AJ();
            if (r0 != r4) goto L_0x0053;
        L_0x001c:
            r0 = r6.pDZ;
            r0 = r0.jQP;
            if (r0 == 0) goto L_0x0051;
        L_0x0024:
            r0 = r0.vV();
        L_0x0028:
            r1 = r0;
        L_0x0029:
            r0 = r1;
            r0 = (java.lang.CharSequence) r0;
            if (r0 == 0) goto L_0x0034;
        L_0x002e:
            r0 = b.f.g.Y(r0);
            if (r0 == 0) goto L_0x00d5;
        L_0x0034:
            r0 = r4;
        L_0x0035:
            if (r0 == 0) goto L_0x0046;
        L_0x0037:
            r0 = r6.pDZ;
            r0 = r0.pDg;
            if (r0 == 0) goto L_0x0046;
        L_0x003d:
            r0 = r6.pDZ;
            r0 = r0.pDg;
            if (r0 == 0) goto L_0x0045;
        L_0x0043:
            r2 = r0.kzN;
        L_0x0045:
            r1 = r2;
        L_0x0046:
            r0 = r6.pDZ;
            if (r1 != 0) goto L_0x004d;
        L_0x004a:
            r1 = "";
        L_0x004d:
            com.tencent.mm.plugin.radar.ui.RadarMemberView.a(r0, r1);
            return;
        L_0x0051:
            r0 = r2;
            goto L_0x0028;
        L_0x0053:
            r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
            r0 = com.tencent.mm.kernel.g.h(r0);
            r5 = "service(IMessengerStorage::class.java)";
            b.c.b.e.h(r0, r5);
            r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
            r5 = r0.Fg();
            r0 = r6.pDZ;
            r0 = r0.jQP;
            if (r0 == 0) goto L_0x00cb;
        L_0x006d:
            r0 = r0.getUsername();
        L_0x0071:
            r5 = r5.FF(r0);
            if (r5 == 0) goto L_0x0088;
        L_0x0077:
            r0 = r5.vZ();
            r0 = (java.lang.CharSequence) r0;
            if (r0 == 0) goto L_0x0085;
        L_0x007f:
            r0 = b.f.g.Y(r0);
            if (r0 == 0) goto L_0x00cd;
        L_0x0085:
            r0 = r4;
        L_0x0086:
            if (r0 == 0) goto L_0x00d8;
        L_0x0088:
            r0 = r6.pDZ;
            r0 = r0.jQP;
            if (r0 == 0) goto L_0x00cf;
        L_0x0090:
            r0 = r0.vZ();
        L_0x0094:
            r0 = (java.lang.CharSequence) r0;
            if (r0 == 0) goto L_0x009e;
        L_0x0098:
            r0 = b.f.g.Y(r0);
            if (r0 == 0) goto L_0x00d1;
        L_0x009e:
            r0 = r4;
        L_0x009f:
            if (r0 != 0) goto L_0x00d8;
        L_0x00a1:
            r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
            r0 = com.tencent.mm.kernel.g.h(r0);
            r5 = "service(IMessengerStorage::class.java)";
            b.c.b.e.h(r0, r5);
            r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
            r5 = r0.Fg();
            r0 = r6.pDZ;
            r0 = r0.jQP;
            if (r0 == 0) goto L_0x00d3;
        L_0x00bb:
            r0 = r0.vZ();
        L_0x00bf:
            r0 = r5.FF(r0);
        L_0x00c3:
            if (r0 == 0) goto L_0x0029;
        L_0x00c5:
            r1 = r0.vV();
            goto L_0x0029;
        L_0x00cb:
            r0 = r2;
            goto L_0x0071;
        L_0x00cd:
            r0 = r3;
            goto L_0x0086;
        L_0x00cf:
            r0 = r2;
            goto L_0x0094;
        L_0x00d1:
            r0 = r3;
            goto L_0x009f;
        L_0x00d3:
            r0 = r2;
            goto L_0x00bf;
        L_0x00d5:
            r0 = r3;
            goto L_0x0035;
        L_0x00d8:
            r0 = r5;
            goto L_0x00c3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarMemberView.h.onClick(android.view.View):void");
        }
    }

    private final View bmf() {
        return (View) this.pDE.getValue();
    }

    private final View bmg() {
        return (View) this.pDG.getValue();
    }

    private final Button bmh() {
        return (Button) this.pDH.getValue();
    }

    private final TextView bmi() {
        return (TextView) this.pDI.getValue();
    }

    private final TextView bmj() {
        return (TextView) this.pDJ.getValue();
    }

    private final Button bmk() {
        return (Button) this.pDK.getValue();
    }

    private final TextView bml() {
        return (TextView) this.pDL.getValue();
    }

    private final TextView bmm() {
        return (TextView) this.pDN.getValue();
    }

    public static final /* synthetic */ void a(RadarMemberView radarMemberView, String str) {
        radarMemberView.pDU = View.inflate(radarMemberView.getContext(), com.tencent.mm.plugin.radar.a.d.drZ, null);
        View view = radarMemberView.pDU;
        radarMemberView.mVG = view != null ? (TextView) view.findViewById(com.tencent.mm.plugin.radar.a.c.cLI) : null;
        TextView textView = radarMemberView.mVG;
        if (textView != null) {
            textView.setText("");
        }
        view = radarMemberView.pDU;
        radarMemberView.pwv = view != null ? (EditText) view.findViewById(com.tencent.mm.plugin.radar.a.c.cLH) : null;
        view = radarMemberView.pDU;
        radarMemberView.pDV = view != null ? (TextView) view.findViewById(com.tencent.mm.plugin.radar.a.c.cZN) : null;
        TextView textView2 = radarMemberView.pDV;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        EditText editText = radarMemberView.pwv;
        if (editText != null) {
            editText.setText(str);
        }
        TextView textView3 = radarMemberView.pDV;
        if (textView3 != null) {
            textView3.setText("50");
        }
        editText = radarMemberView.pwv;
        if (editText != null) {
            editText.setFilters(com.tencent.mm.pluginsdk.ui.tools.h.vEv);
        }
        EditText editText2 = radarMemberView.pwv;
        if (editText2 != null) {
            editText2.addTextChangedListener(new j(radarMemberView));
        }
        radarMemberView.pDT = com.tencent.mm.ui.base.h.a(radarMemberView.getContext(), radarMemberView.getContext().getString(com.tencent.mm.plugin.radar.a.f.pBU), radarMemberView.pDU, (DialogInterface.OnClickListener) new m(radarMemberView), (DialogInterface.OnClickListener) new l(radarMemberView));
        editText2 = radarMemberView.pwv;
        if (editText2 != null) {
            editText2.post(new k(radarMemberView));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ boolean i(com.tencent.mm.plugin.radar.ui.RadarMemberView r9) {
        /*
        r2 = 0;
        r6 = 1;
        r5 = 0;
        r0 = r9.pwv;
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        r0 = r5;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = r9.pwv;
        if (r0 == 0) goto L_0x0033;
    L_0x000d:
        r0 = r0.getText();
    L_0x0011:
        r0 = java.lang.String.valueOf(r0);
        r0 = (java.lang.CharSequence) r0;
        r1 = r0.length();
        r4 = r1 + -1;
        r7 = r5;
        r3 = r5;
    L_0x001f:
        if (r3 > r4) goto L_0x0041;
    L_0x0021:
        if (r7 != 0) goto L_0x0035;
    L_0x0023:
        r1 = r3;
    L_0x0024:
        r1 = r0.charAt(r1);
        r8 = 32;
        if (r1 > r8) goto L_0x0037;
    L_0x002c:
        r1 = r6;
    L_0x002d:
        if (r7 != 0) goto L_0x003c;
    L_0x002f:
        if (r1 != 0) goto L_0x0039;
    L_0x0031:
        r7 = r6;
        goto L_0x001f;
    L_0x0033:
        r0 = r2;
        goto L_0x0011;
    L_0x0035:
        r1 = r4;
        goto L_0x0024;
    L_0x0037:
        r1 = r5;
        goto L_0x002d;
    L_0x0039:
        r3 = r3 + 1;
        goto L_0x001f;
    L_0x003c:
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r4 = r4 + -1;
        goto L_0x001f;
    L_0x0041:
        r1 = r4 + 1;
        r0 = r0.subSequence(r3, r1);
        r1 = r0.toString();
        r0 = r9.pDg;
        if (r0 == 0) goto L_0x0057;
    L_0x004f:
        r3 = com.tencent.mm.plugin.radar.ui.g.pFl;
        r0 = com.tencent.mm.plugin.radar.ui.g.b(r0);
        if (r0 != 0) goto L_0x0149;
    L_0x0057:
        r0 = "";
        r3 = r0;
    L_0x005b:
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r0 == 0) goto L_0x0063;
    L_0x0061:
        r0 = r5;
        goto L_0x0008;
    L_0x0063:
        r0 = r9.jQP;
        if (r0 == 0) goto L_0x0123;
    L_0x0067:
        r0 = r0.AJ();
        if (r0 != r6) goto L_0x0123;
    L_0x006d:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r3 = "service(IMessengerStorage::class.java)";
        b.c.b.e.h(r0, r3);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r3 = r0.Fg();
        r0 = r9.jQP;
        if (r0 == 0) goto L_0x0119;
    L_0x0083:
        r0 = r0.getUsername();
    L_0x0087:
        r3 = r3.FF(r0);
        if (r3 == 0) goto L_0x009e;
    L_0x008d:
        r0 = r3.vZ();
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x009b;
    L_0x0095:
        r0 = b.f.g.Y(r0);
        if (r0 == 0) goto L_0x011c;
    L_0x009b:
        r0 = r6;
    L_0x009c:
        if (r0 == 0) goto L_0x0147;
    L_0x009e:
        r0 = r9.jQP;
        if (r0 == 0) goto L_0x011f;
    L_0x00a2:
        r0 = r0.vZ();
    L_0x00a6:
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x00b0;
    L_0x00aa:
        r0 = b.f.g.Y(r0);
        if (r0 == 0) goto L_0x0121;
    L_0x00b0:
        r0 = r6;
    L_0x00b1:
        if (r0 != 0) goto L_0x0147;
    L_0x00b3:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r3 = "service(IMessengerStorage::class.java)";
        b.c.b.e.h(r0, r3);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Fg();
        r3 = r9.jQP;
        if (r3 == 0) goto L_0x00cd;
    L_0x00c9:
        r2 = r3.vZ();
    L_0x00cd:
        r0 = r0.FF(r2);
        r2 = r0;
    L_0x00d2:
        if (r2 == 0) goto L_0x00fe;
    L_0x00d4:
        r0 = r2.vZ();
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x00e2;
    L_0x00dc:
        r0 = b.f.g.Y(r0);
        if (r0 == 0) goto L_0x00e3;
    L_0x00e2:
        r5 = r6;
    L_0x00e3:
        if (r5 != 0) goto L_0x00fe;
    L_0x00e5:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r3 = "service(IMessengerStorage::class.java)";
        b.c.b.e.h(r0, r3);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.Fg();
        r2 = r2.vZ();
        r0.FG(r2);
    L_0x00fe:
        r0 = r9.jQP;
        if (r0 == 0) goto L_0x0105;
    L_0x0102:
        r0.da(r1);
    L_0x0105:
        r0 = r9.jQP;
        com.tencent.mm.y.s.b(r0, r1);
    L_0x010a:
        r2 = r9.bmj();
        if (r2 == 0) goto L_0x0116;
    L_0x0110:
        r0 = r1;
        r0 = (java.lang.CharSequence) r0;
        r2.setText(r0);
    L_0x0116:
        r0 = r6;
        goto L_0x0008;
    L_0x0119:
        r0 = r2;
        goto L_0x0087;
    L_0x011c:
        r0 = r5;
        goto L_0x009c;
    L_0x011f:
        r0 = r2;
        goto L_0x00a6;
    L_0x0121:
        r0 = r5;
        goto L_0x00b1;
    L_0x0123:
        r0 = r9.jQP;
        if (r0 == 0) goto L_0x012a;
    L_0x0127:
        r0.da(r1);
    L_0x012a:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r2 = "service(IMessengerStorage::class.java)";
        b.c.b.e.h(r0, r2);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r2 = r0.Fg();
        r0 = new com.tencent.mm.storage.bf;
        r0.<init>(r3, r1);
        r0 = (com.tencent.mm.sdk.e.c) r0;
        r2.a(r0);
        goto L_0x010a;
    L_0x0147:
        r2 = r3;
        goto L_0x00d2;
    L_0x0149:
        r3 = r0;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarMemberView.i(com.tencent.mm.plugin.radar.ui.RadarMemberView):boolean");
    }

    public final boolean isShowing() {
        return getVisibility() == 0;
    }

    public RadarMemberView(Context context, AttributeSet attributeSet) {
        b.c.b.e.i(context, "context");
        b.c.b.e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarMemberView(Context context, AttributeSet attributeSet, int i) {
        b.c.b.e.i(context, "context");
        b.c.b.e.i(attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    public final void c(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        Object obj = null;
        b.c.b.e.i(str, "username");
        b.c.b.e.i(eVar, "state");
        if (isShowing() && !this.pDO) {
            Object obj2;
            bbr bbr = this.pDg;
            if (bbr != null) {
                obj2 = bbr.wjz;
            } else {
                obj2 = null;
            }
            if (!b.c.b.e.h((Object) str, obj2)) {
                bbr = this.pDg;
                if (bbr != null) {
                    obj = bbr.kyG;
                }
                if (!b.c.b.e.h((Object) str, obj)) {
                    return;
                }
            }
            a(eVar);
        }
    }

    private final void a(com.tencent.mm.plugin.radar.b.c.e eVar) {
        bmm().setVisibility(0);
        if (eVar != null) {
            switch (c.pDt[eVar.ordinal()]) {
                case 1:
                    bmj().setVisibility(0);
                    bmk().setVisibility(0);
                    bmh().setText(com.tencent.mm.plugin.radar.a.f.pBX);
                    bmh().setVisibility(0);
                    bmi().setVisibility(8);
                    bml().setVisibility(8);
                    return;
                case 2:
                    bmj().setVisibility(0);
                    bmk().setVisibility(0);
                    bmi().setText(com.tencent.mm.plugin.radar.a.f.pCa);
                    bmh().setVisibility(8);
                    bmi().setVisibility(0);
                    bml().setVisibility(8);
                    return;
                case 3:
                    bmj().setVisibility(0);
                    bmk().setVisibility(0);
                    bmi().setText(com.tencent.mm.plugin.radar.a.f.pBR);
                    bmh().setVisibility(8);
                    bmi().setVisibility(0);
                    bml().setVisibility(8);
                    return;
                case 4:
                    bmj().setVisibility(0);
                    bmk().setVisibility(0);
                    bmh().setText(com.tencent.mm.plugin.radar.a.f.pBQ);
                    bmh().setVisibility(0);
                    bmi().setVisibility(8);
                    bml().setText(getContext().getString(com.tencent.mm.plugin.radar.a.f.pBz));
                    bml().setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(View view, bbr bbr, com.tencent.mm.plugin.radar.b.c.e eVar) {
        Object h;
        String vV;
        b.c.b.e.i(view, "view");
        b.c.b.e.i(bbr, "member");
        com.tencent.mm.sdk.platformtools.x.d(TAG, "popup");
        this.pDh = eVar;
        this.pDg = bbr;
        Button bmh = bmh();
        if (bmh != null) {
            bmh.setOnClickListener(new e(this, bbr));
        }
        bmk().setOnClickListener(this.pDR);
        setOnTouchListener(new f(this));
        bmm().setOnClickListener(new g(this));
        g gVar = g.pFl;
        String b = g.b(bbr);
        if (!b.f.g.Y(b)) {
            h = com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
            b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
            this.jQP = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).Ff().Xv(b);
        }
        x xVar = this.jQP;
        if (xVar == null || !xVar.AJ()) {
            h = com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
            b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
            this.pDP = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).Fg().FF(b);
            bf bfVar = this.pDP;
            vV = bfVar != null ? bfVar.vV() : null;
        } else {
            xVar = this.jQP;
            vV = xVar != null ? xVar.vV() : null;
        }
        TextView bmj = bmj();
        CharSequence b2 = (this.jQP == null || bi.oN(vV)) ? com.tencent.mm.pluginsdk.ui.d.i.b(getContext(), bbr.kzN, bmj().getTextSize()) : com.tencent.mm.pluginsdk.ui.d.i.b(getContext(), vV, bmj().getTextSize());
        bmj.setText(b2);
        bmj().setVisibility(4);
        bmk().setVisibility(4);
        reset();
        this.pDD = view;
        View view2 = this.pDD;
        if (view2 == null) {
            b.c.b.e.cKr();
        }
        h = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pBv);
        b.c.b.e.h(h, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
        ImageView imageView = (ImageView) h;
        View view3 = this.pDD;
        if (view3 == null) {
            b.c.b.e.cKr();
        }
        Object findViewById = view3.findViewById(com.tencent.mm.plugin.radar.a.c.pBf);
        b.c.b.e.h(findViewById, "avatarItem!!.findViewByI…d.radar_avatar_container)");
        view3 = this.pDD;
        if (view3 == null) {
            b.c.b.e.cKr();
        }
        view3.setVisibility(4);
        ((ImageView) this.pDF.getValue()).setImageDrawable(imageView.getDrawable());
        bmg().setVisibility(0);
        int[] iArr = new int[2];
        findViewById.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        bmf().getLocationInWindow(iArr2);
        this.pDM = iArr2;
        setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(1);
        animationSet.setDuration(500);
        float height = ((float) bmf().getHeight()) / ((float) findViewById.getHeight());
        TranslateAnimation translateAnimation = new TranslateAnimation((float) iArr[0], ((float) iArr2[0]) - (((float) ((findViewById.getWidth() - findViewById.getHeight()) / 2)) * height), (float) iArr[1], (float) iArr2[1]);
        animationSet.addAnimation(new ScaleAnimation(1.0f, height, 1.0f, height));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new i(this));
        bmg().startAnimation(animationSet);
    }

    public final void dismiss() {
        com.tencent.mm.sdk.platformtools.x.d(TAG, "dismiss");
        if (!this.pDO) {
            this.pDO = true;
            View view = this.pDD;
            if (view == null) {
                b.c.b.e.cKr();
            }
            Object findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pBf);
            b.c.b.e.h(findViewById, "avatarItem!!.findViewByI…d.radar_avatar_container)");
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setFillAfter(true);
            animationSet.setRepeatCount(1);
            animationSet.setDuration(500);
            int[] iArr = this.pDM;
            int[] iArr2 = new int[2];
            findViewById.getLocationInWindow(iArr2);
            float height = ((float) bmf().getHeight()) / ((float) findViewById.getHeight());
            float width = ((float) ((findViewById.getWidth() - findViewById.getHeight()) / 2)) * height;
            if (iArr == null) {
                b.c.b.e.cKr();
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(((float) iArr[0]) - width, (float) iArr2[0], (float) iArr[1], (float) iArr2[1]);
            animationSet.addAnimation(new ScaleAnimation(height, 1.0f, height, 1.0f));
            animationSet.addAnimation(translateAnimation);
            animationSet.setAnimationListener(new c(this));
            bmj().setVisibility(4);
            bmk().setVisibility(4);
            bmh().setVisibility(8);
            bmi().setVisibility(8);
            bml().setVisibility(8);
            bmm().setVisibility(8);
            bmg().startAnimation(animationSet);
        }
    }

    private final void reset() {
        bmg().setVisibility(8);
        bmj().setVisibility(4);
        bmk().setVisibility(4);
        bmh().setVisibility(8);
        bmi().setVisibility(8);
        bml().setVisibility(8);
        bmm().setVisibility(8);
    }
}
