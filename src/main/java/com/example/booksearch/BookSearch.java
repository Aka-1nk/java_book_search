package com.example.booksearch;

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
        System.out.print("Enter book name: ");
        String searchTerm = scanner.nextLine().toLowerCase().trim();
        
        System.out.println("\nSearching for: " + searchTerm + "...\n");
        searchBooks(libraryFolder, "", searchTerm);
        scanner.close();
    }

    public static void searchBooks(File folder, String category, String searchTerm) {
        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                searchBooks(file, file.getName(), searchTerm);
            } else if (file.getName().toLowerCase().endsWith(".pdf") && 
                      file.getName().toLowerCase().contains(searchTerm)) {
                System.out.println("Found in [" + category + "]: " + file.getName());
            }
        }
    }
}
