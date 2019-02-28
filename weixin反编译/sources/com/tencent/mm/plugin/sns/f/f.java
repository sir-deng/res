package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {
    public static final Pattern rgB = Pattern.compile("\\{([\\s\\S]*?)\\}");
    public static String[] rgC = new String[]{"{sex", "{username", "{richtext"};
    public static HashMap<String, a> rgD = new HashMap();

    enum a {
        OK,
        FAIL
    }

    public static String a(a aVar) {
        if (!rgD.containsKey(aVar.rgy)) {
            Object obj = aVar.rgy;
            if (bi.oN(obj)) {
                return aVar.rgx;
            }
            Object obj2;
            do {
                Matcher matcher = rgB.matcher(obj);
                if (matcher.find()) {
                    int groupCount = matcher.groupCount();
                    Object group = matcher.group();
                    x.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + groupCount + " " + group);
                    obj = obj.replace(group, "");
                    for (String indexOf : rgC) {
                        if (group.indexOf(indexOf) >= 0) {
                            obj2 = 1;
                            continue;
                            break;
                        }
                    }
                    obj2 = null;
                    continue;
                } else {
                    rgD.put(aVar.rgy, a.OK);
                    return aVar.rgy;
                }
            } while (obj2 != null);
            rgD.put(aVar.rgy, a.FAIL);
            return aVar.rgx;
        } else if (((a) rgD.get(aVar.rgy)) == a.OK) {
            return aVar.rgy;
        } else {
            return aVar.rgx;
        }
    }
}
