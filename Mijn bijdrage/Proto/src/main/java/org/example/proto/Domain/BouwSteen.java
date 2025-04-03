package org.example.proto.Domain;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.mongodb.core.mapping.Field;

public class BouwSteen {
    @Field("status")
    private Status status;

    @Field("provider")
    private String provider;

    @Field("categorie")
    private String categorie;

    @Field("data")
    private Data data;


    public BouwSteen(Status status, String categorie, String provider, JsonNode jsonData) {
        this.provider = provider;
        this.categorie = categorie;
        this.status = status;
        this.data = new Data(jsonData);
    }

    public void voegDataToe(Data data) {
        this.data = data;
    }

    public void stelStatusIn(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
