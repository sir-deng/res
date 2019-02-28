package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;

public final class o implements u {
    private long aig;
    private q alA;
    private int amN;
    private final i aoA = new i(new byte[10]);
    private boolean aoB;
    private boolean aoC;
    private boolean aoD;
    private int aoE;
    private int aoF;
    private boolean aoG;
    private final h aoz;
    private int state = 0;

    public o(h hVar) {
        this.aoz = hVar;
    }

    public final void a(q qVar, f fVar, d dVar) {
        this.alA = qVar;
        this.aoz.a(fVar, dVar);
    }

    public final void jy() {
        this.state = 0;
        this.amN = 0;
        this.aoD = false;
        this.aoz.jy();
    }

    public final void a(j jVar, boolean z) {
        if (z) {
            switch (this.state) {
                case 3:
                    if (this.aoF != -1) {
                        new StringBuilder("Unexpected start indicator: expected ").append(this.aoF).append(" more bytes");
                    }
                    this.aoz.jz();
                    break;
            }
            setState(1);
        }
        while (jVar.lG() > 0) {
            int i;
            switch (this.state) {
                case 0:
                    jVar.cV(jVar.lG());
                    break;
                case 1:
                    if (!a(jVar, this.aoA.data, 9)) {
                        break;
                    }
                    this.aoA.cR(0);
                    if (this.aoA.cT(24) != 1) {
                        this.aoF = -1;
                        i = 0;
                    } else {
                        this.aoA.cS(8);
                        i = this.aoA.cT(16);
                        this.aoA.cS(5);
                        this.aoG = this.aoA.lD();
                        this.aoA.cS(2);
                        this.aoB = this.aoA.lD();
                        this.aoC = this.aoA.lD();
                        this.aoA.cS(6);
                        this.aoE = this.aoA.cT(8);
                        if (i == 0) {
                            this.aoF = -1;
                        } else {
                            this.aoF = ((i + 6) - 9) - this.aoE;
                        }
                        boolean i2 = true;
                    }
                    setState(i2 != 0 ? 2 : 0);
                    break;
                case 2:
                    if (a(jVar, this.aoA.data, Math.min(10, this.aoE)) && a(jVar, null, this.aoE)) {
                        this.aoA.cR(0);
                        this.aig = -9223372036854775807L;
                        if (this.aoB) {
                            this.aoA.cS(4);
                            long cT = ((long) this.aoA.cT(3)) << 30;
                            this.aoA.cS(1);
                            cT |= (long) (this.aoA.cT(15) << 15);
                            this.aoA.cS(1);
                            cT |= (long) this.aoA.cT(15);
                            this.aoA.cS(1);
                            if (!this.aoD && this.aoC) {
                                this.aoA.cS(4);
                                long cT2 = ((long) this.aoA.cT(3)) << 30;
                                this.aoA.cS(1);
                                cT2 |= (long) (this.aoA.cT(15) << 15);
                                this.aoA.cS(1);
                                cT2 |= (long) this.aoA.cT(15);
                                this.aoA.cS(1);
                                this.alA.Q(cT2);
                                this.aoD = true;
                            }
                            this.aig = this.alA.Q(cT);
                        }
                        this.aoz.c(this.aig, this.aoG);
                        setState(3);
                        break;
                    }
                case 3:
                    int i3;
                    i2 = jVar.lG();
                    if (this.aoF == -1) {
                        i3 = 0;
                    } else {
                        i3 = i2 - this.aoF;
                    }
                    if (i3 > 0) {
                        i2 -= i3;
                        jVar.cU(jVar.position + i2);
                    }
                    this.aoz.b(jVar);
                    if (this.aoF == -1) {
                        break;
                    }
                    this.aoF -= i2;
                    if (this.aoF != 0) {
                        break;
                    }
                    this.aoz.jz();
                    setState(1);
                    break;
                default:
                    break;
            }
        }
    }

    private void setState(int i) {
        this.state = i;
        this.amN = 0;
    }

    private boolean a(j jVar, byte[] bArr, int i) {
        int min = Math.min(jVar.lG(), i - this.amN);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            jVar.cV(min);
        } else {
            jVar.readBytes(bArr, this.amN, min);
        }
        this.amN = min + this.amN;
        if (this.amN != i) {
            return false;
        }
        return true;
    }
}
