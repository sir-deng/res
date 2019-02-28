package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class o extends g {
    private final ag iHt;

    public o(ag agVar) {
        this.iHt = agVar;
    }

    public final boolean bE(String str) {
        return true;
    }

    public final j qk(String str) {
        Closeable qa = this.iHt.qa(str);
        if (qa == null) {
            return j.RET_NOT_EXISTS;
        }
        bi.d(qa);
        return j.OK;
    }

    public final j b(String str, h<List<h>> hVar) {
        if (qk(str) == j.OK) {
            return j.ERR_IS_FILE;
        }
        String pQ = a.pQ(str);
        ag agVar = this.iHt;
        List<ag.a> linkedList = new LinkedList();
        for (ag.a add : agVar.iHS.values()) {
            linkedList.add(add);
        }
        String quote = Pattern.quote(pQ);
        for (ag.a add2 : linkedList) {
            if (add2.fileName.startsWith(pQ)) {
                String replaceFirst = add2.fileName.replaceFirst(quote, "");
                if (replaceFirst.split("/").length <= 1) {
                    Object linkedList2;
                    h hVar2 = new h();
                    hVar2.fileName = replaceFirst;
                    if (hVar.jXv == null) {
                        linkedList2 = new LinkedList();
                    } else {
                        List linkedList22 = (List) hVar.jXv;
                    }
                    hVar.jXv = linkedList22;
                    ((List) hVar.jXv).add(hVar2);
                }
            }
        }
        return hVar.jXv == null ? j.RET_NOT_EXISTS : j.OK;
    }

    public final j qp(String str) {
        return b(str, new h());
    }

    public final j a(String str, h<ByteBuffer> hVar) {
        Closeable qa = this.iHt.qa(str);
        if (qa == null) {
            return j.RET_NOT_EXISTS;
        }
        j jVar;
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(qa.available());
            if (qa instanceof com.tencent.mm.plugin.appbrand.k.a) {
                allocateDirect.put(((com.tencent.mm.plugin.appbrand.k.a) qa).jMu);
            } else {
                allocateDirect.put(ByteBuffer.wrap(c.k(qa)));
            }
            allocateDirect.rewind();
            hVar.jXv = allocateDirect;
            jVar = j.OK;
            return jVar;
        } catch (Exception e) {
            jVar = e;
            x.printErrStackTrace("MicroMsg.WxaPkgFileSystem", jVar, "readFile", new Object[0]);
            return j.ERR_OP_FAIL;
        } finally {
            bi.d(qa);
        }
    }

    public final j a(String str, FileStructStat fileStructStat) {
        Closeable qa = this.iHt.qa(str);
        if (qa == null) {
            return j.RET_NOT_EXISTS;
        }
        ag agVar = this.iHt;
        FileStructStat fileStructStat2 = agVar.iHT;
        if (fileStructStat2 == null) {
            fileStructStat2 = new FileStructStat();
            FileStat.stat(agVar.iHM.getAbsolutePath(), fileStructStat2);
            agVar.iHT = fileStructStat2;
        }
        fileStructStat2.fillAnother(fileStructStat);
        try {
            fileStructStat.st_size = (long) qa.available();
            bi.d(qa);
        } catch (Exception e) {
            x.e("MicroMsg.WxaPkgFileSystem", "stat(), %s stream.available fail", str);
        }
        return j.OK;
    }

    public final void initialize() {
        this.iHt.aai();
    }

    public final void release() {
        this.iHt.close();
    }
}
