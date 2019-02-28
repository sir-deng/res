package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.R;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bgl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class b extends com.tencent.mm.plugin.brandservice.ui.base.a {
    private static com.tencent.mm.ui.base.sortview.a.b kKR;
    protected String iconUrl;
    CharSequence ikG;
    protected CharSequence kKF;
    protected boolean kKI;
    protected boolean kKJ;
    protected String kKS;
    protected String username;

    public static class a extends com.tencent.mm.plugin.brandservice.a.a.a implements com.tencent.mm.ui.base.sortview.a.a {
        public TextView kHt;
        public TextView kKK;
        public View kKM;
        public TextView kKN;
        public View kKQ;
    }

    public b(Object obj, String str) {
        super(6, obj);
        this.kKS = str;
    }

    public final com.tencent.mm.ui.base.sortview.a.b asT() {
        if (kKR == null) {
            kKR = new com.tencent.mm.ui.base.sortview.a.b() {
                public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
                    if (!(aVar instanceof b)) {
                        return false;
                    }
                    String str;
                    String str2;
                    b bVar = (b) aVar;
                    bgl bgl = (bgl) aVar.data;
                    if (bgl.wzM != null) {
                        str = bgl.wzM.wRo;
                    } else {
                        str = null;
                    }
                    if (bgl.wfM != null) {
                        str2 = bgl.wfM.wRo;
                    } else {
                        str2 = null;
                    }
                    if (bi.oN(str2)) {
                        x.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
                        return false;
                    }
                    c cVar;
                    as.Hm();
                    ag Xv = c.Ff().Xv(str2);
                    Intent intent = new Intent();
                    if (com.tencent.mm.k.a.ga(Xv.field_type)) {
                        intent.putExtra("Contact_User", str2);
                        intent.putExtra("Contact_Scene", 55);
                    } else {
                        intent.putExtra("Contact_User", str2);
                        intent.putExtra("Contact_Alias", bgl.hxj);
                        intent.putExtra("Contact_Nick", str);
                        intent.putExtra("Contact_Signature", bgl.hxh);
                        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ai(bgl.hxn, bgl.hxf, bgl.hxg));
                        intent.putExtra("Contact_Sex", bgl.hxe);
                        intent.putExtra("Contact_VUser_Info", bgl.wCr);
                        intent.putExtra("Contact_VUser_Info_Flag", bgl.wCq);
                        intent.putExtra("Contact_KWeibo_flag", bgl.wCu);
                        intent.putExtra("Contact_KWeibo", bgl.wCs);
                        intent.putExtra("Contact_KWeiboNick", bgl.wCt);
                        intent.putExtra("Contact_Scene", 55);
                        if (bgl.wCx != null) {
                            try {
                                intent.putExtra("Contact_customInfo", bgl.wCx.toByteArray());
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.BizRecommDataItem", e, "", new Object[0]);
                            }
                        }
                    }
                    com.tencent.mm.plugin.brandservice.a.ihN.d(intent, context);
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof c)) {
                        cVar = null;
                    } else {
                        cVar = (c) objArr[0];
                    }
                    com.tencent.mm.plugin.brandservice.ui.c.b atj = bVar.atj();
                    if (atj == null || cVar == null) {
                        return true;
                    }
                    atj.a(cVar, aVar, 1, str2, bVar.atk(), bVar.getPosition());
                    return true;
                }

                public final View b(Context context, View view) {
                    if (view == null) {
                        return View.inflate(context, R.i.drC, null);
                    }
                    return view;
                }

                public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
                    int i = 0;
                    if (context == null || aVar == null || aVar2 == null || aVar2.data == null) {
                        x.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                    } else if (!(aVar instanceof a)) {
                        x.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
                    } else if (aVar2.data instanceof bgl) {
                        int i2;
                        a aVar3 = (a) aVar;
                        b bVar = (b) aVar2;
                        aVar3.username = bVar.username;
                        aVar3.iconUrl = bVar.iconUrl;
                        com.tencent.mm.plugin.brandservice.ui.base.b.a.a(aVar3.ikK, bVar.username, bVar.iconUrl);
                        aVar3.kHt.setText(bVar.ikG, BufferType.SPANNABLE);
                        View view = aVar3.kKQ;
                        if (bVar.kKJ) {
                            i2 = 0;
                        } else {
                            i2 = 8;
                        }
                        view.setVisibility(i2);
                        View view2 = aVar3.kKM;
                        if (!bVar.kKI) {
                            i = 8;
                        }
                        view2.setVisibility(i);
                        aVar3.kKN.setText(bVar.kKF, BufferType.SPANNABLE);
                        com.tencent.mm.plugin.brandservice.a.a.b(aVar3.kKK, bVar.kKS);
                    } else {
                        x.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
                    }
                }

                public final void a(View view, com.tencent.mm.ui.base.sortview.a.a aVar) {
                    if (view != null && aVar != null && (aVar instanceof a)) {
                        a aVar2 = (a) aVar;
                        aVar2.ikK = (ImageView) view.findViewById(R.h.bLE);
                        aVar2.kHt = (TextView) view.findViewById(R.h.cAr);
                        aVar2.kKK = (TextView) view.findViewById(R.h.bYB);
                        aVar2.kKQ = view.findViewById(R.h.bNO);
                        aVar2.kKM = view.findViewById(R.h.cUF);
                        aVar2.kKN = (TextView) view.findViewById(R.h.cpV);
                    }
                }
            };
        }
        return kKR;
    }

    public final com.tencent.mm.ui.base.sortview.a.a asU() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, Object... objArr) {
        if (!this.ysA) {
            if (context == null || aVar == null || this.data == null) {
                x.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(aVar instanceof a)) {
                x.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
            } else if (this.data instanceof bgl) {
                bgl bgl = (bgl) this.data;
                try {
                    this.ikG = i.b(context, bgl.wzM != null ? bgl.wzM.toString() : "", ((a) aVar).kHt.getTextSize());
                } catch (Exception e) {
                    this.ikG = "";
                }
                this.iconUrl = bgl.wbZ;
                this.username = bgl.wfM.toString();
            } else {
                x.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
            }
        }
    }
}
