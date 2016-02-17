/*
 * Name:	Wong Kang Fei
 * Matric Number: A0138862W
 * */

import java.util.*;

public class FileManager {
	private static List<Folder> listOfFolders = new ArrayList<Folder>();
	private static String[] queries;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int QUERY_COUNT = sc.nextInt();
		queries = new String[QUERY_COUNT];

		sc.nextLine(); // consume line feed

		for( int i =0; i<QUERY_COUNT; i++){
			queries[i] = sc.nextLine();
		}

		for(int i = 0; i< QUERY_COUNT; i++){
			String[] queryParameters = queries[i].trim().split(" ");
			String queryName = queryParameters[0];

			switch(queryName){
				case "Createfile":
					createFile(queryParameters[1], Integer.parseInt(queryParameters[2]), queryParameters[3]);
					break;
				case "Createfolder":
					createFolder(queryParameters[1]);
					break;
				case "Deletefile":
					deleteFile(queryParameters[1]);
					break;
				case "Count":
					count(queryParameters[1]);
					break;
				case "Movefile":
					moveFile(queryParameters[1], queryParameters[2]);
					break;
				case "Findlargest":
					findLargest();
					break;
				default:
					break;
			}

		}
	}

	private static Folder findFolderByFolderName(String folderName){
		Folder targetFolder = null;
		for(Folder folder : listOfFolders){
			if(folderName.equals(folder.getName())){
				targetFolder = folder;
				break;
			}
		}

		return targetFolder;
	}

	private static File findFileByFileName(String fileName){
		File targetFile = null;
		for(Folder folder : listOfFolders){
			for(File file : folder.getListOfFiles()){
				if(fileName.equals(file.getName())){
					targetFile = file;
					break;
				}
			}
		}

		return targetFile;
	}

	private static void createFile(String fileName, int fileSize, String folderName){
		Folder folder = findFolderByFolderName(folderName);
		File file = new File(fileName, fileSize, folderName);

		folder.addFile(file);
	}

	private static void createFolder(String folderName){
		Folder folder = new Folder(folderName);
		listOfFolders.add(folder);
	}

	private static void deleteFile(String fileName){
		File file = findFileByFileName(fileName);
		Folder folder = findFolderByFolderName(file.getFolderName());

		folder.deleteFile(file);
	}

	private static void count(String folderName){
		Folder folder = findFolderByFolderName(folderName);
		System.out.println(folder.getFolderSize());
	}

	private static void moveFile(String fileName, String folderName){
		File file = findFileByFileName(fileName);
		Folder sourceFolder = findFolderByFolderName(file.getFolderName());
		Folder destinationFolder = findFolderByFolderName(folderName);

		destinationFolder.addFile(file);
		sourceFolder.deleteFile(file);
	}
	
	private static void findLargest(){
		Folder largestFolder = null;
		for(Folder folder : listOfFolders){
			if(largestFolder == null){
				largestFolder = folder;
			}else{
				largestFolder = folder.getFolderSize() > largestFolder.getFolderSize()? folder: largestFolder;
			}
		}

		System.out.println(largestFolder.getName());
	}
}

class File {
	//define the appropriate attributes and constructor
	
	private String name;
	private int size;
	private String folderName;

	public File(String name, int size, String folderName){
		this.name = name;
		this.size = size;
		this.folderName = folderName;
	}

	public void setFolderName(String folderName){
		this.folderName = folderName;
	}

	public String getName(){
		return name;
	}

	public int getSize(){
		return size;
	}

	public String getFolderName(){
		return folderName;
	}
}

class Folder {
	//define the appropriate attributes and constructor
	
	private String name;
	private List<File> listOfFiles = new ArrayList<File>();

	public Folder(String name){
		this.name = name;
	}

	public void addFile(File file){
		file.setFolderName(name);
		listOfFiles.add(file);
	}

	public void deleteFile(File file){
		listOfFiles.remove(file);
	}

	public int getFolderSize(){
		int folderSize = 0;

		for(File file: listOfFiles){
			folderSize = folderSize + file.getSize();
		}

		return folderSize;
	}

	public String getName(){
		return name;
	}

	public List<File> getListOfFiles(){
		return listOfFiles;
	}
}

