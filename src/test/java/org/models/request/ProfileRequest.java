package org.models.request;

public class ProfileRequest {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;

//Making the constructor as private so we can create the object only from the class itself not outside the class ,
    //in design builder also we can make it private
    private ProfileRequest(String firstName, String lastName, String mobileNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ProfileRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private String mobileNumber;
        private String email;

        public Builder firstName(String firstName){
            this.firstName =firstName;
            return this;

        }
        public Builder lastName(String lastName){
            this.lastName =lastName;
            return this;

        }
        public Builder mobileNumber(String mobileNumber){
            this.mobileNumber =mobileNumber;
            return this;

        }
        public Builder email(String email){
            this.email =email;
            return this;

        }

        public ProfileRequest build(){
            ProfileRequest profileRequest= new ProfileRequest(firstName, lastName, mobileNumber, email);
            return profileRequest;
        }

    }
}
