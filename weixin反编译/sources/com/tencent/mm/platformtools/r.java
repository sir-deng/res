package com.tencent.mm.platformtools;

import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class r {
    public static boolean ifA = false;
    public static boolean ifB = false;
    public static boolean ifC = false;
    public static boolean ifD = false;
    public static boolean ifE = false;
    public static int ifF = 0;
    public static int ifG = 0;
    public static boolean ifH = false;
    public static String ifI = null;
    public static String ifJ = null;
    public static boolean ifK = false;
    public static boolean ifL = false;
    public static int ifM = 0;
    public static int ifN = 0;
    public static int ifO = 0;
    public static String ifP = "";
    public static String ifQ = "";
    public static String ifR = null;
    public static String ifS = null;
    public static boolean ifT = false;
    public static boolean ifU = false;
    public static boolean ifV = false;
    public static boolean ifW = false;
    public static String ifX = "";
    public static String ifY = "";
    public static String ifZ = "";
    public static boolean ifb = false;
    public static boolean ifc = false;
    public static boolean ifd = false;
    public static boolean ife = false;
    public static boolean iff = false;
    public static boolean ifg = false;
    public static boolean ifh = false;
    public static boolean ifi = false;
    public static boolean ifj = false;
    public static boolean ifk = false;
    public static boolean ifl = false;
    public static boolean ifm = false;
    public static String ifn = "";
    public static boolean ifo = false;
    public static boolean ifp = false;
    public static boolean ifq = false;
    public static boolean ifr = false;
    public static int ifs = 0;
    public static boolean ift = false;
    public static boolean ifu = false;
    public static boolean ifv = false;
    public static String ifw = "";
    public static String ifx = "";
    public static boolean ify = false;
    public static boolean ifz = false;
    public static String igA = "";
    public static boolean igB = false;
    public static boolean igC = false;
    public static String igD = "";
    public static String igE = "";
    public static boolean igF = false;
    public static boolean igG = false;
    public static boolean igH = false;
    public static boolean igI = false;
    public static boolean igJ = false;
    public static boolean igK = false;
    public static boolean igL = false;
    private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> igM = new HashMap();
    public static boolean igN = false;
    public static boolean igO = false;
    public static boolean igP = false;
    public static String iga = "";
    public static String igb = "";
    public static boolean igc = false;
    public static boolean igd = false;
    public static boolean ige = false;
    public static int igf = 0;
    public static boolean igg = false;
    public static boolean igh = false;
    public static boolean igi = false;
    public static boolean igj = false;
    public static boolean igk = false;
    public static boolean igl = false;
    public static boolean igm = true;
    public static boolean ign = false;
    public static boolean igo = false;
    public static String igp = "";
    public static int igq = 0;
    public static boolean igr = false;
    public static boolean igs = false;
    public static int igt = -1;
    public static boolean igu = false;
    public static String igv = "";
    public static float igw = 0.4f;
    public static float igx = 0.7f;
    public static boolean igy = false;
    public static String igz = "";
    public static double lat = 0.0d;
    public static double lng = 0.0d;

    public static void br(int i, int i2) {
        synchronized (igM) {
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) igM.get(Integer.valueOf(i));
            if (concurrentLinkedQueue == null) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                igM.put(Integer.valueOf(i), concurrentLinkedQueue);
            }
            concurrentLinkedQueue.add(Integer.valueOf(i2));
        }
    }
}
