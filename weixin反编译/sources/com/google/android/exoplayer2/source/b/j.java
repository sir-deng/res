package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.h.q;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.h.r.c;
import com.google.android.exoplayer2.h.r.d;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.h.b;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

final class j implements f, com.google.android.exoplayer2.h.r.a<com.google.android.exoplayer2.source.a.a>, d, b, com.google.android.exoplayer2.source.j {
    m acV;
    final int ach;
    boolean adD;
    private final com.google.android.exoplayer2.h.b asj;
    private final int atN;
    final com.google.android.exoplayer2.source.a.a atO;
    private final a aua;
    final c aub;
    private final Format auc;
    final r aud = new r("Loader:HlsSampleStreamWrapper");
    private final c.b aue = new c.b();
    final LinkedList<f> auf = new LinkedList();
    private final Runnable aug = new Runnable() {
        public final void run() {
            j.this.kE();
        }
    };
    h[] auh = new h[0];
    private int[] aui = new int[0];
    boolean auj;
    int auk;
    Format aul;
    int aum;
    int aun;
    private boolean auo;
    boolean[] aup;
    private boolean[] auq;
    long aur;
    private long aus;
    boolean aut;
    boolean auu;
    boolean auv;
    final Handler handler = new Handler();
    boolean released;

    public interface a extends com.google.android.exoplayer2.source.j.a<j> {
        void a(com.google.android.exoplayer2.source.b.a.a.a aVar);

        void hY();
    }

    public final /* synthetic */ int a(c cVar, long j, long j2, IOException iOException) {
        com.google.android.exoplayer2.source.a.a aVar = (com.google.android.exoplayer2.source.a.a) cVar;
        boolean z = aVar instanceof f;
        Object obj = (!z || aVar.kq() == 0) ? 1 : null;
        boolean z2 = false;
        c cVar2 = this.aub;
        if (obj != null) {
            boolean z3;
            e eVar = cVar2.atk;
            int indexOf = cVar2.atk.indexOf(cVar2.atb.j(aVar.asI));
            if (com.google.android.exoplayer2.source.a.b.a(iOException)) {
                boolean f = eVar.f(indexOf, 60000);
                int i = ((q.e) iOException).responseCode;
                if (f) {
                    new StringBuilder("Blacklisted: duration=60000").append(", responseCode=").append(i).append(", format=").append(eVar.cN(indexOf));
                } else {
                    new StringBuilder("Blacklisting failed (cannot blacklist last enabled track): responseCode=").append(i).append(", format=").append(eVar.cN(indexOf));
                }
                z3 = f;
            } else {
                z3 = false;
            }
            if (z3) {
                obj = 1;
                if (obj != null) {
                    if (z) {
                        com.google.android.exoplayer2.i.a.ap(((f) this.auf.removeLast()) != aVar);
                        if (this.auf.isEmpty()) {
                            this.aus = this.aur;
                        }
                    }
                    z2 = true;
                }
                this.atO.a(aVar.asH, aVar.type, this.ach, aVar.asI, aVar.asJ, aVar.asK, aVar.asL, aVar.asM, j, j2, aVar.kq(), iOException, z2);
                if (z2) {
                    return 0;
                }
                if (this.adD) {
                    C(this.aur);
                } else {
                    this.aua.a(this);
                }
                return 2;
            }
        }
        obj = null;
        if (obj != null) {
            if (z) {
                if (((f) this.auf.removeLast()) != aVar) {
                }
                com.google.android.exoplayer2.i.a.ap(((f) this.auf.removeLast()) != aVar);
                if (this.auf.isEmpty()) {
                    this.aus = this.aur;
                }
            }
            z2 = true;
        }
        this.atO.a(aVar.asH, aVar.type, this.ach, aVar.asI, aVar.asJ, aVar.asK, aVar.asL, aVar.asM, j, j2, aVar.kq(), iOException, z2);
        if (z2) {
            return 0;
        }
        if (this.adD) {
            this.aua.a(this);
        } else {
            C(this.aur);
        }
        return 2;
    }

