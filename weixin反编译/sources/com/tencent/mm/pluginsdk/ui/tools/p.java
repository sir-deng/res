package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.mm.bf.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.p.b;

public final class p extends com.tencent.mm.ui.tools.p {
    private VoiceSearchLayout qia;
    public boolean vFI = true;
    int vFJ;
    int vFK;
    a vFL;
    private com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.a vFM = new com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.a() {
        public final void cbz() {
            if (!com.tencent.mm.o.a.aW(ad.getContext()) && !com.tencent.mm.o.a.aU(ad.getContext())) {
                x.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
                g.pWK.h(10453, Integer.valueOf(p.this.vFJ), Integer.valueOf(3));
                if (p.this.vFL != null) {
                    p.this.vFL.asZ();
                }
            }
        }

        public final void cbA() {
            x.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
            g.pWK.h(10453, Integer.valueOf(p.this.vFJ), Integer.valueOf(4));
            if (p.this.zvv != null) {
                p.this.zvv.nx(true);
                p.this.zvv.ny(true);
            }
            if (p.this.vFL != null) {
                p.this.vFL.ata();
            }
        }

        public final void a(boolean z, String[] strArr, long j) {
            x.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", Boolean.valueOf(z), Long.valueOf(j));
            if (p.this.vFL != null) {
                p.this.vFL.a(z, strArr, j, p.this.vFK);
            }
        }
    };

    public interface a extends b {
        void a(boolean z, String[] strArr, long j, int i);

        void asZ();

        void ata();
    }

    public p(byte b) {
        super(true, true);
    }

    public final void a(a aVar) {
        this.vFL = aVar;
        this.zvw = aVar;
    }

    public final void o(VoiceSearchLayout voiceSearchLayout) {
        this.qia = voiceSearchLayout;
        this.vFK = 1;
        if (1 == this.vFK) {
            this.vFJ = 2;
        } else {
            this.vFJ = 1;
        }
    }

    public final void cancel() {
        x.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
        if (this.qia != null) {
            this.qia.cbm();
        }
        if (this.zvv != null) {
            this.zvv.nx(true);
            this.zvv.ny(true);
        }
    }

    protected final boolean cdz() {
        boolean z = false;
        String str = "MicroMsg.VoiceSearchViewHelper";
        String str2 = "check has voice search, Enable %B, layout is null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.vFI);
        if (this.qia == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        return this.vFI;
    }

    protected final void cdA() {
        x.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
        if (this.zvv != null) {
            this.zvv.nx(false);
            this.zvv.ny(false);
        }
        if (this.qia != null && this.qia.getVisibility() == 8) {
            x.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
            VoiceSearchLayout voiceSearchLayout = this.qia;
            int i = this.vFK;
            x.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.aZ(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")));
            if (com.tencent.mm.pluginsdk.g.a.aZ(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")) {
                boolean z;
                x.d("MicroMsg.VoiceSearchLayout", "doStart " + voiceSearchLayout.fBn);
                voiceSearchLayout.vti = i;
                voiceSearchLayout.fBn = true;
                voiceSearchLayout.vth = false;
                if (voiceSearchLayout.vtf != null) {
                    voiceSearchLayout.vtf.cbz();
                }
                voiceSearchLayout.setVisibility(0);
                voiceSearchLayout.kKg.K(50, 50);
                voiceSearchLayout.a(true, null);
                voiceSearchLayout.vts = 0;
                voiceSearchLayout.vtm = new e(new e.b() {
                    public final void Va() {
                        VoiceSearchLayout.k(VoiceSearchLayout.this);
                        VoiceSearchLayout.this.a(false, null);
                        if (VoiceSearchLayout.this.kKg != null) {
                            VoiceSearchLayout.this.kKg.TN();
                        }
                    }

                    public final void a(String[] strArr, long j) {
                        try {
                            x.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes ");
                            if (strArr != null) {
                                x.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes size:" + strArr.length + " " + strArr.toString());
                                for (String str : strArr) {
                                    x.d("MicroMsg.VoiceSearchLayout", "search username  :" + str);
                                }
                            }
                            VoiceSearchLayout.this.reset();
                            VoiceSearchLayout.this.vtf.a(true, strArr, j);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.VoiceSearchLayout", e, "", new Object[0]);
                        }
                    }

                    public final void UZ() {
                        VoiceSearchLayout.this.reset();
                        VoiceSearchLayout.this.vtf.a(false, null, -1);
                    }
                }, i);
                e eVar = voiceSearchLayout.vtm;
                x.i("MicroMsg.SceneVoiceAddr", "start record");
                if (eVar.hZV == 0 && ao.is2G(ad.getContext())) {
                    z = true;
                } else {
                    z = false;
                }
                eVar.iag = z;
                x.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", Boolean.valueOf(eVar.iag));
                com.tencent.mm.sdk.f.e.post(new a(), "SceneVoiceAddr_record");
            } else if (voiceSearchLayout.getContext() instanceof Activity) {
                com.tencent.mm.pluginsdk.g.a.g((Activity) voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO");
            }
        }
    }

    public final void a(Activity activity, Menu menu) {
        super.a(activity, menu);
        if (this.qia != null) {
            this.qia.vtf = this.vFM;
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            boolean z = this.qia != null && this.qia.getVisibility() == 0;
            x.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", Boolean.valueOf(z));
            cancel();
            if (z) {
                return true;
            }
        }
        x.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
        return super.onKeyDown(i, keyEvent);
    }

    protected final void cdB() {
        cancel();
    }
}
