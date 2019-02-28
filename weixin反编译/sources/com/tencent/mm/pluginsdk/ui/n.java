package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.bw.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;

public final class n {
    private Context mContext;
    private SpannableStringBuilder vsA = new SpannableStringBuilder();
    private CharacterStyle vsB = new ForegroundColorSpan(-5066062);
    private int vsC;
    private int vsD;
    public int vsE = 3;
    private StringBuilder vsx;
    private SpannableStringBuilder vsy = new SpannableStringBuilder();
    private SpannableString vsz;

    public n(Context context) {
        this.mContext = context;
    }

    public final void a(MMEditText mMEditText, String str, boolean z) {
        if (mMEditText != null) {
            if (this.vsx == null) {
                throw new IllegalStateException("You should saveHistory before setText");
            }
            int length = this.vsC + str.length();
            this.vsy.clear();
            this.vsA.clear();
            if (z) {
                CharSequence charSequence;
                this.vsz = g.chT().a(this.mContext, this.vsx.subSequence(0, this.vsC), mMEditText.getTextSize());
                SpannableStringBuilder append = this.vsy.append(this.vsz);
                SpannableStringBuilder spannableStringBuilder = this.vsA;
                if (spannableStringBuilder == null || str == null || str.length() == 0) {
                    charSequence = spannableStringBuilder;
                } else {
                    int length2;
                    int i;
                    if (str.length() < this.vsE) {
                        length2 = str.length();
                        i = 0;
                    } else {
                        length2 = str.length();
                        i = length2 - this.vsE;
                    }
                    spannableStringBuilder.append(str).setSpan(this.vsB, i, length2, 33);
                    Object charSequence2 = spannableStringBuilder;
                }
                append.append(charSequence2).append(this.vsx.subSequence(this.vsD, this.vsx.length()));
            } else {
                this.vsz = g.chT().a(this.mContext, str, mMEditText.getTextSize());
                this.vsy.append(this.vsz);
            }
            x.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", Integer.valueOf(this.vsC), Integer.valueOf(this.vsD), Integer.valueOf(length), Integer.valueOf(this.vsy.length()), str, this.vsy);
            mMEditText.setText(this.vsy);
            if (length > this.vsy.length()) {
                return;
            }
            if (length == 0) {
                mMEditText.setSelection(this.vsy.length());
            } else {
                mMEditText.setSelection(length);
            }
        }
    }

    public final void a(MMEditText mMEditText) {
        if (mMEditText != null) {
            this.vsE = 0;
            this.vsz = g.chT().a(this.mContext, mMEditText.getText().toString(), mMEditText.getTextSize());
            x.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", this.vsz);
            mMEditText.setText(this.vsz);
            mMEditText.setSelection(this.vsz.length());
        }
    }

    public final void b(MMEditText mMEditText) {
        if (mMEditText != null) {
            this.vsC = mMEditText.getSelectionStart();
            this.vsD = mMEditText.getSelectionEnd();
            this.vsx = new StringBuilder(mMEditText.getText());
            x.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", Integer.valueOf(this.vsC), Integer.valueOf(this.vsD), this.vsx);
            if (mMEditText.getText().toString().equalsIgnoreCase("")) {
                this.vsy.clear();
            }
        }
    }
}
