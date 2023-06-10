import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task1 {
   public static void main(String[] args) {
    NotebookTask1 notebook1 = new NotebookTask1("Asus", "4", "1000", "Windows", "grey");
    NotebookTask1 notebook2 = new NotebookTask1("Asus", "4", "1000", "Lunex", "black");
    NotebookTask1 notebook3 = new NotebookTask1("Asus", "4", "2000", "Windows", "black");
    NotebookTask1 notebook4 = new NotebookTask1("Asus", "16", "1000", "Windows", "grey");
    NotebookTask1 notebook5 = new NotebookTask1("Huawei", "8", "1000", "Windows", "black");

      Set<NotebookTask1> notebooks = new HashSet<>(List.of(notebook1, notebook2,
            notebook3, notebook4, notebook5));

      Map<String, String> sel = selectCriteria();
      sort(sel, notebooks);

   }

   public static String scanner() {
      Scanner scanner = new Scanner(System.in);
      String scan = scanner.nextLine();
      return scan;
   }

   public static Map<String, String> selectCriteria() {
      Map<String, String> resultCriterias = new HashMap<>();
      while (true) {
         System.out.println("Вы хотите выбрать критерий? Если да введите 'y', если нет введите 'n'");
         String question = scanner();
         if (question.equals("n")) {
            break;
         } else {

            System.out.println(
                  "Введите цифру, соответствующую необходимому критерию: \n 1 - Цвет \n 2 - Бренд \n 3 - ОЗУ \n 4 - Объем ЖД \n 5 - Операционная система ");
            String key = scanner();
            System.out.println("Введите значения для выбранного критерия: ");
            String value = scanner();

            resultCriterias.put(key, value);
         }
      }
      System.out.println(resultCriterias);
      return resultCriterias;

   }

   public static void sort(Map<String, String> criterias, Set<NotebookTask1> notebooks) {

      Set<NotebookTask1> temp = new HashSet<>(notebooks);
      for (NotebookTask1 notebook : notebooks) {

         for (Object pair : criterias.keySet()) {

            if (pair.equals("1") && !notebook.getColour().equals(criterias.get(pair))) {
               temp.remove(notebook);
            }
            for (Object pair1 : criterias.keySet()) {

               if (pair1.equals("2") && !notebook.getName().equals(criterias.get(pair1))) {
                  temp.remove(notebook);

               }
               for (Object pair2 : criterias.keySet()) {

                  if (pair2.equals("3") && !notebook.getRam().equals(criterias.get(pair2))) {
                     temp.remove(notebook);

                  }
                  for (Object pair3 : criterias.keySet()) {

                     if ( pair3.equals("4") && !notebook.getHardDisk().equals(criterias.get(pair3))) {
                        temp.remove(notebook);

                     }
                     for (Object pair4 : criterias.keySet()) {

                        if (pair4.equals("5") && !notebook.getOperatingSystem().equals(criterias.get(pair4))) {
                           temp.remove(notebook);

                        }
                     }
                  }
               }
            }
         }

      }
      if (temp.isEmpty()) {
         System.out.println("По введенным критериям ничего не найдено!");
      } else {
         System.out.println("Вот что мы можем предложить: \n" + temp.toString());
      }

   }

}