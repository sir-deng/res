package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;

final class h extends o {
    private static final byte[] aFt = "\n".getBytes();
    private final String aFr;
    private final j aFs;

    private class a {
        int aFu;
        ByteArrayOutputStream aFv = new ByteArrayOutputStream();

        public final boolean b(c cVar) {
            w.ag(cVar);
            if (this.aFu + 1 > ac.nB()) {
                return false;
            }
            String a = h.this.a(cVar, false);
            if (a == null) {
                h.this.aFo.mT().a(cVar, "Error formatting hit");
                return true;
            }
            byte[] bytes = a.getBytes();
            int length = bytes.length;
            if (length > ac.nx()) {
                h.this.aFo.mT().a(cVar, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.aFv.size() > 0) {
                length++;
            }
            if (this.aFv.size() + length > ((Integer) aj.aHS.get()).intValue()) {
                return false;
            }
            try {
                if (this.aFv.size() > 0) {
                    this.aFv.write(h.aFt);
                }
                this.aFv.write(bytes);
                this.aFu++;
                return true;
            } catch (IOException e) {
                h.this.f("Failed to write payload when batching hits", e);
                return true;
            }
        }
    }

    h(q qVar) {
        super(qVar);
        String str = p.VERSION;
        String str2 = VERSION.RELEASE;
        String c = k.c(Locale.getDefault());
        String str3 = Build.MODEL;
        String str4 = Build.ID;
        this.aFr = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", str, str2, c, str3, str4});
        this.aFs = new j(qVar.aFD);
    }

    private int a(URL url, byte[] bArr) {
        Object e;
        Throwable th;
        OutputStream outputStream = null;
        w.ag(url);
        w.ag(bArr);
        b("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (n.mQ()) {
            c("Post payload\n", new String(bArr));
        }
        HttpURLConnection c;
        try {
            c = c(url);
            try {
                c.setDoOutput(true);
                c.setFixedLengthStreamingMode(bArr.length);
                c.connect();
                outputStream = c.getOutputStream();
                outputStream.write(bArr);
                b(c);
                int responseCode = c.getResponseCode();
                if (responseCode == 200) {
                    this.aFo.mV().mM();
                }
                d("POST status", Integer.valueOf(responseCode));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        f("Error closing http post connection output stream", e2);
                    }
                }
                if (c == null) {
                    return responseCode;
                }
                c.disconnect();
                return responseCode;
            } catch (IOException e3) {
                e = e3;
                try {
                    e("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            f("Error closing http post connection output stream", e4);
                        }
                    }
                    if (c != null) {
                        c.disconnect();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e22) {
                            f("Error closing http post connection output stream", e22);
                        }
                    }
                    if (c != null) {
                        c.disconnect();
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            c = outputStream;
            e("Network POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (c != null) {
                c.disconnect();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            c = outputStream;
            if (outputStream != null) {
                outputStream.close();
            }
            if (c != null) {
                c.disconnect();
            }
            throw th;
        }
    }

