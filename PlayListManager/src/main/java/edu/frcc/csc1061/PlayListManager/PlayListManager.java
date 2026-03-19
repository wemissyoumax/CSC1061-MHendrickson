package edu.frcc.csc1061.PlayListManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class PlayListManager {

	public static void main(String[] args) {
		MyDoubleLinkedList<Song> playlist = new MyDoubleLinkedList<>();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		String title = "";
		String artist = "";
		Song tempSong = null;
		
		while(running) {
			printMenu();
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				 scanner.nextLine();
				 System.out.print("Enter song title: ");
				 title = scanner.nextLine();
				 System.out.print("Enter artist: ");
				 artist = scanner.nextLine();
				 tempSong = new Song(title, artist);
				 playlist.add(tempSong);
				 break;
			case 2:
				scanner.nextLine();
				System.out.println("Enter song title to remove: ");
				String removeTitle = scanner.nextLine();
				System.out.println("Enter artist to remove: ");
				String removeArtist = scanner.nextLine();
				Song songToRemove = new Song(removeTitle, removeArtist);
				if(playlist.remove(songToRemove)) {
					System.out.println("Song removed.");
				} else {
					System.out.println("Song not found.");
				}
				break;
			case 3:
				System.out.println("Number of songs: " + playlist.count());
				break;
			case 4:
				if(playlist.isEmpty()) {
					System.out.println("Playlist is empty.");
				} else {
				for (Song song : playlist) {
					System.out.println(song);
					}
				}
				break;
			case 5:
				shuffle(playlist);
				System.out.println("Playlist shuffled.");
				break;
			case 6:
				if(playlist.isEmpty()) {
					System.out.println("Playlist is empty.");
				} else {
					playlist.reverse();
					System.out.println("Playlist is reversed.");
				}
				break;
			case 7:
				try {
					PrintWriter writer = new PrintWriter(new FileWriter("playlist.txt"));
					for(Song song : playlist) {
						writer.println(song);
					}
					writer.close();
					System.out.println("Playlist saved.");
				} catch (IOException e) {
					System.out.println("Error saving playlist.");
				}
				break;
			case 8:
			    try {
			        BufferedReader reader = new BufferedReader(new FileReader("playlist.txt"));
			        playlist.clear();
			        String line;
			        while ((line = reader.readLine()) != null) {
			            String[] parts = line.split(",");
			            title = parts[0];
			            artist = parts[1];
			            tempSong = new Song(title, artist);
			            playlist.add(tempSong);
			        }
			        reader.close();
			        System.out.println("Playlist loaded!");
			    } catch (IOException e) {
			        System.out.println("Error loading playlist.");
			    }
			    break;
			case 9:
				System.out.println("Goodbye!");
				running = false;
				break;
			default:
				System.out.println("Invalid number input, please try again.");
			}
		}
		scanner.close();
	}
	
	public static void printMenu() {
	    System.out.println("---Playlist Manager---");
	    System.out.println("1. Add a song");
	    System.out.println("2. Remove a song");
	    System.out.println("3. Count songs");
	    System.out.println("4. Play playlist");
	    System.out.println("5. Shuffle playlist");
	    System.out.println("6. Reverse playlist");
	    System.out.println("7. Save playlist");
	    System.out.println("8. Load playlist");
	    System.out.println("9. Quit");
	    System.out.print("Enter choice: ");
	}
	
	public static void shuffle(MyDoubleLinkedList<Song> playlist) {
		ArrayList<Song> songs = new ArrayList<>();
		for (Song song : playlist) {
			songs.add(song);
		}
		Collections.shuffle(songs);
		playlist.clear();
		for(Song song : songs) {
			playlist.add(song);
		}
	}
}
