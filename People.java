public class People {
   
    private String name;
    private String cmnd;
    private int age;
    private String gender;
    private String address;
    private String addressNow;
    private String health;

    String[] listmove;

    public People(){
        this.health = "Binh Thuong!";
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCmnd() {
        return cmnd;
    }
    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddressNow() {
        return addressNow;
    }
    public void setAddressNow(String addressNow) {
        this.addressNow = addressNow;
    }
    public String getHealth() {
        return health;
    }
    public void setHealth(String health) {
        this.health = health;
    }

    public void showInfo(){
        System.out.println("Ho va ten           CMND                Tuoi      Gioi tinh      Dia Chi Thuong Tru       Dia Chi Tam Tru          Health  ");
        String s = String.format("%-20s%-20s%-15d%-10s%-25s%-25s%-20s",
                                 name, cmnd, age, gender, address, addressNow, health);
        System.out.println(s);
        System.out.println("Lich trinh di chuyen:");
        try {
            for (String string : listmove) {
                System.out.println(string);
            }
        } catch (Exception e) {
            System.out.println("Lich trinh di chuyen trong.");
        }
    }
}
