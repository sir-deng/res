package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.d.a.a;
import com.tencent.d.a.c.b;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.f;
import com.tencent.d.a.c.g;
import com.tencent.d.b.e.d;
import java.nio.charset.Charset;

public class i extends d {
    private static final String AmU = ("soter_triggered_oom" + f.s(a.cGH().getBytes(Charset.forName("UTF-8"))));
    private boolean AmV = false;
    private String AmW = "";
    private g.a AmX = new g.a() {
        @SuppressLint({"ApplySharedPref"})
        public final void cGO() {
            c.w("Soter.TaskInit", "soter: on trigger OOM, using wrapper implement", new Object[0]);
            SharedPreferences cGT = com.tencent.d.b.b.a.cGQ().cGT();
            if (cGT != null) {
                Editor edit = cGT.edit();
                edit.putBoolean(i.AmU, true);
                edit.commit();
            }
        }

        public final boolean cGN() {
            SharedPreferences cGT = com.tencent.d.b.b.a.cGQ().cGT();
            if (cGT == null) {
                return false;
            }
            c.i("Soter.TaskInit", "soter: is triggered OOM: %b", Boolean.valueOf(cGT.getBoolean(i.AmU, false)));
            return cGT.getBoolean(i.AmU, false);
        }
    };
    private d Amp;
    private String Amq = "";
    private int[] Amr;

    static /* synthetic */ void c(i iVar) {
        SharedPreferences cGT = com.tencent.d.b.b.a.cGQ().cGT();
        c.d("Soter.TaskInit", "soter: ask status: %d", Integer.valueOf(cGT.getInt(com.tencent.d.a.c.d.cGL().Aly, 0)));
        if (Iu(cGT.getInt(com.tencent.d.a.c.d.cGL().Aly, 0)) && a.cGE()) {
            a.cGD();
        }
        for (int i : iVar.Amr) {
            String str = (String) com.tencent.d.b.b.a.cGQ().cGS().get(i, "");
            if (!f.oN(str)) {
                c.d("Soter.TaskInit", "soter: %s status: %d", str, Integer.valueOf(cGT.getInt(str, 0)));
                if (Iu(cGT.getInt(str, 0)) && a.acd(str)) {
                    a.bt(str, false);
                }
            }
        }
    }

    public i(Context context, e eVar) {
        boolean z = false;
        b bVar = eVar.Ams;
        if (bVar != null) {
            c.a(bVar);
        }
        com.tencent.d.b.b.a cGQ = com.tencent.d.b.b.a.cGQ();
        SharedPreferences sharedPreferences = context.getSharedPreferences("soter_status", 0);
        synchronized (com.tencent.d.b.b.a.class) {
            cGQ.AlQ = sharedPreferences;
        }
        g.a(this.AmX);
        a.setUp();
        if (a.cGB() && a.ie(context)) {
            z = true;
        }
        this.AmV = z;
        this.Amp = eVar.Amp;
        this.Amr = eVar.Amr;
        this.Amq = eVar.Amq;
        this.AmW = eVar.Amt;
    }

    final boolean cGZ() {
        int[] iArr = this.Amr;
        int i = (iArr == null || iArr.length <= 0) ? 1 : 0;
        if (i != 0) {
            c.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
            b(new com.tencent.d.b.a.d(27, "no business scene provided"));
            return true;
        }
        if (f.oM(this.Amq).length() > 16) {
            c.w("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
            String s = f.s(this.Amq.getBytes(Charset.forName("UTF-8")));
            s = (f.oN(s) || s.length() < 16) ? null : s.substring(0, 16);
            if (f.oN(s)) {
                c.w("Soter.TaskInit", "soter: saltlen compat failed!!", new Object[0]);
                b(new com.tencent.d.b.a.d(28, "the account salt length is too long"));
                return true;
            }
            this.Amq = s;
        }
        if (f.oN(this.AmW) || this.AmW.length() <= 24) {
            if (this.Amp == null) {
                c.w("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
            }
            if (!f.oN(this.AmW)) {
                c.i("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
                com.tencent.d.a.c.d.cGL().Aly = this.AmW;
            }
            g.cHd().A(new Runnable() {
                public final void run() {
                    i.this.b(i.this.Amq, i.this.Amr);
                    i.c(i.this);
                }
            });
            return false;
        }
        c.e("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
        b(new com.tencent.d.b.a.d(29, "the passed ask name is too long (larger than 24)"));
        return true;
    }

    final void cHa() {
    }

    final void execute() {
        if (!this.AmV) {
            b(new com.tencent.d.b.a.d(2));
            synchronized (com.tencent.d.b.b.a.class) {
                com.tencent.d.b.b.a.cGQ().oc(false);
                com.tencent.d.b.b.a.cGQ().cGR();
            }
        } else if (this.Amp == null) {
            com.tencent.d.b.b.a.cGQ().oc(true);
            com.tencent.d.b.b.a.cGQ().cGR();
            b(new com.tencent.d.b.a.d(0));
        } else {
            this.Amp.br(new d.a(a.cGH()));
            this.Amp.a(new com.tencent.d.b.e.b<d.b>() {
                public final /* synthetic */ void cz(Object obj) {
                    c.i("Soter.TaskInit", "soter: got support tag from backend: %b", Boolean.valueOf(((d.b) obj).fJK));
                    synchronized (com.tencent.d.b.b.a.class) {
                        com.tencent.d.b.b.a.cGQ().oc(r6.fJK);
                        com.tencent.d.b.b.a.cGQ().cGR();
                    }
                    i.this.b(new com.tencent.d.b.a.d(0));
                }
            });
            this.Amp.execute();
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void b(String str, int[] iArr) {
        for (int put : iArr) {
            com.tencent.d.b.b.a.cGQ().cGS().put(put, String.format("%suid%d_%s_scene%d", new Object[]{"Wechat", Integer.valueOf(Process.myUid()), f.oM(str), Integer.valueOf(iArr[r0])}));
        }
    }

    private static boolean Iu(int i) {
        return i == 2 || i == 1;
    }
}
