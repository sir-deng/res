package com.tencent.recovery;

import com.tencent.recovery.config.Express;
import com.tencent.recovery.config.ExpressItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.ProcessOptions;
import java.util.ArrayList;
import java.util.List;

public class ConstantsRecovery {

    public static final class DefaultCommonOptions {
        public static final CommonOptions Aai;

        static {
            Builder builder = new Builder();
            builder.njL = "";
            builder.clientVersion = "";
            builder.AaL = "";
            builder.AaP = "";
            builder.AaQ = "";
            Aai = builder.cEf();
        }
    }

    public static final class DefaultExpress {
        public static final Express Aaj = new Express();
        public static final Express Aak = new Express();
        public static final Express Aal = new Express();

        static {
            List arrayList = new ArrayList();
            arrayList.add(new ExpressItem(17, 1114112));
            Aaj.dJ(arrayList);
            arrayList = new ArrayList();
            arrayList.add(new ExpressItem(1, 1118208));
            Aak.dJ(arrayList);
            arrayList = new ArrayList();
            arrayList.add(new ExpressItem(1, 1114112));
            Aal.dJ(arrayList);
        }
    }

    public static final class DefaultProcessOptions {
        public static final ProcessOptions Aam;
        public static final ProcessOptions Aan;
        public static final ProcessOptions Aao;

        static {
            ProcessOptions.Builder builder = new ProcessOptions.Builder();
            builder.AaV = DefaultExpress.Aaj;
            builder.cEg();
            Aam = builder.cEh();
            builder = new ProcessOptions.Builder();
            builder.AaV = DefaultExpress.Aak;
            builder.cEg();
            Aan = builder.cEh();
            builder = new ProcessOptions.Builder();
            builder.AaV = DefaultExpress.Aal;
            builder.cEg();
            Aao = builder.cEh();
        }
    }

    public static final class IntentAction {
    }

    public static final class IntentKeys {
    }

    public static final class Message {
    }

    public static final class ProcessStage {
    }

    public static final class ProcessStartFlag {
    }

    public static final class ProcessStatus {
    }

    public static final class ReportType {
    }

    public static final class SpKeys {
    }
}
