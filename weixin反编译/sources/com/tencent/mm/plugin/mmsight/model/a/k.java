package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.storage.w.a;

public final class k {
    private static k oAs = new k();
    public SightParams oAt;

    public static k bbq() {
        return oAs;
    }

    public static d c(VideoTransPara videoTransPara) {
        switch (j.oyD.gHU) {
            case 1:
                return new l(videoTransPara);
            case 2:
                return new n(videoTransPara);
            default:
                return null;
        }
    }

    public static int bbr() {
        return j.oyD.videoBitrate;
    }

    public static int bbs() {
        return j.oyD.oxc;
    }

    public static boolean bbt() {
        if (CaptureMMProxy.getInstance().getInt(a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, 0) == 1) {
            return true;
        }
        return false;
    }

    public static String bbu() {
        switch (j.oyD.gHU) {
            case 1:
                return "RECORDER_TYPE_FFMPEG";
            case 2:
                return "ENCODER_MEDIACODEC";
            default:
                return "";
        }
    }
}
