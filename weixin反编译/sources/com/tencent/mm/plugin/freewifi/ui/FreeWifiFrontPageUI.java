package com.tencent.mm.plugin.freewifi.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.e.g;
import com.tencent.mm.plugin.freewifi.e.h;
import com.tencent.mm.plugin.freewifi.e.i;
import com.tencent.mm.plugin.freewifi.e.j;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI extends MMActivity {
    protected int cPf;
    protected String className;
    protected String fGh;
    protected int fei;
    protected String fqu;
    private final com.tencent.mm.ap.a.a.c hEY;
    private ag hbP = new ag() {
        public final void handleMessage(Message message) {
            c cVar = (c) message.obj;
            switch (AnonymousClass8.mNk[cVar.mNi.ordinal()]) {
                case 1:
                    FreeWifiFrontPageUI.this.aNk();
                    return;
                case 2:
                    FreeWifiFrontPageUI.this.aNl();
                    return;
                case 3:
                    FreeWifiFrontPageUI.this.bs(cVar.data);
                    return;
                case 4:
                    FreeWifiFrontPageUI.this.bt(cVar.data);
                    return;
                default:
                    return;
            }
        }
    };
    protected Intent intent;
    protected String mKN;
    protected int mKO;
    protected String mKP;
    protected TextView mMI;
    protected TextView mMJ;
    protected TextView mMK;
    protected ImageView mMV;
    protected TextView mMW;
    protected TextView mMX;
    protected Button mMY;
    protected Button mMZ;
    protected Dialog mNa;
    protected View mNb;
    protected String mNc;
    protected String mNd;
    protected String mNe;
    protected String mNf;
    protected com.tencent.mm.plugin.freewifi.e.a mNg;
    private Lock mNh;
    private d mNi;
    protected String ssid;

    public static class b {
        public em mNm;
    }

    public static class c {
        Object data;
        d mNi;

        public c(d dVar, Object obj) {
            this.mNi = dVar;
            this.data = obj;
        }
    }

    public enum d {
        START,
        CONNECTING,
        FAIL,
        SUCCESS
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI$8 */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] mNk = new int[d.values().length];

        static {
            try {
                mNk[d.START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mNk[d.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mNk[d.FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                mNk[d.SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static class a {
        public static a mNl = new a();
        public int jHN;
        public String mMO;
        public String text;
    }

    public FreeWifiFrontPageUI() {
        com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
        aVar.hFj = true;
        aVar.hFk = true;
        aVar.hFA = R.g.bCk;
        aVar.hFJ = true;
        aVar.hFK = 0.0f;
        this.hEY = aVar.PQ();
    }

    private d aNi() {
        try {
            this.mNh.lock();
            d dVar = this.mNi;
            return dVar;
        } finally {
            this.mNh.unlock();
        }
    }

    public final void a(d dVar, Object obj) {
        try {
            this.mNh.lock();
            this.mNi = dVar;
            Message obtain = Message.obtain();
            obtain.obj = new c(dVar, obj);
            this.hbP.sendMessage(obtain);
        } finally {
            this.mNh.unlock();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        switch (this.mKO) {
            case 1:
                this.mNg = new g(this);
                break;
            case 4:
                this.mNg = new f(this);
                break;
            case 31:
                this.mNg = new h(this);
                this.mNb.setVisibility(0);
                aNj();
                break;
            case 32:
                this.mNg = new j(this);
                this.mNb.setVisibility(0);
                break;
            case 33:
                this.mNg = new i(this);
                break;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.className, this.fqu);
        l.r(com.tencent.mm.plugin.freewifi.model.d.aMm(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FreeWifiFrontPageUI.this.goBack();
                return true;
            }
        });
        if (this.mNa != null) {
            this.mNa.dismiss();
        }
        this.mNh = new ReentrantLock();
        this.className = getClass().getSimpleName();
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.mKN = getIntent().getStringExtra("free_wifi_url");
        this.fqu = getIntent().getStringExtra("free_wifi_ap_key");
        this.cPf = getIntent().getIntExtra("free_wifi_source", 1);
        this.fei = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.mKO = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        this.fGh = getIntent().getStringExtra("free_wifi_appid");
        this.mNc = getIntent().getStringExtra("free_wifi_head_img_url");
        this.mNd = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.mNe = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.mNf = getIntent().getStringExtra("free_wifi_privacy_url");
        this.mKP = getIntent().getStringExtra("free_wifi_app_nickname");
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.className, this.ssid, this.mKN, this.fqu, Integer.valueOf(this.cPf), Integer.valueOf(this.fei), Integer.valueOf(this.mKO), this.fGh, this.mNc, this.mNd, this.mNf);
        this.mNb = findViewById(R.h.cUs);
        this.mMV = (ImageView) findViewById(R.h.cjj);
        this.mMW = (TextView) findViewById(R.h.cjV);
        this.mMX = (TextView) findViewById(R.h.cjI);
        this.mMI = (TextView) findViewById(R.h.cjq);
        this.mMJ = (TextView) findViewById(R.h.cjo);
        this.mMK = (TextView) findViewById(R.h.cjp);
        this.mMY = (Button) findViewById(R.h.bXb);
        this.mMY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                FreeWifiFrontPageUI.this.aNj();
            }
        });
        this.mMZ = (Button) findViewById(R.h.cUt);
        this.mMZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", FreeWifiFrontPageUI.this.mNf);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bl.d.b(FreeWifiFrontPageUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        if (bi.oN(this.ssid)) {
            this.mMX.setText(getString(R.l.ekn));
            this.mMY.setVisibility(4);
        }
        setMMTitle(getString(R.l.ekp));
        a(d.START, null);
    }

    private void aNj() {
        l.s(com.tencent.mm.plugin.freewifi.model.d.aMm(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        d aNi = aNi();
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.className, aNi.name());
        if (aNi() == d.START || aNi() == d.FAIL) {
            x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", m.D(getIntent()), Integer.valueOf(m.E(getIntent())), this.className, Boolean.valueOf(this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false)), Integer.valueOf(m.aLR()));
            if (this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false) && r1 == 1 && this.mKO != 33) {
                com.tencent.mm.ui.base.h.a((Context) this, R.l.ejJ, R.l.ejK, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        m.cH(FreeWifiFrontPageUI.this);
                    }
                }, null);
                return;
            }
            this.mNi = d.CONNECTING;
            aNl();
            this.mNg.connect();
        }
    }

    protected final void aNk() {
        this.mMI.setVisibility(4);
        if (this.mKO == 31) {
            this.mMY.setVisibility(8);
        } else {
            this.mMY.setVisibility(0);
            this.mMY.setText(R.l.dUA);
        }
        if (!(m.G(getIntent()) != 10 || m.Bf(q.gHK.gIg) || m.Bf(q.aI(this.mController.xRr)))) {
            this.mMY.setText(String.format(getString(R.l.ejL), new Object[]{q.aI(this.mController.xRr)}));
        }
        if (!bi.oN(this.mNe)) {
            this.mMX.setText(this.mNe);
        } else if (this.mKO == 33) {
            this.mMX.setText(getString(R.l.dUw) + ": " + this.ssid);
        } else {
            this.mMX.setText(getString(R.l.dUw));
        }
        if (!bi.oN(this.fGh)) {
            if (!bi.oN(this.mKP)) {
                this.mMW.setText(this.mKP);
            }
            if (!bi.oN(this.mNc)) {
                o.PG().a(this.mNc, this.mMV, this.hEY);
            }
        }
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
    }

    protected final void aNl() {
        this.mMI.setVisibility(4);
        this.mMJ.setVisibility(4);
        this.mMK.setVisibility(4);
        this.mMY.setText(R.l.dUx);
        Context context = this.mController.xRr;
        OnCancelListener anonymousClass6 = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                com.tencent.mm.plugin.freewifi.model.d.a(FreeWifiFrontPageUI.this.ssid, 4, FreeWifiFrontPageUI.this.getIntent());
                x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", m.D(FreeWifiFrontPageUI.this.getIntent()), Integer.valueOf(m.E(FreeWifiFrontPageUI.this.getIntent())), Integer.valueOf(4));
            }
        };
        View inflate = View.inflate(context, R.i.diK, null);
        Dialog kVar = new k(context, R.m.eZb);
        kVar.setCancelable(true);
        kVar.setContentView(inflate);
        kVar.setOnCancelListener(anonymousClass6);
        this.mNa = kVar;
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
        this.mNa.show();
    }

    protected final void bs(Object obj) {
        if (obj instanceof a) {
            CharSequence string;
            a aVar = (a) obj;
            x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", m.D(this.intent), Integer.valueOf(m.E(this.intent)), aVar.mMO);
            if (this.mNa != null) {
                this.mNa.dismiss();
            }
            this.mMI.setVisibility(0);
            if (m.Bf(aVar.text)) {
                if (aVar.jHN == 0) {
                    aVar.jHN = R.l.ejN;
                }
                string = getString(aVar.jHN);
            } else {
                string = aVar.text;
            }
            this.mMI.setText(string);
            this.mMI.setVisibility(0);
            this.mMJ.setVisibility(0);
            this.mMK.setVisibility(0);
            final String str = getString(R.l.ejY) + ": " + aVar.mMO;
            this.mMK.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_show_detail_error", 1);
                    intent.putExtra("free_wifi_error_ui_error_msg", FreeWifiFrontPageUI.this.getString(R.l.ejM));
                    intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                    intent.setClass(FreeWifiFrontPageUI.this, FreeWifiErrorUI.class);
                    FreeWifiFrontPageUI.this.startActivity(intent);
                }
            });
            this.mMY.setVisibility(0);
            this.mMY.setText(R.l.ekl);
            x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
        }
    }

    protected final void bt(Object obj) {
        if (obj instanceof b) {
            com.tencent.mm.plugin.freewifi.k.a aLL;
            em emVar = ((b) obj).mNm;
            if (!(this.mKO == 31 || this.mNa == null)) {
                this.mNa.dismiss();
            }
            this.mMY.setText(R.l.dUu);
            this.mMY.setClickable(false);
            Intent intent = getIntent();
            intent.putExtra("free_wifi_appid", emVar.nqc);
            intent.putExtra("free_wifi_app_nickname", emVar.kzN);
            intent.putExtra("free_wifi_app_username", emVar.kyG);
            intent.putExtra("free_wifi_signature", emVar.hxh);
            intent.putExtra("free_wifi_finish_actioncode", emVar.vQy);
            intent.putExtra("free_wifi_finish_url", emVar.vQz);
            intent.putExtra(com.tencent.mm.ui.e.c.xMN, emVar.mOo);
            if (emVar.vQy == 2) {
                if (bi.oN(emVar.kyG)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", emVar.kyG);
                    com.tencent.mm.bl.d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                    d.xd();
                    x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
                    aLL = com.tencent.mm.plugin.freewifi.k.aLL();
                    aLL.fqu = this.fqu;
                    aLL.mIi = m.D(intent);
                    aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoContactInfoUI.mIW;
                    aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoContactInfoUI.name;
                    aLL.fDM = m.G(intent);
                    aLL.mIj = m.F(intent);
                    aLL.result = 0;
                    aLL.lfa = "";
                    aLL.aLN().b(intent, true).aLM();
                    return;
                }
            } else if (m.Bf(emVar.vQA)) {
                intent.setClass(this, FreeWifiSuccUI.class);
            } else {
                intent.putExtra("free_wifi_qinghuai_url", emVar.vQA);
                intent.setClass(this, FreeWifiSuccWebViewUI.class);
            }
            aLL = com.tencent.mm.plugin.freewifi.k.aLL();
            aLL.fqu = this.fqu;
            aLL.mIi = m.D(intent);
            aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoSuc.mIW;
            aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoSuc.name;
            aLL.fDM = m.G(intent);
            aLL.mIj = m.F(intent);
            aLL.result = 0;
            aLL.lfa = "";
            aLL.aLN().b(intent, true).aLM();
            finish();
            startActivity(intent);
            d.xd();
            x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", m.D(getIntent()), Integer.valueOf(m.E(getIntent())));
        }
    }

    public void finish() {
        super.finish();
        com.tencent.mm.plugin.freewifi.k.a aLL = com.tencent.mm.plugin.freewifi.k.aLL();
        aLL.fqu = this.fqu;
        aLL.mIi = m.D(this.intent);
        aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosed.mIW;
        aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosed.name;
        aLL.fDM = m.G(this.intent);
        aLL.mIj = m.F(this.intent);
        aLL.result = 0;
        aLL.lfa = "";
        aLL.aLN().b(this.intent, true).aLM();
    }

    protected final int getLayoutId() {
        return R.i.diE;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        l.t(com.tencent.mm.plugin.freewifi.model.d.aMm(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        com.tencent.mm.plugin.freewifi.k.a aLL = com.tencent.mm.plugin.freewifi.k.aLL();
        aLL.fqu = this.fqu;
        aLL.mIi = m.D(this.intent);
        aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoBack.mIW;
        aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoBack.name;
        aLL.fDM = m.G(this.intent);
        aLL.mIj = m.F(this.intent);
        aLL.result = 0;
        aLL.lfa = "";
        aLL.aLN().b(this.intent, true).aLM();
        com.tencent.mm.plugin.freewifi.g.ihN.i(new Intent(), this);
        finish();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.freewifi.model.j.aMy().release();
    }
}
