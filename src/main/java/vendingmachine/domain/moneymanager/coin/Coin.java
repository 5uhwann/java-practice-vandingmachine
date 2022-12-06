package vendingmachine.domain.moneymanager.coin;

public enum Coin {
    COIN_500(500, "500원 - "),
    COIN_100(100, "100원 - "),
    COIN_50(50, "50원 - "),
    COIN_10(10, "10원 - ");

    private final int amount;
    private final String koreanTag;

    Coin(final int amount, String koreanTag) {
        this.amount = amount;
        this.koreanTag = koreanTag;
    }

    // 추가 기능 구현
    public int getAmount() {
        return amount;
    }

    public String getKoreanTag() {
        return koreanTag;
    }

    public boolean isAbleCoin(int remainderAmount) {
        return remainderAmount >= amount;
    }
}
