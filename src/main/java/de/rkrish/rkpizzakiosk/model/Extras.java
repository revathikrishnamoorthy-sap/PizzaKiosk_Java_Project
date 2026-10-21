package de.rkrish.rkpizzakiosk.model;

import java.util.ArrayList;
import java.util.List;

public class Extras extends ArrayList<Extra> {
    public List<String> getName() {
        List<String> extraNames = new ArrayList<>();

        for (Extra extra : this) {
            extraNames.add(extra.name());
        }
        return extraNames;
    }
}
