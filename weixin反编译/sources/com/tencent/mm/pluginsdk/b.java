package com.tencent.mm.pluginsdk;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;

public final class b {

    public static final class b {
        public static final HashMap<Integer, Integer> viL;

        static {
            HashMap hashMap = new HashMap();
            viL = hashMap;
            hashMap.put(Integer.valueOf(22), Integer.valueOf(64));
            viL.put(Integer.valueOf(9), Integer.valueOf(64));
            viL.put(Integer.valueOf(3), Integer.valueOf(64));
            viL.put(Integer.valueOf(23), Integer.valueOf(64));
            viL.put(Integer.valueOf(25), Integer.valueOf(64));
            viL.put(Integer.valueOf(13), Integer.valueOf(64));
            viL.put(Integer.valueOf(29), Integer.valueOf(256));
            viL.put(Integer.valueOf(34), Integer.valueOf(WXMediaMessage.TITLE_LENGTH_LIMIT));
            viL.put(Integer.valueOf(6), Integer.valueOf(WXMediaMessage.TITLE_LENGTH_LIMIT));
            viL.put(Integer.valueOf(35), Integer.valueOf(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
            viL.put(Integer.valueOf(36), Integer.valueOf(Downloads.RECV_BUFFER_SIZE));
            viL.put(Integer.valueOf(37), Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
            viL.put(Integer.valueOf(38), Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
            viL.put(Integer.valueOf(42), Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
            viL.put(Integer.valueOf(40), Integer.valueOf(65536));
            viL.put(Integer.valueOf(41), Integer.valueOf(65536));
            viL.put(Integer.valueOf(46), Integer.valueOf(262144));
            viL.put(Integer.valueOf(48), Integer.valueOf(SQLiteGlobal.journalSizeLimit));
        }
    }

    public static final class a {
        public static final HashMap<String, Long> viK;

        public static Long RH(String str) {
            if (str == null) {
                return null;
            }
            return (Long) viK.get(str.toLowerCase());
        }

        static {
            HashMap hashMap = new HashMap();
            viK = hashMap;
            hashMap.put("doc", Long.valueOf(64));
            viK.put("docx", Long.valueOf(128));
            viK.put("ppt", Long.valueOf(256));
            viK.put("pptx", Long.valueOf(512));
            viK.put("xls", Long.valueOf(1024));
            viK.put("xlsx", Long.valueOf(2048));
            viK.put("pdf", Long.valueOf(4096));
            viK.put("1", Long.valueOf(1));
            viK.put(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, Long.valueOf(2));
            viK.put("48", Long.valueOf(4));
            viK.put("43", Long.valueOf(8));
            viK.put("mp3", Long.valueOf(16));
            viK.put("wav", Long.valueOf(16));
            viK.put("wma", Long.valueOf(16));
            viK.put("avi", Long.valueOf(8));
            viK.put("rmvb", Long.valueOf(8));
            viK.put("rm", Long.valueOf(8));
            viK.put("mpg", Long.valueOf(8));
            viK.put("mpeg", Long.valueOf(8));
            viK.put("wmv", Long.valueOf(8));
            viK.put("mp4", Long.valueOf(8));
            viK.put("mkv", Long.valueOf(8));
        }
    }
}
