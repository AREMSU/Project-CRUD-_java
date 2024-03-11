package org.example.models;
import java.util.ArrayList;
import java.util.List;
public class homescreen {
    private List<drugs> drugList;

    public homescreen() {
        drugList = new ArrayList<>();
    }

    public void addDrug(drugs drug) {
        drugList.add(drug);
    }

    public List<drugs> getDrugList() {
        return drugList;
    }
    public drugs searchDrugByName(String name) {
        for (drugs drug : drugList) {
            if (drug.getName().equalsIgnoreCase(name)) {
                return drug;
            }
        }
        return null;
    }
}

