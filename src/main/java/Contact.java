public class Contact {

    private String id;
    private String firstname;
    private String lastname;
    private String email;

    public Contact (String id) {
        this.id = id;

        //TODO Get out of DB
        if(id.equals("1")) {
            this.firstname = "Wilke";
            this.lastname = "Klausing";
            this.email = "w.klausing@outlook.de";
        } else if(id.equals("2")) {
            this.firstname = "Tom";
            this.lastname = "Gruber";
            this.email = "tom.gruber@outlook.de";
        } else if(id.equals("3")) {
            this.firstname = "Anna";
            this.lastname = "Müller";
            this.email = "anna.mueller@outlook.de";
        } else {
            System.out.println("Fehler in Contact. ID gibt es nicht! ID: " + id);
            System.exit(0);
        }
    }

    public String id() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
