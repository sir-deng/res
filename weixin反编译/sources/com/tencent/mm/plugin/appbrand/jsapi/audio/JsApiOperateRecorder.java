package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.f.a.lk;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.media.f;
import com.tencent.mm.plugin.appbrand.media.f.AnonymousClass6;
import com.tencent.mm.plugin.appbrand.media.g;
import com.tencent.mm.plugin.appbrand.media.record.RecordParam;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOperateRecorder extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 295;
    public static final String NAME = "operateRecorder";
    private static Vector<String> jhJ = new Vector();
    private b jij;
    private OperateRecordTask jit;
    private p jiu;
    private int jiv;

    private static class OperateRecordTask extends MainProcessTask {
        public static final Creator<OperateRecordTask> CREATOR = new Creator<OperateRecordTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OperateRecordTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateRecordTask[i];
            }
        };
        public int action;
        public String appId;
        private int duration = 0;
        private byte[] fDD;
        private boolean fDE;
        private String filePath = "";
        private int fileSize = 0;
        public j jga;
        public int jgb;
        public String jhM = "";
        public boolean jhO = false;
        private String jiA = "";
        private String jiB;
        private int jiC;
        private final c<lk> jiD = new c<lk>() {
            {
                this.xmG = lk.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                lk lkVar = (lk) bVar;
                x.i("MicroMsg.JsApiOperateRecorder", "mListener callback action : %d", Integer.valueOf(lkVar.fDC.action));
                if (OperateRecordTask.this.appId.equalsIgnoreCase(lkVar.fDC.appId)) {
                    Map hashMap = new HashMap();
                    hashMap.put("state", lkVar.fDC.state);
                    OperateRecordTask.this.state = lkVar.fDC.state;
                    if (lkVar.fDC.action == 2) {
                        OperateRecordTask.this.filePath = lkVar.fDC.filePath;
                        OperateRecordTask.this.duration = lkVar.fDC.duration;
                        OperateRecordTask.this.fileSize = lkVar.fDC.fileSize;
                        com.tencent.mm.plugin.appbrand.media.c.tL(OperateRecordTask.this.appId);
                    }
                    if (lkVar.fDC.action == 4) {
                        hashMap.put("errCode", Integer.valueOf(lkVar.fDC.errCode));
                        Object obj = "";
                        if (!TextUtils.isEmpty(lkVar.fDC.foE)) {
                            obj = lkVar.fDC.foE;
                        }
                        hashMap.put("errMsg", obj);
                    }
                    if (lkVar.fDC.action == 5) {
                        if (lkVar.fDC.fDD == null || lkVar.fDC.fDD.length <= 819200) {
                            OperateRecordTask.this.fDD = lkVar.fDC.fDD;
                        } else {
                            OperateRecordTask.a(OperateRecordTask.this, lkVar);
                        }
                        OperateRecordTask.this.jiC = lkVar.fDC.fDD != null ? lkVar.fDC.fDD.length : 0;
                        OperateRecordTask.this.fDE = lkVar.fDC.fDE;
                        x.i("MicroMsg.JsApiOperateRecorder", "frameBufferSize:%d", Integer.valueOf(OperateRecordTask.this.jiC));
                    }
                    OperateRecordTask.this.jik = new JSONObject(hashMap).toString();
                    OperateRecordTask.this.action = lkVar.fDC.action;
                    OperateRecordTask.this.afF();
                    return true;
                }
                x.e("MicroMsg.JsApiOperateRecorder", "appId is diff, don't send event");
                return false;
            }
        };
        b jij;
        public String jik;
        private JsApiOperateRecorder jiy;
        public String jiz;
        public String processName = "";
        private String state = "";

        static /* synthetic */ void a(OperateRecordTask operateRecordTask, lk lkVar) {
            Throwable e;
            long nanoTime = System.nanoTime();
            FileOutputStream fileOutputStream = null;
            try {
                File file = new File(operateRecordTask.jiB);
                x.d("MicroMsg.JsApiOperateRecorder", "frameBufferPath:%s", operateRecordTask.jiB);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(lkVar.fDC.fDD);
                    fileOutputStream2.close();
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e2, "", new Object[0]);
                    }
                } catch (FileNotFoundException e3) {
                    e2 = e3;
                    fileOutputStream = fileOutputStream2;
                    try {
                        x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e2, "", new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e22, "", new Object[0]);
                            }
                        }
                        x.d("MicroMsg.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                    } catch (Throwable th) {
                        e22 = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e4, "", new Object[0]);
                            }
                        }
                        throw e22;
                    }
                } catch (IOException e5) {
                    e22 = e5;
                    fileOutputStream = fileOutputStream2;
                    x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e22, "", new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e222) {
                            x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                        }
                    }
                    x.d("MicroMsg.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                } catch (Throwable th2) {
                    e222 = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e222;
                }
            } catch (FileNotFoundException e6) {
                e222 = e6;
                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                x.d("MicroMsg.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
            } catch (IOException e7) {
                e222 = e7;
                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                x.d("MicroMsg.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
            }
            x.d("MicroMsg.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
        }

        public OperateRecordTask(JsApiOperateRecorder jsApiOperateRecorder, j jVar, int i) {
            this.jiy = jsApiOperateRecorder;
            this.jga = jVar;
            this.jgb = i;
            this.jiB = AppBrandLocalMediaObjectManager.genMediaFilePath(jVar.mAppId, "frameBuffer");
        }

        public OperateRecordTask(Parcel parcel) {
            f(parcel);
        }

        public final void YA() {
            boolean z = false;
            try {
                JSONObject jSONObject = new JSONObject(this.jiz);
                String optString = jSONObject.optString("operationType");
                if (TextUtils.isEmpty(optString)) {
                    x.e("MicroMsg.JsApiOperateRecorder", "operationType is null");
                    this.jhO = true;
                    this.action = -1;
                    this.jhM = "operationType is null";
                    afF();
                    return;
                }
                x.i("MicroMsg.JsApiOperateRecorder", "operationType;%s", optString);
                this.jhO = false;
                this.action = -1;
                boolean z2;
                f ZD;
                if (optString.equals("start")) {
                    int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 60000);
                    int optInt2 = jSONObject.optInt("sampleRate", 44100);
                    int optInt3 = jSONObject.optInt("numberOfChannels", 2);
                    int optInt4 = jSONObject.optInt("encodeBitRate", 128000);
                    String optString2 = jSONObject.optString("format");
                    int optInt5 = jSONObject.optInt("frameSize", 0);
                    com.tencent.mm.plugin.appbrand.media.c.a(this.appId, this.jiD);
                    com.tencent.mm.plugin.appbrand.media.c.aiS();
                    RecordParam recordParam = new RecordParam();
                    recordParam.duration = optInt;
                    recordParam.sampleRate = optInt2;
                    recordParam.jFX = optInt3;
                    recordParam.jFY = optInt4;
                    recordParam.jiA = optString2;
                    recordParam.scene = 8;
                    recordParam.afs = optInt5;
                    recordParam.gIR = System.currentTimeMillis();
                    recordParam.processName = this.processName;
                    recordParam.appId = this.appId;
                    this.jiA = optString2;
                    f ZD2 = e.ZD();
                    x.i("MicroMsg.AudioRecordMgr", JsApiStartRecordVoice.NAME);
                    if (ZD2.jFi == null || recordParam.appId == null || recordParam.appId.equalsIgnoreCase(ZD2.jFi.appId)) {
                        if (ZD2.jFg) {
                            x.e("MicroMsg.AudioRecordMgr", "startRecord fail, is recording");
                        } else if (ZD2.vh()) {
                            x.e("MicroMsg.AudioRecordMgr", "startRecord fail, is pause");
                        }
                        if (z) {
                            x.i("MicroMsg.JsApiOperateRecorder", "star record ok");
                            this.action = -1;
                        } else if (e.ZD().jFg) {
                            this.jhO = true;
                            this.jhM = "start record fail";
                        } else {
                            this.jhO = true;
                            this.jhM = "audio is recording, don't start record again";
                        }
                    } else {
                        x.e("MicroMsg.AudioRecordMgr", "appId is diff, must stop record first");
                        ZD2.vj();
                    }
                    z2 = !TextUtils.isEmpty(recordParam.jiA) && recordParam.duration >= 0 && recordParam.jFY > 0 && recordParam.sampleRate > 0 && recordParam.jFX > 0;
                    if (!z2) {
                        x.e("MicroMsg.AudioRecordMgr", "startRecord fail, param is invalid");
                        com.tencent.mm.plugin.appbrand.media.j.ln(15);
                    } else if (g.tP(recordParam.jiA)) {
                        if (TextUtils.isEmpty(recordParam.gIR)) {
                            recordParam.gIR = System.currentTimeMillis();
                        }
                        com.tencent.mm.plugin.appbrand.media.j.ajb();
                        x.i("MicroMsg.RecordParamCompatibility", "recordParam duration:%d, numberOfChannels:%d, sampleRate:%d, encodeBitRate:%d", Integer.valueOf(recordParam.duration), Integer.valueOf(recordParam.jFX), Integer.valueOf(recordParam.sampleRate), Integer.valueOf(recordParam.jFY));
                        if (recordParam.duration <= 0) {
                            recordParam.duration = 60000;
                        } else if (recordParam.duration >= 600000) {
                            recordParam.duration = 600000;
                        }
                        if (recordParam.jFX <= 0 && recordParam.jFX > 2) {
                            recordParam.jFX = 2;
                        }
                        if (recordParam.sampleRate > 48000) {
                            recordParam.sampleRate = 48000;
                        } else if (recordParam.sampleRate < 8000) {
                            recordParam.sampleRate = 8000;
                        }
                        if (recordParam.jFY > 320000) {
                            recordParam.jFY = 320000;
                        } else if (recordParam.jFY < 16000) {
                            recordParam.jFY = 16000;
                        }
                        com.tencent.mm.sdk.f.e.post(new AnonymousClass6(recordParam), "app_brand_start_record");
                        z = true;
                    } else {
                        x.e("MicroMsg.AudioRecordMgr", "startRecord fail, encode format %s is not support!", recordParam.jiA);
                        com.tencent.mm.plugin.appbrand.media.j.ln(16);
                    }
                    if (z) {
                        x.i("MicroMsg.JsApiOperateRecorder", "star record ok");
                        this.action = -1;
                    } else if (e.ZD().jFg) {
                        this.jhO = true;
                        this.jhM = "start record fail";
                    } else {
                        this.jhO = true;
                        this.jhM = "audio is recording, don't start record again";
                    }
                } else if (optString.equals("resume")) {
                    ZD = e.ZD();
                    if (ZD.jFg) {
                        x.e("MicroMsg.AudioRecordMgr", "resumeRecord fail, is recording");
                    } else if (ZD.jFi == null) {
                        x.e("MicroMsg.AudioRecordMgr", "resumeRecord fail, mRecordParam is null");
                    } else {
                        com.tencent.mm.plugin.appbrand.media.j.ajb();
                        com.tencent.mm.sdk.f.e.post(new Runnable() {
                            public final void run() {
                                synchronized (f.this.jFh) {
                                    f.b(f.this);
                                }
                            }
                        }, "app_brand_resume_record");
                        z = true;
                    }
                    if (z) {
                        this.action = -1;
                        x.i("MicroMsg.JsApiOperateRecorder", "resume record ok");
                    } else if (e.ZD().jFg) {
                        this.jhO = true;
                        this.jhM = "audio is recording, don't resume record again";
                    } else {
                        this.jhO = true;
                        this.jhM = "resume record fail";
                    }
                } else if (optString.equals("pause")) {
                    ZD = e.ZD();
                    x.i("MicroMsg.AudioRecordMgr", "pauseRecord");
                    if (ZD.jFf == null) {
                        x.e("MicroMsg.AudioRecordMgr", "mRecord is null");
                        z2 = false;
                    } else if (ZD.vh()) {
                        x.e("MicroMsg.AudioRecordMgr", "is paused, don't pause again");
                        z2 = true;
                    } else {
                        com.tencent.mm.sdk.f.e.post(new Runnable() {
                            public final void run() {
                                synchronized (f.this.jFh) {
                                    f.this.aiY();
                                }
                            }
                        }, "app_brand_pause_record");
                        z2 = true;
                    }
                    if (z2) {
                        this.action = -1;
                        x.i("MicroMsg.JsApiOperateRecorder", "pause record ok");
                    } else if (e.ZD().vh()) {
                        this.jhO = true;
                        this.jhM = "audio is pause, don't pause record again";
                    } else {
                        this.jhO = true;
                        this.jhM = "pause record fail";
                    }
                } else if (!optString.equals("stop")) {
                    x.e("MicroMsg.JsApiOperateRecorder", "operationType is invalid");
                    this.jhO = true;
                    this.jhM = "operationType is invalid";
                } else if (e.ZD().vj()) {
                    this.action = -1;
                    x.i("MicroMsg.JsApiOperateRecorder", "stop record ok");
                } else if (e.ZD().aiV()) {
                    this.jhO = true;
                    this.jhM = "audio is stop, don't stop record again";
                } else {
                    this.jhO = true;
                    this.jhM = "stop record fail";
                }
                if (this.jhO) {
                    x.e("MicroMsg.JsApiOperateRecorder", this.jhM);
                }
                afF();
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiOperateRecorder", "new json exists exception, data is invalid, dataStr:%s", this.jiz);
                this.jhO = true;
                this.action = -1;
                this.jhM = "parser data fail, data is invalid";
                x.e("MicroMsg.JsApiOperateRecorder", "exception:%s" + e.getMessage());
                afF();
            }
        }

        public final void YB() {
            Throwable e;
            File file;
            com.tencent.mm.plugin.appbrand.jsapi.f a;
            FileInputStream fileInputStream = null;
            if (this.jga == null) {
                x.e("MicroMsg.JsApiOperateRecorder", "service is null, don't callback");
            } else if (this.action != -1) {
                com.tencent.mm.plugin.appbrand.jsapi.b aVar = new a();
                switch (this.action) {
                    case 0:
                    case 1:
                        JsApiOperateRecorder.a(this.jiy, true);
                        if (!JsApiOperateRecorder.jhJ.contains(this.appId)) {
                            com.tencent.mm.plugin.appbrand.c.a(this.appId, this.jij);
                            JsApiOperateRecorder.jhJ.add(this.appId);
                            break;
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                        JsApiOperateRecorder.a(this.jiy, false);
                        if (this.action == 2 || this.action == 4) {
                            com.tencent.mm.plugin.appbrand.c.b(this.appId, this.jij);
                            JsApiOperateRecorder.jhJ.remove(this.appId);
                            break;
                        }
                }
                if (this.action == 2) {
                    AppBrandLocalMediaObject attach;
                    Map hashMap = new HashMap();
                    hashMap.put("state", this.state);
                    x.i("MicroMsg.JsApiOperateRecorder", "filePath:%s, encodeFormat:%s", this.filePath, this.jiA);
                    String str = this.jga.mAppId;
                    String str2 = this.filePath;
                    String str3 = this.jiA;
                    if (!TextUtils.isEmpty(str3)) {
                        if ("aac".equalsIgnoreCase(str3)) {
                            str3 = "m4a";
                        } else if ("mp3".equalsIgnoreCase(str3)) {
                            str3 = "mp3";
                        } else if ("wav".equalsIgnoreCase(str3)) {
                            str3 = "wav";
                        }
                        attach = AppBrandLocalMediaObjectManager.attach(str, str2, str3, false);
                        if (attach == null) {
                            hashMap.put("tempFilePath", attach.fvn);
                        } else {
                            x.e("MicroMsg.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
                            hashMap.put("tempFilePath", "");
                        }
                        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
                        hashMap.put("fileSize", Integer.valueOf(this.fileSize));
                        this.jik = new JSONObject(hashMap).toString();
                    }
                    str3 = "";
                    attach = AppBrandLocalMediaObjectManager.attach(str, str2, str3, false);
                    if (attach == null) {
                        x.e("MicroMsg.JsApiOperateRecorder", "AppBrandLocalMediaObject obj is null");
                        hashMap.put("tempFilePath", "");
                    } else {
                        hashMap.put("tempFilePath", attach.fvn);
                    }
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
                    hashMap.put("fileSize", Integer.valueOf(this.fileSize));
                    this.jik = new JSONObject(hashMap).toString();
                }
                if (this.action == 5) {
                    Map hashMap2 = new HashMap();
                    hashMap2.put("state", this.state);
                    hashMap2.put("isLastFrame", Boolean.valueOf(this.fDE));
                    if (this.jiC > 819200) {
                        long nanoTime = System.nanoTime();
                        File file2;
                        FileInputStream fileInputStream2;
                        try {
                            file2 = new File(this.jiB);
                            try {
                                if (file2.exists()) {
                                    fileInputStream2 = new FileInputStream(file2);
                                    try {
                                        this.fDD = new byte[this.jiC];
                                        fileInputStream2.read(this.fDD);
                                        fileInputStream2.close();
                                        try {
                                            fileInputStream2.close();
                                        } catch (Throwable e2) {
                                            x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e2, "", new Object[0]);
                                        }
                                        if (file2.exists()) {
                                            file2.delete();
                                        } else {
                                            x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                        }
                                    } catch (FileNotFoundException e3) {
                                        e2 = e3;
                                        file = file2;
                                        try {
                                            x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e2, "", new Object[0]);
                                            if (fileInputStream2 != null) {
                                                try {
                                                    fileInputStream2.close();
                                                } catch (Throwable e22) {
                                                    x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e22, "", new Object[0]);
                                                }
                                            }
                                            if (file == null) {
                                            }
                                            x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                            x.d("MicroMsg.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                                            if (this.fDD != null) {
                                                x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                                            } else {
                                                hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fDD));
                                            }
                                            if (l.a(this.jga, hashMap2, aVar)) {
                                                this.jik = new JSONObject(hashMap2).toString();
                                            }
                                            x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", Integer.valueOf(this.action), this.jik);
                                            a = aVar.a(this.jga);
                                            a.mData = this.jik;
                                            a.afI();
                                        } catch (Throwable th) {
                                            e22 = th;
                                            file2 = file;
                                            fileInputStream = fileInputStream2;
                                            if (fileInputStream != null) {
                                                try {
                                                    fileInputStream.close();
                                                } catch (Throwable e4) {
                                                    x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e4, "", new Object[0]);
                                                }
                                            }
                                            if (file2 == null) {
                                            }
                                            x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                            throw e22;
                                        }
                                    } catch (IOException e5) {
                                        e22 = e5;
                                        fileInputStream = fileInputStream2;
                                        try {
                                            x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e22, "", new Object[0]);
                                            if (fileInputStream != null) {
                                                try {
                                                    fileInputStream.close();
                                                } catch (Throwable e222) {
                                                    x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                                                }
                                            }
                                            if (file2 == null) {
                                            }
                                            x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                            x.d("MicroMsg.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                                            if (this.fDD != null) {
                                                hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fDD));
                                            } else {
                                                x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                                            }
                                            if (l.a(this.jga, hashMap2, aVar)) {
                                                this.jik = new JSONObject(hashMap2).toString();
                                            }
                                            x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", Integer.valueOf(this.action), this.jik);
                                            a = aVar.a(this.jga);
                                            a.mData = this.jik;
                                            a.afI();
                                        } catch (Throwable th2) {
                                            e222 = th2;
                                            if (fileInputStream != null) {
                                                fileInputStream.close();
                                            }
                                            if (file2 == null && file2.exists()) {
                                                file2.delete();
                                            } else {
                                                x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                            }
                                            throw e222;
                                        }
                                    } catch (Throwable th3) {
                                        e222 = th3;
                                        fileInputStream = fileInputStream2;
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        if (file2 == null) {
                                        }
                                        x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                        throw e222;
                                    }
                                    x.d("MicroMsg.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                                } else {
                                    x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, return");
                                    if (file2.exists()) {
                                        file2.delete();
                                    } else {
                                        x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                    }
                                }
                            } catch (FileNotFoundException e6) {
                                e222 = e6;
                                fileInputStream2 = null;
                                file = file2;
                                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                                if (file == null) {
                                }
                                x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                x.d("MicroMsg.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                                if (this.fDD != null) {
                                    x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                                } else {
                                    hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fDD));
                                }
                                if (l.a(this.jga, hashMap2, aVar)) {
                                    this.jik = new JSONObject(hashMap2).toString();
                                }
                                x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", Integer.valueOf(this.action), this.jik);
                                a = aVar.a(this.jga);
                                a.mData = this.jik;
                                a.afI();
                            } catch (IOException e7) {
                                e222 = e7;
                                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (file2 == null) {
                                }
                                x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                                x.d("MicroMsg.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                                if (this.fDD != null) {
                                    hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fDD));
                                } else {
                                    x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                                }
                                if (l.a(this.jga, hashMap2, aVar)) {
                                    this.jik = new JSONObject(hashMap2).toString();
                                }
                                x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", Integer.valueOf(this.action), this.jik);
                                a = aVar.a(this.jga);
                                a.mData = this.jik;
                                a.afI();
                            }
                        } catch (FileNotFoundException e8) {
                            e222 = e8;
                            fileInputStream2 = null;
                            x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            if (file == null && file.exists()) {
                                file.delete();
                            } else {
                                x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                            }
                            x.d("MicroMsg.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                            if (this.fDD != null) {
                                x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                            } else {
                                hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fDD));
                            }
                            if (l.a(this.jga, hashMap2, aVar)) {
                                this.jik = new JSONObject(hashMap2).toString();
                            }
                            x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", Integer.valueOf(this.action), this.jik);
                            a = aVar.a(this.jga);
                            a.mData = this.jik;
                            a.afI();
                        } catch (IOException e9) {
                            e222 = e9;
                            file2 = null;
                            x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e222, "", new Object[0]);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (file2 == null && file2.exists()) {
                                file2.delete();
                            } else {
                                x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                            }
                            x.d("MicroMsg.JsApiOperateRecorder", "time:%d", Long.valueOf(System.nanoTime() - nanoTime));
                            if (this.fDD != null) {
                                hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fDD));
                            } else {
                                x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                            }
                            if (l.a(this.jga, hashMap2, aVar)) {
                                this.jik = new JSONObject(hashMap2).toString();
                            }
                            x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", Integer.valueOf(this.action), this.jik);
                            a = aVar.a(this.jga);
                            a.mData = this.jik;
                            a.afI();
                        } catch (Throwable th4) {
                            e222 = th4;
                            file2 = null;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (file2 == null) {
                            }
                            x.e("MicroMsg.JsApiOperateRecorder", "frameBufferFile is not exist, delete error");
                            throw e222;
                        }
                    }
                    if (this.fDD != null) {
                        hashMap2.put("frameBuffer", ByteBuffer.wrap(this.fDD));
                    } else {
                        x.e("MicroMsg.JsApiOperateRecorder", "framBuffer is null, error");
                    }
                    if (l.a(this.jga, hashMap2, aVar)) {
                        this.jik = new JSONObject(hashMap2).toString();
                    }
                }
                x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder onRecorderStateChange callback action:%d, jsonResult:%s", Integer.valueOf(this.action), this.jik);
                a = aVar.a(this.jga);
                a.mData = this.jik;
                a.afI();
            } else if (this.jhO) {
                x.e("MicroMsg.JsApiOperateRecorder", "operateRecorder fail:%s", this.jhM);
                this.jga.E(this.jgb, this.jiy.e("fail:" + this.jhM, null));
            } else {
                x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder ok");
                this.jga.E(this.jgb, this.jiy.e("ok", null));
            }
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.appId = parcel.readString();
            this.jiz = parcel.readString();
            this.jhO = parcel.readInt() == 1;
            this.jhM = parcel.readString();
            this.jik = parcel.readString();
            this.action = parcel.readInt();
            this.filePath = parcel.readString();
            this.fileSize = parcel.readInt();
            this.duration = parcel.readInt();
            this.state = parcel.readString();
            this.jiA = parcel.readString();
            this.fDD = parcel.createByteArray();
            this.jiC = parcel.readInt();
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.fDE = z;
            this.jiB = parcel.readString();
            this.processName = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            parcel.writeString(this.appId);
            parcel.writeString(this.jiz);
            parcel.writeInt(this.jhO ? 1 : 0);
            parcel.writeString(this.jhM);
            parcel.writeString(this.jik);
            parcel.writeInt(this.action);
            parcel.writeString(this.filePath);
            parcel.writeInt(this.fileSize);
            parcel.writeInt(this.duration);
            parcel.writeString(this.state);
            parcel.writeString(this.jiA);
            parcel.writeByteArray(this.fDD);
            parcel.writeInt(this.jiC);
            if (!this.fDE) {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            parcel.writeString(this.jiB);
            parcel.writeString(this.processName);
        }
    }

    public static final class a extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 296;
        private static final String NAME = "onRecorderStateChange";
    }

    static /* synthetic */ void a(JsApiOperateRecorder jsApiOperateRecorder, final boolean z) {
        if (!ah.isMainThread()) {
            ah.y(new Runnable() {
                public final void run() {
                    JsApiOperateRecorder.a(JsApiOperateRecorder.this, z);
                }
            });
        } else if (jsApiOperateRecorder.jiu != null && jsApiOperateRecorder.jiu.iuk != null) {
            if (z) {
                jsApiOperateRecorder.jiv = com.tencent.mm.plugin.appbrand.page.a.q(jsApiOperateRecorder.jiu.iuk).a(com.tencent.mm.plugin.appbrand.page.a.a.VOICE);
            } else {
                com.tencent.mm.plugin.appbrand.page.a.q(jsApiOperateRecorder.jiu.iuk).ls(jsApiOperateRecorder.jiv);
            }
        }
    }

    public final void a(final j jVar, final JSONObject jSONObject, final int i) {
        boolean z;
        com.tencent.mm.plugin.appbrand.a.a(jVar.mAppId, new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                if (i == 116) {
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        x.e("MicroMsg.JsApiOperateRecorder", "operateRecorder, SYS_PERM_DENIED");
                        jVar.E(i, JsApiOperateRecorder.this.e("fail:system permission denied", null));
                        return;
                    }
                    x.i("MicroMsg.JsApiOperateRecorder", "PERMISSION_GRANTED, do invoke again");
                    JsApiOperateRecorder.this.a(jVar, jSONObject, i);
                }
            }
        });
        Activity a = a(jVar);
        if (a == null) {
            x.e("MicroMsg.JsApiOperateRecorder", "operateRecorder, pageContext is null");
            jVar.E(i, e("fail", null));
            z = false;
        } else {
            z = com.tencent.mm.pluginsdk.g.a.a(a, "android.permission.RECORD_AUDIO", 116, "", "");
            if (z) {
                com.tencent.mm.plugin.appbrand.a.pj(jVar.mAppId);
            }
        }
        if (z) {
            this.jiu = com.tencent.mm.plugin.appbrand.jsapi.e.b(jVar);
            if (this.jiu == null) {
                jVar.E(i, e("fail", null));
                return;
            } else if (jSONObject == null) {
                x.e("MicroMsg.JsApiOperateRecorder", "operateRecorder, data is null");
                jVar.E(i, e("fail:data is null", null));
                return;
            } else {
                final String str = jVar.mAppId;
                x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", str, jSONObject.toString());
                if (this.jit == null) {
                    this.jit = new OperateRecordTask(this, jVar, i);
                }
                this.jit.jgb = i;
                this.jit.appId = str;
                this.jit.jiz = jSONObject.toString();
                this.jit.processName = ad.By();
                if (this.jij == null) {
                    this.jij = new b() {
                        public final void a(com.tencent.mm.plugin.appbrand.c.c cVar) {
                            x.i("MicroMsg.JsApiOperateRecorder", "onPause, appId:%s", str);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "pause");
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e, "", new Object[0]);
                            }
                            if (JsApiOperateRecorder.this.jit == null) {
                                JsApiOperateRecorder.this.jit = new OperateRecordTask(JsApiOperateRecorder.this, jVar, i);
                            }
                            JsApiOperateRecorder.this.jit.jiz = jSONObject.toString();
                            JsApiOperateRecorder.this.jit.appId = str;
                            JsApiOperateRecorder.this.jit.action = -1;
                            AppBrandMainProcessService.a(JsApiOperateRecorder.this.jit);
                        }

                        public final void onDestroy() {
                            x.i("MicroMsg.JsApiOperateRecorder", "onDestroy, appId:%s", str);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "stop");
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e, "", new Object[0]);
                            }
                            if (JsApiOperateRecorder.this.jit == null) {
                                JsApiOperateRecorder.this.jit = new OperateRecordTask(JsApiOperateRecorder.this, jVar, i);
                            }
                            JsApiOperateRecorder.this.jit.jiz = jSONObject.toString();
                            JsApiOperateRecorder.this.jit.appId = str;
                            JsApiOperateRecorder.this.jit.action = -1;
                            AppBrandMainProcessService.b(JsApiOperateRecorder.this.jit);
                            com.tencent.mm.plugin.appbrand.c.b(str, this);
                            JsApiOperateRecorder.jhJ.remove(str);
                        }
                    };
                }
                this.jit.jij = this.jij;
                AppBrandMainProcessService.a(this.jit);
                return;
            }
        }
        x.e("MicroMsg.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
        jVar.E(i, e("fail:system permission denied", null));
    }
}
