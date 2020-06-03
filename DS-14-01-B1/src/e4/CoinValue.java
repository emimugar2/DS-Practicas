package e4;

public enum CoinValue {
    UN_CENTIMO(1),
    DOS_CENTIMOS(2),
    CINCO_CENTIMOS(5),
    DIEZ_CENTIMOS(10),
    VEINTE_CENTIMOS(20),
    CINCUENTA_CENTIMOS(50),
    UN_EURO(100),
    DOS_EUROS(200);
    
    private final int value;

    private CoinValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
