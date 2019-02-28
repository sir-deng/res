package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.bx.h;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public interface c extends f {

    public interface a {
        void a(c cVar, c cVar2);
    }

    public static class b {
        public long hBI;
        public String name;
        public a[] ouw;
        public int oux;

        private static class a {
            public long ouy;
            public long ouz;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public b(int i, String str, a[] aVarArr) {
            boolean z;
            boolean z2 = true;
            Assert.assertTrue(str.length() > 0);
            this.name = str;
            if (aVarArr.length == 2) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            Assert.assertTrue(aVarArr[0].ouz >= aVarArr[0].ouy);
            Assert.assertTrue(aVarArr[1].ouz >= aVarArr[1].ouy);
            if (aVarArr[1].ouy < aVarArr[0].ouz) {
                z2 = false;
            }
            Assert.assertTrue(z2);
            this.ouw = aVarArr;
            this.oux = i;
            this.hBI = aVarArr[0].ouy;
        }

        public final synchronized void bac() {
            if (this.hBI == this.ouw[0].ouz) {
                this.hBI = this.ouw[1].ouy;
                d.pVE.a(111, 251, 1, false);
            } else {
                this.hBI++;
            }
            if (!com.tencent.mm.sdk.a.b.cfz()) {
                x.i("MicroMsg.MsgTable", "incMsgLocalId %d  ", Long.valueOf(this.hBI));
            }
        }

        public final boolean dN(long j) {
            for (a aVar : this.ouw) {
                boolean z = j >= aVar.ouy && j <= aVar.ouz;
                if (z) {
                    return true;
                }
            }
            return false;
        }

        public static a[] a(long j, long j2, long j3, long j4) {
            a[] aVarArr = new a[2];
            a aVar = new a();
            aVar.ouy = j;
            aVar.ouz = j2;
            aVarArr[0] = aVar;
            aVar = new a();
            aVar.ouy = j3;
            aVar.ouz = j4;
            aVarArr[1] = aVar;
            return aVarArr;
        }
    }

    public static class c {
        public long kMn;
        public String ouA;
        public ArrayList<au> ouB;
        public int ouC;
        public int ouD;
        public int ouE;
        public long ouF;
        public String talker;

        public c(String str, String str2, au auVar) {
            this(str, str2, auVar, 0);
        }

        public c(String str, String str2, au auVar, int i) {
            long j = -1;
            this.ouB = new ArrayList();
            this.ouD = 0;
            this.ouE = 0;
            this.ouF = 0;
            this.kMn = -1;
            this.talker = str;
            this.ouA = str2;
            this.ouC = i;
            if (auVar != null) {
                j = auVar.field_bizChatId;
            }
            this.kMn = j;
            if (auVar != null) {
                this.ouB.add(auVar);
            }
        }

        public c(String str, String str2, au auVar, int i, byte b) {
            this(str, str2, auVar, 0);
            this.ouE = i;
        }

        public static boolean T(au auVar) {
            return auVar != null && auVar.field_isSend == 0 && auVar.field_status == 3;
        }
    }

    Cursor D(String str, String str2, int i);

    void EZ(String str);

    void F(String str, long j);

    au FA(String str);

    int FB(String str);

    List<au> FC(String str);

    long FD(String str);

    void Fa(String str);

    Cursor Fb(String str);

    au Fc(String str);

    au Fd(String str);

    au Fe(String str);

    au Ff(String str);

    List<au> Fg(String str);

    Cursor Fh(String str);

    void Fi(String str);

    int Fj(String str);

    boolean Fk(String str);

    int Fl(String str);

    Cursor Fm(String str);

    Cursor Fn(String str);

    com.tencent.mm.storage.au.c Fo(String str);

    au.d Fp(String str);

    com.tencent.mm.storage.au.a Fq(String str);

    com.tencent.mm.storage.au.b Fr(String str);

    int Fs(String str);

    boolean Ft(String str);

    int Fu(String str);

    int Fv(String str);

    String Fw(String str);

    long Fx(String str);

    long Fy(String str);

    long Fz(String str);

    au G(String str, long j);

    void G(ArrayList<Long> arrayList);

    au H(String str, long j);

    au I(String str, long j);

    List<au> J(String str, long j);

    List<au> K(String str, long j);

    au L(String str, long j);

    au M(String str, long j);

    List<au> N(String str, int i, int i2);

    boolean N(String str, long j);

    long O(String str, long j);

    Cursor O(String str, int i, int i2);

    int P(au auVar);

    int P(String str, long j);

    int Q(String str, long j);

    long Q(au auVar);

    int R(String str, long j);

    void R(au auVar);

    int S(au auVar);

    String S(String str, long j);

    au T(String str, long j);

    au U(String str, long j);

    long V(String str, long j);

    long W(String str, long j);

    Cursor a(String str, long j, long j2, boolean z);

    void a(long j, au auVar);

    void a(h hVar, String str);

    void a(a aVar);

    void a(a aVar, Looper looper);

    void a(b bVar);

    void a(c cVar);

    void a(e eVar);

    boolean a(long j, String str, String str2, String str3);

    h aZR();

    void aZS();

    void aZT();

    void aZU();

    ArrayList<au> aZV();

    List<au> aZW();

    Cursor aZX();

    Cursor aZY();

    String aZZ();

    long b(au auVar, boolean z);

    Cursor b(String str, long j, long j2, int i);

    void b(long j, au auVar);

    void b(String str, String str2, String[] strArr);

    Cursor bA(String str, int i);

    Cursor bB(String str, int i);

    int bC(String str, int i);

    Cursor bD(String str, int i);

    Cursor bE(String str, int i);

    int bF(String str, int i);

    Cursor bG(String str, int i);

    au[] bH(String str, int i);

    Cursor bI(String str, int i);

    String baa();

    List<au> bab();

    List<au> by(String str, int i);

    List<au> bz(String str, int i);

    int c(String str, long j, int i);

    List<au> c(String str, long j, boolean z);

    Cursor d(String str, long j, int i);

    au dI(long j);

    int dJ(long j);

    boolean dK(long j);

    boolean dL(long j);

    void dM(long j);

    au dr(String str, String str2);

    Cursor ds(String str, String str2);

    int dt(String str, String str2);

    LinkedList<au> du(String str, String str2);

    Cursor e(String str, int i, long j);

    Cursor f(String str, int i, long j);

    Cursor g(String str, int i, long j);

    Cursor l(String str, long j, long j2);

    int m(String str, long j, long j2);

    int n(String str, long j, long j2);

    Cursor o(String str, long j, long j2);

    int p(String str, long j, long j2);

    Cursor q(String str, long j, long j2);

    au sM(int i);
}
