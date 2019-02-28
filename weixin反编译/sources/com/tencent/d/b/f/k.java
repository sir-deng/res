package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import com.tencent.d.a.a;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.f;
import com.tencent.d.a.c.h;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.e;

public final class k extends c {
    String AlV = null;
    private boolean Ana = false;
    e And = null;
    private e Ane = null;
    private boolean Anf = false;
    private int itU = -1;

    /* renamed from: com.tencent.d.b.f.k$3 */
    class AnonymousClass3 implements b<e.b> {
        final /* synthetic */ h Anh;

        AnonymousClass3(h hVar) {
            this.Anh = hVar;
        }

        public final /* synthetic */ void cz(Object obj) {
            e.b bVar = (e.b) obj;
            c.dL(k.this.AlV, 0);
            c.i("Soter.TaskPrepareAuthKey", "soter: auth key upload result: %b", Boolean.valueOf(bVar.Ame));
            if (bVar.Ame) {
                k.this.b(new com.tencent.d.b.a.c(this.Anh));
                return;
            }
            a.bt(k.this.AlV, false);
            k.this.b(new com.tencent.d.b.a.c(10, String.format("upload auth key: %s failed", new Object[]{k.this.AlV})));
        }
    }

    public k(int i, e eVar, e eVar2, boolean z, boolean z2) {
        this.itU = i;
        this.And = eVar;
        this.Ana = z;
        this.Anf = true;
        this.Ane = eVar2;
    }

    @SuppressLint({"DefaultLocale"})
    final boolean cGZ() {
        if (!com.tencent.d.b.b.a.cGQ().isInit()) {
            c.w("Soter.TaskPrepareAuthKey", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.d.b.a.c(14));
            return true;
        } else if (com.tencent.d.b.b.a.cGQ().cGP()) {
            this.AlV = (String) com.tencent.d.b.b.a.cGQ().cGS().get(this.itU, "");
            if (f.oN(this.AlV)) {
                c.w("Soter.TaskPrepareAuthKey", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                b(new com.tencent.d.b.a.c(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.itU)})));
                return true;
            }
            boolean cGF = a.cGF();
            if (!cGF && a.acd(this.AlV)) {
                c.w("Soter.TaskPrepareAuthKey", "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
                a.bt(this.AlV, false);
            }
            if (!cGF && !this.Anf) {
                c.w("Soter.TaskPrepareAuthKey", "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
                b(new com.tencent.d.b.a.c(3));
                return true;
            } else if (a.acd(this.AlV) && !a.ace(this.AlV)) {
                c.w("Soter.TaskPrepareAuthKey", "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
                return false;
            } else if (!a.acd(this.AlV) || this.Ana) {
                if (this.And == null) {
                    c.w("Soter.TaskPrepareAuthKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
                }
                return false;
            } else {
                c.i("Soter.TaskPrepareAuthKey", "soter: already has key. do not need generate again", new Object[0]);
                b(new com.tencent.d.b.a.c(a.acf(this.AlV)));
                return true;
            }
        } else {
            c.w("Soter.TaskPrepareAuthKey", "soter: not support soter", new Object[0]);
            b(new com.tencent.d.b.a.c(2));
            return true;
        }
    }

    final void cHa() {
        c.w("Soter.TaskPrepareAuthKey", "soter: cancelled prepare authkey: %s", this.AlV);
        a.bt(this.AlV, false);
    }

    final void execute() {
        if (a.cGF() || !this.Anf) {
            cHg();
            return;
        }
        c.d("Soter.TaskPrepareAuthKey", "soter: ask not found, but required to generate it. start generate", new Object[0]);
        com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.c>() {
            public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                com.tencent.d.b.a.c cVar = (com.tencent.d.b.a.c) eVar;
                c.d("Soter.TaskPrepareAuthKey", "soter: prepare ask end: %s", cVar.toString());
                if (cVar.errCode == 0) {
                    k.this.cHg();
                } else {
                    k.this.b(cVar);
                }
            }
        }, false, this.Ane);
    }

    private void cHg() {
        c.dL(this.AlV, 1);
        com.tencent.d.b.d.b.a aVar = new com.tencent.d.b.d.b.a();
        String str = this.AlV;
        boolean z = this.Ana;
        aVar.AlV = str;
        aVar.AlX = z;
        aVar.AlU |= 2;
        aVar.AlY = new com.tencent.d.b.d.a() {
            public final void onError(int i, String str) {
                c.w("Soter.TaskPrepareAuthKey", "soter: auth key %s generate failed. errcode: %d, errmsg: %s", k.this.AlV, Integer.valueOf(i), str);
                c.dL(k.this.AlV, 0);
                k.this.b(new com.tencent.d.b.a.c(i, str));
            }

            public final void onSuccess() {
                c.i("Soter.TaskPrepareAuthKey", "soter: auth key generate successfully. start upload", new Object[0]);
                if (k.this.And != null) {
                    c.dL(k.this.AlV, 2);
                } else {
                    c.dL(k.this.AlV, 0);
                }
                k kVar = k.this;
                h acf = a.acf(kVar.AlV);
                if (acf == null) {
                    c.e("Soter.TaskPrepareAuthKey", "soter: auth key model is null even after generation. fatal error", new Object[0]);
                    a.bt(kVar.AlV, false);
                    kVar.b(new com.tencent.d.b.a.c(12, "auth key model is null even after generation."));
                } else if (kVar.And != null) {
                    kVar.And.br(new e.a(acf.signature, acf.AlD));
                    kVar.And.a(new AnonymousClass3(acf));
                    kVar.And.execute();
                } else {
                    c.d("Soter.TaskPrepareAuthKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
                    kVar.b(new com.tencent.d.b.a.c("treat as normal because you do not provide the net wrapper", acf));
                }
            }
        };
        aVar.cGX().cGW();
    }
}
