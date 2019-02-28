package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import android.text.style.StyleSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.Iterator;

public final class b extends e<Boolean, BoldSpan> {
    public final /* synthetic */ void a(WXRTEditText wXRTEditText, Object obj) {
        Boolean bool = (Boolean) obj;
        e p = p(wXRTEditText);
        int i = p.isEmpty() ? 18 : 34;
        Spannable text = wXRTEditText.getText();
        Iterator it = a(text, p, s.ucE).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean equals = BoldSpan.bYi().equals(bool);
            int spanStart = text.getSpanStart(next);
            if (spanStart < p.Ww) {
                if (equals) {
                    p.ev(p.Ww - spanStart, 0);
                    i = 34;
                } else {
                    BoldSpan.bYi();
                    text.setSpan(new BoldSpan(), spanStart, p.Ww, 33);
                }
            }
            spanStart = text.getSpanEnd(next);
            if (spanStart > p.wq) {
                if (equals) {
                    p.ev(0, spanStart - p.wq);
                } else {
                    BoldSpan.bYi();
                    text.setSpan(new BoldSpan(), p.wq, spanStart, 34);
                }
            }
            text.removeSpan(next);
        }
        if (bool != null && bool.booleanValue()) {
            text.setSpan(new BoldSpan(), p.Ww, p.wq, i);
        }
    }

    protected final /* synthetic */ g bYh() {
        return new BoldSpan();
    }

    protected final /* synthetic */ Object getValue(Object obj) {
        return BoldSpan.bYi();
    }

    public final boolean bP(Object obj) {
        if (obj instanceof BoldSpan) {
            return true;
        }
        return (obj instanceof StyleSpan) && ((StyleSpan) obj).getStyle() == 1;
    }

    public final int bYg() {
        return 0;
    }
}
