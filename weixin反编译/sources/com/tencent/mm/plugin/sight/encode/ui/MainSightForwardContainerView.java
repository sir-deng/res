package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.f.a.pk;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

public class MainSightForwardContainerView extends RelativeLayout implements OnItemClickListener, a {
    private int mDuration;
    private boolean mIsPause;
    private boolean mIsPlaying;
    public View oox;
    public View qCA;
    public View qCB;
    public View qCC;
    private Dialog qCD;
    private boolean qCE;
    public String qCF;
    private boolean qCG;
    public String qCH;
    public float qCI;
    private b qCJ;
    private boolean qCK;
    public MMFragmentActivity qCL;
    private boolean qCM;
    private c qCN;
    private boolean qCO;
    private MediaPlayer qCP;
    public MainSightSelectContactView qCx;
    public SightCameraView qCy;
    public b qCz;

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qCD = null;
        this.mIsPlaying = false;
        this.qCE = true;
        this.qCF = "";
        this.qCG = false;
        this.qCH = "";
        this.mDuration = 1;
        this.qCI = 1.0f;
        this.mIsPause = false;
        this.qCJ = new b();
        this.qCK = false;
        this.qCM = false;
        this.qCN = new c<pk>() {
            {
                this.xmG = pk.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                pk pkVar = (pk) bVar;
                String str = "MicroMsg.MainSightContainerView";
                String str2 = "on sight send result back[%d], type %d, waitSend %B, isForSns %B";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(hashCode());
                objArr[1] = Integer.valueOf(pkVar.fIc.type);
                objArr[2] = Boolean.valueOf(MainSightForwardContainerView.this.qCD != null);
                objArr[3] = Boolean.valueOf(MainSightForwardContainerView.this.qCO);
                x.i(str, str2, objArr);
                switch (pkVar.fIc.type) {
                    case 0:
                        MainSightForwardContainerView.this.qCM = false;
                        if (!MainSightForwardContainerView.this.qCO) {
                            if (!pkVar.fIc.fIe) {
                                MainSightForwardContainerView.this.postDelayed(new Runnable() {
                                    public final void run() {
                                        MainSightForwardContainerView.this.bug();
                                    }
                                }, 500);
                                break;
                            }
                            g.pWK.h(11443, Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(0));
                            MainSightForwardContainerView.this.im(true);
                            break;
                        }
                        if (pkVar.fIc.fIe) {
                            g.pWK.h(11443, Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(0));
                        }
                        MainSightForwardContainerView.this.aCt();
                        break;
                }
                return false;
            }
        };
        this.qCO = false;
    }

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void aCt() {
        a.xmy.c(this.qCN);
    }

    public final void bug() {
        boolean z = true;
        x.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", this.qCH, Boolean.valueOf(this.qCE), Boolean.valueOf(this.mIsPlaying));
        if (!this.qCy.isPlaying()) {
            this.qCE = true;
        }
        this.qCy.aB(this.qCH, this.qCE);
        if (this.qCE) {
            in(true);
        } else {
            in(false);
        }
        this.mIsPlaying = true;
        if (this.qCE) {
            z = false;
        }
        this.qCE = z;
    }

    public final boolean AP() {
        return !this.qCE;
    }

    private void il(boolean z) {
        if (this.qCy != null) {
            this.qCy.il(z);
        }
    }

    public final void im(boolean z) {
        if (!this.qCG) {
            this.qCG = true;
            bi.hideVKB(this);
            this.mIsPlaying = false;
            this.qCE = true;
            x.d("MicroMsg.MainSightContainerView", "dismiss sight view");
            this.qCM = false;
            this.qCy.but();
            if (this.qCz != null && z) {
                this.qCz.bui();
            }
            if (this.qCx != null) {
                View view = this.qCx;
                view.qCG = true;
                bi.hideVKB(view);
                view.qDl.bum();
                view.qDv.clear();
                view.qDu.clear();
                view.Fv.setAdapter(null);
                view.Fv.clearAnimation();
                view.setVisibility(8);
            }
            as(0.85f);
            buh();
            in(false);
            this.qCF = "";
            aCt();
        }
    }

    public final void in(boolean z) {
        if (this.qCK != z) {
            this.qCK = z;
            if (!z) {
                this.qCB.setVisibility(8);
                this.oox.setVisibility(8);
            } else if (this.qCB.getVisibility() != 0) {
                this.qCy.postDelayed(new Runnable() {
                    public final void run() {
                        if (!MainSightForwardContainerView.this.qCK || (MainSightForwardContainerView.this.qCx != null && MainSightForwardContainerView.this.qCx.qDl.buk())) {
                            MainSightForwardContainerView.this.qCK = false;
                            return;
                        }
                        MainSightForwardContainerView.this.qCB.setVisibility(0);
                        if (MainSightForwardContainerView.this.qCx != null && !MainSightForwardContainerView.this.qCx.bus() && MainSightForwardContainerView.this.oox.getVisibility() != 0) {
                            MainSightForwardContainerView.this.oox.setVisibility(0);
                            MainSightForwardContainerView.this.oox.startAnimation(AnimationUtils.loadAnimation(MainSightForwardContainerView.this.qCL, R.a.bpZ));
                        }
                    }
                }, 100);
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = i - 1;
        if (MainSightSelectContactView.wG(i2) && this.mIsPlaying) {
            bug();
        } else if (c.Kb(this.qCx.hF(i2))) {
            this.qCx.qDl.bul();
        } else if (!c.Ka(this.qCx.hF(i2))) {
            x.d("MicroMsg.MainSightContainerView", "on item click Item : %d", Integer.valueOf(i2));
            MainSightSelectContactView mainSightSelectContactView = this.qCx;
            if (i2 >= 0 && i2 <= mainSightSelectContactView.qDn.getCount()) {
                com.tencent.mm.ui.contact.a.a GF = mainSightSelectContactView.qDn.GF(i2);
                if (GF != null) {
                    if (mainSightSelectContactView.qDv.contains(GF.jQP.field_username)) {
                        mainSightSelectContactView.qDv.remove(GF.jQP.field_username);
                    } else {
                        mainSightSelectContactView.qDv.add(GF.jQP.field_username);
                    }
                    c.qCV = mainSightSelectContactView.qDv.isEmpty();
                    c.qCW = !mainSightSelectContactView.qDv.isEmpty();
                }
            }
            mainSightSelectContactView = this.qCx;
            if (mainSightSelectContactView.qDn != null) {
                mainSightSelectContactView.qDn.notifyDataSetChanged();
            }
            if (!AP()) {
                bug();
            } else if (this.qCx.bus()) {
                if (this.oox.getVisibility() == 0) {
                    this.oox.setVisibility(8);
                    this.oox.startAnimation(AnimationUtils.loadAnimation(this.qCL, R.a.bqa));
                }
            } else if (this.oox.getVisibility() != 0) {
                this.oox.setVisibility(0);
                this.oox.startAnimation(AnimationUtils.loadAnimation(this.qCL, R.a.bpZ));
            }
            if (this.qCx.qDl.buk()) {
                mainSightSelectContactView = this.qCx;
                boolean contains = mainSightSelectContactView.qDn.GF(i2) == null ? false : mainSightSelectContactView.qDn.GF(i2).jQP == null ? false : mainSightSelectContactView.qDv.contains(mainSightSelectContactView.qDn.GF(i2).jQP.field_username);
                if (contains) {
                    this.qCx.qDl.bul();
                }
            }
        } else if (c.qCV) {
            this.qCM = true;
            this.qCy.but();
            Context context = this.qCL;
            String JU = d.JU(this.qCH);
            String str = this.qCH;
            String str2 = this.qCF;
            x.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", str, JU);
            if (!e.bO(JU)) {
                try {
                    com.tencent.mm.sdk.platformtools.d.a(d.U(str, 320, 240), 60, CompressFormat.JPEG, JU, true);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                    x.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                }
            }
            Intent intent = new Intent();
            intent.putExtra("KSightPath", str);
            intent.putExtra("KSightThumbPath", JU);
            intent.putExtra("sight_md5", str2);
            intent.putExtra("KSightDraftEntrance", false);
            intent.putExtra("Ksnsupload_source", 0);
            intent.putExtra("KSnsPostManu", true);
            intent.putExtra("KTouchCameraTime", bi.Wx());
            com.tencent.mm.bl.d.b(context, "sns", ".ui.SightUploadUI", intent, 5985);
            if (this.qCO) {
                g.pWK.h(11442, Integer.valueOf(3), Integer.valueOf(3));
            } else {
                g.pWK.h(11442, Integer.valueOf(1), Integer.valueOf(3));
            }
        }
    }

    public final void aQk() {
        String str = "MicroMsg.MainSightContainerView";
        String str2 = "do send to friend, loadingDialog null %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.qCD == null);
        x.i(str, str2, objArr);
        if (!bi.oN(this.qCH) && !this.qCx.bus()) {
            String str3;
            boolean z;
            final List<String> bur = this.qCx.bur();
            g.pWK.h(11443, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(bur.size()));
            b.a anonymousClass6 = new b.a() {
                public final void onError(int i) {
                    if (bur.size() <= 1 || -1 == i) {
                        h.bu(MainSightForwardContainerView.this.getContext(), MainSightForwardContainerView.this.getContext().getString(R.l.eKq));
                    }
                }
            };
            if (bur.size() == 1) {
                b bVar = this.qCJ;
                String str4 = this.qCH;
                int i = this.mDuration;
                str3 = this.qCF;
                str2 = (String) bur.get(0);
                if (bi.oN(str4)) {
                    x.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                    b.a(anonymousClass6, -1);
                } else if (bi.oN(str2)) {
                    x.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                    b.a(anonymousClass6, -1);
                } else if (!e.bO(str4) || e.bN(str4) <= 0) {
                    x.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                    h.bu(ad.getContext(), ad.getContext().getString(com.tencent.mm.plugin.ah.a.h.sjI));
                } else {
                    x.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", str3, com.tencent.mm.a.g.bV(str4));
                    if (bi.aD(str3, "").equals(com.tencent.mm.a.g.bV(str4))) {
                        com.tencent.mm.kernel.g.Dr();
                        if (com.tencent.mm.kernel.g.Dt().F(new com.tencent.mm.plugin.sight.encode.a.b.AnonymousClass3(str2, anonymousClass6, str4, i)) < 0) {
                            x.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                            b.a(anonymousClass6, -1);
                        }
                    } else {
                        x.e("MicroMsg.SightRecorderHelper", "error md5, return");
                        b.a(anonymousClass6, -1);
                    }
                }
            } else {
                b bVar2 = this.qCJ;
                String str5 = this.qCH;
                int i2 = this.mDuration;
                String str6 = this.qCF;
                if (bi.oN(str5)) {
                    x.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                    b.a(anonymousClass6, -1);
                } else if (bur.isEmpty()) {
                    x.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
                    b.a(anonymousClass6, -1);
                } else if (!e.bO(str5) || e.bN(str5) <= 0) {
                    x.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                    h.bu(ad.getContext(), ad.getContext().getString(com.tencent.mm.plugin.ah.a.h.sjI));
                } else {
                    x.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", str6, com.tencent.mm.a.g.bV(str5));
                    if (bi.aD(str6, "").equals(com.tencent.mm.a.g.bV(str5))) {
                        com.tencent.mm.kernel.g.Dr();
                        if (com.tencent.mm.kernel.g.Dt().F(new com.tencent.mm.plugin.sight.encode.a.b.AnonymousClass4(str5, bur, str6, anonymousClass6, i2)) < 0) {
                            x.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                            b.a(anonymousClass6, -1);
                        }
                    } else {
                        x.e("MicroMsg.SightRecorderHelper", "error md5, return");
                        b.a(anonymousClass6, -1);
                    }
                }
            }
            if (this.qCx.bur().size() > 1 || this.qCz == null) {
                z = true;
            } else {
                this.qCz.JZ((String) this.qCx.bur().get(0));
                z = false;
            }
            if (this.qCL != null) {
                try {
                    AssetFileDescriptor openFd = this.qCL.getAssets().openFd("sight_send_song.wav");
                    this.qCP = new j();
                    this.qCP.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    openFd.close();
                    this.qCP.setOnCompletionListener(new OnCompletionListener() {
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                        }
                    });
                    this.qCP.setLooping(false);
                    this.qCP.prepare();
                    this.qCP.start();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MainSightContainerView", e, "", new Object[0]);
                }
            }
            im(z);
            for (String str32 : bur) {
                if (str32.toLowerCase().endsWith("@chatroom")) {
                    g.pWK.h(11442, Integer.valueOf(1), Integer.valueOf(2));
                } else {
                    g.pWK.h(11442, Integer.valueOf(1), Integer.valueOf(1));
                }
            }
        }
    }

    public final void onPause() {
        if (!this.qCM) {
            this.qCy.setVisibility(0);
            in(false);
            this.qCy.but();
            this.mIsPause = true;
        }
    }

    public final void onResume() {
        if (!this.qCG) {
            a.xmy.c(this.qCN);
            a.xmy.b(this.qCN);
        } else {
            aCt();
        }
        if (this.mIsPause) {
            bug();
            this.mIsPause = false;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.qCG && this.qCx != null) {
            x.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            this.qCx.bup();
        }
    }

    @TargetApi(11)
    public final void as(float f) {
        float min = Math.min(1.0f, Math.max(0.0f, f));
        if (com.tencent.mm.compatible.util.d.fN(11)) {
            this.qCA.setAlpha(min);
        } else {
            Animation alphaAnimation = new AlphaAnimation(min, min);
            alphaAnimation.setDuration(0);
            alphaAnimation.setFillAfter(true);
            this.qCA.startAnimation(alphaAnimation);
        }
        x.d("MicroMsg.MainSightContainerView", "set alpha: %f", Float.valueOf(min));
        if (min <= 0.0f) {
            this.qCA.setVisibility(8);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(500);
            this.qCA.startAnimation(alphaAnimation2);
            return;
        }
        this.qCA.setVisibility(0);
    }

    public final void buh() {
        this.qCC.setVisibility(8);
    }

    public final void ik(boolean z) {
        if (z) {
            this.qCC.setVisibility(0);
            il(true);
            return;
        }
        buh();
        il(AP());
    }

    public final void bue() {
        this.qCy.setVisibility(0);
        in(true);
    }

    public final void buf() {
        this.qCy.setVisibility(4);
        in(false);
    }

    public final int bud() {
        int height = getHeight();
        if (height <= 0) {
            return getResources().getDisplayMetrics().heightPixels;
        }
        return height;
    }
}
