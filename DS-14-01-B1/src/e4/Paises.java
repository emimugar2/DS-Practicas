package e4;

public enum Paises {
    AUSTRIA("AT"),
    BELGIUM("BE"),
    CYPRUS("CY"),
    NETHERLANDS("NL"),
    ESTONIA("EE"),
    FINLAND("FI"),
    FRANCE("FR"),
    GERMANY("DE"),
    GREECE("GR"),
    IRELAND("IE"),
    ITALY("IT"),
    LATVIA("LV"),
    LITHUANIA("LT"),
    LUXEMBURG("LU"),
    MALTA("MT"),
    MONACO("MC"),
    PORTUGAL("PT"),
    SAN_MARINO("SM"),
    SLOVAKIA("SK"),
    SLOVENIA("SI"),
    SPAIN("ES"),
    VATICAN_CITY("VA");
    
    private final String ISO;

    private Paises(String ISO) {
        this.ISO = ISO;
    }

    public String getISO() {
        return ISO;
    }
    
    
}
