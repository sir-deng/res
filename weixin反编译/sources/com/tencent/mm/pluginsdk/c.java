package com.tencent.mm.pluginsdk;

import com.tencent.mm.plugin.k.a.a;
import com.tencent.mm.plugin.k.a.b;
import java.util.HashMap;

public final class c {
    private static HashMap<String, Integer> viM = null;

    public static int RI(String str) {
        if (viM == null) {
            HashMap hashMap = new HashMap();
            viM = hashMap;
            hashMap.put("avi", Integer.valueOf(b.dvL));
            viM.put("m4v", Integer.valueOf(b.dvL));
            viM.put("vob", Integer.valueOf(b.dvL));
            viM.put("mpeg", Integer.valueOf(b.dvL));
            viM.put("mpe", Integer.valueOf(b.dvL));
            viM.put("asx", Integer.valueOf(b.dvL));
            viM.put("asf", Integer.valueOf(b.dvL));
            viM.put("f4v", Integer.valueOf(b.dvL));
            viM.put("flv", Integer.valueOf(b.dvL));
            viM.put("mkv", Integer.valueOf(b.dvL));
            viM.put("wmv", Integer.valueOf(b.dvL));
            viM.put("wm", Integer.valueOf(b.dvL));
            viM.put("3gp", Integer.valueOf(b.dvL));
            viM.put("mp4", Integer.valueOf(b.dvL));
            viM.put("rmvb", Integer.valueOf(b.dvL));
            viM.put("rm", Integer.valueOf(b.dvL));
            viM.put("ra", Integer.valueOf(b.dvL));
            viM.put("ram", Integer.valueOf(b.dvL));
            viM.put("mp3pro", Integer.valueOf(b.dvy));
            viM.put("vqf", Integer.valueOf(b.dvy));
            viM.put("cd", Integer.valueOf(b.dvy));
            viM.put("md", Integer.valueOf(b.dvy));
            viM.put("mod", Integer.valueOf(b.dvy));
            viM.put("vorbis", Integer.valueOf(b.dvy));
            viM.put("au", Integer.valueOf(b.dvy));
            viM.put("amr", Integer.valueOf(b.dvy));
            viM.put("silk", Integer.valueOf(b.dvy));
            viM.put("wma", Integer.valueOf(b.dvy));
            viM.put("mmf", Integer.valueOf(b.dvy));
            viM.put("mid", Integer.valueOf(b.dvy));
            viM.put("midi", Integer.valueOf(b.dvy));
            viM.put("mp3", Integer.valueOf(b.dvy));
            viM.put("aac", Integer.valueOf(b.dvy));
            viM.put("ape", Integer.valueOf(b.dvy));
            viM.put("aiff", Integer.valueOf(b.dvy));
            viM.put("aif", Integer.valueOf(b.dvy));
            viM.put("jfif", Integer.valueOf(a.byW));
            viM.put("tiff", Integer.valueOf(a.byW));
            viM.put("tif", Integer.valueOf(a.byW));
            viM.put("jpe", Integer.valueOf(a.byW));
            viM.put("dib", Integer.valueOf(a.byW));
            viM.put("jpeg", Integer.valueOf(a.byW));
            viM.put("jpg", Integer.valueOf(a.byW));
            viM.put("png", Integer.valueOf(a.byW));
            viM.put("bmp", Integer.valueOf(a.byW));
            viM.put("gif", Integer.valueOf(a.byW));
            viM.put("rar", Integer.valueOf(b.dvG));
            viM.put("zip", Integer.valueOf(b.dvG));
            viM.put("7z", Integer.valueOf(b.dvG));
            viM.put("iso", Integer.valueOf(b.dvG));
            viM.put("cab", Integer.valueOf(b.dvG));
            viM.put("doc", Integer.valueOf(b.dvP));
            viM.put("docx", Integer.valueOf(b.dvP));
            viM.put("ppt", Integer.valueOf(b.dvE));
            viM.put("pptx", Integer.valueOf(b.dvE));
            viM.put("xls", Integer.valueOf(b.dvs));
            viM.put("xlsx", Integer.valueOf(b.dvs));
            viM.put("txt", Integer.valueOf(b.dvH));
            viM.put("rtf", Integer.valueOf(b.dvH));
            viM.put("pdf", Integer.valueOf(b.dvC));
        }
        Integer num = (Integer) viM.get(str);
        if (num == null) {
            return b.dvI;
        }
        return num.intValue();
    }

    public static int bYK() {
        return b.dvI;
    }
}
