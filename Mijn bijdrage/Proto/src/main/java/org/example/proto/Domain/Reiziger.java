package org.example.proto.Domain;

import org.springframework.data.mongodb.core.mapping.Field;

public class Reiziger {
    @Field("voornaam")
    private String voornaam;

    @Field("achternaam")
    private String achternaam;

    @Field("geboortedatum")
    private String geboortedatum;

    public Reiziger(String voornaam, String achternaam, String geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public String getVoornaam() { return voornaam; }
    public String getAchternaam() { return achternaam; }
    public String getGeboortedatum() { return geboortedatum; }
}
