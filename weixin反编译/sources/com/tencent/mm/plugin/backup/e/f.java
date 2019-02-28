package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.modelvideo.p;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.plugin.backup.g.c;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class f implements l {
    public final int a(ev evVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, long j) {
        Object obj;
        int i;
        d.aqL().aqM().Ub();
        String nx = s.nx(auVar.field_imgPath);
        r wd = c.wd(auVar.field_imgPath);
        if (wd == null || wd.status == 199) {
            obj = 1;
        } else {
            obj = null;
        }
        File file = new File(nx);
        if (obj == null || !file.exists()) {
            i = 0;
        } else {
            i = (int) file.length();
        }
        int i2 = 0;
        d.aqL().aqM().Ub();
        String ny = s.ny(auVar.field_imgPath);
        File file2 = new File(ny);
        if (file2.exists()) {
            i2 = (int) file2.length();
        }
        if (z) {
            return i2 + i;
        }
        int i3 = 0;
        if (i2 != 0) {
            if (auVar.getType() == 62) {
                i3 = i.a(new i.a(ny, evVar, (LinkedList) linkedList, 13, z, "_thumb", z2)) + 0;
            } else {
                i3 = i.a(new i.a(ny, evVar, (LinkedList) linkedList, 11, z, "_thumb", z2)) + 0;
            }
        }
        i2 = (obj == null || i == 0) ? i3 : auVar.getType() == 62 ? i.a(new i.a(nx, evVar, (LinkedList) linkedList, 12, z, z2, null)) + i3 : i.a(new i.a(nx, evVar, (LinkedList) linkedList, 10, z, z2, null)) + i3;
        ny = a(evVar, auVar);
        if (ny == null) {
            return i2;
        }
        evVar.vNO = new bet().Vf(ny);
        return i2 + ny.length();
    }

    public final int a(String str, ev evVar, au auVar) {
        r rVar = new r();
        rVar.fEx = evVar.vNM.wRo;
        rVar.hXs = auVar.field_createTime;
        rVar.fGj = evVar.vNT;
        String str2 = evVar.vNO.wRo;
        x.d("MicroMsg.BackupItemVideo", "parseVideoMsgXML content:" + str2);
        Map y = bj.y(str2, "msg");
        if (y != null) {
            try {
                rVar.hmZ = g.aS((String) y.get(".msg.videomsg.$length"), 0);
                rVar.hXv = g.aS((String) y.get(".msg.videomsg.$playlength"), 0);
                rVar.hXn = (String) y.get(".msg.videomsg.$fromusername");
                int aS = g.aS((String) y.get(".msg.videomsg.$type"), 0);
                x.d("MicroMsg.BackupItemVideo", "video msg exportType :" + aS);
                if (aS == 44) {
                    aS = 1;
                } else {
                    aS = 0;
                }
                rVar.hXz = aS;
            } catch (Throwable e) {
                x.e("MicroMsg.BackupItemVideo", "parsing voice msg xml failed");
                x.printErrStackTrace("MicroMsg.BackupItemVideo", e, "", new Object[0]);
            }
        } else {
            x.e("MicroMsg.BackupItemVideo", "videomsg paseXml failed:%s", evVar.vNO.wRo);
            auVar.setContent(evVar.vNO.wRo);
        }
        if (g.d(evVar, 10) || g.d(evVar, 12)) {
            rVar.status = 199;
        } else {
            rVar.status = 111;
        }
        String nw = s.nw(rVar.Ul());
        auVar.dV(nw);
        rVar.fileName = nw;
        if (auVar.getType() != 62) {
            auVar.setType(43);
        }
        auVar.setContent(p.b(rVar.Ul(), rVar.hXu, false));
        rVar.hXw = (int) c.i(auVar);
        rVar.hXt = bi.Wx();
        rVar.hXx = 0;
        x.d("MicroMsg.BackupItemVideo", "Insert fileName[" + rVar.getFileName() + "] size:" + rVar.hmZ + " svrid:" + rVar.fGj + " timelen:" + rVar.hXv + " user:" + rVar.Uk() + " human:" + rVar.Ul());
        d.aqL().aqM().Ub().a(rVar);
        d.aqL().aqM().Ub();
        str2 = s.ny(nw);
        if (auVar.getType() == 62) {
            g.b(evVar, 13, str2);
            str2 = g.a(evVar, 12);
        } else {
            g.b(evVar, 11, str2);
            str2 = g.a(evVar, 10);
        }
        if (str2 != null) {
            str2 = g.vS(str2) + str2;
            d.aqL().aqM().Ub();
            k.r(str2, s.nx(nw), false);
        }
        return 0;
    }

    private static String a(ev evVar, au auVar) {
        r wd = c.wd(auVar.field_imgPath);
        if (wd == null) {
            return null;
        }
        int i;
        if (auVar.getType() == 62) {
            i = 62;
        } else {
            i = 43;
        }
        evVar.kzz = i;
        if (bi.oN(auVar.field_content)) {
            return null;
        }
        String Ul;
        if (c.eX(auVar.field_talker)) {
            Ul = wd.Ul();
        } else {
            Ul = evVar.vNM.wRo;
        }
        Writer stringWriter = new StringWriter();
        try {
            XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
            newSerializer.setOutput(stringWriter);
            newSerializer.startTag(null, "msg");
            newSerializer.startTag(null, "videomsg");
            Map y = bj.y(wd.Un(), "msg");
            if (y != null) {
                newSerializer.attribute(null, "aeskey", ((String) y.get(".msg.videomsg.$aeskey")));
                newSerializer.attribute(null, "cdnthumbaeskey", ((String) y.get(".msg.videomsg.$cdnthumbaeskey")));
                newSerializer.attribute(null, "cdnvideourl", ((String) y.get(".msg.videomsg.$cdnvideourl")));
                newSerializer.attribute(null, "cdnthumburl", ((String) y.get(".msg.videomsg.$cdnthumburl")));
                newSerializer.attribute(null, "cdnthumblength", ((String) y.get(".msg.videomsg.$cdnthumblength")));
            }
            newSerializer.attribute(null, "playlength", wd.hXv);
            newSerializer.attribute(null, "length", wd.hmZ);
            newSerializer.attribute(null, Columns.TYPE, String.valueOf(i));
            if (!bi.oN(Ul)) {
                newSerializer.attribute(null, "fromusername", Ul);
            }
            newSerializer.attribute(null, "md5", wd.fIf);
            newSerializer.endTag(null, "videomsg");
            newSerializer.endTag(null, "msg");
            newSerializer.endDocument();
            stringWriter.flush();
            stringWriter.close();
            String stringBuffer = stringWriter.getBuffer().toString();
            x.d("MicroMsg.BackupItemVideo", "parseContent xml:" + stringBuffer);
            return stringBuffer;
        } catch (Exception e) {
            x.e("MicroMsg.BackupItemVideo", "packetVoice xml error: " + e.toString());
            return null;
        }
    }
}
