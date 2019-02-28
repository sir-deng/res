package com.tencent.mm.plugin.wallet_core.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ac;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a {
    ArrayList<a> teW = new ArrayList();
    private c teX = new c<ac>() {
        {
            this.xmG = ac.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            while (a.this.teW != null && a.this.teW.size() > 0) {
                com.tencent.mm.platformtools.j.a aVar = (a) a.this.teW.remove(0);
                if (aVar == null) {
                    break;
                }
                Bankcard bankcard = aVar.sGk;
                ImageView imageView = (ImageView) aVar.tff.get();
                if (imageView != null) {
                    String str = (String) imageView.getTag(f.uFb);
                    if (!bi.oN(str) && ((!q.Gl() && str.equals(bankcard.field_bankcardType)) || (q.Gl() && str.equals(bankcard.field_bankName)))) {
                        e h = bankcard.sRw == null ? q.Gl() ? com.tencent.mm.plugin.wallet_core.d.b.h(imageView.getContext(), bankcard.field_bankName, false) : com.tencent.mm.plugin.wallet_core.d.b.h(imageView.getContext(), bankcard.field_bankcardType, bankcard.bLA()) : bankcard.sRw;
                        a aVar2 = a.this;
                        if (h == null || aVar == null || aVar.tff == null || aVar.tff.get() == null) {
                            x.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
                        } else {
                            x.d("MicroMsg.BankcardLogoHelper", "setLogo bankLogoUrl = " + h.oVl);
                            imageView = (ImageView) aVar.tff.get();
                            if (!bi.oN(h.oVl)) {
                                imageView.post(new AnonymousClass2(aVar, imageView, j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(h.oVl))));
                                aVar.tcb = h.oVl;
                                j.a(aVar);
                            } else if (h.sRF > 0) {
                                imageView.post(new AnonymousClass3(imageView, h));
                            } else {
                                x.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
                            }
                        }
                        aVar2 = a.this;
                        if (!(h == null || aVar == null || aVar.tfg == null || aVar.tfg.get() == null)) {
                            View view = (View) aVar.tfg.get();
                            view.post(new AnonymousClass4(view, h, aVar));
                        }
                        aVar2 = a.this;
                        if (!(h == null || aVar == null || aVar.tfg == null || aVar.tfg.get() == null)) {
                            imageView = (ImageView) aVar.tfh.get();
                            if (imageView != null) {
                                imageView.post(new AnonymousClass5(h, imageView, aVar));
                            }
                        }
                    }
                }
            }
            return true;
        }
    };
    public LinkedList<String> teY;
    public LinkedList<Bankcard> teZ;

    /* renamed from: com.tencent.mm.plugin.wallet_core.e.a$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ImageView lUB;
        final /* synthetic */ a tfb;
        final /* synthetic */ Bitmap tfc;

        AnonymousClass2(a aVar, ImageView imageView, Bitmap bitmap) {
            this.tfb = aVar;
            this.lUB = imageView;
            this.tfc = bitmap;
        }

        public final void run() {
            Bankcard bankcard = this.tfb.sGk;
            String str = (String) this.lUB.getTag(f.uFb);
            if (bi.oN(str) || ((q.Gl() || !str.equals(bankcard.field_bankcardType)) && !(q.Gl() && str.equals(bankcard.field_bankName)))) {
                x.d("MicroMsg.BankcardLogoHelper", "not match tag: %s, banktype: %s, iv: %s", str, bankcard.field_bankcardType, this.lUB);
                return;
            }
            this.lUB.setImageBitmap(this.tfc);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.e.a$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ImageView lUB;
        final /* synthetic */ e tfd;

        AnonymousClass3(ImageView imageView, e eVar) {
            this.lUB = imageView;
            this.tfd = eVar;
        }

        public final void run() {
            this.lUB.setImageResource(this.tfd.sRF);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.e.a$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ a tfb;
        final /* synthetic */ e tfd;
        final /* synthetic */ View tfe;

        AnonymousClass4(View view, e eVar, a aVar) {
            this.tfe = view;
            this.tfd = eVar;
            this.tfb = aVar;
        }

        public final void run() {
            this.tfe.invalidate();
            String str = this.tfd.sRD;
            int i = "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png".equals(str) ? com.tencent.mm.plugin.wxpay.a.e.ukg : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png".equals(str) ? com.tencent.mm.plugin.wxpay.a.e.uki : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png".equals(str) ? com.tencent.mm.plugin.wxpay.a.e.ukj : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png".equals(str) ? com.tencent.mm.plugin.wxpay.a.e.ukk : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png".equals(str) ? com.tencent.mm.plugin.wxpay.a.e.ukl : "http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png".equals(str) ? com.tencent.mm.plugin.wxpay.a.e.ukp : -1;
            if (i != -1) {
                this.tfe.setBackgroundResource(i);
            } else if (!bi.oN(this.tfd.sRD)) {
                i cVar = new com.tencent.mm.plugin.wallet_core.ui.view.c(this.tfd.sRD);
                Bitmap a = j.a(cVar);
                j.a(this.tfb);
                if (a != null) {
                    try {
                        byte[] ninePatchChunk = a.getNinePatchChunk();
                        if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                            FileOp.deleteFile(cVar.Wo());
                        }
                    } catch (Exception e) {
                    }
                }
                if (a != null) {
                    this.tfe.setBackgroundDrawable(com.tencent.mm.plugin.wallet_core.ui.view.b.c(this.tfe.getContext(), a));
                }
            } else if (this.tfd.sRG > 0) {
                this.tfe.setBackgroundResource(this.tfd.sRG);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.e.a$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ ImageView lUB;
        final /* synthetic */ a tfb;
        final /* synthetic */ e tfd;

        AnonymousClass5(e eVar, ImageView imageView, a aVar) {
            this.tfd = eVar;
            this.lUB = imageView;
            this.tfb = aVar;
        }

        public final void run() {
            if (!bi.oN(this.tfd.sRE)) {
                this.lUB.setImageBitmap(j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(this.tfd.sRE)));
                j.a(this.tfb);
            } else if (this.tfd.sRH > 0) {
                this.lUB.setImageResource(this.tfd.sRH);
            }
        }
    }

    static class a implements com.tencent.mm.platformtools.j.a {
        Bankcard sGk;
        String tcb;
        WeakReference<ImageView> tff;
        WeakReference<View> tfg = null;
        WeakReference<ImageView> tfh = null;
        boolean tfi = false;

        a() {
        }

        public final void l(String str, final Bitmap bitmap) {
            boolean z = true;
            x.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish " + str + ", bitmap = " + (bitmap == null));
            if (TextUtils.isEmpty(this.tcb)) {
                x.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
            } else if (this.tff != null) {
                String str2;
                final ImageView imageView = (ImageView) this.tff.get();
                String str3 = "MicroMsg.BankcardLogoHelper";
                String str4 = "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s";
                Object[] objArr = new Object[6];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(bitmap == null);
                if (imageView != null) {
                    z = false;
                }
                objArr[2] = Boolean.valueOf(z);
                if (imageView == null) {
                    str2 = "";
                } else {
                    str2 = imageView.getTag();
                }
                objArr[3] = str2;
                objArr[4] = this.tcb;
                objArr[5] = Boolean.valueOf(this.tfi);
                x.d(str3, str4, objArr);
                if (imageView != null && str != null && str.equals(this.tcb)) {
                    if (!this.tfi) {
                        imageView.post(new Runnable() {
                            public final void run() {
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                        imageView.setTag(f.uFb, null);
                    } else if (imageView.getTag(f.uFb) != null && this.sGk != null && this.sGk.field_bankcardType != null) {
                        str2 = (String) imageView.getTag(f.uFb);
                        if (!bi.oN(str2) && str2.equals(this.sGk.field_bankcardType)) {
                            imageView.post(new Runnable() {
                                public final void run() {
                                    imageView.setImageBitmap(bitmap);
                                }
                            });
                            imageView.setTag(f.uFb, null);
                        }
                    }
                }
            }
        }
    }

    public a() {
        com.tencent.mm.sdk.b.a.xmy.b(this.teX);
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView) {
        a(context, bankcard, imageView, null, null);
    }

    public final void a(Bankcard bankcard, ImageView imageView) {
        com.tencent.mm.platformtools.j.a aVar = new a();
        aVar.sGk = bankcard;
        if (imageView != null) {
            imageView.setTag(f.uFb, bankcard.field_bankcardType);
            aVar.tff = new WeakReference(imageView);
        }
        final e eVar = bankcard.sRw;
        if (eVar == null || aVar.tff == null || aVar.tff.get() == null) {
            x.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
            return;
        }
        x.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + eVar.oVl);
        final ImageView imageView2 = (ImageView) aVar.tff.get();
        if (!bi.oN(eVar.oVl)) {
            aVar.tcb = eVar.oVl;
            aVar.tfi = true;
            Bitmap a = j.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(eVar.oVl));
            if (a != null) {
                imageView2.setImageBitmap(a);
            }
            j.a(aVar);
        } else if (eVar.sRF > 0) {
            imageView2.post(new Runnable() {
                public final void run() {
                    imageView2.setImageResource(eVar.sRF);
                }
            });
        } else {
            x.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
        }
    }

    public final void a(Context context, Bankcard bankcard, ImageView imageView, View view, ImageView imageView2) {
        a aVar = new a();
        aVar.tfi = false;
        aVar.sGk = bankcard;
        if (imageView != null) {
            imageView.setTag(f.uFb, bankcard.field_bankcardType);
            aVar.tff = new WeakReference(imageView);
        }
        if (view != null) {
            aVar.tfg = new WeakReference(view);
        }
        if (imageView2 != null) {
            aVar.tfh = new WeakReference(imageView2);
        }
        this.teW.add(aVar);
        String str = q.Gl() ? bankcard.field_bankName : bankcard.field_bankcardType;
        if (this.teY != null && this.teY.contains(str)) {
            x.i("MicroMsg.BankcardLogoHelper", "waiting resp:" + str);
        } else if (a(context, bankcard)) {
            com.tencent.mm.sdk.b.a.xmy.m(new ac());
        } else {
            if (this.teZ == null) {
                this.teZ = new LinkedList();
            }
            this.teZ.add(bankcard);
            if (this.teY == null) {
                b(context, this.teZ);
            }
        }
    }

    public final void destory() {
        com.tencent.mm.sdk.b.a.xmy.c(this.teX);
        if (this.teW != null) {
            this.teW.clear();
            this.teW = null;
        }
    }

    private static boolean a(Context context, Bankcard bankcard) {
        e h;
        if (q.Gl()) {
            h = com.tencent.mm.plugin.wallet_core.d.b.h(context, bankcard.field_bankName, false);
        } else {
            h = com.tencent.mm.plugin.wallet_core.d.b.h(context, bankcard.field_bankcardType, bankcard.bLA());
        }
        if (h == null || h.sRI) {
            return false;
        }
        return true;
    }

    public final void b(final Context context, List<Bankcard> list) {
        if (list != null && list.size() > 0) {
            int size = list.size();
            this.teY = new LinkedList();
            for (int i = 0; i < size; i++) {
                Bankcard bankcard = (Bankcard) list.get(i);
                if (bankcard.bLB()) {
                    x.i("MicroMsg.BankcardLogoHelper", "ignore balance");
                } else if (!a(context, bankcard)) {
                    x.i("MicroMsg.BankcardLogoHelper", bankcard.field_bankcardType + "'s url is null or need update");
                    this.teY.add(bankcard.field_bankcardType);
                }
            }
            if (this.teY.size() > 0) {
                x.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
                k cVar = new com.tencent.mm.plugin.wallet_core.c.c(this.teY);
                g.Dr();
                g.Dp().gRu.a(1650, new com.tencent.mm.ad.e() {
                    public final void a(int i, int i2, String str, k kVar) {
                        g.Dr();
                        g.Dp().gRu.b(1650, (com.tencent.mm.ad.e) this);
                        a.this.teY = null;
                        if (a.this.teZ != null) {
                            a.this.b(context, a.this.teZ);
                            a.this.teZ = null;
                        }
                    }
                });
                g.Dr();
                g.Dp().gRu.a(cVar, 0);
                return;
            }
            x.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
            com.tencent.mm.sdk.b.a.xmy.m(new ac());
        }
    }
}
