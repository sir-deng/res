package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.a.c.e;
import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.protocal.c.j;
import com.tencent.mm.protocal.c.y;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAUI extends BaseAAPresenterActivity {
    private String chatroomName = null;
    private TextView ikp;
    private Dialog ikw;
    private boolean ilB = false;
    private e ilR = ((e) q(e.class));
    private boolean ilS = false;
    private MMEditText ilT;
    private TextView ilU;
    private TextView ilV;
    private TextView ilW;
    private TextView ilX;
    private WalletFormView ilY;
    private TextView ilZ;
    private TextView ima;
    private ViewGroup imb;
    private ViewGroup imc;
    private List<String> imd = new ArrayList();
    private ViewGroup ime;
    private ViewGroup imf;
    private TextView img;
    private ViewGroup imh;
    private Map<String, Double> imi = new HashMap();
    private Map<String, LaunchAAByPersonNameAmountRow> imj = new HashMap();
    private Button imk;
    private TextView iml;
    private TextView imm;
    private d imn = new d();
    private int imo = 0;
    private int imp = 0;
    private boolean imq = false;
    private int mode = a.iid;
    private long timestamp = 0;

    static /* synthetic */ void a(LaunchAAUI launchAAUI) {
        String obj = launchAAUI.ilT.getText().toString();
        ((i) g.h(i.class)).a(launchAAUI.mController, launchAAUI.chatroomName, launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uNy) + (bi.oN(obj) ? launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uQe) : obj), launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uNx), new o.a() {
            public final void a(boolean z, String str, int i) {
                if (z) {
                    LaunchAAUI.j(LaunchAAUI.this);
                }
            }
        });
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, String str, final String str2) {
        launchAAUI.imm.setVisibility(0);
        launchAAUI.imm.startAnimation(AnimationUtils.loadAnimation(launchAAUI, com.tencent.mm.plugin.wxpay.a.a.ugM));
        launchAAUI.imm.setText(str);
        launchAAUI.imm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                com.tencent.mm.bl.d.b(LaunchAAUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, List list) {
        Intent intent = new Intent(launchAAUI, AASelectContactUI.class);
        intent.putExtra("titile", launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uQh));
        intent.putExtra("list_type", 12);
        intent.putExtra("chatroomName", launchAAUI.chatroomName);
        if (list != null) {
            intent.putExtra("already_select_contact", bi.d(list, ","));
        }
        intent.putExtra("max_select_num", s.eX(launchAAUI.chatroomName) ? (long) Math.min(d.WO(), m.gn(launchAAUI.chatroomName)) : (long) Math.min(d.WO(), 2));
        intent.putExtra("select_type", 1);
        launchAAUI.startActivityForResult(intent, 233);
        com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(2), Integer.valueOf(2));
    }

    static /* synthetic */ void e(LaunchAAUI launchAAUI) {
        x.i("MicroMsg.LaunchAAUI", "switchMode");
        launchAAUI.ilS = false;
        if (launchAAUI.mode == a.iid) {
            launchAAUI.mode = a.iie;
            launchAAUI.imb.setVisibility(8);
            launchAAUI.imc.setVisibility(8);
            launchAAUI.ime.setVisibility(0);
            launchAAUI.ilU.setText(launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uQb, new Object[]{Integer.valueOf(0)}));
            if (launchAAUI.imi != null && launchAAUI.imi.size() > d.WN()) {
                com.tencent.mm.plugin.report.service.g.pWK.h(13722, Integer.valueOf(8));
                launchAAUI.ilS = true;
            }
            if (launchAAUI.ilS) {
                launchAAUI.oX(launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uPY, new Object[]{Integer.valueOf(d.WN())}));
            } else {
                launchAAUI.Xo();
            }
            com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(2), Integer.valueOf(1));
        } else {
            launchAAUI.mode = a.iid;
            launchAAUI.imb.setVisibility(0);
            launchAAUI.imc.setVisibility(0);
            launchAAUI.ime.setVisibility(8);
            launchAAUI.ilU.setText(com.tencent.mm.plugin.wxpay.a.i.uPU);
            launchAAUI.ilS = false;
            if (launchAAUI.imd.size() > d.WO()) {
                com.tencent.mm.plugin.report.service.g.pWK.h(13722, Integer.valueOf(8));
                launchAAUI.ilS = true;
            }
            launchAAUI.Xs();
            com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(3), Integer.valueOf(1));
        }
        launchAAUI.Xj();
        launchAAUI.aWY();
        launchAAUI.Xn();
        launchAAUI.Xq();
        launchAAUI.Xp();
        launchAAUI.ilX.post(new Runnable() {
            public final void run() {
            }
        });
    }

    static /* synthetic */ void i(LaunchAAUI launchAAUI) {
        Intent intent = new Intent(launchAAUI, LaunchAAByPersonAmountSelectUI.class);
        intent.putExtra("chatroom", launchAAUI.chatroomName);
        intent.putExtra("maxPerAmount", d.WP());
        if (launchAAUI.imi != null && launchAAUI.imi.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAUI.imi.keySet()) {
                arrayList.add(str + "," + ((Double) launchAAUI.imi.get(str)).doubleValue());
            }
            intent.putStringArrayListExtra("oldAmountData", arrayList);
        }
        intent.putExtra("maxUserNumber", d.WN());
        launchAAUI.startActivityForResult(intent, JsApiGetSetting.CTRL_INDEX);
        com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(3), Integer.valueOf(2));
    }

    static /* synthetic */ void j(LaunchAAUI launchAAUI) {
        if (launchAAUI.mode != a.iid) {
            launchAAUI.Xo();
            launchAAUI.Xr();
        } else if (!bi.oN(launchAAUI.ilY.getText()) && launchAAUI.imd != null && launchAAUI.imd.size() != 0) {
            launchAAUI.Xo();
            com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(2), Integer.valueOf(3));
            Map hashMap = new HashMap();
            try {
                Object string;
                String obj = launchAAUI.ilT.getText().toString();
                if (bi.oN(obj)) {
                    string = launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uQe);
                } else {
                    String string2 = obj;
                }
                double d = bi.getDouble(launchAAUI.ilY.getText(), 0.0d);
                hashMap.put(k.iiY, string2);
                hashMap.put(k.iiZ, Double.valueOf(100.0d * d));
                hashMap.put(k.ijc, launchAAUI.chatroomName);
                hashMap.put(k.ijf, Long.valueOf(launchAAUI.timestamp));
                if ((launchAAUI.imd != null ? launchAAUI.imd.size() : 0) > 0) {
                    long aI = h.aI(launchAAUI.ikp.getText(), "100");
                    x.d("MicroMsg.LaunchAAUI", "perAmount: %s", Long.valueOf(aI));
                    if (aI <= 0 || aI > d.WP()) {
                        x.i("MicroMsg.LaunchAAUI", "illegal avgAmount: %s", Long.valueOf(aI));
                        return;
                    }
                    hashMap.put(k.ijb, Long.valueOf(aI));
                    hashMap.put(k.ije, launchAAUI.imd);
                    launchAAUI.ikw = com.tencent.mm.wallet_core.ui.g.a(launchAAUI, false, null);
                    com.tencent.mm.vending.g.g.t(Integer.valueOf(launchAAUI.mode), hashMap).b(launchAAUI.ilR.ijR).e(new com.tencent.mm.vending.c.a<Void, Boolean>() {
                        public final /* synthetic */ Object call(Object obj) {
                            x.d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", (Boolean) obj);
                            if (LaunchAAUI.this.ikw != null) {
                                LaunchAAUI.this.ikw.dismiss();
                            }
                            if (r7.booleanValue()) {
                                LaunchAAUI.l(LaunchAAUI.this);
                                Toast.makeText(LaunchAAUI.this, com.tencent.mm.plugin.wxpay.a.i.uQi, 1).show();
                                com.tencent.mm.plugin.report.service.g.pWK.h(13722, Integer.valueOf(4));
                            } else {
                                Toast.makeText(LaunchAAUI.this, com.tencent.mm.plugin.wxpay.a.i.uQf, 1).show();
                                com.tencent.mm.plugin.report.service.g.pWK.h(13722, Integer.valueOf(5));
                            }
                            return zLb;
                        }
                    }).a(new com.tencent.mm.vending.g.d.a() {
                        public final void aW(Object obj) {
                            x.i("MicroMsg.LaunchAAUI", "onInterrupt: %s", obj);
                            if (LaunchAAUI.this.ikw != null) {
                                LaunchAAUI.this.ikw.dismiss();
                            }
                            if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                                Toast.makeText(LaunchAAUI.this, obj.toString(), 1).show();
                            } else if (obj == null || !(obj instanceof y)) {
                                Toast.makeText(LaunchAAUI.this, com.tencent.mm.plugin.wxpay.a.i.uQf, 1).show();
                            } else {
                                h.a(LaunchAAUI.this.mController.xRr, (y) obj);
                            }
                            com.tencent.mm.plugin.report.service.g.pWK.h(13722, Integer.valueOf(5));
                        }
                    });
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(13723, Integer.valueOf(1), h.oS(launchAAUI.chatroomName), Integer.valueOf(r0), Double.valueOf(d * 100.0d), string2);
            } catch (Exception e) {
                x.e("MicroMsg.LaunchAAUI", "launchAAByMoney mode: %s error: %s", Integer.valueOf(launchAAUI.mode), e.getMessage());
            }
        }
    }

    static /* synthetic */ void l(LaunchAAUI launchAAUI) {
        if (launchAAUI.getIntent().getIntExtra("enter_scene", 1) == 3) {
            launchAAUI.setResult(-1);
            launchAAUI.finish();
            return;
        }
        Intent intent = new Intent();
        intent.setFlags(67108864);
        intent.putExtra("key_should_finish", true);
        com.tencent.mm.bl.d.b(launchAAUI.mController.xRr, "offline", ".ui.WalletOfflineCoinPurseUI", intent);
    }

    public void onCreate(Bundle bundle) {
        List F;
        CharSequence spannableString;
        super.onCreate(bundle);
        x.i("MicroMsg.LaunchAAUI", "LaunchAAUI onCreate");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                LaunchAAUI.this.finish();
                return false;
            }
        });
        this.timestamp = System.currentTimeMillis() / 1000;
        setMMTitle(com.tencent.mm.plugin.wxpay.a.i.uQj);
        com.tencent.mm.vending.g.g.cAN().b(this.ilR.ijT).e(new com.tencent.mm.vending.c.a<Void, d>() {
            public final /* synthetic */ Object call(Object obj) {
                d dVar = (d) obj;
                x.i("MicroMsg.LaunchAAUI", "fetch operation data finish");
                if (dVar != null) {
                    LaunchAAUI.this.imn = dVar;
                    if (!(bi.oN(LaunchAAUI.this.imn.iiM) || bi.oN(LaunchAAUI.this.imn.iiL))) {
                        LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.this.imn.iiM, LaunchAAUI.this.imn.iiL);
                    }
                }
                return zLb;
            }
        }).a(new com.tencent.mm.vending.g.d.a() {
            public final void aW(Object obj) {
                x.i("MicroMsg.LaunchAAUI", "fetch operation data failed");
            }
        });
        this.chatroomName = getIntent().getStringExtra("chatroom_name");
        if (bi.oN(this.chatroomName)) {
            x.e("MicroMsg.LaunchAAUI", "chatroomName is null!!!");
            this.chatroomName = "";
        }
        String str = this.chatroomName;
        if (!bi.oN(str)) {
            if (!s.eX(str)) {
                F = bi.F(str.split(","));
                if (F != null) {
                    F.remove(q.FY());
                    if (F.size() > 0) {
                        str = (String) F.get(0);
                    }
                }
            }
            this.chatroomName = str;
            this.ilc = findViewById(f.cID);
            this.ilc.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    LaunchAAUI.this.Xj();
                    LaunchAAUI.this.aWY();
                    return false;
                }
            });
            this.ilW = (TextView) findViewById(f.usd);
            this.ilW.setClickable(true);
            this.ilW.setOnTouchListener(new l(this));
            Xn();
            this.imk = (Button) findViewById(f.urW);
            this.imk.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    LaunchAAUI.a(LaunchAAUI.this);
                }
            });
            this.iml = (TextView) findViewById(f.urT);
            this.imm = (TextView) findViewById(f.ush);
            this.ilT = (MMEditText) findViewById(f.use);
            this.ilU = (TextView) findViewById(f.usg);
            this.ikp = (TextView) findViewById(f.urU);
            this.ilV = (TextView) findViewById(f.urV);
            this.ilU.setText(com.tencent.mm.plugin.wxpay.a.i.uPU);
            this.mode = a.iid;
            this.ilX = (TextView) findViewById(f.ukA);
            this.ilX.setClickable(true);
            this.ilX.setOnTouchListener(new l());
            spannableString = new SpannableString(getString(com.tencent.mm.plugin.wxpay.a.i.uOH));
            spannableString.setSpan(new a(new a.a() {
                public final void WX() {
                    LaunchAAUI.this.startActivity(new Intent(LaunchAAUI.this, AAQueryListUI.class));
                    if (LaunchAAUI.this.mode == a.iid) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(5), Integer.valueOf(1));
                        return;
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(5), Integer.valueOf(2));
                }
            }), 0, spannableString.length(), 18);
            this.ilX.setText(spannableString);
            this.ilX.setVisibility(8);
            this.ilT.addTextChangedListener(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    LaunchAAUI.this.Xp();
                }
            });
            this.ilY = (WalletFormView) findViewById(f.usf);
            this.ilY.a(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (editable.toString().startsWith(".")) {
                        editable.insert(0, "0");
                    }
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    int length = obj.length();
                    if (indexOf >= 0 && length - indexOf > 3) {
                        editable.delete(indexOf + 3, length);
                    } else if (indexOf > 6) {
                        editable.delete(6, indexOf);
                    } else if (indexOf == -1 && length > 6) {
                        editable.delete(6, length);
                    }
                    double d = bi.getDouble(editable.toString(), 0.0d);
                    if (LaunchAAUI.this.imd != null && LaunchAAUI.this.imd.size() > 0) {
                        d = (d * 100.0d) / ((double) LaunchAAUI.this.imd.size());
                        LaunchAAUI.this.imn;
                        if (d > ((double) d.WP())) {
                            LaunchAAUI.this.ilB = true;
                            com.tencent.mm.plugin.report.service.g.pWK.h(13722, Integer.valueOf(2));
                            LaunchAAUI.this.Xp();
                            LaunchAAUI.this.Xq();
                            LaunchAAUI.this.Xs();
                        }
                    }
                    LaunchAAUI.this.ilB = false;
                    LaunchAAUI.this.Xp();
                    LaunchAAUI.this.Xq();
                    LaunchAAUI.this.Xs();
                }
            });
            a(this.ilY, 2, false, false);
            this.ima = (TextView) findViewById(f.urX);
            this.ilZ = (TextView) findViewById(f.urY);
            if (s.eX(this.chatroomName)) {
                x.i("MicroMsg.LaunchAAUI", "is single chat: %s", this.chatroomName);
                F = new ArrayList();
                F.add(q.FY());
                F.add(this.chatroomName);
            } else {
                F = h.oS(this.chatroomName);
            }
            this.imd = F;
            if (this.imd.size() > d.WO()) {
                this.imd.clear();
                this.ima.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uSN));
                Xp();
            } else if (s.eX(this.chatroomName)) {
                this.ima.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uPV, new Object[]{Integer.valueOf(F.size())}));
            } else {
                this.ima.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uPR, new Object[]{Integer.valueOf(F.size())}));
            }
            this.ima.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    LaunchAAUI.this.Xj();
                    LaunchAAUI.this.aWY();
                    LaunchAAUI.a(LaunchAAUI.this, F);
                }
            });
            this.imb = (ViewGroup) findViewById(f.usk);
            this.imc = (ViewGroup) findViewById(f.usj);
            this.ilY.requestFocus();
            this.ilS = false;
            this.img = (TextView) findViewById(f.usc);
            this.img.setText(com.tencent.mm.plugin.wxpay.a.i.uQc);
            this.img.setTextColor(getResources().getColor(c.uha));
            this.ime = (ViewGroup) findViewById(f.usl);
            this.imf = (ViewGroup) findViewById(f.usm);
            this.imh = (ViewGroup) findViewById(f.usb);
            this.imh.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    LaunchAAUI.i(LaunchAAUI.this);
                }
            });
            ck(false);
            com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(1), Integer.valueOf(1));
            this.ilX.post(new Runnable() {
                public final void run() {
                }
            });
        }
        str = "";
        this.chatroomName = str;
        this.ilc = findViewById(f.cID);
        this.ilc.setOnTouchListener(/* anonymous class already generated */);
        this.ilW = (TextView) findViewById(f.usd);
        this.ilW.setClickable(true);
        this.ilW.setOnTouchListener(new l(this));
        Xn();
        this.imk = (Button) findViewById(f.urW);
        this.imk.setOnClickListener(/* anonymous class already generated */);
        this.iml = (TextView) findViewById(f.urT);
        this.imm = (TextView) findViewById(f.ush);
        this.ilT = (MMEditText) findViewById(f.use);
        this.ilU = (TextView) findViewById(f.usg);
        this.ikp = (TextView) findViewById(f.urU);
        this.ilV = (TextView) findViewById(f.urV);
        this.ilU.setText(com.tencent.mm.plugin.wxpay.a.i.uPU);
        this.mode = a.iid;
        this.ilX = (TextView) findViewById(f.ukA);
        this.ilX.setClickable(true);
        this.ilX.setOnTouchListener(new l());
        spannableString = new SpannableString(getString(com.tencent.mm.plugin.wxpay.a.i.uOH));
        spannableString.setSpan(new a(/* anonymous class already generated */), 0, spannableString.length(), 18);
        this.ilX.setText(spannableString);
        this.ilX.setVisibility(8);
        this.ilT.addTextChangedListener(/* anonymous class already generated */);
        this.ilY = (WalletFormView) findViewById(f.usf);
        this.ilY.a(/* anonymous class already generated */);
        a(this.ilY, 2, false, false);
        this.ima = (TextView) findViewById(f.urX);
        this.ilZ = (TextView) findViewById(f.urY);
        if (s.eX(this.chatroomName)) {
            x.i("MicroMsg.LaunchAAUI", "is single chat: %s", this.chatroomName);
            F = new ArrayList();
            F.add(q.FY());
            F.add(this.chatroomName);
        } else {
            F = h.oS(this.chatroomName);
        }
        this.imd = F;
        if (this.imd.size() > d.WO()) {
            this.imd.clear();
            this.ima.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uSN));
            Xp();
        } else if (s.eX(this.chatroomName)) {
            this.ima.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uPV, new Object[]{Integer.valueOf(F.size())}));
        } else {
            this.ima.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uPR, new Object[]{Integer.valueOf(F.size())}));
        }
        this.ima.setOnClickListener(/* anonymous class already generated */);
        this.imb = (ViewGroup) findViewById(f.usk);
        this.imc = (ViewGroup) findViewById(f.usj);
        this.ilY.requestFocus();
        this.ilS = false;
        this.img = (TextView) findViewById(f.usc);
        this.img.setText(com.tencent.mm.plugin.wxpay.a.i.uQc);
        this.img.setTextColor(getResources().getColor(c.uha));
        this.ime = (ViewGroup) findViewById(f.usl);
        this.imf = (ViewGroup) findViewById(f.usm);
        this.imh = (ViewGroup) findViewById(f.usb);
        this.imh.setOnClickListener(/* anonymous class already generated */);
        ck(false);
        com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(1), Integer.valueOf(1));
        this.ilX.post(/* anonymous class already generated */);
    }

    protected final boolean Xm() {
        return false;
    }

    private void Xn() {
        Object string;
        CharSequence string2;
        CharSequence spannableStringBuilder;
        if (this.mode == a.iid) {
            string = getString(com.tencent.mm.plugin.wxpay.a.i.uPS);
            string2 = getString(com.tencent.mm.plugin.wxpay.a.i.uPT);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new a(new a.a() {
                public final void WX() {
                    LaunchAAUI.e(LaunchAAUI.this);
                }
            }), string.length(), spannableStringBuilder.length(), 18);
            this.ilW.setText(spannableStringBuilder);
        } else if (this.mode == a.iie) {
            string = getString(com.tencent.mm.plugin.wxpay.a.i.uPZ);
            string2 = getString(com.tencent.mm.plugin.wxpay.a.i.uQa);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new a(new a.a() {
                public final void WX() {
                    LaunchAAUI.e(LaunchAAUI.this);
                }
            }), string.length(), spannableStringBuilder.length(), 18);
            this.ilW.setText(spannableStringBuilder);
        }
    }

    private void oX(String str) {
        this.imq = true;
        this.iml.setVisibility(0);
        this.iml.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.ugM));
        this.iml.setText(str);
    }

    private void Xo() {
        this.imq = false;
        if (this.iml.getVisibility() != 8) {
            this.iml.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.ugN));
            this.iml.setVisibility(8);
        }
    }

    private void Xp() {
        if (this.mode == a.iid) {
            if (bi.oN(this.ilY.getText())) {
                ck(false);
                return;
            } else if (this.ilB) {
                ck(false);
                return;
            } else if (this.imd == null || this.imd.size() == 0) {
                ck(false);
                return;
            } else if (this.imd.size() > d.WO() || this.ilS) {
                ck(false);
                return;
            } else {
                x.d("MicroMsg.LaunchAAUI", "b1: %s, b2: %s, avg: %s", this.ilY.getText(), Integer.valueOf(this.imd.size()), Double.valueOf(h.b(this.ilY.getText(), this.imd.size(), 5, 4)));
                if (h.b(this.ilY.getText(), this.imd.size(), 5, 4) < 0.01d) {
                    x.i("MicroMsg.LaunchAAUI", "less than 0.01");
                    ck(false);
                    return;
                }
            }
        } else if (this.imi == null || this.imi.size() == 0) {
            ck(false);
            return;
        } else if (this.imi.size() > d.WO() || this.ilS) {
            ck(false);
            return;
        }
        ck(true);
    }

    private void ck(boolean z) {
        this.imk.setEnabled(z);
        if (z) {
            this.ilU.setTextColor(getResources().getColor(c.black));
            this.ikp.setTextColor(getResources().getColor(c.black));
            this.ilV.setTextColor(getResources().getColor(c.black));
            return;
        }
        this.ilU.setTextColor(getResources().getColor(c.uhb));
        this.ikp.setTextColor(getResources().getColor(c.uhb));
        this.ilV.setTextColor(getResources().getColor(c.uhb));
    }

    private void Xq() {
        double b;
        if (this.mode == a.iid) {
            if (this.imd == null || this.imd.size() <= 0) {
                this.ikp.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uNr));
            } else {
                b = h.b(this.ilY.getText(), this.imd.size(), 2, 2);
                this.ikp.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uNp, new Object[]{Double.valueOf(b)}));
            }
            this.ilU.setText(com.tencent.mm.plugin.wxpay.a.i.uPU);
        } else if (this.imi == null || this.imi.size() == 0) {
            this.ilU.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uQb, new Object[]{Integer.valueOf(0)}));
            this.ikp.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uNr));
        } else {
            b = 0.0d;
            Iterator it = this.imi.values().iterator();
            while (true) {
                double d = b;
                if (it.hasNext()) {
                    b = ((Double) it.next()).doubleValue() + d;
                } else {
                    this.ikp.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uNp, new Object[]{Double.valueOf(d)}));
                    this.ilU.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uQb, new Object[]{Integer.valueOf(this.imi.size())}));
                    return;
                }
            }
        }
    }

    private void Xr() {
        com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(3), Integer.valueOf(3));
        Map hashMap = new HashMap();
        try {
            Object string;
            long j;
            String obj = this.ilT.getText().toString();
            if (bi.oN(obj)) {
                string = getString(com.tencent.mm.plugin.wxpay.a.i.uQe);
            } else {
                String string2 = obj;
            }
            long j2 = 0;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            Iterator it = this.imi.keySet().iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                obj = (String) it.next();
                double doubleValue = ((Double) this.imi.get(obj)).doubleValue();
                j jVar = new j();
                jVar.fMM = (long) (doubleValue * 100.0d);
                jVar.username = obj;
                arrayList.add(jVar);
                j2 = jVar.fMM + j;
                arrayList2.add(jVar.fMM);
            }
            j jVar2 = new j();
            jVar2.username = q.FY();
            jVar2.fMM = j;
            hashMap.put(k.iiY, string2);
            hashMap.put(k.iiZ, Long.valueOf(j));
            hashMap.put(k.ije, arrayList);
            hashMap.put(k.ijc, this.chatroomName);
            hashMap.put(k.ijf, Long.valueOf(this.timestamp));
            if (this.ikw != null) {
                this.ikw.dismiss();
            }
            this.ikw = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
            com.tencent.mm.vending.g.g.cq(hashMap).b(this.ilR.ijS).e(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.vending.j.d<Boolean, String, Long>>() {
                public final /* synthetic */ Object call(Object obj) {
                    x.d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", ((com.tencent.mm.vending.j.d) obj).get(0));
                    if (LaunchAAUI.this.ikw != null) {
                        LaunchAAUI.this.ikw.dismiss();
                    }
                    if (((Boolean) r8.get(0)).booleanValue()) {
                        LaunchAAUI.l(LaunchAAUI.this);
                        Toast.makeText(LaunchAAUI.this, com.tencent.mm.plugin.wxpay.a.i.uQi, 1).show();
                        com.tencent.mm.plugin.report.service.g.pWK.h(13722, Integer.valueOf(9));
                    } else {
                        Toast.makeText(LaunchAAUI.this, com.tencent.mm.plugin.wxpay.a.i.uQf, 1).show();
                        com.tencent.mm.plugin.report.service.g.pWK.h(13722, Integer.valueOf(10));
                    }
                    return zLb;
                }
            }).a(new com.tencent.mm.vending.g.d.a() {
                public final void aW(Object obj) {
                    x.i("MicroMsg.LaunchAAUI", "onInterrupt: %s", obj);
                    if (LaunchAAUI.this.ikw != null) {
                        LaunchAAUI.this.ikw.dismiss();
                    }
                    if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                        Toast.makeText(LaunchAAUI.this, obj.toString(), 1).show();
                    } else if (obj == null || !(obj instanceof y)) {
                        Toast.makeText(LaunchAAUI.this, com.tencent.mm.plugin.wxpay.a.i.uQf, 1).show();
                    } else {
                        h.a(LaunchAAUI.this.mController.xRr, (y) obj);
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.h(13722, Integer.valueOf(10));
                }
            });
            com.tencent.mm.plugin.report.service.g.pWK.h(13723, Integer.valueOf(2), Integer.valueOf(h.oS(this.chatroomName).size()), Integer.valueOf(arrayList.size() + 1), Long.valueOf(j), string2, bi.d(arrayList2, ","));
        } catch (Exception e) {
            x.e("MicroMsg.LaunchAAUI", "launchAAByPerson error: %s", e.getMessage());
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uIH;
    }

    protected void onStop() {
        super.onStop();
        if (this.imj != null) {
            this.imj.clear();
        }
    }

    private void Xs() {
        if (!this.ilS || this.imq) {
            if (this.ilB && !this.imq) {
                oX(getString(com.tencent.mm.plugin.wxpay.a.i.uQg, new Object[]{Float.valueOf(((float) d.WP()) / 100.0f)}));
            } else if (!this.ilS && !this.ilB) {
                Xo();
            }
        } else if (this.mode == a.iid) {
            oX(getString(com.tencent.mm.plugin.wxpay.a.i.uPY, new Object[]{Integer.valueOf(d.WO())}));
        } else {
            oX(getString(com.tencent.mm.plugin.wxpay.a.i.uPY, new Object[]{Integer.valueOf(d.WN())}));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        String[] split;
        int i3;
        if (i == 233) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Contact");
                if (this.mode == a.iid) {
                    if (!bi.oN(stringExtra)) {
                        split = stringExtra.split(",");
                        this.imd.clear();
                        this.imd.addAll(Arrays.asList(split));
                    }
                    List oS = h.oS(this.chatroomName);
                    TextView textView;
                    Object[] objArr;
                    if (oS == null || this.imd == null || this.imd.size() != oS.size() || !s.eX(this.chatroomName)) {
                        textView = this.ima;
                        i3 = com.tencent.mm.plugin.wxpay.a.i.uPV;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.imd != null ? this.imd.size() : 0);
                        textView.setText(getString(i3, objArr));
                    } else {
                        textView = this.ima;
                        i3 = com.tencent.mm.plugin.wxpay.a.i.uPR;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.imd != null ? this.imd.size() : 0);
                        textView.setText(getString(i3, objArr));
                    }
                }
                Xo();
                if (this.imd == null || this.imd.size() <= d.WO()) {
                    this.ilS = false;
                } else {
                    this.ilS = true;
                }
                double d = bi.getDouble(this.ilY.getText(), 0.0d);
                if (this.imd == null || (d * 100.0d) / ((double) this.imd.size()) <= ((double) d.WP())) {
                    this.ilB = false;
                } else {
                    this.ilB = true;
                    com.tencent.mm.plugin.report.service.g.pWK.h(13722, Integer.valueOf(2));
                }
                Xp();
                Xq();
                Xs();
            }
        } else if (i == JsApiGetSetting.CTRL_INDEX && i2 == -1) {
            int dimension;
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selectUI");
            this.imi.clear();
            if (stringArrayListExtra != null) {
                try {
                    if (stringArrayListExtra.size() > 0) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            split = ((String) it.next()).split(",");
                            this.imi.put(split[0], Double.valueOf(bi.getDouble(split[1], 0.0d)));
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", e.getMessage());
                    return;
                }
            }
            if (this.imi == null || this.imi.size() <= 0) {
                this.img.setText(com.tencent.mm.plugin.wxpay.a.i.uQc);
                this.img.setTextColor(getResources().getColor(c.uha));
                dimension = (int) getResources().getDimension(com.tencent.mm.plugin.wxpay.a.d.uim);
                this.imh.setPadding(dimension, dimension, dimension, dimension);
                this.imh.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.ujh);
                this.imf.setVisibility(8);
            } else {
                this.img.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uQd, new Object[]{Integer.valueOf(this.imi.size())}));
                this.img.setTextColor(getResources().getColor(c.black));
                dimension = (int) getResources().getDimension(com.tencent.mm.plugin.wxpay.a.d.uim);
                this.imh.setPadding(dimension, (int) getResources().getDimension(com.tencent.mm.plugin.wxpay.a.d.uik), dimension, (int) getResources().getDimension(com.tencent.mm.plugin.wxpay.a.d.uil));
                this.imh.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.ujg);
                this.imf.setVisibility(0);
            }
            this.imf.removeAllViews();
            this.imj.clear();
            dimension = 0;
            if (this.imi != null && this.imi.size() > 0) {
                Iterator it2 = this.imi.keySet().iterator();
                while (true) {
                    i3 = dimension;
                    if (!it2.hasNext()) {
                        break;
                    }
                    stringExtra = (String) it2.next();
                    double doubleValue = ((Double) this.imi.get(stringExtra)).doubleValue();
                    View launchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
                    if (i3 >= this.imi.size() - 1) {
                        launchAAByPersonNameAmountRow.iln.setVisibility(8);
                    }
                    launchAAByPersonNameAmountRow.ill.setText(com.tencent.mm.pluginsdk.ui.d.i.b(launchAAByPersonNameAmountRow.getContext(), ((b) g.h(b.class)).L(stringExtra, this.chatroomName), launchAAByPersonNameAmountRow.ill.getTextSize()));
                    launchAAByPersonNameAmountRow.ikp.setText(launchAAByPersonNameAmountRow.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.uNp, new Object[]{Double.valueOf(doubleValue)}));
                    this.imf.addView(launchAAByPersonNameAmountRow);
                    this.imj.put(stringExtra, launchAAByPersonNameAmountRow);
                    dimension = i3 + 1;
                }
            }
            if (this.ilc != null) {
                this.ilc.requestLayout();
            }
            this.imp = 0;
            this.ilX.post(new Runnable() {
                public final void run() {
                }
            });
            Xq();
            Xp();
        }
    }
}
