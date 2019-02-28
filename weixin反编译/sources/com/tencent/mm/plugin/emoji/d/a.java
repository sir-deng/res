package com.tencent.mm.plugin.emoji.d;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.a.o;
import com.tencent.mm.ap.a.b.e;
import com.tencent.mm.ap.a.c.b;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class a implements b {

    static class a {
        private static u b(String str, com.tencent.mm.network.b.b bVar) {
            u a = com.tencent.mm.network.b.a(str, bVar);
            String str2 = "";
            if (as.Hp()) {
                r2 = new Object[4];
                as.Hm();
                r2[1] = o.getString(c.Cn());
                r2[2] = Integer.valueOf(ao.getNetTypeForStat(ad.getContext()));
                r2[3] = Integer.valueOf(ao.getStrength(ad.getContext()));
                str2 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r2);
            }
            x.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "referer %s ", str2);
            a.setRequestMethod("GET");
            a.setRequestProperty("referer", str2);
            a.setConnectTimeout(15000);
            a.setReadTimeout(HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
            return a;
        }

        public static com.tencent.mm.ap.a.d.b c(String str, com.tencent.mm.network.b.b bVar) {
            Throwable e;
            InputStream inputStream;
            String contentType;
            byte[] a;
            u b = b(str, bVar);
            if (b == null) {
                x.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "open connection failed.");
            }
            if (b.getResponseCode() == HardCoderJNI.SCENE_QUIT_CHATTING) {
                try {
                    x.i("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "302 redirect: %s", str);
                    String headerField = b.getHeaderField("location");
                    if (!bi.oN(headerField)) {
                        com.tencent.mm.network.b.b bVar2 = new com.tencent.mm.network.b.b(headerField);
                        try {
                            b.aBw.disconnect();
                            b = b(headerField, bVar2);
                            bVar = bVar2;
                        } catch (Throwable e2) {
                            bVar = bVar2;
                            e = e2;
                            x.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", e, "httpURLConnectionGet 302 redirect", new Object[0]);
                            if (com.tencent.mm.network.b.a(b) != 0) {
                                inputStream = b.getInputStream();
                                if (inputStream == null) {
                                    contentType = b.aBw.getContentType();
                                    a = e.a(inputStream, false);
                                    b.aBw.disconnect();
                                    return new com.tencent.mm.ap.a.d.b(a, contentType);
                                }
                                x.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", str);
                                return null;
                            }
                            x.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", str, bVar.ip, bVar.ip, Integer.valueOf(bVar.ibm), Integer.valueOf(b.getResponseCode()));
                            switch (b.getResponseCode()) {
                                case TencentLocation.ERROR_UNKNOWN /*404*/:
                                    g.pWK.a(315, 8, 1, false);
                                    break;
                                case 502:
                                    g.pWK.a(315, 9, 1, false);
                                    break;
                                case 503:
                                    g.pWK.a(315, 10, 1, false);
                                    break;
                                case 504:
                                    g.pWK.a(315, 11, 1, false);
                                    break;
                                default:
                                    g.pWK.a(315, 12, 1, false);
                                    break;
                            }
                            return null;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    x.printErrStackTrace("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", e, "httpURLConnectionGet 302 redirect", new Object[0]);
                    if (com.tencent.mm.network.b.a(b) != 0) {
                        x.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", str, bVar.ip, bVar.ip, Integer.valueOf(bVar.ibm), Integer.valueOf(b.getResponseCode()));
                        switch (b.getResponseCode()) {
                            case TencentLocation.ERROR_UNKNOWN /*404*/:
                                g.pWK.a(315, 8, 1, false);
                                break;
                            case 502:
                                g.pWK.a(315, 9, 1, false);
                                break;
                            case 503:
                                g.pWK.a(315, 10, 1, false);
                                break;
                            case 504:
                                g.pWK.a(315, 11, 1, false);
                                break;
                            default:
                                g.pWK.a(315, 12, 1, false);
                                break;
                        }
                        return null;
                    }
                    inputStream = b.getInputStream();
                    if (inputStream == null) {
                        x.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", str);
                        return null;
                    }
                    contentType = b.aBw.getContentType();
                    a = e.a(inputStream, false);
                    b.aBw.disconnect();
                    return new com.tencent.mm.ap.a.d.b(a, contentType);
                }
            }
            if (com.tencent.mm.network.b.a(b) != 0) {
                x.e("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "checkHttpConnection failed! url:%s urlIP:%s dnsServerIP:%s dnsType:%d retCode:%d", str, bVar.ip, bVar.ip, Integer.valueOf(bVar.ibm), Integer.valueOf(b.getResponseCode()));
                switch (b.getResponseCode()) {
                    case TencentLocation.ERROR_UNKNOWN /*404*/:
                        g.pWK.a(315, 8, 1, false);
                        break;
                    case 502:
                        g.pWK.a(315, 9, 1, false);
                        break;
                    case 503:
                        g.pWK.a(315, 10, 1, false);
                        break;
                    case 504:
                        g.pWK.a(315, 11, 1, false);
                        break;
                    default:
                        g.pWK.a(315, 12, 1, false);
                        break;
                }
                return null;
            }
            inputStream = b.getInputStream();
            if (inputStream == null) {
                x.d("MicroMsg.emoji.EmojiDownloader.DefaultHttpClientFactory", "getInputStream failed. url:%s", str);
                return null;
            }
            contentType = b.aBw.getContentType();
            a = e.a(inputStream, false);
            b.aBw.disconnect();
            return new com.tencent.mm.ap.a.d.b(a, contentType);
        }
    }

    public final com.tencent.mm.ap.a.d.b lD(String str) {
        String str2;
        int i;
        Throwable e;
        String str3 = "";
        String str4 = "";
        try {
            com.tencent.mm.network.b.b bVar = new com.tencent.mm.network.b.b(str);
            if (bi.oN(bVar.ip)) {
                str2 = str3;
            } else {
                str2 = bVar.ip;
            }
            try {
                str3 = bVar.ip;
                try {
                    i = bVar.ibm;
                    try {
                        return a.c(str, bVar);
                    } catch (ProtocolException e2) {
                        e = e2;
                    } catch (InterruptedException e3) {
                        e = e3;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                        g.pWK.a(315, 0, 1, false);
                        return new com.tencent.mm.ap.a.d.b(null, null);
                    } catch (UnknownHostException e4) {
                        e = e4;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                        g.pWK.a(315, 1, 1, false);
                        return new com.tencent.mm.ap.a.d.b(null, null);
                    } catch (SSLHandshakeException e5) {
                        e = e5;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                        g.pWK.a(315, 2, 1, false);
                        return new com.tencent.mm.ap.a.d.b(null, null);
                    } catch (SocketException e6) {
                        e = e6;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                        g.pWK.a(315, 3, 1, false);
                        return new com.tencent.mm.ap.a.d.b(null, null);
                    } catch (SocketTimeoutException e7) {
                        e = e7;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                        g.pWK.a(315, 4, 1, false);
                        return new com.tencent.mm.ap.a.d.b(null, null);
                    } catch (IOException e8) {
                        e = e8;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                        g.pWK.a(315, 5, 1, false);
                        return new com.tencent.mm.ap.a.d.b(null, null);
                    } catch (Exception e9) {
                        e = e9;
                        x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                        g.pWK.a(315, 6, 1, false);
                        return new com.tencent.mm.ap.a.d.b(null, null);
                    }
                } catch (ProtocolException e10) {
                    e = e10;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                    g.pWK.a(315, 7, 1, false);
                    return new com.tencent.mm.ap.a.d.b(null, null);
                } catch (InterruptedException e11) {
                    e = e11;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                    g.pWK.a(315, 0, 1, false);
                    return new com.tencent.mm.ap.a.d.b(null, null);
                } catch (UnknownHostException e12) {
                    e = e12;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                    g.pWK.a(315, 1, 1, false);
                    return new com.tencent.mm.ap.a.d.b(null, null);
                } catch (SSLHandshakeException e13) {
                    e = e13;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                    g.pWK.a(315, 2, 1, false);
                    return new com.tencent.mm.ap.a.d.b(null, null);
                } catch (SocketException e14) {
                    e = e14;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                    g.pWK.a(315, 3, 1, false);
                    return new com.tencent.mm.ap.a.d.b(null, null);
                } catch (SocketTimeoutException e15) {
                    e = e15;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                    g.pWK.a(315, 4, 1, false);
                    return new com.tencent.mm.ap.a.d.b(null, null);
                } catch (IOException e16) {
                    e = e16;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                    g.pWK.a(315, 5, 1, false);
                    return new com.tencent.mm.ap.a.d.b(null, null);
                } catch (Exception e17) {
                    e = e17;
                    i = 0;
                    x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                    g.pWK.a(315, 6, 1, false);
                    return new com.tencent.mm.ap.a.d.b(null, null);
                }
            } catch (ProtocolException e18) {
                e = e18;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                g.pWK.a(315, 7, 1, false);
                return new com.tencent.mm.ap.a.d.b(null, null);
            } catch (InterruptedException e19) {
                e = e19;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                g.pWK.a(315, 0, 1, false);
                return new com.tencent.mm.ap.a.d.b(null, null);
            } catch (UnknownHostException e20) {
                e = e20;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                g.pWK.a(315, 1, 1, false);
                return new com.tencent.mm.ap.a.d.b(null, null);
            } catch (SSLHandshakeException e21) {
                e = e21;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                g.pWK.a(315, 2, 1, false);
                return new com.tencent.mm.ap.a.d.b(null, null);
            } catch (SocketException e22) {
                e = e22;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                g.pWK.a(315, 3, 1, false);
                return new com.tencent.mm.ap.a.d.b(null, null);
            } catch (SocketTimeoutException e23) {
                e = e23;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                g.pWK.a(315, 4, 1, false);
                return new com.tencent.mm.ap.a.d.b(null, null);
            } catch (IOException e24) {
                e = e24;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                g.pWK.a(315, 5, 1, false);
                return new com.tencent.mm.ap.a.d.b(null, null);
            } catch (Exception e25) {
                e = e25;
                str3 = str4;
                i = 0;
                x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
                g.pWK.a(315, 6, 1, false);
                return new com.tencent.mm.ap.a.d.b(null, null);
            }
        } catch (ProtocolException e26) {
            e = e26;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
            g.pWK.a(315, 7, 1, false);
            return new com.tencent.mm.ap.a.d.b(null, null);
        } catch (InterruptedException e27) {
            e = e27;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
            g.pWK.a(315, 0, 1, false);
            return new com.tencent.mm.ap.a.d.b(null, null);
        } catch (UnknownHostException e28) {
            e = e28;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
            g.pWK.a(315, 1, 1, false);
            return new com.tencent.mm.ap.a.d.b(null, null);
        } catch (SSLHandshakeException e29) {
            e = e29;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
            g.pWK.a(315, 2, 1, false);
            return new com.tencent.mm.ap.a.d.b(null, null);
        } catch (SocketException e30) {
            e = e30;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
            g.pWK.a(315, 3, 1, false);
            return new com.tencent.mm.ap.a.d.b(null, null);
        } catch (SocketTimeoutException e31) {
            e = e31;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
            g.pWK.a(315, 4, 1, false);
            return new com.tencent.mm.ap.a.d.b(null, null);
        } catch (IOException e32) {
            e = e32;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
            g.pWK.a(315, 5, 1, false);
            return new com.tencent.mm.ap.a.d.b(null, null);
        } catch (Exception e33) {
            e = e33;
            str2 = str3;
            str3 = str4;
            i = 0;
            x.e("MicroMsg.emoji.EmojiDownloader", "[cpan] get image data failed. url:%s urlIP:%s dnsServerIP:%s dnsType:%d Exception:%s", str, str2, str3, Integer.valueOf(i), bi.i(e));
            g.pWK.a(315, 6, 1, false);
            return new com.tencent.mm.ap.a.d.b(null, null);
        }
    }
}
