package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.a.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.i;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.x.n;
import com.tencent.mm.y.d;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.mm.y.u;
import com.tencent.wcdb.FileUtils;

@a(19)
public class VideoAdPlayerUI extends MMActivity implements b.a, b.b {
    private String bssid;
    private String fHB;
    private String fwx = "";
    private String hFn = "";
    private String hfc = "";
    private String hfd = "";
    private String iWv = "";
    private d jwC;
    private boolean loa = false;
    private String mediaId = "";
    private boolean qWK = false;
    private m rEl;
    private h rMq = new h("VideoAdPlayerUI");
    private VideoPlayView rTe;
    private com.tencent.mm.modelsns.b rTf = null;
    private String rTg = "";
    private int rTh = 0;
    private String rTi = "";
    public String rTj = "";
    public String rTk = "";
    private int rTl = 0;
    private int rTm = 0;
    private String rTn = "";
    private String rTo;
    private String rTp = "";
    private long rTq = 0;
    private int rTr = 0;
    private int rTs = 0;
    private boolean rTt = false;
    private boolean rTu = false;
    private are rTv = null;
    private String rTw;
    private int rTx;
    private String[] rTy = null;
    private String[] rTz = null;
    private String rmN = "";
    private String ssid;
    private String thumbUrl = "";
    private String url = "";

