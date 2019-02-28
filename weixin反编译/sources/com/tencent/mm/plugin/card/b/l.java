package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.c.bjs;
import com.tencent.mm.protocal.c.lb;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.x.g.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class l {
    private static SimpleDateFormat ldn = null;
    private static SimpleDateFormat ldo = null;
    private static SimpleDateFormat ldp = null;

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    public static int xu(String str) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            x.e("MicroMsg.CardUtil", "string format error");
            return rgb;
        }
        try {
            String toUpperCase = str.substring(1).toUpperCase();
            return Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
        } catch (Exception e) {
            x.e("MicroMsg.CardUtil", e.toString());
            return rgb;
        }
    }

    public static int bc(String str, int i) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            x.e("MicroMsg.CardUtil", "string format error");
            return rgb;
        }
        try {
            String toUpperCase = str.substring(1).toUpperCase();
            return Color.argb(i, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
        } catch (Exception e) {
            x.e("MicroMsg.CardUtil", e.toString());
            return rgb;
        }
    }

    public static ShapeDrawable z(Context context, int i) {
        return cm(i, context.getResources().getDimensionPixelOffset(R.f.bwh));
    }

    public static ShapeDrawable cm(int i, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static ShapeDrawable d(Context context, int i, int i2) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvM);
        float[] fArr = new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2};
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, new RectF((float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize, (float) dimensionPixelSize), fArr));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i);
        paint.setStrokeWidth((float) dimensionPixelSize);
        return shapeDrawable;
    }

    public static List<b> ao(List<lb> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<b> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            lb lbVar = (lb) list.get(i);
            b bVar = new b();
            bVar.title = lbVar.title;
            bVar.kPB = lbVar.kPB;
            bVar.kTd = lbVar.kTd;
            bVar.url = lbVar.url;
            bVar.vZQ = lbVar.vZQ;
            bVar.kPM = false;
            bVar.vZR = lbVar.vZR;
            bVar.vZS = lbVar.vZS;
            bVar.pfi = lbVar.pfi;
            bVar.vYB = lbVar.vYB;
            bVar.vYC = lbVar.vYC;
            bVar.kPL = 1;
            arrayList.add(bVar);
        }
        return arrayList;
    }

    public static String bq(long j) {
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (ldn == null) {
            ldn = new SimpleDateFormat("yyyy.MM.dd");
        }
        return ldn.format(new Date(j2));
    }

    public static boolean xv(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static Bitmap t(Bitmap bitmap) {
        boolean z = true;
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        String str = "MicroMsg.CardUtil";
        StringBuilder stringBuilder = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        x.d(str, stringBuilder.append(z).append("  degree:90.0").toString());
        return createBitmap;
    }

    public static void u(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            x.i("MicroMsg.CardUtil", "bitmap recycle %s", bitmap);
            bitmap.recycle();
        }
    }

    public static boolean b(CardInfo cardInfo) {
        if (cardInfo == null) {
            x.e("MicroMsg.CardUtil", "processCardObject fail, card is null");
            return false;
        }
        CardInfo wL = am.avh().wL(cardInfo.field_card_id);
        if (wL == null) {
            boolean b = am.avh().b((c) cardInfo);
            x.d("MicroMsg.CardUtil", "processCardObject, insertRet = %b", Boolean.valueOf(b));
            if (!b) {
                x.e("MicroMsg.CardUtil", "processCardObject, insert fail");
            }
            return b;
        }
        cardInfo.field_stickyIndex = wL.field_stickyIndex;
        cardInfo.field_stickyEndTime = wL.field_stickyEndTime;
        cardInfo.field_stickyAnnouncement = wL.field_stickyAnnouncement;
        x.d("MicroMsg.CardUtil", "processCardObject, updateRet = %b", Boolean.valueOf(am.avh().c(cardInfo, new String[0])));
        return am.avh().c(cardInfo, new String[0]);
    }

    public static void a(com.tencent.mm.plugin.card.base.b bVar, String str, String str2, int i) {
        byte[] Q;
        a aVar;
        Bitmap a = j.a(new m(bVar.aui().kPA));
        if (a != null) {
            Q = d.Q(a);
        } else {
            Q = null;
        }
        if (bVar == null) {
            aVar = null;
        } else {
            int i2;
            if (i == 23) {
                i = 2;
                i2 = 1;
            } else {
                i2 = 0;
            }
            StringBuilder stringBuilder = new StringBuilder();
            a aVar2 = new a();
            if (bVar.aui() != null) {
                aVar2.title = bVar.auk().wTA;
                aVar2.description = bVar.aui().title;
                aVar2.type = 16;
                aVar2.showType = 0;
                aVar2.hcP = 3;
                aVar2.appId = bVar.aui().fGh;
                aVar2.hdf = 0;
                aVar2.thumburl = bVar.aui().kPA;
                aVar2.hdW = i;
                aVar2.hdV = bVar.aui().kQL;
                aVar2.url = bVar.aui().vYS;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("<from_username>").append(bVar.auo()).append("</from_username>");
            if (oq(i)) {
                stringBuilder2.append("<card_id>").append(bVar.aun()).append("</card_id>");
            } else if (i == 5) {
                stringBuilder2.append("<card_id>").append(bVar.aum()).append("</card_id>");
            }
            stringBuilder2.append("<card_type>").append(bVar.aui().kPz).append("</card_type>");
            stringBuilder2.append("<from_scene>").append(i).append("</from_scene>");
            stringBuilder2.append("<color>").append(bVar.aui().hdx).append("</color>");
            stringBuilder2.append("<card_type_name>").append(bVar.aui().kQK).append("</card_type_name>");
            stringBuilder2.append("<brand_name>").append(bVar.aui().kQL).append("</brand_name>");
            if (TextUtils.isEmpty(str2)) {
                stringBuilder2.append("<card_ext></card_ext>");
            } else {
                stringBuilder2.append("<card_ext>").append(str2).append("</card_ext>");
            }
            stringBuilder2.append("<is_recommend>").append(i2).append("</is_recommend>");
            stringBuilder2.append("<recommend_card_id>").append(bVar.aum()).append("</recommend_card_id>");
            aVar2.hdU = stringBuilder.append(stringBuilder2.toString()).toString();
            aVar2.fzn = a.a(aVar2, null, null);
            aVar = aVar2;
        }
        com.tencent.mm.pluginsdk.model.app.l.a(aVar, bVar.aui().fGh, bVar.aui().kQL, str, null, Q);
    }

    public static void cg(String str, String str2) {
        if (!bi.oN(str)) {
            com.tencent.mm.sdk.b.b otVar = new ot();
            otVar.fHD.fHE = str2;
            otVar.fHD.content = str;
            otVar.fHD.type = s.hs(str2);
            otVar.fHD.flags = 0;
            com.tencent.mm.sdk.b.a.xmy.m(otVar);
        }
    }

    public static boolean oq(int i) {
        return i == 0 || i == 1 || i == 2 || i == 9 || i == 12 || i == 17 || i == 21;
    }

    public static boolean or(int i) {
        return i == 7 || i == 8 || i == 16 || i == 26;
    }

    public static boolean os(int i) {
        return i == 3 || i == 4 || i == 5 || i == 15;
    }

    public static boolean nY(int i) {
        switch (i) {
            case 0:
            case 10:
            case 11:
            case 20:
            case 30:
                return true;
            default:
                return false;
        }
    }

    public static void axL() {
        as.Hm();
        Integer num = (Integer) com.tencent.mm.y.c.Db().get(282883, null);
        if (num == null || num.intValue() != 1) {
            x.i("MicroMsg.CardUtil", "open card entrance");
            as.Hm();
            com.tencent.mm.y.c.Db().set(282883, Integer.valueOf(1));
            com.tencent.mm.r.c.Bx().o(262152, true);
            return;
        }
        x.i("MicroMsg.CardUtil", "card entrance is open");
    }

    public static boolean axM() {
        as.Hm();
        Integer num = (Integer) com.tencent.mm.y.c.Db().get(282883, null);
        if (num == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public static void axN() {
        as.Hm();
        Integer num = (Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, Integer.valueOf(0));
        if (num == null || num.intValue() != 1) {
            x.i("MicroMsg.CardUtil", "open share card entrance");
            as.Hm();
            com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, Integer.valueOf(1));
            com.tencent.mm.r.c.Bx().o(262152, true);
            return;
        }
        x.i("MicroMsg.CardUtil", "share card entrance is open");
    }

    public static boolean axO() {
        as.Hm();
        Integer num = (Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_CARD_IS_SHARE_CARD_ENTRANCE_OPEN_INT_SYNC, null);
        if (num == null || num.intValue() != 1) {
            return false;
        }
        return true;
    }

    public static String f(Context context, float f) {
        if (f <= 0.0f) {
            return "";
        }
        if (f > 0.0f && f < 1000.0f) {
            return context.getString(R.l.dOm, new Object[]{((int) f)});
        } else if (f < 1000.0f) {
            return "";
        } else {
            int i = R.l.dOl;
            Object[] objArr = new Object[1];
            objArr[0] = new DecimalFormat("0.00").format((double) (f / 1000.0f));
            return context.getString(i, objArr);
        }
    }

    public static boolean OW() {
        try {
            return ((LocationManager) ad.getContext().getSystemService("location")).isProviderEnabled("gps");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardUtil", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean OX() {
        try {
            return ((LocationManager) ad.getContext().getSystemService("location")).isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardUtil", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean a(ShareCardInfo shareCardInfo) {
        if (shareCardInfo == null) {
            x.e("MicroMsg.CardUtil", "processShareCardObject fail, card is null");
            return false;
        }
        ShareCardInfo xb = am.avp().xb(shareCardInfo.field_card_id);
        if (xb == null) {
            boolean b = am.avp().b((c) shareCardInfo);
            x.d("MicroMsg.CardUtil", "processShareCardObject, insertRet = %b", Boolean.valueOf(b));
            if (b) {
                com.tencent.mm.plugin.card.sharecard.a.b.bY(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
            } else {
                x.e("MicroMsg.CardUtil", "processShareCardObject, insert fail");
            }
            return b;
        }
        shareCardInfo.field_categoryType = xb.field_categoryType;
        shareCardInfo.field_itemIndex = xb.field_itemIndex;
        x.d("MicroMsg.CardUtil", "processShareCardObject, updateRet = %b", Boolean.valueOf(am.avp().c(shareCardInfo, new String[0])));
        return am.avp().c(shareCardInfo, new String[0]);
    }

    public static boolean j(com.tencent.mm.plugin.card.base.b bVar) {
        boolean c;
        if (bVar instanceof CardInfo) {
            c = am.avh().c((CardInfo) bVar, new String[0]);
            if (c) {
                return c;
            }
            x.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", bVar.aum());
            return c;
        } else if (!(bVar instanceof ShareCardInfo)) {
            return false;
        } else {
            c = am.avp().c((ShareCardInfo) bVar, new String[0]);
            if (c) {
                return c;
            }
            x.e("MicroMsg.CardUtil", "update mCardInfo fail, cardId = %s", bVar.aum());
            return c;
        }
    }

    public static void xw(String str) {
        as.Hm();
        com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_SHARECARD_LAYOUT_JSON_STRING_SYNC, (Object) str);
    }

    public static String axP() {
        as.Hm();
        return (String) com.tencent.mm.y.c.Db().get(w.a.USERINFO_CARD_SHARECARD_LAYOUT_JSON_STRING_SYNC, (Object) "");
    }

    public static String xx(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        CharSequence gx = r.gx(str);
        CharSequence gw = r.gw(str);
        if (!TextUtils.isEmpty(gx)) {
            return gx;
        }
        if (TextUtils.isEmpty(gw)) {
            return str;
        }
        return gw;
    }

    public static ArrayList<String> ap(List<String> list) {
        if (list == null || list.isEmpty()) {
            x.e("MicroMsg.CardUtil", "getContactNamesFromLabels labels is empty!");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Collection hashSet = new HashSet();
        for (String DU : list) {
            Collection DX = com.tencent.mm.plugin.label.a.a.aVD().DX(com.tencent.mm.plugin.label.a.a.aVD().DU(DU));
            if (DX == null || DX.size() == 0) {
                x.e("MicroMsg.CardUtil", "getContactNamesFromLabels, namelist get bu label is null");
            } else {
                hashSet.addAll(DX);
            }
        }
        arrayList.addAll(hashSet);
        return arrayList;
    }

    public static ArrayList<String> aq(List<String> list) {
        if (list == null || list.isEmpty()) {
            x.e("MicroMsg.CardUtil", "getContactIdsFromLabels labels is empty!");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String DU : list) {
            CharSequence DU2 = com.tencent.mm.plugin.label.a.a.aVD().DU(DU);
            if (!TextUtils.isEmpty(DU2)) {
                arrayList.add(DU2);
            }
        }
        return arrayList;
    }

    public static String xy(String str) {
        List list;
        List<Object> asList = Arrays.asList(str.split(","));
        List linkedList = new LinkedList();
        if (as.Hp()) {
            if (asList == null || asList.size() == 0) {
                list = linkedList;
                return bi.d(list, ",");
            }
            for (Object obj : asList) {
                Object obj2;
                as.Hm();
                com.tencent.mm.k.a Xv = com.tencent.mm.y.c.Ff().Xv(obj2);
                if (!(Xv == null || ((int) Xv.gKO) == 0)) {
                    obj2 = Xv.AX();
                }
                linkedList.add(obj2);
            }
        }
        list = linkedList;
        return bi.d(list, ",");
    }

    public static bjs a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        int i2 = 0;
        x.i("MicroMsg.CardUtil", "getShareTag()");
        bjs bjs = new bjs();
        Collection arrayList3;
        int i3;
        String str;
        if (i == 2) {
            if (arrayList != null && arrayList.size() > 0) {
                bjs.wTB.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList3 = new ArrayList();
                while (true) {
                    i3 = i2;
                    if (i3 >= arrayList2.size()) {
                        break;
                    }
                    str = (String) arrayList2.get(i3);
                    if (!TextUtils.isEmpty(str) && xv(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                    i2 = i3 + 1;
                }
                bjs.wTD.addAll(arrayList3);
            }
        } else if (i == 3) {
            if (arrayList != null && arrayList.size() > 0) {
                bjs.wTC.addAll(arrayList);
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList3 = new ArrayList();
                while (true) {
                    i3 = i2;
                    if (i3 >= arrayList2.size()) {
                        break;
                    }
                    str = (String) arrayList2.get(i3);
                    if (!TextUtils.isEmpty(str) && xv(str)) {
                        arrayList3.add(Integer.valueOf(str));
                    }
                    i2 = i3 + 1;
                }
                bjs.wTE.addAll(arrayList3);
            }
        }
        return bjs;
    }

    public static boolean a(oy oyVar, String str) {
        if (bQ(oyVar.vZQ)) {
            String str2 = oyVar.title;
            if (xz(str)) {
                x.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
                return false;
            }
            x.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            return true;
        }
        x.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
        return false;
    }

    public static boolean a(b bVar, String str) {
        if (bQ(bVar.vZQ)) {
            String str2 = bVar.title;
            if (xz(str)) {
                x.i("MicroMsg.CardUtil", "ShowWarning has show the warning!");
                return false;
            }
            x.i("MicroMsg.CardUtil", "ShowWarning has not show the warning!");
            return true;
        }
        x.i("MicroMsg.CardUtil", "ShowWarning not support show the warning!");
        return false;
    }

    private static boolean bQ(long j) {
        if ((8 & j) <= 0) {
            return false;
        }
        x.i("MicroMsg.CardUtil", "shouldShowWarning show the warning!");
        return true;
    }

    private static boolean xz(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardUtil", "hasShowTheWarning card_id or title is empty!");
            return true;
        }
        x.i("MicroMsg.CardUtil", "hasShowWarning()");
        as.Hm();
        String str2 = (String) com.tencent.mm.y.c.Db().get(w.a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, (Object) "");
        if (TextUtils.isEmpty(str2)) {
            x.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
            return false;
        }
        String[] split = str2.split(",");
        if (split == null || split.length == 0) {
            x.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
            return false;
        }
        for (Object equals : split) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static void xA(String str) {
        Object obj = null;
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardUtil", "setShowWarningFlag card_id or title is empty!");
            return;
        }
        Object str2;
        x.i("MicroMsg.CardUtil", "setShowWarningFlag()");
        as.Hm();
        String str3 = (String) com.tencent.mm.y.c.Db().get(w.a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, (Object) "");
        if (TextUtils.isEmpty(str3)) {
            x.e("MicroMsg.CardUtil", "hasShowTheWarning cardIdListStr list is empty!");
        } else {
            String[] split = str3.split(",");
            if (split == null || split.length == 0) {
                x.e("MicroMsg.CardUtil", "hasShowTheWarning cardIds is empty!");
                str3 = str2;
            }
            for (Object equals : split) {
                if (str2.equals(equals)) {
                    obj = 1;
                }
            }
            if (obj == null) {
                str2 = str3 + "," + str2;
            } else {
                str2 = str3;
            }
        }
        as.Hm();
        com.tencent.mm.y.c.Db().a(w.a.USERINFO_CARD_SHOW_WARNING_CARD_IDS_STRING_SYNC, str2);
    }

    public static String w(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        float f = am.avn().gAi;
        float f2 = am.avn().gAh;
        if (f == -1000.0f || f2 == -85.0f) {
            x.e("MicroMsg.CardUtil", "getRedirectUrl() location info is empty!");
            return str;
        } else if ((16 & j) <= 0) {
            return str;
        } else {
            String replace = str.replace("#", ("&longitude=" + f + "&latitude=" + f2) + "#");
            x.i("MicroMsg.CardUtil", "getRedirectUrl originalUrl:" + str);
            x.i("MicroMsg.CardUtil", "getRedirectUrl afterwardsUrl:" + replace);
            return replace;
        }
    }

    public static int xB(String str) {
        if (TextUtils.isEmpty(str) || str.equals(q.FY())) {
            return 0;
        }
        return 1;
    }

    public static Drawable f(Context context, String str, int i) {
        Drawable d = d(context, xu(str), i);
        Drawable cm = cm(xu(str), i);
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, cm);
        stateListDrawable.addState(new int[0], d);
        return stateListDrawable;
    }

    public static ColorStateList U(Context context, String str) {
        return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, new int[]{context.getResources().getColor(R.e.white), xu(str)});
    }
}
