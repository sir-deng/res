package com.tencent.mm.plugin.favorite.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.au.a.a;
import com.tencent.mm.au.b;
import com.tencent.mm.f.a.kp;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.h;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.plugin.favorite.ui.FavImgGalleryUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteFileDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteImgDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteSightDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteTextDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteVideoPlayUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteVoiceDetailUI;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e {
    private static int[] mDJ = new int[]{R.h.bUL, R.h.bUM, R.h.bUN, R.h.bUO, R.h.bUP};

    public static void a(Context context, f fVar, vp vpVar) {
        if (context == null) {
            x.w("MicroMsg.FavItemLogic", "Context is null");
        } else if (fVar == null) {
            x.w("MicroMsg.FavItemLogic", "Fav item is null");
        } else {
            x.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_type));
            Intent intent;
            long j;
            String str;
            Intent intent2;
            switch (fVar.field_type) {
                case -2:
                    Toast.makeText(context, R.l.ehd, 0).show();
                    return;
                case 1:
                    Intent intent3 = new Intent(context, FavoriteTextDetailUI.class);
                    intent3.putExtra("key_detail_text", fVar.field_favProto.desc);
                    intent3.putExtra("key_detail_info_id", fVar.field_localId);
                    intent3.putExtra("key_detail_can_share_to_friend", fVar.aIq());
                    intent3.putExtra("key_detail_time", fVar.field_updateTime);
                    intent3.putExtra("key_detail_create_time", fVar.field_sourceCreateTime <= 0 ? fVar.field_updateTime : fVar.field_sourceCreateTime);
                    intent3.putExtra("key_detail_fav_scene", vpVar.scene);
                    intent3.putExtra("key_detail_fav_sub_scene", vpVar.mtU);
                    intent3.putExtra("key_detail_fav_index", vpVar.index);
                    context.startActivity(intent3);
                    return;
                case 2:
                    d(context, fVar, vpVar);
                    return;
                case 3:
                    intent = new Intent(context, FavoriteVoiceDetailUI.class);
                    intent.putExtra("key_detail_fav_scene", vpVar.scene);
                    intent.putExtra("key_detail_fav_sub_scene", vpVar.mtU);
                    intent.putExtra("key_detail_fav_index", vpVar.index);
                    intent.putExtra("key_detail_info_id", fVar.field_localId);
                    intent.putExtra("key_detail_create_time", fVar.field_favProto.wlW.hXs);
                    context.startActivity(intent);
                    return;
                case 4:
                    c(context, fVar, vpVar);
                    return;
                case 5:
                    d(context, fVar, true, vpVar);
                    return;
                case 6:
                    vg vgVar = fVar.field_favProto.wld;
                    String str2 = fVar.field_favProto.iLo;
                    vt vtVar = fVar.field_favProto.wlW;
                    String gw = (vtVar == null || bi.oN(vtVar.wlx)) ? r.gw(fVar.field_fromUser) : r.gw(vtVar.wlx);
                    ArrayList arrayList = new ArrayList();
                    if (fVar.field_tagProto.wmn != null) {
                        arrayList.addAll(fVar.field_tagProto.wmn);
                    }
                    d.a(fVar.field_localId, vgVar, gw, str2, arrayList, context);
                    return;
                case 7:
                    String absolutePath;
                    vt vtVar2 = fVar.field_favProto.wlW;
                    uz p = j.p(fVar);
                    File file = new File(j.i(p));
                    if (file.exists()) {
                        absolutePath = file.getAbsolutePath();
                    } else if (p.fra == null) {
                        absolutePath = "";
                    } else {
                        file = new File(j.aJl() + g.s(p.fra.getBytes()));
                        absolutePath = file.exists() ? file.getAbsolutePath() : "";
                    }
                    b.b(((a) com.tencent.mm.kernel.g.h(a.class)).a(6, null, p.title, p.desc, p.wjU, p.wjY, p.wjW, p.mBr, j.aJn(), absolutePath, "", vtVar2.appId));
                    intent = new Intent();
                    intent.putExtra("key_scene", 2);
                    com.tencent.mm.bl.d.b(context, "music", ".ui.MusicMainUI", intent);
                    return;
                case 8:
                    c(context, fVar, true, vpVar);
                    return;
                case 10:
                    x.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId));
                    j = fVar.field_localId;
                    str = fVar.field_favProto.wlh.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_Product_xml", str);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    intent2.putExtra("key_ProductUI_getProductInfoScene", 3);
                    com.tencent.mm.bl.d.b(context, "scanner", ".ui.ProductUI", intent2);
                    return;
                case 11:
                    x.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId));
                    intent = new Intent();
                    intent.putExtra("key_product_scene", 4);
                    intent.putExtra("key_product_info", fVar.field_favProto.wlh.info);
                    com.tencent.mm.bl.d.b(context, "product", ".ui.MallProductUI", intent);
                    return;
                case 12:
                case 15:
                    x.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId));
                    j = fVar.field_localId;
                    str = fVar.field_favProto.wlj.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_TV_getProductInfoScene", 3);
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_TV_xml", str);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    com.tencent.mm.bl.d.b(context, "shake", ".ui.TVInfoUI", intent2);
                    return;
                case 14:
                    a(context, fVar, true, vpVar);
                    return;
                case 16:
                    uz p2 = j.p(fVar);
                    if (p2 == null || p2.wkN == null || (bi.oN(p2.wkN.heZ) && bi.oN(p2.wkN.hfd))) {
                        c(context, fVar, vpVar);
                        return;
                    }
                    x.i("MicroMsg.FavItemLogic", "it is ad sight.");
                    b(context, fVar, vpVar);
                    return;
                case 17:
                    String str3 = j.p(fVar).desc;
                    as.Hm();
                    au.a Fq = c.Fh().Fq(str3);
                    if (Fq != null) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("Contact_User", Fq.sfb);
                        intent4.putExtra("Contact_Alias", Fq.ggL);
                        intent4.putExtra("Contact_Nick", Fq.fqG);
                        intent4.putExtra("Contact_QuanPin", Fq.hyG);
                        intent4.putExtra("Contact_PyInitial", Fq.hyF);
                        intent4.putExtra("Contact_Uin", Fq.ppA);
                        intent4.putExtra("Contact_Mobile_MD5", Fq.xHI);
                        intent4.putExtra("Contact_full_Mobile_MD5", Fq.xHJ);
                        intent4.putExtra("Contact_QQNick", Fq.ckv());
                        intent4.putExtra("User_From_Fmessage", false);
                        intent4.putExtra("Contact_Scene", Fq.scene);
                        intent4.putExtra("Contact_FMessageCard", true);
                        intent4.putExtra("Contact_RemarkName", Fq.hyK);
                        intent4.putExtra("Contact_VUser_Info_Flag", Fq.tth);
                        intent4.putExtra("Contact_VUser_Info", Fq.fXp);
                        intent4.putExtra("Contact_BrandIconURL", Fq.pnr);
                        intent4.putExtra("Contact_Province", Fq.getProvince());
                        intent4.putExtra("Contact_City", Fq.getCity());
                        intent4.putExtra("Contact_Sex", Fq.fXa);
                        intent4.putExtra("Contact_Signature", Fq.signature);
                        intent4.putExtra("Contact_ShowUserName", false);
                        intent4.putExtra("Contact_KSnsIFlag", 0);
                        com.tencent.mm.bl.d.b(context, "profile", ".ui.ContactInfoUI", intent4);
                        com.tencent.mm.bm.a.CV(Fq.scene);
                        return;
                    }
                    return;
                case 18:
                    b(context, fVar, true, vpVar);
                    return;
                default:
                    x.w("MicroMsg.FavItemLogic", "Do not match any type %d", Integer.valueOf(fVar.field_type));
                    return;
            }
        }
    }

    private static void a(Context context, f fVar, boolean z, vp vpVar) {
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", fVar.field_localId);
        intent.putExtra("show_share", z);
        intent.putExtra("key_detail_fav_scene", vpVar.scene);
        intent.putExtra("key_detail_fav_sub_scene", vpVar.mtU);
        intent.putExtra("key_detail_fav_index", vpVar.index);
        com.tencent.mm.bl.d.b(context, "record", ".ui.FavRecordDetailUI", intent);
    }

    public static boolean l(uz uzVar) {
        ati Qz = b.Qz();
        return Qz != null && Qz.wHt == 6 && bi.aD(uzVar.mBr, "").equals(Qz.wdd) && b.Qx();
    }

    private static void b(Context context, f fVar, boolean z, vp vpVar) {
        x.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
        com.tencent.mm.sdk.b.b kpVar = new kp();
        kpVar.fCH.field_localId = fVar.field_localId;
        if (fVar.field_localId == -1) {
            kpVar.fCH.fCO = 4;
        } else {
            kpVar.fCH.fCJ = fVar.field_xml;
        }
        kpVar.fCH.context = context;
        Bundle bundle = new Bundle();
        vh vhVar = fVar.field_favProto.vJG;
        if (vhVar != null) {
            bundle.putString("noteauthor", vhVar.wlP);
            bundle.putString("noteeditor", vhVar.wlQ);
        }
        bundle.putLong("edittime", fVar.field_updateTime);
        kpVar.fCH.fCM = bundle;
        kpVar.fCH.field_favProto = fVar.field_favProto;
        kpVar.fCH.type = 2;
        kpVar.fCH.fCQ = z;
        kpVar.fCH.fCR = vpVar;
        com.tencent.mm.sdk.b.a.xmy.m(kpVar);
    }

    private static void c(Context context, f fVar, boolean z, vp vpVar) {
        uz p = j.p(fVar);
        if (j.e(p)) {
            if (j.f(p)) {
                d(context, fVar, vpVar);
                return;
            } else if (!com.tencent.mm.pluginsdk.ui.tools.a.a((Activity) context, j.h(p), p.wkc, 2)) {
                return;
            }
        }
        Intent intent = new Intent(context, FavoriteFileDetailUI.class);
        intent.putExtra("key_detail_info_id", fVar.field_localId);
        intent.putExtra("show_share", z);
        intent.putExtra("key_detail_fav_scene", vpVar.scene);
        intent.putExtra("key_detail_fav_sub_scene", vpVar.mtU);
        intent.putExtra("key_detail_fav_index", vpVar.index);
        context.startActivity(intent);
    }

    private static String G(f fVar) {
        if (fVar.field_favProto == null) {
            return null;
        }
        if (fVar.field_favProto.wlf != null && !bi.oN(fVar.field_favProto.wlf.canvasPageXml)) {
            return fVar.field_favProto.wlf.thumbUrl;
        }
        List list = fVar.field_favProto.wlY;
        if (list == null || list.size() != 1) {
            return null;
        }
        return ((uz) list.get(0)).hcU;
    }

    private static void d(Context context, f fVar, boolean z, vp vpVar) {
        String str;
        vt vtVar;
        String str2;
        String str3;
        wc wcVar;
        uz p;
        Intent intent;
        String str4;
        Bundle bundle;
        Bundle bundle2;
        String str5;
        Bundle mS;
        String str6;
        Intent intent2;
        if (fVar.field_favProto != null) {
            if (fVar.field_favProto.wlf == null || bi.oN(fVar.field_favProto.wlf.canvasPageXml)) {
                List list = fVar.field_favProto.wlY;
                if (list != null && list.size() == 1) {
                    str = ((uz) list.get(0)).canvasPageXml;
                    if (bi.oN(str)) {
                        vtVar = fVar.field_favProto.wlW;
                        str = "";
                        str2 = "";
                        str3 = "";
                        if (fVar.field_favProto.wlf != null) {
                            wcVar = fVar.field_favProto.wlf;
                            str = wcVar.wmD;
                            str2 = wcVar.title;
                            str3 = wcVar.desc;
                        }
                        if (vtVar != null && bi.oN(r2)) {
                            str = vtVar.hPT;
                        }
                        if (bi.oN(str)) {
                            p = j.p(fVar);
                            if (p != null) {
                                if (bi.oN(str2)) {
                                    str2 = p.title;
                                }
                                if (bi.oN(str3)) {
                                    str3 = str2;
                                    str2 = p.desc;
                                    x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId));
                                    intent = new Intent();
                                    intent.putExtra("rawUrl", str);
                                    intent.putExtra("showShare", z);
                                    intent.putExtra("is_favorite_item", true);
                                    intent.putExtra("fav_local_id", fVar.field_localId);
                                    str4 = "favorite_control_argument";
                                    bundle = new Bundle();
                                    bundle.putBoolean("key_ctrl_flag_open_chat", fVar.aIq());
                                    bundle.putBoolean("key_ctrl_flag_open_sns", fVar.aIr());
                                    bundle.putBoolean("key_ctrl_flag_open_weibo", (fVar.field_favProto.wlo & 4) == 0);
                                    bundle.putBoolean("key_ctrl_flag_open_cplink", (fVar.field_favProto.wlo & 8) == 0);
                                    bundle.putBoolean("key_ctrl_flag_open_browser", (fVar.field_favProto.wlo & 16) == 0);
                                    bundle.putBoolean("key_ctrl_flag_open_weiyun", (fVar.field_favProto.wlo & 32) == 0);
                                    bundle.putBoolean("key_ctrl_flag_open_facebook", (fVar.field_favProto.wlo & 64) == 0);
                                    x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", bundle.toString());
                                    intent.putExtra(str4, bundle);
                                    intent.putExtra("sentUsername", fVar.field_fromUser);
                                    if (!(vtVar == null || bi.oN(vtVar.foe))) {
                                        intent.putExtra("srcDisplayname", r.gw(vtVar.foe));
                                    }
                                    intent.putExtra("mode", 1);
                                    intent.putExtra("geta8key_scene", 14);
                                    bundle2 = new Bundle();
                                    bundle2.putString("key_snsad_statextstr", j.p(fVar).fHB);
                                    intent.putExtra("jsapiargs", bundle2);
                                    intent.putExtra("from_scence", 4);
                                    str5 = "fav_" + q.FY() + "_" + fVar.field_id;
                                    intent.putExtra("KPublisherId", str5);
                                    intent.putExtra("pre_username", fVar.field_fromUser);
                                    intent.putExtra("prePublishId", str5);
                                    intent.putExtra("preUsername", fVar.field_fromUser);
                                    intent.putExtra("share_report_pre_msg_url", str);
                                    intent.putExtra("share_report_pre_msg_title", str3);
                                    intent.putExtra("share_report_pre_msg_desc", str2);
                                    intent.putExtra("share_report_pre_msg_icon_url", G(fVar));
                                    intent.putExtra("share_report_pre_msg_appid", "");
                                    intent.putExtra("share_report_from_scene", 4);
                                    mS = com.tencent.mm.modelstat.a.b.mS(com.tencent.mm.pluginsdk.model.e.class.getName());
                                    mS.putInt("mm_rpt_fav_id", fVar.field_id);
                                    mS.putInt("key_detail_fav_scene", vpVar.scene);
                                    mS.putInt("key_detail_fav_sub_scene", vpVar.mtU);
                                    mS.putInt("key_detail_fav_index", vpVar.index);
                                    intent.putExtra("mm_report_bundle", mS);
                                    d.j(intent, context);
                                }
                            }
                            str6 = str3;
                            str3 = str2;
                            str2 = str6;
                            x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId));
                            intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("showShare", z);
                            intent.putExtra("is_favorite_item", true);
                            intent.putExtra("fav_local_id", fVar.field_localId);
                            str4 = "favorite_control_argument";
                            bundle = new Bundle();
                            bundle.putBoolean("key_ctrl_flag_open_chat", fVar.aIq());
                            bundle.putBoolean("key_ctrl_flag_open_sns", fVar.aIr());
                            if ((fVar.field_favProto.wlo & 4) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_weibo", (fVar.field_favProto.wlo & 4) == 0);
                            if ((fVar.field_favProto.wlo & 8) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_cplink", (fVar.field_favProto.wlo & 8) == 0);
                            if ((fVar.field_favProto.wlo & 16) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_browser", (fVar.field_favProto.wlo & 16) == 0);
                            if ((fVar.field_favProto.wlo & 32) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_weiyun", (fVar.field_favProto.wlo & 32) == 0);
                            if ((fVar.field_favProto.wlo & 64) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_facebook", (fVar.field_favProto.wlo & 64) == 0);
                            x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", bundle.toString());
                            intent.putExtra(str4, bundle);
                            intent.putExtra("sentUsername", fVar.field_fromUser);
                            intent.putExtra("srcDisplayname", r.gw(vtVar.foe));
                            intent.putExtra("mode", 1);
                            intent.putExtra("geta8key_scene", 14);
                            bundle2 = new Bundle();
                            bundle2.putString("key_snsad_statextstr", j.p(fVar).fHB);
                            intent.putExtra("jsapiargs", bundle2);
                            intent.putExtra("from_scence", 4);
                            str5 = "fav_" + q.FY() + "_" + fVar.field_id;
                            intent.putExtra("KPublisherId", str5);
                            intent.putExtra("pre_username", fVar.field_fromUser);
                            intent.putExtra("prePublishId", str5);
                            intent.putExtra("preUsername", fVar.field_fromUser);
                            intent.putExtra("share_report_pre_msg_url", str);
                            intent.putExtra("share_report_pre_msg_title", str3);
                            intent.putExtra("share_report_pre_msg_desc", str2);
                            intent.putExtra("share_report_pre_msg_icon_url", G(fVar));
                            intent.putExtra("share_report_pre_msg_appid", "");
                            intent.putExtra("share_report_from_scene", 4);
                            mS = com.tencent.mm.modelstat.a.b.mS(com.tencent.mm.pluginsdk.model.e.class.getName());
                            mS.putInt("mm_rpt_fav_id", fVar.field_id);
                            mS.putInt("key_detail_fav_scene", vpVar.scene);
                            mS.putInt("key_detail_fav_sub_scene", vpVar.mtU);
                            mS.putInt("key_detail_fav_index", vpVar.index);
                            intent.putExtra("mm_report_bundle", mS);
                            d.j(intent, context);
                        }
                    }
                    intent2 = new Intent();
                    intent2.putExtra("sns_landing_pages_xml", str);
                    intent2.putExtra("sns_landig_pages_from_source", 7);
                    intent2.putExtra("sns_landing_pages_share_thumb_url", G(fVar));
                    intent2.putExtra("sns_landing_favid", q.FY() + "_" + fVar.field_id);
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    com.tencent.mm.bl.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
                    return;
                }
            }
            str = fVar.field_favProto.wlf.canvasPageXml;
            if (bi.oN(str)) {
                vtVar = fVar.field_favProto.wlW;
                str = "";
                str2 = "";
                str3 = "";
                if (fVar.field_favProto.wlf != null) {
                    wcVar = fVar.field_favProto.wlf;
                    str = wcVar.wmD;
                    str2 = wcVar.title;
                    str3 = wcVar.desc;
                }
                str = vtVar.hPT;
                if (bi.oN(str)) {
                    p = j.p(fVar);
                    if (p != null) {
                        if (bi.oN(str2)) {
                            str2 = p.title;
                        }
                        if (bi.oN(str3)) {
                            str3 = str2;
                            str2 = p.desc;
                            x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId));
                            intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("showShare", z);
                            intent.putExtra("is_favorite_item", true);
                            intent.putExtra("fav_local_id", fVar.field_localId);
                            str4 = "favorite_control_argument";
                            bundle = new Bundle();
                            bundle.putBoolean("key_ctrl_flag_open_chat", fVar.aIq());
                            bundle.putBoolean("key_ctrl_flag_open_sns", fVar.aIr());
                            if ((fVar.field_favProto.wlo & 4) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_weibo", (fVar.field_favProto.wlo & 4) == 0);
                            if ((fVar.field_favProto.wlo & 8) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_cplink", (fVar.field_favProto.wlo & 8) == 0);
                            if ((fVar.field_favProto.wlo & 16) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_browser", (fVar.field_favProto.wlo & 16) == 0);
                            if ((fVar.field_favProto.wlo & 32) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_weiyun", (fVar.field_favProto.wlo & 32) == 0);
                            if ((fVar.field_favProto.wlo & 64) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_facebook", (fVar.field_favProto.wlo & 64) == 0);
                            x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", bundle.toString());
                            intent.putExtra(str4, bundle);
                            intent.putExtra("sentUsername", fVar.field_fromUser);
                            intent.putExtra("srcDisplayname", r.gw(vtVar.foe));
                            intent.putExtra("mode", 1);
                            intent.putExtra("geta8key_scene", 14);
                            bundle2 = new Bundle();
                            bundle2.putString("key_snsad_statextstr", j.p(fVar).fHB);
                            intent.putExtra("jsapiargs", bundle2);
                            intent.putExtra("from_scence", 4);
                            str5 = "fav_" + q.FY() + "_" + fVar.field_id;
                            intent.putExtra("KPublisherId", str5);
                            intent.putExtra("pre_username", fVar.field_fromUser);
                            intent.putExtra("prePublishId", str5);
                            intent.putExtra("preUsername", fVar.field_fromUser);
                            intent.putExtra("share_report_pre_msg_url", str);
                            intent.putExtra("share_report_pre_msg_title", str3);
                            intent.putExtra("share_report_pre_msg_desc", str2);
                            intent.putExtra("share_report_pre_msg_icon_url", G(fVar));
                            intent.putExtra("share_report_pre_msg_appid", "");
                            intent.putExtra("share_report_from_scene", 4);
                            mS = com.tencent.mm.modelstat.a.b.mS(com.tencent.mm.pluginsdk.model.e.class.getName());
                            mS.putInt("mm_rpt_fav_id", fVar.field_id);
                            mS.putInt("key_detail_fav_scene", vpVar.scene);
                            mS.putInt("key_detail_fav_sub_scene", vpVar.mtU);
                            mS.putInt("key_detail_fav_index", vpVar.index);
                            intent.putExtra("mm_report_bundle", mS);
                            d.j(intent, context);
                        }
                    }
                    str6 = str3;
                    str3 = str2;
                    str2 = str6;
                    x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId));
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", z);
                    intent.putExtra("is_favorite_item", true);
                    intent.putExtra("fav_local_id", fVar.field_localId);
                    str4 = "favorite_control_argument";
                    bundle = new Bundle();
                    bundle.putBoolean("key_ctrl_flag_open_chat", fVar.aIq());
                    bundle.putBoolean("key_ctrl_flag_open_sns", fVar.aIr());
                    if ((fVar.field_favProto.wlo & 4) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_weibo", (fVar.field_favProto.wlo & 4) == 0);
                    if ((fVar.field_favProto.wlo & 8) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_cplink", (fVar.field_favProto.wlo & 8) == 0);
                    if ((fVar.field_favProto.wlo & 16) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_browser", (fVar.field_favProto.wlo & 16) == 0);
                    if ((fVar.field_favProto.wlo & 32) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_weiyun", (fVar.field_favProto.wlo & 32) == 0);
                    if ((fVar.field_favProto.wlo & 64) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_facebook", (fVar.field_favProto.wlo & 64) == 0);
                    x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", bundle.toString());
                    intent.putExtra(str4, bundle);
                    intent.putExtra("sentUsername", fVar.field_fromUser);
                    intent.putExtra("srcDisplayname", r.gw(vtVar.foe));
                    intent.putExtra("mode", 1);
                    intent.putExtra("geta8key_scene", 14);
                    bundle2 = new Bundle();
                    bundle2.putString("key_snsad_statextstr", j.p(fVar).fHB);
                    intent.putExtra("jsapiargs", bundle2);
                    intent.putExtra("from_scence", 4);
                    str5 = "fav_" + q.FY() + "_" + fVar.field_id;
                    intent.putExtra("KPublisherId", str5);
                    intent.putExtra("pre_username", fVar.field_fromUser);
                    intent.putExtra("prePublishId", str5);
                    intent.putExtra("preUsername", fVar.field_fromUser);
                    intent.putExtra("share_report_pre_msg_url", str);
                    intent.putExtra("share_report_pre_msg_title", str3);
                    intent.putExtra("share_report_pre_msg_desc", str2);
                    intent.putExtra("share_report_pre_msg_icon_url", G(fVar));
                    intent.putExtra("share_report_pre_msg_appid", "");
                    intent.putExtra("share_report_from_scene", 4);
                    mS = com.tencent.mm.modelstat.a.b.mS(com.tencent.mm.pluginsdk.model.e.class.getName());
                    mS.putInt("mm_rpt_fav_id", fVar.field_id);
                    mS.putInt("key_detail_fav_scene", vpVar.scene);
                    mS.putInt("key_detail_fav_sub_scene", vpVar.mtU);
                    mS.putInt("key_detail_fav_index", vpVar.index);
                    intent.putExtra("mm_report_bundle", mS);
                    d.j(intent, context);
                }
            }
            intent2 = new Intent();
            intent2.putExtra("sns_landing_pages_xml", str);
            intent2.putExtra("sns_landig_pages_from_source", 7);
            intent2.putExtra("sns_landing_pages_share_thumb_url", G(fVar));
            intent2.putExtra("sns_landing_favid", q.FY() + "_" + fVar.field_id);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bl.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
            return;
        }
        str = null;
        if (bi.oN(str)) {
            intent2 = new Intent();
            intent2.putExtra("sns_landing_pages_xml", str);
            intent2.putExtra("sns_landig_pages_from_source", 7);
            intent2.putExtra("sns_landing_pages_share_thumb_url", G(fVar));
            intent2.putExtra("sns_landing_favid", q.FY() + "_" + fVar.field_id);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bl.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
            return;
        }
        vtVar = fVar.field_favProto.wlW;
        str = "";
        str2 = "";
        str3 = "";
        if (fVar.field_favProto.wlf != null) {
            wcVar = fVar.field_favProto.wlf;
            str = wcVar.wmD;
            str2 = wcVar.title;
            str3 = wcVar.desc;
        }
        str = vtVar.hPT;
        if (bi.oN(str)) {
            p = j.p(fVar);
            if (p != null) {
                if (bi.oN(str2)) {
                    str2 = p.title;
                }
                if (bi.oN(str3)) {
                    str3 = str2;
                    str2 = p.desc;
                    x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId));
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", z);
                    intent.putExtra("is_favorite_item", true);
                    intent.putExtra("fav_local_id", fVar.field_localId);
                    str4 = "favorite_control_argument";
                    bundle = new Bundle();
                    bundle.putBoolean("key_ctrl_flag_open_chat", fVar.aIq());
                    bundle.putBoolean("key_ctrl_flag_open_sns", fVar.aIr());
                    if ((fVar.field_favProto.wlo & 4) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_weibo", (fVar.field_favProto.wlo & 4) == 0);
                    if ((fVar.field_favProto.wlo & 8) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_cplink", (fVar.field_favProto.wlo & 8) == 0);
                    if ((fVar.field_favProto.wlo & 16) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_browser", (fVar.field_favProto.wlo & 16) == 0);
                    if ((fVar.field_favProto.wlo & 32) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_weiyun", (fVar.field_favProto.wlo & 32) == 0);
                    if ((fVar.field_favProto.wlo & 64) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_facebook", (fVar.field_favProto.wlo & 64) == 0);
                    x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", bundle.toString());
                    intent.putExtra(str4, bundle);
                    intent.putExtra("sentUsername", fVar.field_fromUser);
                    intent.putExtra("srcDisplayname", r.gw(vtVar.foe));
                    intent.putExtra("mode", 1);
                    intent.putExtra("geta8key_scene", 14);
                    bundle2 = new Bundle();
                    bundle2.putString("key_snsad_statextstr", j.p(fVar).fHB);
                    intent.putExtra("jsapiargs", bundle2);
                    intent.putExtra("from_scence", 4);
                    str5 = "fav_" + q.FY() + "_" + fVar.field_id;
                    intent.putExtra("KPublisherId", str5);
                    intent.putExtra("pre_username", fVar.field_fromUser);
                    intent.putExtra("prePublishId", str5);
                    intent.putExtra("preUsername", fVar.field_fromUser);
                    intent.putExtra("share_report_pre_msg_url", str);
                    intent.putExtra("share_report_pre_msg_title", str3);
                    intent.putExtra("share_report_pre_msg_desc", str2);
                    intent.putExtra("share_report_pre_msg_icon_url", G(fVar));
                    intent.putExtra("share_report_pre_msg_appid", "");
                    intent.putExtra("share_report_from_scene", 4);
                    mS = com.tencent.mm.modelstat.a.b.mS(com.tencent.mm.pluginsdk.model.e.class.getName());
                    mS.putInt("mm_rpt_fav_id", fVar.field_id);
                    mS.putInt("key_detail_fav_scene", vpVar.scene);
                    mS.putInt("key_detail_fav_sub_scene", vpVar.mtU);
                    mS.putInt("key_detail_fav_index", vpVar.index);
                    intent.putExtra("mm_report_bundle", mS);
                    d.j(intent, context);
                }
            }
            str6 = str3;
            str3 = str2;
            str2 = str6;
            x.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId));
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", z);
            intent.putExtra("is_favorite_item", true);
            intent.putExtra("fav_local_id", fVar.field_localId);
            str4 = "favorite_control_argument";
            bundle = new Bundle();
            bundle.putBoolean("key_ctrl_flag_open_chat", fVar.aIq());
            bundle.putBoolean("key_ctrl_flag_open_sns", fVar.aIr());
            if ((fVar.field_favProto.wlo & 4) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_weibo", (fVar.field_favProto.wlo & 4) == 0);
            if ((fVar.field_favProto.wlo & 8) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_cplink", (fVar.field_favProto.wlo & 8) == 0);
            if ((fVar.field_favProto.wlo & 16) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_browser", (fVar.field_favProto.wlo & 16) == 0);
            if ((fVar.field_favProto.wlo & 32) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_weiyun", (fVar.field_favProto.wlo & 32) == 0);
            if ((fVar.field_favProto.wlo & 64) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_facebook", (fVar.field_favProto.wlo & 64) == 0);
            x.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", bundle.toString());
            intent.putExtra(str4, bundle);
            intent.putExtra("sentUsername", fVar.field_fromUser);
            intent.putExtra("srcDisplayname", r.gw(vtVar.foe));
            intent.putExtra("mode", 1);
            intent.putExtra("geta8key_scene", 14);
            bundle2 = new Bundle();
            bundle2.putString("key_snsad_statextstr", j.p(fVar).fHB);
            intent.putExtra("jsapiargs", bundle2);
            intent.putExtra("from_scence", 4);
            str5 = "fav_" + q.FY() + "_" + fVar.field_id;
            intent.putExtra("KPublisherId", str5);
            intent.putExtra("pre_username", fVar.field_fromUser);
            intent.putExtra("prePublishId", str5);
            intent.putExtra("preUsername", fVar.field_fromUser);
            intent.putExtra("share_report_pre_msg_url", str);
            intent.putExtra("share_report_pre_msg_title", str3);
            intent.putExtra("share_report_pre_msg_desc", str2);
            intent.putExtra("share_report_pre_msg_icon_url", G(fVar));
            intent.putExtra("share_report_pre_msg_appid", "");
            intent.putExtra("share_report_from_scene", 4);
            mS = com.tencent.mm.modelstat.a.b.mS(com.tencent.mm.pluginsdk.model.e.class.getName());
            mS.putInt("mm_rpt_fav_id", fVar.field_id);
            mS.putInt("key_detail_fav_scene", vpVar.scene);
            mS.putInt("key_detail_fav_sub_scene", vpVar.mtU);
            mS.putInt("key_detail_fav_index", vpVar.index);
            intent.putExtra("mm_report_bundle", mS);
            d.j(intent, context);
        }
    }

    private static void b(Context context, f fVar, vp vpVar) {
        h.a(h.a.PlayIcon, fVar);
        Intent intent = new Intent(context, FavoriteSightDetailUI.class);
        intent.putExtra("key_detail_info_id", fVar.field_localId);
        intent.putExtra("key_detail_fav_scene", vpVar.scene);
        intent.putExtra("key_detail_fav_sub_scene", vpVar.mtU);
        intent.putExtra("key_detail_fav_index", vpVar.index);
        context.startActivity(intent);
    }

    private static void c(Context context, f fVar, vp vpVar) {
        boolean z;
        uz p = j.p(fVar);
        vc vcVar = p.wkN;
        if (vcVar == null || bi.oN(vcVar.heZ)) {
            z = false;
        } else {
            h.a(h.a.EnterCompleteVideo, fVar);
            String i = j.i(p);
            Intent intent = new Intent();
            intent.putExtra("IsAd", false);
            intent.putExtra("KStremVideoUrl", vcVar.heZ);
            intent.putExtra("StreamWording", vcVar.hfc);
            intent.putExtra("StremWebUrl", vcVar.hfd);
            intent.putExtra("KThumUrl", vcVar.hfe);
            intent.putExtra("KSta_StremVideoAduxInfo", vcVar.hff);
            intent.putExtra("KSta_StremVideoPublishId", vcVar.hfg);
            intent.putExtra("KSta_SourceType", 2);
            intent.putExtra("KSta_Scene", h.b.Fav.value);
            intent.putExtra("KSta_FromUserName", fVar.field_fromUser);
            intent.putExtra("KSta_FavID", fVar.field_id);
            intent.putExtra("KSta_SnsStatExtStr", p.fHB);
            intent.putExtra("KBlockFav", true);
            intent.putExtra("KMediaId", "fakeid_" + fVar.field_id);
            intent.putExtra("KThumbPath", i);
            intent.putExtra("KMediaVideoTime", vcVar.wlG);
            intent.putExtra("KMediaTitle", vcVar.hfb);
            com.tencent.mm.bl.d.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
            z = true;
        }
        if (!z) {
            if (bi.oN(p.wke) || p.wki <= 0) {
                x.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", p.wke, Long.valueOf(p.wki));
                String str = j.p(fVar).wjU;
                if (bi.oN(str)) {
                    str = j.p(fVar).wjY;
                }
                if (bi.oN(str)) {
                    x.w("MicroMsg.FavItemLogic", "onClick video url null, return");
                    b(context, fVar, vpVar);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("is_favorite_item", true);
                intent2.putExtra("fav_local_id", fVar.field_localId);
                intent2.putExtra("geta8key_scene", 14);
                x.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId));
                d.j(intent2, context);
                return;
            }
            Intent intent3 = new Intent(context, FavoriteSightDetailUI.class);
            intent3.putExtra("key_detail_fav_scene", vpVar.scene);
            intent3.putExtra("key_detail_fav_sub_scene", vpVar.mtU);
            intent3.putExtra("key_detail_fav_index", vpVar.index);
            intent3.putExtra("key_detail_info_id", fVar.field_localId);
            context.startActivity(intent3);
        }
    }

    public static void d(Context context, f fVar, vp vpVar) {
        Intent intent = new Intent(context, FavoriteImgDetailUI.class);
        intent.putExtra("key_detail_fav_scene", vpVar.scene);
        intent.putExtra("key_detail_fav_sub_scene", vpVar.mtU);
        intent.putExtra("key_detail_fav_index", vpVar.index);
        intent.putExtra("key_detail_info_id", fVar.field_localId);
        context.startActivity(intent);
    }

    public static String[] a(final f fVar, ag agVar) {
        String str = null;
        if (fVar == null) {
            x.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
            return null;
        }
        final uz p = j.p(fVar);
        String[] strArr = new String[2];
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                j.b(fVar, p, true);
            }
        };
        vm vmVar;
        switch (fVar.field_type) {
            case 5:
                wc wcVar = fVar.field_favProto.wlf;
                if (p == null) {
                    if (wcVar != null) {
                        strArr[1] = wcVar.thumbUrl;
                        break;
                    }
                }
                String str2 = wcVar == null ? null : wcVar.thumbUrl;
                if (bi.oN(str2)) {
                    str2 = p.fra;
                }
                strArr[0] = j.i(p);
                strArr[1] = str2;
                agVar.post(anonymousClass1);
                break;
                break;
            case 10:
                vmVar = fVar.field_favProto.wlh;
                if (vmVar != null) {
                    strArr[1] = vmVar.thumbUrl;
                    break;
                }
                break;
            case 11:
                vmVar = fVar.field_favProto.wlh;
                if (vmVar != null) {
                    strArr[1] = vmVar.thumbUrl;
                    break;
                }
                break;
            case 14:
            case 18:
                if (fVar.field_favProto.wlY != null) {
                    Iterator it = fVar.field_favProto.wlY.iterator();
                    while (it.hasNext()) {
                        uz uzVar = (uz) it.next();
                        if (uzVar.bjS == 2) {
                            str = j.h(uzVar);
                            agVar.post(anonymousClass1);
                        } else if (uzVar.bjS == 15) {
                            str = j.i(uzVar);
                            agVar.post(anonymousClass1);
                        }
                        strArr[0] = str;
                    }
                    strArr[0] = str;
                }
                strArr[1] = p.fra;
                break;
            case 15:
                vw vwVar = fVar.field_favProto.wlj;
                if (vwVar != null) {
                    strArr[1] = vwVar.thumbUrl;
                    break;
                }
                break;
            default:
                if (p != null) {
                    strArr[0] = j.i(p);
                    strArr[1] = p.fra;
                    agVar.post(anonymousClass1);
                    break;
                }
                break;
        }
        x.d("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", strArr[0], strArr[1], Integer.valueOf(fVar.field_type));
        return strArr;
    }

    public static void a(com.tencent.mm.pluginsdk.ui.applet.e.a aVar, final Context context, final f fVar) {
        String str = null;
        if (fVar == null || context == null) {
            x.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
            return;
        }
        String absolutePath;
        wc wcVar;
        uz p = j.p(fVar);
        if (fVar == null) {
            x.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
        } else {
            uz p2 = j.p(fVar);
            File file;
            if (5 == fVar.field_type) {
                file = new File(j.i(p2));
                if (file.exists()) {
                    absolutePath = file.getAbsolutePath();
                } else {
                    wc wcVar2 = fVar.field_favProto.wlf;
                    absolutePath = wcVar2 == null ? null : wcVar2.thumbUrl;
                    if (bi.oN(absolutePath)) {
                        absolutePath = p2.fra;
                    }
                    absolutePath = j.AF(absolutePath);
                    if (bi.oN(absolutePath)) {
                        absolutePath = Integer.valueOf(R.k.dvO);
                    }
                }
            } else {
                if (11 == fVar.field_type || 10 == fVar.field_type) {
                    vm vmVar = fVar.field_favProto.wlh;
                    if (vmVar != null) {
                        absolutePath = j.AF(vmVar.thumbUrl);
                        if (bi.oN(absolutePath)) {
                            absolutePath = Integer.valueOf(R.k.dvI);
                        }
                    }
                }
                if (15 == fVar.field_type || 12 == fVar.field_type) {
                    vw vwVar = fVar.field_favProto.wlj;
                    if (vwVar != null) {
                        absolutePath = j.AF(vwVar.thumbUrl);
                        if (bi.oN(absolutePath)) {
                            absolutePath = Integer.valueOf(R.k.dvI);
                        }
                    }
                }
                if (2 == fVar.field_type || 7 == fVar.field_type || 16 == fVar.field_type || 4 == fVar.field_type) {
                    file = new File(j.i(p2));
                    if (!file.exists()) {
                        absolutePath = j.AF(p2.fra);
                        if (bi.oN(absolutePath)) {
                            j.b(fVar, p2, true);
                            absolutePath = j.i(p2);
                        }
                        if (bi.oN(absolutePath)) {
                            switch (fVar.field_type) {
                                case 2:
                                    absolutePath = Integer.valueOf(R.g.byW);
                                    break;
                                case 7:
                                    absolutePath = Integer.valueOf(R.k.dvy);
                                    break;
                                default:
                                    absolutePath = Integer.valueOf(R.k.dvL);
                                    break;
                            }
                        }
                    }
                    absolutePath = file.getAbsolutePath();
                } else if (!(3 == fVar.field_type || 6 == fVar.field_type)) {
                    au.a Fq;
                    if (8 == fVar.field_type) {
                        absolutePath = Integer.valueOf(com.tencent.mm.pluginsdk.c.RI(p2.wkc));
                    } else if (17 == fVar.field_type) {
                        as.Hm();
                        Fq = c.Fh().Fq(p2.desc);
                        absolutePath = (Fq.sfb == null || Fq.sfb.length() == 0) ? Integer.valueOf(R.g.bBC) : new SpannableString(Fq.sfb);
                    } else if (14 == fVar.field_type && fVar.field_favProto.wlY != null) {
                        Iterator it = fVar.field_favProto.wlY.iterator();
                        while (it.hasNext()) {
                            uz uzVar = (uz) it.next();
                            if (uzVar.bjS != 1) {
                                String AF;
                                if (uzVar.bjS == 3) {
                                    absolutePath = Integer.valueOf(R.k.dvN);
                                    break;
                                } else if (uzVar.bjS == 6) {
                                    absolutePath = Integer.valueOf(R.k.dvx);
                                    break;
                                } else if (uzVar.bjS == 8) {
                                    absolutePath = Integer.valueOf(com.tencent.mm.pluginsdk.c.RI(uzVar.wkc));
                                    break;
                                } else if (uzVar.bjS == 2 || uzVar.bjS == 7 || uzVar.bjS == 15 || uzVar.bjS == 4) {
                                    file = new File(j.i(uzVar));
                                    if (file.exists()) {
                                        absolutePath = file.getAbsolutePath();
                                    } else {
                                        AF = j.AF(uzVar.fra);
                                        if (bi.oN(AF)) {
                                            switch (uzVar.bjS) {
                                                case 2:
                                                    absolutePath = Integer.valueOf(R.g.byW);
                                                    break;
                                                case 7:
                                                    absolutePath = Integer.valueOf(R.k.dvy);
                                                    break;
                                                default:
                                                    absolutePath = Integer.valueOf(R.k.dvL);
                                                    break;
                                            }
                                        }
                                        absolutePath = AF;
                                    }
                                } else if (uzVar.bjS == 5) {
                                    file = new File(j.i(uzVar));
                                    if (file.exists()) {
                                        absolutePath = file.getAbsolutePath();
                                    } else {
                                        wcVar = uzVar.wkH.wlf;
                                        AF = wcVar == null ? null : wcVar.thumbUrl;
                                        if (bi.oN(AF)) {
                                            AF = uzVar.fra;
                                        }
                                        absolutePath = j.AF(AF);
                                        if (bi.oN(absolutePath)) {
                                            absolutePath = Integer.valueOf(R.k.dvO);
                                        }
                                    }
                                } else {
                                    if (uzVar.bjS == 10 || uzVar.bjS == 11) {
                                        vm vmVar2 = uzVar.wkH.wlh;
                                        if (vmVar2 != null) {
                                            absolutePath = j.AF(vmVar2.thumbUrl);
                                            if (bi.oN(absolutePath)) {
                                                absolutePath = Integer.valueOf(R.k.dvI);
                                            }
                                        }
                                    }
                                    if (uzVar.bjS == 12 || uzVar.bjS == 14) {
                                        vw vwVar2 = uzVar.wkH.wlj;
                                        if (vwVar2 != null) {
                                            absolutePath = j.AF(vwVar2.thumbUrl);
                                            if (bi.oN(absolutePath)) {
                                                absolutePath = Integer.valueOf(R.k.dvI);
                                            }
                                        }
                                    }
                                    if (uzVar.bjS == 16) {
                                        as.Hm();
                                        Fq = c.Fh().Fq(uzVar.desc);
                                        absolutePath = (Fq.sfb == null || Fq.sfb.length() == 0) ? Integer.valueOf(R.g.bBC) : new SpannableString(Fq.sfb);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (absolutePath instanceof String) {
                if (absolutePath instanceof Integer) {
                    ((Integer) absolutePath).intValue();
                }
                absolutePath = null;
            } else {
                absolutePath = absolutePath;
            }
            wcVar = fVar.field_favProto.wlf;
            switch (fVar.field_type) {
                case 1:
                    aVar.SU(fVar.field_favProto.desc);
                    aVar.cbE();
                    aVar.a(new i.a.a() {
                        public final void aKs() {
                            Intent intent = new Intent();
                            intent.putExtra("Retr_Msg_content", fVar.field_favProto.desc);
                            com.tencent.mm.bl.d.a(context, ".ui.transmit.RetransmitPreviewUI", intent);
                            com.tencent.mm.ui.base.b.fG(context);
                        }
                    });
                    return;
                case 2:
                    aVar.a(com.tencent.mm.sdk.platformtools.d.Vs(absolutePath), 3);
                    return;
                case 4:
                    aVar.a(com.tencent.mm.sdk.platformtools.d.Vs(absolutePath), 2);
                    return;
                case 5:
                    if (wcVar != null || bi.oN(wcVar.title)) {
                        absolutePath = null;
                    } else {
                        absolutePath = wcVar.title;
                        str = wcVar.desc;
                    }
                    if (bi.oN(absolutePath)) {
                        absolutePath = p.title;
                    }
                    if (bi.oN(str)) {
                        str = p.desc;
                    }
                    aVar.SU(new StringBuffer(context.getResources().getString(R.l.dHf)).append(absolutePath).toString());
                    return;
                case 6:
                    aVar.SU(context.getString(R.l.dFK) + fVar.field_favProto.wld.label);
                    return;
                case 7:
                    if (!(wcVar == null || bi.oN(wcVar.title))) {
                        str = wcVar.title;
                    }
                    if (bi.oN(str)) {
                        str = p.title;
                    }
                    aVar.SU(new StringBuffer(context.getResources().getString(R.l.dFU)).append(str).toString());
                    return;
                case 8:
                    absolutePath = fVar.field_favProto.title;
                    if (bi.oN(absolutePath)) {
                        absolutePath = p.title;
                    }
                    aVar.SU(new StringBuffer(context.getResources().getString(R.l.dFu)).append(absolutePath).toString());
                    return;
                case 14:
                    aVar.SU(new StringBuffer(context.getResources().getString(R.l.dGD)).append(com.tencent.mm.plugin.favorite.a.e.a.a(context, fVar).title).toString());
                    return;
                case 16:
                    aVar.a(com.tencent.mm.sdk.platformtools.d.Vs(absolutePath), 2);
                    return;
                case 18:
                    aVar.SU(new StringBuffer(context.getResources().getString(R.l.dGe)).append(com.tencent.mm.plugin.favorite.a.e.a.a(context, fVar).desc.replaceAll("\n", " ")).toString());
                    return;
                default:
                    if (!(wcVar == null || bi.oN(wcVar.title))) {
                        str = wcVar.title;
                    }
                    if (bi.oN(str)) {
                        str = p.title;
                    }
                    aVar.SU(new StringBuffer(context.getResources().getString(R.l.dDY)).append(str).toString());
                    return;
            }
        }
        absolutePath = null;
        if (absolutePath instanceof String) {
            if (absolutePath instanceof Integer) {
                ((Integer) absolutePath).intValue();
            }
            absolutePath = null;
        } else {
            absolutePath = absolutePath;
        }
        wcVar = fVar.field_favProto.wlf;
        switch (fVar.field_type) {
            case 1:
                aVar.SU(fVar.field_favProto.desc);
                aVar.cbE();
                aVar.a(/* anonymous class already generated */);
                return;
            case 2:
                aVar.a(com.tencent.mm.sdk.platformtools.d.Vs(absolutePath), 3);
                return;
            case 4:
                aVar.a(com.tencent.mm.sdk.platformtools.d.Vs(absolutePath), 2);
                return;
            case 5:
                if (wcVar != null) {
                    break;
                }
                absolutePath = null;
                if (bi.oN(absolutePath)) {
                    absolutePath = p.title;
                }
                if (bi.oN(str)) {
                    str = p.desc;
                }
                aVar.SU(new StringBuffer(context.getResources().getString(R.l.dHf)).append(absolutePath).toString());
                return;
            case 6:
                aVar.SU(context.getString(R.l.dFK) + fVar.field_favProto.wld.label);
                return;
            case 7:
                str = wcVar.title;
                if (bi.oN(str)) {
                    str = p.title;
                }
                aVar.SU(new StringBuffer(context.getResources().getString(R.l.dFU)).append(str).toString());
                return;
            case 8:
                absolutePath = fVar.field_favProto.title;
                if (bi.oN(absolutePath)) {
                    absolutePath = p.title;
                }
                aVar.SU(new StringBuffer(context.getResources().getString(R.l.dFu)).append(absolutePath).toString());
                return;
            case 14:
                aVar.SU(new StringBuffer(context.getResources().getString(R.l.dGD)).append(com.tencent.mm.plugin.favorite.a.e.a.a(context, fVar).title).toString());
                return;
            case 16:
                aVar.a(com.tencent.mm.sdk.platformtools.d.Vs(absolutePath), 2);
                return;
            case 18:
                aVar.SU(new StringBuffer(context.getResources().getString(R.l.dGe)).append(com.tencent.mm.plugin.favorite.a.e.a.a(context, fVar).desc.replaceAll("\n", " ")).toString());
                return;
            default:
                str = wcVar.title;
                if (bi.oN(str)) {
                    str = p.title;
                }
                aVar.SU(new StringBuffer(context.getResources().getString(R.l.dDY)).append(str).toString());
                return;
        }
    }

    public static void b(com.tencent.mm.pluginsdk.ui.applet.e.a aVar, final Context context, final f fVar) {
        if (fVar == null || context == null) {
            x.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
            return;
        }
        final uz p = j.p(fVar);
        switch (fVar.field_type) {
            case 1:
                aVar.a(new i.a.a() {
                    public final void aKs() {
                        Intent intent = new Intent();
                        intent.putExtra("Retr_Msg_content", fVar.field_favProto.desc);
                        com.tencent.mm.bl.d.a(context, ".ui.transmit.RetransmitPreviewUI", intent);
                        com.tencent.mm.ui.base.b.fG(context);
                    }
                });
                return;
            case 2:
                aVar.a(new i.a.a() {
                    public final void aKs() {
                        Intent intent = new Intent(context, FavImgGalleryUI.class);
                        intent.putExtra("key_detail_info_id", fVar.field_localId);
                        intent.putExtra("key_detail_data_id", p.mBr);
                        intent.putExtra("show_share", false);
                        context.startActivity(intent);
                    }
                });
                return;
            case 4:
            case 16:
                aVar.a(new i.a.a() {
                    public final void aKs() {
                        uz p = j.p(fVar);
                        Intent intent;
                        if (p == null) {
                            x.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
                        } else if (p.wkN == null || (bi.oN(p.wkN.heZ) && bi.oN(p.wkN.hfd))) {
                            intent = new Intent(context, FavoriteVideoPlayUI.class);
                            intent.putExtra("key_detail_fav_path", j.h(p));
                            intent.putExtra("key_detail_fav_thumb_path", j.i(p));
                            intent.putExtra("key_detail_fav_video_duration", p.duration);
                            intent.putExtra("key_detail_statExtStr", p.fHB);
                            intent.putExtra("show_share", false);
                            context.startActivity(intent);
                        } else {
                            x.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
                            intent = new Intent(context, FavoriteFileDetailUI.class);
                            intent.putExtra("key_detail_info_id", fVar.field_localId);
                            intent.putExtra("key_detail_data_id", p.mBr);
                            intent.putExtra("key_detail_can_delete", false);
                            context.startActivity(intent);
                        }
                    }
                });
                return;
            case 5:
                aVar.a(new i.a.a() {
                    public final void aKs() {
                        e.d(context, fVar, false, new vp());
                    }
                });
                return;
            case 6:
                final vg vgVar = fVar.field_favProto.wld;
                aVar.a(new i.a.a() {
                    public final void aKs() {
                        Intent intent = new Intent();
                        intent.putExtra("map_view_type", 1);
                        intent.putExtra("kwebmap_slat", vgVar.lat);
                        intent.putExtra("kwebmap_lng", vgVar.lng);
                        intent.putExtra("Kwebmap_locaion", vgVar.label);
                        intent.putExtra("kShowshare", false);
                        com.tencent.mm.bl.d.b(context, "location", ".ui.RedirectUI", intent);
                    }
                });
                return;
            case 8:
                aVar.a(new i.a.a() {
                    public final void aKs() {
                        e.c(context, fVar, false, new vp());
                    }
                });
                return;
            case 14:
                aVar.a(new i.a.a() {
                    public final void aKs() {
                        e.a(context, fVar, false, new vp());
                    }
                });
                return;
            case 18:
                aVar.a(new i.a.a() {
                    public final void aKs() {
                        e.b(context, fVar, false, new vp());
                    }
                });
                return;
            default:
                return;
        }
    }
}
