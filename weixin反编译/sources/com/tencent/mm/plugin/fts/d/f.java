package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.e.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.d.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class f {

    public static class a {
        public static int mUz;

        static {
            mUz = 0;
            Context context = ad.getContext();
            mUz = ((com.tencent.mm.bu.a.eB(context) - (com.tencent.mm.bu.a.aa(context, b.mUM) * 2)) - com.tencent.mm.bu.a.aa(context, b.bvE)) - com.tencent.mm.bu.a.aa(context, b.mUM);
        }
    }

    public static final com.tencent.mm.plugin.fts.d.b.b a(String str, String str2, com.tencent.mm.plugin.fts.d.b.a aVar) {
        com.tencent.mm.plugin.fts.d.b.b a = a(aVar);
        a.mVW = TextUtils.concat(new CharSequence[]{str, a.mVW, str2});
        return a;
    }

    public static final SpannableString b(CharSequence charSequence, int i) {
        SpannableString spannableString = new SpannableString(charSequence);
        com.tencent.mm.plugin.fts.d.b.a.b bVar = new com.tencent.mm.plugin.fts.d.b.a.b();
        bVar.mVU = 0;
        bVar.mVV = i;
        b(spannableString, bVar, new com.tencent.mm.plugin.fts.d.b.a());
        return spannableString;
    }

    public static final com.tencent.mm.plugin.fts.d.b.b a(com.tencent.mm.plugin.fts.d.b.a aVar) {
        int i;
        com.tencent.mm.plugin.fts.d.b.b bVar = new com.tencent.mm.plugin.fts.d.b.b();
        CharSequence spannableString = new SpannableString(TextUtils.concat(new CharSequence[]{aVar.mVN, aVar.mVI, aVar.mVO}));
        bVar.bjW = -1;
        bVar.mVW = spannableString;
        if (bi.N(aVar.mVI) || aVar.mRM == null) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return bVar;
        }
        List ao;
        String BI = d.BI(aVar.mVI.toString());
        ArrayList arrayList = new ArrayList();
        if (aVar.mRj) {
            ao = ao(BI, aVar.mVJ);
        } else {
            Object ao2 = arrayList;
        }
        com.tencent.mm.plugin.fts.d.b.a.b bVar2;
        com.tencent.mm.plugin.fts.d.b.b b;
        if (aVar.mRM.mRp.size() == 1 || a(spannableString, aVar)) {
            bVar2 = new com.tencent.mm.plugin.fts.d.b.a.b();
            if (aVar.mRM.mRp.size() == 1) {
                bVar2.mVT = (c) aVar.mRM.mRp.get(0);
                if (aVar.mRj) {
                    a(ao2, bVar2, aVar);
                } else {
                    a(BI, bVar2, aVar);
                }
                if (!bVar2.isAvailable()) {
                    return bVar;
                }
                try {
                    b = b(spannableString, bVar2, aVar);
                } catch (Exception e) {
                    bVar.mVW = spannableString;
                    b = bVar;
                }
                return b;
            }
            for (c cVar : aVar.mRM.mRp) {
                bVar2.mVT = cVar;
                if (aVar.mRj) {
                    a(ao2, bVar2, aVar);
                } else {
                    a(BI, bVar2, aVar);
                }
                if (bVar2.isAvailable()) {
                    try {
                        return b(spannableString, bVar2, aVar);
                    } catch (Exception e2) {
                        bVar.mVW = spannableString;
                        return bVar;
                    }
                }
            }
            return bVar;
        }
        com.tencent.mm.plugin.fts.d.b.a.b bVar3 = new com.tencent.mm.plugin.fts.d.b.a.b();
        bVar3.mVT = new c();
        e.b bVar4 = new e.b();
        bVar4.mRr = e.d.mRw;
        bVar4.content = aVar.mRM.mRm;
        bVar3.mVT.mRt.add(bVar4);
        if (aVar.mRj) {
            a(ao2, bVar3, aVar);
        } else {
            a(BI, bVar3, aVar);
        }
        if (bVar3.isAvailable()) {
            try {
                return b(spannableString, bVar3, aVar);
            } catch (Exception e3) {
                bVar.mVW = spannableString;
                return bVar;
            }
        }
        List<com.tencent.mm.plugin.fts.d.b.a.b> arrayList2 = new ArrayList();
        for (c cVar2 : aVar.mRM.mRp) {
            bVar2 = new com.tencent.mm.plugin.fts.d.b.a.b();
            bVar2.mVT = cVar2;
            arrayList2.add(bVar2);
        }
        for (com.tencent.mm.plugin.fts.d.b.a.b bVar32 : arrayList2) {
            if (aVar.mRj) {
                a(ao2, bVar32, aVar);
            } else {
                a(BI, bVar32, aVar);
            }
        }
        for (com.tencent.mm.plugin.fts.d.b.a.b bVar322 : arrayList2) {
            if (bVar322.isAvailable()) {
                b = b(spannableString, bVar322, aVar);
                if (b.bjW == 0) {
                    bVar = b;
                }
            }
        }
        return bVar;
    }

    private static boolean a(SpannableString spannableString, com.tencent.mm.plugin.fts.d.b.a aVar) {
        if (aVar.mVM <= 0.0f || aVar.gVy == null || aVar.mVM - (aVar.gVy.getTextSize() * 2.0f) >= aVar.gVy.measureText(spannableString.toString())) {
            return false;
        }
        return true;
    }

    private static com.tencent.mm.plugin.fts.d.b.b a(SpannableString spannableString, com.tencent.mm.plugin.fts.d.b.a.b bVar, com.tencent.mm.plugin.fts.d.b.a aVar) {
        com.tencent.mm.plugin.fts.d.b.b bVar2 = new com.tencent.mm.plugin.fts.d.b.b();
        float textSize = aVar.mVM - (aVar.gVy.getTextSize() * 2.0f);
        float measureText = aVar.gVy.measureText("…");
        float measureText2 = aVar.gVy.measureText(spannableString, 0, bVar.mVU);
        float measureText3 = aVar.gVy.measureText(spannableString, bVar.mVU, bVar.mVV);
        float measureText4 = aVar.gVy.measureText(spannableString, bVar.mVV, spannableString.length());
        if ((measureText2 + measureText3) + measureText4 < textSize) {
            return c(spannableString, bVar, aVar);
        }
        Object backgroundColorSpan;
        if (aVar.mVK == com.tencent.mm.plugin.fts.d.b.a.a.mVQ) {
            backgroundColorSpan = new BackgroundColorSpan(aVar.mVL);
        } else {
            backgroundColorSpan = new ForegroundColorSpan(aVar.mVL);
        }
        CharSequence spannableString2 = new SpannableString(spannableString.subSequence(bVar.mVU, bVar.mVV));
        try {
            spannableString2.setSpan(backgroundColorSpan, 0, spannableString2.length(), 33);
            CharSequence spannableStringBuilder;
            if ((measureText2 + measureText3) + measureText < textSize) {
                spannableStringBuilder = new SpannableStringBuilder(spannableString, 0, bVar.mVU);
                spannableStringBuilder.append(spannableString2);
                spannableStringBuilder.append(TextUtils.ellipsize(spannableString.subSequence(bVar.mVV, spannableString.length()), aVar.gVy, (textSize - measureText2) - measureText3, TruncateAt.END));
                bVar2.mVW = spannableStringBuilder;
            } else if ((measureText + measureText3) + measureText4 < textSize) {
                spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(TextUtils.ellipsize(spannableString.subSequence(0, bVar.mVU), aVar.gVy, (textSize - measureText3) - measureText4, TruncateAt.START));
                spannableStringBuilder.append(spannableString2);
                spannableStringBuilder.append(spannableString, bVar.mVV, spannableString.length());
                bVar2.mVW = spannableStringBuilder;
            } else if ((measureText + measureText3) + measureText >= textSize) {
                spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append(TextUtils.ellipsize(spannableString2, aVar.gVy, textSize, TruncateAt.END));
                bVar2.mVW = spannableStringBuilder;
            } else {
                spannableStringBuilder = new SpannableStringBuilder();
                textSize = (textSize - measureText3) / 2.0f;
                CharSequence subSequence = spannableString.subSequence(0, bVar.mVU);
                CharSequence subSequence2 = spannableString.subSequence(bVar.mVV, spannableString.length());
                spannableStringBuilder.append(TextUtils.ellipsize(subSequence, aVar.gVy, textSize, TruncateAt.START));
                spannableStringBuilder.append(spannableString2);
                spannableStringBuilder.append(TextUtils.ellipsize(subSequence2, aVar.gVy, textSize, TruncateAt.END));
                bVar2.mVW = spannableStringBuilder;
            }
            bVar2.bjW = 0;
            return bVar2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", e, "setSpan %s", bVar.toString());
            bVar2.bjW = -1;
            bVar2.mVW = spannableString;
            return bVar2;
        }
    }

    private static com.tencent.mm.plugin.fts.d.b.b b(SpannableString spannableString, com.tencent.mm.plugin.fts.d.b.a.b bVar, com.tencent.mm.plugin.fts.d.b.a aVar) {
        if (a(spannableString, aVar)) {
            return a(spannableString, bVar, aVar);
        }
        return c(spannableString, bVar, aVar);
    }

    private static com.tencent.mm.plugin.fts.d.b.b c(SpannableString spannableString, com.tencent.mm.plugin.fts.d.b.a.b bVar, com.tencent.mm.plugin.fts.d.b.a aVar) {
        Object backgroundColorSpan;
        com.tencent.mm.plugin.fts.d.b.b bVar2 = new com.tencent.mm.plugin.fts.d.b.b();
        if (aVar.mVK == com.tencent.mm.plugin.fts.d.b.a.a.mVQ) {
            backgroundColorSpan = new BackgroundColorSpan(aVar.mVL);
        } else {
            backgroundColorSpan = new ForegroundColorSpan(aVar.mVL);
        }
        try {
            spannableString.setSpan(backgroundColorSpan, bVar.mVU, bVar.mVV, 33);
            bVar2.mVW = spannableString;
            bVar2.bjW = 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSUIHLLogic", e, "setSpan %s", bVar.toString());
            bVar2.mVW = spannableString;
            bVar2.bjW = -1;
        }
        return bVar2;
    }

    private static void a(String str, com.tencent.mm.plugin.fts.d.b.a.b bVar, com.tencent.mm.plugin.fts.d.b.a aVar) {
        String str2;
        if (bVar.mVT != null && bVar.mVT.mRt.size() > 0) {
            for (e.b bVar2 : bVar.mVT.mRt) {
                if (bVar2.mRr == e.d.mRw) {
                    str2 = bVar2.content;
                    break;
                }
            }
        }
        str2 = null;
        if (!bi.oN(str2)) {
            int indexOf = str.indexOf(str2);
            if (indexOf >= 0) {
                bVar.mVU = indexOf;
                bVar.mVV = str2.length() + indexOf;
            }
            if (bVar.isAvailable() && aVar.mVN != null) {
                bVar.mVU += aVar.mVN.length();
                bVar.mVV += aVar.mVN.length();
            }
        }
    }

    private static void a(List<List<String>> list, com.tencent.mm.plugin.fts.d.b.a.b bVar, com.tencent.mm.plugin.fts.d.b.a aVar) {
        e.b bVar2;
        if (aVar.mVJ) {
            for (e.b bVar22 : bVar.mVT.mRt) {
                if (bVar22.mRr == e.d.mRv) {
                    break;
                }
            }
            bVar22 = null;
            if (bVar22 != null) {
                int g = g(list, bVar22.mRs);
                if (g >= 0) {
                    bVar.mVU = g;
                    bVar.mVV = bVar22.mRs.size() + g;
                }
            } else {
                return;
            }
        }
        for (e.b bVar222 : bVar.mVT.mRt) {
            if (bVar222.mRr == e.d.mRu) {
                int g2 = g(list, bVar222.mRs);
                if (g2 >= 0) {
                    bVar.mVU = g2;
                    bVar.mVV = bVar222.mRs.size() + g2;
                    break;
                }
            }
        }
        if (bVar.isAvailable() && aVar.mVN != null) {
            bVar.mVU += aVar.mVN.length();
            bVar.mVV += aVar.mVN.length();
        }
    }

    private static int g(List<List<String>> list, List<String> list2) {
        int i = 0;
        int i2 = 0;
        while (i < (list.size() - list2.size()) + 1) {
            int i3;
            Object obj;
            while (true) {
                int i4 = i2;
                if (i4 >= list2.size()) {
                    i2 = 1;
                    i3 = i4;
                    break;
                }
                List<String> list3 = (List) list.get(i + i4);
                String str = (String) list2.get(i4);
                if (!list3.contains(str)) {
                    if (i4 != list2.size() - 1) {
                        obj = null;
                        i3 = 0;
                        break;
                    }
                    for (String startsWith : list3) {
                        if (startsWith.startsWith(str)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        obj = null;
                        i3 = 0;
                        break;
                    }
                    i2 = i4 + 1;
                } else {
                    i2 = i4 + 1;
                }
            }
            if (obj != null) {
                return i;
            }
            i++;
            i2 = i3;
        }
        return -1;
    }

    private static List<List<String>> ao(String str, boolean z) {
        List<List<String>> arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            List arrayList2 = new ArrayList(2);
            if (com.tencent.mm.plugin.fts.a.f.i(charAt)) {
                String[] strArr = (String[]) com.tencent.mm.plugin.fts.a.f.mQU.get(String.valueOf(charAt));
                if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
                    arrayList.add(arrayList2);
                } else {
                    for (Object obj : strArr) {
                        Object obj2;
                        if (z) {
                            obj2 = obj2.substring(0, 1);
                        }
                        if (!arrayList2.contains(obj2)) {
                            arrayList2.add(obj2);
                        }
                    }
                    arrayList.add(arrayList2);
                }
            } else {
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }
}