    public final /* synthetic */ void a(c cVar, long j, long j2) {
        com.google.android.exoplayer2.source.a.a aVar = (com.google.android.exoplayer2.source.a.a) cVar;
        c cVar2 = this.aub;
        if (aVar instanceof a) {
            a aVar2 = (a) aVar;
            cVar2.ate = aVar2.data;
            cVar2.a(aVar2.asH.uri, aVar2.atl, aVar2.atm);
        }
        this.atO.a(aVar.asH, aVar.type, this.ach, aVar.asI, aVar.asJ, aVar.asK, aVar.asL, aVar.asM, j, j2, aVar.kq());
        if (this.adD) {
            this.aua.a(this);
            return;
        }
        C(this.aur);
    }

    public final /* synthetic */ void a(c cVar, long j, long j2, boolean z) {
        com.google.android.exoplayer2.source.a.a aVar = (com.google.android.exoplayer2.source.a.a) cVar;
        this.atO.b(aVar.asH, aVar.type, this.ach, aVar.asI, aVar.asJ, aVar.asK, aVar.asL, aVar.asM, j, j2, aVar.kq());
        if (!z) {
            kD();
            if (this.auk > 0) {
                this.aua.a(this);
            }
        }
    }

    public final /* synthetic */ k ck(int i) {
        return cG(i);
    }

    public j(int i, a aVar, c cVar, com.google.android.exoplayer2.h.b bVar, long j, Format format, int i2, com.google.android.exoplayer2.source.a.a aVar2) {
        this.ach = i;
        this.aua = aVar;
        this.aub = cVar;
        this.asj = bVar;
        this.auc = format;
        this.atN = i2;
        this.atO = aVar2;
        this.aur = j;
        this.aus = j;
    }

    public final void kB() {
        if (!this.adD) {
            C(this.aur);
        }
    }

    public final boolean e(long j, boolean z) {
        this.aur = j;
        if (!(z || kF())) {
            boolean z2;
            int length = this.auh.length;
            int i = 0;
            while (i < length) {
                h hVar = this.auh[i];
                hVar.rewind();
                if (!hVar.d(j, false) && (this.auq[i] || !this.auo)) {
                    z2 = false;
                    break;
                }
                hVar.H(hVar.asl.kl());
                i++;
            }
            z2 = true;
            if (z2) {
                return false;
            }
        }
        this.aus = j;
        this.auv = false;
        this.auf.clear();
        if (this.aud.id()) {
            this.aud.lz();
        } else {
            kD();
        }
        return true;
    }

    public final long kb() {
        if (this.auv) {
            return Long.MIN_VALUE;
        }
        if (kF()) {
            return this.aus;
        }
        long max;
        long j = this.aur;
        f fVar = (f) this.auf.getLast();
        if (!fVar.atL) {
            fVar = this.auf.size() > 1 ? (f) this.auf.get(this.auf.size() - 2) : null;
        }
        if (fVar != null) {
            max = Math.max(j, fVar.asM);
        } else {
            max = j;
        }
        h[] hVarArr = this.auh;
        int length = hVarArr.length;
        int i = 0;
        while (i < length) {
            long max2 = Math.max(max, hVarArr[i].asl.kj());
            i++;
            max = max2;
        }
        return max;
    }

    public final void kC() {
        kD();
    }

    public final void ak(boolean z) {
        this.aub.atd = z;
    }

    final void kd() {
        this.aud.kd();
        c cVar = this.aub;
        if (cVar.atf != null) {
            throw cVar.atf;
        } else if (cVar.atg != null) {
            cVar.ata.c(cVar.atg);
        }
    }

    final void kD() {
        for (h hVar : this.auh) {
            boolean z = this.aut;
            g gVar = hVar.asl;
            gVar.length = 0;
            gVar.asa = 0;
            gVar.asb = 0;
            gVar.asc = 0;
            gVar.asf = true;
            gVar.asd = Long.MIN_VALUE;
            gVar.ase = Long.MIN_VALUE;
            if (z) {
                gVar.ash = null;
                gVar.asg = true;
            }
            a aVar = hVar.asn;
            if (aVar.asx) {
                com.google.android.exoplayer2.h.a[] aVarArr = new com.google.android.exoplayer2.h.a[((hVar.asp.asx ? 1 : 0) + (((int) (hVar.asp.asw - aVar.asw)) / hVar.ask))];
                for (int i = 0; i < aVarArr.length; i++) {
                    aVarArr[i] = aVar.asy;
                    aVar = aVar.ko();
                }
                hVar.asj.a(aVarArr);
            }
            hVar.asn = new a(0, hVar.ask);
            hVar.aso = hVar.asn;
            hVar.asp = hVar.asn;
            hVar.ano = 0;
            hVar.asj.ln();
        }
        this.aut = false;
    }

