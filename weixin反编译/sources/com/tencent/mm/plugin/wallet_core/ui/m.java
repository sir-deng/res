package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.f.a.lg;
import com.tencent.mm.f.a.nc;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.y.q;
import com.tenpay.android.wechat.MyKeyboardWindow;

public final class m extends k implements c {
    protected OnCancelListener Gj;
    private String fDw = "";
    private String fvC;
    public ImageView hxJ;
    private boolean isPaused = false;
    public View kTo;
    private Animation mFF;
    private int mFG = 0;
    protected MyKeyboardWindow mKeyboard;
    protected View okX;
    public TextView pUw;
    public TextView qaV;
    protected boolean qva;
    protected com.tencent.mm.plugin.wallet_core.e.a sHX = new com.tencent.mm.plugin.wallet_core.e.a();
    public TextView sLT;
    public TextView tbA;
    public FavourLayout tbB;
    public ImageView tbC;
    public TextView tbD;
    public EditHintPasswdView tbE;
    public b tbF;
    public View tbG;
    public View tbH;
    public TextView tbI;
    public ImageView tbJ;
    public TextView tbK;
    public TextView tbL;
    public View tbM;
    public TextView tbN;
    protected a tbO;
    protected OnClickListener tbP;
    protected boolean tbQ = false;
    protected boolean tbR = true;
    protected Bankcard tbS = null;
    public TextView tbT;
    public View tbU;
    public TextView tbV;
    public ImageView tbW;
    protected int tbX = 0;
    protected boolean tbY = false;
    private int tbZ = 0;
    public Button tbx;
    public ImageView tby;
    public TextView tbz;
    private Animation tca = null;
    private String tcb = "";
    private long tcc = -1;
    private int tcd = 0;
    private int tce = 0;
    private boolean tcf = false;

    public interface b {
        void b(String str, boolean z, String str2);
    }

    public interface a {
        void bhU();
    }

