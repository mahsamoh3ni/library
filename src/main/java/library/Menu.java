package library;

import library.model.ProductType;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public Menu() throws IOException {
    }

    public void mainMenu() {
        boolean isFinished = false;
        while (!isFinished) {
            System.out.println("1. Login as a member" +
                    "\n" +
                    "2. Login as manager: " +
                    "\n" +
                    "3. Exit");
            int loginInput = scanner.nextInt();
            try {
                switch (loginInput) {
                    case 1:
                        System.out.println("Please enter userId:");
                        int userId = scanner.nextInt();
                        System.out.println("Please enter password");
                        String userPassword = scanner.next();
                        if (library.checkMember(userId, userPassword))
                            memberMenu(userId);
                        break;
                    case 2:
                        managerMenu();
                        break;
                    case 3:
                        isFinished = true;
                        library.persistData();
                        break;
                    default:
                        System.out.println("Your choice invalid!" +
                                "\n" +
                                "Please Enter 1 or 2 or 3");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void managerMenu() {
        boolean isFinished = false;
        while (!isFinished) {
            System.out.println("1. Add a book:" +
                    "\n" +
                    "2. Add magazine:" +
                    "\n" +
                    "3. Add a member:" +
                    "\n" +
                    "4. View all member:" +
                    "\n" +
                    "5. View all books:" +
                    "\n" +
                    "6. View all magazine:" +
                    "\n" +
                    "7. Delete a book by id:" +
                    "\n" +
                    "8. Logout");
            int managerInput = scanner.nextInt();
            try {
                switch (managerInput) {
                    case 1:
                        System.out.println("Please enter bookId:");
                        int bookId = scanner.nextInt();
                        System.out.println("Please enter bookName:");
                        String bookName = scanner.next();
                        System.out.println("Please enter existNumber:");
                        int existNumber = scanner.nextInt();
                        System.out.println("Please enter productType: Romance / History / Geography / Educational / Cooking");
                        String type = scanner.next();
                        System.out.println("Please enter authorName:");
                        String authorName = scanner.next();
                        ProductType productType = ProductType.valueOf(type);
                        library.addBook(bookId, bookName, existNumber, productType, authorName);
                        break;

                    case 2:
                        System.out.println("Please enter magazineId:");
                        int magazineId = scanner.nextInt();
                        System.out.println("Please enter existNumber:");
                        int existNumber2 = scanner.nextInt();
                        System.out.println("Please enter productType: Geography / Educational / Cooking");
                        String type2 = scanner.next();
                        System.out.println("Please enter magazineNumber:");
                        int magazineNumber = scanner.nextInt();
                        System.out.println("Please enter magazineName:");
                        String magazineName = scanner.next();
                        System.out.println("Please enter day of magazineDate:");
                        int magazineDay = scanner.nextInt();
                        System.out.println("Please enter month of magazineDate:");
                        int magazineMonth = scanner.nextInt();
                        System.out.println("Please enter year of magazineDate:");
                        int magazineYear = scanner.nextInt();
                        ProductType productType2 = ProductType.valueOf(type2);
                        library.addNewMagazine(
                                magazineId,
                                magazineName,
                                existNumber2,
                                productType2,
                                magazineNumber,
                                magazineDay,
                                magazineMonth,
                                magazineYear);
                        break;

                    case 3:
                        System.out.println("Please enter firstName:");
                        String firstName = scanner.next();
                        System.out.println("Please enter lastName:");
                        String lastName = scanner.next();
                        System.out.println("Please enter nationalCode:");
                        int nationalCode = scanner.nextInt();
                        System.out.println("Please enter day of birthday:");
                        int memberDay = scanner.nextInt();
                        System.out.println("Please enter month of birthday:");
                        int memberMonth = scanner.nextInt();
                        System.out.println("Please enter year of birthday:");
                        int memberYear = scanner.nextInt();
                        System.out.println("please enter favoritePassword");
                        String password = scanner.next();
                        library.addNewMember(firstName,
                                lastName,
                                nationalCode,
                                memberDay,
                                memberMonth,
                                memberYear,
                                password);

                        break;

                    case 4:
                        library.viewMember();
                        break;

                    case 5:
                        library.viewProducts();
                        break;

                    case 6:
                        library.viewAllMagazine();
                        break;

                    case 7:
                        System.out.println("Please enter bookId:");
                        int bookId2 = scanner.nextInt();
                        library.deleteBook(bookId2);
                        break;

                    case 8:
                        isFinished = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void memberMenu(int userId) throws Exception {
        boolean isFinished = false;
        while (!isFinished) {
            System.out.println("1. Borrow a book:" +
                    "\n" +
                    "2. Borrow a magazine:" +
                    "\n" +
                    "3. Return a book:" +
                    "\n" +
                    "4. Return a magazine:" +
                    "\n" +
                    "5. View all borrowed books:" +
                    "\n" +
                    "6. View all borrowed Magazines:" +
                    "\n" +
                    "7.Logout");
            int memberInput = scanner.nextInt();
            try {
                switch (memberInput) {

                    case 1:
                        library.viewProducts();
                        System.out.println("Enter LibraryId:");
                        int bookId = scanner.nextInt();
                        library.borrowBook(userId, bookId);
                        break;

                    case 2:
                        library.viewAllMagazine();
                        System.out.println("Enter MagazineNumber:");
                        int magazineNUmber = scanner.nextInt();
                        library.borrowMagazine(userId, magazineNUmber);
                        break;

                    case 3:
                        library.viewBorrowedBook(userId);
                        System.out.println("Enter LibraryId:");
                        int returnBookId = scanner.nextInt();
                        library.returnBorrowedBook(userId, returnBookId);
                        break;

                    case 4:
                        library.viewBorrowedMagazine(userId);
                        System.out.println("Enter LibraryId:");
                        int returnMagazineNumber = scanner.nextInt();
                        library.returnBorrowedMagazine(userId, returnMagazineNumber);
                        break;

                    case 5:
                        library.viewBorrowedBook(userId);
                        break;

                    case 6:
                        library.viewBorrowedMagazine(userId);
                        break;

                    case 7:
                        isFinished = true;
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
