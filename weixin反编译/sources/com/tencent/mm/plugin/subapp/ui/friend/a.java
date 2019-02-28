package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.be.b;
import com.tencent.mm.be.f;
import com.tencent.mm.be.l;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.q;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class a implements OnItemClickListener {
    private Context context;
    private boolean hnX = false;
    private b scR;

    public a(Context context, b bVar, boolean z) {
        this.context = context;
        this.scR = bVar;
        this.hnX = z;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.hnX) {
            i--;
        }
        b bVar = (b) this.scR.getItem(i);
        if (bVar == null) {
            x.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = " + i);
        } else {
            g(this.context, bVar.field_talker, false);
        }
    }

    public static void g(Context context, String str, boolean z) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
            return;
        }
        x.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = " + str);
        l.TE().mW(str);
        f nb = l.TD().nb(str);
        if (nb == null) {
            x.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = " + str);
        } else if (nb.field_type == 0) {
            as.Hm();
            com.tencent.mm.storage.au.a Fq = c.Fh().Fq(nb.field_msgContent);
            if (Fq != null && Fq.sfb.length() > 0) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("Contact_ShowFMessageList", true);
                bundle.putInt("Contact_Source_FMessage", Fq.scene);
                as.Hm();
                com.tencent.mm.storage.x Xv = c.Ff().Xv(Fq.sfb);
                if (Xv != null && ((int) Xv.gKO) > 0 && com.tencent.mm.k.a.ga(Xv.field_type)) {
                    com.tencent.mm.plugin.subapp.b.ihO.a(context, Xv, Fq, bundle, "");
                } else if (Fq.ppA > 0) {
                    if (bi.oN(Fq.hyK) && bi.oN(Fq.hyH) && !bi.oN(Fq.fqG)) {
                        bundle.putString("Contact_QQNick", Fq.fqG);
                    }
                    com.tencent.mm.plugin.subapp.b.ihO.a(context, Fq, bundle);
                } else if (bi.oN(Fq.xHI) && bi.oN(Fq.xHJ)) {
                    com.tencent.mm.plugin.subapp.b.ihO.a(context, Fq, bundle);
                } else {
                    com.tencent.mm.modelfriend.b kV = af.OJ().kV(Fq.xHI);
                    if (kV == null || kV.Nx() == null || kV.Nx().length() <= 0) {
                        kV = af.OJ().kV(Fq.xHJ);
                        if (kV == null || kV.Nx() == null || kV.Nx().length() <= 0) {
                            if (Xv == null || ((int) Xv.gKO) <= 0) {
                                com.tencent.mm.plugin.subapp.b.ihO.a(context, Fq, bundle);
                            } else {
                                com.tencent.mm.plugin.subapp.b.ihO.a(context, Xv, Fq, bundle, "");
                            }
                            x.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + Fq.xHI + " fullMD5:" + Fq.xHJ);
                            return;
                        }
                    }
                    if (kV.getUsername() == null || kV.getUsername().length() <= 0) {
                        kV.username = Fq.sfb;
                        kV.fEo = FileUtils.S_IWUSR;
                        if (af.OJ().a(kV.Nx(), kV) == -1) {
                            x.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
                            return;
                        }
                    }
                    com.tencent.mm.plugin.subapp.b.ihO.a(context, Fq, bundle);
                }
            }
        } else {
            a(context, nb, z);
        }
    }

    public static void a(Context context, f fVar, boolean z) {
        String str = fVar.field_msgContent;
        x.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : " + str);
        if (str != null && str.length() > 0) {
            as.Hm();
            d Fp = c.Fh().Fp(str);
            if (Fp != null && !bi.oN(Fp.sfb)) {
                Assert.assertTrue(Fp.sfb.length() > 0);
                as.Hm();
                ag Xv = c.Ff().Xv(Fp.sfb);
                Intent intent = new Intent();
                if (z) {
                    intent.putExtra("Accept_NewFriend_FromOutside", true);
                }
                intent.putExtra("Contact_ShowUserName", false);
                intent.putExtra("Contact_ShowFMessageList", true);
                intent.putExtra("Contact_Scene", Fp.scene);
                intent.putExtra("Verify_ticket", Fp.mTU);
                intent.putExtra("Contact_Source_FMessage", Fp.scene);
                if (Xv == null || ((int) Xv.gKO) <= 0 || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                    if (fVar.field_type == 1 || fVar.field_type == 2) {
                        intent.putExtra("User_Verify", true);
                    }
                    intent.putExtra("Contact_User", Fp.sfb);
                    intent.putExtra("Contact_Alias", Fp.ggL);
                    intent.putExtra("Contact_Nick", Fp.fqG);
                    intent.putExtra("Contact_QuanPin", Fp.hyG);
                    intent.putExtra("Contact_PyInitial", Fp.hyF);
                    intent.putExtra("Contact_Sex", Fp.fXa);
                    intent.putExtra("Contact_Signature", Fp.signature);
                    intent.putExtra("Contact_FMessageCard", true);
                    intent.putExtra("Contact_City", Fp.getCity());
                    intent.putExtra("Contact_Province", Fp.getProvince());
                    intent.putExtra("Contact_Mobile_MD5", Fp.xHI);
                    intent.putExtra("Contact_full_Mobile_MD5", Fp.xHJ);
                    intent.putExtra("Contact_KSnsBgUrl", Fp.xHW);
                } else {
                    intent.putExtra("Contact_User", Xv.field_username);
                    com.tencent.mm.plugin.subapp.b.ihO.a(intent, Xv.field_username);
                }
                str = Fp.content;
                if (bi.oM(str).length() <= 0) {
                    switch (Fp.scene) {
                        case 18:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                            str = context.getString(R.l.dRq);
                            break;
                        default:
                            str = context.getString(R.l.dRm);
                            break;
                    }
                }
                intent.putExtra("Contact_Content", str);
                if (Fp.xHY == 1 && !bi.oN(Fp.xIa)) {
                    intent.putExtra("Safety_Warning_Detail", Fp.xIa);
                }
                intent.putExtra("Contact_verify_Scene", Fp.scene);
                if ((Fp.scene == 14 || Fp.scene == 8) && !bi.oN(Fp.chatroomName)) {
                    as.Hm();
                    q hG = c.Fo().hG(Fp.chatroomName);
                    if (hG != null) {
                        intent.putExtra("Contact_RoomNickname", hG.gw(Fp.sfb));
                    }
                }
                intent.putExtra("Contact_Uin", Fp.ppA);
                intent.putExtra("Contact_QQNick", Fp.hyH);
                intent.putExtra("Contact_Mobile_MD5", Fp.xHI);
                intent.putExtra("User_From_Fmessage", true);
                intent.putExtra("Contact_from_msgType", 37);
                if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                    intent.putExtra("Contact_KSnsIFlag", 0);
                }
                intent.putExtra("Contact_KSnsBgUrl", Fp.xHW);
                intent.putExtra("verify_gmail", Fp.ppC);
                intent.putExtra("source_from_user_name", Fp.vtA);
                intent.putExtra("source_from_nick_name", Fp.vtB);
                com.tencent.mm.bl.d.b(context, "profile", ".ui.ContactInfoUI", intent);
            }
        }
    }
}
