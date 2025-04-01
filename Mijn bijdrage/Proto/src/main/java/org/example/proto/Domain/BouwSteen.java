package org.example.proto.Domain;

public class BouwSteen {
        private Status status;
        private Data data;

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
}
