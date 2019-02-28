package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    public int gHU = 1;
    public VideoTransPara owp;
    public int oxc = -1;
    public boolean oyA = false;
    public int oyM = -1;
    public boolean oyN = false;
    public boolean oyO = false;
    public boolean oyP = true;
    public boolean oyQ = false;
    b oyR;
    public int videoBitrate;

    public static o a(int i, VideoTransPara videoTransPara) {
        o oVar;
        switch (i) {
            case 1:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
                oVar = new o(2, videoTransPara);
                oVar.oyO = false;
                break;
            case 2:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
                oVar = new o(2, videoTransPara);
                oVar.oyO = false;
                oVar = oVar.baR().baQ();
                break;
            case 3:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
                oVar = new o(1, videoTransPara);
                oVar.oyO = false;
                break;
            case 4:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
                oVar = new o(1, videoTransPara);
                oVar.oyO = false;
                oVar = oVar.baR().baQ();
                break;
            case 5:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
                oVar = new o(2, videoTransPara);
                oVar.oyO = true;
                oVar.oyN = false;
                oVar = oVar.baQ();
                break;
            case 6:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
                oVar = new o(1, videoTransPara);
                oVar.oyO = true;
                oVar = oVar.baQ();
                break;
            case 7:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
                oVar = new o(2, videoTransPara);
                oVar.oyO = true;
                oVar = oVar.baS();
                oVar.oyN = false;
                break;
            case 8:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
                oVar = new o(2, videoTransPara);
                oVar.oyO = true;
                oVar = oVar.baS();
                oVar.oyN = true;
                break;
            case 9:
                oVar = new o(1, videoTransPara);
                oVar.oyO = true;
                oVar = oVar.baS();
                oVar.oyN = false;
                break;
            case 10:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
                oVar = new o(1, videoTransPara);
                oVar.oyO = true;
                oVar = oVar.baS();
                oVar.oyN = true;
                break;
            case 11:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
                oVar = new o(2, videoTransPara);
                oVar.oyO = true;
                oVar = oVar.baS();
                oVar.oyN = false;
                oVar = oVar.baR();
                break;
            default:
                return null;
        }
        if (oVar == null) {
            return oVar;
        }
        oVar.oyM = i;
        return oVar;
    }

    private o(int i, VideoTransPara videoTransPara) {
        this.owp = videoTransPara;
        this.gHU = i;
        this.videoBitrate = videoTransPara.videoBitrate;
        this.oxc = videoTransPara.width;
    }

    public final o baQ() {
        this.oxc = 720;
        return this;
    }

    public final o baR() {
        this.videoBitrate = this.owp.videoBitrate * 2;
        this.oyQ = true;
        return this;
    }

    public final o baS() {
        this.oxc = this.owp.width * 2;
        return this;
    }

    public final boolean baT() {
        return this.owp.width < this.oxc;
    }

    public final String toString() {
        return String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[]{Integer.valueOf(this.gHU), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.oyA), Boolean.valueOf(this.oyN), Boolean.valueOf(this.oyO), Integer.valueOf(this.oxc), this.owp});
    }
}
