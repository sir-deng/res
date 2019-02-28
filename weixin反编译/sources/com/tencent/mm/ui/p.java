package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.v4.view.m;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.f.a.ah;
import com.tencent.mm.f.a.ru;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.ac;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.v.a.d;
import com.tencent.mm.v.a.f;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.j;
import com.tencent.mm.v.a.k;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class p {
    private static WakeLock wakeLock = null;
    public static final int xRJ = h.gYK;
    private static byte[] xRM = new byte[]{(byte) 0};
    private static boolean xRv = false;
    String className;
    public View contentView;
    AudioManager hYt;
    private com.tencent.mm.ui.tools.p liK;
    public ActionBar mActionBar;
    Context mContext;
    private int mYO = 0;
    private LayoutInflater ntf;
    protected ag pLF = new ag(Looper.getMainLooper());
    private final long rNL = 300;
    private long rNM = SystemClock.elapsedRealtime();
    protected boolean xQT = false;
    public ImageView xRA;
    View xRB;
    private TextView xRC;
    private ImageButton xRD;
    private ImageView xRE;
    private int xRF = 0;
    private boolean xRG = false;
    private c xRH = new c<ru>() {
        {
            this.xmG = ru.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.f.a.ru.a aVar = ((ru) bVar).fKs;
            if (aVar.fpf == 2) {
                String str = aVar.fpi;
                int i = aVar.position;
                x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position[%d] noticeId[%s]", Integer.valueOf(i), str);
                if (i <= 0 || i == p.this.xRF) {
                    p.this.a(aVar.fph, aVar.visible, aVar.url, aVar.desc, str, i, false);
                } else {
                    x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE callback position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(p.this.xRF));
                }
            }
            return false;
        }
    };
    private int xRI = h.gYJ;
    private int xRK = -1;
    public int xRL = 0;
    private a xRN;
    private MenuItem xRO;
    private Runnable xRP = new Runnable() {
        public final void run() {
            p.this.xRr.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            if (p.this.mActionBar != null) {
                p.this.mActionBar.hide();
            }
        }
    };
    private Runnable xRQ = new Runnable() {
        public final void run() {
            if (p.this.mActionBar != null) {
                p.this.mActionBar.show();
            }
        }
    };
    private View xRc;
    public View xRd;
    View xRe;
    private TextView xRf;
    FrameLayout xRg;
    boolean xRh = true;
    private String xRi = " ";
    private int xRj = 0;
    private int xRk = 0;
    private e xRl = null;
    private e xRm = null;
    private e xRn = null;
    private e xRo = null;
    private boolean xRp = false;
    boolean xRq = false;
    public ActionBarActivity xRr;
    private boolean xRs;
    private a xRt = new a();
    public LinkedList<a> xRu = new LinkedList();
    private ArrayList<Dialog> xRw;
    public View xRx;
    public TextView xRy;
    View xRz;

    public static final class a {
        boolean frK = true;
        public OnLongClickListener mCu;
        public OnMenuItemClickListener pXw;
        public String text;
        public int textColor;
        boolean visible = true;
        public int xRW = -1;
        int xRX;
        Drawable xRY;
        View xRZ;
        View xSa;
        public int xSb = b.xSd;
        boolean xSc = false;
    }

    public enum b {
        ;

        static {
            xSd = 1;
            xSe = 2;
            xSf = 3;
            xSg = 4;
            xSh = 5;
            xSi = 6;
            xSj = 7;
            xSk = 8;
            xSl = 9;
            xSm = 10;
            xSn = 11;
            xSo = new int[]{xSd, xSe, xSf, xSg, xSh, xSi, xSj, xSk, xSl, xSm, xSn};
        }
    }

    protected abstract boolean cnD();

    protected abstract void dealContentView(View view);

    protected abstract String getClassName();

    protected abstract String getIdentString();

    protected abstract int getLayoutId();

    protected abstract View getLayoutView();

    protected abstract void onCreateBeforeSetContentView();

    public abstract void onKeyboardStateChanged();

    static /* synthetic */ boolean a(p pVar, View view, a aVar) {
        if (pVar.xRh) {
            return aVar.mCu != null ? aVar.mCu.onLongClick(view) : false;
        } else {
            x.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
            return true;
        }
    }

    static /* synthetic */ boolean f(p pVar) {
        return (pVar.xRr.getWindow().getAttributes().flags & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0;
    }

    static /* synthetic */ void g(p pVar) {
        pVar.xRL = 2;
        pVar.onKeyboardStateChanged();
    }

    static /* synthetic */ void h(p pVar) {
        pVar.xRL = 1;
        pVar.onKeyboardStateChanged();
    }

    private void a(int i, final boolean z, final String str, final String str2, final String str3, final int i2, boolean z2) {
        x.i("MicroMsg.MMActivityController", "initNotifyView viewid[%d], visible[%b], uithread[%b], noticeid[%s], position[%d], notifyView[%s]", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str3, Integer.valueOf(i2), this.xRe);
        if (!needShowIdcError()) {
            return;
        }
        if (!z && this.xRe == null) {
            return;
        }
        if (this.mActionBar == null || this.mActionBar.isShowing()) {
            if (this.xRg == null) {
                this.xRg = (FrameLayout) this.contentView.findViewById(g.cwr);
            }
            if (this.xRe != null) {
                this.xRg.removeView(this.xRe);
            }
            int i3 = h.dop;
            if (i <= 0) {
                i = i3;
            }
            this.xRe = this.ntf.inflate(i, null);
            this.xRf = (TextView) this.xRe.findViewById(g.cBw);
            this.xRe.findViewById(g.gXH).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.sdk.b.b ahVar = new ah();
                    ahVar.fpb.type = 1;
                    ahVar.fpb.fpd = str3;
                    ahVar.fpb.position = i2;
                    com.tencent.mm.sdk.b.a.xmy.m(ahVar);
                    p.this.xRe.setVisibility(8);
                }
            });
            this.xRe.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (str != null) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        p.this.mContext.startActivity(intent);
                    }
                }
            });
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (this.xRG && VERSION.SDK_INT >= 16) {
                layoutParams.setMargins(0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.xRr, 48.0f), 0, 0);
                x.i("MicroMsg.MMActivityController", "summerdiz initNotifyView [%d, %d]", Integer.valueOf(layoutParams.height), Integer.valueOf(layoutParams.topMargin));
            }
            this.xRg.addView(this.xRe, this.xRg.getChildCount(), layoutParams);
            if (this.xRe == null) {
                return;
            }
            if (z2) {
                CharSequence str22;
                this.xRe.setVisibility(z ? 0 : 8);
                String string = this.mContext.getString(k.ham);
                if (bi.oN(str22)) {
                    str22 = this.mContext.getString(k.dZa);
                }
                if (str != null) {
                    CharSequence spannableString = new SpannableString(str22 + string);
                    spannableString.setSpan(new ForegroundColorSpan(-10119449), str22.length(), string.length() + str22.length(), 33);
                    this.xRf.setText(spannableString);
                } else {
                    x.i("MicroMsg.MMActivityController", "summerdiz url is null 1");
                    this.xRf.setText(str22);
                }
                this.xRe.invalidate();
                this.xRg.invalidate();
                return;
            }
            this.xRe.post(new Runnable() {
                public final void run() {
                    p.this.xRe.setVisibility(z ? 0 : 8);
                    String string = p.this.mContext.getString(k.ham);
                    CharSequence string2 = bi.oN(str22) ? p.this.mContext.getString(k.dZa) : str22;
                    if (str != null) {
                        CharSequence spannableString = new SpannableString(string2 + string);
                        spannableString.setSpan(new ForegroundColorSpan(-10119449), string2.length(), string2.length() + string.length(), 33);
                        p.this.xRf.setText(spannableString);
                    } else {
                        x.i("MicroMsg.MMActivityController", "summerdiz url is null 2");
                        p.this.xRf.setText(string2);
                    }
                    p.this.xRe.invalidate();
                    p.this.xRg.invalidate();
                }
            });
            return;
        }
        x.i("MicroMsg.MMActivityController", "initNotifyView mActionBar not showing");
    }

    private View findViewById(int i) {
        View findViewById = this.contentView.findViewById(i);
        return findViewById != null ? findViewById : this.xRr.findViewById(i);
    }

    public final void setBackGroundColorResource(int i) {
        if (this.contentView != null) {
            if (this.xRg == null) {
                this.xRg = (FrameLayout) this.contentView.findViewById(g.cwr);
            }
            this.xRg.setBackgroundResource(i);
            this.xRd.setBackgroundResource(i);
        }
    }

    public final void ae(int i, boolean z) {
        this.xRF = i;
        this.xRG = z;
    }

    public static Locale initLanguage(Context context) {
        return bn(context, w.d(context.getSharedPreferences(ad.cgf(), 0)));
    }

    public static Locale bn(Context context, String str) {
        Resources resources = ad.getResources();
        if (str.equals("language_default")) {
            w.a(context, Locale.ENGLISH);
            if (resources instanceof com.tencent.mm.bv.a) {
                ((com.tencent.mm.bv.a) resources).ceL();
            }
            return Locale.getDefault();
        }
        Locale VC = w.VC(str);
        w.a(context, VC);
        if (resources instanceof com.tencent.mm.bv.a) {
            ((com.tencent.mm.bv.a) resources).ceL();
        }
        return VC;
    }

    public ActionBar getSupportActionBar() {
        return this.xRr.getSupportActionBar();
    }

    public final void a(Context context, ActionBarActivity actionBarActivity) {
        this.mContext = actionBarActivity;
        this.xRr = actionBarActivity;
        onCreateBeforeSetContentView();
        this.className = getClass().getName();
        ad.aZ(3, this.className);
        initLanguage(context);
        this.hYt = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        int layoutId = getLayoutId();
        this.ntf = LayoutInflater.from(this.mContext);
        this.contentView = com.tencent.mm.kiss.a.b.Ef().a(actionBarActivity, "R.layout.mm_activity", h.dnq);
        this.xRc = this.contentView.findViewById(g.gXC);
        this.xRg = (FrameLayout) this.contentView.findViewById(g.cwr);
        this.mYO = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.v.a.e.gWy);
        if (layoutId != -1) {
            this.xRd = getLayoutView();
            if (this.xRd == null) {
                this.xRd = this.ntf.inflate(getLayoutId(), null);
            } else if (this.xRd.getParent() != null) {
                ((ViewGroup) this.xRd.getParent()).removeView(this.xRd);
            }
            this.xRg.addView(this.xRd, 0);
        }
        dealContentView(this.contentView);
        if (cnD()) {
            int dimensionPixelSize;
            ae.c(ae.a(this.xRr.getWindow(), this.xRd), this.xRd);
            ((ViewGroup) this.xRd.getParent()).removeView(this.xRd);
            ((ViewGroup) this.xRr.getWindow().getDecorView()).addView(this.xRd, 0);
            layoutId = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 25);
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.v.a.e.buG);
            } else {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.v.a.e.buH);
            }
            this.xRd.setPadding(this.xRd.getPaddingLeft(), dimensionPixelSize + (layoutId + this.xRd.getPaddingTop()), this.xRd.getPaddingRight(), this.xRd.getPaddingBottom());
        }
        this.mActionBar = getSupportActionBar();
        x.d("MicroMsg.MMActivityController", "onCreate, before.");
        V(actionBarActivity);
        if (this.xRg == null || !(this.xRg instanceof LayoutListenerView)) {
            x.w("MicroMsg.MMActivityController", "layoutListenerView is not right");
        } else {
            LayoutListenerView layoutListenerView = (LayoutListenerView) this.xRg;
            LayoutListenerView.c anonymousClass9 = new LayoutListenerView.c() {
                private final int xRT = com.tencent.mm.bu.a.fromDPToPix(p.this.mContext, 100);

                public final void onSizeChanged(int i, int i2, int i3, int i4) {
                    if (!p.f(p.this) && i != 0 && i2 != 0 && i3 != 0 && i4 != 0 && i == i3) {
                        if (i2 > i4 && i2 - i4 > this.xRT) {
                            p.g(p.this);
                        } else if (i4 > i2 && i4 - i2 > this.xRT) {
                            p.h(p.this);
                        }
                    }
                }
            };
            synchronized (layoutListenerView.xQz) {
                layoutListenerView.xQB = anonymousClass9;
            }
        }
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.fpb.type = 2;
        ahVar.fpb.position = this.xRF;
        com.tencent.mm.sdk.b.a.xmy.m(ahVar);
        if (ahVar.fpc.fpf == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = ahVar.fpc.fpi;
            int i = ahVar.fpc.position;
            x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position[%d], noticeId[%s] stack[%s]", Integer.valueOf(i), str, bi.chl());
            if (i <= 0 || i == this.xRF) {
                a(ahVar.fpc.fph, ahVar.fpc.visible, ahVar.fpc.url, ahVar.fpc.desc, str, i, true);
            } else {
                x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onCreate position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.xRF));
            }
            x.v("MicroMsg.INIT", "KEVIN MMActivity onCreate initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = actionBarActivity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(actionBarActivity.getResources().getColor(d.btT));
        }
    }

    public boolean noActionBar() {
        return false;
    }

    final void V(Activity activity) {
        if (this.mActionBar != null && !noActionBar()) {
            if (VERSION.SDK_INT < 11) {
                this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.mContext.getResources().getColor(d.brg)));
            }
            x.d("MicroMsg.MMActivityController", "onCreate, after");
            this.mActionBar.setLogo(new ColorDrawable(this.xRr.getResources().getColor(17170445)));
            this.mActionBar.cP();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.cO();
            this.mActionBar.cQ();
            this.mActionBar.setIcon(f.bHc);
            if (this.xRK == -1) {
                this.mActionBar.setCustomView(v.fw(this.xRr).inflate(this.xRI, new LinearLayout(this.xRr), false));
            } else {
                this.mActionBar.setCustomView(v.fw(this.xRr).inflate(this.xRK, new LinearLayout(this.xRr), false));
            }
            this.xRy = (TextView) findViewById(16908308);
            this.xRC = (TextView) findViewById(16908309);
            this.xRx = findViewById(g.divider);
            this.xRz = findViewById(g.bIW);
            this.xRA = (ImageView) findViewById(g.bIX);
            if (this.xRA != null) {
                this.xRA.setContentDescription(this.xRr.getString(k.dDZ));
            }
            this.xRB = findViewById(g.gWR);
            if (this.xRy != null) {
                this.xRy.setText(k.app_name);
            }
            if (activity.getClass().getName() == "WebViewUI") {
                if (this.xRB != null) {
                    this.xRB.setVisibility(8);
                }
                if (this.xRA != null) {
                    this.xRA.setVisibility(0);
                }
                if (this.xRz != null) {
                    this.xRz.setVisibility(0);
                }
            } else if (activity instanceof MMActivity) {
                if (this.xRB != null) {
                    this.xRB.setVisibility(8);
                }
                if (this.xRA != null) {
                    this.xRA.setVisibility(0);
                }
                if (this.xRz != null) {
                    this.xRz.setVisibility(0);
                }
                if (this.xRy != null) {
                    this.xRy.setVisibility(0);
                }
            } else {
                if (this.xRB != null) {
                    this.xRB.setVisibility(0);
                }
                if (this.xRA != null) {
                    this.xRA.setVisibility(8);
                }
                if (this.xRz != null) {
                    this.xRz.setVisibility(8);
                }
            }
        }
    }

    public final void setScreenEnable(boolean z) {
        boolean z2 = true;
        this.xRh = z;
        if (this.xRc == null && this.contentView != null) {
            this.xRc = this.contentView.findViewById(g.gXC);
        }
        if (this.xRc == null) {
            x.e("MicroMsg.MMActivityController", "jacks error npe translayer !");
            return;
        }
        this.xRc.setFocusable(!z);
        View view = this.xRc;
        if (z) {
            z2 = false;
        }
        view.setFocusableInTouchMode(z2);
        if (z) {
            synchronized (xRM) {
                if (wakeLock == null || !wakeLock.isHeld()) {
                    x.w("MicroMsg.MMActivityController", "repeatedly release screen off wakelock from object: %s, drop this call.", toString());
                } else {
                    wakeLock.release();
                    x.i("MicroMsg.MMActivityController", "after release screen off wakelock from object: %s, isHeld: %s", toString(), Boolean.valueOf(wakeLock.isHeld()));
                }
            }
            return;
        }
        Context context = this.xRr;
        synchronized (xRM) {
            if (wakeLock == null) {
                wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(32, "screen Lock");
            }
            if (wakeLock.isHeld()) {
                x.w("MicroMsg.MMActivityController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", toString());
            } else {
                wakeLock.acquire();
                x.i("MicroMsg.MMActivityController", "after acquire screen off wakelock from object: %s, isHeld: %s", toString(), Boolean.valueOf(wakeLock.isHeld()));
            }
        }
    }

    public static boolean cnO() {
        boolean isHeld;
        synchronized (xRM) {
            isHeld = wakeLock != null ? wakeLock.isHeld() : false;
        }
        return isHeld;
    }

    protected static int getForceOrientation() {
        return -1;
    }

    public final void onStart() {
        this.xQT = this.mContext.getSharedPreferences(ad.cgf(), 0).getBoolean("settings_landscape_mode", false);
        if (this.xQT) {
            this.xRr.setRequestedOrientation(-1);
        } else {
            this.xRr.setRequestedOrientation(1);
        }
    }

    public final boolean getLandscapeMode() {
        return this.xQT;
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || keyEvent.getAction() != 1) {
            return false;
        }
        if (this.xRN == null || !this.xRN.frK) {
            return true;
        }
        a(this.xRO, this.xRN);
        return true;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.tencent.mm.compatible.b.f.xR();
        com.tencent.mm.compatible.b.f.xR();
        if (!this.xRs || this.liK == null || !this.liK.onKeyDown(i, keyEvent)) {
            return false;
        }
        x.d("MicroMsg.MMActivityController", "match search view on key down");
        return true;
    }

    public boolean needShowIdcError() {
        return true;
    }

    public final void onResume() {
        activateBroadcast(true);
        com.tencent.mm.sdk.b.a.xmy.b(this.xRH);
        com.tencent.mm.sdk.b.b ahVar = new ah();
        ahVar.fpb.type = 2;
        ahVar.fpb.position = this.xRF;
        com.tencent.mm.sdk.b.a.xmy.m(ahVar);
        if (ahVar.fpc.fpf == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            String str = ahVar.fpc.fpi;
            int i = ahVar.fpc.position;
            x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position[%d], noticeId[%s]", Integer.valueOf(i), str);
            if (i <= 0 || i == this.xRF) {
                a(ahVar.fpc.fph, ahVar.fpc.visible, ahVar.fpc.url, ahVar.fpc.desc, str, i, true);
            } else {
                x.i("MicroMsg.MMActivityController", "summerdiz E_BR_SHOWTYPE_TXTSTRIPE onResume position not match[%d, %d] ignore display", Integer.valueOf(i), Integer.valueOf(this.xRF));
            }
            x.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final void addDialog(Dialog dialog) {
        if (dialog != null) {
            if (this.xRw == null) {
                this.xRw = new ArrayList();
            }
            this.xRw.add(dialog);
        }
    }

    public final void onDestroy() {
        if (this.xRw != null) {
            int size = this.xRw.size();
            for (int i = 0; i < size; i++) {
                Dialog dialog = (Dialog) this.xRw.get(i);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
            this.xRw.clear();
            this.xRw = null;
        }
    }

    public final void activateBroadcast(boolean z) {
        if (xRv || !z) {
            ac.a(z, new Intent().putExtra("classname", getClassName() + getIdentString()));
        } else {
            ac.a(z, new Intent().putExtra("classname", getClassName()).putExtra("main_process", false));
        }
    }

    public static void cnF() {
        xRv = true;
    }

    public final void onPause() {
        activateBroadcast(false);
        com.tencent.mm.sdk.b.a.xmy.c(this.xRH);
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.MMActivityController", "on create option menu, menuCache size:%d", Integer.valueOf(this.xRu.size()));
        if (this.mActionBar == null || this.xRu.size() == 0) {
            x.w("MicroMsg.MMActivityController", "error, mActionBar is null or cache size:%d", Integer.valueOf(this.xRu.size()));
            return false;
        }
        this.xRN = null;
        this.xRO = null;
        if (this.mActionBar.getHeight() == 0) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.v.a.e.buG);
            } else {
                this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.v.a.e.buH);
            }
        }
        Iterator it = this.xRu.iterator();
        while (it.hasNext()) {
            final a aVar = (a) it.next();
            String str;
            if (aVar.xRW == 16908332) {
                x.v("MicroMsg.MMActivityController", "match back option menu, continue");
            } else if (aVar.xRW == g.cvU) {
                boolean z;
                str = "MicroMsg.MMActivityController";
                String str2 = "match search menu, enable search view[%B], search view helper is null[%B]";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(this.xRs);
                if (this.liK == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                x.v(str, str2, objArr);
                if (this.xRs && this.liK != null) {
                    this.liK.a(this.xRr, menu);
                }
            } else {
                final MenuItem add = menu.add(0, aVar.xRW, 0, aVar.text);
                str = getClass().getName();
                if (add == null) {
                    x.w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
                } else if (add.getTitleCondensed() == null) {
                    x.w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", str);
                    add.setTitleCondensed("");
                } else if (!(add.getTitleCondensed() instanceof String)) {
                    x.w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", str, add.getTitleCondensed().getClass().getName(), add.getTitleCondensed());
                    add.setTitleCondensed(add.getTitleCondensed().toString());
                }
                OnClickListener anonymousClass10 = new OnClickListener() {
                    public final void onClick(View view) {
                        p.this.a(add, aVar);
                    }
                };
                OnLongClickListener anonymousClass11 = new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        return p.a(p.this, view, aVar);
                    }
                };
                if (aVar.xRX == 0 && aVar.xRY == null) {
                    TextView textView;
                    if (aVar.xRZ == null) {
                        aVar.xRZ = View.inflate(this.mContext, h.gYG, null);
                    }
                    if (aVar.xSb == b.xSf) {
                        aVar.xRZ.findViewById(g.bIL).setVisibility(8);
                        aVar.xRZ.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xRZ.findViewById(g.gWU);
                        textView.setBackgroundResource(f.bAe);
                        textView.setPadding(this.mYO, 0, this.mYO, 0);
                    } else if (aVar.xSb == b.xSe) {
                        aVar.xRZ.findViewById(g.bIL).setVisibility(8);
                        aVar.xRZ.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xRZ.findViewById(g.gWU);
                        textView.setBackgroundResource(f.bAc);
                        textView.setPadding(this.mYO, 0, this.mYO, 0);
                    } else if (aVar.xSb == b.xSg) {
                        aVar.xRZ.findViewById(g.bIL).setVisibility(8);
                        aVar.xRZ.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xRZ.findViewById(g.gWU);
                        ((TextView) aVar.xRZ.findViewById(g.gWU)).setTextColor(-8393929);
                        textView.setBackgroundResource(f.gWK);
                        textView.setPadding(this.mYO, 0, this.mYO, 0);
                        aVar.xRZ.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
                    } else if (aVar.xSb == b.xSh || aVar.xSb == b.xSi || aVar.xSb == b.xSj || aVar.xSb == b.xSl) {
                        aVar.xRZ.findViewById(g.gWU).setVisibility(8);
                        aVar.xRZ.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xRZ.findViewById(g.bIL);
                        if (aVar.xSb == b.xSi) {
                            textView.setTextColor(this.xRr.getResources().getColor(d.gWp));
                        } else if (aVar.xSb == b.xSj) {
                            textView.setTextColor(this.xRr.getResources().getColor(d.buj));
                        } else if (aVar.xSb == b.xSl) {
                            textView.setTextColor(this.xRr.getResources().getColor(d.gWj));
                        }
                    } else if (aVar.xSb == b.xSk) {
                        aVar.xRZ.findViewById(g.bIL).setVisibility(8);
                        aVar.xRZ.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xRZ.findViewById(g.gWU);
                        textView.setBackgroundResource(f.gWB);
                        textView.setPadding(this.mYO, 0, this.mYO, 0);
                        textView.setTextColor(-2601405);
                    } else if (aVar.xSb == b.xSm) {
                        aVar.xRZ.findViewById(g.gWU).setVisibility(8);
                        aVar.xRZ.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xRZ.findViewById(g.bIL);
                        textView.setTextColor(this.xRr.getResources().getColor(d.buj));
                        textView.setBackgroundResource(f.gWA);
                    } else if (aVar.xSb == b.xSn) {
                        aVar.xRZ.findViewById(g.gWU).setVisibility(8);
                        aVar.xRZ.findViewById(g.divider).setVisibility(8);
                        textView = (TextView) aVar.xRZ.findViewById(g.bIL);
                        textView.setTextColor(this.xRr.getResources().getColor(d.black));
                    } else {
                        aVar.xRZ.findViewById(g.gWU).setVisibility(8);
                        aVar.xRZ.findViewById(g.divider).setVisibility(0);
                        textView = (TextView) aVar.xRZ.findViewById(g.bIL);
                    }
                    textView.setVisibility(0);
                    textView.setText(aVar.text);
                    if (aVar.textColor != 0) {
                        textView.setTextColor(aVar.textColor);
                    }
                    textView.setOnClickListener(anonymousClass10);
                    textView.setOnLongClickListener(anonymousClass11);
                    textView.setEnabled(aVar.frK);
                    m.a(add, aVar.xRZ);
                } else {
                    if (aVar.xSa == null) {
                        aVar.xSa = View.inflate(this.mContext, h.gYG, null);
                    }
                    ImageView imageView = (ImageView) aVar.xSa.findViewById(g.divider);
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    this.xRD = (ImageButton) aVar.xSa.findViewById(g.gWT);
                    this.xRD.setVisibility(0);
                    if (aVar.xRY != null) {
                        this.xRD.setImageDrawable(aVar.xRY);
                    } else {
                        this.xRD.setImageResource(aVar.xRX);
                    }
                    this.xRD.setOnClickListener(anonymousClass10);
                    this.xRD.setEnabled(aVar.frK);
                    this.xRD.setContentDescription(aVar.text);
                    if (aVar.mCu != null) {
                        this.xRD.setOnLongClickListener(anonymousClass11);
                    }
                    this.xRE = (ImageView) aVar.xSa.findViewById(g.ccv);
                    if (this.xRE != null) {
                        if (aVar.xSc) {
                            this.xRE.setVisibility(0);
                        } else {
                            this.xRE.setVisibility(8);
                        }
                    }
                    m.a(add, aVar.xSa);
                }
                add.setEnabled(aVar.frK);
                add.setVisible(aVar.visible);
                m.a(add, 2);
                if (aVar.xRX == f.bDJ) {
                    this.xRN = aVar;
                    this.xRO = add;
                }
                x.v("MicroMsg.MMActivityController", "set %d %s option menu enable %B, visible %B", Integer.valueOf(aVar.xRW), aVar.text, Boolean.valueOf(aVar.frK), Boolean.valueOf(aVar.visible));
            }
        }
        return true;
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        x.d("MicroMsg.MMActivityController", "on prepare option menu");
        if (this.xRs && this.liK != null) {
            this.liK.a(this.xRr, menu);
        }
        return true;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        x.v("MicroMsg.MMActivityController", "on options item selected");
        if (!this.xRh) {
            x.w("MicroMsg.MMActivityController", "onOptionsItemSelected screen not enable.");
            return true;
        } else if (menuItem.getItemId() == this.xRt.xRW && this.xRt.frK) {
            a(menuItem, this.xRt);
            return true;
        } else {
            Iterator it = this.xRu.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (menuItem.getItemId() == aVar.xRW) {
                    x.d("MicroMsg.MMActivityController", "on option menu %d click", Integer.valueOf(menuItem.getItemId()));
                    a(menuItem, aVar);
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean callBackMenu() {
        if (this.xRt == null || !this.xRt.frK) {
            return false;
        }
        a(null, this.xRt);
        return true;
    }

    private void a(MenuItem menuItem, a aVar) {
        if (!this.xRh) {
            x.w("MicroMsg.MMActivityController", "callMenuCallback screen not enable.");
        } else if (aVar.pXw != null) {
            aVar.pXw.onMenuItemClick(menuItem);
        }
    }

    public final void fullScreenNoTitleBar(boolean z) {
        if (z) {
            if (this.mActionBar != null) {
                this.mActionBar.hide();
            }
            this.pLF.removeCallbacks(this.xRQ);
            this.pLF.removeCallbacks(this.xRP);
            this.pLF.postDelayed(this.xRP, 256);
            return;
        }
        this.xRr.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.pLF.removeCallbacks(this.xRP);
        this.pLF.removeCallbacks(this.xRQ);
        this.pLF.postDelayed(this.xRQ, 256);
    }

    public final void i(boolean z, long j) {
        if (this.mActionBar != null) {
            this.mActionBar.hide();
        }
        this.pLF.removeCallbacks(this.xRQ);
        this.pLF.removeCallbacks(this.xRP);
        this.pLF.postDelayed(this.xRP, 0);
    }

    public final void setTitleVisibility(int i) {
        if (this.mActionBar != null) {
            if (i == 0) {
                this.mActionBar.show();
                if (VERSION.SDK_INT >= 21) {
                    this.xRr.getWindow().setStatusBarColor(this.xRr.getResources().getColor(d.btT));
                    return;
                }
                return;
            }
            this.mActionBar.hide();
            if (VERSION.SDK_INT >= 21) {
                this.xRr.getWindow().setStatusBarColor(this.xRr.getResources().getColor(d.black));
            }
        }
    }

    public final void setMMTitle(String str) {
        if (this.mActionBar != null) {
            this.xRi = str;
            if (com.tencent.mm.bu.a.ez(this.xRr)) {
                this.xRy.setTextSize(0, ((float) com.tencent.mm.bu.a.ab(this.xRr, com.tencent.mm.v.a.e.bun)) * com.tencent.mm.bu.a.ex(this.xRr));
            }
            cnP();
            updateDescription(str);
        }
    }

    public final void P(CharSequence charSequence) {
        if (this.mActionBar != null) {
            this.xRi = charSequence.toString();
            this.xRy.setText(charSequence);
            if (com.tencent.mm.bu.a.ez(this.xRr)) {
                this.xRy.setTextSize(0, ((float) com.tencent.mm.bu.a.ab(this.xRr, com.tencent.mm.v.a.e.bun)) * com.tencent.mm.bu.a.ex(this.xRr));
            }
            updateDescription(charSequence.toString());
        }
    }

    protected final void updateDescription(String str) {
        com.tencent.mm.ui.a.a cow = a.xVN;
        Activity activity = this.xRr;
        if (!cow.cov() && !bi.oN(str) && activity != null) {
            activity.getWindow().getDecorView().setContentDescription(activity.getString(k.haj) + str);
        }
    }

    public final void setMMTitle(int i) {
        setMMTitle(this.mContext.getString(i));
    }

    public final void setMMSubTitle(String str) {
        if (this.mActionBar != null) {
            if (str == null) {
                this.xRC.setVisibility(8);
                return;
            }
            this.xRC.setText(str);
            if (com.tencent.mm.bu.a.ez(this.xRr)) {
                this.xRC.setTextSize(1, 14.0f);
                this.xRy.setTextSize(1, 18.0f);
            }
            this.xRC.setVisibility(0);
            updateDescription(str);
        }
    }

    public final void setMMSubTitle(int i) {
        if (this.mActionBar != null) {
            this.xRC.setText(this.mContext.getString(i));
            if (com.tencent.mm.bu.a.ez(this.xRr)) {
                this.xRC.setTextSize(1, 14.0f);
                this.xRy.setTextSize(1, 18.0f);
            }
            this.xRC.setVisibility(0);
            updateDescription(this.mContext.getString(i));
        }
    }

    public final void setTitleLogo(int i, int i2) {
        if (this.mActionBar != null) {
            if (i == 0) {
                this.xRj = 0;
                this.xRl = null;
            } else if (this.xRj != i) {
                this.xRj = i;
                this.xRl = eN(this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.v.a.e.but), this.xRj);
            }
            if (i2 == 0) {
                this.xRk = 0;
                this.xRm = null;
            } else if (this.xRk != i2) {
                this.xRk = i2;
                this.xRm = eN(this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.v.a.e.but), this.xRk);
            }
            cnP();
        }
    }

    private e eN(int i, int i2) {
        Drawable drawable = this.mContext.getResources().getDrawable(i2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        e eVar = new e(drawable, 1);
        eVar.zCd = (drawable.getIntrinsicHeight() - i) / 2;
        return eVar;
    }

    final void cnP() {
        String str;
        int i;
        String str2;
        int i2;
        int i3;
        int i4;
        int i5;
        String str3 = "%s";
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.v.a.e.but);
        if (this.xRj != 0) {
            str3 = "# " + str3;
        }
        if (this.xRk != 0) {
            str = str3 + " #";
            i = 1;
        } else {
            str = str3;
            i = 0;
        }
        if (this.xRp) {
            str2 = str + " #";
            i2 = i + 2;
            i = 1;
        } else {
            str2 = str;
            i2 = i;
            i = 0;
        }
        if (this.xRq) {
            i3 = i + 2;
            i4 = i2 + 2;
            str3 = str2 + " #";
            i5 = 1;
        } else {
            i3 = i;
            i4 = i2;
            str3 = str2;
            i5 = 0;
        }
        CharSequence format = String.format(str3, new Object[]{this.xRi});
        x.v("MicroMsg.MMActivityController", "span title format %s", str3);
        format = com.tencent.mm.ui.e.c.b.a(this.mContext, format, dimensionPixelSize);
        if (format instanceof SpannableString) {
            int length;
            SpannableString spannableString = (SpannableString) format;
            if (this.xRj != 0) {
                spannableString.setSpan(this.xRl, 0, 1, 33);
            }
            if (this.xRk != 0) {
                length = spannableString.length() - i4;
                spannableString.setSpan(this.xRm, length, length + 1, 33);
            }
            if (this.xRp) {
                if (this.xRn == null) {
                    this.xRn = eN(dimensionPixelSize, j.gZZ);
                }
                length = spannableString.length() - i3;
                spannableString.setSpan(this.xRn, length, length + 1, 33);
            }
            if (this.xRq) {
                if (this.xRo == null) {
                    this.xRo = eN(dimensionPixelSize, j.haa);
                }
                length = spannableString.length() - i5;
                spannableString.setSpan(this.xRo, length, length + 1, 33);
            }
        }
        this.xRy.setText(format);
    }

    public final void showHomeBtn(boolean z) {
        int i = 8;
        if (this.mActionBar != null) {
            this.mActionBar.setDisplayHomeAsUpEnabled(z);
            if (this.xRz != null && this.xRB != null) {
                int i2;
                View view = this.xRz;
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                view.setVisibility(i2);
                View view2 = this.xRB;
                if (!z) {
                    i = 0;
                }
                view2.setVisibility(i);
            }
        }
    }

    public void supportInvalidateOptionsMenu() {
        this.xRr.supportInvalidateOptionsMenu();
    }

    public boolean interceptSupportInvalidateOptionsMenu() {
        return false;
    }

    public final void enableBackMenu(boolean z) {
        if (this.xRt != null && this.xRt.frK != z) {
            this.xRt.frK = z;
            supportInvalidateOptionsMenu();
        }
    }

    final void a(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        a aVar;
        if (z) {
            it = this.xRu.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.frK != z2) {
                    aVar.frK = z2;
                    z4 = true;
                } else {
                    z4 = z3;
                }
                z3 = z4;
            }
        } else {
            it = this.xRu.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.xRW != i || aVar.frK == z2) {
                    z4 = z3;
                } else {
                    aVar.frK = z2;
                    z4 = true;
                }
                z3 = z4;
            }
        }
        if (!(this.liK == null ? false : this.liK.zvr)) {
            supportInvalidateOptionsMenu();
        }
        x.v("MicroMsg.MMActivityController", "enable option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    final void b(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        a aVar;
        if (z) {
            it = this.xRu.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.visible != z2) {
                    aVar.visible = z2;
                    z4 = true;
                } else {
                    z4 = z3;
                }
                z3 = z4;
            }
        } else {
            it = this.xRu.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.xRW != i || aVar.visible == z2) {
                    z4 = z3;
                } else {
                    aVar.visible = z2;
                    z4 = true;
                }
                z3 = z4;
            }
        }
        z4 = this.liK == null ? false : this.liK.zvr;
        if (z3 && !z4) {
            supportInvalidateOptionsMenu();
        }
        x.i("MicroMsg.MMActivityController", "show option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    public final void addSearchMenu(boolean z, com.tencent.mm.ui.tools.p pVar) {
        x.v("MicroMsg.MMActivityController", "add search menu");
        a aVar = new a();
        aVar.xRW = g.cvU;
        aVar.text = this.mContext.getString(k.dGK);
        aVar.xRX = j.dvm;
        aVar.pXw = null;
        aVar.mCu = null;
        removeOptionMenu(aVar.xRW);
        this.xRu.add(0, aVar);
        this.xRs = z;
        this.liK = pVar;
        supportInvalidateOptionsMenu();
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, 0, str, false, onMenuItemClickListener, null, b.xSd);
    }

    public final void addTextOptionMenu$7df2a0ca(int i, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, int i2) {
        a(i, 0, str, false, onMenuItemClickListener, onLongClickListener, i2);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i2, "", false, onMenuItemClickListener, null, b.xSd);
    }

    public final void a(int i, String str, Drawable drawable, OnMenuItemClickListener onMenuItemClickListener) {
        int i2 = b.xSd;
        a aVar = new a();
        aVar.xRW = i;
        aVar.xRY = drawable;
        aVar.text = str;
        aVar.pXw = onMenuItemClickListener;
        aVar.mCu = null;
        aVar.xSb = i2;
        El(aVar.xRW);
        this.xRu.add(aVar);
        new ag().postDelayed(new Runnable() {
            public final void run() {
                p.this.supportInvalidateOptionsMenu();
            }
        }, 200);
    }

    public final void addIconOptionMenu(int i, String str, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i2, str, false, onMenuItemClickListener, null, b.xSd);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i3, this.mContext.getString(i2), false, onMenuItemClickListener, null, b.xSd);
    }

    public final void updateOptionMenuText(int i, String str) {
        a Em = Em(i);
        if (Em != null && !bi.aD(str, "").equals(Em.text)) {
            Em.text = str;
            supportInvalidateOptionsMenu();
        }
    }

    public final void updateOptionMenuListener(int i, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        a Em = Em(i);
        if (Em != null) {
            Em.pXw = onMenuItemClickListener;
            Em.mCu = onLongClickListener;
        }
    }

    public final void setTitleBarDoubleClickListener(final Runnable runnable) {
        if (this.mActionBar != null && runnable != null) {
            this.mActionBar.getCustomView().setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (SystemClock.elapsedRealtime() - p.this.rNM < 300) {
                        runnable.run();
                    }
                    p.this.rNM = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    public final void setBackBtn(final OnMenuItemClickListener onMenuItemClickListener, int i) {
        if (this.mActionBar != null) {
            if (onMenuItemClickListener == null) {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
            } else {
                this.mActionBar.setDisplayHomeAsUpEnabled(false);
                if (this.xRz != null) {
                    this.xRz.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            onMenuItemClickListener.onMenuItemClick(null);
                        }
                    });
                }
            }
            if (!(this.xRA == null || i == 0)) {
                this.xRA.setImageResource(i);
            }
            this.xRt.xRW = 16908332;
            this.xRt.pXw = onMenuItemClickListener;
        }
    }

    public final void removeAllOptionMenu() {
        if (!this.xRu.isEmpty()) {
            this.xRu.clear();
            supportInvalidateOptionsMenu();
        }
    }

    public final boolean El(int i) {
        for (int i2 = 0; i2 < this.xRu.size(); i2++) {
            if (((a) this.xRu.get(i2)).xRW == i) {
                x.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i));
                this.xRu.remove(i2);
                return true;
            }
        }
        return false;
    }

    public final boolean removeOptionMenu(int i) {
        for (int i2 = 0; i2 < this.xRu.size(); i2++) {
            if (((a) this.xRu.get(i2)).xRW == i) {
                x.d("MicroMsg.MMActivityController", "match menu, id %d, remove it", Integer.valueOf(i));
                this.xRu.remove(i2);
                supportInvalidateOptionsMenu();
                return true;
            }
        }
        return false;
    }

    final void a(int i, int i2, String str, boolean z, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, int i3) {
        a aVar = new a();
        aVar.xRW = i;
        aVar.xRX = i2;
        aVar.text = str;
        aVar.pXw = onMenuItemClickListener;
        aVar.mCu = onLongClickListener;
        aVar.xSb = i3;
        aVar.xSc = z;
        if (aVar.xRX == f.bDJ && bi.oN(str)) {
            aVar.text = this.mContext.getString(k.hai);
        }
        El(aVar.xRW);
        this.xRu.add(aVar);
        supportInvalidateOptionsMenu();
    }

    public final a Em(int i) {
        Iterator it = this.xRu.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.xRW == i) {
                return aVar;
            }
        }
        return null;
    }

    public final CharSequence getMMTitle() {
        if (this.mActionBar == null) {
            return null;
        }
        return this.xRi != null ? this.xRi : this.mActionBar.getTitle();
    }

    public final void hideTitleView() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "hideTitleView hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        if (this.mActionBar != null) {
            this.mActionBar.hide();
        }
    }

    public final void showTitleView() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "showTitleView hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        if (this.mActionBar != null) {
            this.mActionBar.show();
        }
    }

    public final boolean isTitleShowing() {
        boolean z = true;
        String str = "MicroMsg.MMActivityController";
        String str2 = "isTitleShowing hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.mActionBar == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        if (this.mActionBar == null) {
            return false;
        }
        return this.mActionBar.isShowing();
    }

    public final int getTitleLocation() {
        if (this.mActionBar == null) {
            return 0;
        }
        return this.mActionBar.getHeight();
    }

    public final void setTitleMuteIconVisibility(int i) {
        this.xRp = i == 0;
        cnP();
    }

    public final boolean hideVKB() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        View currentFocus = this.xRr.getCurrentFocus();
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
            x.e("MicroMsg.MMActivityController", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
        x.v("MicroMsg.MMActivityController", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
        return hideSoftInputFromWindow;
    }

    public final boolean hideVKB(View view) {
        if (view == null) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.MMActivityController", "hide VKB(View) exception %s", e);
            hideSoftInputFromWindow = false;
        }
        return hideSoftInputFromWindow;
    }

    public final void showVKB() {
        Activity activity = this.xRr;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }
}
