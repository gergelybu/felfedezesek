package felfedezesek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Feladatok {

    private Felfedezes[] felfedezesek;

    public static void main(String[] args) throws IOException {
        new Feladatok().feladatok();
    }

    public Feladatok() throws IOException {
        List<String> sorok = Files.readAllLines(Path.of("felfedezesek.csv"));
        assert !sorok.isEmpty() : "üres a fájl";

        felfedezesek = new Felfedezes[sorok.size() - 1];
        for (int i = 0; i < sorok.size() - 1; i++) {
            String sor = sorok.get(i + 1);
            Felfedezes felfedezes = new Felfedezes(sor);
            felfedezesek[i] = felfedezes;
        }
    }

    private void feladatok() throws IOException {
        feladat1();
        feladat2();
        feladat3();
        feladat4();
    }

    private void feladat1() {
        System.out.println("Mit fedeztek fel 1944-ben?");
        int i = 1;
        while (i < felfedezesek.length && !felfedezesek[i].getEv().equals("1944")) {
            i++;
        }
        System.out.println(felfedezesek[i]);
        System.out.println("----------");
    }

    private void feladat2() {
        System.out.println("Történt felfedezés 1975-ben?");
        int i = 0;
        while (i < felfedezesek.length && !felfedezesek[i].getEv().equals("1975")) {
            i++;
        }
        System.out.println(i < felfedezesek.length ? "igen" : "nem");
        System.out.println("----------");
    }

    private void feladat3() {
        System.out.println("Melyik években történt felfedezés?");
        Set<String> evek = new HashSet<>();
        for (Felfedezes felfed : felfedezesek) {
            evek.add(felfed.getEv());
        }
        for (String ev : evek) {
            System.out.println(ev);
        }
        System.out.println("----------");
    }

    private void feladat4() {
        System.out.println("Ki hány darab felfedezést tett?");
        Map<String, Integer> felfedDb = new HashMap<>();
        for (Felfedezes felfedezes : felfedezesek) {
            String kulcs = felfedezes.getFelfedezo();
            if (felfedDb.containsKey(kulcs)) {
                int ertek = felfedDb.get(kulcs);
                felfedDb.put(kulcs, ++ertek);

            } else {
                felfedDb.put(kulcs, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : felfedDb.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("%-12s: %4d db\n", key, value);
        }
    }
}
