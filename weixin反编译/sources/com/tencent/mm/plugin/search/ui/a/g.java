package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class g extends com.tencent.mm.plugin.fts.d.a.b {
    CharSequence qkf;
    private b qkg = new b();
    a qkh = new a();

    private class a extends com.tencent.mm.plugin.fts.d.a.b.a {
        TextView ikM;

        private a() {
            super();
        }

        /* synthetic */ a(g gVar, byte b) {
            this();
        }
    }

    private class b extends com.tencent.mm.plugin.fts.d.a.b.b {
        private b() {
            super();
        }

        /* synthetic */ b(g gVar, byte b) {
            this();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.diX, viewGroup, false);
            a aVar = g.this.qkh;
            aVar.ikM = (TextView) inflate.findViewById(R.h.caU);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            e.a(g.this.qkf, ((a) aVar).ikM);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
            Intent intent = new Intent();
            intent.putExtra("query_phrase_list", bi.F(g.this.mRM.mRn));
            intent.putExtra("go_to_chatroom_direct", true);
            intent.putExtra("scene_from", 3);
            d.a(context, ".ui.transmit.MMCreateChatroomUI", intent);
            return true;
        }
    }

    public g(int i) {
        super(17, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (Object obj : this.mRM.mRn) {
            CharSequence spannableString = new SpannableString(obj);
            spannableString.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.fts.d.d.a.mUn), 0, obj.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append("、");
        }
        this.qkf = TextUtils.concat(new CharSequence[]{context.getString(R.l.eJF), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(R.l.eJE)});
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.qkg;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b.a adH() {
        return this.qkh;
    }
}
