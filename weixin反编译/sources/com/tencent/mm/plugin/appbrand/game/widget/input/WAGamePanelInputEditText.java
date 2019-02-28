package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.widget.input.x;
import com.tencent.mm.pointers.PInt;
import com.tencent.wcdb.database.SQLiteDatabase;

@SuppressLint({"AppCompatCustomView"})
public class WAGamePanelInputEditText extends EditText {
    public final x jdO;
    private final InputFilter jdP;
    public int jdQ;
    private final Factory jdR;

    static /* synthetic */ Spannable a(WAGamePanelInputEditText wAGamePanelInputEditText, Spannable spannable) {
        PInt pInt = new PInt();
        pInt.value = wAGamePanelInputEditText.jdQ;
        b chK = b.chK();
        wAGamePanelInputEditText.getContext();
        return chK.a(spannable, Math.round(wAGamePanelInputEditText.getTextSize()), pInt, wAGamePanelInputEditText.jdR);
    }

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.editTextStyle);
    }

    public WAGamePanelInputEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jdP = new InputFilter() {
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                Spannable spannable;
                CharSequence subSequence = charSequence.subSequence(i, i2);
                if (subSequence instanceof Spannable) {
                    spannable = (Spannable) subSequence;
                } else {
                    Object spannable2 = new SpannableStringBuilder(subSequence);
                }
                return WAGamePanelInputEditText.a(WAGamePanelInputEditText.this, spannable2);
            }
        };
        this.jdQ = Integer.MAX_VALUE;
        this.jdR = new Factory() {
            public final Spannable newSpannable(CharSequence charSequence) {
                return new SpannableStringBuilder(charSequence);
            }
        };
        this.jdO = new x(this);
        super.setEditableFactory(new Editable.Factory() {
            public final Editable newEditable(CharSequence charSequence) {
                return WAGamePanelInputEditText.this.jdO.c((Editable) WAGamePanelInputEditText.a(WAGamePanelInputEditText.this, super.newEditable(charSequence)));
            }
        });
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        if (this.jdP != null) {
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            while (i < inputFilterArr.length) {
                inputFilterArr2[i] = inputFilterArr[i];
                i++;
            }
            inputFilterArr2[i] = this.jdP;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        editorInfo.imeOptions |= SQLiteDatabase.CREATE_IF_NECESSARY;
        return onCreateInputConnection;
    }
}
