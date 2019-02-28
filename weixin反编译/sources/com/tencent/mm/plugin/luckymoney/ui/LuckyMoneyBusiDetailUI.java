package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.luckymoney.b.ab;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.m;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a(3)
public class LuckyMoneyBusiDetailUI extends LuckyMoneyBaseUI {
    private View Lr;
    private boolean lGi = false;
    private View lHm;
    private TextView lpZ;
    private TextView lsa;
    private ListView olW;
    private ImageView olX;
    private TextView olY;
    private TextView olZ;
    private View oma;
    private TextView omb;
    private LuckyMoneyWishFooter omc;
    private View omd;
    private ImageView ome;
    private View omf;
    private ImageView omg;
    private boolean omh = true;
    private int omi;
    private String omj;
    private String omk;
    private String oml;
    private String omm;
    private int omn = 0;
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
                            if (!LuckyMoneyBusiDetailUI.this.olU.aXJ()) {
                                LuckyMoneyBusiDetailUI.this.lGi = false;
                            }
                            if (LuckyMoneyBusiDetailUI.this.omh && !LuckyMoneyBusiDetailUI.this.lGi) {
                                LuckyMoneyBusiDetailUI.this.aYg();
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
                        LuckyMoneyBusiDetailUI.this.r(LuckyMoneyBusiDetailUI.this.getResources().getDrawable(e.uji));
                    } else {
                        LuckyMoneyBusiDetailUI.this.r(null);
                    }
                    this.omv = z;
                }
            }
        }
    };
    private int wn = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.olW = (ListView) findViewById(f.unM);
        this.omq = new i(this.mController.xRr);
        this.Lr = LayoutInflater.from(this).inflate(g.uIM, null);
        this.olW.addHeaderView(this.Lr);
        this.olW.setAdapter(this.omq);
        this.Lr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyBusiDetailUI.this.aYh();
            }
        });
        this.olW.setOnScrollListener(this.omt);
        this.olW.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                LuckyMoneyBusiDetailUI.this.aYh();
            }
        });
        this.lHm = LayoutInflater.from(this).inflate(g.uIL, null);
        this.olX = (ImageView) this.Lr.findViewById(f.unv);
        this.olY = (TextView) this.Lr.findViewById(f.unP);
        this.olZ = (TextView) this.Lr.findViewById(f.unR);
        this.oma = this.Lr.findViewById(f.unu);
        this.omb = (TextView) this.Lr.findViewById(f.unt);
        this.omd = this.Lr.findViewById(f.unC);
        this.lsa = (TextView) this.Lr.findViewById(f.unO);
        this.ome = (ImageView) this.Lr.findViewById(f.unD);
        this.lpZ = (TextView) this.Lr.findViewById(f.uny);
        this.omf = this.Lr.findViewById(f.unK);
        this.omg = (ImageView) this.Lr.findViewById(f.uns);
        ImageView imageView = (ImageView) findViewById(f.unx);
        this.omc = (LuckyMoneyWishFooter) findViewById(f.unQ);
        this.omc.a(new MMEditText.a() {
            public final void aYi() {
                if (LuckyMoneyBusiDetailUI.this.omc.getVisibility() == 0) {
                    LuckyMoneyBusiDetailUI.this.omc.setVisibility(8);
                } else {
                    LuckyMoneyBusiDetailUI.this.mController.xRr.finish();
                }
            }
        });
        this.omc.a(new LuckyMoneyWishFooter.a() {
            public final void EE(String str) {
                if (!bi.oN(str) && !bi.oN(LuckyMoneyBusiDetailUI.this.omk)) {
                    LuckyMoneyBusiDetailUI.this.l(new ab(LuckyMoneyBusiDetailUI.this.omj, str, LuckyMoneyBusiDetailUI.this.omk, "v1.0"));
                    LuckyMoneyBusiDetailUI.this.aYh();
                }
            }
        });
        this.omc.post(new Runnable() {
            public final void run() {
                j.h(LuckyMoneyBusiDetailUI.this);
            }
        });
        this.omc.xPq = new KeyboardLinearLayout.a() {
            public final void ra(int i) {
                if (i == -2 && LuckyMoneyBusiDetailUI.this.omc.oqd) {
                    LuckyMoneyBusiDetailUI.this.omc.oqd = false;
                }
            }
        };
        this.omq.opI = new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyBusiDetailUI.this.omc.setVisibility(0);
            }
        };
        i iVar = this.omq;
        iVar.opK = new a();
        this.omc.aYx();
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyBusiDetailUI.this.finish();
            }
        });
        View findViewById = findViewById(f.unw);
        if (findViewById != null) {
            Drawable background = findViewById.getBackground();
            if (background != null && (background instanceof BitmapDrawable)) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
                bitmapDrawable.mutate();
                bitmapDrawable.setTileModeX(TileMode.REPEAT);
            }
        }
        this.omj = getIntent().getStringExtra("key_sendid");
        this.oml = getIntent().getStringExtra("key_native_url");
        this.omi = getIntent().getIntExtra("key_jump_from", 2);
        this.omn = getIntent().getIntExtra("key_static_from_scene", 0);
        x.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", this.omj, this.oml, Integer.valueOf(this.omi));
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
                    }
                }
            } catch (Exception e) {
                x.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (bi.oN(this.omj) && !bi.oN(this.oml)) {
            try {
                this.omj = Uri.parse(this.oml).getQueryParameter("sendid");
            } catch (Exception e2) {
                x.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + e2.getLocalizedMessage());
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
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.omc.getVisibility() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.omc.setVisibility(8);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
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
                    while (true) {
                        boolean z2 = z;
                        if (z2 >= this.omo.size()) {
                            break;
                        }
                        m mVar = (m) this.omo.get(z2);
                        if (mVar.ohB.equalsIgnoreCase(abVar.ohB)) {
                            mVar.oik = abVar.oht;
                            this.omq.notifyDataSetChanged();
                            break;
                        }
                        z = z2 + 1;
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
                h.bu(this, getString(i.epo));
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
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiDetailUI");
            boolean b = realnameGuideHelper.b(this, bundle, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
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
        return g.uIN;
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final com.tencent.mm.plugin.luckymoney.b.e r13) {
        /*
        r12 = this;
        if (r13 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r13.ohE;
        r1 = 1;
        if (r0 != r1) goto L_0x0339;
    L_0x0008:
        r0 = 1;
    L_0x0009:
        r12.omh = r0;
        r0 = r12.wn;
        if (r0 != 0) goto L_0x023d;
    L_0x000f:
        r0 = r13.ohB;
        r12.omk = r0;
        r0 = r12.omq;
        r1 = r12.omk;
        r0.opG = r1;
        r0 = r12.omq;
        r1 = r13.ohM;
        r0.opJ = r1;
        if (r13 == 0) goto L_0x00eb;
    L_0x0021:
        r0 = r12.mController;
        r0 = r0.xRr;
        r1 = r13.ohM;
        r2 = 2;
        if (r1 != r2) goto L_0x0344;
    L_0x002a:
        r1 = r12.olX;
        r2 = com.tencent.mm.plugin.wxpay.a.e.ujm;
        r1.setImageResource(r2);
        r1 = r13.resourceId;
        if (r1 == 0) goto L_0x033c;
    L_0x0035:
        r1 = "MicroMsg.LuckyMoneyDetailUI";
        r2 = new java.lang.StringBuilder;
        r3 = "busi logo load from file:";
        r2.<init>(r3);
        r3 = r13.resourceId;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = new com.tencent.mm.f.a.hg;
        r1.<init>();
        r2 = r1.fyo;
        r3 = r13.resourceId;
        r2.fyq = r3;
        r2 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$3;
        r2.<init>(r1, r13);
        r1.frD = r2;
        r2 = com.tencent.mm.sdk.b.a.xmy;
        r3 = android.os.Looper.myLooper();
        r2.a(r1, r3);
    L_0x0068:
        r1 = r12.olY;
        r2 = r13.ohu;
        com.tencent.mm.plugin.luckymoney.b.n.a(r0, r1, r2);
        r1 = r12.olZ;
        r2 = r13.oht;
        com.tencent.mm.plugin.luckymoney.b.n.a(r0, r1, r2);
        r0 = r13.fMz;
        r1 = 2;
        if (r0 != r1) goto L_0x0356;
    L_0x007b:
        r0 = r12.omi;
        r1 = 3;
        if (r0 == r1) goto L_0x0356;
    L_0x0080:
        r0 = r12.omb;
        r2 = r13.fMM;
        r2 = (double) r2;
        r4 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r2 = r2 / r4;
        r1 = com.tencent.mm.wallet_core.ui.e.t(r2);
        r0.setText(r1);
        r0 = r13.ohC;
        r1 = 1;
        if (r0 == r1) goto L_0x034f;
    L_0x0094:
        r0 = r12.omq;
        r1 = 1;
        r0.opH = r1;
    L_0x0099:
        r0 = r12.oma;
        r1 = 0;
        r0.setVisibility(r1);
    L_0x009f:
        r0 = r13.oeO;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x0382;
    L_0x00a7:
        r0 = r12.omd;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r12.lsa;
        r1 = r13.oeO;
        r0.setText(r1);
        r0 = r13.oeM;
        r1 = 1;
        if (r0 != r1) goto L_0x0368;
    L_0x00b9:
        r0 = r13.oeN;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x035f;
    L_0x00c1:
        r0 = r13.oeN;
        r1 = "weixin://wxpay";
        r0 = r0.startsWith(r1);
        if (r0 != 0) goto L_0x035f;
    L_0x00cc:
        r0 = r12.ome;
        r1 = 0;
        r0.setVisibility(r1);
    L_0x00d2:
        r0 = r12.lsa;
        r1 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$4;
        r1.<init>(r13);
        r0.setOnClickListener(r1);
    L_0x00dc:
        r0 = r13.ohF;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x0394;
    L_0x00e4:
        r0 = r12.lpZ;
        r1 = r13.ohF;
        r0.setText(r1);
    L_0x00eb:
        if (r13 == 0) goto L_0x0206;
    L_0x00ed:
        r4 = r13.ohI;
        if (r4 == 0) goto L_0x01da;
    L_0x00f1:
        r0 = r4.size();
        if (r0 <= 0) goto L_0x01da;
    L_0x00f7:
        r0 = r12.Lr;
        r1 = com.tencent.mm.plugin.wxpay.a.f.unH;
        r5 = r0.findViewById(r1);
        r0 = r12.Lr;
        r1 = com.tencent.mm.plugin.wxpay.a.f.unI;
        r6 = r0.findViewById(r1);
        r0 = r12.Lr;
        r1 = com.tencent.mm.plugin.wxpay.a.f.unJ;
        r7 = r0.findViewById(r1);
        r0 = r12.Lr;
        r1 = com.tencent.mm.plugin.wxpay.a.f.unE;
        r0 = r0.findViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        r1 = r12.Lr;
        r2 = com.tencent.mm.plugin.wxpay.a.f.unF;
        r1 = r1.findViewById(r2);
        r1 = (android.view.ViewGroup) r1;
        r2 = r12.Lr;
        r3 = com.tencent.mm.plugin.wxpay.a.f.unG;
        r2 = r2.findViewById(r3);
        r2 = (android.view.ViewGroup) r2;
        r3 = r12.Lr;
        r8 = com.tencent.mm.plugin.wxpay.a.f.unz;
        r8 = r3.findViewById(r8);
        r3 = r12.Lr;
        r9 = com.tencent.mm.plugin.wxpay.a.f.unA;
        r9 = r3.findViewById(r9);
        r10 = new com.tencent.mm.plugin.luckymoney.ui.g$c;
        r10.<init>();
        r3 = r12.getResources();
        r11 = com.tencent.mm.plugin.wxpay.a.c.uhp;
        r3 = r3.getColor(r11);
        r10.textColor = r3;
        r3 = 1;
        r10.ooW = r3;
        r3 = r13.resourceId;
        r10.resourceId = r3;
        r3 = r12.omn;
        r10.ooX = r3;
        r3 = r4.size();
        if (r3 <= 0) goto L_0x016d;
    L_0x015f:
        r3 = 0;
        r3 = r4.get(r3);
        r3 = (com.tencent.mm.plugin.luckymoney.b.ah) r3;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r0, r3, r10);
        r0 = 0;
        r5.setVisibility(r0);
    L_0x016d:
        r0 = r4.size();
        r3 = 1;
        if (r0 <= r3) goto L_0x0182;
    L_0x0174:
        r0 = 1;
        r0 = r4.get(r0);
        r0 = (com.tencent.mm.plugin.luckymoney.b.ah) r0;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r1, r0, r10);
        r0 = 0;
        r6.setVisibility(r0);
    L_0x0182:
        r0 = r4.size();
        r1 = 2;
        if (r0 <= r1) goto L_0x0197;
    L_0x0189:
        r0 = 2;
        r0 = r4.get(r0);
        r0 = (com.tencent.mm.plugin.luckymoney.b.ah) r0;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r2, r0, r10);
        r0 = 0;
        r7.setVisibility(r0);
    L_0x0197:
        r0 = r5.getVisibility();
        if (r0 != 0) goto L_0x01ad;
    L_0x019d:
        r0 = r6.getVisibility();
        if (r0 == 0) goto L_0x01a9;
    L_0x01a3:
        r0 = r7.getVisibility();
        if (r0 != 0) goto L_0x01ad;
    L_0x01a9:
        r0 = 0;
        r8.setVisibility(r0);
    L_0x01ad:
        r0 = r6.getVisibility();
        if (r0 != 0) goto L_0x01bd;
    L_0x01b3:
        r0 = r7.getVisibility();
        if (r0 != 0) goto L_0x01bd;
    L_0x01b9:
        r0 = 0;
        r9.setVisibility(r0);
    L_0x01bd:
        r0 = r5.getVisibility();
        if (r0 == 0) goto L_0x01cf;
    L_0x01c3:
        r0 = r6.getVisibility();
        if (r0 == 0) goto L_0x01cf;
    L_0x01c9:
        r0 = r7.getVisibility();
        if (r0 != 0) goto L_0x01da;
    L_0x01cf:
        r0 = r12.omf;
        r0.requestLayout();
        r0 = r12.omf;
        r1 = 0;
        r0.setVisibility(r1);
    L_0x01da:
        r0 = r12.lHm;
        r1 = com.tencent.mm.plugin.wxpay.a.f.unB;
        r0 = r0.findViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        r1 = new com.tencent.mm.plugin.luckymoney.ui.g$c;
        r1.<init>();
        r2 = r12.getResources();
        r3 = com.tencent.mm.plugin.wxpay.a.c.uhp;
        r2 = r2.getColor(r3);
        r1.textColor = r2;
        r2 = r12.getResources();
        r3 = com.tencent.mm.plugin.wxpay.a.d.bvV;
        r2 = r2.getDimensionPixelSize(r3);
        r1.textSize = r2;
        r2 = r13.ohJ;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r0, r2, r1);
    L_0x0206:
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 11701; // 0x2db5 float:1.6397E-41 double:5.781E-320;
        r2 = 5;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r13.ohM;
        r4 = sv(r4);
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
    L_0x023d:
        if (r13 == 0) goto L_0x0304;
    L_0x023f:
        r0 = r13.fMy;
        r1 = 3;
        if (r0 == r1) goto L_0x0249;
    L_0x0244:
        r0 = r13.fMy;
        r1 = 2;
        if (r0 != r1) goto L_0x039c;
    L_0x0249:
        r0 = r13.ohD;
        r1 = 1;
        if (r0 != r1) goto L_0x039c;
    L_0x024e:
        r0 = r12.omh;
        if (r0 != 0) goto L_0x039c;
    L_0x0252:
        r0 = r13.ohG;
        r1 = 1;
        if (r0 != r1) goto L_0x039c;
    L_0x0257:
        r0 = 1;
        r1 = r0;
    L_0x0259:
        r0 = r13.ohH;
        if (r0 == 0) goto L_0x03a0;
    L_0x025d:
        r0 = r13.ohH;
        r0 = r0.gGi;
        r2 = 1;
        if (r0 != r2) goto L_0x03a0;
    L_0x0264:
        r0 = r13.ohH;
        r0 = r0.ohb;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x03a0;
    L_0x026e:
        r0 = 1;
        r2 = r0;
    L_0x0270:
        r0 = r12.lHm;
        r3 = com.tencent.mm.plugin.wxpay.a.f.unN;
        r0 = r0.findViewById(r3);
        r0 = (android.widget.TextView) r0;
        if (r1 != 0) goto L_0x027e;
    L_0x027c:
        if (r2 == 0) goto L_0x03a4;
    L_0x027e:
        r1 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$5;
        r1.<init>(r13);
        r0.setOnClickListener(r1);
        if (r2 == 0) goto L_0x0295;
    L_0x0288:
        r1 = r13.ohH;
        r1 = r1.ohb;
        r12.omm = r1;
        r1 = r13.ohH;
        r1 = r1.ohc;
        r0.setText(r1);
    L_0x0295:
        r1 = com.tencent.mm.plugin.report.service.g.pWK;
        r2 = 11701; // 0x2db5 float:1.6397E-41 double:5.781E-320;
        r3 = 5;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r13.ohM;
        r5 = sv(r5);
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 1;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 2;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 3;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 4;
        r5 = 2;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r1.h(r2, r3);
        r1 = 0;
        r0.setVisibility(r1);
    L_0x02d0:
        r1 = r12.lHm;
        r2 = com.tencent.mm.plugin.wxpay.a.f.unL;
        r1 = r1.findViewById(r2);
        r1 = (android.widget.TextView) r1;
        r2 = r12.omi;
        r3 = 1;
        if (r2 == r3) goto L_0x03ab;
    L_0x02df:
        r2 = r12.omi;
        r3 = 3;
        if (r2 == r3) goto L_0x03ab;
    L_0x02e4:
        r0 = r0.getVisibility();
        if (r0 == 0) goto L_0x03ab;
    L_0x02ea:
        r0 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$6;
        r0.<init>(r13);
        r1.setOnClickListener(r0);
        r0 = 0;
        r1.setVisibility(r0);
    L_0x02f6:
        r0 = r12.oms;
        if (r0 != 0) goto L_0x0304;
    L_0x02fa:
        r0 = r12.olW;
        r1 = r12.lHm;
        r0.addFooterView(r1);
        r0 = 1;
        r12.oms = r0;
    L_0x0304:
        r2 = r13.ohN;
        if (r2 == 0) goto L_0x03c5;
    L_0x0308:
        r0 = 0;
        r1 = r0;
    L_0x030a:
        r0 = r2.size();
        if (r1 >= r0) goto L_0x03b2;
    L_0x0310:
        r0 = r2.get(r1);
        r0 = (com.tencent.mm.plugin.luckymoney.b.m) r0;
        r3 = r12.omp;
        r4 = r0.ohB;
        r3 = r3.containsKey(r4);
        if (r3 != 0) goto L_0x0335;
    L_0x0320:
        r3 = r12.omo;
        r4 = r2.get(r1);
        r3.add(r4);
        r3 = r12.omp;
        r0 = r0.ohB;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r3.put(r0, r4);
    L_0x0335:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x030a;
    L_0x0339:
        r0 = 0;
        goto L_0x0009;
    L_0x033c:
        r1 = r13.ohv;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x0068;
    L_0x0344:
        r1 = r12.olX;
        r2 = r13.ohv;
        r3 = r13.ohP;
        com.tencent.mm.plugin.luckymoney.b.n.a(r1, r2, r3);
        goto L_0x0068;
    L_0x034f:
        r0 = r12.omq;
        r1 = 0;
        r0.opH = r1;
        goto L_0x0099;
    L_0x0356:
        r0 = r12.oma;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x009f;
    L_0x035f:
        r0 = r12.ome;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00d2;
    L_0x0368:
        r0 = "MicroMsg.LuckyMoneyDetailUI";
        r1 = "detail.jumpChange is false";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r12.lsa;
        r1 = r12.getResources();
        r2 = com.tencent.mm.plugin.wxpay.a.c.uhv;
        r1 = r1.getColor(r2);
        r0.setTextColor(r1);
        goto L_0x00dc;
    L_0x0382:
        r0 = "MicroMsg.LuckyMoneyDetailUI";
        r1 = "detail.changeWording is empty";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = r12.omd;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00dc;
    L_0x0394:
        r0 = r12.lpZ;
        r1 = 0;
        r0.setText(r1);
        goto L_0x00eb;
    L_0x039c:
        r0 = 0;
        r1 = r0;
        goto L_0x0259;
    L_0x03a0:
        r0 = 0;
        r2 = r0;
        goto L_0x0270;
    L_0x03a4:
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x02d0;
    L_0x03ab:
        r0 = 8;
        r1.setVisibility(r0);
        goto L_0x02f6;
    L_0x03b2:
        r0 = r12.wn;
        r1 = r2.size();
        r0 = r0 + r1;
        r12.wn = r0;
        r0 = 0;
        r12.lGi = r0;
        r0 = r12.omq;
        r1 = r12.omo;
        r0.bf(r1);
    L_0x03c5:
        r0 = r13.ohL;
        r1 = r13.ohO;
        r2 = r12.omg;
        r3 = com.tencent.mm.plugin.wxpay.a.e.ujl;
        r2.setImageResource(r3);
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r2 == 0) goto L_0x043a;
    L_0x03d6:
        r0 = "MicroMsg.LuckyMoneyDetailUI";
        r1 = "renderAdImage: no adImage";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r12.omg;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x03e6:
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 13051; // 0x32fb float:1.8288E-41 double:6.448E-320;
        r2 = 10;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.omn;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = r13.ohL;
        r2[r3] = r4;
        r3 = 3;
        r4 = r13.ohI;
        r4 = com.tencent.mm.plugin.luckymoney.b.n.be(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = "";
        r2[r3] = r4;
        r3 = 5;
        r4 = "";
        r2[r3] = r4;
        r3 = 6;
        r4 = "";
        r2[r3] = r4;
        r3 = 7;
        r4 = "";
        r2[r3] = r4;
        r3 = 8;
        r4 = r13.ohu;
        r2[r3] = r4;
        r3 = 9;
        r4 = r13.resourceId;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        goto L_0x0002;
    L_0x043a:
        r2 = new android.util.DisplayMetrics;
        r2.<init>();
        r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r2 = r2.getResources();
        r2 = r2.getDisplayMetrics();
        if (r2 == 0) goto L_0x047b;
    L_0x044d:
        r2 = r2.widthPixels;
        r3 = r12.getResources();
        r4 = com.tencent.mm.plugin.wxpay.a.d.uiy;
        r3 = r3.getDimensionPixelSize(r4);
        r3 = r3 * 2;
        r2 = r2 - r3;
        r3 = r12.getResources();
        r4 = com.tencent.mm.plugin.wxpay.a.d.uix;
        r3 = r3.getDimensionPixelSize(r4);
        r3 = r3 * 2;
        r2 = r2 - r3;
        r2 = (float) r2;
        r3 = 1061158912; // 0x3f400000 float:0.75 double:5.24282163E-315;
        r2 = r2 * r3;
        r2 = (int) r2;
        r3 = r12.omg;
        r3 = r3.getLayoutParams();
        r3.height = r2;
        r2 = r12.omg;
        r2.setLayoutParams(r3);
    L_0x047b:
        r2 = r12.omg;
        r3 = 0;
        com.tencent.mm.plugin.luckymoney.b.n.a(r2, r0, r1, r3);
        r0 = r12.omg;
        r1 = 0;
        r0.setVisibility(r1);
        goto L_0x03e6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.a(com.tencent.mm.plugin.luckymoney.b.e):void");
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
    }

    private static int sv(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }
}
