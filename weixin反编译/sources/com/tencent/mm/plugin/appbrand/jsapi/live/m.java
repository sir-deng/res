package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;

public final class m implements ITXLivePushListener {
    boolean gOP = false;
    TXCloudVideoView joA;
    private String joH = "vertical";
    private boolean joN = false;
    private TXLivePushConfig joO;
    TXLivePusher joP;
    ITXLivePushListener joQ;
    String joR;
    private boolean joS = false;
    private boolean joT = false;
    ITXSnapshotListener joU;
    private int joV = 2;
    private int joW = -1;
    private int joX = -1;
    private int joY = 0;
    boolean joZ = true;
    private boolean joj = false;
    private String jpa = "high";
    private int jpb = 5;
    private int jpc = 3;
    private String jpd = "";
    private boolean jpe = false;
    private Context mContext;
    private boolean mFrontCamera = true;
    private int mMode = 1;
    private boolean mMute = false;

    public m(Context context) {
        this.mContext = context;
        this.joO = new TXLivePushConfig();
        this.joP = new TXLivePusher(context);
        this.joP.setConfig(this.joO);
        this.joP.setPushListener(this);
    }

    public final j sO(String str) {
        if (str == null) {
            return new j(-1, "invalid params");
        }
        x.i("TXLivePusherJSAdapter", "operateLivePusher: " + str);
        if (str.equalsIgnoreCase("switchCamera")) {
            this.mFrontCamera = !this.mFrontCamera;
            this.joO.setFrontCamera(this.mFrontCamera);
        }
        if (!this.gOP) {
            return new j(-3, "uninited livePusher");
        }
        if (str.equalsIgnoreCase("start")) {
            if (!(this.joR == null || this.joR.isEmpty() || this.joP.isPushing())) {
                this.joA.setVisibility(0);
                if (this.joZ) {
                    this.joP.startCameraPreview(this.joA);
                }
                this.joP.startPusher(this.joR);
            }
        } else if (str.equalsIgnoreCase("stop")) {
            this.joP.stopCameraPreview(true);
            this.joP.stopPusher();
        } else if (str.equalsIgnoreCase("pause")) {
            this.joP.pausePusher();
        } else if (str.equalsIgnoreCase("resume")) {
            this.joP.resumePusher();
        } else if (str.equalsIgnoreCase("switchCamera")) {
            this.joP.switchCamera();
        } else if (!str.equalsIgnoreCase("snapshot")) {
            return new j(-4, "invalid operate command");
        } else {
            ITXSnapshotListener iTXSnapshotListener = this.joU;
            if (this.joP != null && this.joP.isPushing()) {
                this.joP.snapshot(iTXSnapshotListener);
            }
        }
        return new j();
    }

    public final j cP(boolean z) {
        this.joS = this.joP.isPushing();
        if (!this.joS) {
            return new j();
        }
        if (!z) {
            return sO("pause");
        }
        this.joT = z;
        if (this.joj && this.joQ != null) {
            this.joQ.onPushEvent(5000, new Bundle());
        }
        return sO("stop");
    }

    public final j agL() {
        if (!this.joS) {
            return new j();
        }
        if (this.joT) {
            return sO("start");
        }
        return sO("resume");
    }

    public final void onPushEvent(int i, Bundle bundle) {
        if (i == TXLiveConstants.PUSH_ERR_NET_DISCONNECT) {
            sO("stop");
        }
        if (this.joj && this.joQ != null) {
            this.joQ.onPushEvent(i, bundle);
        }
    }

    public final void onNetStatus(Bundle bundle) {
        if (this.joQ != null) {
            this.joQ.onNetStatus(bundle);
        }
    }

