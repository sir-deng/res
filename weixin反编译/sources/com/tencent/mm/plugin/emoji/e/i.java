package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.ay.d;
import com.tencent.mm.ay.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.a.bc;
import com.tencent.mm.f.a.cn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class i {
    private static String lBA = "panel";
    public static String lBB = "suggest";
    public static String lBC = "egg";
    private static String lBD = "search";
    private static String lBE = "config.conf";
    private static String lBF = "emojipanel.zip";
    private static String lBG = "newemoji.zip";
    private static String lBH = "emoji_template.zip";
    private static String lBI = "emojisuggest.zip";
    private static String lBJ = "egg.zip";
    private static String lBK = "newemoji-config.xml";
    private static String lBL = "emojipanel-config.xml";
    public static String lBM = "emojisuggest-config.xml";
    public static String lBN = "egg.xml";
    private static int lBO = 0;
    private static int lBP = 0;
    private static int lBQ = 0;
    private static int lBR = 0;
    private static i lBS;
    private static String lBx = "";
    private static String lBy = "temp";
    private static String lBz = "newemoji";
    public f lBT;

    public enum a {
        EMOJI,
        PANEL,
        SUGGEST,
        SEARCH,
        EGG
    }

    public static i aBN() {
        if (lBS == null) {
            synchronized (i.class) {
                lBS = new i();
            }
        }
        return lBS;
    }

    public static String aBO() {
        if (bi.oN(lBx)) {
            lBx = e.hbw.replace("/data/user/0", "/data/data");
            lBx += "/emoji";
        }
        return lBx;
    }

    public static boolean a(bc bcVar, a aVar, String str) {
        File file = new File(bcVar.fqf.filePath);
        if (!file.exists() || file.length() <= 0) {
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile update file don't exist.");
            return false;
        }
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile start. type:%s filePath:%s", String.valueOf(aVar), file.getAbsolutePath());
        File file2 = new File(aBO(), str);
        if (file2.exists()) {
            com.tencent.mm.a.e.g(file2);
        }
        switch (aVar) {
            case EMOJI:
                str2 = lBG;
                break;
            case PANEL:
                str2 = lBF;
                break;
            case SEARCH:
                str2 = lBH;
                break;
            case SUGGEST:
                str2 = lBI;
                break;
            case EGG:
                str2 = lBJ;
                break;
            default:
                x.w("MicroMsg.emoji.EmojiResUpdateMgr", "unknown type. type:%s", String.valueOf(aVar));
                str2 = "";
                break;
        }
        File file3 = new File(file2, str2);
        file2.mkdirs();
        com.tencent.mm.a.e.x(file.getAbsolutePath(), file3.getAbsolutePath());
        int fz = bi.fz(file3.getAbsolutePath(), file2.getAbsolutePath());
        b.deleteFile(file3.getPath());
        x.d("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile done. user time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (fz >= 0) {
            return true;
        }
        return false;
    }

    private static int y(File file) {
        Reader inputStreamReader;
        Throwable e;
        Reader reader;
        InputStream inputStream;
        Throwable th;
        Reader reader2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        int i = -1;
        if (file.exists()) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    reader = null;
                    inputStream = fileInputStream;
                    try {
                        x.e("MicroMsg.emoji.EmojiResUpdateMgr", bi.i(e));
                        com.tencent.mm.a.e.c(inputStream);
                        com.tencent.mm.a.e.a(reader2);
                        com.tencent.mm.a.e.a(reader);
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = inputStream;
                        inputStreamReader = reader2;
                        com.tencent.mm.a.e.c(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    reader = null;
                    inputStreamReader = null;
                    com.tencent.mm.a.e.c(fileInputStream);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(reader);
                    throw th;
                }
                try {
                    reader = new BufferedReader(inputStreamReader);
                    try {
                        String str = "";
                        while (true) {
                            String readLine = reader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str = str + readLine;
                        }
                        i = new JSONObject(str).getInt("version");
                        x.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode config file content:%s version:%d", str, Integer.valueOf(i));
                        com.tencent.mm.a.e.c(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                    } catch (Exception e3) {
                        e = e3;
                        reader2 = inputStreamReader;
                        inputStream = fileInputStream;
                        x.e("MicroMsg.emoji.EmojiResUpdateMgr", bi.i(e));
                        com.tencent.mm.a.e.c(inputStream);
                        com.tencent.mm.a.e.a(reader2);
                        com.tencent.mm.a.e.a(reader);
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return i;
                    } catch (Throwable th4) {
                        th = th4;
                        com.tencent.mm.a.e.c(fileInputStream);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(reader);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    reader = null;
                    reader2 = inputStreamReader;
                    inputStream = fileInputStream;
                    x.e("MicroMsg.emoji.EmojiResUpdateMgr", bi.i(e));
                    com.tencent.mm.a.e.c(inputStream);
                    com.tencent.mm.a.e.a(reader2);
                    com.tencent.mm.a.e.a(reader);
                    x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return i;
                } catch (Throwable th5) {
                    th = th5;
                    reader = null;
                    com.tencent.mm.a.e.c(fileInputStream);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(reader);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                reader = null;
                inputStream = null;
                x.e("MicroMsg.emoji.EmojiResUpdateMgr", bi.i(e));
                com.tencent.mm.a.e.c(inputStream);
                com.tencent.mm.a.e.a(reader2);
                com.tencent.mm.a.e.a(reader);
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return i;
            } catch (Throwable th6) {
                th = th6;
                reader = null;
                inputStreamReader = null;
                fileInputStream = null;
                com.tencent.mm.a.e.c(fileInputStream);
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(reader);
                throw th;
            }
        }
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion file don't exist. path:%s", file.getAbsolutePath());
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "readLocalVersion done.use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return i;
    }

    public final boolean a(bc bcVar, a aVar) {
        int y;
        int intValue;
        if (a(bcVar, aVar, lBy)) {
            File file = new File(aBO(), lBy);
            x.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode unzip file done.");
            y = y(new File(file, lBE));
        } else {
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "unzip file failed. type:%s", String.valueOf(aVar));
            y = -1;
        }
        switch (aVar) {
            case EMOJI:
                as.Hm();
                intValue = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0))).intValue();
                lBO = intValue;
                break;
            case PANEL:
                as.Hm();
                intValue = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0))).intValue();
                lBP = intValue;
                break;
            case SEARCH:
                intValue = com.tencent.mm.aj.a.hwC;
                break;
            case SUGGEST:
                as.Hm();
                intValue = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_SUGGEST_INT, Integer.valueOf(0))).intValue();
                lBQ = intValue;
                break;
            case EGG:
                as.Hm();
                intValue = ((Integer) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_EMOJI_EGG_INT, Integer.valueOf(0))).intValue();
                lBR = intValue;
                break;
            default:
                intValue = -1;
                break;
        }
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "file version:%d, current version:%d", Integer.valueOf(y), Integer.valueOf(intValue));
        if (y == -1 || intValue >= y) {
            return false;
        }
        return true;
    }

    private static void z(File file) {
        Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        parse.normalize();
        NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("emoji");
        if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
            ArrayList arrayList = new ArrayList();
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    q qVar = new q();
                    for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                        Node item = childNodes.item(i2);
                        String nodeName = item.getNodeName();
                        if (nodeName.equalsIgnoreCase("key")) {
                            qVar.field_key = item.getTextContent();
                        } else if (nodeName.equalsIgnoreCase("cn-value")) {
                            if (bi.oN(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                qVar.field_cnValue = qVar.field_key;
                            } else {
                                try {
                                    qVar.field_cnValue = item.getTextContent();
                                } catch (Exception e) {
                                    x.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserNewEmojiConfig parseXML exception:%s", e.toString());
                                    return;
                                }
                            }
                        } else if (nodeName.equalsIgnoreCase("qq-value")) {
                            if (bi.oN(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                qVar.field_qqValue = qVar.field_key;
                            } else {
                                qVar.field_qqValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase("en-value")) {
                            if (bi.oN(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                qVar.field_enValue = qVar.field_key;
                            } else {
                                qVar.field_enValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase("tw-value")) {
                            if (bi.oN(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                qVar.field_twValue = qVar.field_key;
                            } else {
                                qVar.field_twValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase("th-value")) {
                            if (bi.oN(item.getTextContent()) || "null".equalsIgnoreCase(item.getTextContent())) {
                                qVar.field_thValue = qVar.field_key;
                            } else {
                                qVar.field_thValue = item.getTextContent();
                            }
                        } else if (nodeName.equalsIgnoreCase(DownloadInfo.FILENAME)) {
                            qVar.field_fileName = item.getTextContent();
                        } else if (nodeName.equalsIgnoreCase("eggIndex")) {
                            int intValue;
                            try {
                                intValue = Integer.valueOf(item.getTextContent()).intValue();
                            } catch (Throwable e2) {
                                x.e("MicroMsg.emoji.EmojiResUpdateMgr", bi.i(e2));
                                intValue = -1;
                            }
                            qVar.field_eggIndex = intValue;
                        } else {
                            continue;
                        }
                    }
                    qVar.field_position = -1;
                    x.d("MicroMsg.emoji.EmojiResUpdateMgr", qVar.toString());
                    if (bi.oN(qVar.field_key)) {
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "key is empty");
                    } else {
                        arrayList.add(qVar);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserNewEmojiConfig smiley list is null.");
            } else if (((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().p(arrayList)) {
                com.tencent.mm.sdk.b.b cnVar = new cn();
                cnVar.frF.fqh = 1;
                com.tencent.mm.sdk.b.a.xmy.m(cnVar);
                lBO = y(new File(aBO() + File.separator + lBz, lBE));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(lBO));
            }
        }
    }

    private static void A(File file) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("item");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                ArrayList arrayList = new ArrayList();
                int length = elementsByTagName.getLength();
                for (int i = 0; i < length; i++) {
                    Node item = elementsByTagName.item(i);
                    if (!(item == null || bi.oN(item.getTextContent()))) {
                        String replaceAll = item.getTextContent().replaceAll("\"", "");
                        if (replaceAll.startsWith("\\\\u")) {
                            char[] toChars = Character.toChars(Integer.parseInt(replaceAll.substring(3), 16));
                            replaceAll = "";
                            int i2 = 0;
                            while (i2 < toChars.length) {
                                String str = replaceAll + String.valueOf(toChars[i2]);
                                i2++;
                                replaceAll = str;
                            }
                        }
                        s sVar = new s(i, replaceAll);
                        if (bi.oN(sVar.field_key)) {
                            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "key is null.");
                        } else {
                            arrayList.add(sVar);
                        }
                        x.d("MicroMsg.emoji.EmojiResUpdateMgr", sVar.toString());
                    }
                }
                if (arrayList.isEmpty()) {
                    x.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfig smiley panel list is null.");
                } else if (((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().q(arrayList)) {
                    com.tencent.mm.sdk.b.b cnVar = new cn();
                    cnVar.frF.fqh = 2;
                    com.tencent.mm.sdk.b.a.xmy.m(cnVar);
                    lBP = y(new File(aBO() + File.separator + lBA, lBE));
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(lBP));
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfig parseXML exception:%s", e.toString());
        }
    }

    public static void B(File file) {
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("group");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                int length = elementsByTagName.getLength();
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                    if (childNodes != null && childNodes.getLength() > 0) {
                        int length2 = childNodes.getLength();
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < length2; i2++) {
                            Node item = childNodes.item(i2);
                            if (item.getNodeName().equals("word")) {
                                String textContent = item.getTextContent();
                                if (!bi.oN(textContent)) {
                                    x.d("MicroMsg.emoji.EmojiResUpdateMgr", "word:%s", textContent);
                                    arrayList2.add(textContent.trim());
                                }
                            }
                        }
                        arrayList.add(arrayList2);
                    }
                }
                com.tencent.mm.plugin.emoji.model.i.aCl().lCG.ag(arrayList);
                lBQ = y(new File(aBO() + File.separator + lBB, lBE));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_SUGGEST_INT, Integer.valueOf(lBQ));
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiDescConfig parseXML exception:%s", e.toString());
        }
    }

    public static void C(File file) {
        try {
            String bT = com.tencent.mm.a.e.bT(file.getAbsolutePath());
            Map y = bj.y(bT, "EasterEgg");
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "eggXml:" + bT);
            if (y == null) {
                x.e("MicroMsg.emoji.EmojiResUpdateMgr", "Exception in parseXml EasterEgg, please check the xml");
                return;
            }
            f fVar = new f();
            fVar.hLo = (double) bi.Wo((String) y.get(".EasterEgg.$version"));
            int i = 0;
            while (true) {
                String str = ".EasterEgg.Item" + (i == 0 ? "" : Integer.valueOf(i));
                if (y.get(str + ".$name") != null) {
                    d dVar = new d();
                    dVar.name = bi.oM((String) y.get(str + ".$name"));
                    dVar.hLh = bi.oM((String) y.get(str + ".$langs"));
                    dVar.hLe = bi.Wo((String) y.get(str + ".$reportType"));
                    dVar.hLf = bi.Wf((String) y.get(str + ".$BeginDate"));
                    dVar.hLg = bi.Wf((String) y.get(str + ".$EndDate"));
                    dVar.hLi = bi.oM((String) y.get(str + ".FileName"));
                    dVar.hLj = bi.Wo((String) y.get(str + ".AnimType"));
                    dVar.hLk = bi.Wo((String) y.get(str + ".AnimType.$viewcount"));
                    dVar.hLl = bi.Wo((String) y.get(str + ".AnimType.$minSize"));
                    dVar.maxSize = bi.Wo((String) y.get(str + ".AnimType.$maxSize"));
                    int i2 = 0;
                    while (true) {
                        bT = str + ".KeyWord" + (i2 == 0 ? "" : Integer.valueOf(i2));
                        String str2 = bT + ".$lang";
                        if (y.get(bT) == null) {
                            break;
                        }
                        com.tencent.mm.ay.e eVar = new com.tencent.mm.ay.e();
                        eVar.hLm = bi.oM((String) y.get(bT));
                        eVar.lang = bi.oM((String) y.get(str2));
                        dVar.hLc.add(eVar);
                        i2++;
                    }
                    fVar.hLn.add(dVar);
                    i++;
                } else {
                    byte[] toByteArray = fVar.toByteArray();
                    StringBuilder stringBuilder = new StringBuilder();
                    as.Hm();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.FI()).append("eggingfo.ini").toString(), toByteArray, toByteArray.length);
                    lBR = y(new File(aBO() + File.separator + lBC, lBE));
                    as.Hm();
                    c.Db().a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_EGG_INT, Integer.valueOf(lBR));
                    return;
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
        }
    }

    public final void a(bc bcVar, boolean z) {
        if (!z && !a(bcVar, a.EMOJI)) {
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji need no update.");
        } else if (z || a(bcVar, a.EMOJI, lBz)) {
            File file = new File(new File(aBO(), lBz), lBK);
            if (file.exists()) {
                z(file);
            } else {
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji config don't exist.");
            }
        } else {
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji unzip file failed.");
        }
    }

    public final void b(bc bcVar, boolean z) {
        if (!(z || a(bcVar, a.PANEL))) {
            as.Hm();
            String str = (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_PANEL_NAME_STRING, lBL);
            String aBW = n.aBW();
            int i = (bi.oN(aBW) || str.equalsIgnoreCase(aBW)) ? 0 : 1;
            if (i == 0) {
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel need no update.");
                return;
            }
        }
        if (z || a(bcVar, a.PANEL, lBA)) {
            File file = new File(aBO(), lBA);
            Object aBW2 = n.aBW();
            if (bi.oN(aBW2)) {
                aBW2 = lBL;
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "no dynamic config panel file name. use default.");
            } else {
                if (!new File(file, aBW2).exists()) {
                    aBW2 = lBL;
                }
                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "dynamic config panel file name :%s", aBW2);
            }
            File file2 = new File(file, aBW2);
            if (file2.exists()) {
                A(file2);
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_PANEL_NAME_STRING, aBW2);
                return;
            }
            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel config don't exist.");
            return;
        }
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel unzip file failed.");
    }

    public static boolean d(bc bcVar) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.bw.b.chK();
        com.tencent.mm.bw.b.chN();
        long j = com.tencent.mm.bw.b.chK().xsQ;
        com.tencent.mm.bw.b.chK();
        int WN = com.tencent.mm.bw.b.WN(bcVar.fqf.filePath);
        com.tencent.mm.bw.b.chK();
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "currentSupportVersion:%d current version:%d supportVersion:%d file version:%d use time:%d", Integer.valueOf(1), Long.valueOf(j), Integer.valueOf(WN), Long.valueOf(com.tencent.mm.bw.b.WM(bcVar.fqf.filePath)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (WN == 1 && r6 > j) {
            return true;
        }
        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "need not update color emoji");
        return false;
    }

    public final f aBF() {
        try {
            if (this.lBT == null) {
                StringBuilder stringBuilder = new StringBuilder();
                as.Hm();
                byte[] e = com.tencent.mm.a.e.e(stringBuilder.append(c.FI()).append("eggingfo.ini").toString(), 0, -1);
                if (e == null) {
                    x.d("MicroMsg.emoji.EmojiResUpdateMgr", "data is null, parse EggList from config file fail");
                } else {
                    this.lBT = (f) new f().aH(e);
                }
            }
        } catch (Throwable e2) {
            x.w("MicroMsg.emoji.EmojiResUpdateMgr", "init crash : %s, try delete egg file", e2.getLocalizedMessage());
            x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e2, "", new Object[0]);
        }
        return this.lBT;
    }
}
