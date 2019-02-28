package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.e;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.fx;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;

@com.tencent.mm.ui.base.a(19)
public class MusicMainUI extends MMActivity implements e, com.tencent.mm.ad.e {
    private ag gCg = new ag(Looper.getMainLooper());
    private c jil = new c<jt>() {
        {
            this.xmG = jt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            final jt jtVar = (jt) bVar;
            switch (jtVar.fBu.action) {
                case 0:
                case 1:
                    MusicMainUI.this.oTk.setChecked(false);
                    ah.y(new Runnable() {
                        public final void run() {
                            if (jtVar.fBu.action == 0 && h.bef().mode != 2) {
                                MusicMainUI.this.oTn.a(MusicMainUI.this.oTp);
                                MusicMainUI.this.oTn.ah(100000 + h.bef().oPf);
                            }
                            MusicMainUI.this.bfr();
                        }
                    });
                    break;
                case 2:
                case 3:
                case 4:
                    MusicMainUI.this.oTk.setChecked(true);
                    break;
                case 5:
                    as.H(MusicMainUI.this.mController.xRr, R.l.eOP);
                    ah.y(new Runnable() {
                        public final void run() {
                            g.B(MusicMainUI.this);
                            MusicMainUI.this.bfr();
                        }
                    });
                    break;
                case 6:
                    ah.y(new Runnable() {
                        public final void run() {
                            boolean z;
                            b h = MusicMainUI.this.oTp;
                            com.tencent.mm.au.a aVar = jtVar.fBu.fBv;
                            boolean z2 = false;
                            Iterator it = h.oSR.entrySet().iterator();
                            while (true) {
                                z = z2;
                                if (!it.hasNext()) {
                                    break;
                                }
                                com.tencent.mm.plugin.music.ui.b.a aVar2 = (com.tencent.mm.plugin.music.ui.b.a) ((View) ((Entry) it.next()).getValue()).getTag();
                                if (aVar2.fBv.field_musicId.equals(aVar.field_musicId)) {
                                    aVar2.h(aVar, true);
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                            }
                            if (!z) {
                                x.i("MicroMsg.Music.MusicMainAdapter", "holder song id is not exist, do refresh all");
                                h.notifyDataSetChanged();
                            }
                        }
                    });
                    break;
                case 7:
                    if (h.bef().mode == 2) {
                        ah.y(new Runnable() {
                            public final void run() {
                                MusicMainUI.this.oTn.ah(MusicMainUI.this.oTn.yF + 1);
                            }
                        });
                        break;
                    }
                    break;
                case 13:
                    if (h.bef().mode == 2) {
                        ah.y(new Runnable() {
                            public final void run() {
                                MusicMainUI.this.oTn.ah(MusicMainUI.this.oTn.yF - 1);
                            }
                        });
                        break;
                    }
                    break;
                case 14:
                    if (h.bef().mode == 2) {
                        ah.y(new Runnable() {
                            public final void run() {
                                MusicMainUI.this.oTn.ah(MusicMainUI.this.oTn.yF + 1);
                            }
                        });
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private long kIG;
    private int mode;
    private com.tencent.mm.plugin.music.model.g.c.a oQg = new com.tencent.mm.plugin.music.model.g.c.a() {
        public final void bK(int i, int i2) {
            if (MusicMainUI.this.mode == 1 && !MusicMainUI.this.oTq) {
                float floatExtra = MusicMainUI.this.getIntent().getFloatExtra("key_offset", 0.0f);
                floatExtra *= 1000.0f;
                long currentTimeMillis = (long) (floatExtra + ((float) (System.currentTimeMillis() - MusicMainUI.this.getIntent().getLongExtra("music_player_beg_time", 0))));
                if (currentTimeMillis >= 0) {
                    MusicMainUI.this.oTp.C(MusicMainUI.this.oTn.yF, currentTimeMillis + 200);
                }
            } else if (i >= 0 && i2 > 0) {
                MusicMainUI.this.oTp.C(MusicMainUI.this.oTn.yF, (long) i);
            }
        }
    };
    private boolean oRt;
    private CheckBox oTk;
    private ImageButton oTl;
    private ImageButton oTm;
    private MusicViewPager oTn;
    private com.tencent.mm.pluginsdk.k.c oTo;
    private b oTp;
    private boolean oTq;
    private int oTr = 0;
    private Timer oTs;
    private int oTt = -1;
    private int scene;

    private class b extends com.tencent.mm.pluginsdk.k.c.a {
        private b() {
        }

        /* synthetic */ b(MusicMainUI musicMainUI, byte b) {
            this();
        }

        public final void bfv() {
            x.i("MicroMsg.Music.MusicMainUI", "shake %b", Boolean.valueOf(true));
            long bB = bi.bB(MusicMainUI.this.kIG);
            if (bB < 1200) {
                x.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:" + bB);
                return;
            }
            x.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:" + bB);
            MusicMainUI.this.kIG = bi.Wz();
            MusicMainUI.this.oTr = MusicMainUI.this.oTr + 1;
            if (MusicMainUI.this.oTr % 2 == 0) {
                com.tencent.mm.plugin.music.model.e bef = h.bef();
                int g = MusicMainUI.this.scene;
                com.tencent.mm.plugin.report.service.g.pWK.a(285, 2, 1, false);
                com.tencent.mm.sdk.b.b jtVar;
                if (bef.mode != 1) {
                    bef.mode = 1;
                    jtVar = new jt();
                    jtVar.fBu.action = 5;
                    com.tencent.mm.sdk.b.a.xmy.m(jtVar);
                    f.S(2, 1, g);
                } else if (bef.oPo) {
                    x.i("MicroMsg.Music.MusicPlayerManager", "already running get list");
                } else {
                    bef.mode = 2;
                    if (bef.oPg.size() <= 1) {
                        bef.bdW();
                    } else {
                        jtVar = new jt();
                        jtVar.fBu.action = 5;
                        com.tencent.mm.sdk.b.a.xmy.m(jtVar);
                    }
                    f.S(1, 2, g);
                }
            }
        }

        public final void onRelease() {
        }
    }

    private class a implements Runnable {
        int position;

        public a(int i) {
            this.position = i;
        }

        public final void run() {
            com.tencent.mm.plugin.music.model.e bef = h.bef();
            int i = this.position;
            if (bef.oPg.size() != 0) {
                i = (i - 100000) % bef.oPg.size();
                if (i < 0) {
                    i += bef.oPg.size();
                }
                if (i != bef.oPf) {
                    bef.oPf = i;
                    bef.e(null);
                }
            }
            com.tencent.mm.au.a bdU = h.bef().bdU();
            if (bdU != null) {
                if (bdU.Qs()) {
                    MusicMainUI.this.q(bdU);
                }
                if (h.bef().bdZ()) {
                    MusicMainUI.this.oTn.DN = true;
                }
                MusicMainUI.this.p(bdU);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.mode = getIntent().getIntExtra("key_mode", 2);
        this.scene = getIntent().getIntExtra("key_scene", 0);
        this.oRt = getIntent().getBooleanExtra("KGlobalShakeMusic", false);
        this.oTn = (MusicViewPager) findViewById(R.h.cVU);
        this.oTp = new b(this, this.scene, this.oRt);
        this.oTn.a(this.oTp);
        this.oTn.b((e) this);
        this.oTn.setSystemUiVisibility(Downloads.RECV_BUFFER_SIZE);
        this.oTl = (ImageButton) findViewById(R.h.bLU);
        this.oTm = (ImageButton) findViewById(R.h.cLz);
        this.oTk = (CheckBox) findViewById(R.h.cyw);
        this.oTk.setChecked(!h.bef().bdT().Qx());
        this.oTo = new com.tencent.mm.pluginsdk.k.c(this);
        this.oTk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MusicMainUI.this.bfs();
                if (MusicMainUI.this.oTk.isChecked()) {
                    com.tencent.mm.au.b.xZ();
                    MusicMainUI.this.oTk.setChecked(true);
                    MusicMainUI.bfu();
                    return;
                }
                MusicMainUI.this.oTq = true;
                if (h.bef().bdT().Qy()) {
                    h.bef().bdT().resume();
                } else {
                    h.bef().e(null);
                }
                MusicMainUI.this.bft();
                MusicMainUI.this.oTk.setChecked(false);
            }
        });
        com.tencent.mm.sdk.b.a.xmy.b(this.jil);
        if (!this.oTo.caA()) {
            x.w("MicroMsg.Music.MusicMainUI", "not support shake");
        }
        bfr();
        this.oTn.ah(100000 + h.bef().oPf);
        bft();
        int i = this.scene;
        if (h.bef().bdU() != null) {
            x.v("MicroMsg.Music.MusicReportUtil", "kvReportEnterMusicUI: %d, %d, %s, %s, %s, %s, %s, %s", Integer.valueOf(13041), Integer.valueOf(i), h.bef().bdU().field_musicId, h.bef().bdU().field_songName, h.bef().bdU().field_songAlbum, Integer.valueOf(h.bef().bdU().field_songId), h.bef().bdU().field_songSinger, h.bef().bdU().field_appId);
            com.tencent.mm.plugin.report.service.g.pWK.h(13041, Integer.valueOf(i), r1.field_musicId, r1.field_songName, r1.field_songAlbum, Integer.valueOf(r1.field_songId), r1.field_songSinger, r1.field_appId);
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(285, 1, 1, false);
        com.tencent.mm.au.a bdU = h.bef().bdU();
        if (bdU == null) {
            finish();
            return;
        }
        if (this.scene == 4 && h.bef().mode == 2) {
            com.tencent.mm.y.as.Hm();
            int i2 = com.tencent.mm.y.c.Db().getInt(83, 0);
            if (i2 < 3) {
                Toast.makeText(this, R.l.ekY, 0).show();
                i2++;
                com.tencent.mm.y.as.Hm();
                com.tencent.mm.y.c.Db().set(83, Integer.valueOf(i2));
            }
        }
        if (this.scene == 5) {
            f.a(0, bdU);
        }
        p(bdU);
        if (this.mode == 1) {
            if (this.oTs == null) {
                this.oTs = new Timer();
            }
            this.oTs.schedule(new TimerTask() {
                public final void run() {
                    MusicMainUI.this.oQg.bK(0, 0);
                }
            }, 0, 500);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    protected void onResume() {
        int i;
        super.onResume();
        com.tencent.mm.au.a bdU = h.bef().bdU();
        if (bdU != null) {
            switch (bdU.field_musicType) {
                case 1:
                case 4:
                case 6:
                case 8:
                case 9:
                    i = 1;
                    break;
            }
        }
        i = (byte) 0;
        if (i == 0) {
            x.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
            h.bef().mode = 1;
        } else if (!this.oRt) {
            if (!(this.oTo == null || !this.oTo.caA() || this.oTo.cay())) {
                this.oTo.a(new b());
            }
            this.kIG = bi.Wz();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.oTo != null) {
            this.oTo.aQC();
        }
    }

    private void bfr() {
        h.bef();
        this.oTp.count = 200000;
        this.oTp.notifyDataSetChanged();
        if (h.bef().bdZ()) {
            this.oTn.DN = true;
        } else {
            this.oTn.DN = false;
        }
    }

    private void bfs() {
        if (this.oTs != null) {
            this.oTs.cancel();
        }
        this.oTs = null;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.oTo != null) {
            this.oTo.aQC();
        }
        if (this.oTp != null) {
            b bVar = this.oTp;
            bVar.oPb.removeCallbacksAndMessages(null);
            d dVar = bVar.oSS;
            dVar.oPb.removeCallbacksAndMessages(null);
            dVar.gBc.clear();
        }
        bfs();
        com.tencent.mm.sdk.b.a.xmy.c(this.jil);
        bfu();
        if (!h.bef().bdT().Qx()) {
            h.bef().bdT().stopPlay();
        }
        com.tencent.mm.plugin.music.model.e bef = h.bef();
        if (!bef.oPh.Qx() && !bef.oPi.Qx()) {
            x.i("MicroMsg.Music.MusicPlayerManager", "really exit music");
            bef.mode = 1;
        }
    }

    public void onClickBack(View view) {
        finish();
    }

    public void onClickSend(View view) {
        final ati bdV = h.bef().bdV();
        x.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", Integer.valueOf(bdV.wHt), bdV.wHB);
        if (bdV.wHt == 11) {
            com.tencent.mm.sdk.b.b fxVar = new fx();
            com.tencent.mm.sdk.b.a.xmy.m(fxVar);
            final String str = fxVar.fwF.appId;
            CharSequence charSequence = fxVar.fwF.fsi;
            final String str2 = fxVar.fwF.fwG;
            final int i = fxVar.fwF.fwH;
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = "";
            }
            x.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", str, charSequence, Integer.valueOf(i), str2);
            String string = getString(R.l.enP, new Object[]{charSequence});
            if (TextUtils.isEmpty(bdV.wHB)) {
                String[] strArr = new String[]{string};
                new ArrayList().add(Integer.valueOf(0));
                com.tencent.mm.ui.base.h.a((Context) this, "", strArr, "", new com.tencent.mm.ui.base.h.c() {
                    public final void jo(int i) {
                        switch (i) {
                            case 0:
                                g.E(str, str2, i);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return;
            }
            List arrayList = new ArrayList();
            String[] strArr2 = new String[]{getString(R.l.eYt), getString(R.l.eYu), getString(R.l.dRa), string};
            arrayList.add(Integer.valueOf(0));
            arrayList.add(Integer.valueOf(1));
            arrayList.add(Integer.valueOf(2));
            arrayList.add(Integer.valueOf(3));
            com.tencent.mm.ui.base.h.a((Context) this, "", strArr2, "", new com.tencent.mm.ui.base.h.c() {
                public final void jo(int i) {
                    switch (i) {
                        case 0:
                            g.A(MusicMainUI.this);
                            f.tF(MusicMainUI.this.scene);
                            f.tI(2);
                            return;
                        case 1:
                            g.c(bdV, MusicMainUI.this);
                            f.tG(MusicMainUI.this.scene);
                            f.tI(1);
                            return;
                        case 2:
                            g.a(bdV, MusicMainUI.this);
                            f.tI(3);
                            return;
                        case 3:
                            g.E(str, str2, i);
                            return;
                        default:
                            return;
                    }
                }
            });
        } else if (!TextUtils.isEmpty(bdV.wHB)) {
            List arrayList2 = new ArrayList();
            String[] strArr3 = new String[]{getString(R.l.eYt), getString(R.l.eYu), getString(R.l.dRa), getString(R.l.eeQ)};
            arrayList2.add(Integer.valueOf(0));
            arrayList2.add(Integer.valueOf(1));
            arrayList2.add(Integer.valueOf(2));
            arrayList2.add(Integer.valueOf(3));
            com.tencent.mm.ui.base.h.a((Context) this, "", strArr3, "", new com.tencent.mm.ui.base.h.c() {
                public final void jo(int i) {
                    switch (i) {
                        case 0:
                            g.A(MusicMainUI.this);
                            f.tF(MusicMainUI.this.scene);
                            f.tI(2);
                            return;
                        case 1:
                            g.c(bdV, MusicMainUI.this);
                            f.tG(MusicMainUI.this.scene);
                            f.tI(1);
                            return;
                        case 2:
                            g.a(bdV, MusicMainUI.this);
                            f.tI(3);
                            return;
                        case 3:
                            g.b(bdV, MusicMainUI.this);
                            f.tI(4);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    protected final int getLayoutId() {
        return R.i.doH;
    }

    public final void a(int i, float f, int i2) {
    }

    private void p(com.tencent.mm.au.a aVar) {
        if (!g.d(aVar) || this.oRt) {
            this.oTk.setVisibility(8);
            this.oTm.setVisibility(8);
            return;
        }
        this.oTk.setVisibility(0);
        this.oTm.setVisibility(0);
    }

    public final void ae(int i) {
        x.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", Integer.valueOf(i));
        if (h.bef().bdZ()) {
            this.oTn.DN = false;
        }
        this.gCg.removeCallbacksAndMessages(null);
        this.gCg.postDelayed(new a(i), 500);
        if (this.oTt == -1) {
            this.oTt = i;
        }
        if (this.oTt != i) {
            this.oTt = i;
            f.oPs = true;
            com.tencent.mm.plugin.report.service.g.pWK.a(285, 3, 1, false);
            f.cW(1, this.scene);
        }
    }

    public final void af(int i) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (-1 == i2 && 1 == i) {
            g.a(h.bef().bdV(), intent, (MMActivity) this);
        } else {
            super.onActivityResult(i, i2, intent);
        }
    }

    public final void bft() {
        h.bef().bdT().a(this.oQg);
    }

    public static void bfu() {
        h.bef().bdT().a(null);
    }

    public final void q(com.tencent.mm.au.a aVar) {
        com.tencent.mm.au.a bdU = h.bef().bdU();
        if (bdU != null && bdU.a(aVar) && this.oTm != null && this.oTl != null && this.oTk != null && this.oTm.getBackground() != null && this.oTl.getBackground() != null && this.oTk.getBackground() != null) {
            if (aVar.Qs()) {
                int i = aVar.field_songLyricColor;
                this.oTm.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.oTl.getBackground().setColorFilter(i, Mode.MULTIPLY);
                this.oTk.getBackground().setColorFilter(i, Mode.MULTIPLY);
                return;
            }
            this.oTm.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.oTl.getBackground().setColorFilter(-1, Mode.MULTIPLY);
            this.oTk.getBackground().setColorFilter(-1, Mode.MULTIPLY);
        }
    }
}
