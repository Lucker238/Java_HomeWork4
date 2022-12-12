import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
     ArrayList<String> list_n = new ArrayList<>();   
     ArrayList<String> list_f = new ArrayList<>();   
     ArrayList<String> list_t = new ArrayList<>();   
     ArrayList<Boolean> list_g = new ArrayList<>();   
     ArrayList<Integer> list_age = new ArrayList<>();
     List<Integer> linked_list = new LinkedList<>(); 
     
     boolean check = true;
     while (check) {
        Scanner scanner_fio = new Scanner(System.in);
        Scanner scanner_age = new Scanner(System.in);
        Scanner scanner_gen = new Scanner(System.in);
        Scanner scanner_check = new Scanner(System.in);

        System.out.println("Введите ваше ФИО: ");
        String fio = scanner_fio.nextLine();
        System.out.println("Введите свой возраст: ");
        Integer age = scanner_age.nextInt();
        System.out.println("Введите ваш пол (М/Ж): ");
        String gen = scanner_gen.nextLine();
        String[] fio_array = fio.split(" ");
        if (fio.length()==3) {
            list_f.add(fio_array[0]);
            list_n.add(fio_array[1]);
            list_t.add(fio_array[2]);
        }
        else if (fio.length()==2) {
            list_f.add(fio_array[0]);
            list_n.add(fio_array[1]);
            list_t.add("");
        }
        else {
            list_f.add(fio_array[0]);
            list_n.add("");
            list_t.add(" ");
        }

        list_age.add(age);

        if (gen.contains("М")){
            list_g.add(true);
        }
        else {
            list_g.add(false);
        }

        linked_list.add(list_n.size() - 1);

        System.out.println("Хотите продолжить? (Y/N)");
        String contin = scanner_check.nextLine();
        if (contin.toUpperCase().equals("N")) {
            check = false;
        }       
     }
     
     int count = list_n.size() - 1;
     while (count >= 0) {
        int max_age = list_age.get(linked_list.get(count));
        int index = count;
        for (int i = 0; i < count; i++) {
            if(max_age < list_age.get(linked_list.get(i))) {
                max_age = list_age.get(linked_list.get(i));
                index = i;
            }            
        }
        int tmp = linked_list.get(count);
        linked_list.set(count, linked_list.get(index));
        linked_list.set(index, tmp);
        count--;
     }
     
    }
}