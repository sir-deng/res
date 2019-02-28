package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.webview.ui.tools.widget.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.xweb.WebView;

public final class h extends a {
    public h(Context context, s sVar, ViewGroup viewGroup) {
        super(context, sVar, viewGroup);
    }

    protected final void bxK() {
        if (((x) bxF()) != null) {
            String str;
            WebView webView = (WebView) getView();
            x xVar = (x) bxF();
            if (TextUtils.isEmpty(xVar.url) || TextUtils.isEmpty(xVar.rfQ)) {
                str = xVar.url;
            } else {
                String uin = AdLandingPagesProxy.getInstance().getUin();
                String m = ac.m(xVar.url, "uxinfo=" + xVar.rfQ, "uin=" + uin);
                if (xVar.fqh == 1) {
                    str = AdLandingPagesProxy.getInstance().getAdVoteInfo(xVar.url, xVar.rfQ, uin);
                    if (!bi.oN(str)) {
                        str = m + "&" + str;
                    }
                }
                str = m;
            }
            webView.loadUrl(str);
        }
    }

    protected final View bxL() {
        View co = a.tQy.co(this.context);
        co.getSettings().cJm();
        co.getSettings().cJq();
        co.getSettings().cJp();
        co.setWebViewClient(com.tencent.mm.plugin.webview.ui.tools.widget.a.a.tQx.a(co, new b() {
            public final boolean n(int i, Bundle bundle) {
                switch (i) {
                    case 150:
                        x xVar = (x) h.this.bxF();
                        AdLandingPagesProxy.getInstance().saveAdVoteInfo(xVar.url, xVar.rfQ, xVar.uin, bundle.getInt("sns_landing_pages_ad_vote_index"), 0);
                        break;
                }
                return false;
            }
        }));
        return co;
    }

    public final void bxq() {
        super.bxq();
        WebView webView = (WebView) getView();
        if (!(webView == null || webView.getParent() == null)) {
            ((ViewGroup) webView.getParent()).removeView(webView);
            webView.setTag(null);
            webView.destroy();
        }
        this.contentView = null;
    }
}
