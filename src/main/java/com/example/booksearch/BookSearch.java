package com.example.booksearch;

import java.io.File;

public class BookSearch {
    public static void main(String[] args) {
        File libraryFolder = new File("D:\\Library");
        
        if (!libraryFolder.exists() || !libraryFolder.isDirectory()) {
            System.out.println("Library folder does not exist or is not a directory.");
            return;
        }

        String searchTerm = "Stay Out of the Basement";     
        System.out.println("\nSearching for: " + searchTerm + "...\n");
        searchBooks(libraryFolder, "", searchTerm);
    }

    public static void searchBooks(File folder, String category, String searchTerm) {
        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                searchBooks(file, file.getName(), searchTerm);
            } else if (file.getName().toLowerCase().endsWith(".pdf") && 
                       file.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("Found in [" + category + "]: " + file.getName());
            }
        }
    }
}
