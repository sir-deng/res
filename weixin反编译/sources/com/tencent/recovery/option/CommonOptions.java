package com.tencent.recovery.option;

public class CommonOptions {
    public String AaL;
    public String AaP;
    public String AaQ;
    private boolean AaR;
    public long AaS;
    public long AaT;
    public String clientVersion;
    public String njL;

    public static final class Builder {
        public String AaL;
        public String AaP;
        public String AaQ;
        public boolean AaR;
        public long AaS;
        public long AaT;
        public String clientVersion;
        public String njL;

        public final CommonOptions cEf() {
            CommonOptions commonOptions = new CommonOptions();
            commonOptions.AaP = this.AaP;
            commonOptions.AaQ = this.AaQ;
            commonOptions.clientVersion = this.clientVersion;
            commonOptions.AaL = this.AaL;
            commonOptions.njL = this.njL;
            commonOptions.AaR = this.AaR;
            commonOptions.AaS = this.AaS;
            commonOptions.AaT = this.AaT;
            return commonOptions;
        }
    }

    /* synthetic */ CommonOptions(byte b) {
        this();
    }

    private CommonOptions() {
    }
}
