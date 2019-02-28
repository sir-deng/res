package com.tencent.mm.network.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.sdk.platformtools.x;
import java.net.InetAddress;

public final class c {
    private InetAddress idp;
    private int port;
    private int type;

    private c(InetAddress inetAddress, int i, int i2) {
        this.idp = inetAddress;
        this.port = i;
        this.type = i2;
    }

    public final String toString() {
        String str = "hc";
        if (this.type == 2) {
            str = "dns";
        } else if (this.type == 3) {
            str = "svrdns";
        } else if (this.type == 4) {
            str = "waphc";
        } else if (this.type == 5) {
            str = "newdns";
        } else if (this.type == 6) {
            str = "auth";
        } else if (this.type == 7) {
            str = "debug";
        }
        return this.idp.getHostAddress() + ":" + this.port + "(" + str + ")";
    }

    public static c on(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        if (split == null || split.length != 3) {
            return null;
        }
        try {
            return new c(q.Vy(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        } catch (Throwable e) {
            x.e("MicroMsg.InAddress", "exception:%s", bi.i(e));
            return null;
        }
    }
}
