package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.p;

public class MMWebViewWithJsApi extends MMWebView {
    private e tQT;
    public boolean tQU;

    public static class a {
        public static MMWebViewWithJsApi dT(Context context) {
            MMWebView.gf(context);
            MMWebViewWithJsApi mMWebViewWithJsApi = new MMWebViewWithJsApi(context);
            mMWebViewWithJsApi.gIz = true;
            return mMWebViewWithJsApi;
        }
    }

    public MMWebViewWithJsApi(Context context) {
        this(context, null);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tQU = true;
        czM();
        getSettings().setJavaScriptEnabled(true);
        getSettings().cJr();
        setWebChromeClient(new d(this));
        setWebViewClient(new e(this));
        String userAgentString = getSettings().getUserAgentString();
        if (!s.Tv(userAgentString)) {
            getSettings().setUserAgentString(s.aL(getContext(), userAgentString));
        }
    }

    public void setWebViewClient(p pVar) {
        super.setWebViewClient(pVar);
        if (pVar instanceof e) {
            this.tQT = (e) pVar;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.tQT != null && this.tQU) {
            this.tQT.cleanup();
        }
    }

    public void loadData(String str, String str2, String str3) {
        if (this.tQT != null) {
            this.tQT.tQH = true;
        }
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.tQT != null) {
            this.tQT.tQH = true;
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }
}
