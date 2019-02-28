package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EllipsizingTextView extends TextView {
    private int maxLines = -1;
    private boolean nDA;
    private String nDB;
    private float nDC = 1.0f;
    private float nDD = 0.0f;
    private final List<Object> nDx = new ArrayList();
    private boolean nDy;
    private boolean nDz;

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.nDz = true;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public void setLineSpacing(float f, float f2) {
        this.nDD = f;
        this.nDC = f2;
        super.setLineSpacing(f, f2);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.nDA) {
            this.nDB = charSequence.toString();
            this.nDz = true;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.nDz) {
            CharSequence charSequence;
            boolean z;
            Iterator it;
            super.setEllipsize(null);
            int maxLines = getMaxLines();
            String str = this.nDB;
            if (maxLines != -1) {
                Layout CT = CT(str);
                if (CT.getLineCount() > maxLines) {
                    str = this.nDB.substring(0, CT.getLineEnd(maxLines - 1)).trim();
                    if (!(str.getBytes().length != str.length())) {
                        while (CT(str + "...").getLineCount() > maxLines) {
                            int lastIndexOf = str.lastIndexOf(32);
                            if (lastIndexOf == -1) {
                                break;
                            }
                            str = str.substring(0, lastIndexOf);
                        }
                    } else if (str.length() >= 2) {
                        str = str.substring(0, (str.length() - 1) - 1);
                    }
                    charSequence = str + "...";
                    z = true;
                    if (!charSequence.equals(getText())) {
                        this.nDA = true;
                        try {
                            setText(charSequence);
                        } finally {
                            this.nDA = false;
                        }
                    }
                    this.nDz = false;
                    if (z != this.nDy) {
                        this.nDy = z;
                        it = this.nDx.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                }
            }
            Object charSequence2 = str;
            z = false;
            if (charSequence2.equals(getText())) {
                this.nDA = true;
                setText(charSequence2);
            }
            this.nDz = false;
            if (z != this.nDy) {
                this.nDy = z;
                it = this.nDx.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
        super.onDraw(canvas);
    }

    private Layout CT(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Alignment.ALIGN_NORMAL, this.nDC, this.nDD, false);
    }

    public void setEllipsize(TruncateAt truncateAt) {
    }
}
