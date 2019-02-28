package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    private static final String oZP = (e.bnF + "FailMsgFileCache");

    public static class a {
        public com.tencent.mm.plugin.notification.c.b oZQ = new com.tencent.mm.plugin.notification.c.b();
        public int oZR;
        public ArrayList<Long> oZS = new ArrayList();
        public ArrayList<Long> oZT = new ArrayList();

        public a(com.tencent.mm.plugin.notification.c.b bVar, int i, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
            this.oZQ = bVar;
            this.oZR = i;
            this.oZS = arrayList;
            this.oZT = arrayList2;
        }

        public final String bhm() {
            x.d("MicroMsg.FailMsgFileCache", "CacheObj, serializeToString");
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.oZQ.oZO.size(); i++) {
                    jSONArray.put(this.oZQ.get(i));
                }
                x.d("MicroMsg.FailMsgFileCache", "serializeToString, msgArray.size:%d", Integer.valueOf(jSONArray.length()));
                jSONObject.put("msg_list", jSONArray);
                x.d("MicroMsg.FailMsgFileCache", "serializeToString, currentSendIndex:%d", Integer.valueOf(this.oZR));
                jSONObject.put("current_send_index", this.oZR);
                jSONArray = new JSONArray();
                Iterator it = this.oZS.iterator();
                while (it.hasNext()) {
                    jSONArray.put((Long) it.next());
                }
                x.d("MicroMsg.FailMsgFileCache", "serializeToString, successArray.size:%d", Integer.valueOf(jSONArray.length()));
                jSONObject.put("success_msg_list", jSONArray);
                jSONArray = new JSONArray();
                it = this.oZT.iterator();
                while (it.hasNext()) {
                    jSONArray.put((Long) it.next());
                }
                x.d("MicroMsg.FailMsgFileCache", "serializeToString, failArray.size:%d", Integer.valueOf(jSONArray.length()));
                jSONObject.put("fail_msg_list", jSONArray);
                return jSONObject.toString();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
                return null;
            }
        }

        public final void Hr(String str) {
            x.d("MicroMsg.FailMsgFileCache", "CacheObj, createFromFileContent");
            try {
                int i;
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("msg_list");
                JSONArray jSONArray2 = jSONObject.getJSONArray("fail_msg_list");
                JSONArray jSONArray3 = jSONObject.getJSONArray("success_msg_list");
                x.d("MicroMsg.FailMsgFileCache", "createFromFileContent, msgArray.size:%d, failArray.size:%d, successArray.size:%d, index:%d", Integer.valueOf(jSONArray.length()), Integer.valueOf(jSONArray2.length()), Integer.valueOf(jSONArray3.length()), Integer.valueOf(jSONObject.getInt("current_send_index")));
                this.oZQ.clear();
                this.oZT.clear();
                this.oZS.clear();
                for (i = 0; i < jSONArray.length(); i++) {
                    this.oZQ.dW(jSONArray.getLong(i));
                }
                for (i = 0; i < jSONArray2.length(); i++) {
                    this.oZT.add(Long.valueOf(jSONArray2.getLong(i)));
                }
                for (i = 0; i < jSONArray3.length(); i++) {
                    this.oZS.add(Long.valueOf(jSONArray3.getLong(i)));
                }
                this.oZR = r5;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
                x.d("MicroMsg.FailMsgFileCache", "createFromFileContent error:%s", e.getMessage());
            }
        }
    }

    public static void init() {
        x.d("MicroMsg.FailMsgFileCache", "init FailMsgFileCache");
        new File(oZP).mkdirs();
    }

    public static void a(int i, a aVar) {
        String str = null;
        if (i == 1) {
            str = oZP + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oZP + File.separator + "snsMsg";
        }
        if (bi.oN(str)) {
            x.e("MicroMsg.FailMsgFileCache", "flushToDisk error, cannot find filename");
            return;
        }
        x.d("MicroMsg.FailMsgFileCache", "flushToDisk, filename:%s", str);
        String bhm = aVar.bhm();
        x.d("MicroMsg.FailMsgFileCache", "flushToDisk, cacheContent:%s", bhm);
        if (bi.oN(bhm)) {
            x.d("MicroMsg.FailMsgFileCache", "flushToDisk, content is empty");
        } else {
            com.tencent.mm.a.e.b(str, bhm.getBytes(), bhm.length());
        }
    }

    public static a uB(int i) {
        String str;
        if (i == 1) {
            str = oZP + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oZP + File.separator + "snsMsg";
        } else {
            str = null;
        }
        if (bi.oN(str)) {
            x.e("MicroMsg.FailMsgFileCache", "extractFromDisk error, cannot find filename");
            return null;
        }
        x.d("MicroMsg.FailMsgFileCache", "extractFromDisk, filename:%s", str);
        try {
            x.d("MicroMsg.FailMsgFileCache", "extractFromDisk, cacheContent:%s", com.tencent.mm.a.e.bT(str));
            a aVar = new a();
            aVar.Hr(r2);
            return aVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
            x.d("MicroMsg.FailMsgFileCache", "extractFromDisk error:%s", e.toString());
            return null;
        }
    }

    public static void uC(int i) {
        String str = null;
        if (i == 1) {
            str = oZP + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oZP + File.separator + "snsMsg";
        }
        if (bi.oN(str)) {
            x.e("MicroMsg.FailMsgFileCache", "removeFile error, cannot find filename");
            return;
        }
        x.d("MicroMsg.FailMsgFileCache", "removeFile, filename:%s", str);
        if (com.tencent.mm.a.e.bO(str)) {
            new File(str).delete();
        }
    }
}
