package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.protocal.c.ajv;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.ci;
import com.tencent.mm.protocal.c.dt;
import com.tencent.mm.protocal.c.du;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    private static int Lu(String str) {
        int i = 0;
        try {
            return bi.getInt(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.AlbumBgHelper", "parserInt error " + str);
            return i;
        }
    }

    private static float mI(String str) {
        float f = 0.0f;
        if (str == null) {
            return f;
        }
        try {
            return bi.getFloat(str, 0.0f);
        } catch (Exception e) {
            x.e("MicroMsg.AlbumBgHelper", "parseFloat error " + str);
            return f;
        }
    }

    private static String mJ(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static ci Lv(String str) {
        Map y = bj.y(str, "albumList");
        ci ciVar = new ci();
        if (y == null) {
            return ciVar;
        }
        ciVar.nnm = mJ((String) y.get(".albumList.$lang"));
        dt dtVar = new dt();
        dtVar.nkW = mJ((String) y.get(".albumList.album.author.name"));
        dtVar.fpg = mJ((String) y.get(".albumList.album.author.title"));
        dtVar.vPF = mJ((String) y.get(".albumList.album.author.description"));
        dtVar.vPE = mJ((String) y.get(".albumList.album.author.quote"));
        du duVar = new du();
        arg o = o(y, ".albumList.album.author.icon.media");
        String str2 = (String) y.get(".albumList.album.author.icon.media.id");
        String str3 = (String) y.get(".albumList.album.author.icon.media.type");
        String str4 = (String) y.get(".albumList.album.author.icon.media.title");
        String str5 = (String) y.get(".albumList.album.author.icon.media.desc");
        String str6 = (String) y.get(".albumList.album.author.icon.media.url");
        String str7 = (String) y.get(".albumList.album.author.icon.media.private");
        String str8 = (String) y.get(".albumList.album.author.icon.media.thumb");
        String str9 = (String) y.get(".albumList.album.author.icon.media.url.$type");
        String str10 = (String) y.get(".albumList.album.author.icon.media.thumb.$type");
        are are = new are();
        are.nMq = mJ(str2);
        are.kzz = Lu(str3);
        are.fpg = mJ(str4);
        are.nkL = mJ(str5);
        are.nlE = mJ(str6);
        are.wEO = Lu(str9);
        are.wEP = mJ(str8);
        are.wEQ = Lu(str10);
        are.wER = Lu(str7);
        are.wES = o;
        duVar.vPH = are;
        dtVar.vPG = duVar;
        ciVar.vOo = dtVar;
        int i = 0;
        while (true) {
            Object obj;
            int i2 = i;
            ajv ajv = new ajv();
            if (i2 == 0) {
                obj = ".albumList.album.groupList.group.name";
                str4 = ".albumList.album.groupList.group.mediaList";
            } else {
                str4 = ".albumList.album.groupList.group" + i2 + ".name";
                String str11 = ".albumList.album.groupList.group" + i2 + ".mediaList";
                str2 = str4;
                str4 = str11;
            }
            str2 = (String) y.get(obj);
            if (str2 == null) {
                return ciVar;
            }
            ajv.nkW = mJ(str2);
            ajv.wfh = p(y, str4);
            ciVar.vOp.add(ajv);
            i = i2 + 1;
        }
    }

    private static arg o(Map<String, String> map, String str) {
        String str2 = str + ".size.$width";
        String str3 = str + ".size.$height";
        str2 = (String) map.get(str2);
        str3 = (String) map.get(str3);
        String str4 = (String) map.get(str + ".size.$totalSize");
        arg arg = new arg();
        arg.wFG = 0.0f;
        arg.wFF = 0.0f;
        arg.wFH = 0.0f;
        if (str2 != null) {
            arg.wFF = mI(str2);
        }
        if (str3 != null) {
            arg.wFG = mI(str3);
        }
        if (str4 != null) {
            arg.wFH = mI(str4);
        }
        return arg;
    }

    private static LinkedList<are> p(Map<String, String> map, String str) {
        LinkedList<are> linkedList = new LinkedList();
        int i = 0;
        while (true) {
            Object obj;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            String str11;
            if (i != 0) {
                obj = str + ".media" + i + ".id";
                str2 = str + ".media" + i + ".type";
                str3 = str + ".media" + i + ".title";
                str4 = str + ".media" + i + ".desc";
                str5 = str + ".media" + i + ".url";
                str6 = str + ".media" + i + ".thumb";
                str7 = str + ".media" + i + ".url.$type";
                str8 = str + ".media" + i + ".thumb.$type";
                str9 = str + ".media" + i + ".private";
                str10 = str + ".media" + i;
                str11 = str9;
                obj2 = str2;
                obj3 = str8;
                obj4 = str3;
                obj5 = str7;
                obj6 = str4;
                obj7 = str6;
                obj8 = str5;
                obj9 = str11;
            } else {
                obj = str + ".media.id";
                str2 = str + ".media.type";
                str3 = str + ".media.title";
                str4 = str + ".media.desc";
                str5 = str + ".media.url";
                str6 = str + ".media.thumb";
                str7 = str + ".media.url.$type";
                str8 = str + ".media.thumb.$type";
                str9 = str + ".media.private";
                str10 = str + ".media";
                str11 = str9;
                str9 = str2;
                str2 = str8;
                str8 = str3;
                str3 = str7;
                str7 = str4;
                str4 = str6;
                str6 = str5;
                str5 = str11;
            }
            if (obj != null && obj2 != null) {
                arg o = o(map, str10);
                str10 = (String) map.get(obj);
                str9 = (String) map.get(obj2);
                str8 = (String) map.get(obj4);
                str7 = (String) map.get(obj6);
                str6 = (String) map.get(obj8);
                str5 = (String) map.get(obj9);
                str4 = (String) map.get(obj7);
                str3 = (String) map.get(obj5);
                str2 = (String) map.get(obj3);
                if (str10 == null || str9 == null) {
                    break;
                }
                are are = new are();
                are.nMq = mJ(str10);
                are.kzz = Lu(str9);
                are.fpg = mJ(str8);
                are.nkL = mJ(str7);
                are.nlE = mJ(str6);
                are.wEO = Lu(str3);
                are.wEP = mJ(str4);
                are.wEQ = Lu(str2);
                are.wER = Lu(str5);
                are.wES = o;
                linkedList.add(are);
                i++;
            } else {
                break;
            }
        }
        return linkedList;
    }
}