    static /* synthetic */ void a(m mVar) {
        mVar.tbT.setText(mVar.getContext().getString(i.vbZ));
        mVar.tbX = 1;
        mVar.tcc = bi.Wz();
        mVar.tbU.setVisibility(0);
        mVar.tbW.setVisibility(0);
        mVar.tbV.setVisibility(8);
        mVar.tbE.setVisibility(8);
        mVar.okX.setVisibility(8);
        mVar.tbz.setText(i.vbT);
        jT(false);
        mVar.tcd = 1;
        g.pWK.h(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
        e.HX(9);
    }

    static /* synthetic */ boolean c(m mVar) {
        String str = "MicroMsg.WalletPwdCustomDialog";
        String str2 = "hy: is screen on: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(!mVar.isPaused);
        x.i(str, str2, objArr);
        return !mVar.isPaused;
    }

    private m(Context context) {
        super(context, j.vfj);
        x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo WalletPwdDialog initView");
        this.kTo = View.inflate(context, com.tencent.mm.plugin.wxpay.a.g.uLz, null);
        this.tbx = (Button) this.kTo.findViewById(f.cwq);
        this.tby = (ImageView) this.kTo.findViewById(f.uGw);
        this.mKeyboard = (MyKeyboardWindow) this.kTo.findViewById(f.uDo);
        this.okX = this.kTo.findViewById(f.uDn);
        this.qaV = (TextView) this.kTo.findViewById(f.content);
        this.tbz = (TextView) this.kTo.findViewById(f.uGA);
        this.pUw = (TextView) this.kTo.findViewById(f.fqJ);
        this.sLT = (TextView) this.kTo.findViewById(f.uzi);
        this.sLT.getPaint().setFlags(16);
        this.tbA = (TextView) this.kTo.findViewById(f.ulW);
        this.tbB = (FavourLayout) this.kTo.findViewById(f.uqR);
        this.tbC = (ImageView) this.kTo.findViewById(f.ulP);
        this.tbG = this.kTo.findViewById(f.uqN);
        this.tbD = (TextView) this.kTo.findViewById(f.uyh);
        this.hxJ = (ImageView) this.kTo.findViewById(f.uod);
        this.tbH = this.kTo.findViewById(f.ulN);
        this.tbI = (TextView) this.kTo.findViewById(f.uCS);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.hxJ, e.getUsername());
        this.tbE = (EditHintPasswdView) this.kTo.findViewById(f.ury);
        this.tbJ = (ImageView) this.kTo.findViewById(f.uro);
        this.tbT = (TextView) this.kTo.findViewById(f.uGr);
        this.tbU = this.kTo.findViewById(f.urb);
        this.tbV = (TextView) this.kTo.findViewById(f.urc);
        this.tbW = (ImageView) this.kTo.findViewById(f.ura);
        this.tbK = (TextView) this.kTo.findViewById(f.uob);
        this.tbL = (TextView) this.kTo.findViewById(f.uAX);
        this.tbM = this.kTo.findViewById(f.uqL);
        this.tbN = (TextView) this.kTo.findViewById(f.uqQ);
        this.tbB.setVisibility(8);
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.tbx.setEnabled(false);
        this.tbx.setTextColor(context.getResources().getColorStateList(c.uhQ));
        com.tencent.mm.wallet_core.ui.formview.a.a(this.tbE);
        this.tbE.zSM = new com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a() {
            public final void hB(boolean z) {
                if (z) {
                    m.this.bNy();
                    g.pWK.h(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                }
            }
        };
        this.tbE.requestFocus();
        TextView textView = (TextView) this.kTo.findViewById(f.uGA);
        if (textView != null) {
            textView.setText(u.gi(context));
        }
        EditText editText = (EditText) this.kTo.findViewById(f.uFa);
        e.setNoSystemInputOnEditText(editText);
        this.mKeyboard.setInputEditText(editText);
        if (VERSION.SDK_INT >= 14) {
            AccessibilityDelegate cVar = new com.tencent.mm.ui.a.c();
            this.mKeyboard.setSecureAccessibility(cVar);
            editText.setAccessibilityDelegate(cVar);
        }
        editText.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!m.this.okX.isShown()) {
                    m.this.okX.setVisibility(0);
                }
            }
        });
        this.kTo.findViewById(f.ivH).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (m.this.okX.isShown()) {
                    m.this.okX.setVisibility(8);
                }
            }
        });
        bNw();
    }

    private void bNw() {
        boolean z;
        x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo updateFingerprintMode");
        this.tbZ = 0;
        this.tbT.setVisibility(8);
        this.tbU.setVisibility(8);
        this.tcc = bi.Wz();
        l lVar = (l) com.tencent.mm.kernel.g.h(l.class);
        if (o.bMc() == null || !lVar.aKD()) {
            z = true;
        } else {
            z = lVar.aKW();
        }
        x.i("MicroMsg.WalletPwdCustomDialog", "hy: soter key status: %b", Boolean.valueOf(z));
        this.tcd = 0;
        this.fDw = "";
        if (lVar == null || !lVar.aKK() || lVar.aKF()) {
            z = false;
        } else {
            z = true;
        }
        x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo isDeviceSupportFp: %b", Boolean.valueOf(z));
        boolean z2 = lVar != null && lVar.aKD();
        if (z2 && z && this.tbY && !bNz()) {
            this.tbT.setVisibility(0);
            this.tbT.setText(getContext().getString(i.vbZ));
            this.tbX = 1;
            this.tbU.setVisibility(0);
            this.tbW.setVisibility(0);
            this.tbE.setVisibility(8);
            this.okX.setVisibility(8);
            this.tbz.setText(i.vbT);
            this.tcd = 1;
            bNk();
            g.pWK.h(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        } else if (z2 && z && this.tbY && bNz()) {
            this.tbT.setText(getContext().getString(i.uYk));
            this.tbT.setVisibility(0);
            this.tbX = 0;
            this.tbU.setVisibility(8);
            this.tbE.setVisibility(0);
            if (!this.okX.isShown()) {
                this.okX.setVisibility(0);
            }
            this.tbz.setText(i.vbX);
            this.tcd = 0;
            this.fDw = "";
            g.pWK.h(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            e.HX(8);
        } else {
            this.tcd = 0;
            this.fDw = "";
            this.tbT.setVisibility(8);
            g.pWK.h(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        }
        x.i("MicroMsg.WalletPwdCustomDialog", "isOpenTouch:" + z2 + ",  isDeviceSupport:" + z + ", use_pay_touch:" + this.tbY + ", isForcePwdMode:" + bNz());
        this.tbT.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (m.this.tbX == 0) {
                    m.a(m.this);
                } else if (m.this.tbX == 1) {
                    m.this.bNx();
                }
                if (m.this.tbX == 1) {
                    m.bNl();
                    if (m.c(m.this)) {
                        m.this.bNk();
                    }
                }
            }
        });
    }

    private void bNx() {
        this.tbT.setText(getContext().getString(i.uYk));
        this.tbX = 0;
        this.tcc = bi.Wz();
        this.tbU.setVisibility(8);
        this.tbE.setVisibility(0);
        if (!this.okX.isShown()) {
            this.okX.setVisibility(0);
        }
        this.tbz.setText(i.vbX);
        jT(true);
        this.tcd = 0;
        this.fDw = "";
        g.pWK.h(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        e.HX(29);
        bNl();
    }

    private void bNk() {
        x.i("MicroMsg.WalletPwdCustomDialog", "reqFingerPrintAuth %s", bi.chl().toString());
        com.tencent.mm.plugin.soter.c.a.bDx();
        final com.tencent.mm.sdk.b.b lgVar = new lg();
        lgVar.fDr.fxT = this.fvC;
        lgVar.fDr.fDt = 1;
        lgVar.fDr.fDv = new Runnable() {
            public final void run() {
                x.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback");
                com.tencent.mm.f.a.lg.b bVar = lgVar.fDs;
                if (bVar == null) {
                    m.this.tcd = 0;
                    x.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, result == null");
                    return;
                }
                int i = bVar.errCode;
                x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo errCode: %d, errMsg: %s", Integer.valueOf(i), bVar.foE);
                if (i == 0) {
                    x.i("MicroMsg.WalletPwdCustomDialog", "hy: payInfo soterAuthReq: %s", bVar.fDw);
                    m.this.tcd = 1;
                    m.this.fDw = bVar.fDw;
                    m.this.tce = m.this.tce + 1;
                    m.this.tbV.setText("");
                    m.this.bNy();
                    g.pWK.h(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2));
                    com.tencent.mm.plugin.soter.c.a.ys(0);
                    return;
                }
                boolean z;
                x.i("MicroMsg.WalletPwdCustomDialog", "hy: FingerPrintAuthEvent callback, encrypted_pay_info & encrypted_rsa_sign is empty, idetify fail!");
                m.this.tcd = 0;
                m.this.fDw = "";
                m.this.tbU.setVisibility(0);
                m.this.tbV.setTextColor(m.this.getContext().getResources().getColor(c.btC));
                m.this.tbV.setText(i.uYi);
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                int f = currentTimeMillis - m.this.mFG;
                if (f > 1) {
                    m.this.mFG = currentTimeMillis;
                    m.this.tbZ = m.this.tbZ + 1;
                    m.this.tce = m.this.tce + 1;
                }
                g.pWK.h(11977, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(2));
                boolean z2 = i == 2 || i == 10308;
                if (bVar.fDx == 2) {
                    z = true;
                } else {
                    z = false;
                }
                x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo shouldDirectlyFail: %b, mIdentifyFail: %d, errCode: %d, isSoter: %b", Boolean.valueOf(z2), Integer.valueOf(m.this.tbZ), Integer.valueOf(i), Boolean.valueOf(z));
                if ((z || (m.this.tbZ < 3 && f > 1)) && !z2) {
                    x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo fingerprint pay");
                    if (m.this.tca == null) {
                        m.this.tca = com.tencent.mm.ui.c.a.fB(m.this.getContext());
                    }
                    m.this.tbW.setVisibility(8);
                    m.this.tbV.setVisibility(4);
                    m.this.tca.reset();
                    m.this.tca.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                            x.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash start");
                            ah.y(new Runnable() {
                                public final void run() {
                                    m.this.tbV.setVisibility(0);
                                }
                            });
                        }

                        public final void onAnimationEnd(Animation animation) {
                            x.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash end");
                            ah.y(new Runnable() {
                                public final void run() {
                                    m.this.tbV.setVisibility(8);
                                    m.this.tbW.setVisibility(0);
                                }
                            });
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    m.this.tbV.startAnimation(m.this.tca);
                    com.tencent.mm.plugin.soter.c.a.ys(1);
                } else if (m.this.tbZ >= 3 || z2) {
                    x.v("MicroMsg.WalletPwdCustomDialog", "alvinluo change to pwd pay");
                    m.bNl();
                    m.this.tbX = 0;
                    m.this.tcc = bi.Wz();
                    m.this.tbT.setVisibility(8);
                    m.this.tbU.setVisibility(8);
                    m.this.tbV.setVisibility(0);
                    m.this.tbV.setText(i.uYj);
                    m.this.tbV.setTextColor(m.this.getContext().getResources().getColor(c.uif));
                    m.this.tbz.setText(i.vbX);
                    m.this.tbE.setVisibility(0);
                    if (!m.this.okX.isShown()) {
                        m.this.okX.setVisibility(0);
                    }
                    com.tencent.mm.plugin.soter.c.a.ys(2);
                    m.jT(true);
                }
            }
        };
        com.tencent.mm.sdk.b.a.xmy.a(lgVar, Looper.getMainLooper());
    }

    private static void bNl() {
        x.i("MicroMsg.WalletPwdCustomDialog", "hy: send release FPManager");
        com.tencent.mm.sdk.b.a.xmy.m(new nc());
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.Gj != null) {
                this.Gj.onCancel(this);
            }
            if (this.tbO != null) {
                this.tbO.bhU();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.kTo);
        com.tencent.d.b.f.f.cHb().cHc();
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        this.qva = z;
        setCanceledOnTouchOutside(this.qva);
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.WalletPwdCustomDialog", "dismiss exception, e = " + e.getMessage());
        }
        bNl();
        this.sHX.destory();
        if (this.mFF != null) {
            this.mFF.cancel();
        }
    }

    protected final void bNy() {
        jT(false);
        if (this.tbP != null) {
            this.tbP.onClick(this, 0);
        }
        dismiss();
        if (this.tbF != null) {
            x.i("MicroMsg.WalletPwdCustomDialog", "doOk use_touch: %s soterAuthReq: %s ", Integer.valueOf(this.tcd), this.fDw);
            this.tbF.b(this.tbE.getText(), this.tcd == 1, this.fDw);
        }
        if (this.tcc < 0) {
            x.e("MicroMsg.WalletPwdCustomDialog", "hy: not set update mode time yet. abandon");
        } else if (this.tbX == 0) {
            g.pWK.a(686, 0, 1, false);
            g.pWK.a(686, 1, bi.bB(this.tcc), false);
        } else if (this.tbX == 1) {
            g.pWK.a(686, 2, 1, false);
            g.pWK.a(686, 3, bi.bB(this.tcc), false);
        }
    }

    public static m a(Context context, String str, String str2, String str3, boolean z, b bVar, final OnCancelListener onCancelListener, a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        m mVar = new m(context);
        if (mVar.tbx != null) {
            mVar.tbP = null;
            mVar.tbx.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    m.this.bNy();
                }
            });
        }
        if (mVar.tby != null) {
            mVar.Gj = onCancelListener;
            mVar.tby.setVisibility(0);
            mVar.tby.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (onCancelListener != null) {
                        onCancelListener.onCancel(null);
                    }
                    if (m.this.tbO != null) {
                        m.this.tbO.bhU();
                    }
                    m.this.cancel();
                    if (m.this.tbT.isShown()) {
                        g.pWK.h(11977, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                        return;
                    }
                    g.pWK.h(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                }
            });
        }
        mVar.setOnCancelListener(onCancelListener);
        mVar.setCancelable(true);
        mVar.qaV.setText(str);
        if (TextUtils.isEmpty(str2)) {
            mVar.pUw.setVisibility(8);
        } else {
            mVar.pUw.setVisibility(0);
            mVar.pUw.setText(str2);
        }
        mVar.tbH.setVisibility(8);
        mVar.tbR = false;
        mVar.tbO = aVar;
        if (TextUtils.isEmpty(str3)) {
            x.i("MicroMsg.WalletPwdCustomDialog", "ChargeFee is null");
            mVar.tbK.setVisibility(8);
        } else {
            mVar.tbK.setVisibility(0);
            mVar.tbK.setText(str3);
        }
        mVar.tbF = bVar;
        mVar.tbY = z;
        if (!q.Gl()) {
            mVar.bNw();
        }
        mVar.show();
        h.a(context, mVar);
        return mVar;
    }

    public final void bNb() {
        this.isPaused = false;
        if (!q.Gl()) {
        }
    }

    public final void bNc() {
        this.isPaused = true;
        if (!q.Gl() && this.tbX == 1) {
            bNx();
        }
    }

    private static void jT(boolean z) {
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.valueOf(z));
    }

    private static boolean bNz() {
        com.tencent.mm.kernel.g.Dr();
        Object obj = com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_FINGER_PRINT_IS_FORCE_PWD_MODE_BOOLEAN_SYNC, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }
}