    final void c(Bundle bundle, boolean z) {
        if (z || bundle.keySet().size() != 0) {
            int i;
            String string;
            int i2;
            boolean z2;
            boolean z3;
            String string2;
            int i3;
            int i4;
            String string3;
            Bitmap decodeFile;
            boolean z4;
            Object obj;
            boolean z5;
            int i5 = bundle.getInt("mode", this.mMode);
            if (z || i5 != this.mMode) {
                switch (i5) {
                    case 1:
                        this.joP.setVideoQuality(1, false, false);
                        break;
                    case 2:
                        this.joP.setVideoQuality(2, true, false);
                        break;
                    case 3:
                        this.joP.setVideoQuality(3, true, false);
                        break;
                    case 4:
                        this.joP.setVideoQuality(4, true, false);
                        break;
                    case 5:
                        this.joP.setVideoQuality(5, true, false);
                        break;
                    case 6:
                        this.joP.setVideoQuality(6, false, false);
                        break;
                }
            }
            int i6 = this.joW;
            int i7 = this.joX;
            int i8 = bundle.getInt("minBitrate", -1);
            int i9 = bundle.getInt("maxBitrate", -1);
            if (!(i8 == -1 || i9 == -1)) {
                if (i8 < 200) {
                    i8 = 200;
                }
                if (i9 > 1000) {
                    i9 = 1000;
                }
                if (i8 <= i9) {
                    i7 = i8;
                    i = bundle.getInt("aspect", this.joV);
                    string = bundle.getString("audioQuality", this.jpa);
                    if (i5 == 6) {
                        if (i == 1) {
                            this.joO.setVideoResolution(13);
                        } else if (i == 2) {
                            this.joO.setVideoResolution(0);
                        }
                        if (!(i7 == -1 || i9 == -1 || i7 > i9)) {
                            this.joO.setMinVideoBitrate(i7);
                            this.joO.setMaxVideoBitrate(i9);
                        }
                        if (string.equalsIgnoreCase("low")) {
                            this.joO.setAudioSampleRate(16000);
                        } else if (string.equalsIgnoreCase("high")) {
                            this.joO.setAudioSampleRate(48000);
                        }
                    }
                    i2 = bundle.getInt("focusMode", this.joY);
                    this.joO.setTouchFocus(i2 == 0);
                    z2 = bundle.getBoolean("enableCamera", this.joZ);
                    this.joO.enablePureAudioPush(z2);
                    if (i5 == 6) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    string2 = bundle.getString("orientation", this.joH);
                    i6 = 0;
                    if (string2.equalsIgnoreCase("horizontal")) {
                        this.joO.setHomeOrientation(0);
                        i6 = 90;
                    } else if (string2.equalsIgnoreCase("vertical")) {
                        this.joO.setHomeOrientation(1);
                        i6 = 0;
                    }
                    i3 = bundle.getInt("beauty", this.jpb);
                    i4 = bundle.getInt("whiteness", this.jpc);
                    this.joO.setBeautyFilter(i3, i4, 5);
                    string3 = bundle.getString("backgroundImage", this.jpd);
                    decodeFile = BitmapFactory.decodeFile(string3);
                    if (decodeFile != null) {
                        this.joO.setPauseImg(decodeFile);
                    }
                    z4 = bundle.getBoolean("backgroundMute", this.jpe);
                    if (z4) {
                        this.joO.setPauseFlag(1);
                    } else {
                        this.joO.setPauseFlag(3);
                    }
                    obj = null;
                    if (!(i == this.joV && i7 == this.joW && i9 == this.joX && i2 == this.joY && z3 == this.joZ && i3 == this.jpb && i4 == this.jpc && z4 == this.jpe && string3.equalsIgnoreCase(this.jpd) && string2.equalsIgnoreCase(this.joH) && string.equalsIgnoreCase(this.jpa))) {
                        obj = 1;
                    }
                    if (z || obj != null) {
                        this.joP.setConfig(this.joO);
                        this.joP.setRenderRotation(i6);
                        this.joP.setBeautyFilter(0, i3, i4, 2);
                    }
                    if (this.joP.isPushing()) {
                        if (z3 == this.joZ) {
                            if (z3) {
                                this.joP.stopCameraPreview(true);
                            } else {
                                this.joP.stopCameraPreview(true);
                                this.joP.startCameraPreview(this.joA);
                            }
                        } else if (this.joZ && !string2.equalsIgnoreCase(this.joH)) {
                            this.joP.stopCameraPreview(true);
                            this.joP.startCameraPreview(this.joA);
                        }
                    }
                    this.mMode = i5;
                    this.joV = i;
                    this.joY = i2;
                    this.joZ = z3;
                    this.joH = string2;
                    this.jpb = i3;
                    this.jpc = i4;
                    this.jpe = z4;
                    this.jpd = string3;
                    this.joW = i7;
                    this.joX = i9;
                    this.jpa = string;
                    this.joj = bundle.getBoolean("needEvent", this.joj);
                    z5 = bundle.getBoolean("muted", this.mMute);
                    if (z || z5 != this.mMute) {
                        this.joP.setMute(z5);
                    }
                    this.mMute = z5;
                    z5 = bundle.getBoolean("debug", this.joN);
                    if (z || z5 != this.joN) {
                        this.joA.showLog(z5);
                    }
                    this.joN = z5;
                }
            }
            i9 = i7;
            i7 = i6;
            i = bundle.getInt("aspect", this.joV);
            string = bundle.getString("audioQuality", this.jpa);
            if (i5 == 6) {
                if (i == 1) {
                    this.joO.setVideoResolution(13);
                } else if (i == 2) {
                    this.joO.setVideoResolution(0);
                }
                this.joO.setMinVideoBitrate(i7);
                this.joO.setMaxVideoBitrate(i9);
                if (string.equalsIgnoreCase("low")) {
                    this.joO.setAudioSampleRate(16000);
                } else if (string.equalsIgnoreCase("high")) {
                    this.joO.setAudioSampleRate(48000);
                }
            }
            i2 = bundle.getInt("focusMode", this.joY);
            if (i2 == 0) {
            }
            this.joO.setTouchFocus(i2 == 0);
            z2 = bundle.getBoolean("enableCamera", this.joZ);
            if (z2) {
            }
            this.joO.enablePureAudioPush(z2);
            if (i5 == 6) {
                z3 = z2;
            } else {
                z3 = true;
            }
            string2 = bundle.getString("orientation", this.joH);
            i6 = 0;
            if (string2.equalsIgnoreCase("horizontal")) {
                this.joO.setHomeOrientation(0);
                i6 = 90;
            } else if (string2.equalsIgnoreCase("vertical")) {
                this.joO.setHomeOrientation(1);
                i6 = 0;
            }
            i3 = bundle.getInt("beauty", this.jpb);
            i4 = bundle.getInt("whiteness", this.jpc);
            this.joO.setBeautyFilter(i3, i4, 5);
            string3 = bundle.getString("backgroundImage", this.jpd);
            decodeFile = BitmapFactory.decodeFile(string3);
            if (decodeFile != null) {
                this.joO.setPauseImg(decodeFile);
            }
            z4 = bundle.getBoolean("backgroundMute", this.jpe);
            if (z4) {
                this.joO.setPauseFlag(1);
            } else {
                this.joO.setPauseFlag(3);
            }
            obj = null;
            obj = 1;
            this.joP.setConfig(this.joO);
            this.joP.setRenderRotation(i6);
            this.joP.setBeautyFilter(0, i3, i4, 2);
            if (this.joP.isPushing()) {
                if (z3 == this.joZ) {
                    this.joP.stopCameraPreview(true);
                    this.joP.startCameraPreview(this.joA);
                } else if (z3) {
                    this.joP.stopCameraPreview(true);
                } else {
                    this.joP.stopCameraPreview(true);
                    this.joP.startCameraPreview(this.joA);
                }
            }
            this.mMode = i5;
            this.joV = i;
            this.joY = i2;
            this.joZ = z3;
            this.joH = string2;
            this.jpb = i3;
            this.jpc = i4;
            this.jpe = z4;
            this.jpd = string3;
            this.joW = i7;
            this.joX = i9;
            this.jpa = string;
            this.joj = bundle.getBoolean("needEvent", this.joj);
            z5 = bundle.getBoolean("muted", this.mMute);
            this.joP.setMute(z5);
            this.mMute = z5;
            z5 = bundle.getBoolean("debug", this.joN);
            this.joA.showLog(z5);
            this.joN = z5;
        }
    }

