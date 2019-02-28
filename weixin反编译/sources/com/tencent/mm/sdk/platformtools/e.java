package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.loader.stub.BaseBuildInfo;

public final class e {
    public static String BUILD_TAG = "MicroMessenger_Android_GIT_RELEASE_GRADLE #6160";
    public static String CLIENT_VERSION = "0x26060532";
    public static String COMMAND = "null";
    public static boolean DEBUG = false;
    public static String HOSTNAME = "45ea8765cf33";
    public static String OWNER = "amm_code_helper";
    public static String REV = "c129b187eee717d3d0de6b4427d3e44639e5eba1";
    public static String SVNPATH = "origin/RB-2017-DEC-v3@git";
    public static String TIME = "2018-03-05 18:19:01";
    public static boolean xmP = true;

    private static class a {
        public static String ft(String str, String str2) {
            if (str == null) {
                return null;
            }
            int indexOf = str.indexOf(str2);
            return indexOf >= 0 ? str.substring(indexOf) : str;
        }

        public static String fu(String str, String str2) {
            if (str == null) {
                return null;
            }
            if (str.equals(str2)) {
                return str;
            }
            return String.format("%s(%s)", new Object[]{str, str2});
        }
    }

    public static String atw() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[b.ver] %s\n", new Object[]{a.fu(CLIENT_VERSION, BaseBuildInfo.CLIENT_VERSION)}));
        stringBuilder.append(String.format("[tag  ] %s\n", new Object[]{a.fu(BUILD_TAG, BaseBuildInfo.BUILD_TAG)}));
        stringBuilder.append(String.format("[by   ] %s\n", new Object[]{a.fu(OWNER, BaseBuildInfo.OWNER)}));
        stringBuilder.append(String.format("[host ] %s\n", new Object[]{a.fu(HOSTNAME, BaseBuildInfo.HOSTNAME)}));
        stringBuilder.append(String.format("[time ] %s\n", new Object[]{a.fu(TIME, BaseBuildInfo.TIME)}));
        stringBuilder.append(String.format("[cmd  ] %s\n", new Object[]{a.fu(COMMAND, BaseBuildInfo.COMMAND)}));
        stringBuilder.append(String.format("[path ] %s\n", new Object[]{a.fu(a.ft(SVNPATH, "MicroMsg_proj"), a.ft(BaseBuildInfo.SVNPATH, "MicroMsg_proj"))}));
        stringBuilder.append(String.format("[rev  ] %s\n", new Object[]{a.fu(REV, BaseBuildInfo.REV)}));
        String str = "[p.rev] %s\n";
        Object[] objArr = new Object[1];
        objArr[0] = BaseBuildInfo.patchEnabled() ? BaseBuildInfo.codeRevision() : "disabled";
        stringBuilder.append(String.format(str, objArr));
        return stringBuilder.toString();
    }
}
