package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.ThumbnailUtils;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.plugin.appbrand.jsapi.video.f.b;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandVideoView extends RelativeLayout {
    private int joi;
    AppBrandVideoWrapper jvA;
    private TextView jvB;
    private DanmuView jvC;
    AppBrandVideoViewControlBar jvD;
    private View jvE;
    private View jvF;
    TextView jvG;
    private LinearLayout jvH;
    private AppBrandDotPercentIndicator jvI;
    private TextView jvJ;
    private ImageView jvK;
    private ImageView jvL;
    String jvM;
    int jvN;
    private boolean jvO;
    e jvP;
    private boolean jvQ;
    private f jvR;
    a jvS;
    private boolean jvT;
    private boolean jvU;
    private int jvV;
    private String jvW;
    boolean jvX;
    private boolean jvY;
    private boolean jvZ;
    private int jvz = -1;
    private boolean jwa;
    private boolean jwb;
    String mAppId;
    boolean mAutoPlay;
    int mDuration;

    public interface a {
        void agI();

        boolean isFullScreen();

        void kC(int i);
    }

    static /* synthetic */ void a(AppBrandVideoView appBrandVideoView, boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.AppBrandVideoView", "updateLiveUI isLive:%b", Boolean.valueOf(z));
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = appBrandVideoView.jvD;
        boolean z3 = appBrandVideoView.jwa && z;
        appBrandVideoViewControlBar.cT(z3);
        AppBrandVideoViewControlBar appBrandVideoViewControlBar2 = appBrandVideoView.jvD;
        if (!appBrandVideoView.jvZ || z) {
            z2 = false;
        }
        appBrandVideoViewControlBar2.cU(z2);
    }

    static /* synthetic */ boolean h(AppBrandVideoView appBrandVideoView) {
        return appBrandVideoView.jvY && !appBrandVideoView.jvA.ahf();
    }

    public AppBrandVideoView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(h.izQ, this);
        this.jvA = (AppBrandVideoWrapper) findViewById(g.cVJ);
        this.jvB = (TextView) findViewById(g.progress);
        this.jvE = findViewById(g.bZo);
        this.jvF = findViewById(g.iyb);
        this.jvG = (TextView) findViewById(g.iyc);
        this.jvH = (LinearLayout) findViewById(g.bJy);
        this.jvI = (AppBrandDotPercentIndicator) findViewById(g.bJz);
        this.jvJ = (TextView) findViewById(g.bJw);
        this.jvK = (ImageView) findViewById(g.bJx);
        this.jvL = (ImageView) findViewById(g.bZn);
        ViewGroup viewGroup = this.jvI;
        viewGroup.jvh = 8;
        viewGroup.removeAllViews();
        for (int i = 0; i < viewGroup.jvh; i++) {
            viewGroup.addView((ImageView) viewGroup.DF.inflate(h.izj, viewGroup, false));
        }
        ((ImageView) findViewById(g.iya)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppBrandVideoView.this.start();
            }
        });
        this.jvR = new f(getContext(), this, new b() {
            public final void ahi() {
                x.d("MicroMsg.AppBrandVideoView", "onSingleTap");
                if (AppBrandVideoView.this.jvO) {
                    AppBrandVideoView.this.jvD.ahr();
                }
            }

            public final void ahj() {
                x.d("MicroMsg.AppBrandVideoView", "onDoubleTap");
            }

            public final void ahk() {
                if (AppBrandVideoView.h(AppBrandVideoView.this)) {
                    AppBrandVideoView.this.jvB.setVisibility(0);
                }
            }

            public final int e(int i, float f) {
                int i2 = 0;
                if (AppBrandVideoView.h(AppBrandVideoView.this)) {
                    x.i("MicroMsg.AppBrandVideoView", "onDragProgress:" + i + "/" + f);
                    float measuredWidth = f / ((float) AppBrandVideoView.this.getMeasuredWidth());
                    int ahy = AppBrandVideoView.this.jvA.ahy();
                    int currentPosition = ((int) (measuredWidth * ((float) ahy))) + getCurrentPosition();
                    if (currentPosition >= 0) {
                        if (currentPosition > ahy) {
                            i2 = ahy;
                        } else {
                            i2 = currentPosition;
                        }
                    }
                    AppBrandVideoView.this.jvB.setText(g.bq(((long) i2) * 1000) + "/" + g.bq(((long) ahy) * 1000));
                }
                return i2;
            }

            public final void f(int i, float f) {
                AppBrandVideoView.this.jvB.setVisibility(8);
                int ahA = AppBrandVideoView.this.jvA.ahA();
                x.i("MicroMsg.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", Integer.valueOf(i), Integer.valueOf(ahA), Float.valueOf(f));
                if (AppBrandVideoView.h(AppBrandVideoView.this)) {
                    AppBrandVideoView.this.w(i, false);
                }
            }

            public final int getCurrentPosition() {
                return AppBrandVideoView.this.jvA.ahA();
            }

            public final void Y(float f) {
                x.d("MicroMsg.AppBrandVideoView", "onAdjustVolume:" + f);
                AppBrandVideoView.this.jvI.X(f);
                AppBrandVideoView.this.jvJ.setText(j.iDQ);
                AppBrandVideoView.this.jvK.setImageResource(i.iAF);
                AppBrandVideoView.this.jvH.setVisibility(0);
            }

            public final void Z(float f) {
                x.d("MicroMsg.AppBrandVideoView", "onAdjustBrightness:" + f);
                AppBrandVideoView.this.jvI.X(f);
                AppBrandVideoView.this.jvJ.setText(j.iDP);
                AppBrandVideoView.this.jvK.setImageResource(i.iAu);
                AppBrandVideoView.this.jvH.setVisibility(0);
            }

            public final void ahl() {
                AppBrandVideoView.this.jvH.setVisibility(8);
            }

            public final void ahm() {
                AppBrandVideoView.this.jvH.setVisibility(8);
            }
        });
        this.jvA.jwv = new com.tencent.mm.pluginsdk.ui.h.b() {
            public final void c(String str, String str2, String str3, int i, int i2) {
                x.i("MicroMsg.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", str3, Integer.valueOf(i), Integer.valueOf(i2));
                if (AppBrandVideoView.this.jvP != null) {
                    e d = AppBrandVideoView.this.jvP;
                    d.clean();
                    try {
                        JSONObject ahC = d.ahC();
                        ahC.put("errMsg", str3);
                        d.a(new c(), ahC);
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiVideoCallback", "onError e=%s", e);
                    }
                }
            }

            public final void bn(String str, String str2) {
                x.i("MicroMsg.AppBrandVideoView", "onPrepared");
                f n = AppBrandVideoView.this.jvR;
                n.jwR = -1;
                n.jwS = 0;
                n.jwQ = 0.0f;
            }

            public final void bo(String str, String str2) {
                x.i("MicroMsg.AppBrandVideoView", "onVideoEnded");
                AppBrandVideoView.this.jvE.setVisibility(0);
                if (AppBrandVideoView.this.ahf() || !AppBrandVideoView.this.jwb) {
                    AppBrandVideoView.this.jvF.setVisibility(8);
                } else {
                    if (AppBrandVideoView.this.mDuration <= 0) {
                        AppBrandVideoView.this.jvG.setText(AppBrandVideoView.kI(AppBrandVideoView.this.jvA.ahy()));
                    }
                    AppBrandVideoView.this.jvF.setVisibility(0);
                }
                if (AppBrandVideoView.this.jvP != null) {
                    e d = AppBrandVideoView.this.jvP;
                    try {
                        d.a(new b(), d.ahC());
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiVideoCallback", "OnVideoEnded e=%s", e);
                    }
                    d.ahD();
                }
                if (AppBrandVideoView.this.jvU) {
                    AppBrandVideoView.this.w(0, true);
                }
            }

            public final void e(String str, String str2, int i, int i2) {
                x.i("MicroMsg.AppBrandVideoView", "onGetVideoSize width=%d height=%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (AppBrandVideoView.this.jvz == -1) {
                    AppBrandVideoView.this.jvz = i < i2 ? 0 : 90;
                    x.i("MicroMsg.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", Integer.valueOf(AppBrandVideoView.this.jvz));
                }
            }

            public final void bp(String str, String str2) {
                x.i("MicroMsg.AppBrandVideoView", "onVideoPause");
                if (AppBrandVideoView.this.jvP != null) {
                    e d = AppBrandVideoView.this.jvP;
                    try {
                        d.a(new e(), d.ahC());
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiVideoCallback", "OnVideoPause e=%s", e);
                    }
                    d.ahD();
                }
            }

            public final void bq(String str, String str2) {
                x.i("MicroMsg.AppBrandVideoView", "onVideoPlay, isLive:%b", Boolean.valueOf(AppBrandVideoView.this.ahf()));
                if (AppBrandVideoView.this.mDuration <= 0 && !AppBrandVideoView.this.ahf()) {
                    AppBrandVideoView.this.jvG.setText(AppBrandVideoView.kI(AppBrandVideoView.this.jvA.ahy()));
                }
                AppBrandVideoView.a(AppBrandVideoView.this, AppBrandVideoView.this.ahf());
                if (AppBrandVideoView.this.jvO) {
                    AppBrandVideoView.this.jvD.ahq();
                }
                if (AppBrandVideoView.this.jvP != null) {
                    e d = AppBrandVideoView.this.jvP;
                    try {
                        d.jwJ = 0;
                        JSONObject ahC = d.ahC();
                        ahC.put("timeStamp", System.currentTimeMillis());
                        d.a(new f(), ahC);
                        if (d.jwI == null) {
                            d.jwI = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                                public final boolean uG() {
                                    try {
                                        int ahz = e.this.jwG.jvA.ahz();
                                        if (Math.abs(ahz - e.this.jwJ) >= 250) {
                                            JSONObject ahC = e.this.ahC();
                                            e.this.jwJ = ahz;
                                            ahC.put("position", e.this.jwG.jvA.ahA());
                                            String str = FFmpegMetadataRetriever.METADATA_KEY_DURATION;
                                            AppBrandVideoView appBrandVideoView = e.this.jwG;
                                            ahC.put(str, appBrandVideoView.mDuration > 0 ? appBrandVideoView.mDuration : appBrandVideoView.jvA.ahy());
                                            e.this.a(new g(), ahC);
                                        }
                                    } catch (JSONException e) {
                                        x.e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", e);
                                    }
                                    return true;
                                }
                            }, true);
                        }
                        d.jwI.K(250, 250);
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiVideoCallback", "OnVideoPlay e=%s", e);
                    }
                }
            }

            public final void br(String str, String str2) {
                x.i("MicroMsg.AppBrandVideoView", "onVideoWaiting");
                if (AppBrandVideoView.this.jvP != null) {
                    e d = AppBrandVideoView.this.jvP;
                    try {
                        JSONObject ahC = d.ahC();
                        ahC.put("timeStamp", System.currentTimeMillis());
                        d.a(new h(), ahC);
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiVideoCallback", "onVideoWaiting e=%s", e);
                    }
                }
            }

            public final void bs(String str, String str2) {
            }
        };
        this.jvD = new AppBrandVideoViewControlBar(getContext());
        this.jvD.setVisibility(8);
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jvD;
        appBrandVideoViewControlBar.jwg.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppBrandVideoView.this.f(!AppBrandVideoView.this.ahd(), AppBrandVideoView.this.jvz);
            }
        });
        this.jvD.qAn = new com.tencent.mm.plugin.sight.decode.ui.b() {
            public final void ahn() {
                x.i("MicroMsg.AppBrandVideoView", "onSeekPre");
            }

            public final void kK(int i) {
                AppBrandVideoView.this.w(i, false);
            }
        };
        this.jvD.h(new OnClickListener() {
            public final void onClick(View view) {
                if (AppBrandVideoView.this.jvA.isPlaying()) {
                    AppBrandVideoView.this.pause();
                } else {
                    AppBrandVideoView.this.start();
                }
            }
        });
        this.jvD.jwm = new AppBrandVideoViewControlBar.b() {
            public final int ahg() {
                return AppBrandVideoView.this.jvA.TO();
            }

            public final int ahh() {
                return AppBrandVideoView.this.jvA.ahy();
            }
        };
        this.jvA.a(this.jvD);
    }

    public final void cR(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setLoop loop=%b", Boolean.valueOf(z));
        this.jvU = z;
    }

    public final void start() {
        x.i("MicroMsg.AppBrandVideoView", "start");
        if (!this.jvA.isPlaying()) {
            if (this.jvO) {
                AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jvD;
                if (appBrandVideoViewControlBar.jwo == null) {
                    appBrandVideoViewControlBar.jwo = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                        public final boolean uG() {
                            if (AppBrandVideoViewControlBar.this.aht()) {
                                return true;
                            }
                            return false;
                        }
                    }, true);
                }
                appBrandVideoViewControlBar.aht();
                appBrandVideoViewControlBar.jwo.TN();
                appBrandVideoViewControlBar.jwo.K(500, 500);
            }
            this.jvE.setVisibility(8);
            this.jvA.start();
            if (this.jvC != null && this.jvD.jwq) {
                this.jvC.show();
            }
        }
    }

    public final void pause() {
        x.i("MicroMsg.AppBrandVideoView", "pause");
        if (this.jvA.isPlaying()) {
            this.jvA.pause();
            if (this.jvC != null && this.jvD.jwq) {
                this.jvC.pause();
            }
        }
    }

    public final void stop() {
        x.i("MicroMsg.AppBrandVideoView", "stop");
        if (this.jvA.isPlaying()) {
            this.jvA.stop();
            AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jvD;
            if (appBrandVideoViewControlBar.jwo != null) {
                appBrandVideoViewControlBar.jwo.TN();
            }
            if (this.jvC != null) {
                this.jvC.hide();
            }
        }
    }

    public final void clean() {
        x.i("MicroMsg.AppBrandVideoView", "clean");
        stop();
        this.jvA.ahB();
        if (this.jvC != null) {
            DanmuView danmuView = this.jvC;
            danmuView.status = 3;
            danmuView.ahM();
            danmuView.jxw.clear();
            danmuView.invalidate();
        }
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jvD;
        if (appBrandVideoViewControlBar.jwo != null) {
            appBrandVideoViewControlBar.jwo.TN();
        }
        if (appBrandVideoViewControlBar.jwn != null) {
            appBrandVideoViewControlBar.jwn.TN();
        }
    }

    public final void e(String str, boolean z, int i) {
        x.i("MicroMsg.AppBrandVideoView", "setVideoPath path=%s isLive=%s", str, Boolean.valueOf(z));
        if (bi.oN(str)) {
            x.v("MicroMsg.AppBrandVideoView", "setVideoPath videoPath empty");
            return;
        }
        String str2;
        AppBrandLocalMediaObject itemByLocalId;
        stop();
        this.jvT = z;
        AppBrandVideoWrapper appBrandVideoWrapper = this.jvA;
        if (bi.oN(str)) {
            str2 = str;
        } else if (str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            x.i("MicroMsg.AppBrandVideoView", "convertPath appid=%s path=%s", this.mAppId, str);
            itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(this.mAppId, str);
            if (itemByLocalId == null) {
                x.e("MicroMsg.AppBrandVideoView", "convertPath AppBrandLocalMediaObject null");
                str2 = str;
            } else {
                if (bi.oN(itemByLocalId.hjJ)) {
                    x.e("MicroMsg.AppBrandVideoView", "convertPath fileFullPath null");
                    str2 = str;
                } else {
                    str2 = String.format("%s%s", new Object[]{AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX, itemByLocalId.hjJ});
                    x.i("MicroMsg.AppBrandVideoView", "convertPath convertedPath=%s", str2);
                }
            }
        } else {
            str2 = str;
        }
        appBrandVideoWrapper.b(z, str2, i);
        if (this.jvV > 0) {
            this.jvA.kL(this.jvV);
        }
        if (this.mAutoPlay) {
            x.i("MicroMsg.AppBrandVideoView", "setVideoPath autoPlay");
            start();
        }
        if (str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX) && !bi.oN(str)) {
            if (bi.oN(this.jvW)) {
                itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(this.mAppId, str);
                if (itemByLocalId == null) {
                    x.w("MicroMsg.AppBrandVideoView", "setCover AppBrandLocalMediaObject null");
                    return;
                }
                str2 = itemByLocalId.hjJ;
                if (bi.oN(str2)) {
                    x.w("MicroMsg.AppBrandVideoView", "setCover fileFullPath null");
                    return;
                } else {
                    c.Dt().F(new Runnable() {
                        public final void run() {
                            final Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str2, 1);
                            ah.y(new Runnable() {
                                public final void run() {
                                    if (createVideoThumbnail != null && !createVideoThumbnail.isRecycled()) {
                                        AppBrandVideoView.this.jvL.setImageBitmap(createVideoThumbnail);
                                    }
                                }
                            });
                        }
                    });
                    return;
                }
            }
            x.i("MicroMsg.AppBrandVideoView", "setCover mCoverUrl not null");
        }
    }

    public final void w(int i, boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "seek to position=%d current=%d isLive=%b", Integer.valueOf(i), Integer.valueOf(this.jvA.ahA()), Boolean.valueOf(this.jvT));
        if (!ahf()) {
            this.jvE.setVisibility(8);
            if (z) {
                this.jvA.s(i, z);
            } else {
                this.jvA.kL(i);
            }
            if (this.jvC != null && r0 > i) {
                DanmuView danmuView = this.jvC;
                x.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", Integer.valueOf(i));
                danmuView.ahK();
                danmuView.ahM();
                danmuView.prepare();
                e.post(new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass5(i), "DanmuView-seekToPlayTime");
            }
        }
    }

    public final void cS(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setIsShowBasicControls isShowBasicControls=%b", Boolean.valueOf(z));
        this.jvO = z;
    }

    public final void tj(String str) {
        x.i("MicroMsg.AppBrandVideoView", "setCover coverUrl=%s", str);
        if (!bi.oN(str)) {
            this.jvW = str;
            com.tencent.mm.modelappbrand.a.b.Jp().a(this.jvL, str, null, null);
        }
    }

    public final void cT(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.AppBrandVideoView", "setShowLiveBtn %b", Boolean.valueOf(z));
        this.jwa = z;
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jvD;
        if (!(z && ahf())) {
            z2 = false;
        }
        appBrandVideoViewControlBar.cT(z2);
    }

    public final void cU(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.AppBrandVideoView", "setShowProgress %b", Boolean.valueOf(z));
        this.jvZ = z;
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jvD;
        if (!z || ahf()) {
            z2 = false;
        }
        appBrandVideoViewControlBar.cU(z2);
    }

    public final void cV(boolean z) {
        int i = 0;
        x.i("MicroMsg.AppBrandVideoView", "setShowFullScreenBtn %b", Boolean.valueOf(z));
        ImageView imageView = this.jvD.jwg;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public final void cW(boolean z) {
        int i = 0;
        x.i("MicroMsg.AppBrandVideoView", "setShowPlayBtn %b", Boolean.valueOf(z));
        ImageView imageView = this.jvD.qAr;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public final void cX(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "enableProgressGesture %b", Boolean.valueOf(z));
        this.jvY = z;
    }

    public final void cY(boolean z) {
        int i = 0;
        x.i("MicroMsg.AppBrandVideoView", "setShowCenterPlayBtn %b", Boolean.valueOf(z));
        this.jwb = z;
        View view = this.jvF;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public final void cZ(boolean z) {
        AppBrandVideoViewControlBar appBrandVideoViewControlBar;
        x.i("MicroMsg.AppBrandVideoView", "setShowDanmakuBtn showDanmakuBtn=%b", Boolean.valueOf(z));
        if (z) {
            if (this.jvC == null) {
                ahe();
            }
            appBrandVideoViewControlBar = this.jvD;
            appBrandVideoViewControlBar.jwh.setOnClickListener(new com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar.AnonymousClass1(new com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar.a() {
                public final void dc(boolean z) {
                    if (!z) {
                        AppBrandVideoView.this.jvC.hide();
                    } else if (AppBrandVideoView.this.jvA.isPlaying()) {
                        AppBrandVideoView.this.jvC.show();
                    } else {
                        AppBrandVideoView.this.jvC.pause();
                    }
                    if (AppBrandVideoView.this.jvP != null) {
                        e d = AppBrandVideoView.this.jvP;
                        int e = AppBrandVideoView.this.jvN;
                        try {
                            x.i("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", Boolean.valueOf(z));
                            JSONObject ahC = d.ahC();
                            ahC.put("showDanmu", z);
                            ahC.put("videoPlayerId", e);
                            d.a(new a(), ahC);
                        } catch (JSONException e2) {
                            x.e("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", e2);
                        }
                    }
                }
            }));
        }
        appBrandVideoViewControlBar = this.jvD;
        if (z) {
            appBrandVideoViewControlBar.jwh.setVisibility(0);
        } else {
            appBrandVideoViewControlBar.jwh.setVisibility(8);
        }
    }

    public final void tk(String str) {
        x.i("MicroMsg.AppBrandVideoView", "setObjectFit objectFit=%s", str);
        if ("fill".equalsIgnoreCase(str)) {
            this.jvA.a(d.FILL);
            this.jvL.setScaleType(ScaleType.FIT_XY);
        } else if ("cover".equalsIgnoreCase(str)) {
            this.jvA.a(d.COVER);
            this.jvL.setScaleType(ScaleType.CENTER_CROP);
        } else {
            this.jvA.a(d.CONTAIN);
            this.jvL.setScaleType(ScaleType.FIT_CENTER);
        }
    }

    public final void setMute(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setMute isMute=%b", Boolean.valueOf(z));
        this.jvA.setMute(z);
    }

    public final void kG(int i) {
        x.i("MicroMsg.AppBrandVideoView", "setFullScreenDirection %d", Integer.valueOf(i));
        this.jvz = i;
    }

    public final void da(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setPageGesture pageGesture=%b", Boolean.valueOf(z));
        this.jvQ = z;
    }

    public final void kH(int i) {
        x.i("MicroMsg.AppBrandVideoView", "setInitialTime initialTime=%d", Integer.valueOf(i));
        this.jvV = i;
    }

    public final void h(JSONArray jSONArray) {
        int i = 0;
        if (jSONArray != null) {
            String str = "MicroMsg.AppBrandVideoView";
            String str2 = "setDanmakuItemList length=%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(jSONArray != null ? jSONArray.length() : 0);
            x.i(str, str2, objArr);
            if (this.jvC == null) {
                x.w("MicroMsg.AppBrandVideoView", " setDanmakuItemList mDanmakuView null");
                ahe();
            }
            List arrayList = new ArrayList();
            while (i < jSONArray.length()) {
                com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d t = t(jSONArray.optJSONObject(i));
                if (t != null) {
                    arrayList.add(t);
                }
                i++;
            }
            DanmuView danmuView = this.jvC;
            danmuView.ahK();
            danmuView.ahM();
            danmuView.jxw.clear();
            danmuView.prepare();
            if (arrayList.isEmpty()) {
                danmuView.ahL();
                return;
            }
            new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass4(arrayList).start();
            danmuView.ahL();
        }
    }

    public final boolean bm(String str, String str2) {
        int parseColor;
        if (this.jvC == null) {
            x.w("MicroMsg.AppBrandVideoView", " addDanmaku mDanmakuView null");
            ahe();
        }
        try {
            parseColor = Color.parseColor(str2);
        } catch (Exception e) {
            x.d("MicroMsg.AppBrandVideoView", "addDanmakuItemList parse color=%s exp=%s", str2, e);
            parseColor = getResources().getColor(q.d.white);
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d aVar = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(str), parseColor, this.jvA.ahA());
        DanmuView danmuView = this.jvC;
        synchronized (danmuView.jxv) {
            danmuView.jxv.offerFirst(aVar);
            e.post(new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass3(aVar), "DanmuView-addItemToWaitingHead");
        }
        return true;
    }

    private com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d t(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int parseColor;
        int optInt = jSONObject.optInt("time", 0);
        CharSequence optString = jSONObject.optString("text", "");
        Object optString2 = jSONObject.optString("color", "");
        try {
            parseColor = Color.parseColor(optString2);
        } catch (Exception e) {
            x.d("MicroMsg.AppBrandVideoView", "addDanmakuItemList parse color=%s exp=%s", optString2, e);
            parseColor = getResources().getColor(q.d.white);
        }
        return new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(optString), parseColor, optInt);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jvQ || ahd()) {
            if (this.jvR != null) {
                f fVar = this.jvR;
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    fVar.jwQ = motionEvent.getRawX();
                    fVar.jwP = ((AudioManager) fVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                    fVar.jhy = g.bX(fVar.mContext);
                }
                fVar.jwN.onTouchEvent(motionEvent);
                if (actionMasked == 1 || actionMasked == 3) {
                    if (fVar.jwM == a.jwY) {
                        fVar.jwO.f(fVar.jwS, motionEvent.getRawX() - fVar.jwQ);
                        fVar.jwR = -1;
                        fVar.jwS = 0;
                        fVar.jwQ = 0.0f;
                    } else if (fVar.jwM == a.jwW) {
                        ((AudioManager) fVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                        fVar.jwO.ahl();
                    } else if (fVar.jwM == a.jwX) {
                        fVar.jwO.ahm();
                    }
                    fVar.jwM = a.jwV;
                }
            }
            return true;
        }
        if (motionEvent.getAction() == 0 && this.jvO && this.jvE.getVisibility() != 0) {
            this.jvD.ahr();
        }
        if (this.jvX) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void f(boolean z, int i) {
        x.i("MicroMsg.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", Boolean.valueOf(z), Integer.valueOf(i));
        if (this.jvS == null) {
            x.w("MicroMsg.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
        } else if (z == ahd()) {
            x.i("MicroMsg.AppBrandVideoView", "operateFullScreen current same");
        } else {
            int i2;
            if (i == -1) {
                i2 = this.jvz == -1 ? 90 : this.jvz;
                x.i("MicroMsg.AppBrandVideoView", "operateFullScreen target direction:%d", Integer.valueOf(i2));
            } else {
                i2 = i;
            }
            if (z) {
                this.joi = i2;
                this.jvS.kC(i2);
                AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jvD;
                appBrandVideoViewControlBar.jwp = true;
                appBrandVideoViewControlBar.ahs();
                db(true);
                return;
            }
            this.jvS.agI();
            this.jvD.agI();
        }
    }

    public final boolean ahd() {
        if (this.jvS != null) {
            return this.jvS.isFullScreen();
        }
        x.w("MicroMsg.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
        return false;
    }

    private void ahe() {
        this.jvC = (DanmuView) findViewById(g.iye);
        this.jvC.jxt = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.c() {
            public final int MV() {
                return AppBrandVideoView.this.jvA.ahA();
            }
        };
        DanmuView danmuView = this.jvC;
        danmuView.jxp = 0.0f;
        danmuView.jxq = 0.8f;
        this.jvC.jxo = 5;
        this.jvC.jxn = 200;
        this.jvC.hide();
        if (this.jvA != null && this.jvA.getHeight() > 0) {
            danmuView = this.jvC;
            int height = (int) ((danmuView.jxq - danmuView.jxp) * ((float) this.jvA.getHeight()));
            float bY = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.bY(getContext());
            DanmuView danmuView2 = this.jvC;
            danmuView2.jxm = (int) (((float) height) / bY);
            if (danmuView2.jxu != null) {
                synchronized (danmuView2.jxu) {
                    height = 0;
                    while (true) {
                        int i = height;
                        if (i >= danmuView2.jxu.size()) {
                            break;
                        }
                        ArrayList arrayList = (ArrayList) danmuView2.jxu.get(Integer.valueOf(i));
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                        height = i + 1;
                    }
                }
            }
            danmuView2.ahI();
        }
    }

    static String kI(int i) {
        return kJ(i / 60) + ":" + kJ(i % 60);
    }

    private static String kJ(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }

    final void db(boolean z) {
        if (this.jvP != null) {
            e eVar = this.jvP;
            try {
                x.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", Integer.valueOf(this.jvN), Boolean.valueOf(z), Integer.valueOf(this.joi));
                JSONObject ahC = eVar.ahC();
                ahC.put("fullScreen", z);
                ahC.put("videoPlayerId", r1);
                ahC.put(TencentLocation.EXTRA_DIRECTION, r2);
                eVar.a(new d(), ahC);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", e);
            }
        }
    }

    private boolean ahf() {
        x.i("MicroMsg.AppBrandVideoView", "isLive %b %b", Boolean.valueOf(this.jvT), Boolean.valueOf(this.jvA.ahf()));
        if (this.jvT || this.jvA.ahf()) {
            return true;
        }
        return false;
    }
}
