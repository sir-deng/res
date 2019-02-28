package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.t.c.g;

public class a {
    private static volatile g iXn;
    private static volatile g iXo;

    public static g jZ(int i) {
        if (i == 1) {
            return adq();
        }
        return adp();
    }

    private static g adp() {
        if (iXn == null) {
            synchronized (a.class) {
                if (iXn == null) {
                    g gVar = new g();
                    gVar.a(new b(HardCoderJNI.SCENE_QUIT_CHATTING));
                    gVar.a(new c(303));
                    gVar.a(new d(308));
                    gVar.a(new f());
                    gVar.a(new g());
                    iXn = gVar;
                }
            }
        }
        return iXn;
    }

    private static g adq() {
        if (iXo == null) {
            synchronized (a.class) {
                if (iXo == null) {
                    g gVar = new g();
                    gVar.a(new b(262));
                    gVar.a(new c(263));
                    gVar.a(new d(268));
                    gVar.a(new f());
                    gVar.a(new g());
                    gVar.a(new e((byte) 0));
                    iXo = gVar;
                }
            }
        }
        return iXo;
    }
}
