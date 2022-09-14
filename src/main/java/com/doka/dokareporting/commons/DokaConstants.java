package com.doka.dokareporting.commons;

import java.math.RoundingMode;
import java.util.Locale;

public class DokaConstants {
    public static final int AMOUNT_SCALE = 2;
    public static final RoundingMode AMOUNT_ROUNDING_MODE;
    public static final Locale TURKISH_LOCALE;
    public static final String DEFAULT_ENCODING = "UTF-8";

    public DokaConstants() {
    }

    static {
        AMOUNT_ROUNDING_MODE = RoundingMode.HALF_UP;
        TURKISH_LOCALE = (new Locale.Builder()).setLanguage("tr").setRegion("TR").build();
    }

    public static final class Environment {
        public static final String PROD = "prod";

        private Environment() {
        }
    }

    public static final class Http {
        private Http() {
        }

        public static final class Headers {
            public static final String X_REQUEST_ID = "x-request-id";

            private Headers() {
            }
        }
    }

    public static final class CommonParameters {
        public static final String BET_OPEN = "BET_OPEN";
        public static final String IDDAA_OPEN = "IDDAA_OPEN";
        public static final String GAME_OPEN_PREFIX = "_OPEN";
        public static final String SZRT_GETBETSLIMIT = "SZRT_GETBETSLIMIT";
        public static final String TM_MIN_STAKE_TYPE_TMPRO = "TM_MIN_STAKE_TYPE_TMPRO";
        public static final String TM_MIN_STAKE_WAGER_TMPRO = "TM_MIN_STAKE_WAGER_TMPRO";
        public static final String TM_MAX_STAKE = "TM_MAX_STAKE";
        public static final String CANCELABLE_COUPON_MINUTES_PREFIX = "_CANCELABLE_COUPON_MINUTES";
        public static final String PRIZE_MAX_AMOUNT_LIMIT = "PRIZE_MAX_AMOUNT_LIMIT";
        public static final String HIGH_PRIZE_DRAW_DAYS = "HIGH_PRIZE_DRAW_DAYS";
        public static final String COIN_ACCEPTOR_LIMIT = "COIN_ACCEPTOR_LIMIT";
        public static final String BILL_ACCEPTOR_LIMIT = "BILL_ACCEPTOR_LIMIT";
        public static final String GAME_RULE_URL = "GAME_RULE_URL";
        public static final String EXPIRE_DATE = "WITHDRAW_EXPIRE_DATE";

        private CommonParameters() {
        }
    }
}
