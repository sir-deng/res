package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.by.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends l {
    public r(Context context, l lVar, ViewGroup viewGroup) {
        super(context, lVar, viewGroup);
    }

    protected final void d(Button button) {
        final l bxV = bxV();
        if (g.m(this.context, bxV.rmk)) {
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    r.this.bxU();
                    f aZ = g.aZ(bxV.rmk, true);
                    if (aZ == null || TextUtils.isEmpty(aZ.field_packageName) || !r.this.r(view.getContext(), aZ.field_packageName, g.a(view.getContext(), aZ, null))) {
                        r.this.bxW();
                    }
                }
            });
        } else {
            super.d(button);
        }
    }

    public final boolean r(Context context, String str, final String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            final Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            if (!(context instanceof Activity)) {
                context = this.context;
            }
            a.post(new Runnable() {
                public final void run() {
                    g.a(context, launchIntentForPackage, str2);
                }
            });
            return true;
        } catch (Throwable e) {
            x.e("AdLandingPageOpenAppBtnComp", bi.i(e));
            return false;
        }
    }
}
