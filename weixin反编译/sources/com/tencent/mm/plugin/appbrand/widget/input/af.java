package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.lang.reflect.Method;

public enum af {
    ;
    
    static final Class kfw = null;

    public enum a {
        private static final /* synthetic */ a[] kfy = null;

        static {
            kfy = new a[0];
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) kfy.clone();
        }

        public static void a(Activity activity, View view) {
            if (anQ() && activity.getResources().getConfiguration().orientation != 2) {
                activity.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                activity.getWindow().addFlags(2048);
                view.setPadding(0, e.ec(activity), 0, 0);
            }
        }

        private static boolean anQ() {
            try {
                return ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
            } catch (Exception e) {
                if (Build.DEVICE.equals("mx2")) {
                    return true;
                }
                if (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) {
                    return false;
                }
                return false;
            }
        }
    }

    enum b {
        private static final /* synthetic */ b[] kfz = null;

        static {
            kfz = new b[0];
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) kfz.clone();
        }

        static void c(EditText editText) {
            if (editText != null) {
                af.cd(editText).hideSoftInputFromInputMethod(editText.getWindowToken(), 2);
            }
        }

        static void setNoSystemInputOnEditText(EditText editText) {
            if (editText != null) {
                if (VERSION.SDK_INT >= 21) {
                    editText.setShowSoftInputOnFocus(false);
                    return;
                }
                Class cls = EditText.class;
                try {
                    Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                    method.setAccessible(true);
                    method.invoke(editText, new Object[]{Boolean.valueOf(false)});
                    method.setAccessible(false);
                } catch (NoSuchMethodException e) {
                    x.i("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", Integer.valueOf(VERSION.SDK_INT));
                    try {
                        Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                        method2.setAccessible(true);
                        method2.invoke(editText, new Object[]{Boolean.valueOf(false)});
                        method2.setAccessible(false);
                    } catch (Throwable e2) {
                        x.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", bi.i(e2));
                        if (editText.getContext() != null && (editText.getContext() instanceof MMActivity)) {
                            ((MMActivity) editText.getContext()).df(editText);
                        }
                    }
                } catch (Throwable e22) {
                    x.e("MicroMsg.AppBrand.InputUtil.EditTextUtil", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", bi.i(e22));
                }
            }
        }

        static int a(EditText editText, float f, float f2) {
            if (editText == null) {
                return -1;
            }
            int paddingTop = editText.getPaddingTop();
            Layout layout = editText.getLayout();
            if (layout == null) {
                return -1;
            }
            Editable editableText = editText.getEditableText();
            if (editableText == null) {
                return -1;
            }
            TextPaint paint = editText.getPaint();
            if (paint == null) {
                return -1;
            }
            Rect rect = new Rect();
            int i = paddingTop;
            paddingTop = 0;
            while (paddingTop < layout.getLineCount()) {
                layout.getLineBounds(paddingTop, rect);
                int height = rect.height() + i;
                if (((float) height) >= f2) {
                    int i2;
                    int lineStart = layout.getLineStart(paddingTop);
                    int lineEnd = layout.getLineEnd(paddingTop);
                    RelativeSizeSpan[] relativeSizeSpanArr = (RelativeSizeSpan[]) editableText.getSpans(lineStart, lineEnd, RelativeSizeSpan.class);
                    float f3 = 1.0f;
                    if (relativeSizeSpanArr != null) {
                        int length = relativeSizeSpanArr.length;
                        i2 = 0;
                        while (i2 < length) {
                            float sizeChange = relativeSizeSpanArr[i2].getSizeChange();
                            i2++;
                            f3 = sizeChange;
                        }
                    }
                    float f4 = f3;
                    String charSequence = editableText.subSequence(lineStart, lineEnd).toString();
                    float[] fArr = new float[charSequence.length()];
                    paint.getTextWidths(charSequence, fArr);
                    f3 = 0.0f;
                    i2 = 0;
                    while (i2 < charSequence.length()) {
                        f3 += fArr[i2] * f4;
                        if (f3 >= f || i2 == charSequence.length() - 1) {
                            return lineStart + i2;
                        }
                        i2++;
                    }
                    continue;
                }
                paddingTop++;
                i = height;
            }
            return -1;
        }
    }

    static {
        Class cls = null;
        try {
            cls = Class.forName("android.view.inputmethod.ComposingText");
        } catch (ClassNotFoundException e) {
            x.e("MicroMsg.AppBrand.InputUtil", "class for ComposingText e = %s", e);
        }
        kfw = cls;
    }

    static Spannable s(CharSequence charSequence) {
        CharSequence charSequence2;
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence;
        }
        if (charSequence2 instanceof Spannable) {
            return (Spannable) charSequence2;
        }
        return new SpannableStringBuilder(charSequence2);
    }

    public static boolean t(CharSequence charSequence) {
        if (!(charSequence instanceof Spanned)) {
            return false;
        }
        Spanned spanned = (Spanned) charSequence;
        Object[] spans = spanned.getSpans(0, spanned.length(), kfw);
        if (spans == null || spans.length <= 0) {
            return false;
        }
        return true;
    }

    static boolean bn(Object obj) {
        return kfw.isInstance(obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.view.inputmethod.InputMethodManager cd(android.view.View r2) {
        /*
        if (r2 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r2.getContext();
        if (r0 != 0) goto L_0x000c;
    L_0x0008:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
    L_0x000c:
        r1 = "input_method";
        r0 = r0.getSystemService(r1);
        r0 = (android.view.inputmethod.InputMethodManager) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.widget.input.af.cd(android.view.View):android.view.inputmethod.InputMethodManager");
    }

    static boolean e(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
