package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.f.a.hg;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.luckymoney.b.ab;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.m;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.luckymoney.particles.a.a;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private View Lr;
    private long kIK = 0;
    private boolean lGi = false;
    private View lHm;
    private TextView lpZ;
    private TextView lsa;
    private ImageView mbn;
    private SoundPool oex;
    private b ofV = new b() {
        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            switch (random.nextInt(8)) {
                case 0:
                    if (LuckyMoneyDetailUI.this.onm == null) {
                        LuckyMoneyDetailUI.this.onm = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.ujt), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.onm);
                case 1:
                    if (LuckyMoneyDetailUI.this.onn == null) {
                        LuckyMoneyDetailUI.this.onn = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.uju), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.onn);
                case 2:
                    if (LuckyMoneyDetailUI.this.ono == null) {
                        LuckyMoneyDetailUI.this.ono = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.ujv), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.ono);
                case 3:
                    if (LuckyMoneyDetailUI.this.onh == null) {
                        LuckyMoneyDetailUI.this.onh = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.ujo), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.onh);
                case 4:
                    if (LuckyMoneyDetailUI.this.oni == null) {
                        LuckyMoneyDetailUI.this.oni = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.ujp), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.oni);
                case 5:
                    if (LuckyMoneyDetailUI.this.onj == null) {
                        LuckyMoneyDetailUI.this.onj = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.ujq), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.onj);
                case 6:
                    if (LuckyMoneyDetailUI.this.onk == null) {
                        LuckyMoneyDetailUI.this.onk = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.ujr), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.onk);
                case 7:
                    if (LuckyMoneyDetailUI.this.onl == null) {
                        LuckyMoneyDetailUI.this.onl = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyDetailUI.this.getResources(), e.ujs), 28, 28, false);
                    }
                    return new a(LuckyMoneyDetailUI.this.onl);
                default:
                    return null;
            }
        }
    };
    private int ohM = -1;
    private ListView olW;
    private ImageView olX;
    private TextView olY;
    private TextView olZ;
    private ImageView omY;
    private ImageView omZ;
    private View oma;
    private TextView omb;
    private LuckyMoneyWishFooter omc;
    private View omd;
    private ImageView ome;
    private View omf;
    private boolean omh = true;
    private int omi;
    private String omj;
    private String omk;
    private String oml;
    private String omm;
    private List<m> omo = new LinkedList();
    private Map<String, Integer> omp = new HashMap();
    private i omq;
    private String omr = "";
    private boolean oms = false;
    OnScrollListener omt = new OnScrollListener() {
        private boolean omu = false;
        private boolean omv;

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (absListView.getCount() != 0) {
                switch (i) {
                    case 0:
                        if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                            if (!LuckyMoneyDetailUI.this.olU.aXJ()) {
                                LuckyMoneyDetailUI.this.lGi = false;
                            }
                            if (LuckyMoneyDetailUI.this.omh && !LuckyMoneyDetailUI.this.lGi) {
                                LuckyMoneyDetailUI.this.aYg();
                            }
                        }
                        this.omu = false;
                        return;
                    case 1:
                        this.omu = true;
                        return;
                    default:
                        return;
                }
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            if (i3 != 0 && this.omu) {
                if (i <= 0) {
                    int top;
                    View childAt = absListView.getChildAt(i);
                    if (childAt != null) {
                        top = 0 - childAt.getTop();
                    } else {
                        top = 0;
                    }
                    if (top <= 100) {
                        z = false;
                    }
                }
                if (this.omv != z) {
                    if (z) {
                        LuckyMoneyDetailUI.this.r(LuckyMoneyDetailUI.this.getResources().getDrawable(e.uji));
                    } else {
                        LuckyMoneyDetailUI.this.r(null);
                    }
                    this.omv = z;
                }
            }
        }
    };
    private View ona;
    private ImageView onb;
    private TextView onc;
    private View ond;
    private RelativeLayout one;
    private int[] onf;
    private ViewGroup ong;
    private Bitmap onh;
    private Bitmap oni;
    private Bitmap onj;
    private Bitmap onk;
    private Bitmap onl;
    private Bitmap onm;
    private Bitmap onn;
    private Bitmap ono;
    private final int onp = 750;
    private final int onq = 240;
    private int wn = 0;

    static /* synthetic */ void w(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics = luckyMoneyDetailUI.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            x.i("MicroMsg.LuckyMoneyDetailUI", "hy: screen  width: %d, scale : %f, fixedHeight: %d", Integer.valueOf(displayMetrics.widthPixels), Double.valueOf(((double) displayMetrics.widthPixels) / 750.0d), Integer.valueOf((int) (240.0d * (((double) displayMetrics.widthPixels) / 750.0d))));
            luckyMoneyDetailUI.one.setLayoutParams(new LayoutParams(luckyMoneyDetailUI.one.getLayoutParams().width, r1));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.omj = getIntent().getStringExtra("key_sendid");
        this.oml = getIntent().getStringExtra("key_native_url");
        this.omi = getIntent().getIntExtra("key_jump_from", 2);
        x.i("MicroMsg.LuckyMoneyDetailUI", "sendid=" + bi.oM(this.omj) + ", nativeurl=" + bi.oM(this.oml) + ", jumpFrom=" + this.omi);
        if (this.omi == 2) {
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (byteArrayExtra != null) {
                    com.tencent.mm.plugin.luckymoney.b.e eVar = (com.tencent.mm.plugin.luckymoney.b.e) new com.tencent.mm.plugin.luckymoney.b.e().aH(byteArrayExtra);
                    if (eVar != null) {
                        a(eVar);
                        if (getIntent().getBooleanExtra("play_sound", false)) {
                            k.H(this, i.uQk);
                        }
                        addTextOptionMenu(0, getString(i.uQp), new OnMenuItemClickListener() {
                            public final boolean onMenuItemClick(MenuItem menuItem) {
                                g.pWK.h(11701, Integer.valueOf(LuckyMoneyDetailUI.sv(LuckyMoneyDetailUI.this.ohM)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                                Intent intent = new Intent();
                                intent.setClass(LuckyMoneyDetailUI.this.mController.xRr, LuckyMoneyMyRecordUI.class);
                                intent.putExtra("key_type", 2);
                                LuckyMoneyDetailUI.this.startActivity(intent);
                                return true;
                            }
                        });
                    }
                }
            } catch (Exception e) {
                x.w("MicroMsg.LuckyMoneyDetailUI", "Parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (bi.oN(this.omj) && !bi.oN(this.oml)) {
            try {
                this.omj = Uri.parse(this.oml).getQueryParameter("sendid");
            } catch (Exception e2) {
            }
        }
        if (bi.oN(this.omj)) {
            x.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
        } else {
            aYg();
        }
        if (getIntent().getBooleanExtra("play_sound", false)) {
            k.H(this, i.uQk);
        }
        addTextOptionMenu(0, getString(i.uQp), /* anonymous class already generated */);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        TextView textView = (TextView) findViewById(f.bIL);
        if (textView != null) {
            textView.setTextColor(getResources().getColor(c.uhq));
        }
        return onCreatePanelMenu;
    }

    protected void onResume() {
        super.onResume();
        this.kIK = bi.Wx();
    }

    protected void onPause() {
        super.onPause();
        d.g("LuckyMoneyDetailUI", this.kIK, bi.Wx());
    }

    protected final void initView() {
        setMMTitle(i.uQr);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                LuckyMoneyDetailUI.this.finish();
                return true;
            }
        });
        this.olW = (ListView) findViewById(f.utS);
        this.omq = new i(this.mController.xRr);
        this.Lr = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uIQ, null);
        this.olW.addHeaderView(this.Lr);
        this.olW.setAdapter(this.omq);
        this.Lr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyDetailUI.this.aYh();
            }
        });
        this.olW.setOnScrollListener(this.omt);
        this.olW.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                LuckyMoneyDetailUI.this.aYh();
            }
        });
        this.lHm = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uIP, null);
        this.olX = (ImageView) this.Lr.findViewById(f.utU);
        this.olY = (TextView) this.Lr.findViewById(f.utX);
        this.omY = (ImageView) this.Lr.findViewById(f.utF);
        this.olZ = (TextView) this.Lr.findViewById(f.utZ);
        this.oma = this.Lr.findViewById(f.uty);
        this.omb = (TextView) this.Lr.findViewById(f.utx);
        this.omd = this.Lr.findViewById(f.utH);
        this.lsa = (TextView) this.Lr.findViewById(f.utV);
        this.ome = (ImageView) this.Lr.findViewById(f.utG);
        this.lpZ = (TextView) this.Lr.findViewById(f.utB);
        this.omZ = (ImageView) this.Lr.findViewById(f.utW);
        this.omf = this.Lr.findViewById(f.utQ);
        this.ona = this.Lr.findViewById(f.utA);
        this.onb = (ImageView) this.Lr.findViewById(f.utz);
        this.onc = (TextView) this.Lr.findViewById(f.utI);
        this.ond = findViewById(f.utJ);
        this.one = (RelativeLayout) this.Lr.findViewById(f.utA);
        this.mbn = (ImageView) this.Lr.findViewById(f.utz);
        this.omc = (LuckyMoneyWishFooter) findViewById(f.utY);
        this.ong = (ViewGroup) findViewById(f.uud);
        this.omc.a(new MMEditText.a() {
            public final void aYi() {
                if (LuckyMoneyDetailUI.this.omc.getVisibility() == 0) {
                    LuckyMoneyDetailUI.this.omc.setVisibility(8);
                } else {
                    LuckyMoneyDetailUI.this.mController.xRr.finish();
                }
            }
        });
        this.omc.a(new LuckyMoneyWishFooter.a() {
            public final void EE(String str) {
                if (!bi.oN(str) && !bi.oN(LuckyMoneyDetailUI.this.omk)) {
                    LuckyMoneyDetailUI.this.l(new ab(LuckyMoneyDetailUI.this.omj, str, LuckyMoneyDetailUI.this.omk, "v1.0"));
                    LuckyMoneyDetailUI.this.aYh();
                }
            }
        });
        this.omc.post(new Runnable() {
            public final void run() {
                j.h(LuckyMoneyDetailUI.this);
            }
        });
        this.omc.xPq = new KeyboardLinearLayout.a() {
            public final void ra(int i) {
                if (i == -2 && LuckyMoneyDetailUI.this.omc.oqd) {
                    LuckyMoneyDetailUI.this.omc.oqd = false;
                }
            }
        };
        this.omq.opI = new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyDetailUI.this.omc.setVisibility(0);
            }
        };
        this.omc.aYx();
        this.onc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyDetailUI.this.omc.setVisibility(0);
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.omc.getVisibility() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.omc.setVisibility(8);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof v) {
            if (i == 0 && i2 == 0) {
                v vVar = (v) kVar;
                com.tencent.mm.plugin.luckymoney.b.e eVar = vVar.oiv;
                this.omr = vVar.oiI;
                a(eVar);
                return true;
            }
            h.bu(this, str);
            return true;
        } else if (kVar instanceof ab) {
            if (i == 0 && i2 == 0) {
                h.bu(this, getString(i.epo));
                this.omq.opH = false;
                aYh();
                ab abVar = (ab) kVar;
                if (this.omo != null) {
                    for (int i3 = 0; i3 < this.omo.size(); i3++) {
                        m mVar = (m) this.omo.get(i3);
                        if (mVar.ohB.equalsIgnoreCase(abVar.ohB)) {
                            mVar.oik = abVar.oht;
                            this.omq.notifyDataSetChanged();
                            break;
                        }
                    }
                    if (this.onc.getVisibility() == 0) {
                        this.onc.setVisibility(8);
                        this.lpZ.setVisibility(0);
                        this.ond.setVisibility(8);
                        this.omq.bf(this.omo);
                    }
                }
                return true;
            }
            h.bu(this, str);
            return true;
        } else if (!(kVar instanceof ag)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.ui.snackbar.a.h(this, getString(i.epo));
                return true;
            }
            h.bu(this, str);
            return true;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bi.oN(stringExtra)) {
                        if (this.omm != null && this.omm.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")) {
                            x.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
                            break;
                        } else {
                            l(new ag(stringExtra.replaceAll(",", "|"), this.omj, "v1.0"));
                            break;
                        }
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void finish() {
        if (getIntent().hasExtra("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getIntent().getParcelableExtra("key_realname_guide_helper");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyDetailUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            boolean b = realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
                    super.finish();
                }
            });
            getIntent().removeExtra("key_realname_guide_helper");
            if (!b) {
                super.finish();
                return;
            }
            return;
        }
        super.finish();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uIR;
    }

    private void aYg() {
        this.lGi = true;
        if (this.wn <= 0 || this.omo.size() <= 0 || this.omo.get(this.omo.size() - 1) == null) {
            this.omr = "";
            l(new v(this.omj, 11, this.wn, this.oml, "v1.0", this.omr));
            return;
        }
        l(new v(this.omj, this.wn, this.oml, bi.getLong(((m) this.omo.get(this.omo.size() - 1)).ohX, 0), "v1.0", this.omr));
    }

    private void a(final com.tencent.mm.plugin.luckymoney.b.e eVar) {
        if (eVar != null) {
            this.omh = eVar.ohE == 1;
            if (this.wn == 0) {
                this.omk = eVar.ohB;
                Object obj = (eVar == null || eVar.ohq != 0 || eVar.ohN == null || eVar.ohN.size() <= 0 || !((m) eVar.ohN.get(0)).ohB.equals(this.omk) || eVar.ohC == 1) ? null : 1;
                if (obj != null) {
                    this.omq.opH = false;
                    this.onc.setVisibility(0);
                    this.ond.setVisibility(0);
                    this.lpZ.setVisibility(8);
                } else {
                    this.lpZ.setVisibility(0);
                    this.omq.opG = this.omk;
                }
                this.omq.opJ = eVar.ohM;
                if (eVar != null) {
                    Context context = this.mController.xRr;
                    if (eVar.ohM == 2) {
                        this.olX.setImageResource(e.ujm);
                        if (eVar.resourceId != 0) {
                            x.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + eVar.resourceId);
                            final com.tencent.mm.sdk.b.b hgVar = new hg();
                            hgVar.fyo.fyq = eVar.resourceId;
                            hgVar.frD = new Runnable() {
                                public final void run() {
                                    if (hgVar.fyp.fyr) {
                                        x.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + hgVar.fyp.fys);
                                        ActionBarActivity actionBarActivity = LuckyMoneyDetailUI.this.mController.xRr;
                                        n.e(LuckyMoneyDetailUI.this.olX, hgVar.fyp.fys, e.ujm);
                                        return;
                                    }
                                    x.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                                    n.a(LuckyMoneyDetailUI.this.olX, eVar.ohv, eVar.ohP);
                                }
                            };
                            com.tencent.mm.sdk.b.a.xmy.a(hgVar, Looper.myLooper());
                        } else {
                            n.a(this.olX, eVar.ohv, eVar.ohP);
                        }
                    } else {
                        n.a(this.olX, eVar.ohv, eVar.ohP);
                    }
                    n.a(context, this.olY, eVar.ohu);
                    n.a(context, this.olZ, eVar.oht);
                    if (eVar.ohq == 1) {
                        this.omY.setVisibility(0);
                        this.omY.setImageResource(e.ujy);
                    } else if (eVar.ohq == 2) {
                        if (!s.gH(eVar.ohP)) {
                            com.tencent.mm.ac.h hVar = new com.tencent.mm.ac.h();
                            hVar.username = eVar.ohP;
                            com.tencent.mm.ac.n.JW().a(hVar);
                        }
                        this.omY.setVisibility(0);
                        this.omY.setImageResource(e.ujw);
                    } else {
                        this.omY.setVisibility(8);
                    }
                    if (!bi.oN(eVar.ohK)) {
                        n.d(this.omZ, eVar.ohK, e.ujA);
                        this.omZ.setScaleType(ScaleType.FIT_XY);
                    }
                    if (bi.oN(eVar.ohL)) {
                        x.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
                        this.one.setVisibility(8);
                    } else {
                        x.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", eVar.ohL);
                        this.one.setVisibility(4);
                        n.h(this.mbn, eVar.ohL);
                        ah.h(new Runnable() {
                            public final void run() {
                                LuckyMoneyDetailUI.w(LuckyMoneyDetailUI.this);
                                LuckyMoneyDetailUI.this.one.setVisibility(0);
                            }
                        }, 500);
                    }
                    if (eVar.fMz != 2 || this.omi == 3) {
                        this.oma.setVisibility(8);
                    } else {
                        this.omb.setText(com.tencent.mm.wallet_core.ui.e.t(((double) eVar.fMM) / 100.0d));
                        if (eVar.ohC != 1) {
                            this.omq.opH = true;
                        } else {
                            this.omq.opH = false;
                        }
                        this.oma.setVisibility(0);
                    }
                    if (bi.oN(eVar.oeO)) {
                        x.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
                        this.omd.setVisibility(8);
                    } else {
                        this.omd.setVisibility(0);
                        this.lsa.setText(eVar.oeO);
                        if (eVar.oeM == 1) {
                            if (TextUtils.isEmpty(eVar.oeN) || eVar.oeN.startsWith("weixin://wxpay")) {
                                this.ome.setVisibility(8);
                            } else {
                                this.ome.setVisibility(0);
                            }
                            this.lsa.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    if (TextUtils.isEmpty(eVar.oeN)) {
                                        com.tencent.mm.wallet_core.ui.e.HX(12);
                                        com.tencent.mm.pluginsdk.wallet.h.Y(LuckyMoneyDetailUI.this.mController.xRr, 1);
                                        g.pWK.h(13184, Integer.valueOf(0), "");
                                        x.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
                                        return;
                                    }
                                    x.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + eVar.oeN);
                                    if (eVar.oeN.startsWith("weixin://wxpay")) {
                                        com.tencent.mm.wallet_core.ui.e.HX(12);
                                        com.tencent.mm.pluginsdk.wallet.h.Y(LuckyMoneyDetailUI.this.mController.xRr, 1);
                                        g.pWK.h(13184, Integer.valueOf(0), eVar.oeN);
                                        return;
                                    }
                                    com.tencent.mm.wallet_core.ui.e.HX(7);
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", eVar.oeN);
                                    com.tencent.mm.bl.d.b(LuckyMoneyDetailUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                                    g.pWK.h(13184, Integer.valueOf(1), eVar.oeN);
                                }
                            });
                        } else {
                            x.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
                            this.lsa.setTextColor(getResources().getColor(c.uhv));
                        }
                    }
                    if (bi.oN(eVar.ohF)) {
                        this.lpZ.setText(null);
                    } else {
                        this.lpZ.setText(eVar.ohF);
                    }
                }
                if (eVar != null) {
                    ViewGroup viewGroup;
                    List list = eVar.ohI;
                    if (list != null && list.size() > 0) {
                        View findViewById = this.Lr.findViewById(f.utN);
                        View findViewById2 = this.Lr.findViewById(f.utO);
                        View findViewById3 = this.Lr.findViewById(f.utP);
                        viewGroup = (ViewGroup) this.Lr.findViewById(f.utK);
                        ViewGroup viewGroup2 = (ViewGroup) this.Lr.findViewById(f.utL);
                        ViewGroup viewGroup3 = (ViewGroup) this.Lr.findViewById(f.utM);
                        View findViewById4 = this.Lr.findViewById(f.utC);
                        View findViewById5 = this.Lr.findViewById(f.utD);
                        g.c cVar = new g.c();
                        cVar.textColor = getResources().getColor(c.uhr);
                        if (list.size() > 0) {
                            g.a(this, viewGroup, (com.tencent.mm.plugin.luckymoney.b.ah) list.get(0), cVar);
                            findViewById.setVisibility(0);
                        }
                        if (list.size() > 1) {
                            g.a(this, viewGroup2, (com.tencent.mm.plugin.luckymoney.b.ah) list.get(1), cVar);
                            findViewById2.setVisibility(0);
                        }
                        if (list.size() > 2) {
                            g.a(this, viewGroup3, (com.tencent.mm.plugin.luckymoney.b.ah) list.get(2), cVar);
                            findViewById3.setVisibility(0);
                        }
                        if (findViewById.getVisibility() == 0 && (findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0)) {
                            findViewById4.setVisibility(0);
                        }
                        if (findViewById2.getVisibility() == 0 && findViewById3.getVisibility() == 0) {
                            findViewById5.setVisibility(0);
                        }
                        if (findViewById.getVisibility() == 0 || findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0) {
                            this.omf.requestLayout();
                            this.omf.setVisibility(0);
                        }
                    }
                    viewGroup = (ViewGroup) this.lHm.findViewById(f.utE);
                    g.c cVar2 = new g.c();
                    cVar2.textColor = getResources().getColor(c.uhr);
                    cVar2.textSize = getResources().getDimensionPixelSize(com.tencent.mm.plugin.wxpay.a.d.bvV);
                    g.a(this, viewGroup, eVar.ohJ, cVar2);
                }
                g.pWK.h(11701, Integer.valueOf(sv(eVar.ohM)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            }
            if (eVar != null) {
                Object obj2 = ((eVar.fMy == 3 || eVar.fMy == 2) && eVar.ohD == 1 && !this.omh && eVar.ohG == 1) ? 1 : null;
                Object obj3 = (eVar.ohH == null || eVar.ohH.gGi != 1 || bi.oN(eVar.ohH.ohb)) ? null : 1;
                TextView textView = (TextView) this.lHm.findViewById(f.utT);
                if (obj2 == null && obj3 == null) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            g.pWK.h(11701, Integer.valueOf(LuckyMoneyDetailUI.sv(eVar.ohM)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                            n.a(LuckyMoneyDetailUI.this, 1, false);
                        }
                    });
                    if (obj3 != null) {
                        this.omm = eVar.ohH.ohb;
                        textView.setText(eVar.ohH.ohc);
                    }
                    g.pWK.h(11701, Integer.valueOf(sv(eVar.ohM)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                    textView.setVisibility(0);
                }
                this.ohM = eVar.ohM;
                ((TextView) this.lHm.findViewById(f.utR)).setVisibility(8);
                if (!this.oms) {
                    this.olW.addFooterView(this.lHm);
                    this.oms = true;
                }
            }
            List list2 = eVar.ohN;
            if (list2 != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list2.size()) {
                        break;
                    }
                    m mVar = (m) list2.get(i2);
                    if (!this.omp.containsKey(mVar.ohB)) {
                        this.omo.add(list2.get(i2));
                        this.omp.put(mVar.ohB, Integer.valueOf(1));
                    }
                    i = i2 + 1;
                }
                this.wn += list2.size();
                this.lGi = false;
                if (this.onc.getVisibility() != 0) {
                    this.lpZ.setVisibility(0);
                    this.omq.bf(this.omo);
                }
            }
            if (eVar.ohq == 2 && !bi.oN(eVar.ohs)) {
                this.oex = new SoundPool(2, 3, 0);
                this.onf = new int[2];
                try {
                    this.onf[0] = this.oex.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
                    this.onf[1] = this.oex.load(getResources().getAssets().openFd("whistle.m4a"), 0);
                } catch (IOException e) {
                    x.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + e.getMessage());
                }
                this.oex.setOnLoadCompleteListener(new OnLoadCompleteListener() {
                    public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
                        if (i2 != 0) {
                            return;
                        }
                        if (i == LuckyMoneyDetailUI.this.onf[0]) {
                            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                        } else if (i == LuckyMoneyDetailUI.this.onf[1] && eVar.fMM >= 19000) {
                            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                        }
                    }
                });
                this.Lr.postDelayed(new Runnable() {
                    public final void run() {
                        ViewGroup t = LuckyMoneyDetailUI.this.ong;
                        b u = LuckyMoneyDetailUI.this.ofV;
                        com.tencent.mm.plugin.luckymoney.particles.a aVar = new com.tencent.mm.plugin.luckymoney.particles.a(t);
                        com.tencent.mm.plugin.luckymoney.particles.c ak = new com.tencent.mm.plugin.luckymoney.particles.c(t.getContext(), u, new com.tencent.mm.plugin.luckymoney.particles.d(-100, t.getHeight() / 2), t).y(600.0f, 150.0f).z(-1000.0f, 250.0f).aj(-200.0f).ak(1500.0f);
                        ak.okg = 600.0f;
                        ak.okh = 300.0f;
                        ak = ak.aXQ();
                        ak.ojK = com.tencent.mm.plugin.luckymoney.particles.e.aXU();
                        aVar.ojy = ak.aXR().aXS();
                        aVar.y(100, 400);
                        t = LuckyMoneyDetailUI.this.ong;
                        u = LuckyMoneyDetailUI.this.ofV;
                        aVar = new com.tencent.mm.plugin.luckymoney.particles.a(t);
                        ak = new com.tencent.mm.plugin.luckymoney.particles.c(t.getContext(), u, new com.tencent.mm.plugin.luckymoney.particles.d(t.getWidth() + 100, t.getHeight() / 2), t).y(-600.0f, 150.0f).z(-1000.0f, 250.0f).aj(200.0f).ak(1500.0f);
                        ak.okg = 600.0f;
                        ak.okh = 300.0f;
                        ak = ak.aXQ();
                        ak.ojK = com.tencent.mm.plugin.luckymoney.particles.e.aXU();
                        aVar.ojy = ak.aXR().aXS();
                        aVar.y(100, 400);
                    }
                }, 300);
            }
            y yVar = new y();
            yVar.field_mNativeUrl = this.oml;
            yVar.field_hbType = eVar.ohq;
            yVar.field_receiveAmount = eVar.fMM;
            yVar.field_receiveTime = System.currentTimeMillis();
            yVar.field_hbStatus = eVar.fMy;
            yVar.field_receiveStatus = eVar.fMz;
            if (yVar.field_receiveAmount > 0) {
                o.bLZ().a(yVar);
            }
        }
    }

    private void aYh() {
        if (this.omc != null && this.omc.getVisibility() != 8) {
            this.omc.setVisibility(8);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.omc != null) {
            this.omc.aYy();
        }
        if (this.oex != null) {
            this.oex.release();
            for (int unload : this.onf) {
                this.oex.unload(unload);
            }
        }
    }

    private static int sv(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }
}
