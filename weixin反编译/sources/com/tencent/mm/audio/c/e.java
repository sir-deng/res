package com.tencent.mm.audio.c;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class e implements a {
    boolean fnd = false;
    BlockingQueue<com.tencent.mm.audio.b.g.a> fnf = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    String fnh;
    private com.tencent.qqpinyin.voicerecoapi.a fnr;
    private a fns;
    private FileOutputStream mFileOutputStream;

    private final class a implements Runnable {
        final /* synthetic */ e fnt;

        public final void run() {
            while (true) {
                boolean z;
                synchronized (this.fnt) {
                    z = this.fnt.fnd;
                }
                x.d("MicroMsg.SpeexWriter", "ThreadSpeex in: " + z + " queueLen: " + this.fnt.fnf.size());
                if (!z || !this.fnt.fnf.isEmpty()) {
                    try {
                        com.tencent.mm.audio.b.g.a aVar = (com.tencent.mm.audio.b.g.a) this.fnt.fnf.poll(200, TimeUnit.MILLISECONDS);
                        if (aVar == null) {
                            x.e("MicroMsg.SpeexWriter", "poll byteBuf is null, " + this.fnt.fnh);
                        } else {
                            this.fnt.a(aVar, 0, false);
                        }
                    } catch (InterruptedException e) {
                        x.i("MicroMsg.SpeexWriter", "ThreadSpeex poll null");
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final boolean cL(String str) {
        x.i("MicroMsg.SpeexWriter", "initWriter, path: " + str);
        if (str == null) {
            return false;
        }
        this.fnh = str;
        try {
            this.mFileOutputStream = new FileOutputStream(new File(str));
            this.fnr = new com.tencent.qqpinyin.voicerecoapi.a();
            int cDS = this.fnr.cDS();
            if (cDS == 0) {
                return true;
            }
            x.e("MicroMsg.SpeexWriter", "speexInit failed: " + cDS);
            return false;
        } catch (Exception e) {
            if (this.mFileOutputStream != null) {
                try {
                    this.mFileOutputStream.close();
                } catch (IOException e2) {
                }
            }
            x.e("MicroMsg.SpeexWriter", "Error on init file: ", e);
            return false;
        }
    }

    public final int a(com.tencent.mm.audio.b.g.a aVar, int i) {
        return a(aVar, 0, false);
    }

    public final int a(com.tencent.mm.audio.b.g.a aVar, int i, boolean z) {
        if (this.fnr == null || aVar.buf == null || aVar.flJ == 0) {
            x.e("MicroMsg.SpeexWriter", "try write invalid data to file");
            return -1;
        }
        try {
            byte[] S = this.fnr.S(aVar.buf, aVar.flJ);
            if (S == null || S.length <= 0) {
                x.e("MicroMsg.SpeexWriter", "convert failed: " + (S == null ? "outBuffer is null" : "size is zero"));
                return -1;
            }
            x.d("MicroMsg.SpeexWriter", "write to file, len: %d", Integer.valueOf(S.length));
            this.mFileOutputStream.write(S);
            this.mFileOutputStream.flush();
            return S.length;
        } catch (Exception e) {
            x.e("MicroMsg.SpeexWriter", "write to file failed", e);
            return -1;
        }
    }

    public final void vK() {
        x.i("MicroMsg.SpeexWriter", "wait Stop");
        synchronized (this) {
            this.fnd = true;
        }
        if (this.fns != null) {
            try {
                com.tencent.mm.sdk.f.e.S(this.fns);
                this.fns = null;
            } catch (InterruptedException e) {
                x.e("MicroMsg.SpeexWriter", "thread speex interrupted");
            }
        }
        if (this.fnr != null) {
            this.fnr.cDT();
            this.fnr = null;
        }
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Exception e2) {
                x.e("MicroMsg.SpeexWriter", "close silk file: " + this.fnh + "msg: " + e2.getMessage());
            }
            this.mFileOutputStream = null;
        }
    }

    public final boolean vL() {
        if (this.fnr != null) {
            this.fnr.cDT();
            this.fnr = null;
        }
        this.fnr = new com.tencent.qqpinyin.voicerecoapi.a();
        int cDS = this.fnr.cDS();
        if (cDS == 0) {
            return true;
        }
        x.e("MicroMsg.SpeexWriter", "resetWriter speexInit failed: " + cDS);
        return false;
    }

    public static boolean B(String str, String str2) {
        FileInputStream fileInputStream;
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            x.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + file.length());
            try {
                com.tencent.qqpinyin.voicerecoapi.a aVar = new com.tencent.qqpinyin.voicerecoapi.a();
                if (aVar.cDS() != 0) {
                    x.e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
                    aVar.cDT();
                    return false;
                }
                b.deleteFile(str2);
                File file2 = new File(str2);
                file2.createNewFile();
                file2.setReadable(true);
                try {
                    byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read > 0) {
                            byte[] S = aVar.S(bArr, read);
                            if (S == null) {
                                fileInputStream2.close();
                                return false;
                            }
                            try {
                                x.i("MicroMsg.SpeexWriter", "[voiceControl] appendToFile " + com.tencent.mm.a.e.d(str2, S) + ", readLen = " + read);
                            } catch (Exception e) {
                                fileInputStream = fileInputStream2;
                            }
                        } else {
                            fileInputStream2.close();
                            aVar.cDT();
                            x.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex = " + (System.currentTimeMillis() - currentTimeMillis));
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    aVar.cDT();
                    return false;
                }
            } catch (Exception e3) {
                x.e("MicroMsg.SpeexWriter", "[voiceControl] Exception in decodePCMToSpeex, " + e3.getMessage());
                return false;
            }
        }
        x.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
        return false;
    }
}
