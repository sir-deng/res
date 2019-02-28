package com.tencent.mm.plugin.g.a.b;

import java.util.HashMap;

public final class h {
    public static String kDG = "00002902-0000-1000-8000-00805f9b34fb";
    public static String kDH = "0000fee7-0000-1000-8000-00805f9b34fb";
    public static String kDI = "0000fec7-0000-1000-8000-00805f9b34fb";
    public static String kDJ = "0000fec8-0000-1000-8000-00805f9b34fb";
    public static String kDK = "0000fea1-0000-1000-8000-00805f9b34fb";
    public static String kDL = "0000fea2-0000-1000-8000-00805f9b34fb";
    public static String kDM = "0000feb1-0000-1000-8000-00805f9b34fb";
    public static String kDN = "0000feb2-0000-1000-8000-00805f9b34fb";
    public static String kDO = "0000feb3-0000-1000-8000-00805f9b34fb";
    public static String kDP = "0000feb4-0000-1000-8000-00805f9b34fb";
    public static String kDQ = "0000181d-0000-1000-8000-00805f9b34fb";
    public static String kDR = "00002a9e-0000-1000-8000-00805f9b34fb";
    public static String kDS = "00002a9d-0000-1000-8000-00805f9b34fb";
    public static String kDT = "0000180d-0000-1000-8000-00805f9b34fb";
    public static String kDU = "00002a37-0000-1000-8000-00805f9b34fb";
    public static String kDV = "00002a38-0000-1000-8000-00805f9b34fb";
    public static String kDW = "00002a39-0000-1000-8000-00805f9b34fb";
    public static String kDX = "00001810-0000-1000-8000-00805f9b34fb";
    public static String kDY = "00002a35-0000-1000-8000-00805f9b34fb";
    public static String kDZ = "00002a36-0000-1000-8000-00805f9b34fb";
    public static String kEa = "00002a49-0000-1000-8000-00805f9b34fb";
    public static HashMap<String, String> kEb;

    static {
        HashMap hashMap = new HashMap();
        kEb = hashMap;
        hashMap.put(kDI, "airsync send characteristic. permission: (write)");
        kEb.put(kDJ, "airsync recv characteristic. permission: (indicate)");
        kEb.put(kDK, "simple step measurement characteristic. permission: ((read)(indicate|notify))");
        kEb.put(kDL, "airsync recv characteristic. permission: [(read)[write][indicate]]");
    }
}
