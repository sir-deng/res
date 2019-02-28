package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.f;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.b.AnonymousClass3;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.InputStream;
import java.io.OutputStream;

public final class d extends b {
    private long rfg = 0;
    private int rfh = 0;

    public d(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String Lp(String str) {
        return str;
    }

    public final boolean bwQ() {
        return false;
    }

    public final u b(u uVar) {
        this.rfg = 0;
        if (this.rfg > 0) {
            x.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.rfg);
            uVar.setRequestProperty("RANGE", "bytes=" + this.rfg + "-");
        }
        return uVar;
    }

    public final boolean p(InputStream inputStream) {
        OutputStream outputStream = null;
        try {
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            String str = this.reJ.getPath() + this.reJ.bwP();
            x.i("MicroMsg.SnsDownloadAdSight", "getdatabegin " + FileOp.mi(f.mq(str)));
            outputStream = FileOp.mf(str);
            long currentTimeMillis = System.currentTimeMillis();
            this.reU.value = "";
            int i = 1;
            Object obj = null;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    if (this.reX == 0) {
                        this.reX = bi.bA(this.reY);
                    }
                    if (read > this.reV) {
                        this.reV = read;
                        this.reW = bi.Wx();
                    }
                    if (i.Ku(ae.FJ())) {
                        outputStream.write(bArr, 0, read);
                        this.rfd += read;
                        if (this.rfd - this.rfh > Downloads.SPLIT_RANGE_SIZE_WAP * i) {
                            ae.aOA().post(new AnonymousClass3(this.reJ.mediaId, str));
                            this.rfh = this.rfd;
                            i++;
                        }
                        obj = 1;
                        if (b.a(this.rfd, currentTimeMillis, this.reU)) {
                            currentTimeMillis = System.currentTimeMillis();
                            obj = null;
                        }
                    } else {
                        x.i("MicroMsg.SnsDownloadAdSight", "read data");
                        outputStream.close();
                        inputStream.close();
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e, "", new Object[0]);
                            }
                        }
                        return false;
                    }
                }
                outputStream.close();
                if (obj != null) {
                    b.a(this.rfd, 0, this.reU);
                }
                x.i("MicroMsg.SnsDownloadAdSight", "getdataend2  " + FileOp.mi(this.reJ.getPath() + this.reJ.bwP()));
                return true;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e2, "snscdndownload fail : " + e2.getMessage(), new Object[0]);
            x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e2, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e22, "", new Object[0]);
                }
            }
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e3, "", new Object[0]);
                }
            }
        }
    }

    public final boolean bwR() {
        long mi = FileOp.mi(this.reJ.getPath() + this.reJ.bwP());
        x.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + mi + " " + this.rfa);
        if (mi < ((long) this.rfa) + this.rfg) {
            return false;
        }
        FileOp.g(this.reJ.getPath(), this.reJ.bwP(), i.k(this.fIx));
        return true;
    }

    protected final int bwS() {
        return 4;
    }
}
