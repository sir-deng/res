package com.tencent.mm.plugin.welab.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bl.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.aoi;
import com.tencent.mm.protocal.c.aoj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

public class WelabAppInfoUI extends MMActivity {
    private String fGh;
    private TextView ikn;
    private TextView jTH;
    private Button mBI;
    private TextView ppv;
    private com.tencent.mm.plugin.welab.c.a.a tWd;
    private int tWe;
    private boolean tWf;
    private WelabRoundCornerImageView tWg;
    private RecyclerView tWh;
    private View tWi;
    private View tWj;
    private MMSwitchBtn tWk;
    private View tWl;
    private View tWm;
    private a tWn;
    private OnClickListener tWo = new OnClickListener() {
        public final void onClick(View view) {
            String obj = view.getTag().toString();
            Intent intent = new Intent();
            intent.putExtra("nowUrl", obj);
            intent.putExtra("urlList", (String[]) ((a) WelabAppInfoUI.this.tWh.fn()).lqU.toArray(new String[0]));
            Context context = WelabAppInfoUI.this;
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            d.b(context, "subapp", ".ui.gallery.GestureGalleryUI", intent2);
        }
    };

    private class a extends android.support.v7.widget.RecyclerView.a<b> {
        public List<String> lqU;

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            View inflate = WelabAppInfoUI.this.getLayoutInflater().inflate(c.tVL, viewGroup, false);
            t bVar = new b(inflate);
            bVar.tWq = (ImageView) inflate.findViewById(com.tencent.mm.plugin.welab.a.b.tVA);
            bVar.tWq.setOnClickListener(WelabAppInfoUI.this.tWo);
            return bVar;
        }

        public final /* synthetic */ void a(t tVar, int i) {
            b bVar = (b) tVar;
            bVar.tWq.setTag(this.lqU.get(i));
            com.tencent.mm.ap.a.a.PN().a((String) this.lqU.get(i), bVar.tWq, com.tencent.mm.plugin.welab.b.bWh().trR);
        }

