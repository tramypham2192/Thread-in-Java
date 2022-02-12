import org.w3c.dom.NameList;

public class DisplayNameAndHometown implements Runnable {
    public String[] list1 = {};

    public DisplayNameAndHometown(String[] list1) {
        this.list1 = list1;
    }

    public static void main(String[] args) {
        String[] nameList = {"nguyen", "ngoc", "lan", "tran thi quynh", "pham duc loc", "phan thi thanh"};
        String[] hometownList = {"Hai Phong", "Ha Noi", "Sai Gon", "Da Nang", "Hue", "Nghe An"};

        DisplayNameAndHometown obj1 = new DisplayNameAndHometown(nameList);
        DisplayNameAndHometown obj2 = new DisplayNameAndHometown(hometownList);
        Thread thread1 = new Thread(obj1);
        Thread thread2 = new Thread(obj2);
        thread1.setName("thread so 1");
        thread1.start();

        thread2.setName("thread so 2");
        thread2.start();
    }

    public void run(){
        for (int i = 0; i < 5; i++){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is running and display " + this.list1[i]);
            } catch (InterruptedException e){
                System.out.println(e);
            } 
        }
        
    }
}
