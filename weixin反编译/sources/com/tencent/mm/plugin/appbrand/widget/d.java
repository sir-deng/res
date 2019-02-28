package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.f.a.if;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class d implements com.tencent.mm.plugin.appbrand.widget.recentview.d {
    public final AppBrandRecentView y(Context context, int i) {
        return a(context, i, null);
    }

    public final AppBrandRecentView a(Context context, int i, a aVar) {
        AppBrandRecentView cVar;
        LayoutParams layoutParams;
        if (i == b.klu) {
            cVar = new c(context);
            cVar.kkP = aVar;
            layoutParams = new FrameLayout.LayoutParams(-1, (int) context.getResources().getDimension(k.a.kaP));
            cVar.setPadding(0, (int) context.getResources().getDimension(k.a.kaQ), 0, 0);
            cVar.setLayoutParams(layoutParams);
            return cVar;
        } else if (i != b.klt) {
            return null;
        } else {
            cVar = new MenuAppBrandRecentView(context);
            cVar.kkP = aVar;
            layoutParams = new FrameLayout.LayoutParams(-1, (int) context.getResources().getDimension(k.a.kaP));
            cVar.setPadding(0, (int) context.getResources().getDimension(k.a.kaQ), 0, 0);
            cVar.setLayoutParams(layoutParams);
            return cVar;
        }
    }

    public final void ck(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.ui.LauncherUI").addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864).addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        intent.putExtra("isShowHeaderWithAnim", true);
        intent.putExtra("isShowHeader", true);
        intent.putExtra("isScrollFirst", true);
        context.startActivity(intent);
    }

    public final void amP() {
        x.i("MicroMsg.AppBrandRecentViewService", "[hideAppBrandRecentView] delay:%s type:%s", Integer.valueOf(300), Integer.valueOf(8));
        if (((h) g.Dn().CU()).DZ()) {
            com.tencent.mm.sdk.b.b ifVar = new if();
            ifVar.fzx.delay = 300;
            ifVar.fzx.type = 8;
            com.tencent.mm.sdk.b.a.xmy.m(ifVar);
        }
    }

    public final com.tencent.mm.plugin.appbrand.widget.recentview.b amQ() {
        return new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    }
}
