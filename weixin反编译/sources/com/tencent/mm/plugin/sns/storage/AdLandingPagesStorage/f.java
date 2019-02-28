package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mm.j.g;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class f {
    private static f rui = new f();
    ConcurrentLinkedQueue<String> ruh = new ConcurrentLinkedQueue();

    public static f byy() {
        return rui;
    }

    private f() {
    }

    private boolean LM(String str) {
        return this.ruh.contains(str);
    }

    private void a(String str, s sVar) {
        final p pVar;
        if (sVar.rmO == 101) {
            Iterator it = ((n) sVar).rmy.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((m) it.next()).rmy.iterator();
                while (it2.hasNext()) {
                    a(str, (s) it2.next());
                }
            }
        } else if (sVar.rmO == 41) {
            pVar = (p) sVar;
            if (!LM(pVar.rmC)) {
                this.ruh.add(pVar.rmC);
                d.a(str, pVar.rmC, true, sVar.rmO, 0, new a() {
                    public final void bxM() {
                    }

                    public final void bxN() {
                        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + pVar.rmC + "is error");
                        f.this.ruh.remove(pVar.rmC);
                    }

                    public final void LD(String str) {
                        f.this.ruh.remove(pVar.rmC);
                    }
                });
            }
        } else if (sVar.rmO == 44) {
            final o oVar = (o) sVar;
            if (!LM(oVar.rmC)) {
                this.ruh.add(oVar.rmC);
                d.a(str, oVar.rmC, true, sVar.rmO, 0, new a() {
                    public final void bxM() {
                    }

                    public final void bxN() {
                        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + oVar.rmC + "is error");
                        f.this.ruh.remove(oVar.rmC);
                    }

                    public final void LD(String str) {
                        f.this.ruh.remove(oVar.rmC);
                    }
                });
            }
        } else if (sVar.rmO == 45) {
            pVar = (p) sVar;
            if (!LM(pVar.rmC)) {
                this.ruh.add(pVar.rmC);
                d.a(str, pVar.rmC, true, sVar.rmO, 0, new a() {
                    public final void bxM() {
                    }

                    public final void bxN() {
                        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + pVar.rmC + "is error");
                        f.this.ruh.remove(pVar.rmC);
                    }

                    public final void LD(String str) {
                        f.this.ruh.remove(pVar.rmC);
                    }
                });
            }
        } else if (sVar.rmO == 61) {
            final q qVar = (q) sVar;
            if (!LM(qVar.rmE)) {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                c.MX();
                if (c.a(pInt, pInt2)) {
                    this.ruh.add(qVar.rmE);
                    d.a(str, qVar.rmE, true, 61, new a() {
                        public final void bxM() {
                        }

                        public final void bxN() {
                            x.e("AdLandingPagesPreDownloadResHelper", " pre download " + qVar.rmE + "is error");
                            f.this.ruh.remove(qVar.rmE);
                        }

                        public final void LD(String str) {
                            f.this.ruh.remove(qVar.rmE);
                        }
                    });
                }
            }
            if (!LM(qVar.rmF)) {
                this.ruh.add(qVar.rmF);
                d.a(str, qVar.rmF, true, 1000000001, 0, new a() {
                    public final void bxM() {
                    }

                    public final void bxN() {
                        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + qVar.rmF + "is error");
                        f.this.ruh.remove(qVar.rmF);
                    }

                    public final void LD(String str) {
                        f.this.ruh.remove(qVar.rmF);
                    }
                });
            }
        } else if (sVar.rmO == 62) {
            boolean z = g.Af().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0;
            x.i("AdLandingPagesPreDownloadResHelper", "pre down video value: " + z);
            final w wVar = (w) sVar;
            if (z && !LM(wVar.rmG)) {
                this.ruh.add(wVar.rmG);
                d.a(str, wVar.rmG, true, sVar.rmO, new b() {
                    public final void LE(String str) {
                        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + wVar.rmG + "is error");
                        f.this.ruh.remove(wVar.rmG);
                    }

                    public final void LF(String str) {
                        f.this.ruh.remove(wVar.rmG);
                    }
                });
            }
            if (!LM(wVar.rnq)) {
                this.ruh.add(wVar.rnq);
                d.a("adId", wVar.rnq, true, sVar.rmO, 0, new a() {
                    public final void bxM() {
                    }

                    public final void bxN() {
                        x.e("AdLandingPagesPreDownloadResHelper", " pre download " + wVar.rnq + "is error");
                        f.this.ruh.remove(wVar.rmG);
                    }

                    public final void LD(String str) {
                        f.this.ruh.remove(wVar.rnq);
                    }
                });
            }
        }
    }

    private void LN(final String str) {
        if (!TextUtils.isEmpty(str) && !LM(str)) {
            this.ruh.add(str);
            d.a("adId", str, true, 0, 0, new a() {
                public final void bxM() {
                }

                public final void bxN() {
                    x.e("AdLandingPagesPreDownloadResHelper", " pre download " + str + "is error");
                    f.this.ruh.remove(str);
                }

                public final void LD(String str) {
                    f.this.ruh.remove(str);
                }
            });
        }
    }

    public final void d(final String str, String str2, String str3, int i) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        LinkedList m = e.m(str2, str3, "", "");
        int i2;
        int i3;
        Iterator it;
        int i4;
        c cVar;
        Iterator it2;
        final s sVar;
        if (i == 0) {
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                x.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
                i2 = g.Af().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
                i3 = g.Af().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
                if (m.size() > 0) {
                    it = m.iterator();
                    while (true) {
                        i4 = i2;
                        if (it.hasNext()) {
                            cVar = (c) it.next();
                            LN(cVar.rtR);
                            if (i3 > 0 && i4 > 0) {
                                it2 = cVar.rtT.iterator();
                                while (it2.hasNext()) {
                                    sVar = (s) it2.next();
                                    ah.y(new Runnable() {
                                        public final void run() {
                                            f.this.a(str, sVar);
                                        }
                                    });
                                    i2 = i3 - 1;
                                    if (i2 <= 0) {
                                        break;
                                    }
                                    i3 = i2;
                                }
                                i2 = i3;
                                i3 = i4 - 1;
                                i4 = i3;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
                return;
            }
            x.i("AdLandingPagesPreDownloadResHelper", "start pre download all resource in wifi");
            Iterator it3 = m.iterator();
            while (it3.hasNext()) {
                c cVar2 = (c) it3.next();
                it = cVar2.rtT.iterator();
                while (it.hasNext()) {
                    a(str, (s) it.next());
                }
                LN(cVar2.rtR);
            }
        } else if (i == 1) {
            x.i("AdLandingPagesPreDownloadResHelper", "start pre download first pages resource");
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                x.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in no wifi,this can't download everything");
                Iterator it4 = m.iterator();
                while (it4.hasNext()) {
                    LN(((c) it4.next()).rtR);
                }
                return;
            }
            x.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in wifi");
            i2 = g.Af().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
            i3 = g.Af().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
            if (m.size() > 0) {
                it = m.iterator();
                while (true) {
                    i4 = i2;
                    if (it.hasNext()) {
                        cVar = (c) it.next();
                        LN(cVar.rtR);
                        if (i3 > 0 && i4 > 0) {
                            it2 = cVar.rtT.iterator();
                            while (it2.hasNext()) {
                                sVar = (s) it2.next();
                                ah.y(new Runnable() {
                                    public final void run() {
                                        f.this.a(str, sVar);
                                    }
                                });
                                i2 = i3 - 1;
                                if (i2 <= 0) {
                                    break;
                                }
                                i3 = i2;
                            }
                            i2 = i3;
                            i3 = i4 - 1;
                            i4 = i3;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            }
        } else {
            x.e("AdLandingPagesPreDownloadResHelper", "the dwnloadKind is error");
        }
    }
}
