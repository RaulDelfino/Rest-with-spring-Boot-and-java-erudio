package br.com.erudio.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id" , "address", "first_name", "last_name", "gender"})
public class PersonVO extends  RepresentationModel<PersonVO> implements Serializable{
    
    private static final long serialVersionUID =1L;
    
    @JsonProperty("id")
    private long key;

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String address;
    private String gender;


    public PersonVO() {}


    public Long getKey() {
        return this.key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PersonVO)) {
            return false;
        }
        PersonVO person = (PersonVO) o;
        return Objects.equals(key, person.key) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, firstName, lastName, address, gender);
    }

}
