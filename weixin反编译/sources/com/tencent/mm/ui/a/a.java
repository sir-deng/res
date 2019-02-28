package com.tencent.mm.ui.a;

import android.content.Context;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.v.a.i;
import java.util.Locale;

public final class a {
    private AccessibilityManager ju;
    Vibrator kJP;
    public Context tI;
    TextToSpeech xVL = null;

    /* renamed from: com.tencent.mm.ui.a.a$1 */
    class AnonymousClass1 implements OnInitListener {
        final /* synthetic */ String hON;

        AnonymousClass1(String str) {
            this.hON = str;
        }

        public final void onInit(int i) {
            if (a.this.xVL != null) {
                a.this.xVL.setLanguage(w.cfR() ? Locale.CHINESE : Locale.ENGLISH);
                a.this.xVL.speak(this.hON, 0, null);
            }
        }
    }

    private static class a {
        private static final a xVN = new a(ad.getContext());
    }

    public a(Context context) {
        this.tI = context;
        this.ju = (AccessibilityManager) this.tI.getSystemService("accessibility");
    }

    public final boolean cov() {
        return this.ju.isEnabled() && this.ju.isTouchExplorationEnabled();
    }

    public final void a(View view, String str, int i, String str2, String str3) {
        if (cov() && this.tI != null && view != null && str != null && str2 != null && str3 != null) {
            b bVar = new b();
            bVar.YZ(str);
            if (i > 0) {
                bVar.YZ(this.tI.getResources().getQuantityString(i.gZV, 1, new Object[]{Integer.valueOf(i)}));
            }
            bVar.YZ(str2).YZ(str3);
            bVar.dg(view);
        }
    }

    public final void H(View view, int i) {
        if (cov() && this.tI != null && view != null) {
            int max = Math.max(i, 1);
            b bVar = new b();
            bVar.YZ(this.tI.getResources().getQuantityString(i.gZU, max, new Object[]{Integer.valueOf(max)}));
            bVar.dg(view);
        }
    }
}
