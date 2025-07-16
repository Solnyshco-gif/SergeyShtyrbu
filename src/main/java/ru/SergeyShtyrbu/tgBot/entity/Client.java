package ru.SergeyShtyrbu.tgBot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "External ID must not be null")
    private Long externalId;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "Full name must not be blank")
    @Size(max = 255, message = "Full name must not exceed 255 characters")
    private String fullName;

    @Column(nullable = false, length = 15)
    @NotBlank(message = "Phone number must not be blank")
    @Size(max = 15, message = "Phone number must not exceed 15 characters")
    private String phoneNumber;

    @Column(nullable = false, length = 400)
    @NotBlank(message = "Address must not be blank")
    @Size(max = 400, message = "Address must not exceed 400 characters")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long externalId) {
        this.externalId = externalId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}