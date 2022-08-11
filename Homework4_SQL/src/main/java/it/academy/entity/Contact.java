package it.academy.entity;

import java.util.Objects;

public class Contact {
    String address;
    String telephone;
    String email;
    String url;

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(address, contact.address)
                && Objects.equals(telephone, contact.telephone)
                && Objects.equals(email, contact.email) && Objects.equals(url, contact.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, telephone, email, url);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "\nContact{" +
                "address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
