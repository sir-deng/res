package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.ui.view.g;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class b implements ActivityLifecycleCallbacks {
    private int kVR = 0;

    public static Application ali() {
        return (Application) ad.getContext().getApplicationContext();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        if (this.kVR < 0) {
            if (activity == null || !(activity instanceof CardDetailUI)) {
                as.Dt().F(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！doUpdateOfflineDynamicCard!");
                        am.avx().a(q.EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND);
                    }
                });
            } else {
                CardDetailUI cardDetailUI = (CardDetailUI) activity;
                if (cardDetailUI.kWg != null) {
                    g gVar = cardDetailUI.kWg.kWE;
                    if (gVar != null && (gVar instanceof m)) {
                        x.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！is showing CardDetailUI,updateCodeView!");
                        cardDetailUI.kWg.kWE.d(c.CARDCODEREFRESHACTION_ENTERFOREGROUND);
                    }
                }
            }
        }
        this.kVR++;
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
        this.kVR--;
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }
}
