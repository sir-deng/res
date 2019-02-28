package com.tencent.d.b.d;

import com.tencent.d.a.c.c;
import com.tencent.d.a.c.e;
import com.tencent.d.a.c.f;
import com.tencent.d.b.f.g;

public final class b {
    int AlU;
    String AlV;
    boolean AlW;
    boolean AlX;
    private a AlY;
    private boolean AlZ;

    public static class a {
        public int AlU = 0;
        public String AlV = "";
        public boolean AlW = false;
        public boolean AlX = false;
        public a AlY = null;

        public final b cGX() {
            return new b(this.AlU, this.AlV, this.AlW, this.AlX, this.AlY, (byte) 0);
        }
    }

    /* synthetic */ b(int i, String str, boolean z, boolean z2, a aVar, byte b) {
        this(i, str, z, z2, aVar);
    }

    static /* synthetic */ void a(b bVar, e eVar) {
        if (!(bVar.AlY == null || bVar.AlZ)) {
            if (eVar == null) {
                bVar.AlY.onError(-1, "unknown");
            } else if (eVar.isSuccess()) {
                bVar.AlY.onSuccess();
            } else {
                bVar.AlY.onError(eVar.errCode, eVar.foE);
            }
        }
        bVar.AlZ = true;
    }

    private b(int i, String str, boolean z, boolean z2, a aVar) {
        this.AlU = 0;
        this.AlV = "";
        this.AlW = false;
        this.AlX = false;
        this.AlY = null;
        this.AlZ = false;
        this.AlU = i;
        this.AlV = str;
        this.AlW = z;
        this.AlX = z2;
        this.AlY = aVar;
    }

    public final void cGW() {
        g.cHd().A(new Runnable() {
            public final void run() {
                e cVar;
                b bVar = b.this;
                if ((bVar.AlU & 1) != 1) {
                    if ((bVar.AlU & 2) != 2) {
                        c.e("Soter.SoterKeyGenerateEngine", "soter: not specified purpose", new Object[0]);
                        cVar = new com.tencent.d.b.a.c(7, "not specified purpose. did you for get to call markGenAppSecureKey or/and markGenAuthKey?");
                    } else if (f.oN(bVar.AlV)) {
                        c.e("Soter.SoterKeyGenerateEngine", "soter: not pass auth key name", new Object[0]);
                        cVar = new com.tencent.d.b.a.c(1, "auth key name not specified");
                    }
                    if (!cVar.isSuccess()) {
                        b.a(b.this, cVar);
                    } else if (com.tencent.d.a.a.cGB()) {
                        c.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
                        b.a(b.this, new com.tencent.d.b.a.c(2));
                    } else {
                        if ((b.this.AlU & 1) == 1) {
                            c.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
                            if (b.this.AlW && com.tencent.d.a.a.cGE()) {
                                c.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
                                cVar = com.tencent.d.a.a.cGD();
                                if (!cVar.isSuccess()) {
                                    c.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", cVar.foE);
                                    b.a(b.this, cVar);
                                    return;
                                }
                            }
                            cVar = com.tencent.d.a.a.cGC();
                            if (cVar.isSuccess()) {
                                c.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", cVar.foE);
                                com.tencent.d.a.a.cGD();
                                b.a(b.this, cVar);
                                return;
                            }
                            c.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
                            b.a(b.this, cVar);
                        }
                        if ((b.this.AlU & 2) == 2) {
                            c.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", b.this.AlV);
                            if (com.tencent.d.a.a.cGF()) {
                                c.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
                                b.a(b.this, new com.tencent.d.b.a.c(3, "ASK not exists when generate auth key"));
                            }
                            if (b.this.AlX && com.tencent.d.a.a.acd(b.this.AlV)) {
                                c.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
                                cVar = com.tencent.d.a.a.bt(b.this.AlV, false);
                                if (!cVar.isSuccess()) {
                                    c.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", b.this.AlV, cVar.foE);
                                    b.a(b.this, cVar);
                                    return;
                                }
                            }
                            cVar = com.tencent.d.a.a.acc(b.this.AlV);
                            if (cVar.isSuccess()) {
                                c.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", b.this.AlV, cVar.foE);
                                com.tencent.d.a.a.bt(b.this.AlV, true);
                                b.a(b.this, cVar);
                                return;
                            }
                            c.i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
                            b.a(b.this, cVar);
                            return;
                        }
                    }
                }
                cVar = new com.tencent.d.b.a.c(0);
                if (!cVar.isSuccess()) {
                    b.a(b.this, cVar);
                } else if (com.tencent.d.a.a.cGB()) {
                    if ((b.this.AlU & 1) == 1) {
                        c.d("Soter.SoterKeyGenerateEngine", "soter: require generate ask. start gen", new Object[0]);
                        c.d("Soter.SoterKeyGenerateEngine", "soter: request regen ask. remove former one", new Object[0]);
                        cVar = com.tencent.d.a.a.cGD();
                        if (cVar.isSuccess()) {
                            c.w("Soter.SoterKeyGenerateEngine", "soter: remove ask failed: %s", cVar.foE);
                            b.a(b.this, cVar);
                            return;
                        }
                        cVar = com.tencent.d.a.a.cGC();
                        if (cVar.isSuccess()) {
                            c.i("Soter.SoterKeyGenerateEngine", "soter: generate ask success!", new Object[0]);
                            b.a(b.this, cVar);
                        } else {
                            c.w("Soter.SoterKeyGenerateEngine", "soter: generate ask failed: %s", cVar.foE);
                            com.tencent.d.a.a.cGD();
                            b.a(b.this, cVar);
                            return;
                        }
                    }
                    if ((b.this.AlU & 2) == 2) {
                        c.d("Soter.SoterKeyGenerateEngine", "soter: require generate auth key. start gen: %s", b.this.AlV);
                        if (com.tencent.d.a.a.cGF()) {
                            c.d("Soter.SoterKeyGenerateEngine", "soter: request regen auth key. remove former one", new Object[0]);
                            cVar = com.tencent.d.a.a.bt(b.this.AlV, false);
                            if (cVar.isSuccess()) {
                                c.w("Soter.SoterKeyGenerateEngine", "soter: remove auth key %s, failed: %s", b.this.AlV, cVar.foE);
                                b.a(b.this, cVar);
                                return;
                            }
                            cVar = com.tencent.d.a.a.acc(b.this.AlV);
                            if (cVar.isSuccess()) {
                                c.i("Soter.SoterKeyGenerateEngine", "soter: generate auth key success!", new Object[0]);
                                b.a(b.this, cVar);
                                return;
                            }
                            c.w("Soter.SoterKeyGenerateEngine", "soter: generate auth key %s failed: %s", b.this.AlV, cVar.foE);
                            com.tencent.d.a.a.bt(b.this.AlV, true);
                            b.a(b.this, cVar);
                            return;
                        }
                        c.w("Soter.SoterKeyGenerateEngine", "soter: no ask.", new Object[0]);
                        b.a(b.this, new com.tencent.d.b.a.c(3, "ASK not exists when generate auth key"));
                    }
                } else {
                    c.w("Soter.SoterKeyGenerateEngine", "soter: native not support soter", new Object[0]);
                    b.a(b.this, new com.tencent.d.b.a.c(2));
                }
            }
        });
    }
}
