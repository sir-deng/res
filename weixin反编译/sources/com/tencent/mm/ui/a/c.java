package com.tencent.mm.ui.a;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings.Secure;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.a.a.AnonymousClass1;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(14)
public final class c extends AccessibilityDelegate {
    private boolean xVP = false;

    public c() {
        boolean z;
        a cow = a.xVN;
        AudioManager audioManager = (AudioManager) cow.tI.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (!cow.cov() || (Secure.getInt(cow.tI.getContentResolver(), "speak_password", 0) == 0 && !audioManager.isWiredHeadsetOn())) {
            z = false;
        } else {
            z = true;
        }
        this.xVP = z;
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return null;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return true;
    }

    public final void sendAccessibilityEvent(View view, int i) {
        if (!this.xVP || view == null) {
            return;
        }
        if (i == FileUtils.S_IWUSR || i == 1) {
            CharSequence text;
            if (view instanceof EditText) {
                EditText editText = (EditText) view;
                text = !bi.N(editText.getText()) ? editText.getText() : !bi.N(editText.getContentDescription()) ? editText.getContentDescription() : editText.getHint() != null ? editText.getHint() : null;
            } else {
                text = view instanceof TextView ? bi.N(view.getContentDescription()) ? ((TextView) view).getText() : view.getContentDescription() : view.getContentDescription();
            }
            x.d("MicroMsg.MMSecureAccessibilityDelegate", "speak content: %s", text);
            if (!bi.N(text)) {
                a cow = a.xVN;
                String charSequence = text.toString();
                if (cow.xVL == null) {
                    cow.xVL = new TextToSpeech(cow.tI, new AnonymousClass1(charSequence));
                } else {
                    cow.xVL.setLanguage(w.cfR() ? Locale.CHINESE : Locale.ENGLISH);
                    cow.xVL.speak(charSequence, 0, null);
                }
                Class cls = View.class;
                try {
                    Method method = cls.getMethod("clearAccessibilityFocus", new Class[0]);
                    method.setAccessible(true);
                    method.invoke(view, new Object[0]);
                    Method method2 = cls.getMethod("requestAccessibilityFocus", new Class[0]);
                    method2.setAccessible(true);
                    method2.invoke(view, new Object[0]);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Accessibility.AccessibilityHelper", e, "", new Object[0]);
                }
                if (cow.kJP != null) {
                    cow.kJP = (Vibrator) ad.getContext().getSystemService("vibrator");
                }
                if (cow.kJP != null) {
                    cow.kJP.vibrate(50);
                }
            }
        }
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
    }
}
