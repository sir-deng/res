package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.protocal.c.bgm;
import com.tencent.mm.protocal.c.jn;
import com.tencent.mm.protocal.c.jr;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.List;

public final class a extends com.tencent.mm.plugin.brandservice.ui.base.a {
    private static b kKE;
    protected String iconUrl;
    protected CharSequence kKF;
    protected CharSequence kKG;
    protected CharSequence kKH;
    protected boolean kKI;
    protected boolean kKJ;
    protected CharSequence nickName;
    protected String username;

    public static class b extends com.tencent.mm.ui.base.sortview.a.b {
        public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
            if (!(aVar instanceof a)) {
                return false;
            }
            a aVar2 = (a) aVar;
            if (aVar.data instanceof jr) {
                jr jrVar = (jr) aVar.data;
                if (jrVar.vWJ == null || jrVar.vWJ.vWr == null) {
                    x.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                    return false;
                }
                String str;
                int i;
                int i2 = 0;
                c cVar = null;
                String str2 = "";
                if (objArr != null) {
                    c cVar2;
                    if (objArr.length <= 0 || !(objArr[0] instanceof c)) {
                        cVar2 = null;
                    } else {
                        cVar2 = (c) objArr[0];
                    }
                    if (objArr.length > 2 && (objArr[2] instanceof Integer)) {
                        i2 = ((Integer) objArr[2]).intValue();
                    }
                    if (objArr.length <= 3 || !(objArr[3] instanceof String)) {
                        cVar = cVar2;
                        str = str2;
                        i = i2;
                    } else {
                        i = i2;
                        c cVar3 = cVar2;
                        str = (String) objArr[3];
                        cVar = cVar3;
                    }
                } else {
                    str = str2;
                    i = 0;
                }
                String str3 = jrVar.vWJ.nkN;
                bgm bgm = jrVar.vWJ.vWr;
                String str4 = bgm.wzM != null ? bgm.wzM.wRo : null;
                String str5 = bgm.wfM != null ? bgm.wfM.wRo : null;
                if (bi.oN(str5)) {
                    x.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
                    return false;
                }
                int i3;
                d.lW(str5);
                if (bi.oN(str3)) {
                    as.Hm();
                    ag Xv = c.Ff().Xv(str5);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("Contact_Ext_Args_Search_Id", str);
                    bundle.putInt("Contact_Ext_Args_Index", aVar2.atk());
                    bundle.putString("Contact_Ext_Args_Query_String", "");
                    bundle.putInt("Contact_Scene", i);
                    intent.putExtra("Contact_Ext_Args", bundle);
                    intent.putExtra("Contact_User", str5);
                    intent.putExtra("Contact_Scene", i);
                    if (!com.tencent.mm.k.a.ga(Xv.field_type)) {
                        intent.putExtra("Contact_Alias", bgm.hxj);
                        intent.putExtra("Contact_Nick", str4);
                        intent.putExtra("Contact_Signature", bgm.hxh);
                        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ai(bgm.hxn, bgm.hxf, bgm.hxg));
                        intent.putExtra("Contact_Sex", bgm.hxe);
                        intent.putExtra("Contact_VUser_Info", bgm.wCr);
                        intent.putExtra("Contact_VUser_Info_Flag", bgm.wCq);
                        intent.putExtra("Contact_KWeibo_flag", bgm.wCu);
                        intent.putExtra("Contact_KWeibo", bgm.wCs);
                        intent.putExtra("Contact_KWeiboNick", bgm.wCt);
                        if (bgm.wSd != null) {
                            try {
                                intent.putExtra("Contact_customInfo", bgm.wSd.toByteArray());
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.BizContactDataItem", e, "", new Object[0]);
                            }
                        }
                    }
                    com.tencent.mm.plugin.brandservice.a.ihN.d(intent, context);
                    i3 = 1;
                } else {
                    i3 = 8;
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", str3);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("vertical_scroll", true);
                    com.tencent.mm.bl.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                }
                com.tencent.mm.plugin.brandservice.ui.c.b atj = aVar2.atj();
                if (!(atj == null || cVar == null)) {
                    atj.a(cVar, aVar, i3, str5, aVar2.atk(), aVar2.getPosition());
                }
                return true;
            }
            x.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
            return false;
        }

        public final View b(Context context, View view) {
            if (view == null) {
                return View.inflate(context, R.i.drC, null);
            }
            return view;
        }

        public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
            int i = 8;
            if (context == null || aVar == null || aVar2 == null || aVar2.data == null) {
                x.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(aVar instanceof a)) {
                x.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
            } else if (aVar2 instanceof a) {
                a aVar3 = (a) aVar;
                a aVar4 = (a) aVar2;
                aVar3.username = aVar4.username;
                aVar3.iconUrl = aVar4.iconUrl;
                com.tencent.mm.plugin.brandservice.ui.base.b.a.a(aVar3.ikK, aVar4.username, aVar4.iconUrl);
                aVar3.kKM.setVisibility(aVar4.kKI ? 0 : 8);
                View view = aVar3.kKQ;
                if (aVar4.kKJ) {
                    i = 0;
                }
                view.setVisibility(i);
                com.tencent.mm.plugin.brandservice.a.a.b(aVar3.kKL, aVar4.nickName);
                boolean b = com.tencent.mm.plugin.brandservice.a.a.b(aVar3.kKP, aVar4.kKH);
                boolean b2 = com.tencent.mm.plugin.brandservice.a.a.b(aVar3.kKO, aVar4.kKG);
                if (com.tencent.mm.plugin.brandservice.a.a.b(aVar3.kKN, aVar4.kKF)) {
                    if (b || b2) {
                        aVar3.kKN.setMaxLines(1);
                    } else {
                        aVar3.kKN.setMaxLines(2);
                    }
                }
                x.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", aVar4.nickName, aVar4.kKG);
            } else {
                x.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
            }
        }

        public final void a(View view, com.tencent.mm.ui.base.sortview.a.a aVar) {
            if (view != null && aVar != null && (aVar instanceof a)) {
                a aVar2 = (a) aVar;
                aVar2.kKK = (TextView) view.findViewById(R.h.bYB);
                aVar2.kKQ = view.findViewById(R.h.bNO);
                aVar2.ikK = (ImageView) view.findViewById(R.h.bLE);
                aVar2.kKL = (TextView) view.findViewById(R.h.cAr);
                aVar2.kKM = view.findViewById(R.h.cUF);
                aVar2.kKO = (TextView) view.findViewById(R.h.ciV);
                aVar2.kKN = (TextView) view.findViewById(R.h.cpV);
                aVar2.kKP = (TextView) view.findViewById(R.h.cZX);
            }
        }
    }

    public static class a extends com.tencent.mm.plugin.brandservice.a.a.a implements com.tencent.mm.ui.base.sortview.a.a {
        public TextView kKK;
        public TextView kKL;
        public View kKM;
        public TextView kKN;
        public TextView kKO;
        public TextView kKP;
        View kKQ;
    }

    public a(Object obj) {
        super(5, obj);
    }

    public final com.tencent.mm.ui.base.sortview.a.b asT() {
        if (kKE == null) {
            kKE = new b();
        }
        return kKE;
    }

    public final com.tencent.mm.ui.base.sortview.a.a asU() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, Object... objArr) {
        com.tencent.mm.af.d.b.d dVar = null;
        if (!this.ysA) {
            if (context == null || aVar == null || this.data == null) {
                x.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(aVar instanceof a)) {
                x.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
            } else if (this.data instanceof jr) {
                a aVar2 = (a) aVar;
                jr jrVar = (jr) this.data;
                if (jrVar.vWJ == null || jrVar.vWJ.vWr == null) {
                    x.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                    return;
                }
                com.tencent.mm.af.d dVar2;
                bgm bgm = jrVar.vWJ.vWr;
                jn jnVar = jrVar.vWJ.vWo;
                if (objArr != null && objArr.length > 1 && (objArr[1] instanceof List)) {
                    this.kMM = (List) objArr[1];
                }
                this.username = bgm.wfM.wRo;
                this.iconUrl = bgm.wbZ;
                this.kKG = jnVar == null ? "" : jnVar.vWx;
                String str = bgm.wzM == null ? null : bgm.wzM.wRo;
                try {
                    List list = this.kMM;
                    aVar2.kKL.getTextSize();
                    this.nickName = com.tencent.mm.plugin.brandservice.a.a.b(context, str, list);
                } catch (Exception e) {
                    this.nickName = "";
                }
                String str2 = bgm.wfM.wRo;
                pz pzVar = bgm.wSd;
                if (pzVar != null) {
                    dVar2 = new com.tencent.mm.af.d();
                    dVar2.field_username = str2;
                    com.tencent.mm.plugin.brandservice.a.a.a(dVar2, pzVar);
                } else {
                    dVar2 = null;
                }
                if (!(dVar2 == null || dVar2.bK(false) == null)) {
                    dVar = dVar2.bK(false).LF();
                }
                if (dVar != null) {
                    boolean z;
                    if (!dVar2.bK(false).LH() || bi.oN(dVar.hqV)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.kKJ = z;
                    this.kKI = bgm.wCq != 0;
                }
                x.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", Integer.valueOf(bgm.wCq));
                String str3 = bgm.hxj;
                if (this.kMM.size() > 0 && str3 != null && str3.toLowerCase().equals(((String) this.kMM.get(0)).toLowerCase())) {
                    try {
                        List list2 = this.kMM;
                        aVar2.kKP.getTextSize();
                        this.kKH = com.tencent.mm.plugin.brandservice.a.a.b(context, str3, list2);
                        this.kKH = TextUtils.concat(new CharSequence[]{context.getResources().getString(R.l.eJa), this.kKH});
                    } catch (Exception e2) {
                        this.kKH = "";
                    }
                }
                if (this.kKH == null || this.kKH.length() == 0 || this.kKG == null || this.kKG.length() == 0) {
                    try {
                        str = bgm.hxh;
                        List list3 = this.kMM;
                        aVar2.kKN.getTextSize();
                        this.kKF = com.tencent.mm.plugin.brandservice.a.a.b(context, str, list3);
                    } catch (Exception e3) {
                        this.kKF = "";
                    }
                }
                x.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", this.nickName, this.kKG);
                this.ysA = true;
            } else {
                x.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
            }
        }
    }
}
