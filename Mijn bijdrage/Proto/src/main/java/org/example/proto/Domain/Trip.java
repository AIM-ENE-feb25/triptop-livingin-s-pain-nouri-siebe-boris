package org.example.proto.Domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "trip")
@TypeAlias("Trip")
public class Trip {
        @Id
        private ObjectId id;
        private String gebruikersnaam;
        private List<Reiziger> reizigers;
        private List<BouwSteen> bouwStenen;

        public Trip() {
                this.reizigers = new ArrayList<>();
                this.bouwStenen = new ArrayList<>();
        }

        public Trip(String gebruikersnaam) {
                this();
                this.gebruikersnaam = gebruikersnaam;
        }

        // Getters and Setters
        public ObjectId getId() {
                return id;
        }

        public void setId(ObjectId id) {
                this.id = id;
        }

        public String getGebruikersnaam() {
                return gebruikersnaam;
        }

        public void setGebruikersnaam(String gebruikersnaam) {
                this.gebruikersnaam = gebruikersnaam;
        }

        public List<Reiziger> getReizigers() {
                return reizigers;
        }

        public void setReizigers(List<Reiziger> reizigers) {
                this.reizigers = reizigers;
        }

        public List<BouwSteen> getBouwStenen() {
                return bouwStenen;
        }

        public void setBouwStenen(List<BouwSteen> bouwStenen) {
                this.bouwStenen = bouwStenen;
        }

        public void voegBouwSteenToe(BouwSteen bouwSteen) {
                if (this.bouwStenen == null) {
                        this.bouwStenen = new ArrayList<>();
                }
                this.bouwStenen.add(bouwSteen);
        }

        public void voegReizigerToe(Reiziger reiziger) {
                if (this.reizigers == null) {
                        this.reizigers = new ArrayList<>();
                }
                this.reizigers.add(reiziger);
        }
}