    static /* synthetic */ void o(VideoAdPlayerUI videoAdPlayerUI) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_link", videoAdPlayerUI.rTg);
        intent.putExtra("Ksnsupload_type", 11);
        intent.putExtra("Ksnsupload_title", videoAdPlayerUI.rTi);
        intent.putExtra("Ksnsupload_imgurl", videoAdPlayerUI.thumbUrl);
        intent.putExtra("KSnsStreamVideoTotalTime", videoAdPlayerUI.rTv.rTh);
        intent.putExtra("KSnsStreamVideoWroding", videoAdPlayerUI.hfc);
        intent.putExtra("KSnsStreamVideoWebUrl", videoAdPlayerUI.hfd);
        intent.putExtra("KSnsStreamVideoAduxInfo", videoAdPlayerUI.rTj);
        intent.putExtra("KSnsStreamVideoPublishId", videoAdPlayerUI.rTk);
        intent.putExtra("need_result", true);
        intent.putExtra("key_snsad_statextstr", videoAdPlayerUI.fHB);
        String str = "sns_";
        if (videoAdPlayerUI.rTm == j.b.Sight.value || videoAdPlayerUI.rTm == j.b.AdUrl.value) {
            str = "sns_" + videoAdPlayerUI.rTp;
        } else if (videoAdPlayerUI.rTm == j.b.Chat.value || videoAdPlayerUI.rTm == j.b.TalkChat.value) {
            str = "msg_" + videoAdPlayerUI.rTq;
        } else if (videoAdPlayerUI.rTm == j.b.Fav.value) {
            str = "fav_" + q.FY() + "_" + videoAdPlayerUI.rTr;
        }
        String hC = u.hC(str);
        u.GQ().t(hC, true).o("prePublishId", str);
        intent.putExtra("reportSessionId", hC);
        com.tencent.mm.bl.d.b(videoAdPlayerUI, "sns", ".ui.SnsUploadUI", intent, 4098);
        if (videoAdPlayerUI.rTx != 0) {
            int i = videoAdPlayerUI.rMq.qVw.qWu;
            if (videoAdPlayerUI.loa && videoAdPlayerUI.rMq.qVw.qWy != 0) {
                i += (int) (bi.bB(videoAdPlayerUI.rMq.qVw.qWy) / 1000);
            }
            k iVar = new i(13228, "1,4," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + bi.Wx() + "," + videoAdPlayerUI.rTw + "," + videoAdPlayerUI.rTh, (int) bi.Wx());
            g.Dr();
            g.Dp().gRu.a(iVar, 0);
        }
    }

    static /* synthetic */ void p(VideoAdPlayerUI videoAdPlayerUI) {
        com.tencent.mm.sdk.b.b cgVar = new cg();
        ((com.tencent.mm.plugin.fav.a.q) g.h(com.tencent.mm.plugin.fav.a.q.class)).a(cgVar, videoAdPlayerUI.rTv.rTh, videoAdPlayerUI.rTi, "", videoAdPlayerUI.rTv.wEW, videoAdPlayerUI.hfc, videoAdPlayerUI.hfd, videoAdPlayerUI.thumbUrl, videoAdPlayerUI.fwx, videoAdPlayerUI.rTn, videoAdPlayerUI.rTj, videoAdPlayerUI.rTk, videoAdPlayerUI.fHB);
        cgVar.frk.activity = videoAdPlayerUI;
        cgVar.frk.frr = 24;
        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
        if (cgVar.frl.ret == 0 && videoAdPlayerUI.rTm != 0) {
            j.a(c.Fav, videoAdPlayerUI.rTk, videoAdPlayerUI.rTj, videoAdPlayerUI.rTl, videoAdPlayerUI.rTm, videoAdPlayerUI.rTn, videoAdPlayerUI.rTo, videoAdPlayerUI.rTp, videoAdPlayerUI.rTq, videoAdPlayerUI.rTr, videoAdPlayerUI.rTs, 0);
        }
        if (videoAdPlayerUI.qWK) {
            k cVar = new com.tencent.mm.plugin.sns.a.b.c(videoAdPlayerUI.iWv, 11, 6, "", 2, videoAdPlayerUI.rEl.byG());
            g.Dr();
            g.Dp().gRu.a(cVar, 0);
        }
        if (videoAdPlayerUI.rTx != 0) {
            int i = videoAdPlayerUI.rMq.qVw.qWu;
            if (videoAdPlayerUI.loa && videoAdPlayerUI.rMq.qVw.qWy != 0) {
                i += (int) (bi.bB(videoAdPlayerUI.rMq.qVw.qWy) / 1000);
            }
            k iVar = new i(13228, "1,5," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + bi.Wx() + "," + videoAdPlayerUI.rTw + "," + videoAdPlayerUI.rTh, (int) bi.Wx());
            g.Dr();
            g.Dp().gRu.a(iVar, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        String r;
        super.onCreate(bundle);
        this.mController.hideTitleView();
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.rTy = new String[]{getString(com.tencent.mm.plugin.sns.i.j.qQf), getString(com.tencent.mm.plugin.sns.i.j.qQg), getString(com.tencent.mm.plugin.sns.i.j.qQe)};
        this.rTz = new String[]{getString(com.tencent.mm.plugin.sns.i.j.qQf), getString(com.tencent.mm.plugin.sns.i.j.qQg)};
        this.rEl = ae.bwf().LQ(com.tencent.mm.plugin.sns.data.i.lV(getIntent().getStringExtra("KSta_SnSId")));
        this.jwC = new d();
        this.rTf = com.tencent.mm.modelsns.b.q(getIntent());
        this.hFn = getIntent().getStringExtra("KFullVideoPath");
        this.rTg = getIntent().getStringExtra("KStremVideoUrl");
        this.thumbUrl = getIntent().getStringExtra("KThumUrl");
        this.mediaId = getIntent().getStringExtra("KMediaId");
        this.qWK = getIntent().getBooleanExtra("IsAd", false);
        this.url = getIntent().getStringExtra("KUrl");
        this.rTi = bi.aD(getIntent().getStringExtra("KMediaTitle"), "");
        this.rTh = getIntent().getIntExtra("KMediaVideoTime", 0);
        this.rTt = getIntent().getBooleanExtra("KBlockFav", false);
        this.rTu = getIntent().getBooleanExtra("ForceLandscape", false);
        this.hfc = getIntent().getStringExtra("StreamWording");
        this.hfd = getIntent().getStringExtra("StremWebUrl");
        this.rmN = getIntent().getStringExtra("KComponentCid");
        this.rTj = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
        this.rTk = getIntent().getStringExtra("KSta_StremVideoPublishId");
        this.rTl = getIntent().getIntExtra("KSta_SourceType", 0);
        this.rTm = getIntent().getIntExtra("KSta_Scene", 0);
        this.rTn = getIntent().getStringExtra("KSta_FromUserName");
        this.rTo = getIntent().getStringExtra("KSta_ChatName");
        this.rTp = getIntent().getStringExtra("KSta_SnSId");
        this.rTq = getIntent().getLongExtra("KSta_MsgId", 0);
        this.rTr = getIntent().getIntExtra("KSta_FavID", 0);
        this.rTs = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
        this.fHB = getIntent().getStringExtra("KSta_SnsStatExtStr");
        this.iWv = bi.aD(getIntent().getStringExtra("KViewId"), "");
        this.rTw = bi.aD(getIntent().getStringExtra("ReportArgs"), "");
        this.rTx = getIntent().getIntExtra("NeedReportData", 0);
        if (this.rTx != 0) {
            WifiInfo connectionInfo = ((WifiManager) getSystemService("wifi")).getConnectionInfo();
            this.ssid = connectionInfo.getSSID();
            this.bssid = connectionInfo.getBSSID();
        }
        this.rTv = new are();
        this.rTv.wEP = this.thumbUrl;
        this.rTv.wEW = this.rTg;
        this.rTv.nMq = this.mediaId;
        this.rTv.nlE = this.url;
        this.rTv.wEO = 1;
        this.rTv.rTh = this.rTh;
        this.rMq.qVq = bi.Wz();
        x.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.rTv.nMq + " attachurl:" + this.rTv.wEW + " videoattachTotalTime:" + this.rTv.rTh + " streamvideowording: " + this.hfc + " streamvideoweburl: " + this.hfd + " mediaTitle: " + this.rTi + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.rTj + " streamvideopublishid " + this.rTk);
        if (bi.oN(this.hFn)) {
            r = am.r(ae.getAccSnsPath(), this.rTv.nMq);
            this.hFn = r + com.tencent.mm.plugin.sns.data.i.k(this.rTv);
        }
        if (bi.oN(this.fwx) || !e.bO(this.fwx)) {
            r = "attach" + this.rTv.nMq;
            this.fwx = am.r(ae.getAccSnsPath(), r) + com.tencent.mm.plugin.sns.data.i.Ki(r);
        }
        if (!e.bO(this.fwx)) {
            try {
                are are = new are();
                are.aH(this.rTv.toByteArray());
                are.nMq = "attach" + are.nMq;
                com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(this.rTv);
                eVar.qWU = 1;
                eVar.hMN = this.rTv.nMq;
                ae.bwa().a(are, 7, eVar, an.xHx);
            } catch (Exception e) {
                x.e("MicroMsg.VideoPlayerUI", "error for download thumb");
            }
            getWindow().addFlags(FileUtils.S_IWUSR);
        }
        this.rTe = (VideoPlayView) findViewById(f.qMg);
        VideoPlayView videoPlayView = this.rTe;
        com.tencent.mm.plugin.sight.decode.ui.a adVideoPlayerLoadingBar = new AdVideoPlayerLoadingBar(this.mController.xRr);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = BackwardSupportUtil.b.b(videoPlayView.getContext(), videoPlayView.getContext().getResources().getDimension(com.tencent.mm.plugin.ah.a.c.qEM));
        videoPlayView.qBg = adVideoPlayerLoadingBar;
        videoPlayView.kYP.ii(true);
        videoPlayView.addView((View) videoPlayView.qBg, layoutParams);
        videoPlayView.qBg.a(new com.tencent.mm.plugin.sight.decode.ui.b() {
            public final void ahn() {
                VideoPlayView.this.hbP.removeCallbacks(VideoPlayView.this.qBu);
                VideoPlayView.this.btO();
            }

            public final void kK(int i) {
                x.i("MicroMsg.VideoPlayView", "onSeek time " + i);
                VideoPlayView.this.qBh = (double) i;
                VideoPlayView.this.kYP.q((double) i);
                VideoPlayView.this.hbP.removeCallbacks(VideoPlayView.this.qBu);
                VideoPlayView.this.hbP.postDelayed(VideoPlayView.this.qBu, 3000);
            }
        });
        videoPlayView.qBg.h(new OnClickListener() {
            public final void onClick(View view) {
                VideoPlayView.this.hbP.removeCallbacks(VideoPlayView.this.qBu);
                VideoPlayView.this.hbP.postDelayed(VideoPlayView.this.qBu, 3000);
                if (VideoPlayView.this.kYP.isPlaying()) {
                    VideoPlayView.this.wE(-1);
                    if (VideoPlayView.this.qBg != null) {
                        VideoPlayView.this.qBg.dd(false);
                        return;
                    }
                    return;
                }
                VideoPlayView.this.ih(false);
                VideoPlayView.this.kYP.q(VideoPlayView.this.qBh);
                if (VideoPlayView.this.qBg != null) {
                    VideoPlayView.this.qBg.dd(true);
                }
            }
        });
        videoPlayView.qBg.dd(videoPlayView.kYP.isPlaying());
        if (videoPlayView.qBg != null) {
            ((View) videoPlayView.qBg).setVisibility(8);
        }
        adVideoPlayerLoadingBar.seek(0);
        this.rTe.qBe = new VideoPlayView.a() {
            public final void ij(boolean z) {
                if (z) {
                    VideoAdPlayerUI.this.rMq.qVw.qWx = VideoAdPlayerUI.this.getResources().getConfiguration().orientation == 2 ? 2 : 1;
                    VideoAdPlayerUI.this.rMq.qVw.qWy = bi.Wz();
                    VideoAdPlayerUI.this.rMq.qVw.qWw = 2;
                    VideoAdPlayerUI.this.rMq.qVw.qWu = 0;
                }
                if (!VideoAdPlayerUI.this.loa && ((int) VideoAdPlayerUI.this.rTe.btQ()) == 0) {
                    com.tencent.mm.plugin.sns.a.b.a.a aVar = VideoAdPlayerUI.this.rMq.qVw;
                    aVar.qWs++;
                }
                VideoAdPlayerUI.this.rMq.qVw.qWy = bi.Wz();
                VideoAdPlayerUI.this.jwC.a(VideoAdPlayerUI.this.rTe);
                if (VideoAdPlayerUI.this.rTx != 0) {
                    k iVar = new i(13227, "1,1,0," + VideoAdPlayerUI.this.ssid + "," + VideoAdPlayerUI.this.bssid + "," + bi.Wx() + "," + VideoAdPlayerUI.this.rTw + "," + VideoAdPlayerUI.this.rTh, (int) bi.Wx());
                    g.Dr();
                    g.Dp().gRu.a(iVar, 0);
                }
                VideoAdPlayerUI.this.loa = true;
            }

            public final void btS() {
                VideoAdPlayerUI.this.jwC.bz(false);
                com.tencent.mm.plugin.sns.a.b.a.a aVar = VideoAdPlayerUI.this.rMq.qVw;
                aVar.qWu += (int) bi.bB(VideoAdPlayerUI.this.rMq.qVw.qWy);
                VideoAdPlayerUI.this.loa = false;
            }

            public final void btT() {
                x.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
                com.tencent.mm.plugin.sns.a.b.a.a aVar = VideoAdPlayerUI.this.rMq.qVw;
                aVar.qWt++;
                VideoAdPlayerUI.this.loa = false;
                if (VideoAdPlayerUI.this.rTx != 0) {
                    k iVar = new i(13227, "1,2," + VideoAdPlayerUI.this.rTh + "," + VideoAdPlayerUI.this.ssid + "," + VideoAdPlayerUI.this.bssid + "," + bi.Wx() + "," + VideoAdPlayerUI.this.rTw + "," + VideoAdPlayerUI.this.rTh, (int) bi.Wx());
                    g.Dr();
                    g.Dp().gRu.a(iVar, 0);
                }
            }

            public final void btU() {
                x.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
                VideoAdPlayerUI.this.loa = false;
                VideoAdPlayerUI.this.rTe.btN();
            }

            public final void wF(int i) {
                if (VideoAdPlayerUI.this.rTh == 0) {
                    VideoAdPlayerUI.this.rTh = i;
                    VideoAdPlayerUI.this.rTv.rTh = i;
                }
            }
        };
        VideoPlayView videoPlayView2 = this.rTe;
        int i = this.rTv.rTh;
        if (videoPlayView2.qBg.btG() != i) {
            videoPlayView2.qBg.wD(i);
        }
        if (e.bO(this.hFn)) {
            this.rMq.qVo = 1;
            this.rTe.setVideoPath(this.hFn);
        } else {
            this.rTe.btN();
            this.rTe.ig(true);
            ae.bwa().a(this.rTv, 6, null, an.xHx);
        }
        videoPlayView2 = this.rTe;
        videoPlayView2.qBk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                VideoAdPlayerUI.this.finish();
            }
        });
        videoPlayView2 = this.rTe;
        videoPlayView2.qBl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String[] l;
                Context context = VideoAdPlayerUI.this;
                if (VideoAdPlayerUI.this.rTt) {
                    l = VideoAdPlayerUI.this.rTz;
                } else {
                    l = VideoAdPlayerUI.this.rTy;
                }
                com.tencent.mm.ui.base.h.a(context, null, l, null, new com.tencent.mm.ui.base.h.c() {
                    public final void jo(int i) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("ad_video_title", VideoAdPlayerUI.this.rTi);
                                intent.putExtra("Retr_Msg_Type", 2);
                                com.tencent.mm.bl.d.a(VideoAdPlayerUI.this, ".ui.transmit.SelectConversationUI", intent, 4097);
                                return;
                            case 1:
                                VideoAdPlayerUI.o(VideoAdPlayerUI.this);
                                return;
                            case 2:
                                VideoAdPlayerUI.p(VideoAdPlayerUI.this);
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
        });
        videoPlayView2 = this.rTe;
        CharSequence charSequence = this.hfc;
        OnClickListener anonymousClass4 = new OnClickListener() {
            public final void onClick(View view) {
                if (VideoAdPlayerUI.this.rTm != 0) {
                    j.a(j.a.DetailInVideo, VideoAdPlayerUI.this.rTk, VideoAdPlayerUI.this.rTj, VideoAdPlayerUI.this.rTl, VideoAdPlayerUI.this.rTm, VideoAdPlayerUI.this.rTn, VideoAdPlayerUI.this.rTo, VideoAdPlayerUI.this.rTp, VideoAdPlayerUI.this.rTq, VideoAdPlayerUI.this.rTr, VideoAdPlayerUI.this.rTs);
                }
                if (VideoAdPlayerUI.this.rTx != 0) {
                    int i = VideoAdPlayerUI.this.rMq.qVw.qWu;
                    if (VideoAdPlayerUI.this.loa && VideoAdPlayerUI.this.rMq.qVw.qWy != 0) {
                        i += (int) (bi.bB(VideoAdPlayerUI.this.rMq.qVw.qWy) / 1000);
                    }
                    k iVar = new i(13228, "1,1," + i + "," + VideoAdPlayerUI.this.ssid + "," + VideoAdPlayerUI.this.bssid + "," + bi.Wx() + "," + VideoAdPlayerUI.this.rTw + "," + VideoAdPlayerUI.this.rTh, (int) bi.Wx());
                    g.Dr();
                    g.Dp().gRu.a(iVar, 0);
                }
                VideoAdPlayerUI.this.finish();
                final Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("key_snsad_statextstr", VideoAdPlayerUI.this.fHB);
                intent.putExtra("jsapiargs", bundle);
                intent.putExtra("rawUrl", VideoAdPlayerUI.this.hfd);
                intent.putExtra("useJs", true);
                if (VideoAdPlayerUI.this.qWK) {
                    k cVar = new com.tencent.mm.plugin.sns.a.b.c(VideoAdPlayerUI.this.iWv, 18, 6, "", 2, VideoAdPlayerUI.this.rEl.byG());
                    g.Dr();
                    g.Dp().gRu.a(cVar, 0);
                }
                new ag(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        com.tencent.mm.plugin.sns.c.a.ihN.j(intent, VideoAdPlayerUI.this);
                    }
                });
            }
        };
        videoPlayView2.qBj = charSequence;
        videoPlayView2.qBi.setText(charSequence);
        videoPlayView2.qBi.setOnClickListener(anonymousClass4);
        this.rTe.btP();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0) {
            videoPlayView2 = this.rTe;
            if (videoPlayView2.qBl != null) {
                videoPlayView2.qBm = false;
                videoPlayView2.qBl.setVisibility(8);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        k cVar;
        x.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", Integer.valueOf(i));
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : bi.F(stringExtra.split(","))) {
                    int i3;
                    x.i("MicroMsg.VideoPlayerUI", "send sight to %s", str);
                    com.tencent.mm.x.g.a aVar = new com.tencent.mm.x.g.a();
                    aVar.title = this.rTi;
                    aVar.type = 4;
                    if (bi.oN(this.rTv.nlE)) {
                        aVar.url = this.rTv.wEW;
                    } else {
                        aVar.url = this.rTv.nlE;
                    }
                    if (bi.oN(this.rTv.wEZ)) {
                        stringExtra = this.rTv.wEP;
                    } else {
                        stringExtra = this.rTv.wEZ;
                    }
                    aVar.thumburl = stringExtra;
                    aVar.heZ = this.rTv.wEW;
                    aVar.hfa = this.rTv.rTh;
                    aVar.hfb = this.rTi;
                    aVar.hfd = this.hfd;
                    aVar.hfc = this.hfc;
                    aVar.hfe = this.thumbUrl;
                    aVar.hff = this.rTj;
                    aVar.hfg = this.rTk;
                    aVar.fHB = this.fHB;
                    byte[] d = FileOp.d(this.fwx, 0, -1);
                    String str2 = "MicroMsg.VideoPlayerUI";
                    String str3 = "read buf size %d";
                    Object[] objArr = new Object[1];
                    if (d == null) {
                        i3 = 0;
                    } else {
                        i3 = d.length;
                    }
                    objArr[0] = Integer.valueOf(i3);
                    x.i(str2, str3, objArr);
                    if (n.a.EU() != null) {
                        n.a.EU().a(aVar, "", "", str, "", d);
                    }
                    if (this.rTx != 0) {
                        i3 = this.rMq.qVw.qWu;
                        if (this.loa && this.rMq.qVw.qWy != 0) {
                            i3 += (int) (bi.bB(this.rMq.qVw.qWy) / 1000);
                        }
                        k iVar = new i(13228, "1,3," + i3 + "," + this.ssid + "," + this.bssid + "," + bi.Wx() + "," + this.rTw + "," + this.rTh, (int) bi.Wx());
                        g.Dr();
                        g.Dp().gRu.a(iVar, 0);
                    }
                    com.tencent.mm.plugin.messenger.a.f.aZN().dq(stringExtra2, str);
                    if (this.qWK) {
                        k cVar2 = new com.tencent.mm.plugin.sns.a.b.c(this.iWv, 12, 6, "", 2, this.rEl.byG());
                        g.Dr();
                        g.Dp().gRu.a(cVar2, 0);
                    }
                    if (this.rTm != 0) {
                        c cVar3;
                        int gn;
                        boolean eX = s.eX(str);
                        if (eX) {
                            cVar3 = c.Chatroom;
                        } else {
                            cVar3 = c.Chat;
                        }
                        String str4 = this.rTk;
                        str2 = this.rTj;
                        int i4 = this.rTl;
                        int i5 = this.rTm;
                        String str5 = this.rTn;
                        String str6 = this.rTo;
                        String str7 = this.rTp;
                        long j = this.rTq;
                        int i6 = this.rTr;
                        int i7 = this.rTs;
                        if (eX) {
                            gn = com.tencent.mm.y.m.gn(str);
                        } else {
                            gn = 0;
                        }
                        j.a(cVar3, str4, str2, i4, i5, str5, str6, str7, j, i6, i7, gn);
                    }
                }
                com.tencent.mm.ui.snackbar.a.h(this, getString(com.tencent.mm.plugin.sns.i.j.epo));
            } else if (this.qWK) {
                cVar = new com.tencent.mm.plugin.sns.a.b.c(this.iWv, 13, 6, "", 2, this.rEl.byG());
                g.Dr();
                g.Dp().gRu.a(cVar, 0);
            }
        }
        if (4098 == i) {
            if (this.rTm != 0) {
                j.a(c.Sns, this.rTk, this.rTj, this.rTl, this.rTm, this.rTn, this.rTo, this.rTp, this.rTq, this.rTr, this.rTs, 0);
            }
            if (-1 == i2) {
                if (this.qWK) {
                    cVar = new com.tencent.mm.plugin.sns.a.b.c(this.iWv, 15, 6, "", 2, this.rEl.byG());
                    g.Dr();
                    g.Dp().gRu.a(cVar, 0);
                }
            } else if (this.qWK) {
                cVar = new com.tencent.mm.plugin.sns.a.b.c(this.iWv, 16, 6, "", 2, this.rEl.byG());
                g.Dr();
                g.Dp().gRu.a(cVar, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(FileUtils.S_IWUSR);
        if (this.rTm != 0) {
            j.a(j.a.LeaveCompleteVideo, this.rTk, this.rTj, this.rTl, this.rTm, this.rTn, this.rTo, this.rTp, this.rTq, this.rTr, this.rTs);
        }
        if (this.qWK) {
            int bzm = this.rEl == null ? 0 : this.rEl.bzm();
            String buJ = this.rMq.buJ();
            long j = ((long) this.rMq.qVp) - this.rMq.hQr;
            if (j < 0) {
                x.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", Integer.valueOf(this.rMq.qVp), Long.valueOf(this.rMq.hQr));
                j = (long) this.rMq.qVp;
            }
            int i = (int) j;
            g.Dr();
            g.Dp().gRu.a(new com.tencent.mm.plugin.sns.a.b.d(this.iWv, 6, 2, this.rMq.qVp, null, null, 2, buJ, -1, bzm, i, i, 0), 0);
        }
        if (this.rTx != 0) {
            int i2 = this.rMq.qVw.qWu;
            if (this.loa && this.rMq.qVw.qWy != 0) {
                i2 += (int) (bi.bB(this.rMq.qVw.qWy) / 1000);
            }
            k iVar = new i(13228, "1,2," + i2 + "," + this.ssid + "," + this.bssid + "," + bi.Wx() + "," + this.rTw + "," + this.rTh, (int) bi.Wx());
            g.Dr();
            g.Dp().gRu.a(iVar, 0);
        }
        setResult(-1, getIntent().putExtra("key_activity_browse_time", cnN()));
    }

    public void finish() {
        if (this.loa) {
            this.rTe.pause();
        }
        if (!(this.rMq == null || this.rmN == null || this.rmN.length() <= 0)) {
            this.rMq.buK();
            Intent intent = new Intent();
            intent.putExtra("KComponentCid", this.rmN);
            intent.putExtra("KStreamVideoPlayCount", this.rMq.qVs);
            intent.putExtra("KStreamVideoPlayCompleteCount", this.rMq.qVt);
            intent.putExtra("KStreamVideoTotalPlayTimeInMs", this.rMq.qVu);
            setResult(-1, intent);
        }
        super.finish();
    }

    protected void onPause() {
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        x.i("MicroMsg.VideoPlayerUI", "onpause  " + i);
        yd(i);
        if (this.rTe != null && this.rTe.isPlaying()) {
            this.rTe.pause();
        }
        if (this.rTe != null) {
            x.i("MicroMsg.VideoPlayerUI", "onDetach");
            this.rTe.onDetach();
        }
        ae.bwa().qYF.remove(this);
        ae.bwa().b((b.b) this);
        if (this.rMq != null) {
            this.rMq.hQq = bi.Wz();
        }
    }

    protected void onResume() {
        super.onResume();
        ae.bwa().qYF.add(this);
        ae.bwa().a((b.b) this);
        if (this.rMq != null) {
            this.rMq.onResume();
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.qOw;
    }

    public final void ef(String str, String str2) {
        x.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.rTe.isPlaying());
        if (!this.rTe.isPlaying()) {
            this.rTe.cR(false);
            if (str2.equals(this.rTe.hFn)) {
                this.rTe.q(this.rTe.btQ());
                this.rTe.start();
                x.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + str + " path: " + str2);
                return;
            }
            this.rTe.setVideoPath(str2);
            this.rTe.q(this.rTe.btQ());
            x.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + str + " path: " + str2);
        }
    }

    public final void Ky(String str) {
    }

    public final void aE(String str, boolean z) {
    }

    public final void buX() {
    }

    public final void aF(String str, boolean z) {
        x.i("MicroMsg.VideoPlayerUI", "onSightFinish " + str);
        this.rTe.ig(false);
        this.rTe.setVideoPath(this.hFn);
        this.rTe.q(this.rTe.btQ());
        this.rTe.cR(false);
        if (this.qWK && !bi.oN(str) && this.rTv != null && str.equals(this.rTv.nMq) && FileOp.bO(this.hFn)) {
            this.rMq.qVo = 1;
        }
    }

    protected final int getForceOrientation() {
        if (this.rTu) {
            return 0;
        }
        return 4;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        VideoPlayView videoPlayView = this.rTe;
        x.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + configuration.orientation + " " + videoPlayView.qBv);
        if (videoPlayView.qBv != configuration.orientation) {
            if (configuration.orientation == 1) {
                videoPlayView.update(1);
            } else {
                videoPlayView.update(2);
            }
            videoPlayView.qBv = configuration.orientation;
            if (videoPlayView.qBv == 2) {
                videoPlayView.kbO.setVisibility(8);
            }
        }
        yd(configuration.orientation);
    }

    private void yd(int i) {
        if (this.qWK) {
            this.rMq.wJ(this.rTe.getDuration());
            this.rMq.qVw.qWy = bi.Wz();
            this.rMq.qVw.qWx = i == 2 ? 2 : 1;
            this.rMq.qVw.qWw = 2;
            x.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.rMq.qVw.qWx);
        }
    }
}
