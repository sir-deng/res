package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.SpannableString;

public interface d {

    public static class a {
        protected static d vBb;

        public static final void a(d dVar) {
            vBb = dVar;
        }
    }

    SpannableString b(Context context, CharSequence charSequence, int i);

    boolean w(CharSequence charSequence);

    boolean x(CharSequence charSequence);
}
