package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class i {
    static LinkedList<f> vBt = new LinkedList();
    private static boolean vBu = bi.PZ();

    public static void a(f fVar) {
        vBt.add(fVar);
    }

    public static void b(f fVar) {
        vBt.remove(fVar);
    }

    public static SpannableString a(TextView textView, Object obj) {
        return a(textView, 1, true, obj);
    }

    public static SpannableString a(TextView textView, int i, boolean z, Object obj) {
        if (textView == null) {
            x.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString("");
        }
        int textSize = (int) textView.getTextSize();
        o oVar = new o(textView.getContext());
        oVar.vCb = true;
        oVar.vBZ = true;
        oVar.vCg = true;
        oVar.vCi = true;
        oVar.vCk = 1;
        oVar.vCc = true;
        oVar.vCe = false;
        oVar.vCm = true;
        o j = oVar.j(textView);
        j.vCd = true;
        j.vCf = true;
        if (obj != null) {
            j.vCn = obj;
        }
        return j.a(textView.getText(), textSize, z);
    }

    public static SpannableString f(TextView textView, int i) {
        if (textView != null) {
            return a(textView.getContext(), textView, (int) textView.getTextSize(), true, i);
        }
        x.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
        return new SpannableString("");
    }

    public static SpannableString b(TextView textView, Object obj) {
        if (textView == null) {
            x.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString("");
        }
        int textSize = (int) textView.getTextSize();
        o oVar = new o(textView.getContext());
        oVar.vCb = true;
        oVar.vBZ = true;
        oVar.vCa = vBu;
        oVar.vCk = 1;
        oVar.vCc = true;
        oVar.vCe = false;
        oVar.vCm = true;
        o j = oVar.j(textView);
        j.vCn = obj;
        j.iNG = null;
        j.vCd = true;
        j.vCf = true;
        return j.a(textView.getText(), textSize, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, Object obj, String str) {
        o oVar = new o(context);
        oVar.vCb = true;
        oVar.vBZ = true;
        oVar.vCa = vBu;
        oVar.vCk = 1;
        oVar.vCc = true;
        oVar.vCe = false;
        oVar.vCm = true;
        oVar = oVar.j(null);
        oVar.vCn = obj;
        oVar.iNG = str;
        oVar.vCd = true;
        oVar.vCf = true;
        return oVar.a(charSequence, i, true);
    }

    private static SpannableString a(Context context, TextView textView, int i, boolean z, int i2) {
        o oVar = new o(context);
        oVar.vCb = true;
        oVar.vBZ = true;
        oVar.vCa = vBu;
        oVar.vCk = i2;
        oVar.vCc = true;
        oVar.vCe = false;
        oVar.vCm = true;
        oVar = oVar.j(textView);
        if (i2 == 1) {
            oVar.vCd = true;
            oVar.vCf = true;
        } else if (i2 == 2) {
            oVar.vCd = false;
            oVar.vCf = false;
        }
        return oVar.a(textView.getText(), i, z);
    }

    public static SpannableString c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, true);
    }

    public static SpannableString b(Context context, CharSequence charSequence, float f) {
        return a(context, charSequence, (int) f, true);
    }

    public static SpannableString d(Context context, CharSequence charSequence, float f) {
        return a(context, charSequence, (int) f, false);
    }

    public static SpannableString d(Context context, CharSequence charSequence, int i) {
        o oVar = new o(context);
        oVar.vCc = false;
        oVar.vCd = false;
        oVar.vBZ = false;
        oVar.vCe = false;
        oVar.vCk = i;
        oVar.vCb = false;
        oVar.vCm = false;
        CharSequence a = oVar.a(charSequence, 0, true);
        d(a);
        return a;
    }

    private static void d(Spannable spannable) {
        int i = 0;
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
        while (i < clickableSpanArr.length) {
            spannable.removeSpan(clickableSpanArr[i]);
            i++;
        }
    }

    public static SpannableString a(Context context, CharSequence charSequence) {
        return a(context, charSequence, 0, true);
    }

    private static SpannableString a(Context context, CharSequence charSequence, int i, boolean z) {
        o oVar = new o(context);
        oVar.vCc = false;
        oVar.vCd = false;
        oVar.vBZ = false;
        oVar.vCe = false;
        oVar.vCb = false;
        oVar.vCm = false;
        CharSequence a = oVar.a(charSequence, i, z);
        d(a);
        return a;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, int i2) {
        o oVar = new o(context);
        oVar.vCb = true;
        oVar.vBZ = true;
        oVar.vCa = vBu;
        oVar.vCk = i2;
        oVar.vCc = true;
        oVar.vCe = false;
        oVar.vCm = true;
        if (i2 == 1) {
            oVar.vCd = true;
            oVar.vCf = true;
        } else if (i2 == 2) {
            oVar.vCd = false;
            oVar.vCf = false;
        }
        return oVar.a(charSequence, i, true);
    }

    public static SpannableString e(Context context, CharSequence charSequence, int i) {
        o oVar = new o(context);
        oVar.vCb = true;
        oVar.vBZ = true;
        oVar.vCa = vBu;
        oVar.vCi = true;
        oVar.vCk = 1;
        oVar.vCc = true;
        oVar.vCe = false;
        oVar.vCm = true;
        oVar.vCn = null;
        oVar.vCd = true;
        oVar.vCf = true;
        return oVar.a(charSequence, i, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, String str, Object obj) {
        o oVar = new o(context);
        oVar.vCb = true;
        oVar.vBZ = true;
        oVar.vCa = vBu;
        oVar.vCi = true;
        oVar.vCk = 1;
        oVar.vCc = true;
        oVar.vCe = false;
        oVar.vCm = true;
        oVar.vCn = obj;
        oVar.iNG = str;
        oVar.vCd = true;
        oVar.vCf = true;
        return oVar.a(charSequence, i, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, Object obj) {
        o oVar = new o(context);
        oVar.vCb = true;
        oVar.vBZ = true;
        oVar.vCa = vBu;
        oVar.vCi = true;
        oVar.vCk = 1;
        oVar.vCc = true;
        oVar.vCe = false;
        oVar.vCm = true;
        oVar.vCn = obj;
        oVar.vCd = true;
        oVar.vCf = true;
        return oVar.a(charSequence, i, false);
    }

    public static SpannableString f(Context context, CharSequence charSequence, int i) {
        return b(context, charSequence, i, true);
    }

    public static SpannableString e(Context context, CharSequence charSequence, float f) {
        return b(context, charSequence, (int) f, false);
    }

    private static SpannableString b(Context context, CharSequence charSequence, int i, boolean z) {
        o oVar = new o(context);
        oVar.vCb = false;
        oVar.vBZ = true;
        oVar.vCg = true;
        oVar.vCh = z;
        oVar.vCi = true;
        oVar.vCk = 1;
        oVar.vCc = false;
        oVar.vCe = false;
        oVar.vCd = false;
        oVar.vCf = false;
        oVar.vCm = false;
        return oVar.a(charSequence, i, true);
    }

    public static String Tm(String str) {
        if (bi.oN(str)) {
            return str;
        }
        o oVar = new o(ad.getContext());
        oVar.vCb = false;
        oVar.vBZ = true;
        oVar.vCg = true;
        oVar.vCh = true;
        oVar.vCi = true;
        oVar.vCk = 1;
        oVar.vCc = false;
        oVar.vCe = false;
        oVar.vCd = false;
        oVar.vCf = false;
        oVar.vCj = false;
        oVar.vCm = false;
        return oVar.a(str, 0, false).toString();
    }

    public static void clearCache() {
        x.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
        o.clearCache();
    }

    public static SpannableString i(TextView textView) {
        if (textView != null) {
            return a(textView.getContext(), textView, (int) textView.getTextSize(), false, 1);
        }
        x.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
        return new SpannableString("");
    }
}
