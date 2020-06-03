package e2;

public class Polymers {

    private static final String MAYUS = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private static final String MINUS = ("abcdefghijklmnopqrstuvwxyz");

    public static String processPolymer(String polymer) {
        if (polymer != null) {
            StringBuilder polimero = new StringBuilder(polymer);
            for (int i = 0; i < polimero.length() - 1; i++) {
                if ((polimero.codePointAt(i) == polimero.codePointAt(i + 1) - 32)
                        || polimero.codePointAt(i) - 32 == polimero.codePointAt(i + 1)) {
                    polimero.delete(i, i + 2);
                    i = -1;
                }
            }
            return polimero.toString();
        } else {
            throw new IllegalArgumentException("Polimero vacio");

        }

    }

    public static char minProcessedPolymer(String polymer) {

        if (polymer != null) {
            if (polymer.length() != 0) {

                char monomerMinus;
                char monomerMayus;
                char ganador = ' ';
                String candidato = polymer;
                String aux;
                for (int i = 0; i < MINUS.length(); i++) {
                    monomerMinus = MINUS.charAt(i);
                    monomerMayus = MAYUS.charAt(i);
                    StringBuilder polimero = new StringBuilder(polymer);
                    for (int j = 0; j < polimero.length(); j++) {
                        if (polimero.charAt(j) == monomerMinus || polimero.charAt(j) == monomerMayus) {
                            polimero.deleteCharAt(j);
                            j = j - 1;
                        }
                    }
                    aux = processPolymer(polimero.toString());
                    System.out.println("despues de eliminar " + monomerMinus + " nos queda " + aux);
                    if (aux.length() < candidato.length()) {
                        candidato = aux;
                        ganador = monomerMinus;
                    }
                }
                return ganador;
            } else {
                throw new IllegalArgumentException("Polimero vacio");
            }
        } else {
            throw new IllegalArgumentException("Nulo");
        }
    }
}
