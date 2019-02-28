package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.a.d;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class WelabMainUI extends MMActivity {
    private boolean tWf = false;
    private LinearLayout tWr;
    private LinearLayout tWs;
    private LinearLayout tWt;
    private LinearLayout tWu;
    private View tWv;
    private View tWw;
    private List<String> tWx;
    private Comparator<a> tWy = new Comparator<a>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar == aVar2) {
                return 0;
            }
            if (aVar != null) {
                if (aVar2 == null) {
                    return 1;
                }
                if (aVar.field_Pos == aVar2.field_Pos) {
                    int Wo = bi.Wo(aVar.field_expId);
                    int Wo2 = bi.Wo(aVar2.field_expId);
                    if (Wo != Wo2) {
                        return Wo2 > Wo ? 1 : -1;
                    } else {
                        return 0;
                    }
                } else if (aVar.field_Pos > aVar2.field_Pos) {
                    return 1;
                }
            }
            return -1;
        }
    };
    private OnClickListener tWz = new OnClickListener() {
        public final void onClick(View view) {
            Object tag = view.getTag();
            if (tag instanceof a) {
                a aVar = (a) tag;
                Intent intent = new Intent();
                intent.putExtra("para_appid", aVar.field_LabsAppId);
                intent.putExtra("para_from_with_red_point", b.bWw().e(aVar) ? 1 : 0);
                intent.setClass(WelabMainUI.this, WelabAppInfoUI.class);
                WelabMainUI.this.startActivity(intent);
                b bWw = b.bWw();
                String str = aVar.field_LabsAppId;
                bWw.tWa.put(str, Integer.valueOf(1));
                bWw.tag += "&" + str + "=1";
                g.Dq().Db().a(w.a.USERINFO_WELAB_REDPOINT_STRING, bWw.tag);
                b.bWx();
                x.i("MicroMsg.WelabMainUI", "click " + aVar);
            }
        }
    };

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        if (getIntent() != null) {
            if (getIntent().getIntExtra("para_from_with_red_point", 0) == 1) {
                z = true;
            }
            this.tWf = z;
            this.tWx = getIntent().getStringArrayListExtra("key_exclude_apps");
        }
        initView();
        b.bWw();
        ad.cgg().edit().putBoolean("key_has_enter_welab", true).commit();
        b.bWx();
        e.o("", 1, this.tWf);
    }

    protected final int getLayoutId() {
        return c.tVO;
    }

    protected final void initView() {
        setMMTitle(d.tVR);
        int i = com.tencent.mm.plugin.welab.a.a.white;
        p pVar = this.mController;
        if (pVar.xRx != null) {
            pVar.xRx.setBackgroundColor(i);
        }
        cnG();
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.tVw));
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.tVw));
        }
        this.tWr = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.tVD);
        this.tWt = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.tVE);
        this.tWs = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.tVG);
        this.tWu = (LinearLayout) findViewById(com.tencent.mm.plugin.welab.a.b.tVH);
        this.tWv = findViewById(com.tencent.mm.plugin.welab.a.b.eBj);
        this.tWw = findViewById(com.tencent.mm.plugin.welab.a.b.tVC);
        this.tWv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title", view.getResources().getString(d.tVT));
                intent.putExtra("rawUrl", WelabMainUI.this.mController.xRr.getString(d.tVP, new Object[]{com.tencent.mm.sdk.platformtools.w.cfV(), Integer.valueOf(com.tencent.mm.protocal.d.vHl)}));
                intent.putExtra("showShare", false);
                com.tencent.mm.bl.d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WelabMainUI.this.aWY();
                WelabMainUI.this.finish();
                return true;
            }
        });
    }

    public void onResume() {
        super.onResume();
        this.tWt.removeAllViews();
        this.tWu.removeAllViews();
        List<a> bWi = com.tencent.mm.plugin.welab.b.bWh().bWi();
        if (bWi == null || bWi.isEmpty()) {
            this.tWr.setVisibility(8);
        } else {
            a aVar;
            Iterator it = bWi.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (!bi.oN(aVar.field_LabsAppId) && this.tWx.contains(aVar.field_LabsAppId)) {
                    it.remove();
                }
            }
            if (bWi.isEmpty()) {
                this.tWr.setVisibility(8);
            } else {
                this.tWr.setVisibility(0);
                Collections.sort(bWi, this.tWy);
                for (a aVar2 : bWi) {
                    a(aVar2, this.tWt);
                }
                x.d("MicroMsg.WelabMainUI", "get online app count " + this.tWt.getChildCount());
            }
        }
        bWv();
        if (this.tWr.getVisibility() == 0 || this.tWs.getVisibility() == 0) {
            this.tWw.setVisibility(8);
        } else {
            this.tWw.setVisibility(0);
        }
    }

    public void onPause() {
        super.onPause();
    }

    private void bWv() {
        a aVar;
        List<a> bWr = com.tencent.mm.plugin.welab.b.bWh().tVV.bWr();
        Iterator it = bWr.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if ((System.currentTimeMillis() / 1000) - aVar.field_endtime >= 2592000 || "labs1de6f3".equals(aVar.field_LabsAppId)) {
                it.remove();
                com.tencent.mm.plugin.welab.b.bWh().tVV.a((com.tencent.mm.sdk.e.c) aVar, new String[0]);
            } else if (aVar.bPW() && aVar.field_Switch != 3) {
                aVar.field_Switch = 3;
                com.tencent.mm.plugin.welab.b.bWh().tVV.c(aVar, new String[0]);
            } else if (aVar.field_Switch != 3) {
                it.remove();
            }
        }
        if (bWr.isEmpty()) {
            this.tWs.setVisibility(8);
            return;
        }
        this.tWs.setVisibility(0);
        Collections.sort(bWr, this.tWy);
        for (a aVar2 : bWr) {
            a(aVar2, this.tWu);
        }
        x.d("MicroMsg.WelabMainUI", "get online app count " + this.tWu.getChildCount());
    }

    private void a(a aVar, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(c.tVM, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.tVK);
        ImageView imageView2 = (ImageView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.tVx);
        TextView textView = (TextView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.title);
        TextView textView2 = (TextView) linearLayout2.findViewById(com.tencent.mm.plugin.welab.a.b.summary);
        if (b.bWw().e(aVar)) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        com.tencent.mm.ap.a.a.PN().a(aVar.Ri("field_ThumbUrl"), imageView2, com.tencent.mm.plugin.welab.b.bWh().trR);
        com.tencent.mm.plugin.welab.b.bWh();
        textView.setText(com.tencent.mm.plugin.welab.b.a(aVar));
        textView2.setText(aVar.Ri("field_Desc"));
        linearLayout2.setTag(aVar);
        linearLayout2.setOnClickListener(this.tWz);
        linearLayout.addView(linearLayout2);
    }
}
