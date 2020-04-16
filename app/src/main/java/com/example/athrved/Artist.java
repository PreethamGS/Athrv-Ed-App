package com.example.athrved;

public class Artist {



        private String Id;
        private String Name1;
        private String Name2;
        private String Name3;
        private String Name4;
        private String Name5;
        private String Name6;


    public Artist() {
        }



        public Artist(String Id, String Name1, String Name2, String Name3, String Name4, String Name5, String Name6) {
            this.Id = Id;
            this.Name1 = Name1;
            this.Name2 = Name2;
            this.Name3 = Name3;
            this.Name4 = Name4;
            this.Name5 = Name5;
            this.Name6 = Name6;
        }

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public String getName1() {
            return Name1;
        }

        public void setName1(String name1) {
            Name1 = name1;
        }

        public String getName2() {
            return Name2;
        }

        public void setName2(String name2) {
            Name2 = name2;
        }

        public String getName3() {
            return Name3;
        }

        public void setName3(String name3) {
            Name3 = name3;
        }

        public String getName4() {
            return Name4;
        }

        public void setName4(String name4) {
            Name4=name4;
        }
    public String getName5() {
        return Name5;
    }

    public void setName5(String name5) {
        Name5 = name5;
    }
    public String getName6() {
        return Name6;
    }

    public void setName6(String name6) {
        Name6 = name6;
    }

}
