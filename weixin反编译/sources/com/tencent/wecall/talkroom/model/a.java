package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;

public class a {
    private static a Awg = null;
    private f Awh = null;

    public static a cIn() {
        if (Awg == null) {
            synchronized (a.class) {
                if (Awg == null) {
                    Awg = new a();
                }
            }
        }
        return Awg;
    }

    public static f cIo() {
        a cIn = cIn();
        if (cIn.Awh == null) {
            synchronized (a.class) {
                if (cIn.Awh == null) {
                    cIn.Awh = new f();
                }
            }
        }
        return cIn.Awh;
    }

    public static void cIp() {
        c.d("MicroMsg.Voip", "registerEvents");
        cIo();
    }
}
