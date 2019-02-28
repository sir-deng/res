package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.b.b;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.m;
import java.io.File;
import java.util.HashMap;

public final class j {
    String fAJ = "";
    String fAM;
    long hXs;
    public TextView mBO;
    public int mPosition;
    public View nav;
    int rqU = 0;
    public b yMd;
    public b yOP;
    public HashMap<String, Boolean> yOQ = new HashMap();
    public RelativeLayout yOR;
    public f yOS;
    public ImageView yOT;
    public ImageView yOU;
    public MMPinProgressBtn yOV;
    public View yOW;
    public RelativeLayout yOX;
    public ImageView yOY;
    public ImageView yOZ;
    public f yPa;
    public MMPinProgressBtn yPb;
    public TextView yPc;
    public LinearLayout yPd;
    public TextView yPe;
    public TextView yPf;
    public ImageView yPg;
    public ProgressBar yPh;
    public ProgressBar yPi;
    public LinearLayout yPj;
    public TextView yPk;
    public ImageView yPl;
    public MultiTouchImageView yPm;
    int yPn = 0;
    int yPo = 0;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.j$5 */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] yLW = new int[b.values().length];

        static {
            try {
                yLW[b.image.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                yLW[b.video.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                yLW[b.sight.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                yLW[b.unkown.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @TargetApi(11)
    public j(b bVar, View view) {
        this.nav = view;
        this.yMd = bVar;
        this.yPm = (MultiTouchImageView) view.findViewById(R.h.image);
        this.yPi = (ProgressBar) view.findViewById(R.h.cpd);
        if (d.fN(11) && view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    public static void N(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public final j cvW() {
        if (this.yPd == null) {
            this.yPd = (LinearLayout) ((ViewStub) this.nav.findViewById(R.h.cpg)).inflate();
            this.yPh = (ProgressBar) this.yPd.findViewById(R.h.ccX);
            this.yPe = (TextView) this.yPd.findViewById(R.h.ccY);
            this.yPf = (TextView) this.yPd.findViewById(R.h.ccW);
            this.yPg = (ImageView) this.yPd.findViewById(R.h.ccZ);
        }
        return this;
    }

    public final j cvX() {
        if (this.yPj == null) {
            this.yPj = (LinearLayout) ((ViewStub) this.nav.findViewById(R.h.cpe)).inflate();
            this.yPl = (ImageView) this.yPj.findViewById(R.h.ccD);
            this.yPk = (TextView) this.yPj.findViewById(R.h.ccE);
        }
        return this;
    }

    public final j cvY() {
        if (this.yOR == null) {
            this.yOR = (RelativeLayout) ((ViewStub) this.nav.findViewById(R.h.cOz)).inflate();
            this.yOS = n.es(this.nav.getContext());
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            this.yOR.addView((View) this.yOS, layoutParams);
            ((View) this.yOS).setVisibility(8);
            this.yOW = this.yOR.findViewById(R.h.cSl);
            this.yOW.setVisibility(8);
            this.mBO = (TextView) this.yOR.findViewById(R.h.cOn);
            this.yOV = (MMPinProgressBtn) this.yOR.findViewById(R.h.cOw);
            this.yOV.setVisibility(8);
            this.yOT = (ImageView) this.yOR.findViewById(R.h.cOx);
            this.yOU = (ImageView) this.yOR.findViewById(R.h.cVN);
            this.yOS.a(new a() {
                public final void hY() {
                }

                public final void onError(int i, int i2) {
                    j.this.yOS.stop();
                    final String str = (String) ((View) j.this.yOS).getTag();
                    com.tencent.mm.sdk.a.b.z(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.btm() + "[ImageGallery] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + bi.aD(str, "")).getBytes(), 2), "FullScreenPlaySight");
                    ah.y(new Runnable() {
                        public final void run() {
                            if (bi.oN(str)) {
                                h.h(j.this.yMd.yLH, R.l.eTs, R.l.dSM);
                                return;
                            }
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setDataAndType(Uri.fromFile(new File(str)), "video/*");
                            try {
                                j.this.yMd.yLH.startActivity(Intent.createChooser(intent, j.this.yMd.yLH.mController.xRr.getString(R.l.ehf)));
                            } catch (Exception e) {
                                x.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                                h.h(j.this.yMd.yLH, R.l.egf, R.l.egg);
                            }
                        }
                    });
                    j.this.yOQ.put(str, Boolean.valueOf(true));
                }

                public final void vi() {
                    j.this.yOS.start();
                    j.this.yOW.post(new Runnable() {
                        public final void run() {
                            if (j.this.yOW != null && j.this.yOW.getVisibility() != 0) {
                                if (j.this.yOW.getTag() != null && (j.this.yOW.getTag() instanceof r)) {
                                    r rVar = (r) j.this.yOW.getTag();
                                    if (rVar.hXE != null && !bi.oN(rVar.hXE.heZ)) {
                                        j.this.yOW.setVisibility(8);
                                        return;
                                    } else if (!(rVar.hXE == null || bi.oN(rVar.hXE.hfc) || bi.oN(rVar.hXE.hfd))) {
                                        j.this.yOW.setVisibility(8);
                                        return;
                                    }
                                }
                                j.this.yOW.setVisibility(0);
                                j.this.yOW.startAnimation(AnimationUtils.loadAnimation(j.this.yOW.getContext(), R.a.bpZ));
                            }
                        }
                    });
                }

                public final int ck(int i, int i2) {
                    return 0;
                }

                public final void cl(int i, int i2) {
                }
            });
            this.mBO.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (view.getTag() != null && (view.getTag() instanceof au)) {
                        au auVar = (au) view.getTag();
                        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.EnterCompleteVideo, auVar);
                        r nJ = t.nJ(auVar.field_imgPath);
                        bnp bnp = nJ.hXE;
                        if (bnp != null && !com.tencent.mm.platformtools.t.oN(bnp.heZ)) {
                            int i;
                            o.Ub();
                            String ny = s.ny(auVar.field_imgPath);
                            Intent intent = new Intent();
                            intent.putExtra("IsAd", false);
                            intent.putExtra("KStremVideoUrl", bnp.heZ);
                            intent.putExtra("KThumUrl", bnp.hfe);
                            intent.putExtra("KThumbPath", ny);
                            intent.putExtra("KMediaId", "fakeid_" + auVar.field_msgId);
                            intent.putExtra("KMediaVideoTime", bnp.wlG);
                            intent.putExtra("KMediaTitle", bnp.hfb);
                            intent.putExtra("StreamWording", bnp.hfc);
                            intent.putExtra("StremWebUrl", bnp.hfd);
                            String str = auVar.field_talker;
                            boolean endsWith = str.endsWith("@chatroom");
                            ny = endsWith ? bb.hS(auVar.field_content) : str;
                            intent.putExtra("KSta_StremVideoAduxInfo", bnp.hff);
                            intent.putExtra("KSta_StremVideoPublishId", bnp.hfg);
                            intent.putExtra("KSta_SourceType", 1);
                            String str2 = "KSta_Scene";
                            if (endsWith) {
                                i = com.tencent.mm.ui.chatting.a.b.TalkChat.value;
                            } else {
                                i = com.tencent.mm.ui.chatting.a.b.Chat.value;
                            }
                            intent.putExtra(str2, i);
                            intent.putExtra("KSta_FromUserName", ny);
                            intent.putExtra("KSta_ChatName", str);
                            intent.putExtra("KSta_MsgId", auVar.field_msgSvrId);
                            intent.putExtra("KSta_SnsStatExtStr", nJ.fHB);
                            if (endsWith) {
                                intent.putExtra("KSta_ChatroomMembercount", m.gn(str));
                            }
                            com.tencent.mm.bl.d.b(j.this.yMd.yLH.mController.xRr, "sns", ".ui.VideoAdPlayerUI", intent);
                        } else if (bnp != null && !bi.oN(bnp.hfc) && !bi.oN(bnp.hfd)) {
                            x.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + bnp.hfd);
                            final Intent intent2 = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", nJ.fHB);
                            intent2.putExtra("jsapiargs", bundle);
                            intent2.putExtra("rawUrl", bnp.hfd);
                            intent2.putExtra("useJs", true);
                            as.CN().a(new c("", 18, 5, "", 2, -1), 0);
                            new ag(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    com.tencent.mm.bl.d.b(j.this.yMd.yLH.mController.xRr, "webview", ".ui.tools.WebViewUI", intent2);
                                }
                            });
                        }
                    }
                }
            });
        }
        return this;
    }

    public final j cvZ() {
        if (this.yOX == null) {
            this.yOX = (RelativeLayout) ((ViewStub) this.nav.findViewById(R.h.cVB)).inflate();
            this.yOY = (ImageView) this.yOX.findViewById(R.h.cVe);
            this.yOZ = (ImageView) this.yOX.findViewById(R.h.cVM);
            this.yOZ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (j.this.yMd != null) {
                        x.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", Integer.valueOf(j.this.hashCode()), Integer.valueOf(j.this.mPosition));
                        j.this.yMd.Gj(j.this.mPosition);
                    }
                }
            });
            com.tencent.mm.modelcontrol.d.Na();
            if (com.tencent.mm.modelcontrol.d.Nh()) {
                this.yPa = new VideoPlayerTextureView(this.nav.getContext());
                g.pWK.a(354, 150, 1, false);
            } else {
                this.yPa = new VideoTextureView(this.nav.getContext());
                g.pWK.a(354, 151, 1, false);
            }
            this.yPc = (TextView) this.nav.findViewById(R.h.cat);
            this.yPa.ii(true);
            this.yOX.addView((View) this.yPa, 2, new RelativeLayout.LayoutParams(-1, -1));
            this.yPb = (MMPinProgressBtn) this.yOX.findViewById(R.h.cUY);
            this.yPb.setVisibility(8);
            ((View) this.yPa).setVisibility(8);
            this.yPa.a(new a() {
                public final void hY() {
                    if (j.this.yMd != null) {
                        j.this.yMd.yLN.cvT();
                    }
                }

                public final void onError(int i, int i2) {
                    x.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + i + " extra: " + i2);
                    if (j.this.yMd != null) {
                        j.this.yMd.yLN.fb(i, i2);
                    }
                    g.pWK.h(12084, Integer.valueOf(j.this.yPn), Integer.valueOf(j.this.rqU * 1000), Integer.valueOf(0), Integer.valueOf(4), j.this.fAJ, Integer.valueOf(j.this.yPo), j.this.fAM, Long.valueOf(j.this.hXs));
                }

                public final void vi() {
                    ah.y(new Runnable() {
                        public final void run() {
                            j.this.yMd.yLH.nc(true);
                            b bVar = j.this.yMd;
                            bVar.yLN.Gz(j.this.mPosition);
                            ImageGalleryUI.cvI();
                            j.this.yMd.yLN.cvU();
                        }
                    });
                }

                public final int ck(final int i, final int i2) {
                    x.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", Integer.valueOf(i), Integer.valueOf(j.this.rqU), Integer.valueOf(i2), Integer.valueOf(j.this.yPn), Integer.valueOf(j.this.yPo), j.this.fAJ);
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            g gVar = g.pWK;
                            Object[] objArr = new Object[8];
                            objArr[0] = Integer.valueOf(j.this.yPn);
                            objArr[1] = Integer.valueOf(i2 <= 0 ? j.this.rqU * 1000 : i2);
                            objArr[2] = Integer.valueOf(i);
                            objArr[3] = Integer.valueOf(1);
                            objArr[4] = j.this.fAJ;
                            objArr[5] = Integer.valueOf(j.this.yPo);
                            objArr[6] = j.this.fAM;
                            objArr[7] = Long.valueOf(j.this.hXs);
                            gVar.h(12084, objArr);
                        }
                    });
                    return 0;
                }

                public final void cl(int i, int i2) {
                }
            });
        }
        return this;
    }

    public final void a(boolean z, float f) {
        x.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", Integer.valueOf(hashCode()), Boolean.valueOf(z), Float.valueOf(f));
        if (z) {
            View view = (View) cvZ().yPa;
            view.setAlpha(f);
            N(view, 0);
            if (((double) f) >= 1.0d) {
                N(cvZ().yOY, 8);
                N(cvZ().yOZ, 8);
                return;
            }
            return;
        }
        N((View) cvZ().yPa, 8);
        N(cvZ().yOY, 0);
        N(cvZ().yOZ, 0);
    }
}
