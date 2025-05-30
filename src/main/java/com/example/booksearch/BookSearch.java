package booksearch;

import java.io.File;

public class BookSearch {
    public static void main(String[] args) {
        File libraryFolder = new File("D:\\Library");

        if (libraryFolder.exists() && libraryFolder.isDirectory()) {
            searchBooks(libraryFolder, "");
        } else {
            System.out.println("Library folder does not exist.");
        }
    }

    public static void searchBooks(File folder, String category) {
        File[] files = folder.listFiles();

        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                searchBooks(file, folder.getName()); // Go deeper with new category
            } else if (file.getName().toLowerCase().endsWith(".pdf")) {
                System.out.println("[" + category + "] " + file.getName());
            }
        }
    }
}
