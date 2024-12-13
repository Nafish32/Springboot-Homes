package com.example.homes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // Hotel name

    private String location;  // Hotel location

    private String contactNumber;  // Hotel contact number

    private int rating = 0; // Default rating is zero (0 to 5 stars)

    @ElementCollection
    @CollectionTable(name = "hotel_images", joinColumns = @JoinColumn(name = "hotel_id"))
    @Column(name = "image_path")
    private List<String> images;  // List to store paths of the images of the hotel

    @Transient
    private List<String> base64Images; // For UI display purposes, not stored in DB

    private int onePersonRoomCount;  // Number of 1-person rooms
    private BigDecimal onePersonRoomCost;  // Cost per 1-person room
    private String onePersonRoomDescription;  // Description of the 1-person room

    private int twoPersonRoomCount;  // Number of 2-person rooms
    private BigDecimal twoPersonRoomCost;  // Cost per 2-person room
    private String twoPersonRoomDescription;  // Description of the 2-person room

    private int threePersonRoomCount;  // Number of 3-person rooms
    private BigDecimal threePersonRoomCost;  // Cost per 3-person room
    private String threePersonRoomDescription;  // Description of the 3-person room

    private int fourPersonRoomCount;  // Number of 4-person rooms
    private BigDecimal fourPersonRoomCost;  // Cost per 4-person room
    private String fourPersonRoomDescription;  // Description of the 4-person room

    private int vipSuiteCount;  // Number of VIP suites
    private BigDecimal vipSuiteCost;  // Cost per VIP suite
    private String vipSuiteDescription;  // Description of the VIP suite

    @Lob
    private String generalDescription;  // General description of the hotel

    @Column(name = "hotel_category")
    private int category;  // Hotel category (1 to 5 stars)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getBase64Images() {
        return base64Images;
    }

    public void setBase64Images(List<String> base64Images) {
        this.base64Images = base64Images;
    }

    public int getOnePersonRoomCount() {
        return onePersonRoomCount;
    }

    public void setOnePersonRoomCount(int onePersonRoomCount) {
        this.onePersonRoomCount = onePersonRoomCount;
    }

    public BigDecimal getOnePersonRoomCost() {
        return onePersonRoomCost;
    }

    public void setOnePersonRoomCost(BigDecimal onePersonRoomCost) {
        this.onePersonRoomCost = onePersonRoomCost;
    }

    public String getOnePersonRoomDescription() {
        return onePersonRoomDescription;
    }

    public void setOnePersonRoomDescription(String onePersonRoomDescription) {
        this.onePersonRoomDescription = onePersonRoomDescription;
    }

    public int getTwoPersonRoomCount() {
        return twoPersonRoomCount;
    }

    public void setTwoPersonRoomCount(int twoPersonRoomCount) {
        this.twoPersonRoomCount = twoPersonRoomCount;
    }

    public BigDecimal getTwoPersonRoomCost() {
        return twoPersonRoomCost;
    }

    public void setTwoPersonRoomCost(BigDecimal twoPersonRoomCost) {
        this.twoPersonRoomCost = twoPersonRoomCost;
    }

    public String getTwoPersonRoomDescription() {
        return twoPersonRoomDescription;
    }

    public void setTwoPersonRoomDescription(String twoPersonRoomDescription) {
        this.twoPersonRoomDescription = twoPersonRoomDescription;
    }

    public int getThreePersonRoomCount() {
        return threePersonRoomCount;
    }

    public void setThreePersonRoomCount(int threePersonRoomCount) {
        this.threePersonRoomCount = threePersonRoomCount;
    }

    public BigDecimal getThreePersonRoomCost() {
        return threePersonRoomCost;
    }

    public void setThreePersonRoomCost(BigDecimal threePersonRoomCost) {
        this.threePersonRoomCost = threePersonRoomCost;
    }

    public String getThreePersonRoomDescription() {
        return threePersonRoomDescription;
    }

    public void setThreePersonRoomDescription(String threePersonRoomDescription) {
        this.threePersonRoomDescription = threePersonRoomDescription;
    }

    public int getFourPersonRoomCount() {
        return fourPersonRoomCount;
    }

    public void setFourPersonRoomCount(int fourPersonRoomCount) {
        this.fourPersonRoomCount = fourPersonRoomCount;
    }

    public BigDecimal getFourPersonRoomCost() {
        return fourPersonRoomCost;
    }

    public void setFourPersonRoomCost(BigDecimal fourPersonRoomCost) {
        this.fourPersonRoomCost = fourPersonRoomCost;
    }

    public String getFourPersonRoomDescription() {
        return fourPersonRoomDescription;
    }

    public void setFourPersonRoomDescription(String fourPersonRoomDescription) {
        this.fourPersonRoomDescription = fourPersonRoomDescription;
    }

    public int getVipSuiteCount() {
        return vipSuiteCount;
    }

    public void setVipSuiteCount(int vipSuiteCount) {
        this.vipSuiteCount = vipSuiteCount;
    }

    public BigDecimal getVipSuiteCost() {
        return vipSuiteCost;
    }

    public void setVipSuiteCost(BigDecimal vipSuiteCost) {
        this.vipSuiteCost = vipSuiteCost;
    }

    public String getVipSuiteDescription() {
        return vipSuiteDescription;
    }

    public void setVipSuiteDescription(String vipSuiteDescription) {
        this.vipSuiteDescription = vipSuiteDescription;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
