package booksearch;

import java.io.File;
import java.util.Scanner;

public class BookSearch {
    public static void main(String[] args) {
        File libraryFolder = new File("D:\\Library");

        if (!libraryFolder.exists() || !libraryFolder.isDirectory()) {
            System.out.println("Library folder does not exist or is not a directory.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book name (or part of it): ");
        String searchTerm = scanner.nextLine().toLowerCase().trim();

        System.out.println("\nSearching for: " + searchTerm + "...\n");

        boolean found = searchBooks(libraryFolder, "", searchTerm);
        if (!found) {
            System.out.println("No matching book found.");
        }

        scanner.close();
    }

    public static boolean searchBooks(File folder, String category, String searchTerm) {
        File[] files = folder.listFiles();
        boolean found = false;

        if (files == null) return false;

        for (File file : files) {
            if (file.isDirectory()) {
                boolean result = searchBooks(file, file.getName(), searchTerm);
                if (result) found = true;
            } else if (file.getName().toLowerCase().endsWith(".pdf") && file.getName().toLowerCase().contains(searchTerm)) {
                System.out.println("Found in [" + category + "]: " + file.getName());
                found = true;
            }
        }

        return found;
    }
}
