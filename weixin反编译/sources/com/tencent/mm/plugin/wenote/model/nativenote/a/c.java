package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.XMLReader;

public final class c implements TagHandler {
    private static final Pattern ayE = Pattern.compile("\\d+");
    private static final Pattern tYN = Pattern.compile("#[a-f0-9]+");
    private static HashMap<String, Integer> tYO;
    private Stack<com.tencent.mm.plugin.wenote.model.nativenote.spans.a> tYL = new Stack();
    final HashMap<String, String> tYM = new HashMap();

    private static class a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static class b {
        int hX;
        String tYP;
        String tYQ;
        String tYR;

        private b() {
            this.hX = Integer.MIN_VALUE;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static class d extends c {
        d(int i) {
            super(i, false);
        }
    }

    private static class f extends c {
        f(int i) {
            super(i, false);
        }
    }

    private static class e extends c {
        boolean tYU = false;

        e(int i, boolean z) {
            super(i, false);
            this.tYU = z;
        }
    }

    private static abstract class c {
        int tYS;
        boolean tYT = false;

        c(int i, boolean z) {
            this.tYS = i;
        }
    }

    public final void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        Object obj;
        int intValue;
        int i;
        this.tYM.clear();
        try {
            Field declaredField = xMLReader.getClass().getDeclaredField("theNewElement");
            declaredField.setAccessible(true);
            obj = declaredField.get(xMLReader);
            Field declaredField2 = obj.getClass().getDeclaredField("theAtts");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            declaredField = obj2.getClass().getDeclaredField(SlookAirButtonFrequentContactAdapter.DATA);
            declaredField.setAccessible(true);
            String[] strArr = (String[]) declaredField.get(obj2);
            Field declaredField3 = obj2.getClass().getDeclaredField("length");
            declaredField3.setAccessible(true);
            intValue = ((Integer) declaredField3.get(obj2)).intValue();
            for (i = 0; i < intValue; i++) {
                this.tYM.put(strArr[(i * 5) + 1], strArr[(i * 5) + 4]);
            }
        } catch (Exception e) {
        }
        int spanStart;
        String str2;
        boolean z2;
        int i2;
        if (!z) {
            c cVar;
            int spanStart2;
            int length;
            if (str.equalsIgnoreCase("wx-ul")) {
                kM(false);
            } else if (str.equalsIgnoreCase("wx-ol")) {
                kM(true);
            } else if (str.equalsIgnoreCase("wn-todo")) {
                cVar = (c) a(editable, c.class);
                if (cVar != null) {
                    if (editable.length() == 0 || editable.charAt(editable.length() - 1) != 10) {
                        editable.append(10);
                    }
                    spanStart2 = editable.getSpanStart(cVar);
                    length = editable.length();
                    if (!cVar.tYT) {
                        editable.setSpan(new k(((e) cVar).tYU, com.tencent.mm.plugin.wenote.model.nativenote.manager.b.bXb(), spanStart2 == length, false, false), spanStart2, length, 33);
                    }
                    editable.removeSpan(cVar);
                }
            } else if (str.equalsIgnoreCase("wx-li")) {
                cVar = (c) a(editable, c.class);
                if (cVar != null) {
                    if (editable.length() == 0 || editable.charAt(editable.length() - 1) != 10) {
                        editable.append(10);
                    }
                    spanStart2 = editable.getSpanStart(cVar);
                    length = editable.length();
                    if (!cVar.tYT) {
                        intValue = com.tencent.mm.plugin.wenote.model.nativenote.manager.b.bXb();
                        if (cVar instanceof d) {
                            obj = new m(1, intValue, spanStart2 == length, false, false);
                        } else {
                            com.tencent.mm.plugin.wenote.model.nativenote.spans.d dVar = new com.tencent.mm.plugin.wenote.model.nativenote.spans.d(intValue, spanStart2 == length, false, false);
                        }
                        editable.setSpan(obj, spanStart2, length, 33);
                    }
                    editable.removeSpan(cVar);
                }
            } else if (str.equalsIgnoreCase("wx-font") || str.equalsIgnoreCase("span")) {
                intValue = editable.length();
                obj = a(editable, b.class);
                if (obj != null) {
                    spanStart = editable.getSpanStart(obj);
                    editable.removeSpan(obj);
                    if (spanStart != intValue) {
                        b bVar = (b) obj;
                        if ((!TextUtils.isEmpty(bVar.tYR) ? 1 : null) != null) {
                            editable.setSpan(new TypefaceSpan(bVar.tYR), spanStart, intValue, 33);
                        }
                        if ((bVar.hX > 0 ? 1 : null) != null) {
                            editable.setSpan(new AbsoluteSizeSpan(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.BJ(bVar.hX)), spanStart, intValue, 33);
                        }
                        if ((!TextUtils.isEmpty(bVar.tYP) ? 1 : null) != null) {
                            i = Rt(bVar.tYP);
                            if (i != -1) {
                                editable.setSpan(new ForegroundColorSpan(i | WebView.NIGHT_MODE_COLOR), spanStart, intValue, 33);
                            }
                        }
                        if ((!TextUtils.isEmpty(bVar.tYQ) ? 1 : null) != null) {
                            int Rt = Rt(bVar.tYQ);
                            if (Rt != -1) {
                                editable.setSpan(new BackgroundColorSpan(Rt | WebView.NIGHT_MODE_COLOR), spanStart, intValue, 33);
                            }
                        }
                    }
                }
            } else if (str.equalsIgnoreCase("wx-b")) {
                BoldSpan boldSpan = new BoldSpan();
                intValue = editable.length();
                obj = a(editable, a.class);
                spanStart = editable.getSpanStart(obj);
                editable.removeSpan(obj);
                if (spanStart != intValue) {
                    editable.setSpan(boldSpan, spanStart, intValue, 33);
                }
            } else if (str.equalsIgnoreCase("wx-p")) {
                d(editable);
            } else {
                str.equalsIgnoreCase("wx-div");
            }
            this.tYM.clear();
        } else if (str.equalsIgnoreCase("wx-ul")) {
            a(false, q.NOTEUL);
        } else if (str.equalsIgnoreCase("wx-ol")) {
            a(true, q.NOTEOL);
        } else if (str.equalsIgnoreCase("wn-todo")) {
            this.tYL.push(new com.tencent.mm.plugin.wenote.model.nativenote.spans.a(q.NOTETODO, 1, 1));
            str2 = (String) this.tYM.get("checked");
            z2 = !bi.oN(str2) && str2.equals("1");
            a(editable, new e(((com.tencent.mm.plugin.wenote.model.nativenote.spans.a) this.tYL.peek()).ubW, z2));
        } else if (str.equalsIgnoreCase("wx-li")) {
            str2 = (String) this.tYM.get("done");
            z2 = !bi.oN(str2) && str2.equals("true");
            if (this.tYL.isEmpty()) {
                obj = new f(0);
            } else {
                com.tencent.mm.plugin.wenote.model.nativenote.spans.a aVar = (com.tencent.mm.plugin.wenote.model.nativenote.spans.a) this.tYL.peek();
                q qVar = aVar.ubV;
                i2 = aVar.ubW;
                obj = qVar.bYo() ? new d(i2) : qVar.bYn() ? new f(i2) : qVar.bYp() ? new e(i2, z2) : null;
            }
            if (obj != null) {
                a(editable, obj);
            }
        } else if (str.equalsIgnoreCase("wx-font") || str.equalsIgnoreCase("span")) {
            spanStart = Integer.MIN_VALUE;
            String str3 = null;
            String str4 = null;
            str2 = (String) this.tYM.get("style");
            if (str2 != null) {
                str2 = null;
                str4 = null;
                intValue = Integer.MIN_VALUE;
                for (Object obj3 : str2.toLowerCase(Locale.ENGLISH).split(";")) {
                    Matcher matcher;
                    if (obj3.startsWith("font-size")) {
                        matcher = ayE.matcher(obj3);
                        if (matcher.find(0)) {
                            try {
                                intValue = Integer.parseInt(obj3.substring(matcher.start(), matcher.end()));
                            } catch (NumberFormatException e2) {
                            }
                        }
                    } else if (obj3.startsWith("color")) {
                        matcher = tYN.matcher(obj3);
                        if (matcher.find(0)) {
                            str4 = obj3.substring(matcher.start(), matcher.end());
                        }
                    } else if (obj3.startsWith("background-color")) {
                        matcher = tYN.matcher(obj3);
                        if (matcher.find(0)) {
                            str2 = obj3.substring(matcher.start(), matcher.end());
                        }
                    }
                }
                spanStart = intValue;
                str3 = str4;
                str4 = str2;
            }
            str2 = (String) this.tYM.get("face");
            i2 = editable.length();
            b bVar2 = new b();
            bVar2.hX = spanStart;
            bVar2.tYP = str3;
            bVar2.tYQ = str4;
            editable.setSpan(bVar2.tYR = str2, i2, i2, 17);
        } else if (str.equalsIgnoreCase("wx-b")) {
            a(editable, new a());
        } else if (str.equalsIgnoreCase("wx-p")) {
            d(editable);
        } else if (str.equalsIgnoreCase("wx-div")) {
            d(editable);
        }
        a.tYJ = editable;
    }

