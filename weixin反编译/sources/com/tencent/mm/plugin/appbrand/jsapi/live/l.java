package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public final class l implements ITXLivePlayListener {
    boolean gOP = false;
    TXCloudVideoView joA;
    private TXLivePlayConfig joB;
    TXLivePlayer joC;
    ITXLivePlayListener joD;
    String joE = "";
    int joF = 0;
    boolean joG = false;
    private String joH = "vertical";
    private String joI = "fillCrop";
    private String joJ = "speaker";
    private float joK = 1.0f;
    private float joL = 3.0f;
    boolean joM = true;
    private boolean joN = false;
    boolean joj = false;
    boolean mAutoPlay = false;
    private Context mContext;
    private int mMode = 1;
    private boolean mMute = false;

    public l(Context context) {
        this.mContext = context;
        this.joB = new TXLivePlayConfig();
        this.joC = new TXLivePlayer(this.mContext);
        this.joC.setConfig(this.joB);
        this.joC.setPlayListener(this);
        this.joC.enableHardwareDecode(true);
    }

    public final j sN(String str) {
        boolean z = true;
        if (str == null) {
            return new j(-1, "invalid params");
        }
        x.i("TXLivePlayerJSAdapter", "operateLivePlayer: " + str);
        if (!this.gOP) {
            return new j(-3, "uninited livePlayer");
        }
        if (str.equalsIgnoreCase("play")) {
            this.joC.startPlay(this.joE, this.joF);
        } else if (str.equalsIgnoreCase("stop")) {
            this.joC.stopPlay(true);
        } else if (str.equalsIgnoreCase("pause")) {
            this.joC.pause();
        } else if (str.equalsIgnoreCase("resume")) {
            this.joC.resume();
        } else if (!str.equalsIgnoreCase("mute")) {
            return new j(-4, "invalid operate command");
        } else {
            if (this.mMute) {
                z = false;
            }
            this.mMute = z;
            this.joC.setMute(this.mMute);
        }
        return new j();
    }

    public final void onPlayEvent(int i, Bundle bundle) {
        if (i == TXLiveConstants.PLAY_EVT_PLAY_END || i == TXLiveConstants.PLAY_ERR_NET_DISCONNECT) {
            sN("stop");
        }
        if (this.joj && this.joD != null) {
            this.joD.onPlayEvent(i, bundle);
        }
    }

    public final void onNetStatus(Bundle bundle) {
        if (this.joD != null) {
            this.joD.onNetStatus(bundle);
        }
    }

    final int v(Bundle bundle) {
        this.mMode = bundle.getInt("mode", this.mMode);
        if (this.mMode != 1) {
            return 5;
        }
        if (this.joE == null || this.joE == null) {
            return 0;
        }
        if ((this.joE.startsWith("http://") || this.joE.startsWith("https://")) && this.joE.contains(".flv")) {
            return 1;
        }
        return 0;
    }

    final void w(Bundle bundle) {
        this.mMute = bundle.getBoolean("muted", this.mMute);
        this.joC.setMute(this.mMute);
        this.joH = bundle.getString("orientation", this.joH);
        if (this.joH.equalsIgnoreCase("horizontal")) {
            this.joC.setRenderRotation(270);
        } else if (this.joH.equalsIgnoreCase("vertical")) {
            this.joC.setRenderRotation(0);
        }
        this.joI = bundle.getString("objectFit", this.joI);
        if (this.joI.equalsIgnoreCase("fillCrop")) {
            this.joC.setRenderMode(0);
        } else if (this.joI.equalsIgnoreCase("contain")) {
            this.joC.setRenderMode(1);
        }
        this.joJ = bundle.getString("soundMode", this.joJ);
        if (this.joJ.equalsIgnoreCase("speaker")) {
            this.joC.setAudioRoute(0);
        } else if (this.joJ.equalsIgnoreCase("ear")) {
            this.joC.setAudioRoute(1);
        }
        this.joM = bundle.getBoolean("backgroundMute", this.joM);
        this.joK = bundle.getFloat("minCache", this.joK);
        this.joL = bundle.getFloat("maxCache", this.joL);
        this.joB.setAutoAdjustCacheTime(true);
        this.joB.setCacheTime(this.joK);
        this.joB.setMinAutoAdjustCacheTime(this.joK);
        this.joB.setMaxAutoAdjustCacheTime(this.joL);
        this.joC.setConfig(this.joB);
        this.joj = bundle.getBoolean("needEvent", this.joj);
        this.joN = bundle.getBoolean("debug", this.joN);
        this.joA.showLog(this.joN);
    }

    static void c(String str, Bundle bundle) {
        for (String str2 : bundle.keySet()) {
            if (str2.equalsIgnoreCase("playUrl") || str2.equalsIgnoreCase("orientation") || str2.equalsIgnoreCase("objectFit") || str2.equalsIgnoreCase("soundMode")) {
                str = str + "\n" + str2 + " = " + bundle.getString(str2);
            } else if (str2.equalsIgnoreCase("mode") || str2.equalsIgnoreCase("playType")) {
                str = str + "\n" + str2 + " = " + bundle.getInt(str2);
            } else if (str2.equalsIgnoreCase("minCache") || str2.equalsIgnoreCase("maxCache")) {
                str = str + "\n" + str2 + " = " + bundle.getFloat(str2);
            } else if (str2.equalsIgnoreCase("hide") || str2.equalsIgnoreCase("autoplay") || str2.equalsIgnoreCase("muted") || str2.equalsIgnoreCase("backgroundMute") || str2.equalsIgnoreCase("needEvent") || str2.equalsIgnoreCase("debug")) {
                str = str + "\n" + str2 + " = " + bundle.getBoolean(str2);
            }
        }
        x.i("TXLivePlayerJSAdapter", str);
    }
}
