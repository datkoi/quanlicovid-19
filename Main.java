import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<People> peoples = new ArrayList<>();
        int key = 0;
        do {
            menu();
            key =  Integer.parseInt(scanner.nextLine());
            switch (key) {
                case 1:{
                    inputPerson(peoples);
                    break;
                }
                case 2:{
                    searchName(peoples);
                    break;
                }
                case 3:{
                    searchCmnd(peoples);
                    break;
                }
                case 4:{
                    thietlapsuckhoe(peoples);
                    break;
                }
                case 5:{
                    thietlapdichuyen(peoples);
                    break;
                }
                case 6:{
                    truyxuat(peoples);
                    break;
                }
                case 7:{
                    showInfoDuongtinh(peoples);
                    break;
                }
                case 8:{
                    showInfoTheodoi(peoples);
                    break;
                }
                case 9:{
                    break;
                }
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (key != 9);
    }
    public static void menu(){
        System.out.println("1. Lap danh sach cac cong dan o Viet Nam.");
        System.out.println("2. Tim kiem thong tin benh nhan theo ten.");
        System.out.println("3. Tim kiem benh nhan theo CMND.");
        System.out.println("4. Thiet lap tinh trang suc khoe.");
        System.out.println("5. Thiet lap lo trinh di chuyen cua mot benh nhan.");
        System.out.println("6. Thiet lap trang thai benh nhan da tiep xuc voi benh nhan duong tinh voi Covid-19.");
        System.out.println("7. Hien thi benh nhan duong tinh voi Covid-19.");
        System.out.println("8. Hien thi benh nhan dang theo doi.");
        System.out.println("9. Thoat!");
        System.out.println("Choose:");
    }

    public static ArrayList<People> inputPerson(ArrayList<People> peoples){
        System.out.println("Nhap so nguoi can them: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            People people = new People();
            System.out.println("Nhap nhap thong tin cua nguoi thu:"+i+" ");
            System.out.println("Ten: ");
            people.setName(scanner.nextLine());
            System.out.println("CMND: ");
            people.setCmnd(scanner.nextLine());
            System.out.println("Tuoi: ");
            people.setAge(Integer.parseInt(scanner.nextLine()));
            System.out.println("Gioi tinh: ");
            people.setGender(scanner.nextLine());
            System.out.println("Dia chi thuong tru: ");
            people.setAddress(scanner.nextLine());
            System.out.println("Dia chi tam tru: ");
            people.setAddressNow(scanner.nextLine());
            peoples.add(people);
        }
        return peoples;
    }

    public static void searchName(ArrayList<People> peoples){
        System.out.println("Nhap ten can tim: ");
        String name = scanner.nextLine();
        int index = 0;
        for (People people : peoples) {
            if(name.equals(people.getName())){
                people.showInfo();
                index++;
            }
        }
        if(index == 0){
            System.out.println("Khong tim thay ten "+name);
        }
    }
    public static void searchCmnd(ArrayList<People> peoples){
        System.out.println("Nhap CMND can tim: ");
        String cmnd = scanner.nextLine();
        int index = 0;
        for (People people : peoples) {
            if(cmnd.equals(people.getCmnd())){
                people.showInfo();
                index++;
            }
        }
        if(index == 0){
            System.out.println("Khong tim thay CMND: "+cmnd);
        }
    }

    public static void thietlapsuckhoe(ArrayList<People> peoples){
        System.out.println("Nhap CMND can tim: ");
        String cmnd = scanner.nextLine();
        int index = 0;
        for (People people : peoples) {
            if(cmnd.equals(people.getCmnd())){
                System.out.println("Nhap tinh trang suc khoe cua "+people.getName()+": ");
                people.setHealth(scanner.nextLine());
                index++;
            }
        }
        if(index == 0){
            System.out.println("Khong tim thay CMND: "+cmnd);
        }
    }

    public static void thietlapdichuyen(ArrayList<People> peoples){
        System.out.println("Nhap CMND can tim: ");
        String cmnd = scanner.nextLine();
        int index = 0;
        for (People people : peoples) {
            if(cmnd.equals(people.getCmnd())){
                if(people.getHealth().toLowerCase().contains("duong tinh") || people.getHealth().toLowerCase().contains("theo doi")){
                    System.out.println("Nhap so ngay di chuyen cua benh nhan :");
                    int n = Integer.parseInt(scanner.nextLine());
                    people.listmove = new String[n];
                    for(int i = 0 ; i < n ;i ++){
                        System.out.println("Nhap lich trinh ngay thu "+(i+1)+": ");
                        people.listmove[i] = scanner.nextLine();
                    }
                }
                else{
                    System.out.println(people.getName()+" binh thuong!");
                }
                index++;
            }
            
        }
        if(index == 0){
            System.out.println("Khong tim thay CMND: "+cmnd);
        }
    } 
    
    public static void truyxuat(ArrayList<People> peoples){
        System.out.println("Nhap CMND can tim: ");
        String cmnd = scanner.nextLine();
        int index = 0;
        for (People people : peoples) {
            if(cmnd.equals(people.getCmnd())){
                if(people.getHealth().toLowerCase().contains("duong tinh") || people.getHealth().toLowerCase().contains("theo doi")){
                    for (People people2 : peoples) {
                        if(people2.getHealth().toLowerCase().contains("duong tinh") || people2.getHealth().toLowerCase().contains("theo doi")){
                            continue;
                        }
                        else{
                            for (int i = 0; i < people.listmove.length; i++) {
                                if(people.listmove[i].toLowerCase().contains(people2.getAddressNow().toLowerCase())){
                                    people2.setHealth("Theo doi");
                                    break;
                                }
                            }
                        }
                    }
                }
                else{
                    System.out.println(people.getName()+" binh thuong!");
                }
                index++;
            }
            
        }
        if(index == 0){
            System.out.println("Khong tim thay CMND: "+cmnd);
        }
        else{
            System.out.println("Da thiep lap tiep xuc voi nguoi duong tinh.");
        }
    }

    public static void showInfoDuongtinh(ArrayList<People> peoples){
        for (People people : peoples) {
            if(people.getHealth().toLowerCase().contains("duong tinh")){
                people.showInfo();
            }
        }
    }

    public static void showInfoTheodoi(ArrayList<People> peoples){
        for (People people : peoples) {
            if(people.getHealth().toLowerCase().contains("theo doi")){
                people.showInfo();
            }
        }
    }
}
