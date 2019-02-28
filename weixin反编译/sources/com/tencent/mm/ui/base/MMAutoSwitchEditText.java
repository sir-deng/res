package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

public class MMAutoSwitchEditText extends EditText {
    a yie = new a(this);

    public interface b {
        void EX(int i);
    }

    public interface d {
        void cpI();
    }

    public static class a implements TextWatcher, OnKeyListener {
        private EditText kT;
        private String kav;
        int mIndex = 0;
        c yif;
        b yig;
        d yih;
        int yii = 4;

        public a(EditText editText) {
            this.kT = editText;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            int i = 0;
            this.kav = editable.toString();
            Object obj = "";
            if (this.yih != null) {
                this.yih.cpI();
            }
            int i2 = 0;
            while (i < this.kav.length()) {
                i2++;
                if (i2 > this.yii) {
                    break;
                }
                obj = obj + this.kav.charAt(i);
                i++;
            }
            if (i2 > this.yii) {
                this.kT.setText(obj);
                this.kT.setSelection(obj.length());
            }
            if (i2 >= this.yii && this.yif != null) {
                this.yif.EY(this.mIndex);
            }
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 67 && this.kT.getText().toString().trim().length() == 0 && this.yig != null) {
                this.yig.EX(this.mIndex);
            }
            return false;
        }
    }

    public interface c {
        void EY(int i);
    }

    public MMAutoSwitchEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addTextChangedListener(this.yie);
        setOnKeyListener(this.yie);
    }
}
