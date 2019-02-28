package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.os.AsyncTask;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.xwalk.core.R;

public final class b extends AsyncTask<String, Void, String> {
    private static Set<String> rtP = Collections.synchronizedSet(new HashSet());
    private String filePath;
    private boolean rrW;
    private int rrX;
    private a rtQ;
    private int scene;

    public interface a {
        void bxM();

        void bxN();

        void byw();
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return z((String[]) objArr);
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        if (((String) obj) == null) {
            this.rtQ.byw();
        } else {
            this.rtQ.bxN();
        }
    }

    public b(String str, boolean z, int i, int i2, a aVar) {
        this.filePath = str;
        this.rrW = z;
        this.rrX = i;
        this.scene = i2;
        this.rtQ = aVar;
    }

    private String z(String... strArr) {
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        Exception e;
        int i;
        Throwable th;
        if (FileOp.bO(this.filePath)) {
            return null;
        }
        if (rtP.contains(strArr[0])) {
            return "downloading";
        }
        long Wy = bi.Wy();
        int i2 = 0;
        rtP.add(strArr[0]);
        FileOp.ml(this.filePath.substring(0, this.filePath.lastIndexOf("/")));
        InputStream inputStream2 = null;
        OutputStream outputStream2 = null;
        this.rtQ.bxM();
        HttpURLConnection httpURLConnection2;
        int responseCode;
        String str;
        String VF;
        int bwS;
        int bA;
        d dVar;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(strArr[0]).openConnection();
            try {
                httpURLConnection2.connect();
                responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 200) {
                    try {
                        this.rtQ.bxN();
                        str = "Server returned HTTP " + httpURLConnection2.getResponseCode() + " " + httpURLConnection2.getResponseMessage();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        rtP.remove(strArr[0]);
                        VF = ac.VF(strArr[0]);
                        bwS = bwS();
                        bA = (int) bi.bA(Wy);
                        dVar = new d();
                        dVar.q("20UrlMd5", VF + ",");
                        dVar.q("21MediaType", bwS + ",");
                        dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                        dVar.q("23CostTime", bA + ",");
                        dVar.q("24RetCode", responseCode + ",");
                        dVar.q("25Scene", this.scene + ",");
                        dVar.q("26Size", new StringBuilder("0,").toString());
                        dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                        x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                        g.pWK.h(13572, dVar);
                        return str;
                    } catch (Exception e2) {
                        inputStream = null;
                        outputStream = null;
                        httpURLConnection = httpURLConnection2;
                        e = e2;
                        i = responseCode;
                    } catch (Throwable th2) {
                        th = th2;
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e3) {
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                rtP.remove(strArr[0]);
                                VF = ac.VF(strArr[0]);
                                bwS = bwS();
                                bA = (int) bi.bA(Wy);
                                dVar = new d();
                                dVar.q("20UrlMd5", VF + ",");
                                dVar.q("21MediaType", bwS + ",");
                                dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                                dVar.q("23CostTime", bA + ",");
                                dVar.q("24RetCode", responseCode + ",");
                                dVar.q("25Scene", this.scene + ",");
                                dVar.q("26Size", i2 + ",");
                                dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                                x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                                g.pWK.h(13572, dVar);
                                throw th;
                            }
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        rtP.remove(strArr[0]);
                        VF = ac.VF(strArr[0]);
                        bwS = bwS();
                        bA = (int) bi.bA(Wy);
                        dVar = new d();
                        dVar.q("20UrlMd5", VF + ",");
                        dVar.q("21MediaType", bwS + ",");
                        if (this.rrW) {
                        }
                        dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                        dVar.q("23CostTime", bA + ",");
                        dVar.q("24RetCode", responseCode + ",");
                        dVar.q("25Scene", this.scene + ",");
                        dVar.q("26Size", i2 + ",");
                        dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                        x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                        g.pWK.h(13572, dVar);
                        throw th;
                    }
                }
                httpURLConnection2.getContentLength();
                inputStream = httpURLConnection2.getInputStream();
                try {
                    outputStream = new FileOutputStream(this.filePath);
                } catch (Exception e22) {
                    outputStream = null;
                    httpURLConnection = httpURLConnection2;
                    e = e22;
                    i = responseCode;
                    try {
                        this.rtQ.bxN();
                        FileOp.deleteFile(this.filePath);
                        responseCode = -1;
                        try {
                            str = e.toString();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e4) {
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    rtP.remove(strArr[0]);
                                    VF = ac.VF(strArr[0]);
                                    bwS = bwS();
                                    bA = (int) bi.bA(Wy);
                                    dVar = new d();
                                    dVar.q("20UrlMd5", VF + ",");
                                    dVar.q("21MediaType", bwS + ",");
                                    dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                                    dVar.q("23CostTime", bA + ",");
                                    dVar.q("24RetCode", new StringBuilder("-1,").toString());
                                    dVar.q("25Scene", this.scene + ",");
                                    dVar.q("26Size", i2 + ",");
                                    dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                                    g.pWK.h(13572, dVar);
                                    return str;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            rtP.remove(strArr[0]);
                            VF = ac.VF(strArr[0]);
                            bwS = bwS();
                            bA = (int) bi.bA(Wy);
                            dVar = new d();
                            dVar.q("20UrlMd5", VF + ",");
                            dVar.q("21MediaType", bwS + ",");
                            if (this.rrW) {
                            }
                            dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                            dVar.q("23CostTime", bA + ",");
                            dVar.q("24RetCode", new StringBuilder("-1,").toString());
                            dVar.q("25Scene", this.scene + ",");
                            dVar.q("26Size", i2 + ",");
                            dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                            x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                            g.pWK.h(13572, dVar);
                            return str;
                        } catch (Throwable th3) {
                            th = th3;
                            httpURLConnection2 = httpURLConnection;
                            outputStream2 = outputStream;
                            inputStream2 = inputStream;
                        }
                    } catch (Throwable th32) {
                        responseCode = i;
                        th = th32;
                        httpURLConnection2 = httpURLConnection;
                        outputStream2 = outputStream;
                        inputStream2 = inputStream;
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        rtP.remove(strArr[0]);
                        VF = ac.VF(strArr[0]);
                        bwS = bwS();
                        bA = (int) bi.bA(Wy);
                        dVar = new d();
                        dVar.q("20UrlMd5", VF + ",");
                        dVar.q("21MediaType", bwS + ",");
                        if (this.rrW) {
                        }
                        dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                        dVar.q("23CostTime", bA + ",");
                        dVar.q("24RetCode", responseCode + ",");
                        dVar.q("25Scene", this.scene + ",");
                        dVar.q("26Size", i2 + ",");
                        dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                        x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                        g.pWK.h(13572, dVar);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream2 = inputStream;
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    rtP.remove(strArr[0]);
                    VF = ac.VF(strArr[0]);
                    bwS = bwS();
                    bA = (int) bi.bA(Wy);
                    dVar = new d();
                    dVar.q("20UrlMd5", VF + ",");
                    dVar.q("21MediaType", bwS + ",");
                    if (this.rrW) {
                    }
                    dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                    dVar.q("23CostTime", bA + ",");
                    dVar.q("24RetCode", responseCode + ",");
                    dVar.q("25Scene", this.scene + ",");
                    dVar.q("26Size", i2 + ",");
                    dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                    g.pWK.h(13572, dVar);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                    bwS = 0;
                    while (true) {
                        try {
                            i2 = inputStream.read(bArr);
                            if (i2 == -1) {
                                try {
                                    outputStream.close();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (IOException e5) {
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                rtP.remove(strArr[0]);
                                VF = ac.VF(strArr[0]);
                                i = bwS();
                                bA = (int) bi.bA(Wy);
                                dVar = new d();
                                dVar.q("20UrlMd5", VF + ",");
                                dVar.q("21MediaType", i + ",");
                                dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                                dVar.q("23CostTime", bA + ",");
                                dVar.q("24RetCode", responseCode + ",");
                                dVar.q("25Scene", this.scene + ",");
                                dVar.q("26Size", bwS + ",");
                                dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                                x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                                g.pWK.h(13572, dVar);
                                return null;
                            } else if (isCancelled()) {
                                inputStream.close();
                                try {
                                    outputStream.close();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (IOException e6) {
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                rtP.remove(strArr[0]);
                                VF = ac.VF(strArr[0]);
                                i = bwS();
                                bA = (int) bi.bA(Wy);
                                dVar = new d();
                                dVar.q("20UrlMd5", VF + ",");
                                dVar.q("21MediaType", i + ",");
                                dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                                dVar.q("23CostTime", bA + ",");
                                dVar.q("24RetCode", responseCode + ",");
                                dVar.q("25Scene", this.scene + ",");
                                dVar.q("26Size", bwS + ",");
                                dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                                x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                                g.pWK.h(13572, dVar);
                                return null;
                            } else {
                                outputStream.write(bArr, 0, i2);
                                bwS += i2;
                            }
                        } catch (Exception e222) {
                            i2 = bwS;
                            httpURLConnection = httpURLConnection2;
                            e = e222;
                            i = responseCode;
                        } catch (Throwable th5) {
                            th = th5;
                            i2 = bwS;
                            outputStream2 = outputStream;
                            inputStream2 = inputStream;
                        }
                    }
                } catch (Exception e2222) {
                    httpURLConnection = httpURLConnection2;
                    e = e2222;
                    i = responseCode;
                    this.rtQ.bxN();
                    FileOp.deleteFile(this.filePath);
                    responseCode = -1;
                    str = e.toString();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    rtP.remove(strArr[0]);
                    VF = ac.VF(strArr[0]);
                    bwS = bwS();
                    bA = (int) bi.bA(Wy);
                    dVar = new d();
                    dVar.q("20UrlMd5", VF + ",");
                    dVar.q("21MediaType", bwS + ",");
                    if (this.rrW) {
                    }
                    dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                    dVar.q("23CostTime", bA + ",");
                    dVar.q("24RetCode", new StringBuilder("-1,").toString());
                    dVar.q("25Scene", this.scene + ",");
                    dVar.q("26Size", i2 + ",");
                    dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                    g.pWK.h(13572, dVar);
                    return str;
                } catch (Throwable th6) {
                    th = th6;
                    outputStream2 = outputStream;
                    inputStream2 = inputStream;
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    rtP.remove(strArr[0]);
                    VF = ac.VF(strArr[0]);
                    bwS = bwS();
                    bA = (int) bi.bA(Wy);
                    dVar = new d();
                    dVar.q("20UrlMd5", VF + ",");
                    dVar.q("21MediaType", bwS + ",");
                    if (this.rrW) {
                    }
                    dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                    dVar.q("23CostTime", bA + ",");
                    dVar.q("24RetCode", responseCode + ",");
                    dVar.q("25Scene", this.scene + ",");
                    dVar.q("26Size", i2 + ",");
                    dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                    x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                    g.pWK.h(13572, dVar);
                    throw th;
                }
            } catch (Exception e22222) {
                Exception exception = e22222;
                i = 0;
                inputStream = null;
                outputStream = null;
                httpURLConnection = httpURLConnection2;
                e = exception;
                this.rtQ.bxN();
                FileOp.deleteFile(this.filePath);
                responseCode = -1;
                str = e.toString();
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                rtP.remove(strArr[0]);
                VF = ac.VF(strArr[0]);
                bwS = bwS();
                bA = (int) bi.bA(Wy);
                dVar = new d();
                dVar.q("20UrlMd5", VF + ",");
                dVar.q("21MediaType", bwS + ",");
                if (this.rrW) {
                }
                dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                dVar.q("23CostTime", bA + ",");
                dVar.q("24RetCode", new StringBuilder("-1,").toString());
                dVar.q("25Scene", this.scene + ",");
                dVar.q("26Size", i2 + ",");
                dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                g.pWK.h(13572, dVar);
                return str;
            } catch (Throwable th7) {
                th = th7;
                responseCode = 0;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                rtP.remove(strArr[0]);
                VF = ac.VF(strArr[0]);
                bwS = bwS();
                bA = (int) bi.bA(Wy);
                dVar = new d();
                dVar.q("20UrlMd5", VF + ",");
                dVar.q("21MediaType", bwS + ",");
                if (this.rrW) {
                }
                dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
                dVar.q("23CostTime", bA + ",");
                dVar.q("24RetCode", responseCode + ",");
                dVar.q("25Scene", this.scene + ",");
                dVar.q("26Size", i2 + ",");
                dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
                x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
                g.pWK.h(13572, dVar);
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            i = 0;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
            this.rtQ.bxN();
            FileOp.deleteFile(this.filePath);
            responseCode = -1;
            str = e.toString();
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            rtP.remove(strArr[0]);
            VF = ac.VF(strArr[0]);
            bwS = bwS();
            bA = (int) bi.bA(Wy);
            dVar = new d();
            dVar.q("20UrlMd5", VF + ",");
            dVar.q("21MediaType", bwS + ",");
            if (this.rrW) {
            }
            dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
            dVar.q("23CostTime", bA + ",");
            dVar.q("24RetCode", new StringBuilder("-1,").toString());
            dVar.q("25Scene", this.scene + ",");
            dVar.q("26Size", i2 + ",");
            dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
            x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
            g.pWK.h(13572, dVar);
            return str;
        } catch (Throwable th322) {
            responseCode = 0;
            th = th322;
            httpURLConnection2 = null;
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            rtP.remove(strArr[0]);
            VF = ac.VF(strArr[0]);
            bwS = bwS();
            bA = (int) bi.bA(Wy);
            dVar = new d();
            dVar.q("20UrlMd5", VF + ",");
            dVar.q("21MediaType", bwS + ",");
            if (this.rrW) {
            }
            dVar.q("22IsPreload", (this.rrW ? 1 : 0) + ",");
            dVar.q("23CostTime", bA + ",");
            dVar.q("24RetCode", responseCode + ",");
            dVar.q("25Scene", this.scene + ",");
            dVar.q("26Size", i2 + ",");
            dVar.q("27StartDownloadTime", (Wy / 1000) + ",");
            x.i("MicroMsg.AdLandingPageDownloadFileTask", "report logbuffer MM_KVSTAT_AdDownload(13572): " + dVar.SG());
            g.pWK.h(13572, dVar);
            throw th;
        }
    }

    private int bwS() {
        switch (this.rrX) {
            case 41:
            case R.styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
            case R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
            case 1000000001:
                return 1;
            case 61:
                return 2;
            case 62:
                return 3;
            default:
                return 0;
        }
    }
}
