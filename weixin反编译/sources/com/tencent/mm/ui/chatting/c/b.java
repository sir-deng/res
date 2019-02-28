package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.chatting.e.c;

public final class b {

    public interface a extends c<b> {
        String Xf();

        android.support.v7.widget.RecyclerView.a ZT(String str);

        g cve();

        void cvf();

        e cvg();

        com.tencent.mm.pluginsdk.ui.tools.p.a cvh();

        String cvi();

        <T extends h> T fN(Context context);

        int getType();
    }

    public interface b extends com.tencent.mm.ui.chatting.h.a<a> {
        void bo(String str, boolean z);

        void cvj();

        void onFinish();

        void z(boolean z, int i);
    }
}