    static void c(String str, Bundle bundle) {
        for (String str2 : bundle.keySet()) {
            if (str2.equalsIgnoreCase("pushUrl") || str2.equalsIgnoreCase("orientation") || str2.equalsIgnoreCase("backgroundImage") || str2.equalsIgnoreCase("audioQuality")) {
                str = str + "\n" + str2 + " = " + bundle.getString(str2);
            } else if (str2.equalsIgnoreCase("mode") || str2.equalsIgnoreCase("focusMode") || str2.equalsIgnoreCase("beauty") || str2.equalsIgnoreCase("whiteness") || str2.equalsIgnoreCase("aspect") || str2.equalsIgnoreCase("minBitrate") || str2.equalsIgnoreCase("maxBitrate")) {
                str = str + "\n" + str2 + " = " + bundle.getInt(str2);
            } else if (str2.equalsIgnoreCase("hide") || str2.equalsIgnoreCase("autopush") || str2.equalsIgnoreCase("muted") || str2.equalsIgnoreCase("enableCamera") || str2.equalsIgnoreCase("backgroundMute") || str2.equalsIgnoreCase("needEvent") || str2.equalsIgnoreCase("debug")) {
                str = str + "\n" + str2 + " = " + bundle.getBoolean(str2);
            }
        }
        x.i("TXLivePusherJSAdapter", str);
    }
}