        public final int getItemCount() {
            return this.lqU.size();
        }
    }

    private class b extends t {
        public ImageView tWq;

        public b(View view) {
            super(view);
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.fGh = intent.getStringExtra("para_appid");
            this.tWd = com.tencent.mm.plugin.welab.b.bWh().Rb(this.fGh);
            this.tWe = this.tWd.field_Switch;
            if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
                z = false;
            }
            this.tWf = z;
        }
        initView();
        e.o(this.fGh, 2, this.tWf);
    }

    protected final int getLayoutId() {
        return c.tVN;
    }

    protected final void initView() {
        super.initView();
        if (this.tWd == null) {
            x.e("WelabAppInfoUI", "info is null");
            return;
        }
        cnG();
        Ei(8);
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.tVw));
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.tVw));
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WelabAppInfoUI.this.aWY();
                WelabAppInfoUI.this.finish();
                return true;
            }
        });
        this.tWg = (WelabRoundCornerImageView) findViewById(com.tencent.mm.plugin.welab.a.b.tVx);
        this.ikn = (TextView) findViewById(com.tencent.mm.plugin.welab.a.b.title);
        this.ppv = (TextView) findViewById(com.tencent.mm.plugin.welab.a.b.summary);
        this.tWh = (RecyclerView) findViewById(com.tencent.mm.plugin.welab.a.b.tVB);
        this.tWi = findViewById(com.tencent.mm.plugin.welab.a.b.tVy);
        this.mBI = (Button) findViewById(com.tencent.mm.plugin.welab.a.b.cBO);
        this.tWj = findViewById(com.tencent.mm.plugin.welab.a.b.tVz);
        this.tWk = (MMSwitchBtn) findViewById(com.tencent.mm.plugin.welab.a.b.checkbox);
        this.jTH = (TextView) findViewById(com.tencent.mm.plugin.welab.a.b.tVJ);
        this.tWl = findViewById(com.tencent.mm.plugin.welab.a.b.tVI);
        this.tWm = findViewById(com.tencent.mm.plugin.welab.a.b.tVF);
        this.tWh.a(new LinearLayoutManager(0, false));
        this.tWh.setOverScrollMode(2);
        this.tWn = new a();
        this.tWh.a(this.tWn);
    }

    protected void onPause() {
        super.onPause();
        if (this.tWe != this.tWd.field_Switch) {
            com.tencent.mm.plugin.welab.b.bWh().tVV.c(this.tWd, new String[0]);
            com.tencent.mm.bp.a aoj = new aoj();
            aoi aoi = new aoi();
            aoi.wBU = bi.Wo(this.tWd.field_expId);
            aoi.wBV = this.tWd.field_LabsAppId;
            aoi.wnV = this.tWd.field_Switch == 2 ? 1 : 2;
            aoj.gDp.add(aoi);
            ((h) g.h(h.class)).Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(207, aoj));
            e.o(this.fGh, this.tWd.field_Switch == 2 ? 4 : 5, this.tWf);
        }
    }

    protected void onResume() {
        TextView textView;
        com.tencent.mm.ap.a.a PN;
        super.onResume();
        if (this.tWd.bWs() && this.tWd.field_Type == 1) {
            this.tWi.setVisibility(0);
            this.jTH.setText(getResources().getString(com.tencent.mm.plugin.welab.a.d.tVS) + this.tWd.Ri("field_Title"));
            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
            this.tWk.setEnabled(true);
            if (this.tWd.field_Switch == 2) {
                sharedPreferences.edit().putBoolean(bWt(), true).commit();
                this.tWk.nJ(true);
            } else {
                sharedPreferences.edit().putBoolean(bWt(), false).commit();
                this.tWk.nJ(false);
            }
            this.tWk.zEt = new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
                public final void cy(boolean z) {
                    if (WelabAppInfoUI.this.tWd.field_Switch == 2) {
                        WelabAppInfoUI.this.tWd.field_Switch = 1;
                    } else if (WelabAppInfoUI.this.tWd.field_Switch == 1) {
                        WelabAppInfoUI.this.tWd.field_Switch = 2;
                    }
                }
            };
        } else {
            this.tWi.setVisibility(8);
        }
        if (this.tWd.bWs()) {
            this.mBI.setText(getResources().getString(com.tencent.mm.plugin.welab.a.d.tVQ) + this.tWd.Ri("field_Title"));
            if (this.tWd.field_Type != 1) {
                this.mBI.setVisibility(0);
                this.mBI.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        x.i("WelabAppInfoUI", "open func " + WelabAppInfoUI.this.fGh);
                        com.tencent.mm.plugin.welab.b bWh = com.tencent.mm.plugin.welab.b.bWh();
                        Activity activity = WelabAppInfoUI.this;
                        String b = WelabAppInfoUI.this.fGh;
                        com.tencent.mm.plugin.welab.a.a.b bVar = (com.tencent.mm.plugin.welab.a.a.b) bWh.tVW.get(b);
                        if (bVar != null) {
                            x.i("WelabMgr", "use custome opener to open " + b);
                            bVar.e(activity, b);
                        } else {
                            x.i("WelabMgr", "use default opener open " + b);
                            if (bWh.Rb(b).field_Type != 2) {
                                x.e("WelabMgr", "can not find opener for " + b);
                            } else if (bWh.tVX != null) {
                                bWh.tVX.e(activity, b);
                            } else {
                                x.e("WelabMgr", "defaultWeAppOpener is null!");
                            }
                        }
                        e.o(WelabAppInfoUI.this.fGh, 7, WelabAppInfoUI.this.tWf);
                    }
                });
                textView = this.ikn;
                com.tencent.mm.plugin.welab.b.bWh();
                textView.setText(com.tencent.mm.plugin.welab.b.a(this.tWd));
                this.ppv.setText(this.tWd.Ri("field_Introduce"));
                if (this.tWd.bWs()) {
                    this.tWj.setVisibility(8);
                } else {
                    this.tWj.setVisibility(0);
                    this.tWj.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            try {
                                String str = "";
                                g.Do();
                                int Cn = com.tencent.mm.kernel.a.Cn();
                                String encode = URLEncoder.encode(com.tencent.mm.protocal.d.vHj, ProtocolPackage.ServerEncoding);
                                String encode2 = URLEncoder.encode(bi.che(), ProtocolPackage.ServerEncoding);
                                String encode3 = URLEncoder.encode(q.yL(), ProtocolPackage.ServerEncoding);
                                String encode4 = URLEncoder.encode(com.tencent.mm.protocal.d.vHe, ProtocolPackage.ServerEncoding);
                                String encode5 = URLEncoder.encode(com.tencent.mm.protocal.d.vHf, ProtocolPackage.ServerEncoding);
                                String encode6 = URLEncoder.encode(com.tencent.mm.protocal.d.vHg, ProtocolPackage.ServerEncoding);
                                g.Do();
                                String str2 = ("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&from=" + URLEncoder.encode(WelabAppInfoUI.this.tWd.field_expId + "|" + WelabAppInfoUI.this.fGh) + "&version=" + com.tencent.mm.protocal.d.vHl + "&lang=" + w.eM(ad.getContext()) + "&" + bi.oM(str) + ("&uin=" + Cn + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + URLEncoder.encode(com.tencent.mm.kernel.a.CI(), ProtocolPackage.ServerEncoding) + "&signature=" + URLEncoder.encode(bi.fb(ad.getContext()), ProtocolPackage.ServerEncoding) + "&scene=" + (bi.oN(str) ? 0 : 1))) + "#/comment/4134";
                                Intent intent = new Intent();
                                intent.putExtra("showShare", false);
                                intent.putExtra("rawUrl", str2);
                                intent.putExtra("title", "意见反馈");
                                intent.putExtra("neverGetA8Key", true);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                                d.b(WelabAppInfoUI.this, "webview", ".ui.tools.WebViewUI", intent);
                            } catch (UnsupportedEncodingException e) {
                                x.e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", e.getMessage());
                            }
                        }
                    });
                }
                if (this.tWd.bWs()) {
                    this.tWl.setVisibility(0);
                    this.tWm.setVisibility(8);
                } else {
                    this.tWl.setVisibility(8);
                    this.tWm.setVisibility(0);
                }
                bWu();
                this.tWg.tWB = 0.5f;
                PN = com.tencent.mm.ap.a.a.PN();
                com.tencent.mm.plugin.welab.b.bWh();
                PN.a(com.tencent.mm.plugin.welab.b.b(this.tWd), this.tWg, com.tencent.mm.plugin.welab.b.bWh().trR);
            }
        }
        this.mBI.setVisibility(8);
        textView = this.ikn;
        com.tencent.mm.plugin.welab.b.bWh();
        textView.setText(com.tencent.mm.plugin.welab.b.a(this.tWd));
        this.ppv.setText(this.tWd.Ri("field_Introduce"));
        if (this.tWd.bWs()) {
            this.tWj.setVisibility(8);
        } else {
            this.tWj.setVisibility(0);
            this.tWj.setOnClickListener(/* anonymous class already generated */);
        }
        if (this.tWd.bWs()) {
            this.tWl.setVisibility(0);
            this.tWm.setVisibility(8);
        } else {
            this.tWl.setVisibility(8);
            this.tWm.setVisibility(0);
        }
        bWu();
        this.tWg.tWB = 0.5f;
        PN = com.tencent.mm.ap.a.a.PN();
        com.tencent.mm.plugin.welab.b.bWh();
        PN.a(com.tencent.mm.plugin.welab.b.b(this.tWd), this.tWg, com.tencent.mm.plugin.welab.b.bWh().trR);
    }

    private String bWt() {
        return "switch_" + this.tWd.field_LabsAppId;
    }

    private void bWu() {
        String Ri = this.tWd.Ri("field_ImgUrl_android");
        if (TextUtils.isEmpty(Ri)) {
            Ri = this.tWd.Ri("field_ImgUrl");
        }
        List Re = com.tencent.mm.plugin.welab.g.Re(Ri);
        Iterator it = Re.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty((String) it.next())) {
                it.remove();
            }
        }
        if (Re.isEmpty()) {
            this.tWh.setVisibility(8);
            return;
        }
        this.tWh.setVisibility(0);
        this.tWn.lqU = Re;
        this.tWn.UR.notifyChanged();
    }
}
