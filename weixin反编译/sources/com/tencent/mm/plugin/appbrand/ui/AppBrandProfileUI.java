package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.s;
import com.tencent.mm.y.u;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public final class AppBrandProfileUI extends DrawStatusBarActivity implements OnClickListener, com.tencent.mm.sdk.e.j.a {
    private String jPV;
    private t jPX;
    private long jQV = 0;
    private LinearLayout jQW;
    private TableLayout jQX;
    private ImageView jQY;
    private TextView jQZ;
    private TextView jRa;
    private TextView jRb;
    private View jRc;
    private View jRd;
    private TextView jRe;
    private a jRf;
    private WxaExposedParams jRg;
    private boolean jRh = false;
    private g jRi;

    private final class a extends RecyclerView.t implements OnClickListener {
        WxaBindBizInfoView jRp;
        String mAppId;

        static /* synthetic */ void a(a aVar, List list) {
            WxaBindBizInfoView wxaBindBizInfoView = aVar.jRp;
            wxaBindBizInfoView.kaZ.clear();
            if (!(list == null || list.isEmpty())) {
                wxaBindBizInfoView.kaZ.addAll(list);
            }
            wxaBindBizInfoView.dr(true);
        }

        a(View view) {
            super(view);
            this.jRp = (WxaBindBizInfoView) view.findViewById(q.g.iyB);
            view.setOnClickListener(this);
        }

        public final void onClick(View view) {
            Collection collection = this.jRp.kaZ;
            if (collection == null || collection.isEmpty()) {
                x.i("MicroMsg.AppBrandProfileUI", "deal onBindBizInfo click failed, bindBizInfoList is null or nil.");
            } else if (collection.size() == 1) {
                d.b(this.VU.getContext(), "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", ((WxaEntryInfo) collection.get(0)).username).putExtra("key_start_biz_profile_from_app_brand_profile", true).putExtra("force_get_contact", true));
                AppBrandProfileUI.this.bR(3, 1);
            } else {
                Intent intent = new Intent(AppBrandProfileUI.this.mController.xRr, WxaBindBizInfoUI.class);
                intent.putExtra("app_id", this.mAppId);
                intent.putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList(collection));
                AppBrandProfileUI.this.mController.xRr.startActivity(intent);
            }
        }
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI) {
        if (appBrandProfileUI.jRi == null || !appBrandProfileUI.jRi.isShowing()) {
            appBrandProfileUI.jRi = new g(appBrandProfileUI, g.zCt, false);
            appBrandProfileUI.jRi.rQF = new c() {
                public final void a(n nVar) {
                    nVar.clear();
                    nVar.eT(2, j.iAX);
                    nVar.eT(1, j.iBs);
                }
            };
            appBrandProfileUI.jRi.rQG = new p.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            if (AppBrandProfileUI.this.jRg == null) {
                                x.e("MicroMsg.AppBrandProfileUI", "wxaExposedParams is null");
                                return;
                            }
                            Intent intent = new Intent();
                            String a = l.a(AppBrandProfileUI.this.jRg);
                            x.i("MicroMsg.AppBrandProfileUI", "wxaExposedParams:%s", AppBrandProfileUI.this.jRg.toString());
                            x.v("MicroMsg.AppBrandProfileUI", "KRawUrl " + a);
                            intent.putExtra("rawUrl", a);
                            intent.putExtra("forceHideShare", true);
                            d.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", intent);
                            AppBrandProfileUI.this.bR(7, 1);
                            if (AppBrandProfileUI.this.jRg.fqZ == 3) {
                                AppBrandOnOpReportStartEvent.tb(AppBrandProfileUI.this.jPX.appId);
                                return;
                            }
                            return;
                        case 2:
                            d.b(AppBrandProfileUI.this, "appbrand", ".ui.AppBrandAuthorizeUI", new Intent(AppBrandProfileUI.this, AppBrandAuthorizeUI.class).putExtra("key_username", AppBrandProfileUI.this.jPV));
                            AppBrandProfileUI.this.bR(10, 1);
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        appBrandProfileUI.jRi.bUX();
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI, t tVar, long j) {
        boolean z = false;
        if (!appBrandProfileUI.isFinishing() && !appBrandProfileUI.xQV && tVar != null) {
            if ((appBrandProfileUI.jPX == null || !bi.oM(appBrandProfileUI.jPX.iSZ).equals(tVar.iSZ)) && appBrandProfileUI.jQY != null) {
                b.Jp().a(appBrandProfileUI.jQY, tVar.iSZ, com.tencent.mm.modelappbrand.a.a.Jo(), new f());
            }
            if ((appBrandProfileUI.jPX == null || !bi.oM(appBrandProfileUI.jPX.fqG).equals(tVar.fqG)) && appBrandProfileUI.jQZ != null) {
                appBrandProfileUI.jQZ.setText(tVar.fqG);
                appBrandProfileUI.setMMTitle(tVar.fqG);
            }
            if ((appBrandProfileUI.jPX == null || !bi.oM(appBrandProfileUI.jPX.signature).equals(tVar.signature)) && appBrandProfileUI.jRa != null) {
                if (bi.oN(tVar.signature)) {
                    appBrandProfileUI.jRa.setText("");
                    appBrandProfileUI.jRa.setVisibility(8);
                } else {
                    appBrandProfileUI.jRa.setText(tVar.signature);
                    appBrandProfileUI.jRa.setVisibility(0);
                }
            }
            if ((appBrandProfileUI.jPX == null || !bi.oM(tVar.acw()).equals(appBrandProfileUI.jPX.acw())) && appBrandProfileUI.jRb != null) {
                appBrandProfileUI.jRb.setText(tVar.acw());
                appBrandProfileUI.jRc.setVisibility(0);
            }
            if (appBrandProfileUI.jRf != null) {
                List list = tVar.iSy;
                if (bi.cC(list)) {
                    appBrandProfileUI.jRf.VU.setVisibility(8);
                } else {
                    a.a(appBrandProfileUI.jRf, list);
                    appBrandProfileUI.jRf.VU.setVisibility(0);
                }
                appBrandProfileUI.jRf.mAppId = tVar.appId;
                if (j != appBrandProfileUI.jQV && (2 & j) > 0) {
                    appBrandProfileUI.jRf.VU.setVisibility(8);
                }
            }
            if ((appBrandProfileUI.jPX == null || !bi.oM(tVar.hre).equals(appBrandProfileUI.jPX.hre)) && appBrandProfileUI.jRe != null) {
                appBrandProfileUI.jRe.setText(tVar.hre);
            }
            if (appBrandProfileUI.jPX == null || appBrandProfileUI.jPX.iSR != tVar.iSR) {
                if (tVar.iSR != 0) {
                    z = true;
                }
                appBrandProfileUI.dk(z);
            }
            appBrandProfileUI.jPX = tVar;
            appBrandProfileUI.jQV = j;
        }
    }

    public static void a(Context context, String str, String str2, WxaExposedParams wxaExposedParams) {
        if (!bi.oN(str)) {
            if (context == null) {
                context = ad.getContext();
            }
            Intent putExtra = new Intent(context, AppBrandProfileUI.class).putExtra("key_username", str).putExtra("key_from_scene", 3).putExtra("key_scene_note", str2).putExtra("key_can_swipe_back", true).putExtra("key_scene_exposed_params", wxaExposedParams);
            if (wxaExposedParams != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("stat_scene", 6);
                bundle.putString("stat_app_id", wxaExposedParams.appId);
                bundle.putString("stat_url", wxaExposedParams.fDk);
                putExtra.putExtra("_stat_obj", bundle);
            }
            if (!(context instanceof Activity)) {
                putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            context.startActivity(putExtra);
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (!bi.oN(this.jPV)) {
            com.tencent.mm.plugin.appbrand.config.q.acp().j(this);
        }
        String stringExtra = getIntent().getStringExtra("key_username");
        this.jPV = stringExtra;
        if (bi.oN(stringExtra)) {
            finish();
        } else {
            dl(true);
        }
    }

    public final void onBackPressed() {
        if (VERSION.SDK_INT >= 21) {
            super.finishAfterTransition();
        } else {
            super.finish();
        }
        bR(6, 1);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_username");
        this.jPV = stringExtra;
        if (bi.oN(stringExtra)) {
            finish();
            return;
        }
        com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, -1, true);
        getIntent().setExtrasClassLoader(getClassLoader());
        this.jRg = (WxaExposedParams) getIntent().getParcelableExtra("key_scene_exposed_params");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppBrandProfileUI.this.onBackPressed();
                return true;
            }
        }, q.f.ivE);
        addIconOptionMenu(0, j.hai, i.iAG, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppBrandProfileUI.a(AppBrandProfileUI.this);
                return true;
            }
        });
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(-1));
        cnG();
        LayoutInflater from = LayoutInflater.from(this);
        View inflate = from.inflate(h.izz, this.jQW, true);
        View inflate2 = from.inflate(h.izy, this.jQW, true);
        this.jQX = (TableLayout) inflate.findViewById(q.g.iyL);
        a(this.jQX);
        this.jQY = (ImageView) inflate.findViewById(q.g.cDT);
        this.jQZ = (TextView) inflate.findViewById(q.g.iyH);
        this.jRa = (TextView) inflate.findViewById(q.g.iyD);
        this.jRb = (TextView) inflate.findViewById(q.g.iyJ);
        this.jRc = inflate.findViewById(q.g.iyI);
        this.jRf = new a(inflate.findViewById(q.g.iyC));
        this.jRd = inflate.findViewById(q.g.iyF);
        this.jRe = (TextView) this.jRd.findViewById(q.g.iyG);
        dk(true);
        inflate.setClickable(false);
        inflate.setLongClickable(false);
        inflate2.setClickable(false);
        inflate2.setLongClickable(false);
        View findViewById = inflate2.findViewById(q.g.iyE);
        inflate = inflate2.findViewById(q.g.iyK);
        findViewById.setOnClickListener(this);
        inflate.setOnClickListener(this);
        dl(true);
    }

    protected final void dealContentView(View view) {
        super.dealContentView(view);
        View scrollView = new ScrollView(this);
        scrollView.setBackgroundResource(q.d.iuV);
        this.jQW = new LinearLayout(this);
        this.jQW.setOrientation(1);
        scrollView.addView(this.jQW, new LayoutParams(-1, -2));
        ((FrameLayout) view).addView(scrollView);
    }

    protected final void onResume() {
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().mEnable = getIntent().getBooleanExtra("key_can_swipe_back", true);
        }
    }

    protected final void initActivityCloseAnimation() {
        if (!this.jRh) {
            super.initActivityCloseAnimation();
        }
    }

    private void dk(boolean z) {
        if (this.jRd != null) {
            if (z) {
                this.jRd.setVisibility(8);
                return;
            }
            this.jRd.setVisibility(0);
            this.jRd.setOnClickListener(this);
        }
    }

    private void bR(int i, int i2) {
        b(i, i2, bi.Wx());
    }

    private void b(int i, int i2, long j) {
        String str = this.jPX == null ? null : this.jPX.appId;
        if (!bi.oN(str)) {
            int intExtra = getIntent().getIntExtra("key_from_scene", 3);
            String oM = bi.oM(getIntent().getStringExtra("key_scene_note"));
            int i3 = 0;
            WxaAttributes g = e.Zs().g(str, "appInfo", "brandIconURL", "nickname");
            if (g != null) {
                i3 = g.acq().hqv;
            }
            i3 += 1000;
            x.d("MicroMsg.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s", Integer.valueOf(13919), str, Integer.valueOf(intExtra), oM, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            com.tencent.mm.plugin.report.service.g.pWK.h(13919, str, Integer.valueOf(intExtra), oM, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3));
        }
    }

    protected final void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.appbrand.config.q.acp().j(this);
    }

    public final void onClick(final View view) {
        if (view.getId() == q.g.iyF) {
            if (this.jPX != null && !bi.oN(this.jPX.appId)) {
                d.b(this.mController.xRr, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", l.pJ(this.jPX.appId)).putExtra("forceHideShare", true));
                bR(2, 1);
            }
        } else if (view.getId() == q.g.iyE) {
            if (this.jPX != null) {
                Bundle bundleExtra = getIntent().getBundleExtra("_stat_obj");
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                appBrandStatObject.fJn = com.tencent.mm.plugin.appbrand.report.c.f(appBrandStatObject.scene, bundleExtra);
                appBrandStatObject.fJo = com.tencent.mm.plugin.appbrand.report.c.g(appBrandStatObject.scene, bundleExtra);
                com.tencent.mm.plugin.appbrand.launching.precondition.g.jEI.a(this, this.jPX.username, null, null, 0, -1, appBrandStatObject, null, null);
                bR(4, 1);
                if (appBrandStatObject.fJn == 6) {
                    this.jRh = true;
                    finish();
                }
            }
        } else if (view.getId() == q.g.iyK) {
            final t ri = com.tencent.mm.plugin.appbrand.config.q.ri(this.jPV);
            if (ri == null) {
                x.w("MicroMsg.AppBrandProfileUI", "attrs is null.");
                return;
            }
            Serializable hashMap = new HashMap();
            hashMap.put("desc", "");
            hashMap.put(Columns.TYPE, Integer.valueOf(1));
            hashMap.put("title", ri.fqG);
            hashMap.put("img_url", ri.iSZ);
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("mutil_select_is_ret", true);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("scene_from", 3);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            d.a((MMActivity) view.getContext(), ".ui.transmit.SelectConversationUI", intent, 1, new com.tencent.mm.ui.MMActivity.a() {
                public final void b(int i, int i2, Intent intent) {
                    if (i != 1) {
                        AppBrandProfileUI.this.bR(8, 2);
                    } else if (i2 == -1) {
                        String str;
                        if (intent == null) {
                            str = null;
                        } else {
                            str = intent.getStringExtra("Select_Conv_User");
                        }
                        if (str == null || str.length() == 0) {
                            x.i("MicroMsg.AppBrandProfileUI", "mmOnActivityResult fail, toUser is null");
                            return;
                        }
                        x.i("MicroMsg.AppBrandProfileUI", "result success toUser : %s ", str);
                        String stringExtra = intent.getStringExtra("custom_send_text");
                        String str2 = ri.appId;
                        u.GQ().t(u.hC("wxapp_" + str2), true).o("prePublishId", "wxapp_" + str2);
                        com.tencent.mm.x.g.a aVar = new com.tencent.mm.x.g.a();
                        aVar.title = ri.fqG;
                        aVar.type = 33;
                        aVar.hfi = AppBrandProfileUI.this.jPV;
                        aVar.hfj = str2;
                        aVar.hfk = 1;
                        aVar.fHA = "wxapp_" + str2;
                        aVar.thumburl = ri.iSZ;
                        aVar.url = l.pK(str2);
                        aVar.fHu = AppBrandProfileUI.this.jPV;
                        aVar.fHv = ri.fqG;
                        for (String str3 : bi.F(str.split(","))) {
                            int i3;
                            ((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.compat.a.a.class)).a(aVar, str2, ri.fqG, str3, null);
                            if (!bi.oN(stringExtra)) {
                                com.tencent.mm.sdk.b.b otVar = new ot();
                                otVar.fHD.fHE = str3;
                                otVar.fHD.content = stringExtra;
                                otVar.fHD.type = s.hs(str3);
                                otVar.fHD.flags = 0;
                                com.tencent.mm.sdk.b.a.xmy.m(otVar);
                            }
                            if (str3.endsWith("@chatroom")) {
                                i3 = 9;
                            } else {
                                i3 = 8;
                            }
                            AppBrandProfileUI.this.b(i3, 1, bi.Wx());
                        }
                        com.tencent.mm.ui.base.h.bu(view.getContext(), view.getContext().getResources().getString(j.dGR));
                    }
                }
            });
        }
    }

    private void dl(final boolean z) {
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                final t ri = com.tencent.mm.plugin.appbrand.config.q.ri(AppBrandProfileUI.this.jPV);
                final long rh = com.tencent.mm.plugin.appbrand.config.q.rh(AppBrandProfileUI.this.jPV);
                ah.y(new Runnable() {
                    public final void run() {
                        AppBrandProfileUI.a(AppBrandProfileUI.this, ri, rh);
                        if (z && !AppBrandProfileUI.this.isFinishing() && !AppBrandProfileUI.this.xQV) {
                            com.tencent.mm.plugin.appbrand.config.q.acp().a(AppBrandProfileUI.this, com.tencent.mm.plugin.appbrand.r.c.Dt().oFY.getLooper());
                        }
                    }
                });
                if (z) {
                    r.ru(AppBrandProfileUI.this.jPV);
                    AppBrandProfileUI.this.bR(1, 1);
                }
            }
        }, "AppBrandProfile");
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (lVar.jcn == 3 && (lVar.obj instanceof String) && !bi.oN(this.jPV) && this.jPV.equals((String) lVar.obj)) {
            dl(false);
        }
    }

    private void a(TableLayout tableLayout) {
        if (tableLayout != null) {
            int i = getResources().getDisplayMetrics().widthPixels;
            int childCount = tableLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = tableLayout.getChildAt(i2);
                if (childAt instanceof TableRow) {
                    TableRow tableRow = (TableRow) childAt;
                    if (tableRow.getChildCount() > 1) {
                        View childAt2 = tableRow.getChildAt(0);
                        if (childAt2 != null && (childAt2 instanceof TextView)) {
                            ((TextView) childAt2).setMaxWidth((i / 2) - tableRow.getPaddingLeft());
                        }
                    }
                }
            }
        }
    }
}
