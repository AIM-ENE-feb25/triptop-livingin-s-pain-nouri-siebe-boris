package org.example.proto.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Trip {
        @Id
        private Long id;
        private String gebruikersnaam;
        private List<Reiziger> reizigers;
        private List<BouwSteen> bouwStenen;



        public void voegBouwSteenToe(BouwSteen bouwSteen) {
        }

        public void voegReizigerToe(Reiziger reiziger) {
        }
}
