package com.tencent.mm.compatible.e;

import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public int gEA;
    public int gEB;
    public int gEC;
    public int gED;
    public int gEE;
    public int gEF;
    public int gEG;
    public int gEH;
    public int gEI;
    public int gEJ;
    public int gEK;
    public int gEL;
    public int gEM;
    public int gEN;
    public int gEO;
    public int gEP;
    public int gEQ;
    public int gER;
    public int gES;
    public int gET;
    public int gEU;
    public int gEV;
    public boolean gEW;
    public int gEX;
    public int gEY;
    public int gEZ;
    public boolean gEr = false;
    public int gEs;
    public int gEt;
    public int gEu;
    public int gEv;
    public int gEw;
    public int gEx;
    public int gEy;
    public int gEz;
    public int gFA;
    public int gFa;
    public int gFb;
    public int gFc;
    public int gFd;
    public int gFe;
    public int gFf;
    public int gFg;
    public int gFh;
    public int gFi;
    public int gFj;
    public int gFk;
    public int gFl;
    public short[] gFm = new short[15];
    public short[] gFn = new short[2];
    public boolean gFo;
    public int gFp;
    public boolean gFq = false;
    public int gFr;
    public int gFs;
    public int gFt;
    public int gFu;
    public int gFv;
    public int gFw;
    public int gFx;
    public int gFy;
    public int gFz;

    public b() {
        reset();
    }

    public final void reset() {
        this.gEr = false;
        this.gEs = -1;
        this.gEt = -1;
        this.gEu = -1;
        this.gEv = -1;
        this.gEw = -1;
        this.gEx = -1;
        this.gEy = -1;
        this.gEA = -1;
        this.gEz = -1;
        this.gFe = -1;
        this.gEB = -1;
        this.gEC = -1;
        this.gED = -1;
        this.gEP = -1;
        this.gEQ = -1;
        this.gER = -1;
        this.gES = -1;
        this.gET = -1;
        this.gEU = -1;
        this.gEV = -1;
        this.gEW = false;
        this.gEX = -1;
        this.gEY = -1;
        this.gFa = -1;
        this.gEZ = -1;
        this.gFd = -1;
        this.gFb = -1;
        this.gFc = -1;
        this.gFf = -1;
        this.gFg = -1;
        this.gFh = -1;
        this.gFi = -1;
        this.gEE = -1;
        this.gEF = -1;
        this.gEG = -1;
        this.gEH = -1;
        this.gEK = -1;
        this.gEL = -1;
        this.gEM = -1;
        this.gEN = -1;
        this.gFj = 0;
        this.gFk = 0;
        this.gFl = -1;
        this.gEJ = -1;
        this.gEI = -1;
        this.gFo = false;
        this.gFn[0] = (short) -1;
        this.gFn[1] = (short) -1;
        this.gFp = -1;
        this.gFx = -1;
        this.gFy = -1;
        this.gFz = -1;
        this.gFA = -1;
        this.gEO = -1;
    }

    public final boolean yi() {
        if ((this.gEt < 0 || this.gEu >= 0) && ((this.gEt >= 0 || this.gEu < 0) && this.gEv <= 0)) {
            return false;
        }
        return true;
    }

    public final boolean yj() {
        return this.gEw >= 0;
    }

    public final boolean yk() {
        return this.gEx >= 0;
    }

    public final int yl() {
        if (!yj()) {
            return -1;
        }
        int i = (this.gEw & 224) >> 5;
        x.d("VoipAudioInfo", "getEnableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final boolean ym() {
        if (!yj()) {
            return false;
        }
        boolean z;
        int i = this.gEw & 16;
        String str = "VoipAudioInfo";
        StringBuilder stringBuilder = new StringBuilder("enableSpeaker ");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        x.d(str, stringBuilder.append(z).toString());
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final int yn() {
        if (!yj()) {
            return -1;
        }
        int i = (this.gEw & 14) >> 1;
        x.d("VoipAudioInfo", "getDisableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final boolean yo() {
        if (!yj()) {
            return false;
        }
        boolean z;
        int i = this.gEw & 1;
        String str = "VoipAudioInfo";
        StringBuilder stringBuilder = new StringBuilder("disableSpeaker ");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        x.d(str, stringBuilder.append(z).toString());
        if (i > 0) {
            return true;
        }
        return false;
    }

    public final int yp() {
        if (!yk()) {
            return -1;
        }
        int i = (this.gEx & 224) >> 5;
        x.d("VoipAudioInfo", "getEnableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final int yq() {
        if (!yk()) {
            return -1;
        }
        int i = (this.gEx & 14) >> 1;
        x.d("VoipAudioInfo", "getDisableMode " + i);
        if (i == 7) {
            return -1;
        }
        return i;
    }

    public final void dump() {
        x.d("VoipAudioInfo", "streamtype " + this.gEs);
        x.d("VoipAudioInfo", "smode " + this.gEt);
        x.d("VoipAudioInfo", "omode " + this.gEu);
        x.d("VoipAudioInfo", "ospeaker " + this.gEv);
        x.d("VoipAudioInfo", "operating" + this.gEw);
        x.d("VoipAudioInfo", "moperating" + this.gEx);
        x.d("VoipAudioInfo", "mstreamtype" + this.gEy);
        x.d("VoipAudioInfo", "mVoiceRecordMode" + this.gEz);
        x.d("VoipAudioInfo", "agcMode :" + this.gFe);
        x.d("VoipAudioInfo", "nsMode:" + this.gEC);
        x.d("VoipAudioInfo", "aecMode:" + this.gEB);
        x.d("VoipAudioInfo", "volumMode:" + this.gED);
        x.d("VoipAudioInfo", "micMode:" + this.gEP);
        x.d("VoipAudioInfo", "sourceMode:" + this.gEQ);
        x.d("VoipAudioInfo", "speakerMode:" + this.gER);
        x.d("VoipAudioInfo", "phoneMode:" + this.gES);
        x.d("VoipAudioInfo", "voipstreamType:" + this.gET);
        x.d("VoipAudioInfo", "speakerstreamtype:" + this.gEU);
        x.d("VoipAudioInfo", "phonestreamtype:" + this.gEV);
        x.d("VoipAudioInfo", "ringphonestream:" + this.gEX);
        x.d("VoipAudioInfo", "ringphonemode:" + this.gEY);
        x.d("VoipAudioInfo", "ringspeakerstream:" + this.gEZ);
        x.d("VoipAudioInfo", "ringspeakermode:" + this.gFa);
        x.d("VoipAudioInfo", "agcModeNew :" + this.gFd);
        x.d("VoipAudioInfo", "nsModeNew:" + this.gFc);
        x.d("VoipAudioInfo", "aecModeNew:" + this.gFb);
        x.d("VoipAudioInfo", "agctargetdb:" + this.gFf);
        x.d("VoipAudioInfo", "agcgaindb:" + this.gFg);
        x.d("VoipAudioInfo", "agcflag:" + this.gFh);
        x.d("VoipAudioInfo", "agclimiter:" + this.gFi);
        x.d("VoipAudioInfo", "inputVolumeScale:" + this.gEE);
        x.d("VoipAudioInfo", "outputVolumeScale:" + this.gEF);
        x.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.gEG);
        x.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.gEH);
        x.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.gEK);
        x.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.gEL);
        x.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.gEM);
        x.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.gEN);
        x.d("VoipAudioInfo", "enableRecTimer:" + this.gFj);
        x.d("VoipAudioInfo", "enablePlayTimer:" + this.gFk);
        x.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.gFl);
        x.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.gEI);
        x.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.gEJ);
        x.d("VoipAudioInfo", "noisegateon" + this.gFo);
        x.d("VoipAudioInfo", "noisegatestrength[0]" + this.gFn[0]);
        x.d("VoipAudioInfo", "noisegatestrength[1]" + this.gFn[1]);
        x.d("VoipAudioInfo", "spkecenable:" + this.gFp);
        x.d("VoipAudioInfo", "agcRxFlag:" + this.gFx);
        x.d("VoipAudioInfo", "agcRxTargetdb:" + this.gFy);
        x.d("VoipAudioInfo", "agcRxGaindb:" + this.gFz);
        x.d("VoipAudioInfo", "agcRxLimiter:" + this.gFA);
        x.d("VoipAudioInfo", "enableXnoiseSup:" + this.gEO);
    }
}
