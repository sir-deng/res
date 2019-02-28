package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass56;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public class BaseEmojiStoreSearchWebViewUI extends WebViewUI implements b {
    String fEe;
    private p kKU;
    private boolean tIg;
    private boolean tIh = true;
    private int tIi;
    private int type;

    private class a extends h {
        private a() {
            super();
        }

        /* synthetic */ a(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI, byte b) {
            this();
        }

        public final void a(WebView webView, String str) {
            x.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", str);
            super.a(webView, str);
            BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
            BaseEmojiStoreSearchWebViewUI.this.kKU.aay(BaseEmojiStoreSearchWebViewUI.this.fEe);
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            super.b(webView, str, bitmap);
            BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
        }
    }

    protected final void alu() {
        super.alu();
        this.fEe = getIntent().getStringExtra("keyword");
        this.type = getIntent().getIntExtra(Columns.TYPE, 0);
        this.tIg = getIntent().getBooleanExtra("showkeyboard", false);
        this.tIi = getIntent().getIntExtra("sence", 0);
        this.pzt.setWebViewClient(new a());
        this.pzt.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                BaseEmojiStoreSearchWebViewUI.this.aWY();
                return false;
            }
        });
        this.kKU = new p();
        a(this.kKU);
        this.kKU.nC(false);
        this.kKU.zvw = this;
        showOptionMenu(false);
        if (this.tGC != null) {
            this.tGC.ky(true);
        }
        this.pzt.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                return true;
            }
        });
    }

    public final void XB() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.kKU != null) {
            this.kKU.a((FragmentActivity) this, menu);
            this.kKU.setHint(getString(R.l.eaq));
        }
        return true;
    }

    public final void XA() {
        finish();
    }

    public final void pd(String str) {
        if (this.tIh && bi.oN(str)) {
            this.tIh = false;
            if (this.tIg) {
                this.kKU.cyq();
                showVKB();
                return;
            }
            ah.h(new Runnable() {
                public final void run() {
                    BaseEmojiStoreSearchWebViewUI.this.kKU.clearFocus();
                    BaseEmojiStoreSearchWebViewUI.this.aWY();
                }
            }, 500);
        }
    }

    public final boolean pc(String str) {
        if (str != null) {
            str = str.trim();
        }
        this.fEe = str;
        if (!bi.oN(str)) {
            this.fEe = str;
            this.handler.post(new Runnable() {
                public final void run() {
                    if (BaseEmojiStoreSearchWebViewUI.this.tsa != null) {
                        BaseEmojiStoreSearchWebViewUI.this.tsa.bVf();
                    }
                }
            });
            Bundle bundle = new Bundle();
            bundle.putInt(Columns.TYPE, this.type);
            bundle.putString("nextPageBuffer", "");
            bundle.putString("keyword", this.fEe);
            bundle.putInt("webview_instance_id", hashCode());
            bundle.putLong("searchID", this.tsa.bVg());
            try {
                if (this.jAm != null) {
                    this.jAm.q(1, bundle);
                } else {
                    x.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", e, "doSearch", new Object[0]);
            }
        }
        aWY();
        String str2 = "";
        if (!bi.oN(str)) {
            str2 = str.replace(",", " ");
        }
        g.pWK.h(13054, Integer.valueOf(this.tIi), Integer.valueOf(1), str2);
        return false;
    }

    public final void XC() {
        this.kKU.cyq();
        showVKB();
    }

    public final void XD() {
    }

    protected void s(int i, Bundle bundle) {
        x.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", Integer.valueOf(i));
        switch (i) {
            case 80001:
                String string = bundle.getString("emoji_store_json_data");
                boolean z = bundle.getBoolean("emoji_store_new_query", true);
                String string2 = bundle.getString("emoji_store_page_buf");
                long j = bundle.getLong("emoji_store_search_id");
                d dVar = this.tsa;
                if (dVar.tNo) {
                    x.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
                    Map hashMap = new HashMap();
                    hashMap.put("json", string);
                    hashMap.put("newQuery", Boolean.valueOf(z));
                    hashMap.put("nextPageBuffer", string2);
                    x.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", Long.valueOf(j));
                    dVar.tNA = j;
                    x.i("MicroMsg.JsApiHandler", "event:%s", com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("getSearchEmotionDataCallBack", hashMap, dVar.tNq, dVar.tNr));
                    ah.y(new AnonymousClass56(string));
                    return;
                }
                x.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
                return;
            case 80002:
                this.tsa.bVf();
                return;
            default:
                super.s(i, bundle);
                return;
        }
    }

    protected final void bTt() {
        finish();
    }

    protected final int getLayoutId() {
        return R.i.dgp;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final boolean bTJ() {
        return true;
    }
}
