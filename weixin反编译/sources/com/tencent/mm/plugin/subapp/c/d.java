package com.tencent.mm.plugin.subapp.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.f.a.nw;
import com.tencent.mm.f.a.sn;
import com.tencent.mm.f.a.so;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.e;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.ak.f;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.s;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class d implements f, ap {
    private static HashMap<Integer, com.tencent.mm.bx.h.d> kNl;
    private static d scm;
    private final Set<com.tencent.mm.y.ak.d> gDT = new HashSet();
    private String gRT;
    private a kNn;
    private k scl;
    private j scn;
    private List<Long> sco = new ArrayList();
    private c scp = new c<so>() {
        {
            this.xmG = so.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            so soVar = (so) bVar;
            e MO = e.MO(soVar.fLd.fDn);
            cg cgVar = soVar.fLd.fou;
            if (MO != null) {
                d bEK = d.bEK();
                String str = cgVar.field_talker;
                String str2 = soVar.fLd.description;
                String S = n.S(ad.getContext(), MO.sct);
                String str3 = "";
                if (S != null && S.length() > 0) {
                    String[] split = S.split(";");
                    str3 = str3 + split[0];
                    if (split.length > 1) {
                        str3 = str3 + split[1];
                    }
                }
                if (str2 != null) {
                    str3 = str3 + str2;
                }
                bEK.f(str, str3, cgVar.field_createTime);
            }
            return false;
        }
    };
    private c scq = new c<sn>() {
        {
            this.xmG = sn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            String str = ((sn) bVar).fLc.path;
            if (str != null) {
                String aJ = h.aJ(str, false);
                if (!bi.oN(aJ)) {
                    d.bEL().iI(aJ);
                }
                d.bEL().nY(str);
                new File(str).delete();
            }
            return false;
        }
    };
    private c scr = new c<nw>() {
        {
            this.xmG = nw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            int i = (int) ((nw) bVar).fGI.fou.field_msgId;
            as.Hm();
            au dI = com.tencent.mm.y.c.Fh().dI((long) i);
            if (!(dI.field_msgId == 0 || dI.field_imgPath == null || bi.oN(dI.field_imgPath))) {
                g MP = h.MP(dI.field_imgPath);
                if (!(MP == null || bi.oN(MP.field_filename))) {
                    MP.field_status = 3;
                    MP.field_offset = 0;
                    MP.field_createtime = System.currentTimeMillis() / 1000;
                    MP.field_lastmodifytime = System.currentTimeMillis() / 1000;
                    MP.fEo = 16840;
                    h.a(MP);
                    x.d("MicroMsg.VoiceRemindLogic", " file:" + MP.field_filename + " msgid:" + MP.field_msglocalid + "  stat:" + MP.field_status);
                    if (MP.field_msglocalid == 0 || bi.oN(MP.field_user)) {
                        x.e("MicroMsg.VoiceRemindLogic", " failed msg id:" + MP.field_msglocalid + " user:" + MP.field_user);
                    } else {
                        dI.eR(1);
                        as.Hm();
                        com.tencent.mm.y.c.Fh().a(dI.field_msgId, dI);
                        d.bEM().run();
                    }
                }
            }
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        kNl = hashMap;
        hashMap.put(Integer.valueOf("VOICEREMIND_TABLE".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return k.gLy;
            }
        });
    }

    public final void a(com.tencent.mm.y.ak.d dVar) {
        x.d("MicroMsg.SubCoreVoiceRemind", "addVoiceRemind ");
        if (dVar != null) {
            this.gDT.add(dVar);
        }
    }

    public final void b(com.tencent.mm.y.ak.d dVar) {
        x.d("MicroMsg.SubCoreVoiceRemind", "removeVoiceRemind ");
        if (dVar != null) {
            this.gDT.remove(dVar);
        }
    }

    public final void f(String str, String str2, long j) {
        Context context = ad.getContext();
        if (context == null) {
            x.d("MicroMsg.SubCoreVoiceRemind", "notifyVoiceRemind context null");
            return;
        }
        try {
            boolean zA = com.tencent.mm.j.a.zA();
            boolean zy = com.tencent.mm.j.a.zy();
            x.d("MicroMsg.SubCoreVoiceRemind", "shake " + zA + "sound " + zy);
            if (!s.he(as.getNotification().xe())) {
                if (zA) {
                    bi.m(context, true);
                }
                if (zy) {
                    String zz = com.tencent.mm.j.a.zz();
                    Uri defaultUri = zz == e.f.gJJ ? RingtoneManager.getDefaultUri(2) : Uri.parse(zz);
                    MediaPlayer jVar = new j();
                    try {
                        jVar.setDataSource(context, defaultUri);
                        jVar.setOnCompletionListener(new OnCompletionListener() {
                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                try {
                                    mediaPlayer.release();
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e, "", new Object[0]);
                                }
                            }
                        });
                        if (as.Hn().getStreamVolume(5) != 0) {
                            if (as.Hn().xY()) {
                                int streamVolume = as.Hn().getStreamVolume(8);
                                int streamMaxVolume = as.Hn().getStreamMaxVolume(8);
                                int streamVolume2 = as.Hn().getStreamVolume(5);
                                if (streamVolume2 <= streamMaxVolume) {
                                    streamMaxVolume = streamVolume2;
                                }
                                as.Hn().aM(8, streamMaxVolume);
                                jVar.setAudioStreamType(8);
                                jVar.setLooping(true);
                                jVar.prepare();
                                jVar.setLooping(false);
                                jVar.start();
                                as.Hn().aM(8, streamVolume);
                                x.d("MicroMsg.SubCoreVoiceRemind", "oldVolume is %d, toneVolume is %d", Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
                            } else {
                                jVar.setAudioStreamType(5);
                                jVar.setLooping(true);
                                jVar.prepare();
                                jVar.setLooping(false);
                                jVar.start();
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e, "", new Object[0]);
                        jVar.release();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e2, "relese error", new Object[0]);
                    }
                }
            } else if (zA) {
                bi.m(context, true);
            }
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e22, "", new Object[0]);
        }
        if (this.gDT == null || this.gDT.size() == 0) {
            RemindDialog.u(context, str, str2);
            return;
        }
        for (com.tencent.mm.y.ak.d m : this.gDT) {
            m.m(str2, j);
        }
    }

    public final void hO(String str) {
        as.Hm();
        com.tencent.mm.y.c.Fk().XH(str);
        this.sco.clear();
        as.Hm();
        Cursor Fn = com.tencent.mm.y.c.Fh().Fn(str);
        Fn.moveToFirst();
        x.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene");
        while (!Fn.isAfterLast()) {
            cg auVar = new au();
            auVar.b(Fn);
            long j = auVar.field_msgId;
            x.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene: msgId = " + j + " status = " + auVar.field_status);
            Fn.moveToNext();
            this.sco.add(Long.valueOf(j));
        }
        Fn.close();
        as.Hm();
        com.tencent.mm.y.c.Fh().Fl(str);
    }

    public final void GY() {
        bEM().run();
    }

    public final boolean aK(long j) {
        boolean contains = this.sco.contains(Long.valueOf(j));
        x.d("MicroMsg.SubCoreVoiceRemind", "silent " + contains + "  mid " + j);
        return contains;
    }

    public static d bEK() {
        as.Hg();
        com.tencent.mm.plugin.subapp.a aVar = (com.tencent.mm.plugin.subapp.a) bq.ib("plugin.subapp");
        scm = aVar == null ? null : (d) aVar.MN(d.class.getName());
        x.i("MicroMsg.SubCoreVoiceRemind", "summervoice SubCoreVoiceRemind getCore subCoreSubapp[%s], theCore[%s], stack[%s]", aVar, scm, bi.chl());
        if (scm == null) {
            f dVar = new d();
            scm = dVar;
            ak.a.hhy = dVar;
            aVar.b(d.class.getName(), scm);
        }
        return scm;
    }

    public static k bEL() {
        g.Do().CA();
        if (bEK().scl == null) {
            d bEK = bEK();
            bEK();
            if (bEK().kNn == null) {
                StringBuilder stringBuilder = new StringBuilder();
                as.Hm();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.y.c.FI()).append("CommonOneMicroMsg.db").toString();
                bEK().kNn = com.tencent.mm.platformtools.g.a(d.class.hashCode(), stringBuilder2, kNl, false);
            }
            bEK.scl = new k(bEK().kNn);
        }
        return bEK().scl;
    }

    public final HashMap<Integer, com.tencent.mm.bx.h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        stringBuilder.append(com.tencent.mm.y.c.FI()).append("CommonOneMicroMsg.db");
        bEL();
        com.tencent.mm.sdk.b.a.xmy.b(this.scp);
        com.tencent.mm.sdk.b.a.xmy.b(this.scq);
        com.tencent.mm.sdk.b.a.xmy.b(this.scr);
        x.d("MicroMsg.SubCoreVoiceRemind", "summervoiceremind onAccountPostReset hash[%d]", Integer.valueOf(hashCode()));
    }

    public final void bt(boolean z) {
        as.Hm();
        String FJ = com.tencent.mm.y.c.FJ();
        if (bi.oN(FJ) || bi.oN(this.gRT) || !FJ.equals(this.gRT)) {
            x.d("MicroMsg.SubCoreVoiceRemind", "setVoiceRemindPath core on accPath : " + FJ);
            this.gRT = FJ;
            File file = new File(FJ);
            if (!file.exists()) {
                file.mkdirs();
            }
            as.Hm();
            File file2 = new File(com.tencent.mm.y.c.FG());
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
    }

    public final void onAccountRelease() {
        if (this.scn != null) {
            this.scn.fmn = 0;
        }
        if (scm != null) {
            x.d("MicroMsg.SubCoreVoiceRemind", "SubCoreVoiceRemind close db");
            d dVar = scm;
            if (dVar.kNn != null) {
                dVar.kNn.iY(dVar.hashCode());
                dVar.kNn = null;
            }
            dVar.gRT = "";
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.scp);
        com.tencent.mm.sdk.b.a.xmy.c(this.scq);
        com.tencent.mm.sdk.b.a.xmy.c(this.scr);
    }

    public static j bEM() {
        g.Do().CA();
        if (bEK().scn == null) {
            bEK().scn = new j();
        }
        return bEK().scn;
    }
}
