package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass52;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.a;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppBrandSearchUI extends FTSSearchTabWebViewUI {
    private View jRw;
    private String jRx;
    private String jRy;
    private int scene;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jRy = getIntent().getStringExtra("key_session_id");
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        x.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", this.jRy);
        g.pWK.h(13929, this.jRy, "", Integer.valueOf(1), Integer.valueOf(this.scene));
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.jRy);
        intent.putExtra("ftsbizscene", this.scene);
        setResult(-1, intent);
    }

    protected final void initView() {
        super.initView();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(-1052684));
        cnG();
        Bb(WebView.NIGHT_MODE_COLOR);
    }

    protected final void alu() {
        super.alu();
        if (this.qhY != null) {
            this.qhY.findViewById(R.h.bId).setVisibility(8);
            ((ImageView) this.qhY.findViewById(R.h.bIb)).setImageResource(R.g.bAl);
            FTSEditTextView fTSEditTextView = (FTSEditTextView) this.qhY.findViewById(R.h.ckk);
            fTSEditTextView.jIs.setImageResource(R.k.dvX);
            ((ImageButton) fTSEditTextView.findViewById(R.h.bWi)).setImageResource(R.k.dvW);
            fTSEditTextView.yqL.setHintTextColor(1711276032);
            fTSEditTextView.yqL.setTextColor(WebView.NIGHT_MODE_COLOR);
            k.a(this);
        }
    }

    protected final int alo() {
        if (VERSION.SDK_INT >= 23 && (!h.zq() || !AppBrandNearbyWebViewUI.alp())) {
            ae.g(getWindow());
            return -1052684;
        } else if (VERSION.SDK_INT >= 21) {
            return n.iuA;
        } else {
            return super.alo();
        }
    }

    public void onDestroy() {
        if (this.scene == 3 || this.scene == 16) {
            g.pWK.h(13929, this.jRy, b.hli, Integer.valueOf(2), Integer.valueOf(this.scene));
        }
        super.onDestroy();
    }

    public final boolean als() {
        this.jRw.setVisibility(8);
        return super.als();
    }

    public final void a(String str, String str2, List<a.b> list, FTSEditTextView.b bVar) {
        if (!TextUtils.isEmpty(str2)) {
            this.jRw.setVisibility(8);
        }
        try {
            this.jAm.e(10001, null);
        } catch (RemoteException e) {
            x.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", e);
        }
        super.a(str, str2, list, bVar);
    }

    protected final void dealContentView(View view) {
        super.dealContentView(view);
        this.jRx = getIntent().getStringExtra("key_nearby_url");
        getIntent().getStringExtra("key_nearby_list_id");
        this.jRw = getLayoutInflater().inflate(R.i.das, (ViewGroup) view, false);
        View findViewById = this.jRw.findViewById(R.h.cyR);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!TextUtils.isEmpty(AppBrandSearchUI.this.jRx)) {
                    Intent intent = new Intent();
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", AppBrandSearchUI.this.jRx);
                    intent.putExtra("geta8key_scene", 41);
                    intent.putExtra("show_long_click_popup_menu", false);
                    d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
        if (TextUtils.isEmpty(this.jRx)) {
            findViewById.setVisibility(8);
            this.jRw.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            this.jRw.setVisibility(0);
        }
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.jRw);
            return;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (getWindow().hasFeature(9)) {
            View view2 = this.jRw;
            int paddingLeft = this.jRw.getPaddingLeft();
            Rect rect = new Rect();
            int bTm = bTm();
            View decorView = getWindow().getDecorView();
            decorView.getWindowVisibleDisplayFrame(rect);
            int height = decorView.getHeight();
            int[] iArr = new int[2];
            decorView.getLocationOnScreen(iArr);
            if (height == 0) {
                bTm += alt();
            }
            bTm = (height - rect.height() < 0 || iArr[1] <= 200) ? bTm + rect.top : bTm + (height - rect.height());
            view2.setPadding(paddingLeft, bTm + this.jRw.getPaddingTop(), this.jRw.getPaddingRight(), this.jRw.getPaddingBottom());
        }
        addContentView(this.jRw, layoutParams);
    }

    private int alt() {
        int i = 0;
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            return getResources().getDimensionPixelSize(bi.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Exception e) {
            return i;
        }
    }

    protected final void h(int i, Bundle bundle) {
        super.h(i, bundle);
        switch (i) {
            case 142:
                final String string = bundle.getString("fts_key_json_data");
                final int i2 = bundle.getInt("fts_key_is_cache_data", 0);
                final int i3 = bundle.getInt("fts_key_is_expired", 1);
                this.handler.post(new Runnable() {
                    public final void run() {
                        if (AppBrandSearchUI.this.tsa != null) {
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.d c = AppBrandSearchUI.this.tsa;
                            String str = string;
                            int i = i2;
                            int i2 = i3;
                            if (c.tNo) {
                                x.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
                                Map hashMap = new HashMap();
                                hashMap.put("json", str);
                                hashMap.put("isCacheData", Integer.valueOf(i));
                                hashMap.put("isExpired", Integer.valueOf(i2));
                                ah.y(new AnonymousClass52(i.a.a("onSearchGuideDataReady", hashMap, c.tNq, c.tNr)));
                                return;
                            }
                            x.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
                        }
                    }
                });
                return;
            default:
                return;
        }
    }
}
