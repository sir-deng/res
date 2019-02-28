package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.modelvoice.h;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.protocal.c.bum;

public final class d {
    public static bum aN(int i, String str) {
        bum bum = new bum();
        switch (i) {
            case 0:
                bum.vPx = 8000;
                bum.vPy = 16;
                bum.vPv = 5;
                bum.vPw = 5;
                break;
            case 1:
                bum.vPx = 16000;
                bum.vPy = 16;
                bum.vPv = 4;
                bum.vPw = 4;
                break;
            case 4:
                bum.vPx = 16000;
                b nX = q.nX(str);
                if (nX != null) {
                    int SilkGetEncSampleRate = MediaRecorder.SilkGetEncSampleRate(((h) nX).bp(0, 1).buf);
                    if (SilkGetEncSampleRate >= 8000) {
                        bum.vPx = SilkGetEncSampleRate;
                    }
                }
                bum.vPy = 16;
                bum.vPv = 6;
                bum.vPw = 6;
                break;
            default:
                bum.vPx = 0;
                bum.vPy = 0;
                bum.vPv = 0;
                bum.vPw = 0;
                break;
        }
        return bum;
    }
}