    private URL a(c cVar) {
        try {
            return new URL(cVar.aFg ? ac.nC() + ac.nE() : ac.nD() + ac.nE());
        } catch (MalformedURLException e) {
            f("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private static void a(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append('&');
        }
        stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
        stringBuilder.append('=');
        stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private int b(URL url) {
        w.ag(url);
        d("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = c(url);
            httpURLConnection.connect();
            b(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                this.aFo.mV().mM();
            }
            d("GET status", Integer.valueOf(responseCode));
            if (httpURLConnection == null) {
                return responseCode;
            }
            httpURLConnection.disconnect();
            return responseCode;
        } catch (IOException e) {
            e("Network GET connection error", e);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return 0;
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private int b(URL url, byte[] bArr) {
        Object e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        OutputStream outputStream = null;
        w.ag(url);
        w.ag(bArr);
        HttpURLConnection c;
        OutputStream outputStream2;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            super.a(3, "POST compressed size, ratio %, url", Integer.valueOf(toByteArray.length), Long.valueOf((100 * ((long) toByteArray.length)) / ((long) bArr.length)), url);
            if (toByteArray.length > bArr.length) {
                c("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(toByteArray.length), Integer.valueOf(bArr.length));
            }
            if (n.mQ()) {
                c("Post payload", "\n" + new String(bArr));
            }
            c = c(url);
            try {
                c.setDoOutput(true);
                c.addRequestProperty("Content-Encoding", "gzip");
                c.setFixedLengthStreamingMode(toByteArray.length);
                c.connect();
                outputStream2 = c.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                outputStream2 = null;
                httpURLConnection = c;
            } catch (Throwable th2) {
                th = th2;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                        f("Error closing http compressed post connection output stream", e3);
                    }
                }
                if (c != null) {
                    c.disconnect();
                }
                throw th;
            }
            try {
                outputStream2.write(toByteArray);
                outputStream2.close();
                b(c);
                int responseCode = c.getResponseCode();
                if (responseCode == 200) {
                    this.aFo.mV().mM();
                }
                d("POST status", Integer.valueOf(responseCode));
                if (c == null) {
                    return responseCode;
                }
                c.disconnect();
                return responseCode;
            } catch (IOException e4) {
                e = e4;
                httpURLConnection = c;
                try {
                    e("Network compressed POST connection error", e);
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e5) {
                            f("Error closing http compressed post connection output stream", e5);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return 0;
                } catch (Throwable th3) {
                    th = th3;
                    c = httpURLConnection;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (c != null) {
                        c.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                outputStream = outputStream2;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (c != null) {
                    c.disconnect();
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            outputStream2 = null;
            e("Network compressed POST connection error", e);
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return 0;
        } catch (Throwable th5) {
            th = th5;
            c = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (c != null) {
                c.disconnect();
            }
            throw th;
        }
    }

    private URL b(c cVar, String str) {
        try {
            return new URL(cVar.aFg ? ac.nC() + ac.nE() + "?" + str : ac.nD() + ac.nE() + "?" + str);
        } catch (MalformedURLException e) {
            f("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    f("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    f("Error closing http connection input stream", e2);
                }
            }
        }
    }

    private HttpURLConnection c(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(((Integer) aj.aHW.get()).intValue());
            httpURLConnection.setReadTimeout(((Integer) aj.aHX.get()).intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.aFr);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    private URL mr() {
        try {
            return new URL(ac.nC() + ((String) aj.aHL.get()));
        } catch (MalformedURLException e) {
            f("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private List<Long> r(List<c> list) {
        List<Long> arrayList = new ArrayList(list.size());
        for (c cVar : list) {
            boolean z;
            w.ag(cVar);
            String a = a(cVar, !cVar.aFg);
            if (a == null) {
                this.aFo.mT().a(cVar, "Error formatting hit for upload");
                z = true;
            } else {
                URL b;
                if (a.length() <= ((Integer) aj.aHM.get()).intValue()) {
                    b = b(cVar, a);
                    if (b == null) {
                        ay("Failed to build collect GET endpoint url");
                    } else {
                        z = b(b) == 200;
                    }
                } else {
                    String a2 = a(cVar, false);
                    if (a2 == null) {
                        this.aFo.mT().a(cVar, "Error formatting hit for POST upload");
                        z = true;
                    } else {
                        byte[] bytes = a2.getBytes();
                        if (bytes.length > ((Integer) aj.aHR.get()).intValue()) {
                            this.aFo.mT().a(cVar, "Hit payload exceeds size limit");
                            z = true;
                        } else {
                            b = a(cVar);
                            if (b == null) {
                                ay("Failed to build collect POST endpoint url");
                            } else if (a(b, bytes) == 200) {
                                z = true;
                            }
                        }
                    }
                }
                z = false;
            }
            if (!z) {
                break;
            }
            arrayList.add(Long.valueOf(cVar.aFd));
            if (arrayList.size() >= ac.nA()) {
                break;
            }
        }
        return arrayList;
    }

    final String a(c cVar, boolean z) {
        w.ag(cVar);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : cVar.aFb.entrySet()) {
                String str = (String) entry.getKey();
                if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str) || "z".equals(str) || "_gmsv".equals(str))) {
                    a(stringBuilder, str, (String) entry.getValue());
                }
            }
            a(stringBuilder, "ht", String.valueOf(cVar.aFe));
            a(stringBuilder, "qt", String.valueOf(this.aFo.aFD.currentTimeMillis() - cVar.aFe));
            if (f.aNs) {
                a(stringBuilder, "_gmsv", p.VERSION);
            }
            if (z) {
                long ar = k.ar(cVar.k("_s", "0"));
                a(stringBuilder, "z", ar != 0 ? String.valueOf(ar) : String.valueOf(cVar.aFd));
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            f("Failed to encode name or value", e);
            return null;
        }
    }

    protected final void mg() {
        c("Network initialized. User agent", this.aFr);
    }

    public final boolean mq() {
        NetworkInfo activeNetworkInfo;
        q.mZ();
        mR();
        try {
            activeNetworkInfo = ((ConnectivityManager) this.aFo.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        au("No network connectivity");
        return false;
    }

    public final List<Long> q(List<c> list) {
        boolean z;
        boolean z2;
        a aVar;
        List<Long> arrayList;
        URL mr;
        int b;
        boolean z3 = true;
        q.mZ();
        mR();
        w.ag(list);
        if (this.aFo.aFW.nF().isEmpty() || !this.aFs.V(((long) ((Integer) aj.aHU.get()).intValue()) * 1000)) {
            z = false;
        } else {
            z = x.aE((String) aj.aHN.get()) != x.NONE;
            if (z.aF((String) aj.aHO.get()) == z.GZIP) {
                z2 = true;
                if (z) {
                    return r(list);
                }
                if (list.isEmpty()) {
                    z3 = false;
                }
                w.au(z3);
                a("Uploading batched hits. compression, count", Boolean.valueOf(z2), Integer.valueOf(list.size()));
                aVar = new a();
                arrayList = new ArrayList();
                for (c cVar : list) {
                    if (aVar.b(cVar)) {
                        break;
                    }
                    arrayList.add(Long.valueOf(cVar.aFd));
                }
                if (aVar.aFu == 0) {
                    return arrayList;
                }
                mr = mr();
                if (mr != null) {
                    ay("Failed to build batching endpoint url");
                } else {
                    b = z2 ? b(mr, aVar.aFv.toByteArray()) : a(mr, aVar.aFv.toByteArray());
                    if (200 != b) {
                        c("Batched upload completed. Hits batched", Integer.valueOf(aVar.aFu));
                        return arrayList;
                    }
                    c("Network error uploading hits. status code", Integer.valueOf(b));
                    if (this.aFo.aFW.nF().contains(Integer.valueOf(b))) {
                        ax("Server instructed the client to stop batching");
                        this.aFs.start();
                    }
                }
                return Collections.emptyList();
            }
        }
        z2 = false;
        if (z) {
            return r(list);
        }
        if (list.isEmpty()) {
            z3 = false;
        }
        w.au(z3);
        a("Uploading batched hits. compression, count", Boolean.valueOf(z2), Integer.valueOf(list.size()));
        aVar = new a();
        arrayList = new ArrayList();
        for (c cVar2 : list) {
            if (aVar.b(cVar2)) {
                break;
            }
            arrayList.add(Long.valueOf(cVar2.aFd));
        }
        if (aVar.aFu == 0) {
            return arrayList;
        }
        mr = mr();
        if (mr != null) {
            if (z2) {
            }
            if (200 != b) {
                c("Network error uploading hits. status code", Integer.valueOf(b));
                if (this.aFo.aFW.nF().contains(Integer.valueOf(b))) {
                    ax("Server instructed the client to stop batching");
                    this.aFs.start();
                }
            } else {
                c("Batched upload completed. Hits batched", Integer.valueOf(aVar.aFu));
                return arrayList;
            }
        }
        ay("Failed to build batching endpoint url");
        return Collections.emptyList();
    }
}
