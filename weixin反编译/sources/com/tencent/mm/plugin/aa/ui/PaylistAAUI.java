package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.aa.a.c.f;
import com.tencent.mm.plugin.aa.a.c.g;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.protocal.c.t;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.j;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PaylistAAUI extends BaseAAPresenterActivity {
    private String fFk;
    private String fqL;
    private Dialog ikw = null;
    private View ilc;
    private TextView imA;
    private TextView imB;
    private TextView imC;
    private TextView imD;
    private String imE;
    private String imF;
    private String imG;
    private int imH;
    private String imI;
    private long imJ;
    private g imt = ((g) q(g.class));
    private f imu = ((f) t(f.class));
    private LinearLayout imv;
    private LinearLayout imw;
    private LinearLayout imx;
    private WalletTextView imy;
    private Button imz;
    private String title;

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, long j) {
        paylistAAUI.ikw = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        double d = bi.getDouble(paylistAAUI.imy.getText().toString(), 0.0d);
        com.tencent.mm.vending.g.g.cq(Long.valueOf(j)).b(paylistAAUI.imt.ikb).e(new a<Void, o>() {
            public final /* synthetic */ Object call(Object obj) {
                final o oVar = (o) obj;
                if (PaylistAAUI.this.ikw != null) {
                    PaylistAAUI.this.ikw.dismiss();
                }
                String str = "MicroMsg.PaylistAAUI";
                String str2 = "aapay return, alertItem: %s, alertItem.flag: %s";
                Object[] objArr = new Object[2];
                objArr[0] = oVar.vKc;
                objArr[1] = Integer.valueOf(oVar.vKc != null ? oVar.vKc.fEo : 0);
                x.i(str, str2, objArr);
                if (oVar.vKc == null || oVar.vKc.fEo != 1) {
                    x.d("MicroMsg.PaylistAAUI", "aapay return, reqKey: %s", oVar.oiX);
                    PaylistAAUI.a(PaylistAAUI.this, oVar);
                } else {
                    String str3 = oVar.vKc.fzT;
                    String str4 = oVar.vKc.ojb;
                    str = oVar.vKc.ojc;
                    i.a aVar = new i.a(PaylistAAUI.this);
                    aVar.Zn(str3);
                    aVar.Zp(str).a(new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            PaylistAAUI.a(PaylistAAUI.this, oVar);
                        }
                    });
                    aVar.Zq(str4);
                    aVar.ale().show();
                }
                return zLb;
            }
        }).a(new d.a() {
            public final void aW(Object obj) {
                x.i("MicroMsg.PaylistAAUI", "aapay failed: %s", obj);
                if (PaylistAAUI.this.ikw != null) {
                    PaylistAAUI.this.ikw.dismiss();
                }
                if (obj == null) {
                    Toast.makeText(PaylistAAUI.this, PaylistAAUI.this.getString(com.tencent.mm.plugin.wxpay.a.i.uNI), 1).show();
                } else if (obj instanceof com.tencent.mm.protocal.c.a) {
                    final com.tencent.mm.protocal.c.a aVar = (com.tencent.mm.protocal.c.a) obj;
                    String str = aVar.fzT;
                    String str2 = aVar.ojb;
                    String str3 = aVar.ojc;
                    i.a aVar2 = new i.a(PaylistAAUI.this);
                    aVar2.Zn(str);
                    aVar2.Zp(str3).a(new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            e.l(PaylistAAUI.this.mController.xRr, aVar.loA, false);
                        }
                    });
                    aVar2.Zq(str2);
                    aVar2.ale().show();
                } else if ((obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                    Toast.makeText(PaylistAAUI.this, obj.toString(), 1).show();
                }
            }
        });
        com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(4), Integer.valueOf(9));
        com.tencent.mm.plugin.report.service.g.pWK.h(13723, Integer.valueOf(3), Integer.valueOf(h.oS(paylistAAUI.imF).size()), Integer.valueOf(paylistAAUI.imH), Double.valueOf(d * 100.0d), paylistAAUI.title);
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, o oVar) {
        boolean z = paylistAAUI.getIntent().getIntExtra("enter_scene", 0) == 1;
        paylistAAUI.imE = oVar.oiX;
        paylistAAUI.fFk = oVar.fFi;
        paylistAAUI.imI = oVar.vJK;
        paylistAAUI.fqL = oVar.vKd;
        String str = paylistAAUI.imE;
        String str2 = oVar.pQF;
        String str3 = paylistAAUI.imG;
        x.d("MicroMsg.AAUtil", "startAAPay, reqKey: %s, isFromChatting: %s", str, Boolean.valueOf(z));
        PayInfo payInfo = new PayInfo();
        payInfo.fvC = str;
        payInfo.fDQ = 42;
        if (z) {
            payInfo.fDM = 14;
        } else {
            payInfo.fDM = 1;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str3);
        payInfo.vGl = bundle;
        com.tencent.mm.pluginsdk.wallet.h.a(paylistAAUI, false, "", payInfo, str2, new Intent(), 233);
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, v vVar) {
        String str = vVar.vKh;
        String str2 = vVar.title;
        double d = ((double) vVar.vKi) / 100.0d;
        b.o((ImageView) paylistAAUI.findViewById(com.tencent.mm.plugin.wxpay.a.f.uzu), str);
        TextView textView = (TextView) paylistAAUI.findViewById(com.tencent.mm.plugin.wxpay.a.f.uzD);
        CharSequence string = paylistAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uST, new Object[]{str2, Double.valueOf(d)});
        if (vVar.type == 2 && vVar.vKv > vVar.vKi) {
            string = paylistAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uSU, new Object[]{str2, Double.valueOf(((double) vVar.vKv) / 100.0d), Double.valueOf(((double) vVar.vKi) / 100.0d)});
        }
        x.i("MicroMsg.PaylistAAUI", "tftest: cs: %s", string);
        try {
            textView.setText(com.tencent.mm.pluginsdk.ui.d.i.a(paylistAAUI.mController.xRr, string));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PaylistAAUI", e, "", new Object[0]);
        }
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, String str) {
        if (paylistAAUI.ikw != null) {
            paylistAAUI.ikw.dismiss();
            paylistAAUI.ikw = null;
        }
        if (bi.oN(str)) {
            Toast.makeText(paylistAAUI, com.tencent.mm.plugin.wxpay.a.i.uNz, 1).show();
        } else {
            Toast.makeText(paylistAAUI, str, 1).show();
        }
    }

    static /* synthetic */ void b(PaylistAAUI paylistAAUI) {
        if (paylistAAUI.ikw != null) {
            paylistAAUI.ikw.dismiss();
        }
        paylistAAUI.ikw = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        com.tencent.mm.vending.g.g.cAN().b(paylistAAUI.imt.ikf).e(new a<Void, Boolean>() {
            public final /* synthetic */ Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                if (PaylistAAUI.this.ikw != null) {
                    PaylistAAUI.this.ikw.dismiss();
                }
                if (bool.booleanValue()) {
                    x.i("MicroMsg.PaylistAAUI", "urgeAAPay success");
                    Toast.makeText(PaylistAAUI.this, com.tencent.mm.plugin.wxpay.a.i.uVd, 1).show();
                } else {
                    x.i("MicroMsg.PaylistAAUI", "urgeAAPay fail");
                    Toast.makeText(PaylistAAUI.this, com.tencent.mm.plugin.wxpay.a.i.uVc, 1).show();
                }
                return zLb;
            }
        }).a(new d.a() {
            public final void aW(Object obj) {
                if (PaylistAAUI.this.ikw != null) {
                    PaylistAAUI.this.ikw.dismiss();
                }
                if (!(obj instanceof String) || obj.toString().equalsIgnoreCase("ok")) {
                    Toast.makeText(PaylistAAUI.this, com.tencent.mm.plugin.wxpay.a.i.uVc, 1).show();
                } else {
                    Toast.makeText(PaylistAAUI.this, obj.toString(), 1).show();
                }
                x.e("MicroMsg.PaylistAAUI", "urgeAAPay fail");
            }
        });
        com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(4), Integer.valueOf(8));
    }

    static /* synthetic */ void b(PaylistAAUI paylistAAUI, v vVar) {
        if (vVar.state == com.tencent.mm.plugin.aa.a.a.iij) {
            paylistAAUI.imA.setText(com.tencent.mm.plugin.wxpay.a.i.uSS);
            paylistAAUI.imA.setTextColor(paylistAAUI.getResources().getColor(c.btC));
        } else if (vVar.state == com.tencent.mm.plugin.aa.a.a.iik) {
            paylistAAUI.imA.setText(com.tencent.mm.plugin.wxpay.a.i.uSQ);
            paylistAAUI.imA.setTextColor(paylistAAUI.getResources().getColor(c.btC));
            if (vVar.type != 2 || vVar.vKv <= vVar.vKi) {
                paylistAAUI.imB.setVisibility(8);
                return;
            }
            paylistAAUI.imB.setText(paylistAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uSX, new Object[]{Double.valueOf(((double) vVar.vKk) / 100.0d)}));
            paylistAAUI.imB.setVisibility(0);
        } else if (vVar.vJT == com.tencent.mm.plugin.aa.a.a.iin) {
            paylistAAUI.imw.setVisibility(8);
            paylistAAUI.imv.setVisibility(0);
            paylistAAUI.imA.setText(paylistAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uSV));
            paylistAAUI.imA.setTextColor(paylistAAUI.getResources().getColor(c.uhE));
        } else if (vVar.vJT == com.tencent.mm.plugin.aa.a.a.iim) {
            paylistAAUI.imw.setVisibility(8);
            paylistAAUI.imv.setVisibility(0);
            if (vVar.vKo == com.tencent.mm.plugin.aa.a.a.iiq) {
                paylistAAUI.imA.setText(paylistAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uSR));
                paylistAAUI.imA.setTextColor(paylistAAUI.getResources().getColor(c.uhE));
            } else if (vVar.vKo == com.tencent.mm.plugin.aa.a.a.iip) {
                paylistAAUI.imA.setText(paylistAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uSX, new Object[]{Double.valueOf(((double) vVar.vKk) / 100.0d)}));
            } else if (vVar.vKo == com.tencent.mm.plugin.aa.a.a.iio) {
                paylistAAUI.imA.setText(com.tencent.mm.plugin.wxpay.a.i.uSY);
            } else {
                x.e("MicroMsg.PaylistAAUI", "unhandled state, state: %s, type: %s, role: %s", Integer.valueOf(vVar.state), Integer.valueOf(vVar.type), Integer.valueOf(vVar.vJT));
                paylistAAUI.imA.setVisibility(8);
            }
        } else if (vVar.vJT == com.tencent.mm.plugin.aa.a.a.iil) {
            for (t tVar : vVar.vJN) {
                if (tVar.vKe.equals(q.FY())) {
                    break;
                }
            }
            x.i("MicroMsg.AAUtil", "not contains self");
            t tVar2 = null;
            if (vVar.vKo == com.tencent.mm.plugin.aa.a.a.iis || (tVar2 != null && tVar2.vKg == com.tencent.mm.plugin.aa.a.a.iis)) {
                CharSequence format = String.format("%.2f", new Object[]{Double.valueOf(((double) vVar.vKp) / 100.0d)});
                CharSequence string = paylistAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uSP);
                paylistAAUI.imJ = vVar.vKp;
                int i = vVar.state;
                paylistAAUI.imw.setVisibility(0);
                paylistAAUI.imv.setVisibility(8);
                paylistAAUI.imz = (Button) paylistAAUI.imw.findViewById(com.tencent.mm.plugin.wxpay.a.f.uzA);
                if (i == com.tencent.mm.plugin.aa.a.a.iij || i == com.tencent.mm.plugin.aa.a.a.iik) {
                    paylistAAUI.imz.setVisibility(8);
                }
                paylistAAUI.imz.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        PaylistAAUI.a(PaylistAAUI.this, PaylistAAUI.this.imJ);
                    }
                });
                paylistAAUI.imy = (WalletTextView) paylistAAUI.findViewById(com.tencent.mm.plugin.wxpay.a.f.uyl);
                TextView textView = (TextView) paylistAAUI.imw.findViewById(com.tencent.mm.plugin.wxpay.a.f.uzC);
                paylistAAUI.imy.mPrefix = u.cCu();
                paylistAAUI.imy.setText(format);
                textView.setText(string);
            } else if (vVar.vKo == com.tencent.mm.plugin.aa.a.a.iit || (tVar2 != null && tVar2.vKg == com.tencent.mm.plugin.aa.a.a.iit)) {
                paylistAAUI.imw.setVisibility(8);
                paylistAAUI.imv.setVisibility(0);
                paylistAAUI.imA.setText(paylistAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uSW, new Object[]{Double.valueOf(((double) vVar.vKp) / 100.0d)}));
                paylistAAUI.imA.setTextColor(paylistAAUI.getResources().getColor(c.uhE));
            } else {
                x.e("MicroMsg.PaylistAAUI", "unhandled state, state: %s, type: %s, role: %s", Integer.valueOf(vVar.state), Integer.valueOf(vVar.type), Integer.valueOf(vVar.vJT));
                paylistAAUI.imw.setVisibility(8);
                paylistAAUI.imA.setVisibility(8);
            }
        }
    }

    static /* synthetic */ void c(PaylistAAUI paylistAAUI, v vVar) {
        View findViewById = paylistAAUI.findViewById(com.tencent.mm.plugin.wxpay.a.f.divider);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Iterator it = vVar.vJN.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            if (tVar.vKg == com.tencent.mm.plugin.aa.a.a.iis) {
                arrayList2.add(tVar);
            } else {
                arrayList.add(tVar);
            }
        }
        if (arrayList2.isEmpty()) {
            paylistAAUI.a(arrayList, paylistAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uSM, new Object[]{Integer.valueOf(arrayList.size())}), E(vVar.vJT, vVar.vKo, vVar.state));
            paylistAAUI.imx.setVisibility(8);
            findViewById.setVisibility(4);
            return;
        }
        paylistAAUI.a(arrayList2, paylistAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uSL, new Object[]{Integer.valueOf(arrayList2.size())}), E(vVar.vJT, vVar.vKo, vVar.state));
        if (arrayList.isEmpty()) {
            paylistAAUI.imx.setVisibility(8);
            findViewById.setVisibility(4);
            return;
        }
        String string = paylistAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uSM, new Object[]{Integer.valueOf(arrayList.size())});
        int i = vVar.vJT;
        i = vVar.vKo;
        i = vVar.state;
        paylistAAUI.e(arrayList, string);
    }

    static /* synthetic */ void e(PaylistAAUI paylistAAUI, v vVar) {
        if (vVar.vJT == com.tencent.mm.plugin.aa.a.a.iim && vVar.vKh.equals(q.FY())) {
            paylistAAUI.imD.setVisibility(0);
        } else {
            paylistAAUI.imD.setVisibility(8);
        }
        if (paylistAAUI.imD.getVisibility() != 0) {
            x.i("MicroMsg.PaylistAAUI", "no need to show bottom tv");
        } else if (bi.oN(vVar.vKt)) {
            x.i("MicroMsg.PaylistAAUI", "wording is null");
        } else {
            CharSequence spannableStringBuilder = new SpannableStringBuilder(vVar.vKt);
            if (vVar.vKu == 1) {
                paylistAAUI.imD.setClickable(true);
                paylistAAUI.imD.setOnTouchListener(new l(paylistAAUI));
                spannableStringBuilder.setSpan(new a(new a.a() {
                    public final void WX() {
                        Intent intent = new Intent();
                        intent.putExtra("key_scene_balance_manager", 0);
                        com.tencent.mm.bl.d.b(PaylistAAUI.this, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
                        com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(4), Integer.valueOf(4));
                    }
                }), 0, spannableStringBuilder.length(), 18);
            }
            paylistAAUI.imD.setText(spannableStringBuilder);
            paylistAAUI.getWindow().getDecorView().post(new Runnable() {
                public final void run() {
                    int height = PaylistAAUI.this.getWindow().getDecorView().getHeight();
                    int[] iArr = new int[2];
                    View findViewById = PaylistAAUI.this.findViewById(com.tencent.mm.plugin.wxpay.a.f.uzE);
                    findViewById.getLocationInWindow(iArr);
                    int height2 = iArr[1] + findViewById.getHeight();
                    int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(PaylistAAUI.this.mController.xRr, 20);
                    int fromDPToPix2 = ((height - height2) - com.tencent.mm.bu.a.fromDPToPix(PaylistAAUI.this.mController.xRr, 24)) - com.tencent.mm.bu.a.fromDPToPix(PaylistAAUI.this.mController.xRr, 12);
                    if (fromDPToPix2 < fromDPToPix) {
                        fromDPToPix2 = fromDPToPix;
                    }
                    x.d("MicroMsg.PaylistAAUI", "height: %s, h1: %s, topMargin: %s", Integer.valueOf(height), Integer.valueOf(height2), Integer.valueOf(fromDPToPix2));
                    LayoutParams layoutParams = (LayoutParams) PaylistAAUI.this.imD.getLayoutParams();
                    layoutParams.topMargin = fromDPToPix2;
                    PaylistAAUI.this.imD.setLayoutParams(layoutParams);
                }
            });
        }
    }

    static /* synthetic */ void h(PaylistAAUI paylistAAUI) {
        if (paylistAAUI.ikw != null) {
            paylistAAUI.ikw.dismiss();
        }
        paylistAAUI.ikw = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        com.tencent.mm.vending.g.g.cAN().b(paylistAAUI.imt.ike).e(new a<Void, Boolean>() {
            public final /* synthetic */ Object call(Object obj) {
                x.i("MicroMsg.PaylistAAUI", "close pay list success: %s", (Boolean) obj);
                if (PaylistAAUI.this.ikw != null) {
                    PaylistAAUI.this.ikw.dismiss();
                }
                PaylistAAUI.this.imG = null;
                PaylistAAUI.this.Xt();
                PaylistAAUI.this.mController.removeAllOptionMenu();
                PaylistAAUI.k(PaylistAAUI.this);
                return zLb;
            }
        }).a(new d.a() {
            public final void aW(Object obj) {
                x.i("MicroMsg.PaylistAAUI", "close pay list failed: %s", obj);
                if (PaylistAAUI.this.ikw != null) {
                    PaylistAAUI.this.ikw.dismiss();
                }
                if (obj instanceof String) {
                    Toast.makeText(PaylistAAUI.this, obj.toString(), 1).show();
                } else {
                    Toast.makeText(PaylistAAUI.this, com.tencent.mm.plugin.wxpay.a.i.uOK, 1).show();
                }
            }
        });
        com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(4), Integer.valueOf(6));
    }

    static /* synthetic */ void k(PaylistAAUI paylistAAUI) {
        Intent intent = new Intent();
        intent.putExtra("close_aa", true);
        intent.putExtra("item_position", paylistAAUI.getIntent().getIntExtra("item_position", 0));
        intent.putExtra("item_offset", paylistAAUI.getIntent().getIntExtra("item_offset", 0));
        paylistAAUI.setResult(-1, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                PaylistAAUI.this.finish();
                return false;
            }
        });
        setMMTitle(com.tencent.mm.plugin.wxpay.a.i.uQj);
        this.imF = getIntent().getStringExtra("chatroom");
        this.imv = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzI);
        this.imw = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzB);
        this.imx = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzv);
        this.imA = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzJ);
        this.imB = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzz);
        this.ilc = findViewById(com.tencent.mm.plugin.wxpay.a.f.cID);
        this.imC = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzK);
        this.imC.setClickable(true);
        this.imC.setOnTouchListener(new l(this));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(com.tencent.mm.plugin.wxpay.a.i.uSZ));
        spannableStringBuilder.setSpan(new a(new a.a() {
            public final void WX() {
                int i;
                int i2 = com.tencent.mm.plugin.wxpay.a.i.uUZ;
                if (s.eX(PaylistAAUI.this.imF)) {
                    i = i2;
                } else {
                    i = com.tencent.mm.plugin.wxpay.a.i.uVa;
                }
                j.b bVar = new j.b(PaylistAAUI.this);
                String string = PaylistAAUI.this.getString(com.tencent.mm.plugin.wxpay.a.i.uVb);
                int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(bVar.mContext, (int) (20.0f * com.tencent.mm.bu.a.ev(bVar.mContext)));
                if (!bi.oN(string)) {
                    bVar.vtY.Q((SpannableString) com.tencent.mm.ui.e.c.b.a(bVar.mContext, string.toString(), fromDPToPix));
                }
                View inflate = com.tencent.mm.ui.v.fw(PaylistAAUI.this).inflate(com.tencent.mm.plugin.wxpay.a.g.uKN, null);
                TextView textView = (TextView) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.text);
                ((ImageView) inflate.findViewById(com.tencent.mm.plugin.wxpay.a.f.image)).setImageResource(com.tencent.mm.plugin.wxpay.a.e.ujV);
                textView.setText(i);
                bVar.vtY.dk(inflate);
                bVar.EZ(com.tencent.mm.plugin.wxpay.a.i.dGL);
                bVar.yix = PaylistAAUI.this.getString(com.tencent.mm.plugin.wxpay.a.i.dEy);
                bVar.yiz = false;
                bVar.a(new j.a() {
                    public final void cj(boolean z) {
                    }
                }, new j.a() {
                    public final void cj(boolean z) {
                        PaylistAAUI.b(PaylistAAUI.this);
                    }
                });
                bVar.pDT.show();
                com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(4), Integer.valueOf(7));
            }
        }), 0, spannableStringBuilder.length(), 18);
        this.imC.setText(spannableStringBuilder);
        this.imD = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzy);
        Xt();
    }

    private void Xt() {
        this.ikw = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        this.ilc.setVisibility(4);
        com.tencent.mm.vending.g.g.cAN().b(this.imt.ika).e(new a<Void, v>() {
            public final /* synthetic */ Object call(Object obj) {
                v vVar = (v) obj;
                if (vVar == null) {
                    x.e("MicroMsg.PaylistAAUI", "queryDetailRes is null!!!");
                    PaylistAAUI.a(PaylistAAUI.this, null);
                } else {
                    x.i("MicroMsg.PaylistAAUI", "get queryDetailRes: %s, billNo: %s, type: %s, state: %s, is_launcher: %s, role: %s, role_state: %s, payer_list.size: %s", vVar, vVar.vJI, Integer.valueOf(vVar.type), Integer.valueOf(vVar.state), Integer.valueOf(vVar.vKn), Integer.valueOf(vVar.vJT), Integer.valueOf(vVar.vKo), Integer.valueOf(vVar.vJN.size()));
                    x.i("MicroMsg.PaylistAAUI", "paid_num: %s, plan_num: %s, activity_amount: %s", Integer.valueOf(vVar.vKl), Integer.valueOf(vVar.vKj), Long.valueOf(vVar.vKv));
                    PaylistAAUI.this.ilc.setVisibility(0);
                    PaylistAAUI.this.imG = vVar.vKh;
                    PaylistAAUI.this.imH = vVar.vJN.size() + 1;
                    PaylistAAUI.this.title = vVar.title;
                    PaylistAAUI.a(PaylistAAUI.this, vVar);
                    PaylistAAUI.b(PaylistAAUI.this, vVar);
                    PaylistAAUI.c(PaylistAAUI.this, vVar);
                    PaylistAAUI.this.addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.bDJ, new OnMenuItemClickListener(vVar) {
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(PaylistAAUI.this, com.tencent.mm.ui.widget.g.zCt, false);
                            gVar.rQF = new p.c() {
                                public final void a(n nVar) {
                                    nVar.add(0, 1, 1, com.tencent.mm.plugin.wxpay.a.i.uTa);
                                    if (!bi.oN(PaylistAAUI.this.imG) && PaylistAAUI.this.imG.equals(q.FY()) && r4.state == com.tencent.mm.plugin.aa.a.a.iii && r4.vKk < r4.vKi) {
                                        nVar.add(0, 2, 1, com.tencent.mm.plugin.wxpay.a.i.uNu);
                                    }
                                }
                            };
                            gVar.rQG = new p.d() {
                                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                    int i2 = 3;
                                    switch (menuItem.getItemId()) {
                                        case 1:
                                            if (!bi.oN(PaylistAAUI.this.imF)) {
                                                Intent intent = new Intent(PaylistAAUI.this.mController.xRr, LaunchAAUI.class);
                                                intent.putExtra("enter_scene", 3);
                                                intent.putExtra("chatroom_name", PaylistAAUI.this.imF);
                                                PaylistAAUI.this.startActivity(intent);
                                            }
                                            if (r4.vJT == com.tencent.mm.plugin.aa.a.a.iim) {
                                                i2 = 1;
                                            } else if (r4.vJT == com.tencent.mm.plugin.aa.a.a.iil) {
                                                i2 = 2;
                                            }
                                            x.d("MicroMsg.PaylistAAUI", "test");
                                            com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(7), Integer.valueOf(i2));
                                            return;
                                        case 2:
                                            com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(4), Integer.valueOf(5));
                                            com.tencent.mm.ui.base.h.a(PaylistAAUI.this, com.tencent.mm.plugin.wxpay.a.i.uNt, -1, com.tencent.mm.plugin.wxpay.a.i.uNv, com.tencent.mm.plugin.wxpay.a.i.dEy, new OnClickListener() {
                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    PaylistAAUI.h(PaylistAAUI.this);
                                                }
                                            }, null);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                            };
                            gVar.bUX();
                            return true;
                        }
                    });
                    PaylistAAUI.e(PaylistAAUI.this, vVar);
                    if (PaylistAAUI.this.ikw != null) {
                        PaylistAAUI.this.ikw.dismiss();
                        PaylistAAUI.this.ikw = null;
                    }
                }
                return zLb;
            }
        }).a(new d.a() {
            public final void aW(Object obj) {
                x.i("MicroMsg.PaylistAAUI", "onInterrupt: %s", obj);
                PaylistAAUI.a(PaylistAAUI.this, obj == null ? "" : obj.toString());
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private static boolean E(int i, int i2, int i3) {
        return i == com.tencent.mm.plugin.aa.a.a.iim && i2 != com.tencent.mm.plugin.aa.a.a.iiq && i3 == com.tencent.mm.plugin.aa.a.a.iii;
    }

    private void a(List<t> list, String str, boolean z) {
        ((TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzL)).setText(str);
        this.imC.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzM);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z2;
            t tVar = (t) list.get(i);
            if (i >= list.size() - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            a(linearLayout, tVar, z2);
        }
    }

    private void e(List<t> list, String str) {
        ((TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzw)).setText(str);
        LinearLayout linearLayout = (LinearLayout) findViewById(com.tencent.mm.plugin.wxpay.a.f.uzx);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z;
            t tVar = (t) list.get(i);
            if (i >= list.size() - 1) {
                z = true;
            } else {
                z = false;
            }
            a(linearLayout, tVar, z);
        }
    }

    private void a(LinearLayout linearLayout, t tVar, boolean z) {
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(com.tencent.mm.plugin.wxpay.a.g.uJK, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(com.tencent.mm.plugin.wxpay.a.f.uzF);
        TextView textView = (TextView) linearLayout2.findViewById(com.tencent.mm.plugin.wxpay.a.f.uzG);
        TextView textView2 = (TextView) linearLayout2.findViewById(com.tencent.mm.plugin.wxpay.a.f.uzH);
        View findViewById = linearLayout2.findViewById(com.tencent.mm.plugin.wxpay.a.f.divider);
        if (z) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        b.a(imageView, tVar.vKe);
        Context context = this.mController.xRr;
        com.tencent.mm.vending.app.a aVar = this.imu;
        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(context, ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.a.b.class)).L(tVar.vKe, aVar.zKi.getStringExtra("chatroom")), textView.getTextSize()));
        if (tVar.vKg == com.tencent.mm.plugin.aa.a.a.iit) {
            textView2.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uSW, new Object[]{Double.valueOf(((double) tVar.vJR) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(c.uhE));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
        } else if (tVar.vKg == com.tencent.mm.plugin.aa.a.a.iis) {
            textView2.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uSO, new Object[]{Double.valueOf(((double) tVar.vJR) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(c.uhF));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
        } else {
            textView2.setVisibility(8);
            linearLayout.addView(linearLayout2);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uJL;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Intent intent2;
        String stringExtra;
        if (i == 233) {
            if (i2 == -1) {
                x.i("MicroMsg.PaylistAAUI", "pay success, payMsgId: %s", this.fFk);
                RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                if (realnameGuideHelper != null) {
                    x.i("MicroMsg.PaylistAAUI", "do realname guide");
                    intent2 = new Intent();
                    intent2.putExtra("key_realname_guide_helper", realnameGuideHelper);
                    com.tencent.mm.bl.d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent2);
                }
                h.oT(this.imF);
                finish();
                com.tencent.mm.vending.g.g.a(this.fFk, this.imG, this.imI).b(this.imt.ikc).e(new a<Void, Void>() {
                    public final /* synthetic */ Object call(Object obj) {
                        x.i("MicroMsg.PaylistAAUI", "insert msg finish");
                        return zLb;
                    }
                });
                com.tencent.mm.plugin.report.service.g.pWK.a(407, 12, 1, false);
                stringExtra = intent.getStringExtra("key_trans_id");
                a aVar = this.imt.ikd;
                long j = this.imJ;
                com.tencent.mm.vending.g.g.a(Long.valueOf(j), this.fqL, stringExtra).b(aVar);
            }
        } else if (i == 222 && i2 == -1) {
            stringExtra = intent.getStringExtra("Select_Conv_User");
            x.i("MicroMsg.PaylistAAUI", "select chatroom：%s", stringExtra);
            if (!bi.oN(stringExtra)) {
                intent2 = new Intent(this.mController.xRr, LaunchAAUI.class);
                intent2.putExtra("enter_scene", 3);
                intent2.putExtra("chatroom_name", stringExtra);
                startActivity(intent2);
            }
        }
    }
}
