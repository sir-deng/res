package com.tencent.mm.plugin.favorite.ui.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.protocal.c.vp;

public final class o extends a {
    public o(h hVar) {
        super(hVar);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        return new View(viewGroup.getContext());
    }

    public final void a(View view, vp vpVar) {
        if (view != null) {
            Toast.makeText(view.getContext(), R.l.ehd, 0).show();
        }
    }
}
