package com.tencent.mm.network;

import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.au;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.network.d.a implements c {
    private boolean foreground = false;
    byte[] hpt;
    private byte[] ibg;
    private a ibh = null;
    byte[] ibi;
    String ibj;
    private Map<String, byte[]> ibk = new HashMap();
    private int uin;
    String username;

    public interface a {
    }

    public a(a aVar) {
        this.ibh = aVar;
        Vt();
    }

    public final void reset() {
        x.i("MicroMsg.AccInfo", "reset accinfo");
        this.username = "";
        this.ibg = null;
        Vt();
        this.uin = 0;
    }

    private void Vt() {
        this.hpt = bi.Wj(au.Ht().getString("server_id", ""));
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final void v(byte[] bArr, int i) {
        x.i("MicroMsg.AccInfo", "summerauth update session info: session:%s, uin:%d -> %d stack:[%s]", bi.Wz(bi.bx(bArr)), Integer.valueOf(this.uin), Integer.valueOf(i), bi.chl());
        this.ibg = bArr;
        this.uin = i;
        if (this.ibh != null) {
            Kz();
        }
    }

    public final void L(byte[] bArr) {
        this.hpt = bArr;
    }

    public final void M(byte[] bArr) {
        this.ibi = bArr;
    }

    public final byte[] CM() {
        return this.ibg;
    }

    public final byte[] KA() {
        return this.ibi;
    }

    public final byte[] Ky() {
        return this.hpt;
    }

    public final String getUsername() {
        return this.username;
    }

    public final int Cn() {
        return this.uin;
    }

    public final boolean Kz() {
        return this.ibg != null && this.ibg.length > 0;
    }

    public final String toString() {
        return ((((("AccInfo:\n" + "|-uin     =" + Cn() + "\n") + "|-user    =" + getUsername() + "\n") + "|-wxuser  =" + KY() + "\n") + "|-session =" + bi.bx(CM()) + "\n") + "|-ecdhkey =" + bi.bx(KA()) + "\n") + "`-cookie  =" + bi.bx(Ky());
    }

    public final void ok(String str) {
        this.ibj = str;
    }

    public final String KY() {
        return this.ibj;
    }

    public final void g(String str, byte[] bArr) {
        this.ibk.put(str, bArr);
    }

    public final byte[] js(String str) {
        return (byte[]) this.ibk.get(str);
    }

    public final boolean KB() {
        return this.foreground;
    }

    public final void bF(boolean z) {
        this.foreground = z;
        x.i("MicroMsg.AccInfo", "somr accinfo setForeground :%b", Boolean.valueOf(this.foreground));
    }

    private void clear() {
        this.username = null;
        this.ibg = null;
        this.hpt = null;
        this.uin = 0;
        this.ibi = null;
        this.ibj = null;
    }

    private String Vu() {
        try {
            ByteBuffer allocate = ByteBuffer.allocate(Downloads.RECV_BUFFER_SIZE);
            allocate.put(this.ibg).put(this.ibi).put(this.hpt).putInt(this.uin).put(this.ibj.getBytes()).put(this.username.getBytes());
            return g.s(allocate.array());
        } catch (Exception e) {
            return "";
        }
    }

    public final byte[] KC() {
        long Wy = bi.Wy();
        int i = bi.oN(this.username) ? 0 : bi.by(this.ibg) ? 0 : bi.by(this.hpt) ? 0 : (this.uin == 0 || this.uin == -1) ? 0 : bi.by(this.ibi) ? 0 : bi.oN(this.ibj) ? 0 : 1;
        if (i == 0) {
            x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
            return null;
        }
        try {
            u uVar = new u();
            uVar.cfK();
            uVar.VA(this.username);
            uVar.VA(this.ibj);
            uVar.Dw(this.uin);
            uVar.bu(this.hpt);
            uVar.bu(this.ibi);
            uVar.bu(this.ibg);
            uVar.VA(Vu());
            x.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", Long.valueOf(bi.bA(Wy)), Integer.valueOf(uVar.cfL().length), r6);
            return uVar.cfL();
        } catch (Throwable e) {
            x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", bi.i(e));
            return null;
        }
    }

    public final int G(byte[] bArr) {
        long Wy = bi.Wy();
        if (Kz()) {
            x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
            return -2;
        }
        try {
            u uVar = new u();
            if (uVar.bt(bArr) != 0) {
                x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", Integer.valueOf(uVar.bt(bArr)));
                return -3;
            }
            this.username = uVar.getString();
            this.ibj = uVar.getString();
            this.uin = uVar.getInt();
            this.hpt = uVar.getBuffer();
            this.ibi = uVar.getBuffer();
            this.ibg = uVar.getBuffer();
            String string = uVar.getString();
            if (bi.oN(string) || !string.equals(Vu())) {
                clear();
                x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
                return -4;
            }
            x.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", Long.valueOf(bi.bA(Wy)), string);
            return 0;
        } catch (Throwable e) {
            clear();
            x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", bi.i(e));
            return -5;
        }
    }

    public final void eE(int i) {
        x.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", Integer.valueOf(this.uin), Integer.valueOf(i), bi.chl());
        this.uin = i;
    }
}
