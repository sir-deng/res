package com.tencent.d.b.f;

import com.tencent.d.a.a;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.d;
import com.tencent.d.a.c.h;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.e;

public final class j extends c {
    e AmZ = null;
    private boolean Ana = false;

    /* renamed from: com.tencent.d.b.f.j$2 */
    class AnonymousClass2 implements b<e.b> {
        final /* synthetic */ h Anc;

        AnonymousClass2(h hVar) {
            this.Anc = hVar;
        }

        public final /* synthetic */ void cz(Object obj) {
            e.b bVar = (e.b) obj;
            c.dL(d.cGL().Aly, 0);
            c.i("Soter.TaskPrepareAppSecureKey", "soter: ask upload result: %b", Boolean.valueOf(bVar.Ame));
            if (bVar.Ame) {
                j.this.b(new com.tencent.d.b.a.c(this.Anc));
                return;
            }
            a.cGD();
            j.this.b(new com.tencent.d.b.a.c(9, "upload app secure key failed"));
        }
    }

    public j(e eVar, boolean z) {
        this.AmZ = eVar;
        this.Ana = z;
    }

    final boolean cGZ() {
        if (!com.tencent.d.b.b.a.cGQ().isInit()) {
            c.w("Soter.TaskPrepareAppSecureKey", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.d.b.a.c(14));
            return true;
        } else if (!com.tencent.d.b.b.a.cGQ().cGP()) {
            c.w("Soter.TaskPrepareAppSecureKey", "soter: not support soter", new Object[0]);
            b(new com.tencent.d.b.a.c(2));
            return true;
        } else if (!a.cGF() || this.Ana) {
            if (this.AmZ == null) {
                c.w("Soter.TaskPrepareAppSecureKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
            }
            return false;
        } else {
            c.i("Soter.TaskPrepareAppSecureKey", "soter: already has ask. do not need generate again", new Object[0]);
            b(new com.tencent.d.b.a.c(a.cGG()));
            return true;
        }
    }

    final void cHa() {
        c.w("Soter.TaskPrepareAppSecureKey", "soter: cancelled prepare ask", new Object[0]);
        a.cGD();
    }

    final void execute() {
        c.dL(d.cGL().Aly, 1);
        com.tencent.d.b.d.b.a aVar = new com.tencent.d.b.d.b.a();
        boolean z = this.Ana;
        aVar.AlU |= 1;
        aVar.AlW = z;
        aVar.AlY = new com.tencent.d.b.d.a() {
            public final void onError(int i, String str) {
                c.w("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate failed. errcode: %d, errmsg: %s", Integer.valueOf(i), str);
                c.dL(d.cGL().Aly, 0);
                j.this.b(new com.tencent.d.b.a.c(i, str));
            }

            public final void onSuccess() {
                c.i("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate successfully. start upload ask", new Object[0]);
                if (j.this.AmZ != null) {
                    c.dL(d.cGL().Aly, 2);
                } else {
                    c.dL(d.cGL().Aly, 0);
                }
                j jVar = j.this;
                h cGG = a.cGG();
                if (cGG == null) {
                    c.e("Soter.TaskPrepareAppSecureKey", "soter: ask model is null even after generation. fatal error", new Object[0]);
                    a.cGD();
                    jVar.b(new com.tencent.d.b.a.c(3, "ask model is null even after generation."));
                } else if (jVar.AmZ != null) {
                    jVar.AmZ.br(new e.a(cGG.signature, cGG.AlD));
                    jVar.AmZ.a(new AnonymousClass2(cGG));
                    jVar.AmZ.execute();
                } else {
                    c.d("Soter.TaskPrepareAppSecureKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
                    jVar.b(new com.tencent.d.b.a.c("treat as normal because you do not provide the net wrapper", cGG));
                }
            }
        };
        aVar.cGX().cGW();
    }
}
