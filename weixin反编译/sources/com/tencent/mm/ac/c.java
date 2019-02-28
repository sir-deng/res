package com.tencent.mm.ac;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.a.f;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class c implements e {
    boolean hmq = false;
    Set<String> hmr = new HashSet();
    f<String, c> hms = new f(400);
    Stack<h> hmt = new Stack();
    private at hmu = null;
    private at hmv = null;
    String hmw = null;
    f<String, String> hmx = new f(200);
    al hmy = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        private long hmA = 0;

        public final boolean uG() {
            long currentTimeMillis = System.currentTimeMillis();
            if (c.this.hmq && currentTimeMillis - this.hmA > 60000) {
                x.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", Long.valueOf(currentTimeMillis - this.hmA));
                c.this.hmq = false;
            }
            if (c.this.hmq) {
                c.this.hmy.K(1000, 1000);
                return false;
            }
            this.hmA = currentTimeMillis;
            c.this.hmq = true;
            LinkedList linkedList = new LinkedList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 5 || c.this.hmt.size() <= 0) {
                    g.CN().a(new j(linkedList), 0);
                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 44, 1, true);
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 42, 1, true);
                    linkedList.add(new bet().Vf(((h) c.this.hmt.pop()).getUsername()));
                    i = i2 + 1;
                }
            }
            g.CN().a(new j(linkedList), 0);
            com.tencent.mm.plugin.report.service.g.pWK.a(138, 44, 1, true);
            return false;
        }
    }, false);

    private static class c {
        public long hjl;
        public int hmE;

        private c() {
            this.hjl = 0;
            this.hmE = 0;
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    private class a implements com.tencent.mm.sdk.platformtools.at.a {
        public h hmB = null;
        public byte[] hmC = null;

        public a(h hVar) {
            this.hmB = hVar;
        }

        public final boolean JH() {
            u uVar;
            ByteArrayOutputStream byteArrayOutputStream;
            InputStream inputStream;
            ProtocolException protocolException;
            com.tencent.mm.plugin.report.service.g gVar;
            Object[] objArr;
            SocketTimeoutException socketTimeoutException;
            IOException iOException;
            Exception exception;
            if (this.hmB == null) {
                return false;
            }
            if (!ao.isNetworkConnected(ad.getContext())) {
                x.w("MicroMsg.HttpGetAvatar", "[tomys] network is unavailable, skip rest loading logic.");
                x.cfX();
            }
            String JN = this.hmB.JN();
            String str = "";
            if (g.Do().CF()) {
                r1 = new Object[4];
                g.Do();
                r1[1] = o.getString(com.tencent.mm.kernel.a.Cn());
                r1[2] = Integer.valueOf(ao.getNetTypeForStat(ad.getContext()));
                r1[3] = Integer.valueOf(ao.getStrength(ad.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r1);
            }
            x.d("MicroMsg.HttpGetAvatar", "dkreferer dkavatar user: %s referer: %s", this.hmB.getUsername(), str);
            this.hmC = null;
            u uVar2 = null;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            InputStream inputStream2 = null;
            com.tencent.mm.plugin.report.service.g.pWK.a(138, 40, 1, true);
            try {
                uVar2 = com.tencent.mm.network.b.a(JN, null);
                try {
                    uVar2.setRequestMethod("GET");
                    uVar2.setRequestProperty("referer", str);
                    uVar2.setConnectTimeout(5000);
                    uVar2.setReadTimeout(5000);
                    if (com.tencent.mm.network.b.a(uVar2) != 0) {
                        int responseCode = uVar2.getResponseCode();
                        Map headerFields = uVar2.getHeaderFields();
                        List list = headerFields != null ? (List) headerFields.get("X-ErrNo") : null;
                        str = (list == null || list.size() <= 0) ? "" : (String) list.get(0);
                        x.e("MicroMsg.HttpGetAvatar", "checkHttpConnection failed! url:%s code:%d xErr:%s", JN, Integer.valueOf(responseCode), str);
                        switch (responseCode) {
                            case TencentLocation.ERROR_UNKNOWN /*404*/:
                                com.tencent.mm.plugin.report.service.g.pWK.a(138, 2, 1, true);
                                com.tencent.mm.plugin.report.service.g.pWK.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hmB.getUsername(), uVar2.icj, Integer.valueOf(uVar2.ibm), uVar2.url.getHost(), JN, str);
                                break;
                            case 502:
                                com.tencent.mm.plugin.report.service.g.pWK.a(138, 3, 1, true);
                                com.tencent.mm.plugin.report.service.g.pWK.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hmB.getUsername(), uVar2.icj, Integer.valueOf(uVar2.ibm), uVar2.url.getHost(), JN, str);
                                break;
                            case 503:
                                com.tencent.mm.plugin.report.service.g.pWK.a(138, 4, 1, true);
                                com.tencent.mm.plugin.report.service.g.pWK.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hmB.getUsername(), uVar2.icj, Integer.valueOf(uVar2.ibm), uVar2.url.getHost(), JN, str);
                                break;
                            case 504:
                                com.tencent.mm.plugin.report.service.g.pWK.a(138, 5, 1, true);
                                com.tencent.mm.plugin.report.service.g.pWK.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hmB.getUsername(), uVar2.icj, Integer.valueOf(uVar2.ibm), uVar2.url.getHost(), JN, str);
                                break;
                            default:
                                com.tencent.mm.plugin.report.service.g.pWK.a(138, 6, 1, true);
                                com.tencent.mm.plugin.report.service.g.pWK.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.hmB.getUsername(), uVar2.icj, Integer.valueOf(uVar2.ibm), uVar2.url.getHost(), JN, str);
                                break;
                        }
                        return true;
                    }
                    int contentLength = uVar2.aBw.getContentLength();
                    inputStream2 = uVar2.getInputStream();
                    if (inputStream2 == null) {
                        try {
                            x.d("MicroMsg.HttpGetAvatar", "getInputStream failed. url:%s", JN);
                            return true;
                        } catch (ProtocolException e) {
                            uVar = uVar2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            protocolException = e;
                            com.tencent.mm.plugin.report.service.g.pWK.a(138, 1, 1, true);
                            gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10001);
                            objArr[2] = protocolException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hmB.getUsername();
                            if (uVar != null) {
                                str = "null";
                            } else {
                                str = uVar.icj;
                            }
                            objArr[5] = str;
                            objArr[6] = uVar != null ? "null" : Integer.valueOf(uVar.ibm);
                            objArr[7] = uVar != null ? "null" : uVar.url.getHost();
                            objArr[8] = JN;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                            if (uVar != null) {
                                try {
                                    uVar.aBw.disconnect();
                                } catch (Throwable e2) {
                                    x.e("MicroMsg.HttpGetAvatar", "exception:%s", bi.i(e2));
                                    x.e("MicroMsg.HttpGetAvatar", "close conn failed : %s", e2.getMessage());
                                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 9, 1, true);
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (SocketTimeoutException e3) {
                            uVar = uVar2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            socketTimeoutException = e3;
                            com.tencent.mm.plugin.report.service.g.pWK.a(138, 8, 1, true);
                            gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10002);
                            objArr[2] = socketTimeoutException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hmB.getUsername();
                            if (uVar != null) {
                                str = uVar.icj;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            objArr[6] = uVar != null ? Integer.valueOf(uVar.ibm) : "null";
                            objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                            objArr[8] = JN;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (IOException e4) {
                            uVar = uVar2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            iOException = e4;
                            com.tencent.mm.plugin.report.service.g.pWK.a(138, 7, 1, true);
                            gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10003);
                            objArr[2] = iOException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hmB.getUsername();
                            if (uVar != null) {
                                str = uVar.icj;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            objArr[6] = uVar != null ? Integer.valueOf(uVar.ibm) : "null";
                            objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                            objArr[8] = JN;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, iOException.getClass().getSimpleName(), iOException.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (Exception e5) {
                            uVar = uVar2;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            inputStream = inputStream2;
                            exception = e5;
                            com.tencent.mm.plugin.report.service.g.pWK.a(138, 0, 1, true);
                            gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10003);
                            objArr[2] = exception.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hmB.getUsername();
                            if (uVar != null) {
                                str = uVar.icj;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            if (uVar != null) {
                                str = Integer.valueOf(uVar.ibm);
                            } else {
                                str = "null";
                            }
                            objArr[6] = str;
                            if (uVar != null) {
                                str = uVar.url.getHost();
                            } else {
                                str = "null";
                            }
                            objArr[7] = str;
                            objArr[8] = JN;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, exception.getClass().getSimpleName(), exception.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        }
                    }
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 41, 1, true);
                    if (com.tencent.mm.sdk.a.b.cfx()) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(14058, Integer.valueOf(100001), Integer.valueOf(HardCoderJNI.sHCENCODEVIDEOTIMEOUT), "", Integer.valueOf(contentLength), this.hmB.getUsername(), uVar2.icj, Integer.valueOf(uVar2.ibm), uVar2.url.getHost(), JN, "");
                    }
                    this.hmC = byteArrayOutputStream2.toByteArray();
                    byteArrayOutputStream2.close();
                    try {
                        uVar2.aBw.disconnect();
                        try {
                            inputStream2.close();
                            if (contentLength > 0) {
                                try {
                                    if (this.hmC.length < contentLength) {
                                        com.tencent.mm.plugin.report.service.g.pWK.a(138, 15, 1, true);
                                        x.e("MicroMsg.HttpGetAvatar", "HTTP downloaded length is smaller than Content-Length field. Drop.");
                                    }
                                } catch (ProtocolException e6) {
                                    uVar = null;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                    protocolException = e6;
                                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 1, 1, true);
                                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                    objArr = new Object[10];
                                    objArr[0] = Integer.valueOf(100001);
                                    objArr[1] = Integer.valueOf(10001);
                                    objArr[2] = protocolException.getMessage();
                                    objArr[3] = Integer.valueOf(0);
                                    objArr[4] = this.hmB.getUsername();
                                    if (uVar != null) {
                                        str = uVar.icj;
                                    } else {
                                        str = "null";
                                    }
                                    objArr[5] = str;
                                    if (uVar != null) {
                                    }
                                    objArr[6] = uVar != null ? "null" : Integer.valueOf(uVar.ibm);
                                    if (uVar != null) {
                                    }
                                    objArr[7] = uVar != null ? "null" : uVar.url.getHost();
                                    objArr[8] = JN;
                                    objArr[9] = "";
                                    gVar.h(14058, objArr);
                                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                                    if (uVar != null) {
                                        uVar.aBw.disconnect();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    return true;
                                } catch (SocketTimeoutException e32) {
                                    uVar = null;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                    socketTimeoutException = e32;
                                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 8, 1, true);
                                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                    objArr = new Object[10];
                                    objArr[0] = Integer.valueOf(100001);
                                    objArr[1] = Integer.valueOf(10002);
                                    objArr[2] = socketTimeoutException.getMessage();
                                    objArr[3] = Integer.valueOf(0);
                                    objArr[4] = this.hmB.getUsername();
                                    if (uVar != null) {
                                        str = "null";
                                    } else {
                                        str = uVar.icj;
                                    }
                                    objArr[5] = str;
                                    if (uVar != null) {
                                    }
                                    objArr[6] = uVar != null ? Integer.valueOf(uVar.ibm) : "null";
                                    if (uVar != null) {
                                    }
                                    objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                                    objArr[8] = JN;
                                    objArr[9] = "";
                                    gVar.h(14058, objArr);
                                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                                    if (uVar != null) {
                                        uVar.aBw.disconnect();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    return true;
                                } catch (IOException e42) {
                                    uVar = null;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                    iOException = e42;
                                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 7, 1, true);
                                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                    objArr = new Object[10];
                                    objArr[0] = Integer.valueOf(100001);
                                    objArr[1] = Integer.valueOf(10003);
                                    objArr[2] = iOException.getMessage();
                                    objArr[3] = Integer.valueOf(0);
                                    objArr[4] = this.hmB.getUsername();
                                    if (uVar != null) {
                                        str = "null";
                                    } else {
                                        str = uVar.icj;
                                    }
                                    objArr[5] = str;
                                    if (uVar != null) {
                                    }
                                    objArr[6] = uVar != null ? Integer.valueOf(uVar.ibm) : "null";
                                    if (uVar != null) {
                                    }
                                    objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                                    objArr[8] = JN;
                                    objArr[9] = "";
                                    gVar.h(14058, objArr);
                                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, iOException.getClass().getSimpleName(), iOException.getMessage());
                                    if (uVar != null) {
                                        uVar.aBw.disconnect();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    return true;
                                } catch (Exception e52) {
                                    uVar = null;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                    exception = e52;
                                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 0, 1, true);
                                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                    objArr = new Object[10];
                                    objArr[0] = Integer.valueOf(100001);
                                    objArr[1] = Integer.valueOf(10003);
                                    objArr[2] = exception.getMessage();
                                    objArr[3] = Integer.valueOf(0);
                                    objArr[4] = this.hmB.getUsername();
                                    if (uVar != null) {
                                        str = "null";
                                    } else {
                                        str = uVar.icj;
                                    }
                                    objArr[5] = str;
                                    if (uVar != null) {
                                        str = "null";
                                    } else {
                                        str = Integer.valueOf(uVar.ibm);
                                    }
                                    objArr[6] = str;
                                    if (uVar != null) {
                                        str = "null";
                                    } else {
                                        str = uVar.url.getHost();
                                    }
                                    objArr[7] = str;
                                    objArr[8] = JN;
                                    objArr[9] = "";
                                    gVar.h(14058, objArr);
                                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, exception.getClass().getSimpleName(), exception.getMessage());
                                    if (uVar != null) {
                                        uVar.aBw.disconnect();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    return true;
                                }
                            }
                            uVar = null;
                            byteArrayOutputStream = null;
                            inputStream = null;
                        } catch (ProtocolException e62) {
                            uVar = null;
                            byteArrayOutputStream = null;
                            inputStream = inputStream2;
                            protocolException = e62;
                            com.tencent.mm.plugin.report.service.g.pWK.a(138, 1, 1, true);
                            gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10001);
                            objArr[2] = protocolException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hmB.getUsername();
                            if (uVar != null) {
                                str = "null";
                            } else {
                                str = uVar.icj;
                            }
                            objArr[5] = str;
                            if (uVar != null) {
                            }
                            objArr[6] = uVar != null ? "null" : Integer.valueOf(uVar.ibm);
                            if (uVar != null) {
                            }
                            objArr[7] = uVar != null ? "null" : uVar.url.getHost();
                            objArr[8] = JN;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (SocketTimeoutException e322) {
                            uVar = null;
                            byteArrayOutputStream = null;
                            inputStream = inputStream2;
                            socketTimeoutException = e322;
                            com.tencent.mm.plugin.report.service.g.pWK.a(138, 8, 1, true);
                            gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10002);
                            objArr[2] = socketTimeoutException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hmB.getUsername();
                            if (uVar != null) {
                                str = uVar.icj;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            if (uVar != null) {
                            }
                            objArr[6] = uVar != null ? Integer.valueOf(uVar.ibm) : "null";
                            if (uVar != null) {
                            }
                            objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                            objArr[8] = JN;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (IOException e422) {
                            uVar = null;
                            byteArrayOutputStream = null;
                            inputStream = inputStream2;
                            iOException = e422;
                            com.tencent.mm.plugin.report.service.g.pWK.a(138, 7, 1, true);
                            gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10003);
                            objArr[2] = iOException.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hmB.getUsername();
                            if (uVar != null) {
                                str = uVar.icj;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            if (uVar != null) {
                            }
                            objArr[6] = uVar != null ? Integer.valueOf(uVar.ibm) : "null";
                            if (uVar != null) {
                            }
                            objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                            objArr[8] = JN;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, iOException.getClass().getSimpleName(), iOException.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        } catch (Exception e522) {
                            uVar = null;
                            byteArrayOutputStream = null;
                            inputStream = inputStream2;
                            exception = e522;
                            com.tencent.mm.plugin.report.service.g.pWK.a(138, 0, 1, true);
                            gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            objArr = new Object[10];
                            objArr[0] = Integer.valueOf(100001);
                            objArr[1] = Integer.valueOf(10003);
                            objArr[2] = exception.getMessage();
                            objArr[3] = Integer.valueOf(0);
                            objArr[4] = this.hmB.getUsername();
                            if (uVar != null) {
                                str = uVar.icj;
                            } else {
                                str = "null";
                            }
                            objArr[5] = str;
                            if (uVar != null) {
                                str = Integer.valueOf(uVar.ibm);
                            } else {
                                str = "null";
                            }
                            objArr[6] = str;
                            if (uVar != null) {
                                str = uVar.url.getHost();
                            } else {
                                str = "null";
                            }
                            objArr[7] = str;
                            objArr[8] = JN;
                            objArr[9] = "";
                            gVar.h(14058, objArr);
                            x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, exception.getClass().getSimpleName(), exception.getMessage());
                            if (uVar != null) {
                                uVar.aBw.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return true;
                        }
                    } catch (ProtocolException e622) {
                        uVar = uVar2;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        protocolException = e622;
                        com.tencent.mm.plugin.report.service.g.pWK.a(138, 1, 1, true);
                        gVar = com.tencent.mm.plugin.report.service.g.pWK;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(10001);
                        objArr[2] = protocolException.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hmB.getUsername();
                        if (uVar != null) {
                            str = uVar.icj;
                        } else {
                            str = "null";
                        }
                        objArr[5] = str;
                        if (uVar != null) {
                        }
                        objArr[6] = uVar != null ? "null" : Integer.valueOf(uVar.ibm);
                        if (uVar != null) {
                        }
                        objArr[7] = uVar != null ? "null" : uVar.url.getHost();
                        objArr[8] = JN;
                        objArr[9] = "";
                        gVar.h(14058, objArr);
                        x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, protocolException.getClass().getSimpleName(), protocolException.getMessage());
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    } catch (SocketTimeoutException e3222) {
                        uVar = uVar2;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        socketTimeoutException = e3222;
                        com.tencent.mm.plugin.report.service.g.pWK.a(138, 8, 1, true);
                        gVar = com.tencent.mm.plugin.report.service.g.pWK;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(10002);
                        objArr[2] = socketTimeoutException.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hmB.getUsername();
                        if (uVar != null) {
                            str = uVar.icj;
                        } else {
                            str = "null";
                        }
                        objArr[5] = str;
                        if (uVar != null) {
                        }
                        objArr[6] = uVar != null ? Integer.valueOf(uVar.ibm) : "null";
                        if (uVar != null) {
                        }
                        objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                        objArr[8] = JN;
                        objArr[9] = "";
                        gVar.h(14058, objArr);
                        x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    } catch (IOException e4222) {
                        uVar = uVar2;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        iOException = e4222;
                        com.tencent.mm.plugin.report.service.g.pWK.a(138, 7, 1, true);
                        gVar = com.tencent.mm.plugin.report.service.g.pWK;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(10003);
                        objArr[2] = iOException.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hmB.getUsername();
                        if (uVar != null) {
                            str = uVar.icj;
                        } else {
                            str = "null";
                        }
                        objArr[5] = str;
                        if (uVar != null) {
                        }
                        objArr[6] = uVar != null ? Integer.valueOf(uVar.ibm) : "null";
                        if (uVar != null) {
                        }
                        objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                        objArr[8] = JN;
                        objArr[9] = "";
                        gVar.h(14058, objArr);
                        x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, iOException.getClass().getSimpleName(), iOException.getMessage());
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    } catch (Exception e5222) {
                        uVar = uVar2;
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        exception = e5222;
                        com.tencent.mm.plugin.report.service.g.pWK.a(138, 0, 1, true);
                        gVar = com.tencent.mm.plugin.report.service.g.pWK;
                        objArr = new Object[10];
                        objArr[0] = Integer.valueOf(100001);
                        objArr[1] = Integer.valueOf(10003);
                        objArr[2] = exception.getMessage();
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = this.hmB.getUsername();
                        if (uVar != null) {
                            str = uVar.icj;
                        } else {
                            str = "null";
                        }
                        objArr[5] = str;
                        if (uVar != null) {
                            str = Integer.valueOf(uVar.ibm);
                        } else {
                            str = "null";
                        }
                        objArr[6] = str;
                        if (uVar != null) {
                            str = uVar.url.getHost();
                        } else {
                            str = "null";
                        }
                        objArr[7] = str;
                        objArr[8] = JN;
                        objArr[9] = "";
                        gVar.h(14058, objArr);
                        x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, exception.getClass().getSimpleName(), exception.getMessage());
                        if (uVar != null) {
                            uVar.aBw.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return true;
                    }
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (ProtocolException e6222) {
                    uVar = uVar2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    protocolException = e6222;
                } catch (SocketTimeoutException e32222) {
                    uVar = uVar2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    socketTimeoutException = e32222;
                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 8, 1, true);
                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr = new Object[10];
                    objArr[0] = Integer.valueOf(100001);
                    objArr[1] = Integer.valueOf(10002);
                    objArr[2] = socketTimeoutException.getMessage();
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = this.hmB.getUsername();
                    if (uVar != null) {
                        str = "null";
                    } else {
                        str = uVar.icj;
                    }
                    objArr[5] = str;
                    if (uVar != null) {
                    }
                    objArr[6] = uVar != null ? Integer.valueOf(uVar.ibm) : "null";
                    if (uVar != null) {
                    }
                    objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                    objArr[8] = JN;
                    objArr[9] = "";
                    gVar.h(14058, objArr);
                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (IOException e42222) {
                    uVar = uVar2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    iOException = e42222;
                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 7, 1, true);
                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr = new Object[10];
                    objArr[0] = Integer.valueOf(100001);
                    objArr[1] = Integer.valueOf(10003);
                    objArr[2] = iOException.getMessage();
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = this.hmB.getUsername();
                    if (uVar != null) {
                        str = "null";
                    } else {
                        str = uVar.icj;
                    }
                    objArr[5] = str;
                    if (uVar != null) {
                    }
                    objArr[6] = uVar != null ? Integer.valueOf(uVar.ibm) : "null";
                    if (uVar != null) {
                    }
                    objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                    objArr[8] = JN;
                    objArr[9] = "";
                    gVar.h(14058, objArr);
                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, iOException.getClass().getSimpleName(), iOException.getMessage());
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                } catch (Exception e52222) {
                    uVar = uVar2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    inputStream = inputStream2;
                    exception = e52222;
                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 0, 1, true);
                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    objArr = new Object[10];
                    objArr[0] = Integer.valueOf(100001);
                    objArr[1] = Integer.valueOf(10003);
                    objArr[2] = exception.getMessage();
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = this.hmB.getUsername();
                    if (uVar != null) {
                        str = "null";
                    } else {
                        str = uVar.icj;
                    }
                    objArr[5] = str;
                    if (uVar != null) {
                        str = "null";
                    } else {
                        str = Integer.valueOf(uVar.ibm);
                    }
                    objArr[6] = str;
                    if (uVar != null) {
                        str = "null";
                    } else {
                        str = uVar.url.getHost();
                    }
                    objArr[7] = str;
                    objArr[8] = JN;
                    objArr[9] = "";
                    gVar.h(14058, objArr);
                    x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, exception.getClass().getSimpleName(), exception.getMessage());
                    if (uVar != null) {
                        uVar.aBw.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return true;
                }
            } catch (ProtocolException e62222) {
                uVar = uVar2;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream = inputStream2;
                protocolException = e62222;
            } catch (SocketTimeoutException e322222) {
                uVar = uVar2;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream = inputStream2;
                socketTimeoutException = e322222;
                com.tencent.mm.plugin.report.service.g.pWK.a(138, 8, 1, true);
                gVar = com.tencent.mm.plugin.report.service.g.pWK;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10002);
                objArr[2] = socketTimeoutException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.hmB.getUsername();
                if (uVar != null) {
                    str = "null";
                } else {
                    str = uVar.icj;
                }
                objArr[5] = str;
                if (uVar != null) {
                }
                objArr[6] = uVar != null ? Integer.valueOf(uVar.ibm) : "null";
                if (uVar != null) {
                }
                objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                objArr[8] = JN;
                objArr[9] = "";
                gVar.h(14058, objArr);
                x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            } catch (IOException e422222) {
                uVar = uVar2;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream = inputStream2;
                iOException = e422222;
                com.tencent.mm.plugin.report.service.g.pWK.a(138, 7, 1, true);
                gVar = com.tencent.mm.plugin.report.service.g.pWK;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10003);
                objArr[2] = iOException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.hmB.getUsername();
                if (uVar != null) {
                    str = "null";
                } else {
                    str = uVar.icj;
                }
                objArr[5] = str;
                if (uVar != null) {
                }
                objArr[6] = uVar != null ? Integer.valueOf(uVar.ibm) : "null";
                if (uVar != null) {
                }
                objArr[7] = uVar != null ? uVar.url.getHost() : "null";
                objArr[8] = JN;
                objArr[9] = "";
                gVar.h(14058, objArr);
                x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, iOException.getClass().getSimpleName(), iOException.getMessage());
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            } catch (Exception e522222) {
                uVar = uVar2;
                byteArrayOutputStream = byteArrayOutputStream2;
                inputStream = inputStream2;
                exception = e522222;
                com.tencent.mm.plugin.report.service.g.pWK.a(138, 0, 1, true);
                gVar = com.tencent.mm.plugin.report.service.g.pWK;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10003);
                objArr[2] = exception.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.hmB.getUsername();
                if (uVar != null) {
                    str = "null";
                } else {
                    str = uVar.icj;
                }
                objArr[5] = str;
                if (uVar != null) {
                    str = "null";
                } else {
                    str = Integer.valueOf(uVar.ibm);
                }
                objArr[6] = str;
                if (uVar != null) {
                    str = "null";
                } else {
                    str = uVar.url.getHost();
                }
                objArr[7] = str;
                objArr[8] = JN;
                objArr[9] = "";
                gVar.h(14058, objArr);
                x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", JN, exception.getClass().getSimpleName(), exception.getMessage());
                if (uVar != null) {
                    uVar.aBw.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            }
        }

        public final boolean JI() {
            if (!(this.hmB == null || bi.oN(this.hmB.getUsername()))) {
                if (bi.by(this.hmC)) {
                    c.this.hmr.remove(this.hmB.getUsername());
                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 10, 1, true);
                } else {
                    if (com.tencent.mm.y.ak.a.hhw != null) {
                        com.tencent.mm.y.ak.a.hhw.aV(this.hmC.length, 0);
                    }
                    c.this.a(new d(this.hmB, this.hmC));
                }
            }
            return false;
        }
    }

    private class b implements com.tencent.mm.sdk.platformtools.at.a {
        Bitmap hmD = null;
        String username = null;

        public b(String str) {
            this.username = str;
        }

        public final boolean JH() {
            h hVar = null;
            int i = 0;
            if (bi.oN(this.username)) {
                return false;
            }
            String str = this.username;
            if (str == null ? false : str.startsWith("ammURL_")) {
                String str2 = (String) c.this.hmx.get(str);
                if (!bi.oN(str2)) {
                    h jp = n.JW().jp(str);
                    if (jp == null || !str.equals(jp.getUsername())) {
                        Cursor a = n.JW().hiZ.a("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + bi.oL(str2) + "\"", null, 2);
                        if (a != null) {
                            if (a.moveToFirst()) {
                                a.moveToFirst();
                                hVar = new h();
                                hVar.b(a);
                            }
                            a.close();
                        }
                        if (!(hVar == null || bi.oN(hVar.getUsername()))) {
                            FileOp.x(b.iZ(hVar.getUsername()), b.iZ(str));
                        }
                        hVar = new h();
                        hVar.username = str;
                        hVar.fWZ = 3;
                        hVar.hnh = str2;
                        hVar.hni = str2;
                        hVar.fEo = 3;
                        hVar.bC(true);
                        hVar.fEo = 31;
                        n.JW().a(hVar);
                    }
                }
            }
            d JF = c.JF();
            if (JF == null) {
                return false;
            }
            if (d.hmI.containsKey(this.username)) {
                i = ((Integer) d.hmI.get(this.username)).intValue();
            }
            if (i != 0) {
                n.JV();
                Context context = n.getContext();
                if (context != null) {
                    JF.e(this.username, com.tencent.mm.compatible.g.a.decodeResource(context.getResources(), i));
                }
            }
            this.hmD = d.jg(this.username);
            return true;
        }

        public final boolean JI() {
            if (this.hmD == null) {
                h hVar;
                c cVar = c.this;
                String str = this.username;
                x.d("MicroMsg.AvatarService", "avatar service push: %s", str);
                if (bi.oN(str)) {
                    hVar = null;
                } else if (str.equals(cVar.hmw + "@bottle") && !bi.a((Boolean) g.Dq().Db().get(60, null), false)) {
                    hVar = null;
                } else if (!str.equals(cVar.hmw) || bi.a((Boolean) g.Dq().Db().get(59, null), false)) {
                    long Wx = bi.Wx();
                    c cVar2 = (c) cVar.hms.get(str);
                    if (cVar2 == null || cVar2.hmE < 5 || Wx - cVar2.hjl >= 600) {
                        h jd = c.jd(str);
                        if (jd == null) {
                            x.w("MicroMsg.AvatarService", "checkUser block local no need: %s", str);
                            cVar2 = new c();
                            cVar2.hmE = 5;
                            cVar2.hjl = Wx;
                            cVar.hms.l(str, cVar2);
                            hVar = null;
                        } else {
                            if (cVar2 == null || Wx - cVar2.hjl > 600) {
                                x.d("MicroMsg.AvatarService", "new user: %s", str);
                                cVar2 = new c();
                                cVar2.hmE = 1;
                                cVar2.hjl = Wx;
                                cVar.hms.l(str, cVar2);
                            } else if (cVar2.hmE < 5) {
                                x.d("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", str, Integer.valueOf(cVar2.hmE), Long.valueOf(Wx - cVar2.hjl));
                                cVar2.hmE++;
                                cVar2.hjl = Wx;
                                cVar.hms.l(str, cVar2);
                            }
                            hVar = jd;
                        }
                    } else {
                        x.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", str);
                        hVar = null;
                    }
                } else {
                    hVar = null;
                }
                if (hVar == null) {
                    cVar.hmr.remove(str);
                } else if (bi.oN(hVar.JN())) {
                    x.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(hVar.fWZ));
                    if (4 == hVar.fWZ) {
                        x.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
                    } else {
                        cVar.hmt.push(hVar);
                        if (cVar.hmt.size() > 5) {
                            cVar.hmy.K(0, 0);
                        } else {
                            cVar.hmy.K(1000, 1000);
                        }
                    }
                } else {
                    cVar.a(new a(hVar));
                }
                return false;
            }
            d JF = c.JF();
            if (JF != null) {
                JF.d(this.username, this.hmD);
            }
            c.this.hmr.remove(this.username);
            return false;
        }
    }

    private class d implements com.tencent.mm.sdk.platformtools.at.a {
        Bitmap bitmap = null;
        byte[] buf;
        h hmF = null;

        public d(h hVar, byte[] bArr) {
            this.hmF = hVar;
            this.buf = bArr;
        }

        public final boolean JH() {
            if (this.hmF == null || bi.oN(this.hmF.getUsername())) {
                x.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
                com.tencent.mm.plugin.report.service.g.pWK.a(138, 13, 1, true);
                return false;
            }
            if (c.JF() != null) {
                this.bitmap = d.e(this.hmF.getUsername(), this.buf);
                if (this.bitmap == null) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(138, 14, 1, true);
                }
            }
            i JG = c.JG();
            if (JG == null) {
                return true;
            }
            this.hmF.fEo = -1;
            this.hmF.JO();
            JG.a(this.hmF);
            return true;
        }

        public final boolean JI() {
            if (!bi.oN(this.hmF.getUsername())) {
                d JF = c.JF();
                if (!(JF == null || this.bitmap == null)) {
                    JF.d(this.hmF.getUsername(), this.bitmap);
                }
                c.this.hmr.remove(this.hmF.getUsername());
            }
            return false;
        }
    }

    static /* synthetic */ i JG() {
        return g.Do().CF() ? n.JW() : null;
    }

    public c() {
        g.CN().a(123, (e) this);
        this.hmq = false;
        this.hmw = q.FY();
    }

    public final Bitmap b(String str, boolean z, int i) {
        Bitmap bitmap;
        d JF = JF();
        if (JF != null) {
            if (i < 0 || i <= 5) {
                bitmap = null;
            } else {
                bitmap = d.jf(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}));
                if (bitmap != null) {
                    x.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", Integer.valueOf(i));
                    return bitmap;
                }
                x.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", Integer.valueOf(i));
            }
            if (bitmap == null) {
                bitmap = d.jf(str);
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            if (i < 0 || i <= 5) {
                return bitmap;
            }
            x.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", Integer.valueOf(i));
            bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, (float) i);
            JF.d(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}), bitmap);
            return bitmap;
        } else if (z) {
            return null;
        } else {
            x.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", str);
            if (this.hmr.contains(str)) {
                return null;
            }
            this.hmr.add(str);
            a(new b(str));
            return null;
        }
    }

    public final void jb(String str) {
        a(new b(str));
    }

    public final void jc(final String str) {
        g.Dt().F(new Runnable() {
            public final void run() {
                if (!bi.oN(str) && !str.equals(c.this.hmw)) {
                    i JG = c.JG();
                    if (JG != null) {
                        h jp = JG.jp(str);
                        if (jp != null && jp.getUsername().equals(str)) {
                            boolean z;
                            if (bi.Wx() - (((long) jp.hnk) * 60) > 86400) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                return;
                            }
                            if (bi.oN(jp.JN())) {
                                x.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", str);
                            } else if (c.JF() != null) {
                                d.y(str, false);
                                d.y(str, true);
                                c.this.jb(str);
                            }
                        }
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|checkAvatarExpire";
            }
        });
    }

    static h jd(String str) {
        h jp = n.JW().jp(str);
        if (jp != null && jp.getUsername().equals(str)) {
            return jp;
        }
        ag Xv = ((h) g.h(h.class)).Ff().Xv(str);
        if (Xv == null || !Xv.field_username.equals(str)) {
            boolean z;
            String str2 = "MicroMsg.AvatarService";
            String str3 = "ct == null? :%s";
            Object[] objArr = new Object[2];
            if (Xv == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str;
            x.d(str2, str3, objArr);
            return null;
        } else if (Xv.fWZ == 4) {
            b.I(str, Xv.fWZ);
            x.d("MicroMsg.AvatarService", "ct imgFlag :%s", Integer.valueOf(Xv.fWZ));
            return null;
        } else {
            jp = new h();
            jp.username = str;
            jp.fWZ = 3;
            byte[] Xz = ((h) g.h(h.class)).Ff().Xz(str);
            if (bi.by(Xz)) {
                return jp;
            }
            h a;
            try {
                a = b.a(str, (asc) new asc().aH(Xz));
            } catch (Throwable e) {
                x.e("MicroMsg.AvatarService", "exception:%s", bi.i(e));
                a = jp;
            }
            return a;
        }
    }

    public final void cancel() {
        while (this.hmt.size() > 0) {
            this.hmr.remove(this.hmt.pop());
        }
    }

    final int a(com.tencent.mm.sdk.platformtools.at.a aVar) {
        if (aVar instanceof a) {
            if (this.hmu == null) {
                this.hmu = new at(1, "getavatar", 2, g.Dt().oFY.getLooper());
            }
            return this.hmu.c(aVar);
        }
        if (this.hmv == null) {
            this.hmv = new at(1, "readsave", 1, g.Dt().oFY.getLooper());
        }
        return this.hmv.c(aVar);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 123) {
            if (!(i == 0 && i2 == 0)) {
                com.tencent.mm.plugin.report.service.g.pWK.a(138, 12, 1, true);
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(138, 45, 1, true);
            j jVar = (j) kVar;
            Set hashSet = new HashSet();
            if (jVar.hnn != null) {
                Iterator it = jVar.hnn.iterator();
                while (it.hasNext()) {
                    alq alq = (alq) it.next();
                    String str2 = alq.wzC.wRo;
                    if (alq.vNQ == null || alq.vNQ.wRm == null || alq.vNQ.wRm.oz == null) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(138, 11, 1, true);
                    } else {
                        hashSet.add(str2);
                        h hVar = new h();
                        hVar.username = str2;
                        hVar.fWZ = 3;
                        com.tencent.mm.plugin.report.service.g.pWK.a(138, 43, 1, true);
                        a(new d(hVar, alq.vNQ.wRm.oz));
                    }
                }
            }
            if (jVar.hnm != null) {
                Iterator it2 = jVar.hnm.iterator();
                while (it2.hasNext()) {
                    String str3 = ((bet) it2.next()).wRo;
                    if (!hashSet.contains(str3)) {
                        this.hmr.remove(str3);
                    }
                }
            }
            this.hmq = false;
            if (this.hmt.size() > 0) {
                this.hmy.K(0, 0);
            }
        }
    }

    static d JF() {
        if (g.Do().CF()) {
            return n.JF();
        }
        return null;
    }

    public final String je(String str) {
        if (bi.oN(str)) {
            return "";
        }
        String format;
        try {
            format = String.format("%s%x_%s", new Object[]{"ammURL_", Integer.valueOf(str.hashCode()), str.substring(str.length() - 24, str.length() - 4)});
        } catch (Exception e) {
            format = String.format("%s%x_", new Object[]{"ammURL_", Integer.valueOf(str.hashCode())});
        }
        this.hmx.put(format, str);
        return format;
    }
}
