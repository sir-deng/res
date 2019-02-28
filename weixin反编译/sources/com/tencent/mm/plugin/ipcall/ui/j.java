package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.b;
import com.tencent.mm.plugin.ipcall.a.b.d;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.ipcall.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public final class j implements com.tencent.mm.plugin.ipcall.a.b.b.a, e {
    ImageView ikl;
    TextView ikq;
    DialPad nMK;
    String nPg;
    String nPh;
    String nPi;
    String nPj;
    int nPk;
    int nPl;
    public View nTA;
    ImageButton nTB;
    int nTC = -1;
    String nTD;
    IPCallTalkUI nTE;
    c nTF;
    a nTG;
    private long nTH;
    long nTI = -1;
    boolean nTJ = false;
    boolean nTK = false;
    private AudioManager nTL = null;
    boolean nTM = false;
    private boolean nTN = true;
    boolean nTO = false;
    Bitmap nTj;
    EditText nTs;
    TextView nTt;
    ImageView nTu;
    IPCallFuncButton nTv;
    IPCallFuncButton nTw;
    IPCallFuncButton nTx;
    ImageButton nTy;
    public TextView nTz;
    String nqW;

    public interface a {
        void gl(boolean z);
    }

    static /* synthetic */ void b(j jVar) {
        jVar.nTF.cM(0, 0);
        as.getNotification().cancel(42);
        jVar.nTE.finish();
    }

    public j(IPCallTalkUI iPCallTalkUI) {
        this.nTE = iPCallTalkUI;
        this.nTF = i.aUj();
        this.nTF.nHF = this;
    }

    private void f(String str, String str2, int i, String str3) {
        String str4;
        aVo();
        if (!bi.oN(str)) {
            str4 = str;
        } else if (bi.oN(str3)) {
            str4 = this.nTE.getString(R.l.eqK);
        } else {
            str4 = str3;
        }
        if (2 == i && str2 != null) {
            this.ikq.setText(str2);
        } else if (1 == i && str2 != null) {
            h.a(this.nTE, str2, str4, this.nTE.getString(R.l.eqL), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    j.this.nTE.finish();
                }
            });
        }
    }

    final void aVm() {
        i.aUh().fnF = this.nTE;
        Object aUh = i.aUh();
        aUh.nJT.nKk = aUh;
        d dVar = aUh.nJT;
        if (!dVar.kIB.xqv) {
            dVar.kIB.a(dVar);
            if (dVar.kIF.O(new Runnable() {
                public final void run() {
                    d.this.kIG = bi.Wz();
                }
            })) {
                dVar.kIG = 0;
            } else {
                dVar.kIG = -1;
            }
        }
        i.aUh().nJX = this;
        i.aUh().a(this);
    }

    final void aVn() {
        this.nTs.setKeyListener(null);
        this.nTs.setHorizontallyScrolling(true);
        this.nMK.setVisibility(4);
        DialPad dialPad = this.nMK;
        dialPad.nMC = true;
        for (DialNumberButton gg : dialPad.nMF.values()) {
            gg.gg(true);
        }
        for (View view : dialPad.nMH.values()) {
            if (dialPad.nMC) {
                view.setBackgroundDrawable(dialPad.getResources().getDrawable(R.e.btX));
            } else {
                view.setBackgroundDrawable(dialPad.getResources().getDrawable(R.e.bsb));
            }
        }
        if (!bi.oN(this.nTD)) {
            DE(this.nTD);
        }
        if (com.tencent.mm.compatible.util.d.fN(16)) {
            this.nTs.setTypeface(Typeface.create("sans-serif-light", 0));
            this.nTt.setTypeface(Typeface.create("sans-serif-light", 0));
        }
        if (!bi.oN(this.nPh)) {
            this.nTj = com.tencent.mm.plugin.ipcall.b.a.f(this.nTE, this.nPh, true);
        }
        if (this.nTj == null && !bi.oN(this.nPg) && com.tencent.mm.plugin.ipcall.b.a.NW()) {
            this.nTj = com.tencent.mm.plugin.ipcall.b.a.ao(this.nTE, this.nPg);
        }
        if (this.nTj == null && !bi.oN(this.nPj)) {
            this.nTj = b.c(this.nPj, 480, 480, 4);
        }
        if (this.nTj == null) {
            this.nTu.setVisibility(0);
            this.ikl.setVisibility(8);
        }
        if (this.nTj != null) {
            this.nTu.setVisibility(8);
            this.ikl.setVisibility(0);
            this.ikl.setImageBitmap(this.nTj);
        }
        this.nTB.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r6) {
                /*
                r5 = this;
                r0 = com.tencent.mm.plugin.ipcall.a.i.aUj();
                r1 = r0.mvg;
                monitor-enter(r1);
                r2 = com.tencent.mm.plugin.ipcall.a.i.aUi();	 Catch:{ all -> 0x005c }
                r2 = r2.aTY();	 Catch:{ all -> 0x005c }
                if (r2 == 0) goto L_0x005a;
            L_0x0011:
                r2 = r0.nHN;	 Catch:{ all -> 0x005c }
                if (r2 == 0) goto L_0x001a;
            L_0x0015:
                r0.aTF();	 Catch:{ all -> 0x005c }
                monitor-exit(r1);	 Catch:{ all -> 0x005c }
            L_0x0019:
                return;
            L_0x001a:
                r2 = 1;
                r0.nHN = r2;	 Catch:{ all -> 0x005c }
                r2 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x005c }
                r3 = com.tencent.mm.R.l.ewI;	 Catch:{ all -> 0x005c }
                r4 = 0;
                r2 = android.widget.Toast.makeText(r2, r3, r4);	 Catch:{ all -> 0x005c }
                r2.show();	 Catch:{ all -> 0x005c }
                r2 = new android.content.Intent;	 Catch:{ all -> 0x005c }
                r2.<init>();	 Catch:{ all -> 0x005c }
                r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
                r2.setFlags(r3);	 Catch:{ all -> 0x005c }
                r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x005c }
                r4 = com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI.class;
                r2.setClass(r3, r4);	 Catch:{ all -> 0x005c }
                r3 = "IPCallTalkUI_isFromMiniNotification";
                r4 = 1;
                r2.putExtra(r3, r4);	 Catch:{ all -> 0x005c }
                r3 = com.tencent.mm.plugin.voip.model.d.bGU();	 Catch:{ all -> 0x005c }
                r4 = r0.nHO;	 Catch:{ all -> 0x005c }
                r3.a(r2, r4);	 Catch:{ all -> 0x005c }
                r0.aTF();	 Catch:{ all -> 0x005c }
                r2 = r0.nHF;	 Catch:{ all -> 0x005c }
                if (r2 == 0) goto L_0x005a;
            L_0x0055:
                r0 = r0.nHF;	 Catch:{ all -> 0x005c }
                r0.aTN();	 Catch:{ all -> 0x005c }
            L_0x005a:
                monitor-exit(r1);	 Catch:{ all -> 0x005c }
                goto L_0x0019;
            L_0x005c:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x005c }
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.j.8.onClick(android.view.View):void");
            }
        });
        this.nTx.nQk = new com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a() {
            public final void gj(boolean z) {
                x.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", Boolean.valueOf(z));
                if (i.aUi().aTZ()) {
                    j.this.nTJ = z;
                    j.this.nTK = z;
                    i.aUh().ga(z);
                    g.pWK.h(12057, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
                } else if (!i.aUo().aiV() && !i.aUi().aUb()) {
                    i.aUo().ju(z);
                }
            }
        };
        this.nTv.nQk = new com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a() {
            public final void gj(boolean z) {
                if (i.aUi().aUa()) {
                    x.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", Boolean.valueOf(z));
                    com.tencent.mm.plugin.ipcall.a.c.a aUf = i.aUf();
                    int tv = z ? aUf.nKn.tv(412) : aUf.nKn.tv(413);
                    if (tv < 0) {
                        x.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:" + tv);
                    }
                    i.aUh().nJS.setMute(z);
                    g.pWK.h(12057, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                }
            }
        };
        this.nTw.nQk = new com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a() {
            public final void gj(boolean z) {
                j jVar;
                if (z) {
                    jVar = j.this;
                    if (jVar.nTj == null) {
                        jVar.ikl.setVisibility(8);
                    } else {
                        jVar.ikl.setVisibility(4);
                    }
                    jVar.ikl.setVisibility(8);
                    jVar.nTu.setVisibility(8);
                    jVar.nTs.setText("");
                    jVar.nTt.setText("");
                    jVar.nMK.setVisibility(0);
                } else {
                    jVar = j.this;
                    if (jVar.nTj != null) {
                        jVar.ikl.setVisibility(0);
                        jVar.nTu.setVisibility(8);
                    } else {
                        jVar.nTu.setVisibility(0);
                        jVar.ikl.setVisibility(8);
                    }
                    jVar.DE(jVar.nTD);
                    jVar.nMK.setVisibility(4);
                }
                g.pWK.h(12057, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
            }
        };
        this.nTy.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                j.b(j.this);
            }
        });
        this.nMK.nMI = new com.tencent.mm.plugin.ipcall.ui.DialPad.a() {
            public final void Dn(String str) {
                String obj = j.this.nTs.getText().toString();
                if (bi.oN(obj)) {
                    j.this.nTI = System.currentTimeMillis();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j.this.nTI >= 3000) {
                    obj = obj + " ";
                }
                obj = obj + str;
                j.this.nTI = currentTimeMillis;
                j.this.df(obj, "");
                c.De(str);
                g.pWK.h(12057, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            }

            public final void Do(String str) {
            }
        };
    }

    final void DE(String str) {
        if (bi.oN(this.nqW)) {
            df(com.tencent.mm.plugin.ipcall.b.a.DO(str), "");
        } else {
            df(this.nqW, com.tencent.mm.plugin.ipcall.b.a.DO(str));
        }
    }

    final void df(String str, String str2) {
        this.nTs.setText(str);
        if (!bi.oN(str)) {
            this.nTs.setSelection(this.nTs.getText().length() - 1);
        }
        this.nTt.setText(str2);
    }

    public final void rY(int i) {
        switch (i) {
            case 3:
                int i2 = i.aUe().nIw.nJu;
                Context context = ad.getContext();
                r0 = ((i2 & 1) <= 0 || (i2 & 2) > 0) ? (i2 & 8) > 0 ? context.getString(R.l.esz) + " " : "" : context.getString(R.l.esy) + " ";
                if (this.nTC != -1) {
                    String rZ = com.tencent.mm.plugin.ipcall.b.a.rZ(this.nTC);
                    this.ikq.setText(r0 + this.nTE.getString(R.l.erE, new Object[]{rZ}));
                    return;
                }
                this.ikq.setText(r0 + this.nTE.getString(R.l.erD));
                return;
            case 5:
                this.ikq.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(this.nTH / 60), Long.valueOf(this.nTH % 60)}));
                return;
            case 10:
                this.ikq.setText(R.l.erG);
                return;
            default:
                return;
        }
    }

    public final void aTw() {
        int i = 0;
        x.i("MicroMsg.TalkUIController", "onInviteSuccess");
        String str = i.aUe().nIw.nJG;
        String str2 = i.aUe().nIw.nJH;
        if (!(bi.oN(str) || bi.oN(str2) || str.equals(str2))) {
            x.i("MicroMsg.TalkUIController", "toPhoneNumber:%s,serverRetPhoneNumber:%s", str, str2);
            DE(str2);
        }
        x.i("MicroMsg.TalkUIController", "callFlag:" + i.aUe().nIw.nJu);
        int i2 = i.aUe().nIw.nJu;
        if ((i2 & 1) > 0 && (i2 & 2) > 0 && (i2 & 8) <= 0) {
            i = 1;
        }
        if (i != 0) {
            x.i("MicroMsg.TalkUIController", "isNotFree");
            h.a(this.nTE, R.l.erM, R.l.erN, R.l.erL, R.l.erK, true, null, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
                    j.b(j.this);
                }
            });
        }
        rY(3);
    }

    public final void aTx() {
        x.d("MicroMsg.TalkUIController", "onStartRing");
        if (i.aUi().aTZ()) {
            this.nTJ = this.nTx.isChecked();
            this.nTK = this.nTx.isChecked();
            i.aUh().ga(this.nTx.isChecked());
        }
    }

    public final void aTL() {
        x.d("MicroMsg.TalkUIController", "onUserAccept");
        if (i.aUi().aTZ()) {
            this.nTJ = this.nTx.isChecked();
            this.nTK = this.nTx.isChecked();
            i.aUh().ga(this.nTx.isChecked());
        }
        if (i.aUi().aUa()) {
            i.aUh().nJS.setMute(this.nTv.isChecked());
        }
    }

    public final void aTM() {
        x.d("MicroMsg.TalkUIController", "onOthersideShutdown");
        aVo();
        rY(10);
        as.getNotification().cancel(42);
        if (this.nTG != null) {
            this.nTG.gl(true);
        }
    }

    public final void d(int i, String str, String str2, int i2) {
        x.d("MicroMsg.TalkUIController", "onError, error: %d", Integer.valueOf(i));
        if (i2 == 1) {
            this.nTN = false;
        }
        if (i == 8) {
            if (i2 == 1) {
                String string;
                if (bi.oN(str)) {
                    string = this.nTE.getString(R.l.eqK);
                } else {
                    string = str;
                }
                h.a(this.nTE, str2, string, this.nTE.getString(R.l.eqL), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        j.this.nTE.finish();
                    }
                });
            } else {
                f(str, str2, i2, this.nTE.getString(R.l.eqJ));
            }
        } else if (i != 10) {
            f(str, str2, i2, null);
        } else {
            f(str, str2, i2, null);
        }
        as.getNotification().cancel(42);
        if (this.nTG != null && !this.nTO) {
            this.nTG.gl(this.nTN);
        }
    }

    public final void gd(boolean z) {
        x.d("MicroMsg.TalkUIController", "onHeadsetPlugStateChange, isPlugged: %b", Boolean.valueOf(z));
        if (!i.aUi().aTZ()) {
            return;
        }
        if (z) {
            i.aUh();
            this.nTJ = com.tencent.mm.plugin.ipcall.a.b.a.xX();
            i.aUh().ga(false);
            this.nTx.gi(false);
            return;
        }
        i.aUh().ga(this.nTJ);
        this.nTx.gi(true);
        this.nTx.setChecked(this.nTJ);
    }

    public final void ge(boolean z) {
        x.d("MicroMsg.TalkUIController", "onBluetoothPlugStateChange, isPlugged: %b", Boolean.valueOf(z));
        if (!i.aUi().aTZ()) {
            return;
        }
        if (z) {
            i.aUh();
            this.nTK = com.tencent.mm.plugin.ipcall.a.b.a.xX();
            i.aUh().ga(false);
            this.nTx.gi(false);
            return;
        }
        i.aUh().ga(this.nTK);
        this.nTx.gi(true);
        this.nTx.setChecked(this.nTK);
    }

    public final void aTO() {
        this.nTH = (long) i.aUj().aTH();
        rY(5);
    }

    public final void aTN() {
        this.nTE.finish();
    }

    public final void aVo() {
        if (this.nTz != null) {
            this.nTz.setVisibility(4);
        }
        if (this.nTA != null) {
            this.nTA.setVisibility(4);
        }
    }
}
