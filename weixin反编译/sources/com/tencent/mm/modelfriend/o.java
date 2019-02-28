package com.tencent.mm.modelfriend;

import com.tencent.mm.f.b.bp;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class o extends bp {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[16];
        aVar.columns = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "googleid";
        aVar.xrT.put("googleid", "TEXT");
        stringBuilder.append(" googleid TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "googlename";
        aVar.xrT.put("googlename", "TEXT");
        stringBuilder.append(" googlename TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "googlephotourl";
        aVar.xrT.put("googlephotourl", "TEXT");
        stringBuilder.append(" googlephotourl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "googlegmail";
        aVar.xrT.put("googlegmail", "TEXT");
        stringBuilder.append(" googlegmail TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "username";
        aVar.xrT.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "nickname";
        aVar.xrT.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "nicknameqp";
        aVar.xrT.put("nicknameqp", "TEXT");
        stringBuilder.append(" nicknameqp TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "usernamepy";
        aVar.xrT.put("usernamepy", "TEXT");
        stringBuilder.append(" usernamepy TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "small_url";
        aVar.xrT.put("small_url", "TEXT");
        stringBuilder.append(" small_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "big_url";
        aVar.xrT.put("big_url", "TEXT");
        stringBuilder.append(" big_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "ret";
        aVar.xrT.put("ret", "INTEGER");
        stringBuilder.append(" ret INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "googleitemid";
        aVar.xrT.put("googleitemid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" googleitemid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "googleitemid";
        aVar.columns[13] = "googlecgistatus";
        aVar.xrT.put("googlecgistatus", "INTEGER default '2' ");
        stringBuilder.append(" googlecgistatus INTEGER default '2' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "contecttype";
        aVar.xrT.put("contecttype", "TEXT");
        stringBuilder.append(" contecttype TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "googlenamepy";
        aVar.xrT.put("googlenamepy", "TEXT");
        stringBuilder.append(" googlenamepy TEXT");
        aVar.columns[16] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("googleIDgoogleid\n");
        stringBuffer.append("googleNamegooglename\n");
        stringBuffer.append("googlePhotoUrlgooglephotourl\n");
        stringBuffer.append("googleGmailgooglegmail\n");
        stringBuffer.append("userNameusername\n");
        stringBuffer.append("nickNamenickname\n");
        stringBuffer.append("nickNameQuanPinnicknameqp\n");
        stringBuffer.append("nickNamePYInitialusernamepy\n");
        stringBuffer.append("smallHeaderUrlsmall_url\n");
        stringBuffer.append("bigHeaderUrlbig_url\n");
        stringBuffer.append("retret\n");
        stringBuffer.append("statusstatus\n");
        stringBuffer.append("googleItemIDgoogleitemid\n");
        stringBuffer.append("cgiStatusgooglecgistatus\n");
        stringBuffer.append("contactTypecontecttype\n");
        stringBuffer.append("googleNamePYInitialgooglenamepy\n");
        return stringBuffer.toString();
    }
}
