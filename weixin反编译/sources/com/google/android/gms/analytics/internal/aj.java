package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.j;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public final class aj {
    public static a<Long> aHA = a.c("analytics.local_dispatch_millis", 1800000, 120000);
    public static a<Long> aHB = a.c("analytics.initial_local_dispatch_millis", 5000, 5000);
    public static a<Long> aHC = a.c("analytics.min_local_dispatch_millis", 120000, 120000);
    public static a<Long> aHD = a.c("analytics.max_local_dispatch_millis", 7200000, 7200000);
    public static a<Long> aHE = a.c("analytics.dispatch_alarm_millis", 7200000, 7200000);
    public static a<Long> aHF = a.c("analytics.max_dispatch_alarm_millis", 32400000, 32400000);
    public static a<Integer> aHG = a.b("analytics.max_hits_per_dispatch", 20, 20);
    public static a<Integer> aHH = a.b("analytics.max_hits_per_batch", 20, 20);
    public static a<String> aHI;
    public static a<String> aHJ;
    public static a<String> aHK;
    public static a<String> aHL;
    public static a<Integer> aHM = a.b("analytics.max_get_length", 2036, 2036);
    public static a<String> aHN = a.a("analytics.batching_strategy.k", x.BATCH_BY_COUNT.name(), x.BATCH_BY_COUNT.name());
    public static a<String> aHO;
    public static a<Integer> aHP = a.b("analytics.max_hits_per_request.k", 20, 20);
    public static a<Integer> aHQ = a.b("analytics.max_hit_length.k", 8192, 8192);
    public static a<Integer> aHR = a.b("analytics.max_post_length.k", 8192, 8192);
    public static a<Integer> aHS = a.b("analytics.max_batch_post_length", 8192, 8192);
    public static a<String> aHT;
    public static a<Integer> aHU = a.b("analytics.batch_retry_interval.seconds.k", 3600, 3600);
    public static a<Long> aHV = a.c("analytics.service_monitor_interval", 86400000, 86400000);
    public static a<Integer> aHW = a.b("analytics.http_connection.connect_timeout_millis", 60000, 60000);
    public static a<Integer> aHX = a.b("analytics.http_connection.read_timeout_millis", 61000, 61000);
    public static a<Long> aHY = a.c("analytics.campaigns.time_limit", 86400000, 86400000);
    public static a<String> aHZ;
    public static a<Boolean> aHs = a.f("analytics.service_enabled", false);
    public static a<Boolean> aHt = a.f("analytics.service_client_enabled", true);
    public static a<String> aHu = a.a("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static a<Long> aHv = a.c("analytics.max_tokens", 60, 60);
    public static a<Float> aHw = new a(j.a("analytics.tokens_per_sec", Float.valueOf(0.5f)), Float.valueOf(0.5f));
    public static a<Integer> aHx = a.b("analytics.max_stored_hits", MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, HardCoderJNI.sHCENCODEVIDEOTIMEOUT);
    public static a<Integer> aHy = a.b("analytics.max_stored_hits_per_app", MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
    public static a<Integer> aHz = a.b("analytics.max_stored_properties_per_app", 100, 100);
    public static a<Integer> aIa = a.b("analytics.first_party_experiment_variant", 0, 0);
    public static a<Boolean> aIb = a.f("analytics.test.disable_receiver", false);
    public static a<Long> aIc = a.c("analytics.service_client.idle_disconnect_millis", 10000, 10000);
    public static a<Long> aId = a.c("analytics.service_client.connect_timeout_millis", 5000, 5000);
    public static a<Long> aIe = a.c("analytics.service_client.second_connect_delay_millis", 5000, 5000);
    public static a<Long> aIf = a.c("analytics.service_client.unexpected_reconnect_millis", 60000, 60000);
    public static a<Long> aIg = a.c("analytics.service_client.reconnect_throttle_millis", 1800000, 1800000);
    public static a<Long> aIh = a.c("analytics.monitoring.sample_period_millis", 86400000, 86400000);
    public static a<Long> aIi = a.c("analytics.initialization_warning_threshold", 5000, 5000);

    public static final class a<V> {
        private final V aIj;
        private final j<V> aIk;
        private V aIl;

        a(j<V> jVar, V v) {
            w.ag(jVar);
            this.aIk = jVar;
            this.aIj = v;
        }

        static a<String> a(String str, String str2, String str3) {
            return new a(j.n(str, str3), str2);
        }

        static a<Integer> b(String str, int i, int i2) {
            return new a(j.a(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static a<Long> c(String str, long j, long j2) {
            return new a(j.a(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static a<Boolean> f(String str, boolean z) {
            return new a(j.h(str, z), Boolean.valueOf(z));
        }

        public final V get() {
            return this.aIl != null ? this.aIl : (f.aNs && j.isInitialized()) ? this.aIk.pA() : this.aIj;
        }
    }

    static {
        String str = "http://www.google-analytics.com";
        aHI = a.a("analytics.insecure_host", str, str);
        str = "https://ssl.google-analytics.com";
        aHJ = a.a("analytics.secure_host", str, str);
        str = "/collect";
        aHK = a.a("analytics.simple_endpoint", str, str);
        str = "/batch";
        aHL = a.a("analytics.batching_endpoint", str, str);
        str = z.GZIP.name();
        aHO = a.a("analytics.compression_strategy.k", str, str);
        str = "404,502";
        aHT = a.a("analytics.fallback_responses.k", str, str);
        str = "";
        aHZ = a.a("analytics.first_party_experiment_id", str, str);
    }
}
