// package commands;

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.util.Deque;
// import java.util.Scanner;

// import data.LabWork;

// public class ExecuteScript implements Command{
//     @Override 
//     public void execute(Deque<LabWork> labWork){
//         boolean approved = false;
//         Scanner scan = new Scanner(System.in);
//         while (approved == false){
//             System.out.print("Введите название файла: ");
//             String scan_file = scan.nextLine().trim();
//             try {
//                 Path file = Paths.get(scan_file);
//                 if (Files.exists(file)) {
//                     approved = true;
//                     CommandMeneger command = new CommandMeneger();

//                     Scanner scanFile = new Scanner(file);
//                     while (scanFile.hasNextLine()) {
//                         String scancom = scanFile.nextLine().trim();
//                         if (scancom.equals("exit")){
//                             System.out.println("Заверешение работы программы без сохранения коллекции.");
//                             break;
//                         }
//                         else if (command.thisIsCommand(scancom)){
//                             command.execute(labWork, scancom);
//                         } else if (scancom.isEmpty()){
//                         } else {
//                             System.out.println("\nКоманда не распознана. Исполнение скрипта завершено.\nВведите help, чтобы узнать доступные команды.");
//                             break;
//                         }
//                     }
//                 } else {
//                     System.out.println("Файл не найдет или нет доступа к нему.");
//                 }
//             } catch (IOException e) {}
//         }
//     }
// }