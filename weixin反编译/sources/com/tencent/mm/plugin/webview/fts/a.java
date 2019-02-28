package com.tencent.mm.plugin.webview.fts;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    private static final a trS = new a();
    public Map<Integer, g> trQ = new HashMap();
    private c trR;

    /* renamed from: com.tencent.mm.plugin.webview.fts.a$1 */
    class AnonymousClass1 implements com.tencent.mm.ui.base.p.a {
        final /* synthetic */ List mxU;

        public AnonymousClass1(List list) {
            this.mxU = list;
        }

        public final void a(ImageView imageView, MenuItem menuItem) {
            com.tencent.mm.ap.a.a.PN().a(((z) this.mxU.get(menuItem.getItemId())).iconUrl, imageView, a.this.trR);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.a$2 */
    class AnonymousClass2 implements p.c {
        final /* synthetic */ List mxU;
        final /* synthetic */ g nfU;

        public AnonymousClass2(List list, g gVar) {
            this.mxU = list;
            this.nfU = gVar;
        }

        public final void a(n nVar) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mxU.size()) {
                    z zVar = (z) this.mxU.get(i2);
                    nVar.a(i2, zVar.title, zVar.desc);
                    if (zVar.nAl) {
                        this.nfU.zCD = i2;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.a$3 */
    class AnonymousClass3 implements d {
        final /* synthetic */ a trU;
        final /* synthetic */ int val$id;

        public AnonymousClass3(a aVar, int i) {
            this.trU = aVar;
            this.val$id = i;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            x.v("FTSSearchActionSheetMgr", "selected pos %d", Integer.valueOf(i));
            if (this.trU != null) {
                this.trU.ej(i, this.val$id);
            }
            a.this.trQ.remove(Integer.valueOf(this.val$id));
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.a$4 */
    class AnonymousClass4 implements com.tencent.mm.ui.widget.g.a {
        final /* synthetic */ a trU;
        final /* synthetic */ int val$id;

        public AnonymousClass4(a aVar, int i) {
            this.trU = aVar;
            this.val$id = i;
        }

        public final void onDismiss() {
            x.v("FTSSearchActionSheetMgr", "selected pos %d", Integer.valueOf(-1));
            if (this.trU != null) {
                this.trU.ej(-1, this.val$id);
            }
            a.this.trQ.remove(Integer.valueOf(this.val$id));
        }
    }

    public interface a {
        void ej(int i, int i2);
    }

    public static a bPR() {
        return trS;
    }

    private a() {
        com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
        aVar.hFl = true;
        aVar.hFk = true;
        this.trR = aVar.PQ();
    }
}
