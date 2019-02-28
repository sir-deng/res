package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class al {
    public String aeskey;
    public long fGj;
    public String frM;
    public String frQ;
    public String fvT;
    public int gkC;
    public String gkD = "";
    public int hGx;
    public String hXn;
    public long hXs;
    public int height;
    public String id;
    public String nGV;
    public String talker;
    public String thumbUrl;
    public int width;
    public int xHf;
    public int xHg;
    public int xHh;
    public int xHi;
    public String xHj = "";
    public String xHk;
    public String xHl;
    public String xHm;
    public boolean xHn = true;
    public String xHo;

    public static al a(Map<String, String> map, String str, String str2, String str3) {
        if (map == null) {
            return null;
        }
        al alVar = new al();
        alVar.xHj = str2;
        alVar.talker = str;
        alVar.id = (String) map.get(".msg.emoji.$idbuffer");
        alVar.hXn = (String) map.get(".msg.emoji.$fromusername");
        String str4 = (String) map.get(".msg.emoji.$androidmd5");
        alVar.frM = str4;
        if (str4 == null) {
            alVar.frM = (String) map.get(".msg.emoji.$md5");
        }
        if (!bi.oN(alVar.frM)) {
            alVar.frM = alVar.frM.toLowerCase();
        }
        try {
            alVar.xHf = Integer.valueOf((String) map.get(".msg.emoji.$type")).intValue();
            if (map.get(".msg.emoji.$androidlen") != null) {
                alVar.xHg = Integer.valueOf((String) map.get(".msg.emoji.$androidlen")).intValue();
            } else if (map.get(".msg.emoji.$len") != null) {
                alVar.xHg = Integer.valueOf((String) map.get(".msg.emoji.$len")).intValue();
            }
            if (map.get(".msg.gameext.$type") != null) {
                alVar.xHh = Integer.valueOf((String) map.get(".msg.gameext.$type")).intValue();
            }
            if (map.get(".msg.gameext.$content") != null) {
                alVar.xHi = Integer.valueOf((String) map.get(".msg.gameext.$content")).intValue();
            }
            if (map.get(".msg.emoji.$productid") != null) {
                alVar.frQ = (String) map.get(".msg.emoji.$productid");
            }
            if (map.get(".msg.emoji.$cdnurl") != null) {
                alVar.nGV = (String) map.get(".msg.emoji.$cdnurl");
            }
            if (map.get(".msg.emoji.$designerid") != null) {
                alVar.xHk = (String) map.get(".msg.emoji.$designerid");
            }
            if (map.get(".msg.emoji.$thumburl") != null) {
                alVar.thumbUrl = (String) map.get(".msg.emoji.$thumburl");
            }
            if (map.get(".msg.emoji.$encrypturl") != null) {
                alVar.fvT = (String) map.get(".msg.emoji.$encrypturl");
            }
            if (map.get(".msg.emoji.$aeskey") != null) {
                alVar.aeskey = (String) map.get(".msg.emoji.$aeskey");
            }
            if (map.get(".msg.emoji.$width") != null) {
                alVar.width = Integer.valueOf((String) map.get(".msg.emoji.$width")).intValue();
            }
            if (map.get(".msg.emoji.$height") != null) {
                alVar.height = Integer.valueOf((String) map.get(".msg.emoji.$height")).intValue();
            }
            if (map.get(".msg.emoji.$externurl") != null) {
                alVar.xHl = (String) map.get(".msg.emoji.$externurl");
            }
            if (map.get(".msg.emoji.$externmd5") != null) {
                alVar.xHm = (String) map.get(".msg.emoji.$externmd5");
            }
            if (map.get(".msg.emoji.$activityid") != null) {
                alVar.xHo = (String) map.get(".msg.emoji.$activityid");
            }
            if (!bi.oN(str3)) {
                alVar.gkD = str3;
            }
            x.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d externUrl:%s externMd5:%s", alVar.id, alVar.frM, Integer.valueOf(alVar.xHf), Integer.valueOf(alVar.xHg), Integer.valueOf(alVar.xHh), Integer.valueOf(alVar.xHi), alVar.frQ, alVar.nGV, alVar.xHk, alVar.thumbUrl, alVar.fvT, Integer.valueOf(alVar.width), Integer.valueOf(alVar.height), alVar.xHl, alVar.xHm);
            return alVar;
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", bi.i(e));
            return null;
        }
    }
}
