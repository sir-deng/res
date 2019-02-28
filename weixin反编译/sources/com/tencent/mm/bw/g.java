package com.tencent.mm.bw;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.mm.pluginsdk.ui.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bi;

public final class g implements d {
    private static g xtD;
    private int xtC = 300;

    private g() {
    }

    public static g chT() {
        if (xtD == null) {
            xtD = new g();
        }
        return xtD;
    }

    public final SpannableString b(Context context, CharSequence charSequence, int i) {
        if (charSequence == null || bi.oN(charSequence.toString())) {
            return new SpannableString("");
        }
        if (charSequence == null || bi.oN(charSequence.toString())) {
            return new SpannableString("");
        }
        SpannableString spannableString = charSequence instanceof SpannableString ? (SpannableString) charSequence : new SpannableString(charSequence);
        PInt pInt = new PInt();
        pInt.value = this.xtC;
        return f.chQ().a(b.chK().a(spannableString, i, pInt), i, pInt.value);
    }

    public final SpannableString a(Context context, CharSequence charSequence, float f) {
        if (charSequence == null || bi.oN(charSequence.toString())) {
            return new SpannableString("");
        }
        return b(context, charSequence, (int) f);
    }

    public final boolean x(CharSequence charSequence) {
        return f.chQ().WQ(charSequence.toString()) != null;
    }

    public final boolean w(CharSequence charSequence) {
        b.chK();
        return b.WO(charSequence.toString());
    }
}
