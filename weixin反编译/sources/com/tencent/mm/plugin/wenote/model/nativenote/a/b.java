package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.BoldSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.a;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.d;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.q;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.r;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public final class b {
    public static String a(Spanned spanned) {
        if (spanned == null || bi.oN(spanned.toString())) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        a(spanned, stringBuilder);
        return stringBuilder.toString();
    }

    private static void a(final Spanned spanned, StringBuilder stringBuilder) {
        ArrayList arrayList = new j(spanned).uay;
        Stack stack = new Stack();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            int indexOf;
            e eVar = (n) arrayList.get(i);
            Set<r> a = a(spanned, eVar);
            q qVar = null;
            for (r rVar : a) {
                if (rVar.ubV.ucw) {
                    qVar = rVar.ubV;
                    break;
                }
            }
            q qVar2 = q.NONE;
            q qVar3 = qVar2;
            int i2 = 0;
            for (r rVar2 : a) {
                int i3 = (rVar2.ubV.bYn() || rVar2.ubV.bYo() || rVar2.ubV.bYp()) ? 1 : 0;
                i2 += i3;
                q qVar4 = rVar2.ubV;
                boolean z = rVar2.ubV.bYn() ? ((d) rVar2.ucC).ucb : rVar2.ubV.bYo() ? ((m) rVar2.ucC).ucb : rVar2.ubV.bYp() ? ((k) rVar2.ucC).ucb : true;
                qVar2 = z ? q.NONE : qVar4.bYn() ? q.NOTEUL : qVar4.bYo() ? q.NOTEOL : qVar4.bYp() ? q.NOTETODO : qVar3;
                qVar3 = qVar2;
            }
            a(stack, stringBuilder, new a(qVar3, i2, 0));
            if (qVar3.bYp()) {
                k[] kVarArr = (k[]) spanned.getSpans(eVar.Ww, eVar.wq, k.class);
                if (kVarArr.length > 0) {
                    qVar3.ucA = kVarArr[0].uch;
                    indexOf = qVar3.ucx.indexOf("\"") + 1;
                    i2 = qVar3.ucx.lastIndexOf("\"");
                    if (indexOf < i2) {
                        String substring = qVar3.ucx.substring(indexOf, i2);
                        if (!bi.oN(substring)) {
                            if (!substring.trim().equals(qVar3.ucA ? "1" : "0")) {
                                String str;
                                String str2 = qVar3.ucx;
                                if (qVar3.ucA) {
                                    str = "1";
                                } else {
                                    str = "0";
                                }
                                qVar3.ucx = str2.replaceAll(substring, str);
                            }
                        }
                    }
                }
            }
            stringBuilder.append(qVar3.ucx);
            if (qVar != null) {
                stringBuilder.append(qVar.ucu);
            }
            indexOf = eVar.Ww;
            int i4 = eVar.wq;
            SortedSet treeSet = new TreeSet(new Comparator<CharacterStyle>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    CharacterStyle characterStyle = (CharacterStyle) obj;
                    CharacterStyle characterStyle2 = (CharacterStyle) obj2;
                    int spanStart = spanned.getSpanStart(characterStyle);
                    int spanStart2 = spanned.getSpanStart(characterStyle2);
                    if (spanStart != spanStart2) {
                        return spanStart - spanStart2;
                    }
                    spanStart = spanned.getSpanEnd(characterStyle);
                    spanStart2 = spanned.getSpanEnd(characterStyle2);
                    return spanStart != spanStart2 ? spanStart2 - spanStart : characterStyle.getClass().getName().compareTo(characterStyle2.getClass().getName());
                }
            });
            treeSet.addAll(Arrays.asList(spanned.getSpans(indexOf, i4, CharacterStyle.class)));
            a(spanned, stringBuilder, indexOf, i4, treeSet);
            if (qVar != null) {
                a(stringBuilder, qVar);
                stringBuilder.append(qVar.ucv);
            }
            a(stringBuilder, qVar3);
            stringBuilder.append(qVar3.ucy);
        }
        while (!stack.isEmpty()) {
            a(stack, stringBuilder);
        }
    }

    private static void a(Spanned spanned, StringBuilder stringBuilder, int i, int i2, SortedSet<CharacterStyle> sortedSet) {
        int i3 = i;
        while (i3 < i2) {
            CharacterStyle characterStyle = sortedSet.isEmpty() ? null : (CharacterStyle) sortedSet.first();
            int spanStart = characterStyle == null ? Integer.MAX_VALUE : spanned.getSpanStart(characterStyle);
            int spanEnd = characterStyle == null ? Integer.MAX_VALUE : spanned.getSpanEnd(characterStyle);
            if (i3 < spanStart) {
                int min = Math.min(i2, spanStart);
                int i4 = i3;
                while (i4 < min) {
                    char charAt = spanned.charAt(i4);
                    if (charAt == 10) {
                        stringBuilder.append("<br/>");
                    } else if (charAt == '<') {
                        stringBuilder.append("&lt;");
                    } else if (charAt == '>') {
                        stringBuilder.append("&gt;");
                    } else if (charAt == '&') {
                        stringBuilder.append("&amp;");
                    } else if (charAt == ' ') {
                        while (i4 + 1 < min && spanned.charAt(i4 + 1) == ' ') {
                            stringBuilder.append("&nbsp;");
                            i4++;
                        }
                        stringBuilder.append(' ');
                    } else if (charAt < ' ') {
                        stringBuilder.append("&#" + charAt + ";");
                    } else {
                        stringBuilder.append(charAt);
                    }
                    i4++;
                }
                i3 = spanStart;
            } else {
                sortedSet.remove(characterStyle);
                a(characterStyle, stringBuilder);
                a(spanned, stringBuilder, Math.max(spanStart, i3), Math.min(spanEnd, i2), sortedSet);
                if (characterStyle instanceof ForegroundColorSpan) {
                    stringBuilder.append("</wx-font>");
                } else if (characterStyle instanceof BackgroundColorSpan) {
                    stringBuilder.append("</wx-font>");
                } else if (characterStyle instanceof AbsoluteSizeSpan) {
                    stringBuilder.append("</wx-font>");
                } else if (characterStyle instanceof UnderlineSpan) {
                    stringBuilder.append("</u>");
                } else if (characterStyle instanceof BoldSpan) {
                    stringBuilder.append("</wx-b>");
                } else if ((characterStyle instanceof StyleSpan) && ((StyleSpan) characterStyle).getStyle() == 2) {
                    stringBuilder.append("</i>");
                } else if ((characterStyle instanceof StyleSpan) && ((StyleSpan) characterStyle).getStyle() == 1) {
                    stringBuilder.append("</wx-b>");
                } else if (characterStyle instanceof RelativeSizeSpan) {
                    stringBuilder.append("</wx-font>");
                }
                i3 = spanEnd;
            }
        }
    }

    private static boolean a(CharacterStyle characterStyle, StringBuilder stringBuilder) {
        String toHexString;
        if (characterStyle instanceof BoldSpan) {
            stringBuilder.append("<wx-b>");
        } else if ((characterStyle instanceof StyleSpan) && ((StyleSpan) characterStyle).getStyle() == 1) {
            stringBuilder.append("<wx-b>");
        } else if ((characterStyle instanceof StyleSpan) && ((StyleSpan) characterStyle).getStyle() == 2) {
            stringBuilder.append("<i>");
        } else if (characterStyle instanceof UnderlineSpan) {
            stringBuilder.append("<u>");
        } else if (characterStyle instanceof RelativeSizeSpan) {
            stringBuilder.append("<wx-font style=\"font-size:");
            stringBuilder.append((float) com.tencent.mm.plugin.wenote.model.nativenote.manager.b.BK((int) (((RelativeSizeSpan) characterStyle).getSizeChange() * com.tencent.mm.plugin.wenote.model.nativenote.manager.b.getTextSize())));
            stringBuilder.append("px\">");
        } else if (characterStyle instanceof AbsoluteSizeSpan) {
            stringBuilder.append("<wx-font style=\"font-size:");
            stringBuilder.append(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.BK(((AbsoluteSizeSpan) characterStyle).getSize()));
            stringBuilder.append("px\">");
        } else if (characterStyle instanceof ForegroundColorSpan) {
            stringBuilder.append("<wx-font style=\"color:#");
            toHexString = Integer.toHexString(((ForegroundColorSpan) characterStyle).getForegroundColor() + 16777216);
            while (toHexString.length() < 6) {
                toHexString = "0" + toHexString;
            }
            stringBuilder.append(toHexString);
            stringBuilder.append("\">");
        } else if (characterStyle instanceof BackgroundColorSpan) {
            stringBuilder.append("<wx-font style=\"background-color:#");
            toHexString = Integer.toHexString(((BackgroundColorSpan) characterStyle).getBackgroundColor() + 16777216);
            while (toHexString.length() < 6) {
                toHexString = "0" + toHexString;
            }
            stringBuilder.append(toHexString);
            stringBuilder.append("\">");
        }
        return true;
    }

    private static void a(StringBuilder stringBuilder, q qVar) {
        if (qVar.ucz && stringBuilder.length() >= 5) {
            int length = stringBuilder.length() - 5;
            int length2 = stringBuilder.length();
            if (stringBuilder.subSequence(length, length2).equals("<br/>")) {
                stringBuilder.delete(length, length2);
            }
        }
    }

    private static Set<r> a(Spanned spanned, e eVar) {
        Set<r> hashSet = new HashSet();
        for (ParagraphStyle paragraphStyle : (ParagraphStyle[]) spanned.getSpans(eVar.Ww, eVar.wq, ParagraphStyle.class)) {
            q a = q.a(paragraphStyle);
            if (a != null) {
                hashSet.add(new r(a, paragraphStyle));
            }
        }
        return hashSet;
    }

    private static void a(Stack<a> stack, StringBuilder stringBuilder, a aVar) {
        while (true) {
            int i = 0;
            q qVar = q.NONE;
            if (!stack.isEmpty()) {
                a aVar2 = (a) stack.peek();
                i = aVar2.ubW;
                qVar = aVar2.ubV;
            }
            if (aVar.ubW > i) {
                aVar.ubX = aVar.ubW - i;
                b(stack, stringBuilder, aVar);
                return;
            } else if (aVar.ubW < i) {
                a((Stack) stack, stringBuilder);
            } else if (aVar.ubV != qVar) {
                aVar.ubX = a((Stack) stack, stringBuilder);
                b(stack, stringBuilder, aVar);
                return;
            } else {
                return;
            }
        }
    }

    private static int a(Stack<a> stack, StringBuilder stringBuilder) {
        int i = 0;
        if (stack.isEmpty()) {
            return 0;
        }
        a aVar = (a) stack.pop();
        String str = aVar.ubV.ucv;
        int i2 = aVar.ubX;
        while (i < i2) {
            stringBuilder.append(str);
            i++;
        }
        return aVar.ubX;
    }

    private static void b(Stack<a> stack, StringBuilder stringBuilder, a aVar) {
        String str = aVar.ubV.ucu;
        int i = aVar.ubX;
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(str);
        }
        stack.push(aVar);
    }
}