    private static void d(Editable editable) {
        int length = editable.length();
        if ((length <= 0 || editable.charAt(length - 1) != 10) && length != 0) {
            editable.append("\n");
        }
    }

    private void a(boolean z, q qVar) {
        if (z) {
            qVar = q.NOTEOL;
        }
        com.tencent.mm.plugin.wenote.model.nativenote.spans.a aVar = this.tYL.isEmpty() ? null : (com.tencent.mm.plugin.wenote.model.nativenote.spans.a) this.tYL.peek();
        if (aVar == null) {
            this.tYL.push(new com.tencent.mm.plugin.wenote.model.nativenote.spans.a(qVar, 1, 1));
        } else if (aVar.ubV == qVar) {
            aVar.ubW++;
            aVar.ubX++;
        } else {
            this.tYL.push(new com.tencent.mm.plugin.wenote.model.nativenote.spans.a(qVar, aVar.ubW + 1, 1));
        }
    }

    private void kM(boolean z) {
        while (!this.tYL.isEmpty()) {
            com.tencent.mm.plugin.wenote.model.nativenote.spans.a aVar = (com.tencent.mm.plugin.wenote.model.nativenote.spans.a) this.tYL.peek();
            q qVar = aVar.ubV;
            if (!(z && qVar.bYo()) && ((z || !qVar.bYn()) && (z || !qVar.bYp()))) {
                this.tYL.pop();
            } else {
                int i = aVar.ubX;
                if (i > 1) {
                    aVar.ubX = i - 1;
                    aVar.ubW--;
                    return;
                }
                this.tYL.pop();
                return;
            }
        }
    }

