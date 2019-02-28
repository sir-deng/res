package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.wcdb.database.SQLiteDatabase;

@a(19)
public final class AppBrand404PageUI extends DrawStatusBarActivity {

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String jPS = null;
        final /* synthetic */ String jkr;

        AnonymousClass1(String str, String str2) {
            this.jkr = str;
        }

        public final void run() {
            ad.getContext().startActivity(new Intent(ad.getContext(), AppBrand404PageUI.class).putExtra("key_wording", this.jkr).putExtra("key_icon_url", this.jPS).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
        }
    }

    public static void show(int i) {
        ah.y(new AnonymousClass1(ad.getContext().getString(i), null));
    }

    protected final int getLayoutId() {
        return h.iza;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, getStatusBarColor(), false);
        setMMTitle(j.iBq);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppBrand404PageUI.this.finish();
                return true;
            }
        });
        TextView textView = (TextView) findViewById(g.iwa);
        CharSequence stringExtra = getIntent().getStringExtra("key_wording");
        bi.oN(stringExtra);
        if (textView != null) {
            textView.setText(stringExtra);
        }
    }

    public final void finish() {
        super.finish();
    }

    protected final void onDestroy() {
        super.onDestroy();
    }
}
