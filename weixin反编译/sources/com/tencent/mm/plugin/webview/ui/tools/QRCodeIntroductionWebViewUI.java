package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

public class QRCodeIntroductionWebViewUI extends WebViewUI {
    static /* synthetic */ void a(QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI) {
        Context context = qRCodeIntroductionWebViewUI;
        h.a(context, "", new String[]{qRCodeIntroductionWebViewUI.getString(R.l.eQm), qRCodeIntroductionWebViewUI.getString(R.l.eBH)}, "", false, new c() {
            public final void jo(int i) {
                switch (i) {
                    case 0:
                        QRCodeIntroductionWebViewUI.this.tsa.bVe();
                        return;
                    case 1:
                        QRCodeIntroductionWebViewUI.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(QRCodeIntroductionWebViewUI.this.bTy())));
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                QRCodeIntroductionWebViewUI.a(QRCodeIntroductionWebViewUI.this);
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                QRCodeIntroductionWebViewUI.this.finish();
                return true;
            }
        });
    }
}
