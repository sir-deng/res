package com.tencent.mm.ab;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.f.a.s;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static String JD() {
        return new StringBuilder(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE).append(ac.VF(System.nanoTime())).toString();
    }

    public static boolean a(String str, a aVar) {
        x.i("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", str);
        com.tencent.mm.sdk.b.b sVar = new s();
        sVar.fow.action = 1;
        sVar.fow.foy = str;
        sVar.fow.foA = aVar;
        a.xmy.m(sVar);
        return sVar.fox.foB;
    }

    public static boolean iN(String str) {
        x.i("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", str);
        com.tencent.mm.sdk.b.b sVar = new s();
        sVar.fow.action = 2;
        sVar.fow.foy = str;
        a.xmy.m(sVar);
        return sVar.fox.foB;
    }

    public static boolean iO(String str) {
        com.tencent.mm.sdk.b.b sVar = new s();
        sVar.fow.action = 7;
        sVar.fow.foy = str;
        a.xmy.m(sVar);
        return sVar.fox.foB;
    }

    public static boolean iP(String str) {
        com.tencent.mm.sdk.b.b sVar = new s();
        sVar.fow.action = 8;
        sVar.fow.foy = str;
        a.xmy.m(sVar);
        return sVar.fox.foB;
    }

    public static a iQ(String str) {
        com.tencent.mm.sdk.b.b sVar = new s();
        sVar.fow.action = 16;
        sVar.fow.foy = str;
        a.xmy.m(sVar);
        return sVar.fow.foA;
    }
}
