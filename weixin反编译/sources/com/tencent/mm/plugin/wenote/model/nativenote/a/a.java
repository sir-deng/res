package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.text.Html;
import android.text.Spanned;
import android.text.style.ParagraphStyle;
import com.tencent.mm.a.f;
import java.util.regex.Pattern;

public final class a {
    private static String TAG = "MicroMsg.ConvertHtmlToSpanned";
    private static f<String, Spanned> tYI = new f(30);
    public static Spanned tYJ = null;

    public static Spanned Rs(String str) {
        CharSequence str2;
        if (str2 == null) {
            str2 = "";
        }
        String replaceAll = Pattern.compile("\n", 2).matcher(str2).replaceAll("<br/>");
        Spanned fromHtml = fromHtml(replaceAll);
        tYI.put(replaceAll, fromHtml);
        return fromHtml;
    }

    private static Spanned fromHtml(String str) {
        Spanned fromHtml;
        if (!str.startsWith("<html>")) {
            str = "<html>" + str;
        }
        if (!str.endsWith("</html>")) {
            str = str + "</html>";
        }
        try {
            tYJ = null;
            fromHtml = Html.fromHtml(str, null, new c());
        } catch (Throwable th) {
            if (tYJ != null) {
                fromHtml = tYJ;
            } else {
                fromHtml = null;
            }
        }
        if (fromHtml == null) {
            return null;
        }
        int length = fromHtml.toString().length();
        if (length <= 1 || !fromHtml.toString().endsWith("\n")) {
            return fromHtml;
        }
        return fromHtml.getSpans(length, length, ParagraphStyle.class).length > 0 ? (Spanned) fromHtml.subSequence(0, length - 1) : fromHtml;
    }
}