    public final boolean C(long r28) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Unknown predecessor block by arg (r19_0 com.google.android.exoplayer2.i.q) in PHI: PHI: (r19_1 com.google.android.exoplayer2.i.q) = (r19_0 com.google.android.exoplayer2.i.q), (r19_2 com.google.android.exoplayer2.i.q) binds: {(r19_0 com.google.android.exoplayer2.i.q)=B:90:0x026c, (r19_2 com.google.android.exoplayer2.i.q)=B:111:0x0371}
	at jadx.core.dex.instructions.PhiInsn.replaceArg(PhiInsn.java:78)
	at jadx.core.dex.visitors.ModVisitor.processInvoke(ModVisitor.java:222)
	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:83)
	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:68)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:32)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
	at java.lang.Iterable.forEach(Iterable.java:75)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
*/
        /*
        r27 = this;
        r0 = r27;
        r2 = r0.auv;
        if (r2 != 0) goto L_0x0010;
    L_0x0006:
        r0 = r27;
        r2 = r0.aud;
        r2 = r2.id();
        if (r2 == 0) goto L_0x0012;
    L_0x0010:
        r2 = 0;
    L_0x0011:
        return r2;
    L_0x0012:
        r0 = r27;
        r0 = r0.aub;
        r22 = r0;
        r0 = r27;
        r2 = r0.auf;
        r2 = r2.isEmpty();
        if (r2 == 0) goto L_0x00e6;
    L_0x0022:
        r20 = 0;
    L_0x0024:
        r0 = r27;
        r2 = r0.aus;
        r4 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0037;
    L_0x0031:
        r0 = r27;
        r0 = r0.aus;
        r28 = r0;
    L_0x0037:
        r0 = r27;
        r0 = r0.aue;
        r24 = r0;
        if (r20 != 0) goto L_0x00f4;
    L_0x003f:
        r2 = -1;
        r3 = r2;
    L_0x0041:
        r2 = 0;
        r0 = r22;
        r0.atg = r2;
        if (r20 == 0) goto L_0x0059;
    L_0x0048:
        r6 = 0;
        r0 = r22;
        r2 = r0.ath;
        if (r2 == 0) goto L_0x0103;
    L_0x0050:
        r0 = r20;
        r4 = r0.asM;
    L_0x0054:
        r4 = r4 - r28;
        java.lang.Math.max(r6, r4);
    L_0x0059:
        r0 = r22;
        r2 = r0.atk;
        r2.kv();
        r0 = r22;
        r2 = r0.atk;
        r7 = r2.lj();
        if (r3 == r7) goto L_0x0109;
    L_0x006a:
        r2 = 1;
        r4 = r2;
    L_0x006c:
        r0 = r22;
        r2 = r0.asZ;
        r6 = r2[r7];
        r0 = r22;
        r2 = r0.ata;
        r2 = r2.avA;
        r2 = r2.get(r6);
        r2 = (com.google.android.exoplayer2.source.b.a.e.a) r2;
        r5 = r2.avL;
        if (r5 == 0) goto L_0x010d;
    L_0x0082:
        r8 = android.os.SystemClock.elapsedRealtime();
        r10 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r5 = r2.avL;
        r12 = r5.aes;
        r12 = com.google.android.exoplayer2.b.j(r12);
        r10 = java.lang.Math.max(r10, r12);
        r5 = r2.avL;
        r5 = r5.auM;
        if (r5 != 0) goto L_0x00af;
    L_0x009a:
        r5 = r2.avL;
        r5 = r5.auF;
        r12 = 2;
        if (r5 == r12) goto L_0x00af;
    L_0x00a1:
        r5 = r2.avL;
        r5 = r5.auF;
        r12 = 1;
        if (r5 == r12) goto L_0x00af;
    L_0x00a8:
        r12 = r2.avM;
        r10 = r10 + r12;
        r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x010d;
    L_0x00af:
        r2 = 1;
    L_0x00b0:
        if (r2 != 0) goto L_0x010f;
    L_0x00b2:
        r0 = r24;
        r0.atp = r6;
        r0 = r22;
        r0.atg = r6;
    L_0x00ba:
        r0 = r27;
        r2 = r0.aue;
        r2 = r2.ato;
        r0 = r27;
        r3 = r0.aue;
        r12 = r3.atn;
        r0 = r27;
        r3 = r0.aue;
        r3 = r3.atp;
        r0 = r27;
        r4 = r0.aue;
        r4.clear();
        if (r2 == 0) goto L_0x02e4;
    L_0x00d5:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r0 = r27;
        r0.aus = r2;
        r2 = 1;
        r0 = r27;
        r0.auv = r2;
        r2 = 1;
        goto L_0x0011;
    L_0x00e6:
        r0 = r27;
        r2 = r0.auf;
        r2 = r2.getLast();
        r2 = (com.google.android.exoplayer2.source.b.f) r2;
        r20 = r2;
        goto L_0x0024;
    L_0x00f4:
        r0 = r22;
        r2 = r0.atb;
        r0 = r20;
        r3 = r0.asI;
        r2 = r2.j(r3);
        r3 = r2;
        goto L_0x0041;
    L_0x0103:
        r0 = r20;
        r4 = r0.asL;
        goto L_0x0054;
    L_0x0109:
        r2 = 0;
        r4 = r2;
        goto L_0x006c;
    L_0x010d:
        r2 = 0;
        goto L_0x00b0;
    L_0x010f:
        r0 = r22;
        r2 = r0.ata;
        r5 = r2.b(r6);
        r2 = r5.auL;
        r0 = r22;
        r0.ath = r2;
        if (r20 == 0) goto L_0x0121;
    L_0x011f:
        if (r4 == 0) goto L_0x01a4;
    L_0x0121:
        if (r20 != 0) goto L_0x014d;
    L_0x0123:
        r2 = r5.auM;
        if (r2 != 0) goto L_0x0161;
    L_0x0127:
        r8 = r5.kG();
        r2 = (r28 > r8 ? 1 : (r28 == r8 ? 0 : -1));
        if (r2 < 0) goto L_0x0161;
    L_0x012f:
        r2 = r5.auJ;
        r3 = r5.auP;
        r3 = r3.size();
        r16 = r2 + r3;
        r9 = r5;
        r8 = r6;
        r5 = r7;
    L_0x013c:
        r2 = r9.auJ;
        r0 = r16;
        if (r0 >= r2) goto L_0x01ae;
    L_0x0142:
        r2 = new com.google.android.exoplayer2.source.b;
        r2.<init>();
        r0 = r22;
        r0.atf = r2;
        goto L_0x00ba;
    L_0x014d:
        r0 = r22;
        r2 = r0.ath;
        if (r2 == 0) goto L_0x015a;
    L_0x0153:
        r0 = r20;
        r0 = r0.asM;
        r28 = r0;
        goto L_0x0123;
    L_0x015a:
        r0 = r20;
        r0 = r0.asL;
        r28 = r0;
        goto L_0x0123;
    L_0x0161:
        r4 = r5.auP;
        r8 = r5.asL;
        r8 = r28 - r8;
        r8 = java.lang.Long.valueOf(r8);
        r0 = r22;
        r2 = r0.ata;
        r2 = r2.avH;
        if (r2 == 0) goto L_0x0175;
    L_0x0173:
        if (r20 != 0) goto L_0x01a2;
    L_0x0175:
        r2 = 1;
    L_0x0176:
        r2 = com.google.android.exoplayer2.i.t.a(r4, r8, r2);
        r4 = r5.auJ;
        r2 = r2 + r4;
        r4 = r5.auJ;
        if (r2 >= r4) goto L_0x0379;
    L_0x0181:
        if (r20 == 0) goto L_0x0379;
    L_0x0183:
        r0 = r22;
        r2 = r0.asZ;
        r5 = r2[r3];
        r0 = r22;
        r2 = r0.ata;
        r4 = r2.b(r5);
        r0 = r20;
        r2 = r0.asP;
        r2 = r2 + 1;
        r25 = r4;
        r4 = r5;
        r5 = r3;
        r3 = r25;
    L_0x019d:
        r16 = r2;
        r9 = r3;
        r8 = r4;
        goto L_0x013c;
    L_0x01a2:
        r2 = 0;
        goto L_0x0176;
    L_0x01a4:
        r0 = r20;
        r2 = r0.asP;
        r16 = r2 + 1;
        r9 = r5;
        r8 = r6;
        r5 = r7;
        goto L_0x013c;
    L_0x01ae:
        r2 = r9.auJ;
        r2 = r16 - r2;
        r3 = r9.auP;
        r3 = r3.size();
        if (r2 < r3) goto L_0x01cf;
    L_0x01ba:
        r2 = r9.auM;
        if (r2 == 0) goto L_0x01c5;
    L_0x01be:
        r2 = 1;
        r0 = r24;
        r0.ato = r2;
        goto L_0x00ba;
    L_0x01c5:
        r0 = r24;
        r0.atp = r8;
        r0 = r22;
        r0.atg = r8;
        goto L_0x00ba;
    L_0x01cf:
        r3 = r9.auP;
        r2 = r3.get(r2);
        r14 = r2;
        r14 = (com.google.android.exoplayer2.source.b.a.b.a) r14;
        r2 = r14.ami;
        if (r2 == 0) goto L_0x02ce;
    L_0x01dc:
        r2 = r9.auW;
        r3 = r14.auS;
        r2 = com.google.android.exoplayer2.i.s.j(r2, r3);
        r0 = r22;
        r3 = r0.ati;
        r3 = r2.equals(r3);
        if (r3 != 0) goto L_0x0221;
    L_0x01ee:
        r9 = r14.auT;
        r0 = r22;
        r3 = r0.atk;
        r6 = r3.kx();
        r0 = r22;
        r3 = r0.atk;
        r7 = r3.ky();
        r4 = new com.google.android.exoplayer2.h.i;
        r3 = 1;
        r4.<init>(r2, r3);
        r2 = new com.google.android.exoplayer2.source.b.c$a;
        r0 = r22;
        r3 = r0.asX;
        r0 = r22;
        r8 = r0.asZ;
        r5 = r8[r5];
        r5 = r5.aeo;
        r0 = r22;
        r8 = r0.ate;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9);
        r0 = r24;
        r0.atn = r2;
        goto L_0x00ba;
    L_0x0221:
        r3 = r14.auT;
        r0 = r22;
        r4 = r0.atj;
        r3 = com.google.android.exoplayer2.i.t.h(r3, r4);
        if (r3 != 0) goto L_0x0238;
    L_0x022d:
        r3 = r14.auT;
        r0 = r22;
        r4 = r0.aiR;
        r0 = r22;
        r0.a(r2, r3, r4);
    L_0x0238:
        r2 = 0;
        r6 = r9.auO;
        if (r6 == 0) goto L_0x0375;
    L_0x023d:
        r2 = r9.auW;
        r3 = r6.url;
        r3 = com.google.android.exoplayer2.i.s.j(r2, r3);
        r2 = new com.google.android.exoplayer2.h.i;
        r4 = r6.auU;
        r6 = r6.auV;
        r2.<init>(r3, r4, r6);
        r23 = r2;
    L_0x0250:
        r2 = r9.asL;
        r4 = r14.auR;
        r12 = r2 + r4;
        r2 = r9.auI;
        r3 = r14.auQ;
        r17 = r2 + r3;
        r0 = r22;
        r3 = r0.asY;
        r2 = r3.aux;
        r0 = r17;
        r2 = r2.get(r0);
        r2 = (com.google.android.exoplayer2.i.q) r2;
        if (r2 != 0) goto L_0x0371;
    L_0x026c:
        r19 = new com.google.android.exoplayer2.i.q;
        r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r0 = r19;
        r0.<init>(r4);
        r2 = r3.aux;
        r0 = r17;
        r1 = r19;
        r2.put(r0, r1);
    L_0x0281:
        r2 = r9.auW;
        r3 = r14.url;
        r3 = com.google.android.exoplayer2.i.s.j(r2, r3);
        r2 = new com.google.android.exoplayer2.h.i;
        r4 = r14.auU;
        r6 = r14.auV;
        r2.<init>(r3, r4, r6);
        r4 = new com.google.android.exoplayer2.source.b.f;
        r0 = r22;
        r5 = r0.asW;
        r0 = r22;
        r9 = r0.atc;
        r0 = r22;
        r3 = r0.atk;
        r10 = r3.kx();
        r0 = r22;
        r3 = r0.atk;
        r11 = r3.ky();
        r6 = r14.aes;
        r14 = r12 + r6;
        r0 = r22;
        r0 = r0.atd;
        r18 = r0;
        r0 = r22;
        r0 = r0.aiR;
        r21 = r0;
        r0 = r22;
        r0 = r0.asT;
        r22 = r0;
        r6 = r2;
        r7 = r23;
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22);
        r0 = r24;
        r0.atn = r4;
        goto L_0x00ba;
    L_0x02ce:
        r2 = 0;
        r0 = r22;
        r0.ati = r2;
        r2 = 0;
        r0 = r22;
        r0.aiR = r2;
        r2 = 0;
        r0 = r22;
        r0.atj = r2;
        r2 = 0;
        r0 = r22;
        r0.asT = r2;
        goto L_0x0238;
    L_0x02e4:
        if (r12 != 0) goto L_0x02f2;
    L_0x02e6:
        if (r3 == 0) goto L_0x02ef;
    L_0x02e8:
        r0 = r27;
        r2 = r0.aua;
        r2.a(r3);
    L_0x02ef:
        r2 = 0;
        goto L_0x0011;
    L_0x02f2:
        r2 = r12 instanceof com.google.android.exoplayer2.source.b.f;
        if (r2 == 0) goto L_0x0338;
    L_0x02f6:
        r2 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r0 = r27;
        r0.aus = r2;
        r2 = r12;
        r2 = (com.google.android.exoplayer2.source.b.f) r2;
        r0 = r27;
        r2.atK = r0;
        r4 = r2.uid;
        r5 = r2.atB;
        r0 = r27;
        r0.aum = r4;
        r0 = r27;
        r6 = r0.auh;
        r7 = r6.length;
        r3 = 0;
    L_0x0314:
        if (r3 >= r7) goto L_0x031f;
    L_0x0316:
        r8 = r6[r3];
        r8 = r8.asl;
        r8.asi = r4;
        r3 = r3 + 1;
        goto L_0x0314;
    L_0x031f:
        if (r5 == 0) goto L_0x0331;
    L_0x0321:
        r0 = r27;
        r4 = r0.auh;
        r5 = r4.length;
        r3 = 0;
    L_0x0327:
        if (r3 >= r5) goto L_0x0331;
    L_0x0329:
        r6 = r4[r3];
        r7 = 1;
        r6.asu = r7;
        r3 = r3 + 1;
        goto L_0x0327;
    L_0x0331:
        r0 = r27;
        r3 = r0.auf;
        r3.add(r2);
    L_0x0338:
        r0 = r27;
        r2 = r0.aud;
        r0 = r27;
        r3 = r0.atN;
        r0 = r27;
        r14 = r2.a(r12, r0, r3);
        r0 = r27;
        r3 = r0.atO;
        r4 = r12.asH;
        r5 = r12.type;
        r0 = r27;
        r6 = r0.ach;
        r7 = r12.asI;
        r8 = r12.asJ;
        r9 = r12.asK;
        r10 = r12.asL;
        r12 = r12.asM;
        r2 = r3.ars;
        if (r2 == 0) goto L_0x036e;
    L_0x0360:
        r0 = r3.handler;
        r16 = r0;
        r2 = new com.google.android.exoplayer2.source.a$a$1;
        r2.<init>(r4, r5, r6, r7, r8, r9, r10, r12, r14);
        r0 = r16;
        r0.post(r2);
    L_0x036e:
        r2 = 1;
        goto L_0x0011;
    L_0x0371:
        r19 = r2;
        goto L_0x0281;
    L_0x0375:
        r23 = r2;
        goto L_0x0250;
    L_0x0379:
        r3 = r5;
        r4 = r6;
        r5 = r7;
        goto L_0x019d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.j.C(long):boolean");
    }

    public final long kc() {
        if (kF()) {
            return this.aus;
        }
        return this.auv ? Long.MIN_VALUE : ((f) this.auf.getLast()).asM;
    }

    public final h cG(int i) {
        int length = this.auh.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.aui[i2] == i) {
                return this.auh[i2];
            }
        }
        h hVar = new h(this.asj);
        hVar.asv = this;
        this.aui = Arrays.copyOf(this.aui, length + 1);
        this.aui[length] = i;
        this.auh = (h[]) Arrays.copyOf(this.auh, length + 1);
        this.auh[length] = hVar;
        return hVar;
    }

    public final void jv() {
        this.auj = true;
        this.handler.post(this.aug);
    }

    public final void kp() {
        this.handler.post(this.aug);
    }

    final void kE() {
        if (!this.released && !this.adD && this.auj) {
            h[] hVarArr = this.auh;
            int length = hVarArr.length;
            int i = 0;
            while (i < length) {
                if (hVarArr[i].asl.ki() != null) {
                    i++;
                } else {
                    return;
                }
            }
            int length2 = this.auh.length;
            int i2 = 0;
            i = -1;
            boolean z = false;
            while (i2 < length2) {
                String str = this.auh[i2].asl.ki().adV;
                boolean z2 = com.google.android.exoplayer2.i.g.aa(str) ? true : com.google.android.exoplayer2.i.g.Z(str) ? true : com.google.android.exoplayer2.i.g.ab(str);
                if (z2 > z) {
                    i = i2;
                } else if (z2 != z || i == -1) {
                    z2 = z;
                } else {
                    i = -1;
                    z2 = z;
                }
                i2++;
                z = z2;
            }
            l lVar = this.aub.atb;
            int i3 = lVar.length;
            this.aun = -1;
            this.aup = new boolean[length2];
            this.auq = new boolean[length2];
            l[] lVarArr = new l[length2];
            for (int i4 = 0; i4 < length2; i4++) {
                Format ki = this.auh[i4].asl.ki();
                String str2 = ki.adV;
                boolean z3 = com.google.android.exoplayer2.i.g.aa(str2) || com.google.android.exoplayer2.i.g.Z(str2);
                this.auq[i4] = z3;
                this.auo = z3 | this.auo;
                if (i4 == i) {
                    Format[] formatArr = new Format[i3];
                    for (i2 = 0; i2 < i3; i2++) {
                        formatArr[i2] = a(lVar.arZ[i2], ki);
                    }
                    lVarArr[i4] = new l(formatArr);
                    this.aun = i4;
                } else {
                    Format format = (z && com.google.android.exoplayer2.i.g.Z(ki.adV)) ? this.auc : null;
                    lVarArr[i4] = new l(a(format, ki));
                }
            }
            this.acV = new m(lVarArr);
            this.adD = true;
            this.aua.hY();
        }
    }

    final void k(int i, boolean z) {
        int i2 = 1;
        com.google.android.exoplayer2.i.a.ap(this.aup[i] != z);
        this.aup[i] = z;
        int i3 = this.auk;
        if (!z) {
            i2 = -1;
        }
        this.auk = i3 + i2;
    }

    private static Format a(Format format, Format format2) {
        if (format == null) {
            return format2;
        }
        String str = null;
        int ad = com.google.android.exoplayer2.i.g.ad(format2.adV);
        if (ad == 1) {
            str = i(format.adS, 1);
        } else if (ad == 2) {
            str = i(format.adS, 2);
        }
        return new Format(format.id, format2.adU, format2.adV, str, format.bitrate, format2.adW, format.width, format.height, format2.adZ, format2.aea, format2.aeb, format2.aed, format2.aec, format2.aee, format2.aef, format2.sampleRate, format2.aeg, format2.aeh, format2.aei, format.aek, format.ael, format2.aem, format2.aej, format2.adX, format2.adY, format2.adT);
    }

    final boolean kF() {
        return this.aus != -9223372036854775807L;
    }

    private static String i(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : split) {
            if (i == com.google.android.exoplayer2.i.g.ad(com.google.android.exoplayer2.i.g.ac(str2))) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(str2);
            }
        }
        if (stringBuilder.length() > 0) {
            return stringBuilder.toString();
        }
        return null;
    }
}