    private static Object a(Editable editable, Class<? extends Object> cls) {
        Object[] spans = editable.getSpans(0, editable.length(), cls);
        return spans.length == 0 ? null : spans[spans.length - 1];
    }

    private static void a(Editable editable, Object obj) {
        int length = editable.length();
        editable.setSpan(obj, length, length, 17);
    }

    static {
        HashMap hashMap = new HashMap();
        tYO = hashMap;
        hashMap.put("aqua", Integer.valueOf(65535));
        tYO.put("black", Integer.valueOf(0));
        tYO.put("blue", Integer.valueOf(255));
        tYO.put("fuchsia", Integer.valueOf(16711935));
        tYO.put("green", Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
        tYO.put("grey", Integer.valueOf(8421504));
        tYO.put("lime", Integer.valueOf(65280));
        tYO.put("maroon", Integer.valueOf(8388608));
        tYO.put("navy", Integer.valueOf(FileUtils.S_IWUSR));
        tYO.put("olive", Integer.valueOf(8421376));
        tYO.put("purple", Integer.valueOf(8388736));
        tYO.put("red", Integer.valueOf(16711680));
        tYO.put("silver", Integer.valueOf(12632256));
        tYO.put("teal", Integer.valueOf(32896));
        tYO.put("white", Integer.valueOf(16777215));
        tYO.put("yellow", Integer.valueOf(16776960));
    }

    @SuppressLint({"DefaultLocale"})
    private static int Rt(String str) {
        int i = 1;
        Integer num = (Integer) tYO.get(str.toLowerCase());
        if (num != null) {
            return num.intValue();
        }
        if (str == null) {
            return -1;
        }
        try {
            int i2;
            int i3;
            String charSequence = str.toString();
            int length = charSequence.length();
            int i4 = 10;
            if ('-' == charSequence.charAt(0)) {
                i2 = -1;
            } else {
                i2 = 1;
                i = 0;
            }
            if ('0' == charSequence.charAt(i)) {
                if (i == length - 1) {
                    return 0;
                }
                char charAt = charSequence.charAt(i + 1);
                if ('x' == charAt || 'X' == charAt) {
                    i3 = i + 2;
                    i4 = 16;
                } else {
                    i3 = i + 1;
                    i4 = 8;
                }
            } else if ('#' == charSequence.charAt(i)) {
                i3 = i + 1;
                i4 = 16;
            } else {
                i3 = i;
            }
            return Integer.parseInt(charSequence.substring(i3), i4) * i2;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
