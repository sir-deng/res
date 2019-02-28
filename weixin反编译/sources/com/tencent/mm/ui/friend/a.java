package com.tencent.mm.ui.friend;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.LinkedList;

public final class a implements OnClickListener {
    private Context context;
    private a zlp;

    public interface a {
        void aau(String str);

        void bq(String str, boolean z);
    }

    public static class b {
        public int pnn;
        public int position;
        public String username;
    }

    static /* synthetic */ void Z(x xVar) {
        com.tencent.mm.k.a xVar2;
        if (((int) xVar2.gKO) == 0) {
            as.Hm();
            c.Ff().T(xVar2);
            if (!bi.oN(xVar2.field_username)) {
                as.Hm();
                xVar2 = c.Ff().Xv(xVar2.field_username);
            } else {
                return;
            }
        }
        if (((int) xVar2.gKO) <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.AddContactListener", "addContact : insert contact failed");
        } else {
            s.p(xVar2);
        }
    }

    public a(Context context, a aVar) {
        this.context = context;
        this.zlp = aVar;
    }

    public final void onClick(View view) {
        b bVar = (b) view.getTag();
        final String str = bVar.username;
        int i = bVar.pnn;
        final int i2 = bVar.position;
        as.Hm();
        final ag Xv = c.Ff().Xv(str);
        if (bi.oN(Xv.field_username)) {
            Xv.setUsername(str);
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
            public final void a(boolean z, boolean z2, String str, String str2) {
                if (z) {
                    a.Z(Xv);
                    a.this.zlp.aau(str);
                    return;
                }
                a.this.zlp.bq(str, z2);
            }
        });
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i));
        aVar.c(str, linkedList);
    }
}
