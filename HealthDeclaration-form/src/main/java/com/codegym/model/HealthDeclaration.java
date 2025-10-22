package com.codegym.healthform.model;

import jakarta.validation.constraints.*;

public class HealthDeclaration {
    @NotBlank(message = "Họ tên bắt buộc")
    private String fullName;

    @NotNull(message = "Năm sinh bắt buộc")
    private Integer yearOfBirth;

    @NotBlank(message = "Giới tính bắt buộc")
    private String gender;

    @NotBlank(message = "Quốc tịch bắt buộc")
    private String nationality;

    @NotBlank(message = "Số CMND/Hộ chiếu bắt buộc")
    private String identityNumber;

    private String vehicleType;
    private String vehicleNumber;
    private String seatNumber;

    @NotBlank(message = "Ngày khởi hành bắt buộc")
    private String departureDate;

    @NotBlank(message = "Ngày kết thúc bắt buộc")
    private String endDate;

    private String visitedPlaces;

    @NotBlank(message = "Tỉnh/Thành phố bắt buộc")
    private String province;

    @NotBlank(message = "Quận/Huyện bắt buộc")
    private String district;

    @NotBlank(message = "Phường/Xã bắt buộc")
    private String ward;

    @NotBlank(message = "Địa chỉ cụ thể bắt buộc")
    private String address;

    @NotBlank(message = "Số điện thoại bắt buộc")
    private String phone;

    @Email(message = "Email không hợp lệ")
    private String email;

    // Triệu chứng
    private boolean fever;
    private boolean cough;
    private boolean difficultyBreathing;
    private boolean soreThroat;
    private boolean nausea;
    private boolean diarrhea;
    private boolean skinBleeding;
    private boolean skinRash;

    // Lịch sử phơi nhiễm
    private boolean contactAnimals;
    private boolean closeContactPatient;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getVisitedPlaces() {
        return visitedPlaces;
    }

    public void setVisitedPlaces(String visitedPlaces) {
        this.visitedPlaces = visitedPlaces;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isDifficultyBreathing() {
        return difficultyBreathing;
    }

    public void setDifficultyBreathing(boolean difficultyBreathing) {
        this.difficultyBreathing = difficultyBreathing;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isNausea() {
        return nausea;
    }

    public void setNausea(boolean nausea) {
        this.nausea = nausea;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isSkinBleeding() {
        return skinBleeding;
    }

    public void setSkinBleeding(boolean skinBleeding) {
        this.skinBleeding = skinBleeding;
    }

    public boolean isSkinRash() {
        return skinRash;
    }

    public void setSkinRash(boolean skinRash) {
        this.skinRash = skinRash;
    }

    public boolean isContactAnimals() {
        return contactAnimals;
    }

    public void setContactAnimals(boolean contactAnimals) {
        this.contactAnimals = contactAnimals;
    }

    public boolean isCloseContactPatient() {
        return closeContactPatient;
    }

    public void setCloseContactPatient(boolean closeContactPatient) {
        this.closeContactPatient = closeContactPatient;
    }
}
