package com.tencent.c.f;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class l {
    static HashMap<String, byte[]> Aeg = null;
    protected String Aec = "UTF-8";
    protected RequestPacket Aed = new RequestPacket();
    protected HashMap<String, byte[]> Aee = new HashMap();
    private HashMap<String, Object> Aef = new HashMap();

    public final void abI(String str) {
        this.Aec = str;
    }

    public final void abJ(String str) {
        this.Aed.sServantName = str;
    }

    public final void abK(String str) {
        this.Aed.sFuncName = str;
    }

    public final void cEF() {
        this.Aed.iRequestId = 3;
    }

    public final <T> void put(String str, T t) {
        if (str.startsWith(".") || t == null || (t instanceof Set)) {
            throw new IllegalArgumentException("wup put err");
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding(this.Aec);
        jceOutputStream.write((Object) t, 0);
        this.Aee.put(str, JceUtil.getJceBufArray(jceOutputStream.getByteBuffer()));
    }

    public final byte[] tr() {
        if (this.Aed.sServantName == null) {
            this.Aed.sServantName = "";
        }
        if (this.Aed.sFuncName == null) {
            this.Aed.sFuncName = "";
        }
        JceOutputStream jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.Aec);
        jceOutputStream.write(this.Aee, 0);
        this.Aed.sBuffer = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        jceOutputStream = new JceOutputStream(0);
        jceOutputStream.setServerEncoding(this.Aec);
        this.Aed.writeTo(jceOutputStream);
        byte[] jceBufArray = JceUtil.getJceBufArray(jceOutputStream.getByteBuffer());
        int length = jceBufArray.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 4);
        allocate.putInt(length + 4).put(jceBufArray).flip();
        return allocate.array();
    }
}
