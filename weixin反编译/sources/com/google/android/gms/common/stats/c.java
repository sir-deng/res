package com.google.android.gms.common.stats;

import com.google.android.gms.c.j;

public final class c {
    public static j<Integer> aPQ = j.a("gms:common:stats:max_num_of_events", Integer.valueOf(100));

    public static final class b {
        public static j<Integer> aPR = j.a("gms:common:stats:wakeLocks:level", Integer.valueOf(d.LOG_LEVEL_OFF));
        public static j<Long> aPW = j.a("gms:common:stats:wakelocks:time_out_duration", Long.valueOf(600000));
    }

    public static final class a {
        public static j<Integer> aPR = j.a("gms:common:stats:connections:level", Integer.valueOf(d.LOG_LEVEL_OFF));
        public static j<String> aPS = j.n("gms:common:stats:connections:ignored_calling_processes", "");
        public static j<String> aPT = j.n("gms:common:stats:connections:ignored_calling_services", "");
        public static j<String> aPU = j.n("gms:common:stats:connections:ignored_target_processes", "");
        public static j<String> aPV = j.n("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static j<Long> aPW = j.a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
    }
}
